package com.ticmas.patricio.proyectofinal

import androidx.lifecycle.Observer
import com.ticmas.patricio.proyectofinal.viewmodel.CompareViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTest {
    @Mock
    private lateinit var mockObserver: Observer<Boolean>

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var viewModel: CompareViewModel
    @Test
    fun compararIguales() = testScope.runBlockingTest {
        val firstString = "Hola"
        val secondString = "Hola"

        viewModel.Resultado.observeForever(mockObserver)
        viewModel.comparar(firstString, secondString)
        verify(mockObserver).onChanged(true)
        viewModel.Resultado.removeObserver(mockObserver)
    }

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
        viewModel = CompareViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }


    @Test
        fun compararDiferentes() = testScope.runBlockingTest {
            val firstString = "Hola"
            val secondString = "Chau"

            viewModel.Resultado.observeForever(mockObserver)
            viewModel.comparar(firstString, secondString)
            verify(mockObserver).onChanged(false)
            viewModel.Resultado.removeObserver(mockObserver)
        }
    }


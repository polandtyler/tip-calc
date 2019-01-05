package com.example.tyler.tipcalculator.viewmodel

import com.example.tyler.tipcalculator.model.Calculator
import com.example.tyler.tipcalculator.model.TipCalculation
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class CalculatorViewModelTest {

    lateinit var viewModel: CalculatorViewModel

    @Mock
    lateinit var mockCalculator: Calculator


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = CalculatorViewModel(mockCalculator)
    }

    @Test
    fun testCalculateTip() {
        viewModel.inputCheckAmount = "10.00"
        viewModel.inputTipPercentage = "15"

        val stub = TipCalculation(checkAmount = 10.00, tipAmount = 1.5, grandTotal = 11.5)
        `when`(mockCalculator.calculateTip(10.00, 15)).thenReturn(stub)

        viewModel.calculateTip()

        assertEquals(stub, viewModel.tipCalculation)
    }

    @Test
    fun testCalculateTip_BadCheckInputAmount() {
        viewModel.inputCheckAmount = ""
        viewModel.inputTipPercentage = "15"

        val stub = TipCalculation(checkAmount = 10.00, tipAmount = 1.5, grandTotal = 11.5)
        `when`(mockCalculator.calculateTip(10.00, 15)).thenReturn(stub)

        viewModel.calculateTip()

        verify(mockCalculator, never()).calculateTip(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt())
    }

    @Test
    fun testCalculateTip_BadTipInputAmount() {
        viewModel.inputCheckAmount = "10.00"
        viewModel.inputTipPercentage = ""

        val stub = TipCalculation(checkAmount = 10.00, tipAmount = 1.5, grandTotal = 11.5)
        `when`(mockCalculator.calculateTip(10.00, 15)).thenReturn(stub)

        viewModel.calculateTip()

        verify(mockCalculator, never()).calculateTip(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt())
    }

}
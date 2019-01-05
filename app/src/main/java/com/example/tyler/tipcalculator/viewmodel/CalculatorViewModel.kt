package com.example.tyler.tipcalculator.viewmodel

import android.arch.lifecycle.ViewModel
import com.example.tyler.tipcalculator.model.Calculator
import com.example.tyler.tipcalculator.model.TipCalculation

class CalculatorViewModel(val calculator: Calculator = Calculator()) : ViewModel() {

    var inputCheckAmount = ""

    var inputTipPercentage = ""

    var tipCalculation = TipCalculation()

    fun calculateTip() {

        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPct = inputTipPercentage.toIntOrNull()

        if (checkAmount != null && tipPct != null) {
            tipCalculation = calculator.calculateTip(checkAmount, tipPct)
        }
    }
}[]
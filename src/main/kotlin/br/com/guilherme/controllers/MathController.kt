package br.com.guilherme.controllers

import br.com.guilherme.converters.NumberConverter.convertToDouble
import br.com.guilherme.converters.NumberConverter.isNumeric
import br.com.guilherme.exceptions.UnsupportedMathOperationException
import br.com.guilherme.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    private val math: SimpleMath = SimpleMath()

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double
    {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo))
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    fun sub(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double
    {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo))
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    fun mul(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double
    {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo))
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    fun div(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double
    {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.division(convertToDouble(numberOne), convertToDouble(numberTwo))
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    fun mean(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double
    {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.mean(convertToDouble(numberOne), convertToDouble(numberTwo))
    }

    @RequestMapping("/squareRoot/{number}")
    fun squareRoot(
        @PathVariable(value = "number") number: String?
    ): Double
    {
        if(!isNumeric(number)) throw UnsupportedMathOperationException("Please set a numeric value!")
        if (convertToDouble(number) <= 0) throw UnsupportedMathOperationException("Must be a positive number!")
        return math.squareRoot(convertToDouble(number))
    }





}
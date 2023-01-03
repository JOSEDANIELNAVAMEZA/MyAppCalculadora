package com.example.myapplicationcalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button0.setOnClickListener {numeroPresionado(digito: "0")}
        button1.setOnClickListener {numeroPresionado(digito: "1")}
        button2.setOnClickListener {numeroPresionado(digito: "2")}
        button3.setOnClickListener {numeroPresionado(digito: "3")}
        button4.setOnClickListener {numeroPresionado(digito: "4")}
        button5.setOnClickListener {numeroPresionado(digito: "5")}
        button6.setOnClickListener {numeroPresionado(digito: "6")}
        button7.setOnClickListener {numeroPresionado(digito: "7")}
        button8.setOnClickListener {numeroPresionado(digito: "8")}
        button9.setOnClickListener {numeroPresionado(digito: "9")}

        buttonMas.setOnClickListener{operacionPresionada(Sum)}
        buttonMenos.setOnClickListener{operacionPresionada(Res)}
        buttonMult.setOnClickListener{operacionPresionada(Mult)}
        buttonDiv.setOnClickListener{operacionPresionada(Div)}
        buttonPercent.setOnClickListener{operacionPresionada(Percent)}

        buttonBorrar.setOnClickListener{
            num1 = 0.0
            num2 = 0.0
            resultadoTextView.text = "0"
            operacion = No_Operacion
        }
        buttonIgual.setOnClickListener{
            var resultado = when(operacion){
                Sum -> num1 + num2
                Res -> num1 - num2
                Mult -> num1 * num2
                Div -> num1 / num2
                Percent -> num1 % num2
                else -> 0
            }
            resultadoTextView.text = resultado.toString()
        }
    }
    private fun numeroPresionado(digito: String){
        resultadoTextView.text = "${resultadoTextView.text}$digito"
        if(operacion == No_Operacion){
            num1 = resultadoTextView.text.toString().toDouble()
        }else{
            num2 = resultadoTextView.text.toString().toDouble()
        }
    }
    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion

        resultadoTextView.text = "0"
    }
    companion object{
        const val Sum = 1
        const val Res = 2
        const val Mult = 3
        const val Div = 4
        const val Percent = 5
        const val No_Operacion = 0
    }

}
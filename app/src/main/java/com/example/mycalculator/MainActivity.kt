package com.example.mycalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mycalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            validate("+")
        }
        binding.btnSubtract.setOnClickListener {
            validate("-")
        }
        binding.btnMultiply.setOnClickListener {
            validate("*")
        }
        binding.btnDivide.setOnClickListener {
            validate("/")
        }
    }

        fun validate(sign:String) {
            val num1 = binding.etNum1.text.toString()
            val num2 = binding.etNum2.text.toString()
            var inputError= false

            if (num1.isBlank()) {
                inputError= true
                binding.etNum1.error = "First number is required"
            }
            if(num2.isBlank()){
                inputError=true
                binding.etNum2.error="Second number is required"

        }
            if(!inputError){
                calculate(num1.toDouble(),num2.toDouble(),sign)
            }

        }
    fun calculate(num1:Double,num2:Double,sign: String){
        var result = 0.0
        when(sign){
            "+"-> result=(num1+num2)
            "-"-> result=(num1-num2)
            "*"-> result=(num1*num2)
            "/"->{
                if (num2==0.0){
                    binding.tvResults.text="cannot divide by zero"
                    return
                }
                result = num1/num2
            }

        }
        if (sign=="/"){
            binding.tvResults.text=result.toString()
        }
        else{
            binding.tvResults.text=if (num1%1==0.0&&num2%1==0.0) result.toInt().toString()else result.toString()
        }
    }


}
//        castViews()
//        btnAdd.setOnClickListener{
//          validate("+")
//        }
//        btnSubtract.setOnClickListener{
//
//           validate("-")
//
//        }
//
//        btnMultiply.setOnClickListener{
//         validate("*")
//        }
//
//        btnDivide.setOnClickListener{
//            validate("/")
//        }
//
//
//        }
//
//    fun castViews(){
//        etNum1 = findViewById(R.id.etNum1)
//        etNum2 = findViewById(R.id.etNum2)
//        btnAdd = findViewById(R.id.btnAdd)
//        btnSubtract = findViewById(R.id.btnSubtract)
//        btnMultiply = findViewById(R.id.btnMultiply)
//        btnDivide = findViewById(R.id.btnDivide)
//        tvResult =findViewById(R.id.tvResults)
//    }
//
////    fun validate(operation:String){
////        val num1 = etNum1.text.toString()
////        val num2 = etNum2.text.toString()
////        var error = false
////        if(num1.isBlank()){
////            error = true
////            etNum1.error = "Num 1 is required"
////
////        }
////        if(num2.isBlank())
////            error = true
////        etNum2.error = "Num 2 is required"
////
////        if(!error){
////            calculate(num1.toDouble(),num2.toDouble(),operation)
////        }
////    }
//
//    fun calculate(num1:Double, num2:Double, operation: String){
//
//        val num1 = etNum1.text.toString().toDouble()
//        val num2 = etNum2.text.toString().toDouble()
//        var results = 0.0
//        when(operation){
//            "+"->{
//                results = num1+num2
//            }
//
//            "-"->{
//                results = num1-num2
//            }
//
//            "*"->{
//                results = num1*num2
//            }
//
//            "/"->{
//                results = num1/num2
//            }
//        }
//        tvResult.text = results.toString()
//    }
//    }

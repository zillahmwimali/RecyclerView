package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.math.BigInteger

class MainActivity : AppCompatActivity() {
    lateinit var rvNumbers: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayNumbers(100)




    }
    fun displayNumbers(limit:Int):List<BigInteger>{
        rvNumbers=findViewById(R.id.rvNumbers)
        var start=BigInteger.ZERO
        var next=BigInteger.ONE
        var numbersList= MutableList<BigInteger>(limit,{BigInteger.ZERO})
        var numbersAdapter=RecyclerViewNumbers(numbersList)
        numbersList[0]=start
        numbersList[1]=next
        for (i in 1..limit){
            var sum=start+next
            start=next
            next=sum
            numbersList[i-1]=start
        }
        rvNumbers.layoutManager=LinearLayoutManager(baseContext)
        rvNumbers.adapter=numbersAdapter
        return numbersList
    }

}
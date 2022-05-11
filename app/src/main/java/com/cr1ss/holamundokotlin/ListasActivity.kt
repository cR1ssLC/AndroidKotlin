package com.cr1ss.holamundokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.cr1ss.holamundokotlin.databinding.ActivityContadorBinding
import com.cr1ss.holamundokotlin.databinding.ActivityListasBinding

class ListasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listas)
        val binding = ActivityListasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val frutas = mutableListOf<String>()

        for (i in 0..15){
            frutas.add("Fruta ${i+1}")
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,frutas)

        binding.lvFruits.adapter = adapter

        binding.btnAdd.setOnClickListener {
            frutas.add("Fruta ${frutas.size + 1}")
            adapter.notifyDataSetChanged()
        }
        binding.lvFruits.setOnItemClickListener { adapterView, view, i, l ->
            /*Toast.makeText(
                this@ListasActivity,
                "Click sobre ${frutas[i]}",
                Toast.LENGTH_SHORT
            ).show()*/

            frutas.removeAt(i)
            adapter.notifyDataSetChanged()
        }
    }


}
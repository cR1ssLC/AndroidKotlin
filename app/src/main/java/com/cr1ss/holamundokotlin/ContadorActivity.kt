package com.cr1ss.holamundokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cr1ss.holamundokotlin.databinding.ActivityContadorBinding

class ContadorActivity : AppCompatActivity() {

    private var name = ""
    private var saludo = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityContadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = savedInstanceState?.getString("NOMBRE") ?: ""
        saludo = savedInstanceState?.getString("SALUDO") ?: ""

        val nombre = intent.extras?.getString("NOMBRES")
        val ape = intent.extras?.getString("APELLIDO")

        if (nombre != null && ape != null) {
            Toast.makeText(this, "Datos recibidos $nombre - $ape", Toast.LENGTH_SHORT).show()
        }

        binding.tvCounter.text = saludo
        binding.etName.setText(name)

        binding.btnGenerate.setOnClickListener {
            name = binding.etName.text.toString()
            saludo = "Hola $name bienvenido, que tengas un buen dia"
            binding.tvCounter.text = saludo
        }

        binding.btnSend.setOnClickListener {
            name = binding.etName.text.toString()
            val intent = Intent()
            intent.putExtra("RESULTADO", name)
            setResult(1000, intent)
            finish()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("NOMBRE", name)
        outState.putString("SALUDO", saludo)
    }
}
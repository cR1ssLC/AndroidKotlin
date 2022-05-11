package com.cr1ss.holamundokotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.cr1ss.holamundokotlin.databinding.ActivityNavegacionBinding


class NavegacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavegacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == 1000) {
                val result = it.data?.extras?.getString("RESULTADO")

                if (result != null) {
                    binding.tvResult.text = result
                }
            }
        }


        binding.btnNavigate.setOnClickListener {
            val intent = Intent(this, ContadorActivity::class.java)
            intent.putExtra("NOMBRE", "Juan")
            intent.putExtra("APELLIDO", "Perez")

            result.launch(intent)
        }
    }
}
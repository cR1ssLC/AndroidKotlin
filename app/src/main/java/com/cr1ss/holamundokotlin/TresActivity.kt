package com.cr1ss.holamundokotlin

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cr1ss.holamundokotlin.databinding.ActivityTresBinding

class TresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendEmail.setOnClickListener {

            val email = binding.etEmail.text.toString().split(",")
            Toast.makeText(this, "$email", Toast.LENGTH_SHORT).show()
            val subject = binding.etSubject.text.toString()
            val content = binding.etContent.text.toString()

            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
            intent.putExtra(Intent.EXTRA_EMAIL, email.toTypedArray())
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, content)

            startActivity(intent)
        }


        binding.btnSearchWeb.setOnClickListener {
            val query = binding.etSearchQuery.text.toString()
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, query)
            startActivity(intent)
        }


        binding.btnMaps.setOnClickListener {
            val lat = binding.etLat.text.toString()
            val lng = binding.etLng.text.toString()


            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:$lat,$lng"))
            startActivity(intent)
        }

        binding.tarea.setOnClickListener {
            val webpage: Uri = Uri.parse("https://developer.android.com/")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

    }

}
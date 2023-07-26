package com.example.uruntakipotomasyonqr

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uruntakipotomasyonqr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object{
        const val RESULT = "RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val intent = Intent(applicationContext , ScanActivity::class.java)
            startActivity(intent)
        }

        val result = intent.getStringExtra(RESULT)

        if (result != null){
            if (result.contains("https://") || result.contains("http://")){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(result))
                startActivity(intent)
            }
            else{
                binding.textView.text = result.toString()
            }

        }

        println("ahmet deneme")



    }
}
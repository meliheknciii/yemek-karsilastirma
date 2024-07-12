package com.melihekinci.resimkarsilastirma

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.melihekinci.resimkarsilastirma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.buttonbitir.isEnabled = false
        var yemekdr = 0
        var icecekdr = 0
        var yemek : String = ""
        var icecek : String = ""

        fun kontrolbutondurum() {
            if (icecekdr == 1 && yemekdr == 1) {
                binding.buttonbitir.isEnabled = true
            } else {
                binding.buttonbitir.isEnabled = false
            }
        }
        binding.hamimage.setOnClickListener {
            binding.pizimage.isVisible = false
            binding.piztxt.isVisible = false
            yemek = "Hamburger"
            yemekdr = 1
            kontrolbutondurum()
        }
        binding.pizimage.setOnClickListener {
            binding.hamimage.isVisible = false
            binding.hamtxt.isVisible = false
            yemek = "Pizza"
            yemekdr = 1
           kontrolbutondurum()
        }
        binding.ayranimage.setOnClickListener {
            binding.kolaimage.isVisible = false
            binding.kolatxt.isVisible = false
            icecek = "Ayran"
            icecekdr = 1
            kontrolbutondurum()
        }
        binding.kolaimage.setOnClickListener {
            binding.ayranimage.isVisible = false
            binding.ayrantxt.isVisible = false
            icecek = "Kola"
            icecekdr = 1
            kontrolbutondurum()
        }

        binding.buttonbitir.setOnClickListener {
            binding.ayranimage.isVisible = false
            binding.kolaimage.isVisible = false
            binding.hamimage.isVisible = false
            binding.pizimage.isVisible = false
            binding.ayrantxt.isVisible = false
            binding.kolatxt.isVisible = false
            binding.hamtxt.isVisible = false
            binding.piztxt.isVisible = false
            binding.txtsonuc.isVisible = true
            binding.txtsonuc.text = "Seçiminiz : $yemek ve $icecek oldu. " +
                    "Ankete katılımınız için teşekkür ederiz"
        }
        binding.buttonsifirla.setOnClickListener {
            binding.ayranimage.isVisible = true
            binding.kolaimage.isVisible = true
            binding.hamimage.isVisible = true
            binding.pizimage.isVisible = true
            binding.ayrantxt.isVisible = true
            binding.kolatxt.isVisible = true
            binding.hamtxt.isVisible = true
            binding.piztxt.isVisible = true
            binding.txtsonuc.isVisible = false
            icecekdr = 0
            yemekdr = 0
            kontrolbutondurum()
        }
    }

}
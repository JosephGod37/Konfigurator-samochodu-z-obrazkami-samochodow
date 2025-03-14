package com.example.konfigurator_samochodu_z_obrazkami_samochodw

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val myImageView: ImageView = findViewById(R.id.my_ImageView)

        val images = listOf(
            R.drawable.hatchback,
            R.drawable.sedan,
            R.drawable.suv
        )

        val radioGroup = findViewById<RadioGroup>(R.id.car_radiogroup)
        var selectedCar = ""

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.hatchback_radiobutton -> {
                    myImageView.setImageResource(images[0])
                    selectedCar = "hatchback"
                }

                R.id.sedan_radiobutton -> {
                    myImageView.setImageResource(images[1])
                    selectedCar = "sedan"
                }

                R.id.suv_radiobutton -> {
                    myImageView.setImageResource(images[2])
                    selectedCar= "suv"
                }
            }
        }

        val myCheckBox_klima = findViewById<CheckBox>(R.id.klimatyzacja)
        var opcja1 = "Nie zaznaczone"
        var opcja2 = "Nie zaznaczone"

        myCheckBox_klima.setOnCheckedChangeListener { _, isChecked ->
            opcja1 = if (isChecked) "zaznaczono" else "Brak klimatyzacji"
        }
        val myCheckBox_siedzenia = findViewById<CheckBox>(R.id.skorzane_siedzenia)
        myCheckBox_siedzenia.setOnCheckedChangeListener { _, isChecked ->
            opcja2= if (isChecked) "skorzane siedzenia" else "Brak skorzanych siedzen"
        }

        val submitButton = findViewById<Button>(R.id.myButton)

        submitButton.setOnClickListener{
            val message = "Wybrane auto: $selectedCar\nKlimatyzacja: $opcja1\nSkorzane siedzenia: $opcja2\n"
            Toast.makeText(this@MainActivity, "Pobrano dane", Toast.LENGTH_LONG).show()
            Log.d("car",message)
        }
    }
}
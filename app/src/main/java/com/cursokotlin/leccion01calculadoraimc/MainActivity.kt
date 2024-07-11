package com.cursokotlin.leccion01calculadoraimc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cursokotlin.leccion01calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var vBind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        vBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vBind.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        vBind.calcular.setOnClickListener { calcularImc() }

    }//llave de cierre método onCreate

    fun calcularImc(){

        val peso = vBind.peso.text.toString().toFloat()
        val altura = vBind.altura.text.toString().toFloat()
        val resultado:Float = (peso / (altura*altura))
        val bajoP = "Bajo peso"
        val pesoN = "Peso normal"
        val sobreP = "Sobrepeso"
        val obesidad = "Obesidad"


        if(resultado < 18.5){
            vBind.imcCalculado.setText(resultado.toString())
            vBind.categoriaPeso.setText(bajoP)
        }
        if(resultado > 18.5 && resultado < 24.9){
            vBind.imcCalculado.setText(resultado.toString())
            vBind.categoriaPeso.setText(pesoN)
        }
        if(resultado > 24.9 && resultado < 29.9){
            vBind.imcCalculado.setText(resultado.toString())
            vBind.categoriaPeso.setText(sobreP)
        }
        if (resultado > 29.9){
            vBind.imcCalculado.setText(resultado.toString())
            vBind.categoriaPeso.setText(obesidad)
        }

    }

}

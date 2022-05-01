package br.com.danielamaral.theclickgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import br.com.danielamaral.theclickgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var contadorPontos = 0
    private var contadorCliques = 0
    private val pontosPorClique = 15
    private var contador = Contador()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btClique.setOnClickListener {
            contadorCliques+=1
            contadorPontos = contadorCliques * pontosPorClique

            binding.tvQuantidadeCLique.text = contadorCliques.toString()
            binding.tvQuantidadePontos.text = contadorPontos.toString()
        }

        Log.i("CICLO_DE_VIDA","onCreate")

        if(savedInstanceState != null){
            contadorPontos = savedInstanceState.getInt("contadorPontos")
            contadorCliques = savedInstanceState.getInt("contadorCliques")
            binding.tvQuantidadeCLique.text = contadorCliques.toString()
            binding.tvQuantidadePontos.text = contadorPontos.toString()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLO_DE_VIDA","onStart")
        contador.iniciar()
    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLO_DE_VIDA","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CICLO_DE_VIDA","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLO_DE_VIDA","onStop")
        contador.parar()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("CICLO_DE_VIDA","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLO_DE_VIDA","onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contadorPontos",contadorPontos)
        outState.putInt("contadorCliques",contadorCliques)
        Log.i("CICLO_DE_VIDA","onSaveInstanceState invocado")
    }
}
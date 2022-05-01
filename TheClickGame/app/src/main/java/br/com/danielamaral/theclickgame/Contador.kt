package br.com.danielamaral.theclickgame

import android.os.Handler
import android.util.Log

class Contador {

    private var segundos = 0

    /**
     * [Handler] é uma classe destinada a processar uma fila de mensagens (conhecida como [android.os.Message]s)
     * ou ações (conhecidas como [Runnable]s)
     */
    private var handler = Handler()
    private lateinit var runnable: Runnable

    fun iniciar() {
        // Cria a ação executável, que imprime um log e incrementa o contador de segundos
        runnable = Runnable {
            segundos++
            Log.i("CICLO_DE_VIDA", "Contagem em : $segundos")
            handler.postDelayed(runnable, 1000)
        }

        // Inicia o cronômetro
        handler.postDelayed(runnable, 1000)

    }

    fun parar() {
        // para o cronômetro
        handler.removeCallbacks(runnable)
    }
}
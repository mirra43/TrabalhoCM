package com.example.room

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class LocalizaUser : AppCompatActivity() {

    private lateinit var btnScan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localiza_user)
       startScan()

    }

    private fun startScan() {
        // Cria uma nova instância do IntentIntegrator
        val integrator = IntentIntegrator(this)

        // Define a mensagem exibida na tela de digitalização
        integrator.setPrompt("Aumentar volume para ativar o flash")

        // Habilita o som de "beep" quando um código é detectado
        integrator.setBeepEnabled(true)

        // Bloqueia a orientação da tela durante a digitalização
        integrator.setOrientationLocked(true)

        // Inicia a atividade de digitalização
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Obtém o resultado da atividade de digitalização
        val result: IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        // Verifica se o conteúdo do código foi obtido com sucesso
        if (result.contents != null) {
            // Exibe o conteúdo do código num diálogo de alerta
            showResultDialog(result.contents)
        }
    }

    private fun showResultDialog(contents: String) {
        val palavraDesejada = detectarPalavraDesejada(contents)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Localização")
        builder.setMessage(contents)
        builder.setPositiveButton("Voltar") { dialog, _ ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        if (palavraDesejada != null) {
            builder.setNegativeButton("Ver no mapa") { dialog, _ ->

                if (palavraDesejada in listOf("Bar", "Cantina", "GAC")) {
                    val intent = Intent(this, MapaEscola::class.java)
                    intent.putExtra("pisoSala", 1) // Substitua o valor '1' pelo valor desejado do piso
                    startActivity(intent)
                }

                if (palavraDesejada in listOf("reprografia")) {
                    val intent = Intent(this, MapaEscola::class.java)
                    intent.putExtra("pisoSala", 2) // Substitua o valor '1' pelo valor desejado do piso
                    startActivity(intent)
                }

                if (palavraDesejada in listOf("sala")) {
                    val intent = Intent(this, MapaEscola::class.java)
                    intent.putExtra("pisoSala", 3) // Substitua o valor '1' pelo valor desejado do piso
                    startActivity(intent)
                }
            }
        }

        builder.show()

        if (palavraDesejada != null) {
            Toast.makeText(this, "Palavra desejada encontrada: $palavraDesejada", Toast.LENGTH_LONG).show()
        }
    }

    private fun detectarPalavraDesejada(contents: String): String? {
        val padrao = "(Bar|Cantina|GAC|reprografia|sala)".toRegex(RegexOption.IGNORE_CASE)
        val match = padrao.find(contents)

        return match?.value
    }
}







package com.example.room

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class LocalizaUser : AppCompatActivity() {

    private lateinit var btnScan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localiza_user)

        // Inicializa o botão de digitalização
        btnScan = findViewById(R.id.btn_scan)
        btnScan.setOnClickListener {
            startScan()
        }
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
        AlertDialog.Builder(this)
            .setTitle("Localização")
            .setMessage(contents)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}







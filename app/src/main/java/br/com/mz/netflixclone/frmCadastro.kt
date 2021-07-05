package br.com.mz.netflixclone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.mz.netflixclone.databinding.ActivityFrmCadastroBinding

class frmCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFrmCadastroBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrmCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        Toolbar()

        binding.btnCadastrar.setOnClickListener {

            val email = binding.cadEmail.text.toString()
            val senha = binding.cadSenha.text.toString()
            val mensagem_erro = binding.mensagemErro

            if(email.isEmpty() || senha.isEmpty()){
                mensagem_erro.setText("Preencha todos os campos")

            }
        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun Toolbar(){
        val toolbar = binding.toolbarCadastro
        toolbar.setBackgroundColor(getColor(R.color.white))
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))
    }
}
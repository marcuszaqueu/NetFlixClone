package br.com.mz.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.mz.netflixclone.databinding.ActivityFrmLoginBinding
import com.google.firebase.auth.FirebaseAuth

class frmLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFrmLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrmLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.txtTelaCadastro.setOnClickListener{

            val intent = Intent(this,frmCadastro::class.java)
            startActivity(intent)
        }

        binding.btEntrar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()
            val mensagem_erro = binding.mErroLogin

            if(email.isEmpty() || senha.isEmpty()){
                mensagem_erro.setText("Preencha todos os Campos!")
            }else{
                AutenticarUsuario()

            }
        }
    }

    private fun AutenticarUsuario(){
        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()
        val mensagem_erro = binding.mErroLogin

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this,"Login efetuado com sucesso!",Toast.LENGTH_SHORT).show()
                LoginTelaFilmes()
            }
        }.addOnFailureListener {
            mensagem_erro.setText("Erro ao logar!")
        }
    }

    private fun LoginTelaFilmes(){
        val intent = Intent(this,ListaFilmes::class.java)
        startActivity(intent)
        finish()
    }

}
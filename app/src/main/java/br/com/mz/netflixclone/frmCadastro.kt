package br.com.mz.netflixclone

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.mz.netflixclone.databinding.ActivityFrmCadastroBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

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
            }else{
                mensagem_erro.setText("")
                CadastrarUsuario()
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun CadastrarUsuario(){
        val email = binding.cadEmail.text.toString()
        val senha = binding.cadSenha.text.toString()
        val mensagem_erro = binding.mensagemErro

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this,"Usuário cadastrado com sucesso!",Toast.LENGTH_SHORT).show()
                binding.cadEmail.setText("")
                binding.cadSenha.setText("")
                mensagem_erro.setText("")
            }
        }.addOnFailureListener {
            var erro = it

            when{
                erro is FirebaseAuthWeakPasswordException -> mensagem_erro.setText("A senha deve possuir no minimo \n6 carecteres!")
                erro is FirebaseAuthUserCollisionException -> mensagem_erro.setText("Este em-mail já existe!")
                erro is FirebaseAuthEmailException -> mensagem_erro.setText("Digite um e-mail válido!")
                erro is FirebaseNetworkException -> mensagem_erro.setText("Verifique sua conexão de internet!")
                else -> mensagem_erro.setText("Erro ao cadastrar usuário!")
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
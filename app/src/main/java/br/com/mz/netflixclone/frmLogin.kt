package br.com.mz.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mz.netflixclone.databinding.ActivityFrmLoginBinding

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
    }
}
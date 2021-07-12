package br.com.mz.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import br.com.mz.netflixclone.Adapter.FilmesAdapter
import br.com.mz.netflixclone.Model.addFilmes
import br.com.mz.netflixclone.databinding.ActivityListaFilmesBinding
import com.google.firebase.auth.FirebaseAuth

class ListaFilmes : AppCompatActivity() {

    private lateinit var binding: ActivityListaFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler_filmes = binding.recyclerFilmes
        recycler_filmes.adapter = FilmesAdapter(addFilmes())
        recycler_filmes.layoutManager = GridLayoutManager(applicationContext,2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal,menu)
        return true


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.logoff ->{
                FirebaseAuth.getInstance().signOut()
                VoltarLogin()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun VoltarLogin(){
        val intent = Intent(this,frmLogin::class.java)
        startActivity(intent)
        finish()
    }
}
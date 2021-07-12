package br.com.mz.netflixclone.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mz.netflixclone.Model.Filmes
import br.com.mz.netflixclone.databinding.ListaFilmesBinding

class FilmesAdapter (val filmes: MutableList<Filmes>): RecyclerView.Adapter<FilmesAdapter.FilmesVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesVH {
        val binding = ListaFilmesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return FilmesVH(binding)
    }

    override fun onBindViewHolder(holder: FilmesVH, position: Int) {
        with(holder){
            with(filmes[position]){
                binding.capafilme.setImageResource(capaFilme)
            }
        }
    }

    override fun getItemCount() = filmes.size

    inner class FilmesVH(val binding: ListaFilmesBinding): RecyclerView.ViewHolder(binding.root){

    }
}
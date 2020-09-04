package cl.desafiolatam.pruebasuperheroes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.pruebasuperheroes.model.room.data_class.SuperherosEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_heroe.view.*

class HeroesAdapter(private val heroesDataset: MutableList<SuperherosEntity>) :RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val lista = LayoutInflater.from(parent.context).inflate(R.layout.item_heroe, parent, false)
        return ViewHolder(lista)
    }
        val heroSelected = MutableLiveData<SuperherosEntity>()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = heroesDataset.get(position).name

        Picasso.get().load(heroesDataset.get(position).images.md).into(holder.image)
        holder.itemView.setOnClickListener{
            Log.d("Adapterclick", "${heroesDataset.get(position)}")
            heroSelected.value = heroesDataset.get(position)

        }
    }

    override fun getItemCount(): Int {
        return heroesDataset.size
    }

    fun updateAdapter(listaHeroes: ArrayList<SuperherosEntity>) {
        heroesDataset.clear()
        heroesDataset.addAll(listaHeroes)
        notifyDataSetChanged()

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image :ImageView = itemView.img_heroe
        var name: TextView = itemView.heroe_name
    }


}
package cl.desafiolatam.pruebasuperheroes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import cl.desafiolatam.pruebasuperheroes.model.room.RetrofitClient
import cl.desafiolatam.pruebasuperheroes.model.room.data_class.SuperherosEntity
import cl.desafiolatam.pruebasuperheroes.view_model.HeroesViewModel
import kotlinx.android.synthetic.main.fragmento_heroe.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A fragment representing a list of Items.
 */
class HeroeFragment : Fragment() {
   // private val viewModel: HeroesViewModel by activityViewModels()
    private  lateinit var heroesAdapter : HeroesAdapter
    val heroesViewModel : HeroesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragmento_heroe, container, false)

        heroesAdapter = HeroesAdapter(mutableListOf())

        //creamos el viewModel Observer
        heroesViewModel.getAll.observe(viewLifecycleOwner, Observer {
            heroesAdapter.updateAdapter(it as ArrayList<SuperherosEntity>)

        })
        heroesAdapter.heroSelected.observe(viewLifecycleOwner, Observer {
            heroesViewModel.select(it)

            Log.d("fragment", "+++++++++++++++${it.id} +++++++++++++++")
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.container_fragment,
                Fragment_Hero_Details.newInstance(), "DETALLE"
            ).addToBackStack(" ").commit()
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("onViewCreated", "respuesta creada")
        val recyclerview = recyclerViewLista
        recyclerview.adapter = heroesAdapter


    }
}




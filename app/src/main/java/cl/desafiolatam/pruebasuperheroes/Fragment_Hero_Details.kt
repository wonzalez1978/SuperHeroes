package cl.desafiolatam.pruebasuperheroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.desafiolatam.pruebasuperheroes.view_model.HeroesViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_hero__details.*
import kotlinx.android.synthetic.main.item_heroe.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_hero_Details.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_Hero_Details : Fragment() {

    val heroesViewModel : HeroesViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_hero__details, container, false)

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = Fragment_Hero_Details()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        heroesViewModel.selected.observe(viewLifecycleOwner, Observer {
            tv_details_hero.text = it.name
            Picasso.get().load(it.images.md).into(iv_imagen)
        })
    }
}
package br.com.danielamaral.jogo_do_milhao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import br.com.danielamaral.jogo_do_milhao.databinding.FragmentHomeBinding
import br.com.danielamaral.show_do_milhao.Database
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.btJogar.setOnClickListener {
            val nome = binding.etNomeJogador.text.toString()

            if (!"".equals(nome)) {
                binding.btJogar.isEnabled=true
                Database.jogador.nome=nome
                view?.findNavController()?.navigate(R.id.action_homeFragment_to_jogoFragment)
            } else {

                val snackbar = Snackbar.make(binding.root, "Nome inválido", Snackbar.LENGTH_SHORT)
                snackbar.show()
            }
        }

        return binding.root
    }

}
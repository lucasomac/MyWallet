package br.com.lucolimac.mywallet.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.lucolimac.mywallet.R
import br.com.lucolimac.mywallet.`interface`.ContractDetail
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class DetailFragment : Fragment() {
    private var msg = ""
    private lateinit var contrato: ContractDetail
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_detail, container, false)
        view.bt_home_entrada.setOnClickListener {
            view.callOnClick()
            textDetails.text = msg
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContractDetail) {
            contrato = context
        }
        arguments?.getString("key")?.let {
            msg = it
        }
    }

    companion object {
        fun newInstance(msg: String) = DetailFragment().apply {
            arguments = Bundle().apply {
                putString("key", msg)
            }
        }
    }
}
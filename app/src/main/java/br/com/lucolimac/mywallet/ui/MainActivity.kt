package br.com.lucolimac.mywallet.ui

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.lucolimac.mywallet.R
import br.com.lucolimac.mywallet.interfaces.ContractDetail
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContractDetail {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        toolbar_main.setNavigationOnClickListener { finish() }

        val fragHome = HomeFragment.newInstance()
        val fragSaida = SaidaFragment.newInstance()
        val fragEntrada = EntradaFragment.newInstance()

        trocaCorHome(R.color.colordetail)
        inflateFragment(fragHome)

        btn_home.setOnClickListener {
            trocaCorEntradas(R.color.white)
            trocaCorGastos(R.color.white)
            trocaCorHome(R.color.colordetail)
            inflateFragment(fragHome)
        }

        btn_saida.setOnClickListener {
            trocaCorEntradas(R.color.white)
            trocaCorGastos(R.color.colordetail)
            trocaCorHome(R.color.white)
            inflateFragment(fragSaida)
        }

        btn_entrada.setOnClickListener {
            trocaCorEntradas(R.color.colordetail)
            trocaCorGastos(R.color.white)
            trocaCorHome(R.color.white)
            inflateFragment(fragEntrada)
        }
    }

    //    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.toolbar_main, menu)
//        return true
//    }
    fun inflateFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentMenu, fragment)
//                addToBackStack(null)
            commit()
        }
    }

    fun trocaCorGastos(color: Int) {
        btn_saida.setTextColor(getColor(color))
        linha_saida.setBackgroundTintList(ColorStateList.valueOf(getColor(color)))
    }

    fun trocaCorHome(color: Int) {
        btn_home.setTextColor(getColor(color))
        linha_home.setBackgroundTintList(ColorStateList.valueOf(getColor(color)))
    }

    fun trocaCorEntradas(color: Int) {
        btn_entrada.setTextColor(getColor(color))
        linha_entrada.setBackgroundTintList(ColorStateList.valueOf(getColor(color)))
    }

    override fun callFragDetails() {
        val fragment = DetailFragment.newInstance("Lucas Macedo")
        Toast.makeText(this, "Era para ter inflado essa gota serana", Toast.LENGTH_LONG).show()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentDetailsLayout, fragment)
//            addToBackStack(null)
            commit()
        }

    }
}
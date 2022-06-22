package arlorenzzo.dev.br.orgs_kotlin.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog

import androidx.recyclerview.widget.LinearLayoutManager
import arlorenzzo.dev.br.orgs_kotlin.ui.adapter.ListaProdutosAdapter
import arlorenzzo.dev.br.orgs_kotlin.dao.ProdutosDao
import arlorenzzo.dev.br.orgs_kotlin.databinding.ActivityMainBinding
import arlorenzzo.dev.br.orgs_kotlin.model.Produto
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configuraRecycler(binding)
        configuraFab(binding)

    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }


    private fun configuraFab(binding: ActivityMainBinding) {
        binding.fabPrincipal.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        })
    }

    private fun configuraRecycler(binding: ActivityMainBinding) {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

}
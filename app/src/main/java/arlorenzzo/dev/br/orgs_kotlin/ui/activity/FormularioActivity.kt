package arlorenzzo.dev.br.orgs_kotlin.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import arlorenzzo.dev.br.orgs_kotlin.dao.ProdutosDao
import arlorenzzo.dev.br.orgs_kotlin.databinding.ActivityFormularioBinding
import arlorenzzo.dev.br.orgs_kotlin.extensions.loadingImage
import arlorenzzo.dev.br.orgs_kotlin.model.Produto
import arlorenzzo.dev.br.orgs_kotlin.ui.dialog.FormularioImagemDialog
import java.math.BigDecimal

class FormularioActivity : AppCompatActivity() {

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Cadastrar Produto"
        configuraBotaoSalvar(binding)
        binding.imageViewFormualrio.setOnClickListener(View.OnClickListener {
            FormularioImagemDialog(this).showDialog{imagem ->
                url = imagem
                binding.imageViewFormualrio.loadingImage(url)
            }
        })
    }

    private fun configuraBotaoSalvar(binding: ActivityFormularioBinding) {
        val dao = ProdutosDao()
        binding.btnSalvar.setOnClickListener(View.OnClickListener {
            val produtoCriado = criaProduto(binding)
            dao.adiciona(produtoCriado)
            finish()
        })
    }

    private fun criaProduto(binding: ActivityFormularioBinding): Produto {
        val campoDescricao = binding.edtDescricao.text.toString()
        val campoProdutos = binding.edtProdutos.text.toString()
        val campoValor = binding.edtValor.text.toString()
        val valorValidado = if (campoValor.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(campoValor)
        }

        return Produto(
            descricao = campoDescricao,
            produtos = campoProdutos,
            valor = valorValidado,
            imagem = url
        )
    }
}
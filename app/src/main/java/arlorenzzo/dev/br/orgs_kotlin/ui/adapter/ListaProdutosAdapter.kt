package arlorenzzo.dev.br.orgs_kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import arlorenzzo.dev.br.orgs_kotlin.R
import arlorenzzo.dev.br.orgs_kotlin.extensions.loadingImage
import arlorenzzo.dev.br.orgs_kotlin.model.Produto
import coil.load
import java.text.NumberFormat
import java.util.*


class ListaProdutosAdapter(
        private val context: Context,
        produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.MyViewHolder>() {

    private val produtos = produtos.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewCriada = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(viewCriada)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun vincula(produto: Produto) {
            val descricao = itemView.findViewById<TextView>(R.id.textDescricao)
            descricao.text = produto.descricao
            val produtos = itemView.findViewById<TextView>(R.id.textProdutos)
            produtos.text = produto.produtos
            val valor = itemView.findViewById<TextView>(R.id.textValor)
            val formatador: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            val valorEmReal: String = formatador.format(produto.valor)
            valor.text = valorEmReal
            val imagemFruta = itemView.findViewById<ImageView>(R.id.imgFruta)

            val visibilidade = if(produto.imagem != null){
                View.VISIBLE
            } else {
                View.GONE
            }

            imagemFruta.visibility = visibilidade

            imagemFruta.loadingImage(produto.imagem)
        }
    }

}

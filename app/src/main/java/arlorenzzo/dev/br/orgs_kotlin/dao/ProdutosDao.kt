package arlorenzzo.dev.br.orgs_kotlin.dao

import arlorenzzo.dev.br.orgs_kotlin.model.Produto

class ProdutosDao {

    fun adiciona(produto: Produto){
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }

}
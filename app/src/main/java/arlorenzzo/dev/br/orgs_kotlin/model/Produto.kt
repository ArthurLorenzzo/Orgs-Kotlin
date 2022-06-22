package arlorenzzo.dev.br.orgs_kotlin.model

import java.math.BigDecimal

data  class Produto (
    val descricao: String,
    val produtos: String,
    val valor: BigDecimal,
    val imagem: String? = null
    )

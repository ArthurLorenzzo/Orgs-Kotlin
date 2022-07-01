package arlorenzzo.dev.br.orgs_kotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data  class Produto (
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val descricao: String,
    val produtos: String,
    val valor: BigDecimal,
    val imagem: String? = null
    )

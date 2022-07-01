package arlorenzzo.dev.br.orgs_kotlin.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import arlorenzzo.dev.br.orgs_kotlin.model.Produto

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produto")
    fun buscaTodos(): List<Produto>

    @Insert
    fun salva(vararg produto: Produto)

}
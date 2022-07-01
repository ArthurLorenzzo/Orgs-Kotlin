package arlorenzzo.dev.br.orgs_kotlin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import arlorenzzo.dev.br.orgs_kotlin.database.converter.Converter
import arlorenzzo.dev.br.orgs_kotlin.database.dao.ProdutoDao
import arlorenzzo.dev.br.orgs_kotlin.model.Produto

@Database(entities = [Produto::class], version = 1)
@TypeConverters(Converter::class)
abstract class OrgsDatabase: RoomDatabase() {
    abstract fun produtoDao(): ProdutoDao
}
package arlorenzzo.dev.br.orgs_kotlin.database.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converter {

    @TypeConverter
    fun deDouble(valor: Double?) : BigDecimal {
        return valor?.let { BigDecimal(valor.toString()) } ?: BigDecimal.ZERO
    }

    @TypeConverter
    fun BigDecimalToDouble(valor: BigDecimal?) : Double? {
        return valor?.let { valor.toDouble() }
    }

}
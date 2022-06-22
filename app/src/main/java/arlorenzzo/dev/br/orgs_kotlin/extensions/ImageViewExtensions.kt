package arlorenzzo.dev.br.orgs_kotlin.extensions

import android.widget.ImageView
import arlorenzzo.dev.br.orgs_kotlin.R
import coil.load

fun ImageView.loadingImage(url: String? = null){
    load(url){
        fallback(R.drawable.erro)
        error(R.drawable.erro)
        placeholder(R.drawable.placeholder)
    }
}
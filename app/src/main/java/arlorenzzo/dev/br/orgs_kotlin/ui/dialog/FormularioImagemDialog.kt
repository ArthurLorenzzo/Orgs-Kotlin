package arlorenzzo.dev.br.orgs_kotlin.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import arlorenzzo.dev.br.orgs_kotlin.databinding.FormularioImagemBinding
import arlorenzzo.dev.br.orgs_kotlin.extensions.loadingImage

class FormularioImagemDialog(private val context: Context) {

    fun showDialog(urlPadrao: String? = null, whenImageLoaded: (imagem: String) -> Unit) {

        FormularioImagemBinding
            .inflate(LayoutInflater.from(context)).apply {
                urlPadrao?.let{
                    imagemDialog.loadingImage(it)
                    edtUrl.setText(it)
                }

                btnCarregar.setOnClickListener(View.OnClickListener {
                    val url = edtUrl.text.toString()
                    imagemDialog.loadingImage(url)  //metodo criado no extension
                })

                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Confirmar"){_, _ ->
                        val url = edtUrl.text.toString()
                        whenImageLoaded(url)
                    }
                    .setNegativeButton("Cancelar"){_, _ ->}
                    .show()

            }
    }
}
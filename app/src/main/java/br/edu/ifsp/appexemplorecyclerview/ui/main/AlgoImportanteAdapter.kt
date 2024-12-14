package br.edu.ifsp.appexemplorecyclerview.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.appexemplorecyclerview.R
import br.edu.ifsp.appexemplorecyclerview.data.AlgoImportante

class AlgoImportanteAdapter(
    private var dataset: List<AlgoImportante>,
    private val clickListener: DeleteItemClickListener
) :
    RecyclerView.Adapter<AlgoImportanteAdapter.ViewHolder>() {

    fun updateDataset(newDataset: List<AlgoImportante>) {
        this.dataset = newDataset
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // recupera referencia do item (algo importante) para ser inserido no recyclerview
        val itemImportante = dataset[position]

        // popular a view com os dados de algo importante usando binding
        //holder.binding.textviewTitle.setText("Elemento: ${itemImportante.id}")
        //holder.binding.textviewSequence.setText("#${itemImportante.id}")
        //holder.binding.imageDelete.setOnClickListener{clickListener.onDeleteItemClick(position)}

        // popular a view com os dados de algo importante usando findViewById
        holder.title.setText("Elemento: ${itemImportante.id}")
        holder.sequence.setText("#${itemImportante.id}")
        holder.delete.setOnClickListener { clickListener.onDeleteItemClick(position) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Usando viewBinding
        //val binding: ItemRecyclerviewBinding = ItemRecyclerviewBinding.bind(view)

        // Usando findViewById
        val title: TextView = view.findViewById(R.id.textview_title)
        val sequence: TextView = view.findViewById(R.id.textview_sequence)
        val delete: ImageView = view.findViewById(R.id.image_delete)
    }
}
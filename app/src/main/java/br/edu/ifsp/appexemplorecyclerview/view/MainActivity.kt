package br.edu.ifsp.appexemplorecyclerview.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.appexemplorecyclerview.R
import br.edu.ifsp.appexemplorecyclerview.databinding.ActivityMainBinding
import br.edu.ifsp.appexemplorecyclerview.model.AlgoImportante
import br.edu.ifsp.appexemplorecyclerview.view.adapter.AdapterPersonalizado
import br.edu.ifsp.appexemplorecyclerview.view.interfaces.DeleteItemClickListener

class MainActivity : AppCompatActivity(), OnClickListener, DeleteItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val datasource = ArrayList<AlgoImportante>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configListener()
        configRecyclerView()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_novo_item) {
            datasource.add(AlgoImportante())
            val adapter = binding.reciclerView.adapter
            adapter?.notifyDataSetChanged()
        }
    }

    override fun onDeleteItemClick(position: Int) {
        datasource.removeAt(position)
        val adapter = binding.reciclerView.adapter
        adapter?.notifyDataSetChanged()
    }

    private fun configListener() {
        binding.buttonNovoItem.setOnClickListener(this)
    }

    private fun configRecyclerView() {
        val adapter = AdapterPersonalizado(datasource, this)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.reciclerView.layoutManager = layoutManager
        binding.reciclerView.adapter = adapter
    }
}
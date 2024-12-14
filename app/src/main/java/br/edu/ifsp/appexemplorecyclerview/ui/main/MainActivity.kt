package br.edu.ifsp.appexemplorecyclerview.ui.main

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.appexemplorecyclerview.R
import br.edu.ifsp.appexemplorecyclerview.databinding.ActivityMainBinding
import br.edu.ifsp.appexemplorecyclerview.data.AlgoImportante

class MainActivity : AppCompatActivity(), OnClickListener, DeleteItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: AlgoImportanteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        configListener()
        configRecyclerView()
        configObservers()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_novo_item) {
            viewModel.insertAlgo(AlgoImportante())
        }
    }

    override fun onDeleteItemClick(position: Int) {
        viewModel.deleteAlgo(position);
    }

    private fun configListener() {
        binding.buttonNovoItem.setOnClickListener(this)
    }

    private fun configRecyclerView() {
        adapter = AlgoImportanteAdapter(mutableListOf(), this)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.reciclerView.layoutManager = layoutManager
        binding.reciclerView.adapter = adapter
    }

    private fun configObservers() {
        viewModel.inserted.observe(this, Observer {
            Toast.makeText(this, "Algo Importante inserido", Toast.LENGTH_SHORT).show()
        })

        viewModel.datasource.observe(this, Observer {
            adapter.updateDataset(it)
        })
    }
}
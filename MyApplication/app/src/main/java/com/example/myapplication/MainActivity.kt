package com.example.myapplication

import Models.VersionModel
import adapters.MonAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : MonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // important de mettre root
        title ="VERSIONS"

        setupRecycler()
        fillRecycler()
    }


    private fun setupRecycler() {
        adapter = MonAdapter() // Créer l'adapteur
        binding.rvMonAdapter.adapter = adapter // Assigner l'adapteur au RecyclerView
        binding.rvMonAdapter.setHasFixedSize(true) // Option pour améliorer les performances
        binding.rvMonAdapter.addItemDecoration( // Ajouter un séparateur entre chaque élément
            DividerItemDecoration(
                binding.rvMonAdapter.context, DividerItemDecoration.VERTICAL
            )
        )
    }
    private fun fillRecycler() {
        val items: MutableList<VersionModel> = mutableListOf()
        items.add(VersionModel("Android 1.1","Petit Four"))
        items.add(VersionModel("Android 1.5","Cupcake"))
        items.add(VersionModel("Android 2.0","Eclair"))
        items.add(VersionModel("Android 3.0","Honeycamb"))
        items.add(VersionModel("Android 4.0","Iu cream sandwich"))
        items.add(VersionModel("Android 5.0","Lollipop"))

        items.add(VersionModel("Android 1.1","Petit Four"))
        items.add(VersionModel("Android 1.5","Cupcake"))
        items.add(VersionModel("Android 2.0","Eclair"))
        items.add(VersionModel("Android 3.0","Honeycamb"))
        items.add(VersionModel("Android 4.0","Iu cream sandwich"))
        items.add(VersionModel("Android 5.0","Lollipop"))
        adapter.submitList(items) // Pour changer le contenu de la liste, utiliser submitList de l'adapteur
    }
}
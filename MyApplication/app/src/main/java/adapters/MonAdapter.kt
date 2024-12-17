package adapters

import Models.VersionModel
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DonneesActivity
import com.example.myapplication.databinding.MonItemBinding

class MonAdapter() : ListAdapter<VersionModel, MonAdapter.MonItemViewHolder>(MonItemDiffCallback) {

    // binding nous permet d'accéder à tout le champs de notre layout mon_item.xml
    inner class MonItemViewHolder(private val binding: MonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: VersionModel) {
            binding.tvElement.text = item.versionAndroid // On affiche l'élément dans le TextView

            binding.tvElementNom.text = item.nom

            binding.sujet.setOnClickListener{
                val intent : Intent = Intent(binding.root.context, DonneesActivity::class.java)
                intent.putExtra("Android", item.versionAndroid)
                intent.putExtra("Nom", item.nom)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonItemViewHolder {
        val binding: MonItemBinding = MonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MonItemViewHolder, position: Int) {
        val item: VersionModel = getItem(position)
        holder.bind(item)
    }

}

object MonItemDiffCallback : DiffUtil.ItemCallback<VersionModel>() {
    override fun areItemsTheSame(oldItem: VersionModel, newItem: VersionModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: VersionModel, newItem: VersionModel): Boolean {
        return oldItem.nom == newItem.nom &&
                oldItem.versionAndroid == newItem.versionAndroid

    }
}
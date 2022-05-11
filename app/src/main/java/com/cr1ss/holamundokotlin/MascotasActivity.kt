package com.cr1ss.holamundokotlin

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cr1ss.holamundokotlin.databinding.ActivityMascotasBinding
import com.cr1ss.holamundokotlin.databinding.ItemPetBinding

class MascotasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMascotasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = RVAdapter(object : PetActions {
            override fun onClick(mascotas: Mascotas, position: Int) {
                Toast.makeText(this@MascotasActivity, "$mascotas", Toast.LENGTH_SHORT).show()
            }

            override fun onDoubleClick(position: Int) {
                Toast.makeText(this@MascotasActivity, "Eliminando!!!", Toast.LENGTH_SHORT).show()
            }
        })
        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvPets.adapter = adapter
        binding.rvPets.layoutManager = linearLayoutManager

        adapter.loadData(Mascotas.fakeMascotas)

    }
}


class RVAdapter(val petActions: PetActions) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    private val mascotas = mutableListOf<Mascotas>()

    fun loadData(items: List<Mascotas>) {
        mascotas.addAll(items)
        notifyItemRangeInserted(0, mascotas.size)
    }

    fun removePet(position: Int) {
        
        mascotas.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int = mascotas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = ItemPetBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val m = mascotas[position]

        holder.binding.tvNamePet.text = m.name
        holder.binding.tvAgePet.text = "${m.age} anios"
        holder.binding.ivPet.setImageResource(m.photo)

        if (m.age >= 5.0) {
            holder.binding.root.setBackgroundColor(Color.parseColor("#018786"))
        } else {
            holder.binding.root.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        holder.binding.root.setOnClickListener {
            petActions.onClick(m, position)
        }

        holder.binding.root.setOnLongClickListener {
            petActions.onDoubleClick(position)
            removePet(position)
            true
        }
    }

    inner class ViewHolder(val binding: ItemPetBinding) : RecyclerView.ViewHolder(binding.root)
}

interface PetActions {
    fun onClick(mascotas: Mascotas, position: Int)
    fun onDoubleClick(position: Int)
}

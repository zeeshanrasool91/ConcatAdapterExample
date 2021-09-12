package com.example.concatadapterexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.concatadapterexample.databinding.AnimalsRowBinding
import com.example.concatadapterexample.databinding.BreedsRowBinding

class AnimalAdapter(private val context: Context) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var animalList = mutableListOf<Animal>()

    companion object {
        const val ITEMS_PER_PAGE = 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemWidth: Int = parent.width / ITEMS_PER_PAGE
        val binding = AnimalsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        val layoutParams: ViewGroup.LayoutParams = binding.root.layoutParams
        layoutParams.width = itemWidth
        binding.root.layoutParams = layoutParams
        return AnimalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (animalList.size > 0) animalList.size else 0
    }

    fun setAnimals(animalList:MutableList<Animal>){
        this.animalList = animalList
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Animal {
        return animalList[position]
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val animalObj = animalList[position]
        when (holder) {
            is AnimalViewHolder -> holder.bind(animalObj,position)
            else -> throw IllegalArgumentException("No viewholder to show this data, did you forgot to add it to the onBindViewHolder?")
        }
    }

    inner class AnimalViewHolder(val binding: AnimalsRowBinding) : BaseViewHolder<Animal>(binding.root){
        override fun bind(item: Animal,position:Int) {
            Glide.with(context).load(item.image).centerCrop().placeholder(R.drawable.ic_launcher_foreground).into(binding.animalImage)
            binding.animalName.text = item.name
        }
    }
}
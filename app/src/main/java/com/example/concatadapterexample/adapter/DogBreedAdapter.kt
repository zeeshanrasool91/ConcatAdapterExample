package com.example.concatadapterexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapterexample.model.Breed
import com.example.concatadapterexample.base.holder.BaseViewHolder
import com.example.concatadapterexample.databinding.BreedsRowBinding

class DogBreedAdapter(
    val context: Context,
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var dogBreedList = mutableListOf<Breed>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val binding = BreedsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DogBreedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dogBreedList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is DogBreedViewHolder -> holder.bind(
                dogBreedList[position],
                position
            )
            else -> throw IllegalArgumentException("No viewholder to show this data, did you forgot to add it to the onBindViewHolder?")
        }
    }

    fun setBreeds(dogBreedList: MutableList<Breed>) {
        this.dogBreedList = dogBreedList
        notifyDataSetChanged()
    }

    inner class DogBreedViewHolder(private val binding: BreedsRowBinding) : BaseViewHolder<Breed>(binding.root) {
        override fun bind(item: Breed, position: Int) {
            binding.breedName.text = item.name
        }
    }
}
package com.example.concatadapterexample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapterexample.databinding.AnimalConcatRowBinding

class BaseGridConcatAdapter(private val context: Context, private val animalAdapter: AnimalAdapter, private val spanCount:Int) :
    RecyclerView.Adapter<BaseConcatHolder<*>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val binding = AnimalConcatRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.rvAnimalConcat.layoutManager = GridLayoutManager(context, spanCount)
        return ConcatViewHolder(binding)
    }

    override fun getItemCount(): Int  = 1

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(animalAdapter)
            else -> throw IllegalArgumentException("No viewholder to show this data, did you forgot to add it to the onBindViewHolder?")
        }
    }

    inner class ConcatViewHolder(private val binding: AnimalConcatRowBinding): BaseConcatHolder<AnimalAdapter>(binding.root){
        override fun bind(adapter: AnimalAdapter) {
            binding.rvAnimalConcat.adapter = adapter
        }
    }
}
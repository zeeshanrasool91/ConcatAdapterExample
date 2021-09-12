package com.example.concatadapterexample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.example.concatadapterexample.databinding.AnimalsRowBinding


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

    inner class AnimalViewHolder(private val binding: AnimalsRowBinding) : BaseViewHolder<Animal>(binding.root){
        override fun bind(item: Animal,position:Int) {

            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_baseline_error)
                .priority(Priority.HIGH)
            GlideImageLoader(
                binding.animalImage,
                binding.progressBar
            ).load(item.image, options)
            binding.animalName.text = item.name
        }
    }
}
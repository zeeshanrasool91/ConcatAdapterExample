package com.example.concatadapterexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.concatadapterexample.adapter.AnimalAdapter
import com.example.concatadapterexample.adapter.DogBreedAdapter
import com.example.concatadapterexample.base.adapter.BaseGridConcatAdapter
import com.example.concatadapterexample.databinding.ActivityMainBinding
import com.example.concatadapterexample.model.Animal
import com.example.concatadapterexample.model.Breed

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val animalAdapter = AnimalAdapter(this)
        animalAdapter.setAnimals(
            mutableListOf(
                Animal("Dog", "https://img.wallpapersafari.com/desktop/728/410/19/58/2zT4A9.jpg"),
                Animal("Cat", "https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832__480.jpg"),
                Animal("Hamster", "https://img.wallpapersafari.com/phone/1440/2560/12/25/bXKvL1.jpg"),
                Animal("Shark", "https://img.wallpapersafari.com/phone/1440/2560/19/54/VBsPI0.jpg")
            )
        )


        val breedAdapter = DogBreedAdapter(this)
        breedAdapter.setBreeds(
            mutableListOf(
                Breed("Bulldog"),
                Breed("Beagle"),
                Breed("Bulldog"),
                Breed("Golden retriever")
            )
        )
        //Lets create now the ConcatAdapter with these adapters ready
        //val concatAdapter = ConcatAdapter(animalAdapter, breedAdapter)
        val concatAdapter = ConcatAdapter(BaseGridConcatAdapter(this,animalAdapter,2),breedAdapter)
        binding.animalRv.layoutManager = LinearLayoutManager(this)
        binding.animalRv.adapter = concatAdapter
    }
}
package com.example.concatadapterexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.concatadapterexample.databinding.ActivityMainBinding

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
                Animal("Dog", "DogImgUrl"),
                Animal("Cat", "CatImgUrl"),
                Animal("Hamster", "HamsterImgUrl"),
                Animal("Shark", "SharkImgUrl")
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
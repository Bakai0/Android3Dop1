package com.example.android3dop1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.android3dop1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupObserve()
        setupListener()
    }

    private fun setupObserve() {
        viewModel.num.observe(this) {
            binding.textView.text = it.toString()
        }
    }

    private fun setupListener() {
        binding.btnPlus.setOnClickListener {
            viewModel.plus()
            if (viewModel.meaning >= -10 || viewModel.meaning <= 10) {
                binding.textView.setTextColor(resources.getColor(R.color.purple_700))
            } else {
                binding.textView.setTextColor(resources.getColor(R.color.teal_700))
            }
        }
        binding.btnMinus.setOnClickListener {
            viewModel.minus()
            if (viewModel.meaning <= -10 || viewModel.meaning >= 10) {
                binding.textView.setTextColor(resources.getColor(R.color.purple_700))
            } else {
                binding.textView.setTextColor(resources.getColor(R.color.teal_700))
            }
        }
    }
}
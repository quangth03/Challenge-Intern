package com.example.currencyconverter
import CurrencyViewModel
import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.currencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: CurrencyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currencies = listOf(
            "USD", "EUR", "GBP", "JPY", "VND", "AUD", "CAD", "CHF", "CNY", "INR", "MXN", "NZD", "SGD", "BRL", "ZAR"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerFromCurrency.adapter = adapter
        binding.spinnerToCurrency.adapter = adapter

        binding.convertButton.setOnClickListener {
            val amount = binding.inputAmount.text.toString().toDoubleOrNull()
            if (amount == null || amount <= 0) {
                binding.resultText.text = "Please enter a valid amount"
                return@setOnClickListener
            }
            val from = binding.spinnerFromCurrency.selectedItem.toString()
            val to = binding.spinnerToCurrency.selectedItem.toString()
            if (from == to) {
                binding.resultText.text = "Please select different currencies"
                return@setOnClickListener
            }

            viewModel.convertCurrency(amount, from, to)
        }

        viewModel.conversionResult.observe(this, Observer { result ->
            val fadeIn = ObjectAnimator.ofFloat(binding.resultText, "alpha", 0f, 1f)
            fadeIn.duration = 500
            fadeIn.start()

            binding.resultText.text = "Result: $result"
        })
    }
}

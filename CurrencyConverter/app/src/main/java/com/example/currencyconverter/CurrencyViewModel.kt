import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyViewModel : ViewModel() {
    private val _conversionResult = MutableLiveData<String>()
    val conversionResult: LiveData<String> get() = _conversionResult

    fun convertCurrency(amount: Double, from: String, to: String) {
        RetrofitInstance.api.getExchangeRates(base = from, symbols = to)
            .enqueue(object : Callback<ExchangeRateResponse> {
                override fun onResponse(
                    call: Call<ExchangeRateResponse>,
                    response: Response<ExchangeRateResponse>
                ) {
                    val rate = response.body()?.rates?.get(to)
                    if (rate != null) {
                        val result = amount * rate
                        _conversionResult.value = "%.2f".format(result)
                    } else {
                        _conversionResult.value = "Conversion failed. Rate not available."
                    }
                }

                override fun onFailure(call: Call<ExchangeRateResponse>, t: Throwable) {
                    _conversionResult.value = "Error: Please check your internet connection and try again."
                }

            })
    }

}

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApiService {
    @GET("latest")
    fun getExchangeRates(
        @Query("base") base: String,
        @Query("symbols") symbols: String
    ): Call<ExchangeRateResponse>
}

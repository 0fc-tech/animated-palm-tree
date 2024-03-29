package com.example.mod7retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel : ViewModel() {
    private val _weatherState = MutableStateFlow<HourlyData?>(null)
    val weatherState = _weatherState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            RetrofitClient.weatherApiService.getWeatherData(
                latitude = 47.224152,
                longitude = -1.6322685,
                current = "temperature_2m,wind_speed_10m",
                hourly = "temperature_2m"
            ).enqueue(object : Callback<WeatherResponse> {
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {
                    if(response.isSuccessful)
                        _weatherState.value = response.body()?.hourly
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}






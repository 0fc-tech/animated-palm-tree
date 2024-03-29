package com.example.mod7retrofit

data class WeatherResponse(
    val hourly: HourlyData
)
data class HourlyData(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val wind_speed_10m: List<Double>
)

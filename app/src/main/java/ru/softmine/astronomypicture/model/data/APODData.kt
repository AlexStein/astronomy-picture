package ru.softmine.astronomypicture.model.data

sealed class APODData {
    data class Success(val serverResponseData: APODResponseData) : APODData()
    data class Error(val error: Throwable) : APODData()
    data class Loading(val progress: Int?) : APODData()
}

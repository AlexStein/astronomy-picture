package ru.softmine.astronomypicture.ui.picture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.softmine.astronomypicture.App
import ru.softmine.astronomypicture.BuildConfig
import ru.softmine.astronomypicture.R
import ru.softmine.astronomypicture.model.api.APODRetrofitImpl
import ru.softmine.astronomypicture.model.data.APODData
import ru.softmine.astronomypicture.model.data.APODResponseData

class PictureOfTheDayViewModel(
    private val liveDataForViewToObserve: MutableLiveData<APODData> = MutableLiveData(),
    private val retrofitImpl: APODRetrofitImpl = APODRetrofitImpl()
) : ViewModel() {

    fun getData(): LiveData<APODData> {
        sendServerRequest()
        return liveDataForViewToObserve
    }

    private fun sendServerRequest() {
        liveDataForViewToObserve.value = APODData.Loading(null)
        val apiKey: String = BuildConfig.NASA_API_KEY

        if (apiKey.isBlank()) {
            APODData.Error(Throwable(App.instance.getString(R.string.no_api_key_error)))
        } else {
            retrofitImpl.getRetrofitImpl().getPictureOfTheDay(apiKey).enqueue(object :
                Callback<APODResponseData> {
                override fun onResponse(
                    call: Call<APODResponseData>,
                    response: Response<APODResponseData>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        liveDataForViewToObserve.value =
                            APODData.Success(response.body()!!)
                    } else {
                        val message = response.message()
                        if (message.isNullOrEmpty()) {
                            liveDataForViewToObserve.value =
                                APODData.Error(Throwable(App.instance.getString(R.string.undefined_error_message)))
                        } else {
                            liveDataForViewToObserve.value =
                                APODData.Error(Throwable(message))
                        }
                    }
                }

                override fun onFailure(call: Call<APODResponseData>, t: Throwable) {
                    liveDataForViewToObserve.value = APODData.Error(t)
                }
            })
        }
    }
}

package developer.tonmoy.simpleblog.view.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import developer.tonmoy.simpleblog.data.remote.repository.AppRepository
import kotlinx.coroutines.Dispatchers

class BlogDetailsViewModel(private val appRepository: AppRepository) : ViewModel() {
    val progressbarVisibility: MutableLiveData<Int> = MutableLiveData<Int>(View.GONE)

    private fun showLoader()  = progressbarVisibility.postValue(View.VISIBLE)
    private fun hideLoader()  = progressbarVisibility.postValue(View.GONE)
}
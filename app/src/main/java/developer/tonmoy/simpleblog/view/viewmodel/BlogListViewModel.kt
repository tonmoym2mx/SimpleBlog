package developer.tonmoy.simpleblog.view.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import developer.tonmoy.simpleblog.data.remote.repository.AppRepository
import kotlinx.coroutines.Dispatchers

class BlogListViewModel(private val appRepository: AppRepository) : ViewModel() {
    val progressbarVisibility: MutableLiveData<Int> = MutableLiveData<Int>(View.GONE)
    fun listOfBlog() = liveData(Dispatchers.IO){
        showLoader()
        emit(appRepository.listOfBlog())
        hideLoader()
    }
    private fun showLoader()  = progressbarVisibility.postValue(View.VISIBLE)
    private fun hideLoader()  = progressbarVisibility.postValue(View.GONE)
}
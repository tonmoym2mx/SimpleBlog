package developer.tonmoy.simpleblog.di


import developer.tonmoy.simpleblog.data.local.db.DatabaseBuilder
import developer.tonmoy.simpleblog.data.local.db.DatabaseHelper
import developer.tonmoy.simpleblog.data.local.db.blog.BlogDatabaseDao
import developer.tonmoy.simpleblog.data.local.db.blog.BlogDatabaseDatabase
import developer.tonmoy.simpleblog.data.remote.api.AppApiHelper
import developer.tonmoy.simpleblog.data.remote.network.RetrofitBuilder

import developer.tonmoy.simpleblog.data.remote.repository.AppRepository
import developer.tonmoy.simpleblog.view.viewmodel.BlogDetailsViewModel
import developer.tonmoy.simpleblog.view.viewmodel.BlogListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    factory { RetrofitBuilder.API_SERVICE}
    factory { AppApiHelper(get()) }

    factory { DatabaseBuilder(BlogDatabaseDatabase::class.java, BlogDatabaseDao::class,get()) }
    factory { DatabaseHelper(get()) }
    factory { AppRepository(get(),get()) }

}
val viewModelModule = module {
    viewModel { BlogListViewModel(get()) }
    viewModel { BlogDetailsViewModel(get()) }
}
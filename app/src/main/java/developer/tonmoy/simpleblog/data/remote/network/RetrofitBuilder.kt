package developer.tonmoy.simpleblog.data.remote.network

import developer.tonmoy.simpleblog.config.BASE_URL
import developer.tonmoy.simpleblog.data.remote.api.AppApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitBuilder{
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
    }
    private fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.connectTimeout(1, TimeUnit.MINUTES)
        okhttpClientBuilder.readTimeout(1, TimeUnit.MINUTES)
        okhttpClientBuilder.writeTimeout(1, TimeUnit.MINUTES)
        okhttpClientBuilder.addInterceptor(loggingInterceptor)
        return okhttpClientBuilder.build()
    }
    val API_SERVICE: AppApiService = getRetrofit().create(AppApiService::class.java)
}


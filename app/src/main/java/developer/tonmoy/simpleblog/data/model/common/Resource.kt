package developer.tonmoy.simpleblog.data.model.common

enum class Status {
    SUCCESS,
    ERROR
}
data class Resource<out T>(var status: Status, val data: T?, var message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = Status.SUCCESS, data = data, message = null)
        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = Status.ERROR, data = data, message = message)
    }
    inline fun isSuccess(func:(T?)->Unit){
        if(status == Status.SUCCESS){
            func.invoke(data)
        }
    }
    inline fun isFailed(func:(message:String?)->Unit){
        if(status == Status.ERROR){
            func.invoke(message)
        }
    }

}
inline fun<reified T> Resource<T>?.isSuccess() = this?.status == Status.SUCCESS
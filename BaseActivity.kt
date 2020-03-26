abstract class BaseActivity : AppCompatActivity(), CoroutineScope { 

// created coroutines would be bound to this scope, in other words, this activity
private val job by lazy { Job() } // one of the elements from coroutineContext
// It is indexed set of instances. It can have Coroutine scope, Dispatcher and Exception handler elements.
    override val coroutineContext: CoroutineContext // set of elements, job,default thread, global exception handler
        get() = job + Dispatchers.Main + handler
private val handler = CoroutineExceptionHandler { coroutineContext, throwable -> // global exception handler
        Log.e("Exception", ":$throwable")
    }
override fun onDestroy() {
        super.onDestroy()
        job.cancel() // once you cancel the job, all coroutines will be cancelled too.
    }
}

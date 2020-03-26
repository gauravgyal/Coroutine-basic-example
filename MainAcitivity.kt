class MainActivity : BaseActivity() {
  private fun asyncWait() {
        this.launch(Dispatch.Default) { // launch,Async are coroutine builder and creates new coroutine
            val a = async { getNumber1() }  // which thread this is running into?
            val b = async { getNumber2() }
            val c = a.await() + b.await() // await can only be applied on async coroutine, this would wait for the result
            log("sum is $c")
        }
    }
private suspend fun getNumber1(): Int {
        delay(1000) //suspend function which delays execution
        return 1
    }
private suspend fun getNumber2(): Int {
        delay(2000)
        return 2
    }
}
output:
sum is 3

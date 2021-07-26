import java.sql.DriverManager.println

/**
 * @author polarisChen
 * @create  2021/7/15 10:10 下午
 *
 */

fun main() {
    var t=tt()
    var thr= Thread(t)
    thr.start()


}
class tt :Runnable{
    /**
     * When an object implementing interface `Runnable` is used
     * to create a thread, starting the thread causes the object's
     * `run` method to be called in that separately executing
     * thread.
     *
     *
     * The general contract of the method `run` is that it may
     * take any action whatsoever.
     *
     * @see java.lang.Thread.run
     */
    override fun run() {
        println("Hello World!")
    }

}
fun s(){

}
fun sum(a: Int, b: Int): Int {   // Int 参数，返回值 Int
    return a + b
}
package framework.proxy


import net.sf.cglib.proxy.MethodInterceptor
import net.sf.cglib.proxy.MethodProxy
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

class Proxy<out T>(val block: () -> T) : MethodInterceptor {
    override fun intercept(o: Any?, method: Method?, args: Array<out Any>?, methodProxy: MethodProxy?): Any? {
        val result: Any?
        try {
            result = method!!.invoke(block.invoke(), *args!!)
        } catch (e: InvocationTargetException) {
            throw e.cause!!
        }
        if (result != null) {
            return result
        } else {
            return null
        }
    }
}
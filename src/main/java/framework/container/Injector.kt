package framework.container

import container.get
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : Any> di(): ReadOnlyProperty<Any, T> = object : ReadOnlyProperty<Any, T> {
    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return get(T::class.java) as T
    }
}


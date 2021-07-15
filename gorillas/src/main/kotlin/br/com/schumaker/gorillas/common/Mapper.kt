package br.com.schumaker.gorillas.common

import java.util.function.BiConsumer

/**
 * @author Hudson Schumaker
 */
interface Mapper<S, T> {

    fun from(source: S): T {
        throw UnsupportedOperationException("from(S) is not implemented.")
    }

    fun from(sources: Iterable<S>): List<T> {
        return from(sources) { s, t ->  }
    }

    fun from(sources: Iterable<S>, postProcessor: BiConsumer<S, T>): List<T> {
        val targetList: ArrayList<T> = ArrayList()
        for (entity in sources) {
            try {
                val dto = from(entity)
                postProcessor.accept(entity, dto)
                targetList.add(dto)
            } catch (ex: RuntimeException) { }
        }
        return targetList
    }
}

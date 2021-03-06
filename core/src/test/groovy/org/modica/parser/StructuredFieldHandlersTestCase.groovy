package org.modica.parser;

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Test

class StructuredFieldHandlersTestCase {

    @Test
    void chainNoArgs() {
        try {
            StructuredFieldHandlers.chain([])
            fail()
        } catch(IllegalArgumentException e) { }
    }

    @Test
    void chain() {
        def api = StructuredFieldHandler.methods.inject([:]) {api, method ->
            api[method.name] = [null] * method.genericParameterTypes.length
            return api
        }

        (1..3).each {n ->
            def handlers = (1..n).collect{ mock(StructuredFieldHandler) }
            def sut = StructuredFieldHandlers.chain(handlers)
            api.each {method, parameters ->
                sut."$method"(*parameters)
            }
            handlers.each { handler ->
                api.each {method, parameters ->
                    verify(handler)."$method"(*parameters.collect { anyObject() })
                }
            }
        }
    }

    @Test
    void chainNested() {
        def handlers = (1..2).collect{ mock(StructuredFieldHandler) }
        def sut = StructuredFieldHandlers.chain(mock(StructuredFieldHandler),
            StructuredFieldHandlers.chain(handlers))
        sut.handle(null)
        handlers.each { handler ->
            verify(handler).handle(anyObject())
        }
    }
}

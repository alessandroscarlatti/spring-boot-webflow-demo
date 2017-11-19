package com.scarlatti

import org.junit.Test
import spock.lang.Specification

/**
 * Created by pc on 10/25/2017.
 */
class SpockTest extends Specification {
    @Test
    "test that a spock test will run"() {
        when:
            println "testing spock"
        then:
            notThrown(Exception)
    }
}

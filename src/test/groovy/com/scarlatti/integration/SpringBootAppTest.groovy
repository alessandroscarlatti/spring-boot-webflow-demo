package com.scarlatti.integration

import com.scarlatti.SpringBootApp
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [SpringBootApp])
class SpringBootAppTest extends Specification {

	@Test
	"context can load"() {
		when:
			println "loaded context."
		then:
			notThrown(Exception)
	}

}

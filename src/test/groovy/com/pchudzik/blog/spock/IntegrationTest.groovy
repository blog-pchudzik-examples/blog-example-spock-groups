package com.pchudzik.blog.spock

import com.pchudzik.blog.spock.groups.Integration
import org.junit.experimental.categories.Category
import spock.lang.Specification

@Category(Integration)
class IntegrationTest extends Specification {
	def "integration test example"() {
		given:
		println "running integration test"

		expect:
		true
	}
}

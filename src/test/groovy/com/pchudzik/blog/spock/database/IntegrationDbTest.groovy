package com.pchudzik.blog.spock.database

import com.pchudzik.blog.spock.groups.Integration
import org.junit.experimental.categories.Category
import spock.lang.Specification

@Category(Integration)
class IntegrationDbTest extends Specification {
	def "integration test in database package"() {
		given:
		println "running integration test from database package"

		expect:
		true
	}
}
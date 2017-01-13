package com.pchudzik.blog.spock

import spock.lang.Specification


class NotAnnotatedTest extends Specification {
	def "should execute not categorized test"() {
		given:
		println "running not categorized test"

		expect:
		true
	}
}

package com.pchudzik.blog.spock.database

class RepositoryTest extends DatabaseSpecification {
	def "inherited test"() {
		given:
		println "running inherited test"

		expect: true
	}

}

package com.pchudzik.blog.spock

class RepositorySpecification extends DatabaseSpecification {
	def "inherited test"() {
		given:
		println "running inherited test"

		expect: true
	}

}

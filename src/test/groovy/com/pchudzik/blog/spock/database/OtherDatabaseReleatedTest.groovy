package com.pchudzik.blog.spock.database

import spock.lang.Specification


class OtherDatabaseReleatedTest extends Specification {
	def "uncategorized test from db package"() {
		given:
		println "running uncategorized test from database package"

		expect:
		true
	}
}
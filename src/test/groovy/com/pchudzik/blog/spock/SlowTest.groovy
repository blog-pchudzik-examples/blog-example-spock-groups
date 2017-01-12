package com.pchudzik.blog.spock

import com.pchudzik.blog.spock.groups.Database
import com.pchudzik.blog.spock.groups.Slow
import org.junit.experimental.categories.Category
import spock.lang.Specification

@Category(Slow)
class SlowTest extends Specification {
	def "slow test example"() {
		given:
		println "running slow test"

		expect:
		true
	}

	@Category(Database)
	def "mixed test example"() {
		given:
		println "database test example"

		expect:
		true
	}
}

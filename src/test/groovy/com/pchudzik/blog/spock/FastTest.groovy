package com.pchudzik.blog.spock

import com.pchudzik.blog.spock.groups.Fast
import org.junit.experimental.categories.Category
import spock.lang.Specification

@Category(Fast)
class FastTest extends Specification {
	def "fast test example"() {
		given:
		println "running fast test"
		
		expect:
		true
	}
}

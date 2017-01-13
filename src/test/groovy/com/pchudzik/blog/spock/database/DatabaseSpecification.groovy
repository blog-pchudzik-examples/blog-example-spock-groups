package com.pchudzik.blog.spock.database

import com.pchudzik.blog.spock.groups.Database
import org.junit.experimental.categories.Category
import spock.lang.Specification

@Category(Database)
abstract class DatabaseSpecification extends Specification {
	def setup() {
		println("database setup")
	}
}

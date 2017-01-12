import spock.lang.Specification
import spock.lang.Unroll

import static java.util.Arrays.asList
import static TestGroups.*

class TestGroupsTest extends Specification {
	def "should include all categories when no groups defined"() {
		given:
		final groups = new TestGroups("")

		expect:
		asList(groups.includedGroups()) == [
				FAST_CATEGORY_CLASS,
				SLOW_CATEGORY_CLASS,
				DATABASE_CATEGORY_CLASS,
				IT_CATEGORY_CLASS
		]
	}

	@Unroll
	def "should exclude nothing when no exclusion defined"() {
		given:
		final groups = new TestGroups(groupsString)

		expect:
		groups.excludedGroups().length == 0

		where:
		groupsString << ["", null]
	}

	def "comma separated values should be resolved to categories"() {
		given:
		final groups = new TestGroups("$FAST_CATEGORY,$SLOW_CATEGORY")

		expect:
		asList(groups.includedGroups()) == [
				FAST_CATEGORY_CLASS,
				SLOW_CATEGORY_CLASS
		]

		and:
		groups.excludedGroups().length == 0
	}

	def "group names prefixed with minus should be in excluded category"() {
		given:
		final groups = new TestGroups("-$FAST_CATEGORY,-$SLOW_CATEGORY")

		expect:
		asList(groups.excludedGroups()) == [
				FAST_CATEGORY_CLASS,
				SLOW_CATEGORY_CLASS
		]

		and:
		asList(groups.includedGroups()) == [
				FAST_CATEGORY_CLASS,
				SLOW_CATEGORY_CLASS,
				DATABASE_CATEGORY_CLASS,
				IT_CATEGORY_CLASS
		]
	}

	def "included and excluded categories should be resolved"() {
		given:
		final groups = new TestGroups("-$FAST_CATEGORY,$SLOW_CATEGORY")

		expect:
		asList(groups.excludedGroups()) == [FAST_CATEGORY_CLASS]

		and:
		asList(groups.includedGroups()) == [SLOW_CATEGORY_CLASS]
	}
}

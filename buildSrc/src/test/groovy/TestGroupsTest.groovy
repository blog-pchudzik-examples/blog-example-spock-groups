import spock.lang.Specification
import spock.lang.Unroll

import static java.util.Arrays.asList
import static TestGroups.*

class TestGroupsTest extends Specification {
	@Unroll
	def "should include all and exclude nothing when no categories defined"() {
		given:
		final groups = new TestGroups(groupsString)

		expect:
		groups.includedGroups().length == 0
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
		groups.includedGroups().length == 0
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

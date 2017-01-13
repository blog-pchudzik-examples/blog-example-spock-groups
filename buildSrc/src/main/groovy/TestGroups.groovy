class TestGroups {
	protected static final FAST_CATEGORY = "fast"
	protected static final FAST_CATEGORY_CLASS = "com.pchudzik.blog.spock.groups.Fast"

	protected static final SLOW_CATEGORY_CLASS = "com.pchudzik.blog.spock.groups.Slow"
	protected static final SLOW_CATEGORY = "slow"

	protected static final String DATABASE_CATEGORY_CLASS = "com.pchudzik.blog.spock.groups.Database"
	protected static final String DATABASE_CATEGORY = "db"

	protected static final String IT_CATEGORY_CLASS = "com.pchudzik.blog.spock.groups.Integration"
	protected static final String IT_CATEGORY = "it"

	private static final groupDefinitions = [
			(FAST_CATEGORY)    : FAST_CATEGORY_CLASS,
			(SLOW_CATEGORY)    : SLOW_CATEGORY_CLASS,
			(DATABASE_CATEGORY): DATABASE_CATEGORY_CLASS,
			(IT_CATEGORY)      : IT_CATEGORY_CLASS
	]

	private final Collection<String> groupsParam

	TestGroups(String groupsString) {
		groupsParam = (groupsString ?: "")
				.split(",")
				.toList()
				.findAll { !it.isAllWhitespace() }
	}

	String[] excludedGroups() {
		resolveGroups(excludes())
	}

	String[] includedGroups() {
		resolveGroups(includes())
	}

	private String[] resolveGroups(Collection<String> groups) {
		groups
				.collect { groupDefinitions[it] }
				.toArray(new String[groups.size()])
	}

	private Collection<String> includes() {
		groupsParam.findAll { !isExcluded(it) }
	}

	private Collection<String> excludes() {
		groupsParam
				.findAll { isExcluded(it) }
				.collect { it.replaceFirst("-", "") }
	}

	private boolean isExcluded(String group) {
		group.startsWith("-")
	}
}

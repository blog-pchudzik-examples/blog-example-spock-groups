class TestGroups {
	public static final FAST_CATEGORY = "fast"
	public static final FAST_CATEGORY_CLASS = "com.pchudzik.blog.spock.groups.Fast"

	public static final SLOW_CATEGORY_CLASS = "com.pchudzik.blog.spock.groups.Slow"
	public static final SLOW_CATEGORY = "slow"

	public static final String DATABASE_CATEGORY_CLASS = "com.pchudzik.blog.spock.groups.Database"
	public static final String DATABASE_CATEGORY = "db"

	public static final String IT_CATEGORY_CLASS = "com.pchudzik.blog.spock.groups.Integration"
	public static final String IT_CATEGORY = "it"

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
		final includedGroups = groupsParam.findAll { !it.startsWith("-") }
		return includedGroups.isEmpty() ? groupDefinitions.keySet() : includedGroups
	}

	private Collection<String> excludes() {
		final excludedGroups = groupsParam
				.findAll { it.startsWith("-") }
				.collect { it.replaceFirst("-", "") }
		return excludedGroups
	}
}

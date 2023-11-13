

# RoleRulesInner

A rule is a list of resources and the list of allowed verbs for those resources.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**resources** | **List&lt;String&gt;** | List of resources. The elements of this list are Javascript ES6 Regex patterns. When a request for a protected resource is received these regexs are used to match against the resource URL.  |  |
|**verbs** | **List&lt;String&gt;** | List of allowed verbs.   For now the only supported verb is &#x60;all&#x60; which allows all actions on the resource.  |  |






# StartTransformation202Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | ID of the new project output. |  [optional] |
|**name** | **String** | Name of the project output. |  [optional] |
|**description** | **String** | Description of the project output. |  [optional] |
|**timestamp** | **OffsetDateTime** |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the transformation. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| TRANSFORMING | &quot;transforming&quot; |
| DONE | &quot;done&quot; |
| ERROR | &quot;error&quot; |




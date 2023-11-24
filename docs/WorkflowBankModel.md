

# WorkflowBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the workflow. |  [optional] |
|**customerGuid** | **String** | The associated customer&#39;s identifier. |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of workflow. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The state of the workflow. |  [optional] |
|**failureCode** | **String** | The failure code for failed workflows. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| PLAID | &quot;plaid&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| COMPLETED | &quot;completed&quot; |
| FAILED | &quot;failed&quot; |




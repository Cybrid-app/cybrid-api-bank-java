

# CustomerBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the customer. |  [optional] |
|**bankGuid** | **String** | Auto-generated unique identifier for the customer&#39;s bank. |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The customer&#39;s type. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The customer&#39;s state. |  [optional] |
|**name** | [**CustomerNameBankModel**](CustomerNameBankModel.md) |  |  [optional] |
|**address** | [**CustomerAddressBankModel**](CustomerAddressBankModel.md) |  |  [optional] |
|**dateOfBirth** | **LocalDate** | The customer&#39;s DOB. Only available for GET operations when &#39;include_pii&#39; is set. |  [optional] |
|**phoneNumber** | **String** | The customer&#39;s phone number. Only available for GET operations when &#39;include_pii&#39; is set. |  [optional] |
|**emailAddress** | **String** | The customer&#39;s email address. Only available for GET operations when &#39;include_pii&#39; is set. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the customer. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| INDIVIDUAL | &quot;individual&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| UNVERIFIED | &quot;unverified&quot; |
| VERIFIED | &quot;verified&quot; |
| REJECTED | &quot;rejected&quot; |
| FROZEN | &quot;frozen&quot; |




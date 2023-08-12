

# CustomerBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the customer. |  [optional] |
|**bankGuid** | **String** | Auto-generated unique identifier for the customer&#39;s bank. |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The customer&#39;s type. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the customer was created at. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The customer&#39;s state. |  [optional] |
|**name** | [**CustomerNameBankModel**](CustomerNameBankModel.md) |  |  [optional] |
|**address** | [**CustomerAddressBankModel**](CustomerAddressBankModel.md) |  |  [optional] |
|**dateOfBirth** | **LocalDate** | The customer&#39;s date of birth. |  [optional] |
|**phoneNumber** | **String** | The customer&#39;s phone number. |  [optional] |
|**emailAddress** | **String** | The customer&#39;s phone number. |  [optional] |



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




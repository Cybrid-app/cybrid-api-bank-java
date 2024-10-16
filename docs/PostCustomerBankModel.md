

# PostCustomerBankModel

Request body for customer creation.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The type of customer. |  |
|**name** | [**PostCustomerNameBankModel**](PostCustomerNameBankModel.md) |  |  [optional] |
|**address** | [**PostCustomerAddressBankModel**](PostCustomerAddressBankModel.md) |  |  [optional] |
|**dateOfBirth** | **LocalDate** | The customer&#39;s date of birth. Optional when type is individual. |  [optional] |
|**phoneNumber** | **String** | The customer&#39;s phone number. Optional when type is individual. |  [optional] |
|**emailAddress** | **String** | The customer&#39;s email address. Optional when type is individual. |  [optional] |
|**identificationNumbers** | [**List&lt;PostIdentificationNumberBankModel&gt;**](PostIdentificationNumberBankModel.md) | The customer&#39;s identification numbers. Optional when type is individual. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the customer. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BUSINESS | &quot;business&quot; |
| INDIVIDUAL | &quot;individual&quot; |




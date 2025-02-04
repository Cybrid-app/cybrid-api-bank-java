

# PostCustomerBankModel

Request body for customer creation.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The type of customer. |  |
|**address** | [**PostCustomerAddressBankModel**](PostCustomerAddressBankModel.md) |  |  [optional] |
|**phoneNumber** | **String** | The customer&#39;s phone number. |  [optional] |
|**emailAddress** | **String** | The customer&#39;s email address. |  [optional] |
|**identificationNumbers** | [**List&lt;PostIdentificationNumberBankModel&gt;**](PostIdentificationNumberBankModel.md) | The customer&#39;s identification numbers. |  [optional] |
|**name** | [**PostCustomerNameBankModel**](PostCustomerNameBankModel.md) |  |  [optional] |
|**dateOfBirth** | **LocalDate** | The customer&#39;s date of birth. Optional when type is individual. |  [optional] |
|**aliases** | [**List&lt;PostCustomerAliasesInnerBankModel&gt;**](PostCustomerAliasesInnerBankModel.md) | The aliases of the customer. Optional when type is business. |  [optional] |
|**website** | **String** | The customer&#39;s website. Optional when type is business. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the customer. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BUSINESS | &quot;business&quot; |
| INDIVIDUAL | &quot;individual&quot; |






# PostCustomerBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The customer&#39;s type. |  |
|**name** | [**PostCustomerNameBankModel**](PostCustomerNameBankModel.md) |  |  [optional] |
|**address** | [**PostCustomerAddressBankModel**](PostCustomerAddressBankModel.md) |  |  [optional] |
|**dateOfBirth** | **LocalDate** | The customer&#39;s date of birth. |  [optional] |
|**phoneNumber** | **String** | The customer&#39;s phone number. |  [optional] |
|**emailAddress** | **String** | The customer&#39;s phone number. |  [optional] |
|**identificationNumbers** | [**List&lt;PostIdentificationNumberBankModel&gt;**](PostIdentificationNumberBankModel.md) | The customer&#39;s identification numbers. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| INDIVIDUAL | &quot;individual&quot; |




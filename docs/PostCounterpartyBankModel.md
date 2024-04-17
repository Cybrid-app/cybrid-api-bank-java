

# PostCounterpartyBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The counterparty&#39;s type. |  |
|**name** | [**PostCounterpartyNameBankModel**](PostCounterpartyNameBankModel.md) |  |  [optional] |
|**address** | [**PostCustomerAddressBankModel**](PostCustomerAddressBankModel.md) |  |  [optional] |
|**dateOfBirth** | **LocalDate** | The counterparty&#39;s date of birth. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the counterparty. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BUSINESS | &quot;business&quot; |
| INDIVIDUAL | &quot;individual&quot; |




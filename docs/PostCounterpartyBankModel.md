

# PostCounterpartyBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The counterparty&#39;s type. |  |
|**customerGuid** | **String** | The owning customer&#39;s identifier. |  [optional] |
|**name** | [**PostCounterpartyNameBankModel**](PostCounterpartyNameBankModel.md) |  |  [optional] |
|**address** | [**PostCustomerAddressBankModel**](PostCustomerAddressBankModel.md) |  |  [optional] |
|**aliases** | [**List&lt;CounterpartyAliasesInnerBankModel&gt;**](CounterpartyAliasesInnerBankModel.md) | The counterparty&#39;s aliases. |  [optional] |
|**dateOfBirth** | **LocalDate** | The counterparty&#39;s date of birth. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the counterparty. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BUSINESS | &quot;business&quot; |
| INDIVIDUAL | &quot;individual&quot; |






# PostCounterpartyBankModel

Request body for counterparty creation.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The counterparty&#39;s type. |  |
|**customerGuid** | **String** | The owning customer&#39;s identifier. |  [optional] |
|**address** | [**PostCounterpartyAddressBankModel**](PostCounterpartyAddressBankModel.md) |  |  |
|**name** | [**PostCounterpartyNameBankModel**](PostCounterpartyNameBankModel.md) |  |  [optional] |
|**aliases** | [**List&lt;PostCounterpartyAliasesInnerBankModel&gt;**](PostCounterpartyAliasesInnerBankModel.md) | The aliases of the counterparty. Optional when type is business. |  [optional] |
|**dateOfBirth** | **LocalDate** | The counterparty&#39;s date of birth. Optional when type is individual. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the counterparty. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BUSINESS | &quot;business&quot; |
| INDIVIDUAL | &quot;individual&quot; |




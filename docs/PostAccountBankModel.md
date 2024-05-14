

# PostAccountBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The account type. |  |
|**customerGuid** | **String** | The customer identifier associated with the account. |  [optional] |
|**asset** | **String** | The asset code. |  |
|**name** | **String** | The name of the account. |  |
|**labels** | **List&lt;String&gt;** | The labels associated with the account. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| TRADING | &quot;trading&quot; |
| FIAT | &quot;fiat&quot; |
| INVOICE_OPERATIONS | &quot;invoice_operations&quot; |






# PostDepositBankAccountBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The account type. |  [optional] |
|**accountGuid** | **String** | The fiat account guid. |  |
|**customerGuid** | **String** | The unique identifier for the customer. |  [optional] |
|**parentDepositBankAccountGuid** | **String** | The unique identifier for the bank-level deposit bank account. This is only required for sub-accounts. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the address. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| MAIN | &quot;main&quot; |
| SUB_ACCOUNT | &quot;sub_account&quot; |




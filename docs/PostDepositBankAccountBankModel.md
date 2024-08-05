

# PostDepositBankAccountBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The account type. To generate deposit bank accounts with their own unique account number set this to \&quot;main\&quot;. To generate deposit bank accounts with the same account number as the parent deposit bank account set this to \&quot;sub_account\&quot;. This setting will only generate a unique identifier for the deposit bank and will not result in a unique account number being generated. \&quot;sub_account\&quot; is only  available for customer-level deposit bank accounts. |  [optional] |
|**accountGuid** | **String** | The fiat account guid. |  |
|**customerGuid** | **String** | The unique identifier for the customer. |  [optional] |
|**parentDepositBankAccountGuid** | **String** | The unique identifier for the bank-level deposit bank account. This is only required for sub-accounts. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the address. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| MAIN | &quot;main&quot; |
| SUB_ACCOUNT | &quot;sub_account&quot; |




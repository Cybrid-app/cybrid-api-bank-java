

# TransferDestinationAccountBankModel

The destination account in the transfer.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the transfer account. |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of transfer account. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| TRADING | &quot;trading&quot; |
| FIAT | &quot;fiat&quot; |
| EXTERNAL_BANK_ACCOUNT | &quot;external_bank_account&quot; |
| EXTERNAL_WALLET | &quot;external_wallet&quot; |
| ONE_TIME_ADDRESS | &quot;one_time_address&quot; |




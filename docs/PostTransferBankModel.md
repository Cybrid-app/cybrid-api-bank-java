

# PostTransferBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  |
|**transferType** | [**TransferTypeEnum**](#TransferTypeEnum) | The type of transfer. |  |
|**externalBankAccountGuid** | **String** | The customer&#39;s &#39;plaid&#39; or &#39;plaid_processor_token&#39; external bank account&#39;s identifier. |  [optional] |
|**oneTimeAddress** | [**PostOneTimeAddressBankModel**](PostOneTimeAddressBankModel.md) |  |  [optional] |
|**expectedError** | [**ExpectedErrorEnum**](#ExpectedErrorEnum) | The optional expected error to simulate transfer failure. |  [optional] |



## Enum: TransferTypeEnum

| Name | Value |
|---- | -----|
| FUNDING | &quot;funding&quot; |
| BOOK | &quot;book&quot; |
| CRYPTO | &quot;crypto&quot; |



## Enum: ExpectedErrorEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |
| IN_PROGRESS | &quot;in_progress&quot; |
| COMPLETED | &quot;completed&quot; |
| FAILED | &quot;failed&quot; |
| CANCELLED | &quot;cancelled&quot; |
| MANUAL_INTERVENTION | &quot;manual_intervention&quot; |
| REVERSED | &quot;reversed&quot; |




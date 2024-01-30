

# PostTransferBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  |
|**transferType** | [**TransferTypeEnum**](#TransferTypeEnum) | The type of transfer. |  |
|**sourceAccountGuid** | **String** | The source account&#39;s identifier. Required for book transfers. |  [optional] |
|**destinationAccountGuid** | **String** | The destination account&#39;s identifier. Required for book transfers. |  [optional] |
|**externalWalletGuid** | **String** | The customer&#39;s external wallet&#39;s identifier. |  [optional] |
|**externalBankAccountGuid** | **String** | The customer&#39;s &#39;plaid&#39; or &#39;plaid_processor_token&#39; external bank account&#39;s identifier. |  [optional] |
|**paymentRail** | **String** | The desired payment rail to initiate the transfer for. Valid values are: ach, eft, wire. Valid for funding transfers only. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the transfer. |  [optional] |



## Enum: TransferTypeEnum

| Name | Value |
|---- | -----|
| FUNDING | &quot;funding&quot; |
| BOOK | &quot;book&quot; |
| CRYPTO | &quot;crypto&quot; |
| INSTANT_FUNDING | &quot;instant_funding&quot; |




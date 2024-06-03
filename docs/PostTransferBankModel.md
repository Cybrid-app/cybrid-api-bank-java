

# PostTransferBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  |
|**transferType** | [**TransferTypeEnum**](#TransferTypeEnum) | The type of transfer. |  |
|**customerGuid** | **String** | The customer&#39;s identifier. |  [optional] |
|**sourceAccountGuid** | **String** | The source account&#39;s identifier. Required for book transfers. |  [optional] |
|**destinationAccountGuid** | **String** | The destination account&#39;s identifier. Required for book transfers. |  [optional] |
|**externalWalletGuid** | **String** | The customer&#39;s external wallet&#39;s identifier. |  [optional] |
|**externalBankAccountGuid** | **String** | The customer&#39;s &#39;plaid&#39; or &#39;plaid_processor_token&#39; external bank account&#39;s identifier. |  [optional] |
|**networkFeeAccountGuid** | **String** | The network fee account&#39;s identifier. Required for network fee transfers. Must be the identifier for the customer&#39;s or bank&#39;s fiat account. For customer&#39;s to pay the network fees, include the customer&#39;s fiat account guid. For bank&#39;s to pay the network fees, include the bank&#39;s fiat account guid. |  [optional] |
|**paymentRail** | **String** | The desired payment rail to initiate the transfer for. Valid values are: ach, eft, wire. Valid for funding transfers only. |  [optional] |
|**beneficiaryMemo** | **String** | The memo to send to the counterparty. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the transfer. |  [optional] |



## Enum: TransferTypeEnum

| Name | Value |
|---- | -----|
| FUNDING | &quot;funding&quot; |
| BOOK | &quot;book&quot; |
| CRYPTO | &quot;crypto&quot; |
| INSTANT_FUNDING | &quot;instant_funding&quot; |
| INTER_ACCOUNT | &quot;inter_account&quot; |
| LIGHTNING | &quot;lightning&quot; |




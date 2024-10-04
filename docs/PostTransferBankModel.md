

# PostTransferBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  |
|**transferType** | [**TransferTypeEnum**](#TransferTypeEnum) | The type of transfer. |  |
|**customerGuid** | **String** | The customer&#39;s identifier. |  [optional] |
|**fiatAccountGuid** | **String** | The identifier for the fiat account to use for the transfer. Required if the customer or bank has multiple fiat accounts. Only valid for funding transfers. |  [optional] |
|**customerFiatAccountGuid** | **String** | The identifier for the fiat account to use for the transfer. Required if the customer has multiple fiat accounts. Only valid for instant funding and lightning transfers. |  [optional] |
|**bankFiatAccountGuid** | **String** | The identifier for the fiat account to use for the transfer. Required if the bank has multiple fiat accounts. Only valid for instant funding and lightning transfers. |  [optional] |
|**sourceAccountGuid** | **String** | The source account&#39;s identifier. Required for book transfers. |  [optional] |
|**sourceParticipants** | [**List&lt;PostTransferParticipantBankModel&gt;**](PostTransferParticipantBankModel.md) | The source participants for the transfer. Not supported for \&quot;inter_account\&quot; transfers. |  [optional] |
|**destinationAccountGuid** | **String** | The destination account&#39;s identifier. Required for book transfers. |  [optional] |
|**destinationParticipants** | [**List&lt;PostTransferParticipantBankModel&gt;**](PostTransferParticipantBankModel.md) | The destination participants for the transfer. Not supported for \&quot;inter_account\&quot; transfers. |  [optional] |
|**externalWalletGuid** | **String** | The customer&#39;s external wallet&#39;s identifier. |  [optional] |
|**externalBankAccountGuid** | **String** | The customer&#39;s &#39;plaid&#39; or &#39;plaid_processor_token&#39; external bank account&#39;s identifier. |  [optional] |
|**networkFeeAccountGuid** | **String** | The network fee account&#39;s identifier. Required for network fee transfers. Must be the identifier for the customer&#39;s or bank&#39;s fiat or trading account. For customer&#39;s to pay the network fees, include the customer&#39;s fiat or trading account guid. For bank&#39;s to pay the network fees, include the bank&#39;s fiat or trading account guid. |  [optional] |
|**paymentRail** | **String** | The desired payment rail to initiate the transfer for. Valid values are: ach, eft, wire. Valid for funding transfers only. |  [optional] |
|**beneficiaryMemo** | **String** | The memo to send to the counterparty. |  [optional] |
|**sendAsDepositBankAccountGuid** | **String** | The deposit bank account&#39;s identifier. Optional for funding transfers. Only valid for withdrawals. The deposit bank account must be owned by the customer or bank initiating the transfer. |  [optional] |
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




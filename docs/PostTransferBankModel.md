

# PostTransferBankModel

Request body for transfer creation.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  |
|**transferType** | [**TransferTypeEnum**](#TransferTypeEnum) | The type of transfer. |  |
|**externalBankAccountGuid** | **String** | The customer&#39;s &#39;plaid&#39; or &#39;plaid_processor_token&#39; external bank account&#39;s identifier. Required when transfer_type is funding or transfer_type is instant_funding. |  [optional] |
|**fiatAccountGuid** | **String** | The identifier for the fiat account to use for the transfer. Required if the customer or bank has multiple fiat accounts. Optional when transfer_type is funding. |  [optional] |
|**sendAsDepositBankAccountGuid** | **String** | The deposit bank account&#39;s identifier. Only valid for withdrawals. The deposit bank account must be owned by the customer or bank initiating the transfer. Optional when transfer_type is funding. |  [optional] |
|**paymentRail** | [**PaymentRailEnum**](#PaymentRailEnum) | The desired payment rail to initiate the transfer for. Optional when transfer_type is funding. |  [optional] |
|**beneficiaryMemo** | **String** | The memo to send to the counterparty. Optional when transfer_type is funding. |  [optional] |
|**sourceParticipants** | [**List&lt;PostTransferParticipantBankModel&gt;**](PostTransferParticipantBankModel.md) | The source participants for the transfer. Optional when transfer_type is funding, transfer_type is instant_funding, transfer_type is book, transfer_type is crypto, or transfer_type is lightning. |  [optional] |
|**destinationParticipants** | [**List&lt;PostTransferParticipantBankModel&gt;**](PostTransferParticipantBankModel.md) | The destination participants for the transfer. Optional when transfer_type is funding, transfer_type is instant_funding, transfer_type is book, transfer_type is crypto, or transfer_type is lightning. |  [optional] |
|**bankFiatAccountGuid** | **String** | The identifier for the fiat account to use for the transfer. Required if the bank has multiple fiat accounts. Optional when transfer_type is instant_funding or transfer_type is lightning. |  [optional] |
|**customerFiatAccountGuid** | **String** | The identifier for the fiat account to use for the transfer. Required if the customer has multiple fiat accounts. Optional when transfer_type is instant_funding or transfer_type is lightning. |  [optional] |
|**sourceAccountGuid** | **String** | The source account&#39;s identifier. Required when transfer_type is book or transfer_type is inter_account. |  [optional] |
|**destinationAccountGuid** | **String** | The destination account&#39;s identifier. Required when transfer_type is book or transfer_type is inter_account. |  [optional] |
|**externalWalletGuid** | **String** | The customer&#39;s external wallet&#39;s identifier. Optional when transfer_type is crypto. |  [optional] |
|**customerGuid** | **String** | The customer&#39;s identifier. Required when transfer_type is lightning. |  [optional] |
|**networkFeeAccountGuid** | **String** | The network fee account&#39;s identifier. Required for network fee transfers. Must be the identifier for the customer&#39;s or bank&#39;s fiat or trading account. For customer&#39;s to pay the network fees, include the customer&#39;s fiat or trading account guid. For bank&#39;s to pay the network fees, include the bank&#39;s fiat or trading account guid. Required when transfer_type is lightning. |  [optional] |
|**expectedBehaviours** | [**List&lt;ExpectedBehavioursEnum&gt;**](#List&lt;ExpectedBehavioursEnum&gt;) | The optional expected behaviour to simulate. Only applicable for transfers under sandbox banks. The force_review behaviour will force the transfer to be reviewed for funding and instant_funding transfers. |  [optional] |
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



## Enum: PaymentRailEnum

| Name | Value |
|---- | -----|
| ACH | &quot;ach&quot; |
| EFT | &quot;eft&quot; |
| WIRE | &quot;wire&quot; |
| RTP | &quot;rtp&quot; |



## Enum: List&lt;ExpectedBehavioursEnum&gt;

| Name | Value |
|---- | -----|
| FORCE_REVIEW | &quot;force_review&quot; |




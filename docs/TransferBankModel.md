

# TransferBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the transfer. |  [optional] |
|**transferType** | **String** | The type of transfer; one of funding, book, crypto, instant_funding, funding_return, crypto_return, loss_recovery, inter_account, lightning, or instant_funding_return. |  [optional] |
|**bankGuid** | **String** | The associated bank&#39;s identifier. |  [optional] |
|**customerGuid** | **String** | The associated customer&#39;s identifier. |  [optional] |
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  [optional] |
|**externalBankAccountGuid** | **String** | The associated external bank account&#39;s identifier. |  [optional] |
|**asset** | **String** | The asset the transfer is related to, e.g., USD. |  [optional] |
|**side** | **String** | The direction of the quote; one of deposit or withdrawal. |  [optional] |
|**state** | **String** | The state of the transfer; one of storing, pending, reviewing, completed, or failed. |  [optional] |
|**failureCode** | **String** | The failure code for failed transfers; one of non_sufficient_funds, refresh_required, party_name_invalid, payment_rail_invalid, compliance_rejection, cancelled, reversed, limit_exceeded, network_fee_too_low, amount_too_low, internal_error, or invalid_address. |  [optional] |
|**returnCode** | **String** | The return code for reversed transfers |  [optional] |
|**amount** | **java.math.BigInteger** | The actual amount in base units of the asset. |  [optional] |
|**estimatedAmount** | **java.math.BigInteger** | The estimated amount in base units of the asset. |  [optional] |
|**fee** | **java.math.BigInteger** | The fee associated with the transfer. |  [optional] |
|**estimatedNetworkFee** | **java.math.BigInteger** | The estimated network fee in base units of network_fee_asset. Only present on &#x60;crypto&#x60; transfers. |  [optional] |
|**networkFee** | **java.math.BigInteger** | The actual network fee in base units of network_fee_asset. Only present on &#x60;crypto&#x60; transfers that have successfully completed. |  [optional] |
|**networkFeeAsset** | **String** | The asset code of the network fee. Only present on &#x60;crypto&#x60; transfers that have successfully completed. |  [optional] |
|**networkFeeLiabilityAmount** | **java.math.BigInteger** | The equivalent fiat network fee in base units of network_fee_liability_amount_asset. Only present on &#x60;crypto&#x60; transfers that have successfully completed. |  [optional] |
|**networkFeeLiabilityAmountAsset** | **String** | The fiat asset the network_fee_liability_amount is denominated in. Only present on &#x60;crypto&#x60; transfers that have successfully completed. |  [optional] |
|**txnHash** | **String** | The hash of the blockchain transaction |  [optional] |
|**referenceTransferGuid** | **String** | The guid of the related transfer. Only present on return type transfers. |  [optional] |
|**sourceAccount** | [**TransferSourceAccountBankModel**](TransferSourceAccountBankModel.md) |  |  [optional] |
|**sourceParticipants** | [**List&lt;TransferParticipantBankModel&gt;**](TransferParticipantBankModel.md) | The participants in the source account. |  [optional] |
|**destinationAccount** | [**TransferDestinationAccountBankModel**](TransferDestinationAccountBankModel.md) |  |  [optional] |
|**destinationParticipants** | [**List&lt;TransferParticipantBankModel&gt;**](TransferParticipantBankModel.md) | The participants in the source account. |  [optional] |
|**depositAddressGuid** | **String** | The guid of the deposit address. Only present on crypto deposits. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |
|**holdDetails** | [**TransferHoldDetailsBankModel**](TransferHoldDetailsBankModel.md) |  |  [optional] |
|**transferDetails** | **Object** | The raw details on the transfer from the bank. |  [optional] |
|**paymentRail** | **String** | The rail the payment was done on. One of: ach, eft, wire, rtp |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the transfer. |  [optional] |
|**entries** | [**List&lt;TransferEntryBankModel&gt;**](TransferEntryBankModel.md) | Transfer entries associated with the batch transfer |  [optional] |




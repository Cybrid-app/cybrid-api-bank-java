

# TransferBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the transfer. |  [optional] |
|**transferType** | [**TransferTypeEnum**](#TransferTypeEnum) | The type of transfer. |  [optional] |
|**bankGuid** | **String** | The associated bank&#39;s identifier. |  [optional] |
|**customerGuid** | **String** | The associated customer&#39;s identifier. |  [optional] |
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  [optional] |
|**externalBankAccountGuid** | **String** | The associated external bank account&#39;s identifier. |  [optional] |
|**asset** | **String** | The asset the transfer is related to, e.g., USD. |  [optional] |
|**side** | [**SideEnum**](#SideEnum) | The direction of the quote: &#39;deposit&#39; or &#39;withdrawal&#39;. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The transfer&#39;s state |  [optional] |
|**failureCode** | **String** | The failure code for failed transfers. |  [optional] |
|**amount** | **java.math.BigInteger** | The actual amount in base units of the asset. |  [optional] |
|**estimatedAmount** | **java.math.BigInteger** | The estimated amount in base units of the asset. |  [optional] |
|**fee** | **java.math.BigInteger** | The fee associated with the transfer. |  [optional] |
|**estimatedNetworkFee** | **java.math.BigInteger** | The estimated network fee in base units of network_fee_asset. Only present on &#x60;crypto&#x60; transfers. |  [optional] |
|**networkFee** | **java.math.BigInteger** | The actual network fee in base units of network_fee_asset. Only present on &#x60;crypto&#x60; transfers that have successfully completed. |  [optional] |
|**networkFeeAsset** | **String** | The asset code of the network fee. Only present on &#x60;crypto&#x60; transfers that have successfully completed. |  [optional] |
|**networkFeeLiabilityAmount** | **java.math.BigInteger** | The equivalent fiat network fee in base units of network_fee_liability_amount_asset. Only present on &#x60;crypto&#x60; transfers that have successfully completed. |  [optional] |
|**networkFeeLiabilityAmountAsset** | **String** | The fiat asset the network_fee_liability_amount is denominated in. Only present on &#x60;crypto&#x60; transfers that have successfully completed. |  [optional] |
|**txnHash** | **String** | The hash of the blockchain transaction |  [optional] |
|**referenceTransferGuid** | **String** | The guid of the related transfer. Only present on &#x60;funding_return&#x60; transfers. |  [optional] |
|**sourceAccount** | [**TransferSourceAccountBankModel**](TransferSourceAccountBankModel.md) |  |  [optional] |
|**destinationAccount** | [**TransferDestinationAccountBankModel**](TransferDestinationAccountBankModel.md) |  |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the bank was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the transfer was last updated at. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the transfer. |  [optional] |



## Enum: TransferTypeEnum

| Name | Value |
|---- | -----|
| FUNDING | &quot;funding&quot; |
| BOOK | &quot;book&quot; |
| CRYPTO | &quot;crypto&quot; |
| INSTANT_FUNDING | &quot;instant_funding&quot; |
| FUNDING_RETURN | &quot;funding_return&quot; |



## Enum: SideEnum

| Name | Value |
|---- | -----|
| DEPOSIT | &quot;deposit&quot; |
| WITHDRAWAL | &quot;withdrawal&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| PENDING | &quot;pending&quot; |
| REVIEWING | &quot;reviewing&quot; |
| COMPLETED | &quot;completed&quot; |
| FAILED | &quot;failed&quot; |




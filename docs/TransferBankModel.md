

# TransferBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the trade. |  [optional] |
|**transferType** | [**TransferTypeEnum**](#TransferTypeEnum) | The type of transfer. |  [optional] |
|**customerGuid** | **String** | The associated customer&#39;s identifier. |  [optional] |
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  [optional] |
|**asset** | **String** | The asset the transfer is related to, e.g., USD. |  [optional] |
|**side** | [**SideEnum**](#SideEnum) | The direction of the quote: &#39;deposit&#39; or &#39;withdrawal&#39;. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The trade&#39;s state |  [optional] |
|**amount** | **java.math.BigInteger** | The amount being transferred. |  [optional] |
|**fee** | **java.math.BigInteger** | The fee associated with the trade. |  [optional] |
|**estimatedNetworkFee** | **java.math.BigInteger** | The estimated network fee in base units of network_fee_asset. Only present on &#x60;crypto&#x60; transfers. |  [optional] |
|**networkFee** | **java.math.BigInteger** | The actual network fee in base units of network_fee_asset. Only present on &#x60;crypto&#x60; transfers that have successfully completed. |  [optional] |
|**networkFeeAsset** | **String** | The asset code of the network fee. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the bank was created at. |  [optional] |



## Enum: TransferTypeEnum

| Name | Value |
|---- | -----|
| SAVINGS | &quot;savings&quot; |
| FUNDING | &quot;funding&quot; |
| BOOK | &quot;book&quot; |
| CRYPTO | &quot;crypto&quot; |



## Enum: SideEnum

| Name | Value |
|---- | -----|
| DEPOSIT | &quot;deposit&quot; |
| WITHDRAWAL | &quot;withdrawal&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| INITIATING | &quot;initiating&quot; |
| PENDING | &quot;pending&quot; |
| COMPLETED | &quot;completed&quot; |
| FAILED | &quot;failed&quot; |




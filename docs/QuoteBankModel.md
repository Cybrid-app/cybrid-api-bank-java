

# QuoteBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the quote. |  [optional] |
|**productType** | [**ProductTypeEnum**](#ProductTypeEnum) | The type of product the quote is for. |  [optional] |
|**customerGuid** | **String** | The unique identifier for the customer. |  [optional] |
|**symbol** | **String** | Symbol the quote was requested for. Format is \&quot;asset-counter_asset\&quot; in uppercase. Populated for trade quotes. |  [optional] |
|**side** | [**SideEnum**](#SideEnum) | The direction of the quote: either &#39;buy&#39; or &#39;sell&#39; for trade quotes. |  [optional] |
|**receiveAmount** | **java.math.BigInteger** | The amount to be received in base units of the currency: currency is \&quot;asset\&quot; for buy and \&quot;counter_asset\&quot; for sell for trade quotes. |  [optional] |
|**deliverAmount** | **java.math.BigInteger** | The amount to be delivered in base units of the currency: currency is \&quot;counter_asset\&quot; for buy and \&quot;asset\&quot; for sell for trade quotes. |  [optional] |
|**fee** | **java.math.BigInteger** | The fee associated with the trade. Denominated in \&quot;counter_asset\&quot; base units for trade quotes. |  [optional] |
|**issuedAt** | **OffsetDateTime** | ISO8601 datetime the quote was created at. |  [optional] |
|**expiresAt** | **OffsetDateTime** | ISO8601 datetime the quote is expiring at. Populated for trading quotes. |  [optional] |
|**asset** | **String** | The asset code the quote was requested for. Populated for book transfer and funding quotes. |  [optional] |
|**networkFee** | **java.math.BigInteger** | The network fee in base units of network_fee_asset. Only present on &#x60;crypto_transfer&#x60; quotes. |  [optional] |
|**networkFeeAsset** | **String** | The asset code of the network fee. |  [optional] |



## Enum: ProductTypeEnum

| Name | Value |
|---- | -----|
| TRADING | &quot;trading&quot; |
| FUNDING | &quot;funding&quot; |
| BOOK_TRANSFER | &quot;book_transfer&quot; |
| CRYPTO_TRANSFER | &quot;crypto_transfer&quot; |



## Enum: SideEnum

| Name | Value |
|---- | -----|
| BUY | &quot;buy&quot; |
| SELL | &quot;sell&quot; |
| DEPOSIT | &quot;deposit&quot; |
| WITHDRAWAL | &quot;withdrawal&quot; |




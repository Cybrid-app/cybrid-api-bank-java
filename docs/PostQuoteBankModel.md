

# PostQuoteBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**productType** | [**ProductTypeEnum**](#ProductTypeEnum) | The type of product the quote is for. |  [optional] |
|**customerGuid** | **String** | The unique identifier for the customer. |  [optional] |
|**asset** | **String** | The asset code the quote was requested for. Populated for funding, book transfer and crypto transfer quotes. |  [optional] |
|**symbol** | **String** | Symbol the quote is being requested for. Format is \&quot;asset-counter_asset\&quot; in uppercase. See the Symbols API for a complete list of cryptocurrencies supported. Populated for trade quotes. |  [optional] |
|**side** | [**SideEnum**](#SideEnum) | The direction for trade quotes: either &#39;buy&#39; or &#39;sell&#39;. The direction for funding quotes: either &#39;deposit&#39; or &#39;withdrawal&#39;. The direction for book transfer quotes: either &#39;deposit&#39; or &#39;withdrawal&#39;. The direction for crypto transfer quotes: &#39;withdrawal&#39;.  |  |
|**receiveAmount** | **java.math.BigInteger** | The amount to be received in base units of the currency: currency is \&quot;asset\&quot; for buy and \&quot;counter_asset\&quot; for sell for trade quotes. |  [optional] |
|**deliverAmount** | **java.math.BigInteger** | The amount to be delivered in base units of the currency: currency is \&quot;counter_asset\&quot; for buy and \&quot;asset\&quot; for sell for trade quotes. |  [optional] |



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




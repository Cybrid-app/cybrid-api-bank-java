

# PostQuoteBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**productType** | [**ProductTypeEnum**](#ProductTypeEnum) | The type of product the quote is for. |  [optional] |
|**bankGuid** | **String** | The unique identifier for the bank. |  [optional] |
|**customerGuid** | **String** | The unique identifier for the customer. |  [optional] |
|**asset** | **String** | The asset code the quote was requested for. Populated for funding, book transfer and crypto transfer quotes. |  [optional] |
|**networkAddress** | **String** | The network address to pay the invoice to. Populated for lightning_transfer quotes. |  [optional] |
|**symbol** | **String** | Symbol the quote is being requested for. Format is \&quot;asset-counter_asset\&quot; in uppercase. See the Symbols API for a complete list of cryptocurrencies supported. Populated for trade quotes. |  [optional] |
|**side** | **String** | The direction for trade quotes: either &#39;buy&#39; or &#39;sell&#39;. The direction for funding quotes: either &#39;deposit&#39; or &#39;withdrawal&#39;. The direction for crypto transfer quotes: &#39;withdrawal&#39;. Book transfers do not require a side. They are all &#39;deposit&#39;s.  |  [optional] |
|**receiveAmount** | **java.math.BigInteger** | The amount to be received in base units of the currency: currency is \&quot;asset\&quot; for buy and \&quot;counter_asset\&quot; for sell for trade quotes. |  [optional] |
|**deliverAmount** | **java.math.BigInteger** | The amount to be delivered in base units of the currency: currency is \&quot;counter_asset\&quot; for buy and \&quot;asset\&quot; for sell for trade quotes. |  [optional] |
|**fees** | [**List&lt;PostFeeBankModel&gt;**](PostFeeBankModel.md) | The custom fees associated with the quote |  [optional] |



## Enum: ProductTypeEnum

| Name | Value |
|---- | -----|
| TRADING | &quot;trading&quot; |
| FUNDING | &quot;funding&quot; |
| BOOK_TRANSFER | &quot;book_transfer&quot; |
| CRYPTO_TRANSFER | &quot;crypto_transfer&quot; |
| INTER_ACCOUNT | &quot;inter_account&quot; |
| LIGHTNING_TRANSFER | &quot;lightning_transfer&quot; |




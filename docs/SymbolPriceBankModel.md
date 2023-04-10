

# SymbolPriceBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**symbol** | **String** | The trade symbol the pricing is related to. Format is asset-counter_asset, e.g., BTC-USD. |  [optional] |
|**buyPrice** | **java.math.BigInteger** | The purchase price (in base units) for the asset denominated in the counter asset currency. |  [optional] |
|**sellPrice** | **java.math.BigInteger** | The sale price (in base units) for the asset denominated in the counter asset currency. |  [optional] |
|**buyPriceLastUpdatedAt** | **OffsetDateTime** | ISO8601 datetime the purchase price was generated at. |  [optional] |
|**sellPriceLastUpdatedAt** | **OffsetDateTime** | ISO8601 datetime the sale price was generated at. |  [optional] |




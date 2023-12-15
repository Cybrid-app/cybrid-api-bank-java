

# TradeBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the trade. |  [optional] |
|**tradeType** | **String** | The type of trade; one of platform or liquidation. |  [optional] |
|**customerGuid** | **String** | The associated customer&#39;s identifier. |  [optional] |
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  [optional] |
|**symbol** | **String** | The trade symbol the pricing is related to. Format is asset-counter_asset, e.g., BTC-USD. |  [optional] |
|**side** | **String** | The direction of the trade; one of buy or sell. |  [optional] |
|**state** | **String** | The state of the trade; one of storing, pending, cancelled, completed, settling, or failed. |  [optional] |
|**failureCode** | **String** | The failure code for failed trades. |  [optional] |
|**receiveAmount** | **java.math.BigInteger** | The amount to be received in base units of the currency: currency is \&quot;asset\&quot; for buy and \&quot;counter_asset\&quot; for sell. |  [optional] |
|**deliverAmount** | **java.math.BigInteger** | The amount to be delivered in base units of the currency: currency is \&quot;counter_asset\&quot; for buy and \&quot;asset\&quot; for sell. |  [optional] |
|**fee** | **java.math.BigInteger** | The fee associated with the trade. Denominated in \&quot;counter_asset\&quot; base units |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the trade. |  [optional] |




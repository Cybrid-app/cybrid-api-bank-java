

# TradeBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the trade. |  [optional] |
|**tradeType** | [**TradeTypeEnum**](#TradeTypeEnum) | The type of trade. |  [optional] |
|**customerGuid** | **String** | The associated customer&#39;s identifier. |  [optional] |
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  [optional] |
|**symbol** | **String** | The trade symbol the pricing is related to. Format is asset-counter_asset, e.g., BTC-USD. |  [optional] |
|**side** | [**SideEnum**](#SideEnum) | The direction of the quote: either &#39;buy&#39; or &#39;sell&#39;. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The trade&#39;s state |  [optional] |
|**failureCode** | **String** | The failure code for failed trades. |  [optional] |
|**receiveAmount** | **java.math.BigInteger** | The amount to be received in base units of the currency: currency is \&quot;asset\&quot; for buy and \&quot;counter_asset\&quot; for sell. |  [optional] |
|**deliverAmount** | **java.math.BigInteger** | The amount to be delivered in base units of the currency: currency is \&quot;counter_asset\&quot; for buy and \&quot;asset\&quot; for sell. |  [optional] |
|**fee** | **java.math.BigInteger** | The fee associated with the trade. Denominated in \&quot;counter_asset\&quot; base units |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the trade was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the trade was last updated at. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the trade. |  [optional] |



## Enum: TradeTypeEnum

| Name | Value |
|---- | -----|
| PLATFORM | &quot;platform&quot; |
| LIQUIDATION | &quot;liquidation&quot; |



## Enum: SideEnum

| Name | Value |
|---- | -----|
| BUY | &quot;buy&quot; |
| SELL | &quot;sell&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| PENDING | &quot;pending&quot; |
| CANCELLED | &quot;cancelled&quot; |
| COMPLETED | &quot;completed&quot; |
| SETTLING | &quot;settling&quot; |
| FAILED | &quot;failed&quot; |




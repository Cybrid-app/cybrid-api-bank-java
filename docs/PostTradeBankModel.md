

# PostTradeBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tradeType** | [**TradeTypeEnum**](#TradeTypeEnum) | The type of trade. |  [optional] |
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  |
|**expectedError** | [**ExpectedErrorEnum**](#ExpectedErrorEnum) | The optional expected error to simulate trade failure. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the trade. |  [optional] |



## Enum: TradeTypeEnum

| Name | Value |
|---- | -----|
| PLATFORM | &quot;platform&quot; |
| EXIT | &quot;exit&quot; |



## Enum: ExpectedErrorEnum

| Name | Value |
|---- | -----|
| EXPIRED_QUOTE | &quot;expired_quote&quot; |
| NON_SUFFICIENT_FUNDS | &quot;non_sufficient_funds&quot; |




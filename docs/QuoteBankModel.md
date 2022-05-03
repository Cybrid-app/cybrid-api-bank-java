

# QuoteBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**guid** | **String** | Auto-generated unique identifier for the quote. |  [optional]
**customerGuid** | **String** | The unique identifier for the customer. |  [optional]
**symbol** | **String** | Symbol the quote is being requested for. Format is \&quot;asset-counter_asset\&quot; in uppercase. |  [optional]
**side** | [**SideEnum**](#SideEnum) | The direction of the quote: either &#39;buy&#39; or &#39;sell&#39;. |  [optional]
**receiveAmount** | **java.math.BigInteger** | The amount to be received in base units of the currency: currency is \&quot;asset\&quot; for buy and \&quot;counter_asset\&quot; for sell. |  [optional]
**deliverAmount** | **java.math.BigInteger** | The amount to be delivered in base units of the currency: currency is \&quot;counter_asset\&quot; for buy and \&quot;asset\&quot; for sell. |  [optional]
**fee** | **java.math.BigInteger** | The fee associated with the trade. Denominated in \&quot;counter_asset\&quot; base units |  [optional]
**issuedAt** | **OffsetDateTime** | ISO8601 datetime the quote was created at. |  [optional]
**expiresAt** | **OffsetDateTime** | ISO8601 datetime the quote is expiring at. |  [optional]



## Enum: SideEnum

Name | Value
---- | -----
BUY | &quot;buy&quot;
SELL | &quot;sell&quot;




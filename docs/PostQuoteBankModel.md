

# PostQuoteBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**customerGuid** | **String** | The unique identifier for the customer. | 
**symbol** | **String** | Symbol the quote is being requested for. Format is \&quot;asset-counter_asset\&quot; in uppercase. See the Symbols API for a complete list of cryptocurrencies supported. | 
**side** | [**SideEnum**](#SideEnum) | The direction of the quote: either &#39;buy&#39; or &#39;sell&#39;. | 
**receiveAmount** | **java.math.BigInteger** | The amount to be received in base units of the currency: currency is \&quot;asset\&quot; for buy and \&quot;counter_asset\&quot; for sell. |  [optional]
**deliverAmount** | **java.math.BigInteger** | The amount to be delivered in base units of the currency: currency is \&quot;counter_asset\&quot; for buy and \&quot;asset\&quot; for sell. |  [optional]



## Enum: SideEnum

Name | Value
---- | -----
BUY | &quot;buy&quot;
SELL | &quot;sell&quot;






# ExchangeAccountBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) | The exchange account type. |  [optional]
**guid** | **String** | Auto-generated unique identifier for exchange account. |  [optional]
**createdAt** | **OffsetDateTime** | ISO8601 datetime the exchange account was created at. |  [optional]
**exchangeGuid** | **String** | The identifier of the exchange that owns this exchange account. |  [optional]
**assetCode** | **String** | The asset code of the exchange account. |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
FIAT | &quot;fiat&quot;
CRYPTO | &quot;crypto&quot;




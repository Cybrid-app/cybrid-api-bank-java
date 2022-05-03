

# ExchangeBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**guid** | **String** | Auto-generated unique identifier for the exchange. |  [optional]
**name** | **String** | The name of the exchange. |  [optional]
**provider** | [**ProviderEnum**](#ProviderEnum) | The provider for the exchange. |  [optional]
**environment** | [**EnvironmentEnum**](#EnvironmentEnum) | The environment that the exchange is operating in. |  [optional]
**createdAt** | **OffsetDateTime** | ISO8601 datetime the exchange was created at. |  [optional]



## Enum: ProviderEnum

Name | Value
---- | -----
AQUANOW | &quot;aquanow&quot;
DV_CHAIN | &quot;dv_chain&quot;



## Enum: EnvironmentEnum

Name | Value
---- | -----
SANDBOX | &quot;sandbox&quot;
PRODUCTION | &quot;production&quot;




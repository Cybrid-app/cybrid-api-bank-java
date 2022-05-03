

# SystemAccountBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) | The account type. |  [optional]
**guid** | **String** | Auto-generated unique identifier for the account. |  [optional]
**createdAt** | **OffsetDateTime** | ISO8601 datetime the account was created at. |  [optional]
**assetCode** | **String** | The asset code. |  [optional]
**name** | **String** | The name of the account. |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
FIAT | &quot;fiat&quot;
CRYPTO | &quot;crypto&quot;




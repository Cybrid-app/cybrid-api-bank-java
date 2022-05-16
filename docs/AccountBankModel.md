

# AccountBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) | The account type. |  [optional]
**guid** | **String** | Auto-generated unique identifier for the account. |  [optional]
**createdAt** | **OffsetDateTime** | ISO8601 datetime the account was created at. |  [optional]
**asset** | **String** | The asset code. |  [optional]
**name** | **String** | The name of the account. |  [optional]
**bankGuid** | **String** | The bank identifier associated with the account. |  [optional]
**customerGuid** | **String** | The customer identifier associated with the account. |  [optional]
**platformBalance** | **java.math.BigInteger** | The amount of funds that are in the account, in base units of the asset. |  [optional]
**platformAvailable** | **java.math.BigInteger** | The amount of funds that are in the account, in base units of the asset, that are available for use on the platform. |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
BACKSTOPPED | &quot;backstopped&quot;
TRADING | &quot;trading&quot;
FEE | &quot;fee&quot;




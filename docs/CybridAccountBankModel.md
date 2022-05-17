

# CybridAccountBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) | The account type. |  [optional]
**guid** | **String** | Auto-generated unique identifier for the account. |  [optional]
**createdAt** | **OffsetDateTime** | ISO8601 datetime the account was created at. |  [optional]
**assetCode** | **String** | The asset code. |  [optional]
**name** | **String** | The name of the account. |  [optional]
**environment** | [**EnvironmentEnum**](#EnvironmentEnum) | The environment the account is configured for. |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
FEE | &quot;fee&quot;



## Enum: EnvironmentEnum

Name | Value
---- | -----
SANDBOX | &quot;sandbox&quot;
PRODUCTION | &quot;production&quot;




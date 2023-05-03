

# ExternalWalletBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the account. |  [optional] |
|**name** | **String** | The name of the account. |  [optional] |
|**assetCode** | **String** | The asset code. |  [optional] |
|**accountKind** | [**AccountKindEnum**](#AccountKindEnum) | The type of account. |  [optional] |
|**environment** | [**EnvironmentEnum**](#EnvironmentEnum) | The environment that the exchange is operating in. |  [optional] |
|**exchangeGuid** | **String** | The exchange identifier. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the exchange was created at. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The state of an external wallet |  [optional] |
|**failureCode** | **String** | The failure code of an external wallet (if any) |  [optional] |



## Enum: AccountKindEnum

| Name | Value |
|---- | -----|
| FIREBLOCKS_EXTERNAL_WALLET | &quot;fireblocks_external_wallet&quot; |
| CIRCLE_WIRE_EXTERNAL_WALLET | &quot;circle_wire_external_wallet&quot; |



## Enum: EnvironmentEnum

| Name | Value |
|---- | -----|
| SANDBOX | &quot;sandbox&quot; |
| PRODUCTION | &quot;production&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| PENDING | &quot;pending&quot; |
| FAILED | &quot;failed&quot; |
| COMPLETED | &quot;completed&quot; |




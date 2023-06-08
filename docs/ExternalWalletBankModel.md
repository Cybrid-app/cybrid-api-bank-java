

# ExternalWalletBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the wallet. |  [optional] |
|**name** | **String** | The name of the wallet. |  [optional] |
|**asset** | **String** | The asset code. |  [optional] |
|**environment** | [**EnvironmentEnum**](#EnvironmentEnum) | The environment that the wallet is configured for. |  [optional] |
|**bankGuid** | **String** | The bank identifier. |  [optional] |
|**customerGuid** | **String** | The customer identifier. |  [optional] |
|**address** | **String** | The blockchain wallet address for the wallet. |  [optional] |
|**tag** | **String** | The blockchain tag to use when transferring crypto to the wallet. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the wallet was created at. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The state of an external wallet |  [optional] |
|**failureCode** | **String** | The failure code of an external wallet (if any) |  [optional] |



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
| DELETING | &quot;deleting&quot; |
| DELETED | &quot;deleted&quot; |




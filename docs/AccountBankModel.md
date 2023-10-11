

# AccountBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The account type. |  [optional] |
|**guid** | **String** | Auto-generated unique identifier for the account. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the account was created at. |  [optional] |
|**asset** | **String** | The asset code. |  [optional] |
|**name** | **String** | The name of the account. |  [optional] |
|**bankGuid** | **String** | The bank identifier associated with the account. |  [optional] |
|**customerGuid** | **String** | The customer identifier associated with the account. |  [optional] |
|**platformBalance** | **java.math.BigInteger** | The amount of funds that are in the account, in base units of the asset. |  [optional] |
|**platformAvailable** | **java.math.BigInteger** | The amount of funds that are in the account, in base units of the asset, that are available for use on the platform. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The account&#39;s state. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the account. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| TRADING | &quot;trading&quot; |
| FEE | &quot;fee&quot; |
| FIAT | &quot;fiat&quot; |
| GAS | &quot;gas&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| CREATED | &quot;created&quot; |




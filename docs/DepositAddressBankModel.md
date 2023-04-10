

# DepositAddressBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the identity verification. |  |
|**bankGuid** | **String** | The address&#39; bank identifier. |  |
|**customerGuid** | **String** | The address&#39; customer identifier. |  |
|**accountGuid** | **String** | The address&#39; account identifier. |  |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the address was created at. |  |
|**asset** | **String** | The asset the transfer is related to, e.g., USD. |  |
|**state** | [**StateEnum**](#StateEnum) | The state of the address. |  |
|**address** | **String** | The blockchain address. |  [optional] |
|**format** | [**FormatEnum**](#FormatEnum) | The blockchain address format. |  [optional] |
|**tag** | **String** | The blockchain address tag. |  [optional] |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| CREATED | &quot;created&quot; |



## Enum: FormatEnum

| Name | Value |
|---- | -----|
| STANDARD | &quot;standard&quot; |
| LEGACY | &quot;legacy&quot; |




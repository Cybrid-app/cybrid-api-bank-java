

# DepositAddressBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the identity verification. |  [optional] |
|**bankGuid** | **String** | The address&#39; bank identifier. |  [optional] |
|**customerGuid** | **String** | The address&#39; customer identifier. |  [optional] |
|**accountGuid** | **String** | The address&#39; account identifier. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the address was created at. |  [optional] |
|**asset** | **String** | The asset the transfer is related to, e.g., USD. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The state of the address. |  [optional] |
|**address** | **String** | The blockchain address. |  [optional] |
|**format** | [**FormatEnum**](#FormatEnum) | The blockchain address format. |  [optional] |
|**tag** | **String** | The blockchain address tag. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the address. |  [optional] |



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




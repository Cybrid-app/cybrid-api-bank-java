

# PatchTransferParticipantBankModel

Request body for a transfer participant.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The type of participant. |  |
|**amount** | **java.math.BigInteger** | The amount in base units of the asset. |  |
|**guid** | **String** | The participant&#39;s identifier. |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BANK | &quot;bank&quot; |
| CUSTOMER | &quot;customer&quot; |
| COUNTERPARTY | &quot;counterparty&quot; |






# TransferHoldDetailsBankModel

The hold details if a transfer is or will be placed on a hold.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**applicableTypes** | **List&lt;String&gt;** | The list of hold types that are applicable for the transfer; one of administrative or non_administrative. |  [optional] |
|**duration** | **java.math.BigInteger** | The approximate time (in seconds) that the transfer will be held for. |  [optional] |
|**startedAt** | **OffsetDateTime** | ISO8601 datetime the transfer hold was started at. |  [optional] |




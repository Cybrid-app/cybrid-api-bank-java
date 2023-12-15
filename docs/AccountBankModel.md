

# AccountBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** | The account type; one of trading, fee, fiat, or gas. |  [optional] |
|**guid** | **String** | Auto-generated unique identifier for the account. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |
|**asset** | **String** | The asset code. |  [optional] |
|**name** | **String** | The name of the account. |  [optional] |
|**bankGuid** | **String** | The bank identifier associated with the account. |  [optional] |
|**customerGuid** | **String** | The customer identifier associated with the account. |  [optional] |
|**platformBalance** | **java.math.BigInteger** | The amount of funds that are in the account, in base units of the asset. |  [optional] |
|**platformAvailable** | **java.math.BigInteger** | The amount of funds that are in the account, in base units of the asset, that are available for use on the platform. |  [optional] |
|**state** | **String** | The state of the account; one of storing or created. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the account. |  [optional] |




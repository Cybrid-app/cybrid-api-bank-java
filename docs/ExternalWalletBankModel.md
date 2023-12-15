

# ExternalWalletBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the wallet. |  [optional] |
|**name** | **String** | The name of the wallet. |  [optional] |
|**asset** | **String** | The asset code. |  [optional] |
|**environment** | **String** | The environment that the wallet is configured for; one of sandbox or production. |  [optional] |
|**bankGuid** | **String** | The bank identifier. |  [optional] |
|**customerGuid** | **String** | The customer identifier. |  [optional] |
|**address** | **String** | The blockchain wallet address for the wallet. |  [optional] |
|**tag** | **String** | The blockchain tag to use when transferring crypto to the wallet. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |
|**state** | **String** | The state of the external wallet; one of storing, pending, failed, completed, deleting, or deleted. |  [optional] |
|**failureCode** | **String** | The failure code of an external wallet (if any) |  [optional] |




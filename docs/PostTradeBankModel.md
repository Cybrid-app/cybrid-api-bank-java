

# PostTradeBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**quoteGuid** | **String** | The associated quote&#39;s identifier. |  |
|**expectedError** | [**ExpectedErrorEnum**](#ExpectedErrorEnum) | The optional expected error to simulate trade failure. |  [optional] |



## Enum: ExpectedErrorEnum

| Name | Value |
|---- | -----|
| UNEXPECTED_ERROR | &quot;unexpected_error&quot; |
| INVALID_QUOTE_GUID | &quot;invalid_quote_guid&quot; |
| EXPIRED_QUOTE | &quot;expired_quote&quot; |
| NON_SUFFICIENT_FUNDS | &quot;non_sufficient_funds&quot; |




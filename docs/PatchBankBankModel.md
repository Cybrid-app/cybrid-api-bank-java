

# PatchBankBankModel

Request body for bank modification.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | The name of the bank. |  [optional] |
|**supportedTradingSymbols** | **List&lt;String&gt;** | The trading symbols supported by the bank. |  [optional] |
|**supportedPayoutSymbols** | [**List&lt;PostSupportedPayoutSymbolsBankModel&gt;**](PostSupportedPayoutSymbolsBankModel.md) | The payout symbols supported by the bank. This is not yet supported and should be nil or empty. |  [optional] |
|**corsAllowedOrigins** | **List&lt;String&gt;** | The list of allowed CORS origin URIs. |  [optional] |




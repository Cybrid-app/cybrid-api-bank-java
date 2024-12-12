

# BankBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the bank. |  |
|**organizationGuid** | **String** | The organization&#39;s identifier. |  |
|**name** | **String** | The bank&#39;s name. |  |
|**type** | **String** | The bank type; one of sandbox or production. |  |
|**supportedTradingSymbols** | **List&lt;String&gt;** | The bank&#39;s list of supported trading symbols. |  [optional] |
|**supportedFiatAccountAssets** | **List&lt;String&gt;** | The bank&#39;s list of supported fiat symbols. |  [optional] |
|**supportedCountryCodes** | **List&lt;String&gt;** | The bank&#39;s list of supported country codes. |  [optional] |
|**features** | **List&lt;String&gt;** | The bank&#39;s enabled features. |  |
|**corsAllowedOrigins** | **List&lt;String&gt;** | The bank&#39;s list of CORS allowed origins. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |




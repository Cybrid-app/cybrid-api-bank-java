

# PostBankBankModel

Request body for bank creation.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The type of bank. |  |
|**name** | **String** | The name of the bank. |  |
|**supportedTradingSymbols** | **List&lt;String&gt;** | The trading symbols supported by the bank. |  |
|**supportedPayoutSymbols** | [**List&lt;PostSupportedPayoutSymbolsBankModel&gt;**](PostSupportedPayoutSymbolsBankModel.md) | The payout symbols supported by the bank. This is not yet supported and should be nil or empty. |  [optional] |
|**supportedFiatAccountAssets** | **List&lt;String&gt;** | The fiat account assets supported by the bank. |  |
|**supportedCountryCodes** | **List&lt;String&gt;** | The country codes supported by the bank. |  |
|**features** | [**List&lt;FeaturesEnum&gt;**](#List&lt;FeaturesEnum&gt;) | The features supported by the bank. |  |
|**corsAllowedOrigins** | **List&lt;String&gt;** | The list of allowed CORS origin URIs. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SANDBOX | &quot;sandbox&quot; |



## Enum: List&lt;FeaturesEnum&gt;

| Name | Value |
|---- | -----|
| ATTESTATION_IDENTITY_RECORDS | &quot;attestation_identity_records&quot; |
| ATTESTATION_IDENTITY_RECORDS_V2 | &quot;attestation_identity_records_v2&quot; |
| KYC_IDENTITY_VERIFICATIONS | &quot;kyc_identity_verifications&quot; |
| BUSINESS_CUSTOMERS | &quot;business_customers&quot; |
| INDIVIDUAL_CUSTOMERS | &quot;individual_customers&quot; |




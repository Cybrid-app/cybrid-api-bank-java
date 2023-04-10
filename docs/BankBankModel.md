

# BankBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the bank. |  |
|**organizationGuid** | **String** | The organization&#39;s identifier. |  |
|**name** | **String** | The bank&#39;s name. |  |
|**type** | [**TypeEnum**](#TypeEnum) | The bank&#39;s type. |  |
|**supportedTradingSymbols** | **List&lt;String&gt;** | The bank&#39;s list of supported trading symbols. |  [optional] |
|**supportedFiatAccountAssets** | **List&lt;String&gt;** | The bank&#39;s list of supported fiat symbols. |  [optional] |
|**supportedCountryCodes** | **List&lt;String&gt;** | The bank&#39;s list of supported country codes. |  [optional] |
|**features** | [**List&lt;FeaturesEnum&gt;**](#List&lt;FeaturesEnum&gt;) | The bank&#39;s enabled features. |  |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the bank was created at. |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SANDBOX | &quot;sandbox&quot; |
| PRODUCTION | &quot;production&quot; |



## Enum: List&lt;FeaturesEnum&gt;

| Name | Value |
|---- | -----|
| ATTESTATION_IDENTITY_RECORDS | &quot;attestation_identity_records&quot; |
| KYC_IDENTITY_VERIFICATIONS | &quot;kyc_identity_verifications&quot; |
| BACKSTOPPED_FUNDING_SOURCE | &quot;backstopped_funding_source&quot; |
| PLAID_FUNDING_SOURCE | &quot;plaid_funding_source&quot; |




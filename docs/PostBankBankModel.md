

# PostBankBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | The bank&#39;s name. |  |
|**type** | [**TypeEnum**](#TypeEnum) | The bank&#39;s type. At present, only **sandbox** is supported. |  |
|**supportedTradingSymbols** | **List&lt;String&gt;** | The bank&#39;s list of supported trading symbols. |  |
|**features** | [**List&lt;FeaturesEnum&gt;**](#List&lt;FeaturesEnum&gt;) | The bank&#39;s enabled features. |  |
|**supportedFiatAccountAssets** | **List&lt;String&gt;** | The bank&#39;s list of supported fiat assets. |  |
|**supportedCountryCodes** | **List&lt;String&gt;** | The bank&#39;s list of supported country codes. |  [optional] |
|**routableAccounts** | [**RoutableAccountsEnum**](#RoutableAccountsEnum) | Configuration for supporting creating routable bank accounts. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SANDBOX | &quot;sandbox&quot; |



## Enum: List&lt;FeaturesEnum&gt;

| Name | Value |
|---- | -----|
| ATTESTATION_IDENTITY_RECORDS | &quot;attestation_identity_records&quot; |
| KYC_IDENTITY_VERIFICATIONS | &quot;kyc_identity_verifications&quot; |



## Enum: RoutableAccountsEnum

| Name | Value |
|---- | -----|
| UNSUPPORTED | &quot;unsupported&quot; |
| BANK | &quot;bank&quot; |
| CUSTOMER | &quot;customer&quot; |




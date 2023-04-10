

# PostWorkflowBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The workflow type. |  |
|**kind** | [**KindEnum**](#KindEnum) | The Plaid workflow kind. |  [optional] |
|**customerGuid** | **String** | The customer identifier associated with the workflow. |  [optional] |
|**externalBankAccountGuid** | **String** | The external bank account identifier associated with the workflow. |  [optional] |
|**language** | [**LanguageEnum**](#LanguageEnum) | The language to initialize Plaid link. |  [optional] |
|**linkCustomizationName** | **String** | The customization name for Plaid link. |  [optional] |
|**redirectUri** | **String** | The redirect URI for Plaid link. |  [optional] |
|**androidPackageName** | **String** | The Android package name for Plaid link. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| PLAID | &quot;plaid&quot; |



## Enum: KindEnum

| Name | Value |
|---- | -----|
| CREATE | &quot;link_token_create&quot; |
| UPDATE | &quot;link_token_update&quot; |



## Enum: LanguageEnum

| Name | Value |
|---- | -----|
| EN | &quot;en&quot; |
| FR | &quot;fr&quot; |
| ES | &quot;es&quot; |
| NL | &quot;nl&quot; |
| DE | &quot;de&quot; |




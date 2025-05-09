

# PostWorkflowBankModel

Request body for workflow creation.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The workflow type. |  |
|**kind** | [**KindEnum**](#KindEnum) | The Plaid workflow kind. Required when type is plaid. |  [optional] |
|**customerGuid** | **String** | The customer identifier associated with the workflow. Optional when type is plaid and kind is link_token_create. |  [optional] |
|**externalBankAccountGuid** | **String** | The external bank account identifier associated with the workflow. Required when type is plaid and kind is link_token_update. |  [optional] |
|**language** | [**LanguageEnum**](#LanguageEnum) | The language to initialize Plaid link. Required when type is plaid. |  [optional] |
|**linkCustomizationName** | **String** | The customization name for Plaid link. For English, use \&quot;default\&quot;. For Spanish, use \&quot;spanish_customization\&quot;. Required when type is plaid. |  [optional] |
|**redirectUri** | **String** | The redirect URI for Plaid link. Optional when type is plaid. |  [optional] |
|**androidPackageName** | **String** | The Android package name for Plaid link. Optional when type is plaid. |  [optional] |



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




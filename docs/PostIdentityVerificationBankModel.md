

# PostIdentityVerificationBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The type of identity verification. |  |
|**method** | [**MethodEnum**](#MethodEnum) | The identity verification method. |  |
|**customerGuid** | **String** | The customer&#39;s identifier. |  [optional] |
|**countryCode** | **String** | The ISO 3166 country 2-Alpha country the customer is being verified in; required when method is set to &#39;id_and_selfie&#39;. If not present, will default to the Bank&#39;s configured country code. |  [optional] |
|**name** | [**PostIdentityVerificationNameBankModel**](PostIdentityVerificationNameBankModel.md) |  |  [optional] |
|**address** | [**PostIdentityVerificationAddressBankModel**](PostIdentityVerificationAddressBankModel.md) |  |  [optional] |
|**dateOfBirth** | **LocalDate** | The customer&#39;s date of birth; required when type is set to &#39;kyc&#39; and method is set to &#39;attested&#39;. |  [optional] |
|**phoneNumber** | **String** | The customer&#39;s phone number. |  [optional] |
|**emailAddress** | **String** | The customer&#39;s email address. |  [optional] |
|**identificationNumbers** | [**List&lt;PostIdentificationNumberBankModel&gt;**](PostIdentificationNumberBankModel.md) | The customer&#39;s identification numbers; required when type is set to &#39;kyc&#39; and method is set to &#39;attested&#39;. |  [optional] |
|**externalBankAccountGuid** | **String** | The external bank account&#39;s identifier. Required for &#39;bank_account&#39; type. |  [optional] |
|**expectedBehaviours** | [**List&lt;ExpectedBehavioursEnum&gt;**](#List&lt;ExpectedBehavioursEnum&gt;) | The optional expected behaviour to simulate. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| KYC | &quot;kyc&quot; |
| BANK_ACCOUNT | &quot;bank_account&quot; |



## Enum: MethodEnum

| Name | Value |
|---- | -----|
| BUSINESS_REGISTRATION | &quot;business_registration&quot; |
| ID_AND_SELFIE | &quot;id_and_selfie&quot; |
| TAX_ID_AND_SELFIE | &quot;tax_id_and_selfie&quot; |
| ATTESTED | &quot;attested&quot; |
| ATTESTED_OWNERSHIP | &quot;attested_ownership&quot; |
| PLAID_IDENTITY_MATCH | &quot;plaid_identity_match&quot; |
| DOCUMENT_SUBMISSION | &quot;document_submission&quot; |



## Enum: List&lt;ExpectedBehavioursEnum&gt;

| Name | Value |
|---- | -----|
| PASSED_IMMEDIATELY | &quot;passed_immediately&quot; |
| FAILED_IMMEDIATELY | &quot;failed_immediately&quot; |
| TAX_ID_NOT_CHECKED | &quot;tax_id_not_checked&quot; |






# PostIdentityVerificationBankModel

Request body for identity verification creation.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The type of identity verification. |  |
|**customerGuid** | **String** | The customer&#39;s identifier. |  [optional] |
|**expectedBehaviours** | [**List&lt;ExpectedBehavioursEnum&gt;**](#List&lt;ExpectedBehavioursEnum&gt;) | The optional expected behaviour to simulate. |  [optional] |
|**method** | [**MethodEnum**](#MethodEnum) | The identity verification method. Required when type is counterparty, type is kyc, or type is bank_account. |  [optional] |
|**counterpartyGuid** | **String** | The counterparty&#39;s identifier. Required when type is counterparty. |  [optional] |
|**countryCode** | **String** | The ISO 3166 country 2-Alpha country the customer is being verified in. If not present, will default to the Bank&#39;s configured country code. Optional when type is kyc and method is id_and_selfie, type is kyc and method is tax_id_and_selfie, or type is kyc and method is business_registration. |  [optional] |
|**name** | [**PostIdentityVerificationNameBankModel**](PostIdentityVerificationNameBankModel.md) |  |  [optional] |
|**address** | [**PostIdentityVerificationAddressBankModel**](PostIdentityVerificationAddressBankModel.md) |  |  [optional] |
|**dateOfBirth** | **LocalDate** | The customer&#39;s date of birth. Required when type is kyc and method is attested. |  [optional] |
|**identificationNumbers** | [**List&lt;PostIdentificationNumberBankModel&gt;**](PostIdentificationNumberBankModel.md) | The customer&#39;s identification numbers. Required when type is kyc and method is attested. |  [optional] |
|**externalBankAccountGuid** | **String** | The external bank account&#39;s identifier. Required when type is bank_account. |  [optional] |
|**phoneNumber** | **String** | The customer&#39;s phone number. Optional when type is bank_account and method is attested_ownership. |  [optional] |
|**emailAddress** | **String** | The customer&#39;s email address. Optional when type is bank_account and method is attested_ownership. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| KYC | &quot;kyc&quot; |
| BANK_ACCOUNT | &quot;bank_account&quot; |
| COUNTERPARTY | &quot;counterparty&quot; |



## Enum: List&lt;ExpectedBehavioursEnum&gt;

| Name | Value |
|---- | -----|
| PASSED_IMMEDIATELY | &quot;passed_immediately&quot; |
| FAILED_IMMEDIATELY | &quot;failed_immediately&quot; |
| TAX_ID_NOT_CHECKED | &quot;tax_id_not_checked&quot; |



## Enum: MethodEnum

| Name | Value |
|---- | -----|
| WATCHLISTS | &quot;watchlists&quot; |
| ATTESTED | &quot;attested&quot; |
| DOCUMENT_SUBMISSION | &quot;document_submission&quot; |
| ID_AND_SELFIE | &quot;id_and_selfie&quot; |
| TAX_ID_AND_SELFIE | &quot;tax_id_and_selfie&quot; |
| BUSINESS_REGISTRATION | &quot;business_registration&quot; |
| ATTESTED_OWNERSHIP | &quot;attested_ownership&quot; |
| ACCOUNT_OWNERSHIP | &quot;account_ownership&quot; |




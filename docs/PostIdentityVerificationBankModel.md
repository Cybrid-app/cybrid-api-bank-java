

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
|**dateOfBirth** | **LocalDate** | The customer&#39;s date of birth; required when method is set to &#39;attested&#39;. |  [optional] |
|**identificationNumbers** | [**List&lt;PostIdentificationNumberBankModel&gt;**](PostIdentificationNumberBankModel.md) | The customer&#39;s identification numbers; required when method is set to &#39;attested&#39;. |  [optional] |
|**expectedBehaviours** | [**List&lt;ExpectedBehavioursEnum&gt;**](#List&lt;ExpectedBehavioursEnum&gt;) | The optional expected behaviour to simulate. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| KYC | &quot;kyc&quot; |



## Enum: MethodEnum

| Name | Value |
|---- | -----|
| ID_AND_SELFIE | &quot;id_and_selfie&quot; |
| ATTESTED | &quot;attested&quot; |



## Enum: List&lt;ExpectedBehavioursEnum&gt;

| Name | Value |
|---- | -----|
| PASSED_IMMEDIATELY | &quot;passed_immediately&quot; |
| FAILED_IMMEDIATELY | &quot;failed_immediately&quot; |



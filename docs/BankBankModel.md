

# BankBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**guid** | **String** | Auto-generated unique identifier for the bank. | 
**organizationGuid** | **String** | The organization&#39;s identifier. | 
**name** | **String** | The bank&#39;s name. | 
**type** | [**TypeEnum**](#TypeEnum) | The bank&#39;s type. | 
**features** | [**List&lt;FeaturesEnum&gt;**](#List&lt;FeaturesEnum&gt;) | The bank&#39;s enabled features. | 
**createdAt** | **OffsetDateTime** | ISO8601 datetime the bank was created at. | 



## Enum: TypeEnum

Name | Value
---- | -----
SANDBOX | &quot;sandbox&quot;



## Enum: List&lt;FeaturesEnum&gt;

Name | Value
---- | -----
ATTESTATION_IDENTITY_RECORDS | &quot;attestation_identity_records&quot;
BACKSTOPPED_FUNDING_SOURCE | &quot;backstopped_funding_source&quot;




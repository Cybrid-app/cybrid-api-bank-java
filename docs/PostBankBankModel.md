

# PostBankBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | The bank&#39;s name. | 
**type** | [**TypeEnum**](#TypeEnum) | The bank&#39;s type. At present, only **sandbox** is supported. | 
**features** | [**List&lt;FeaturesEnum&gt;**](#List&lt;FeaturesEnum&gt;) | The bank&#39;s enabled features. At present, both **attestation_identity_records** and **backstopped_funding_source** must be set. | 



## Enum: TypeEnum

Name | Value
---- | -----
SANDBOX | &quot;sandbox&quot;



## Enum: List&lt;FeaturesEnum&gt;

Name | Value
---- | -----
ATTESTATION_IDENTITY_RECORDS | &quot;attestation_identity_records&quot;
BACKSTOPPED_FUNDING_SOURCE | &quot;backstopped_funding_source&quot;




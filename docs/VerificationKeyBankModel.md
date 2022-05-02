

# VerificationKeyBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**guid** | **String** | Auto-generated unique identifier for the verification key. |  [optional]
**bankGuid** | **String** | The banks&#39;s identifier. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | The verification key&#39;s type. |  [optional]
**state** | [**StateEnum**](#StateEnum) | The verification key&#39;s state. |  [optional]
**algorithm** | [**AlgorithmEnum**](#AlgorithmEnum) | The verification key&#39;s algorithm. |  [optional]
**fingerprint** | **String** | The verification key&#39;s cryptographic fingerprint. |  [optional]
**createdAt** | **OffsetDateTime** | ISO8601 datetime the verification key was created at. |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
ATTESTATION | &quot;attestation&quot;



## Enum: StateEnum

Name | Value
---- | -----
STORING | &quot;storing&quot;
PENDING | &quot;pending&quot;
VERIFIED | &quot;verified&quot;
FAILED | &quot;failed&quot;



## Enum: AlgorithmEnum

Name | Value
---- | -----
RS512 | &quot;RS512&quot;




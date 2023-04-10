

# AttestationDetailsBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**state** | [**StateEnum**](#StateEnum) | The state of an identity record attestation |  [optional] |
|**failureCode** | [**FailureCodeEnum**](#FailureCodeEnum) | The failure code of an identity record attestation (if any) |  [optional] |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| EXPIRED | &quot;expired&quot; |
| VERIFIED | &quot;verified&quot; |
| FAILED | &quot;failed&quot; |



## Enum: FailureCodeEnum

| Name | Value |
|---- | -----|
| INVALID_KEY | &quot;invalid_key&quot; |
| INVALID_ALGORITHM | &quot;invalid_algorithm&quot; |
| INVALID_SIGNATURE | &quot;invalid_signature&quot; |
| INVALID_ISSUER | &quot;invalid_issuer&quot; |
| INVALID_AUDIENCE | &quot;invalid_audience&quot; |
| INVALID_SUBJECT | &quot;invalid_subject&quot; |
| JWT_EXPIRED | &quot;jwt_expired&quot; |
| MISSING_JTI | &quot;missing_jti&quot; |
| MISSING_KEYID | &quot;missing_keyid&quot; |




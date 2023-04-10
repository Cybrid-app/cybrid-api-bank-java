

# IdentityRecordBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the identity record. |  [optional] |
|**customerGuid** | **String** | The customer&#39;s identifier. |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The identity record&#39;s type. |  [optional] |
|**attestationDetails** | [**AttestationDetailsBankModel**](AttestationDetailsBankModel.md) |  |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**expiredAt** | **OffsetDateTime** | ISO8601 datetime the record is expired at. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| ATTESTATION | &quot;attestation&quot; |




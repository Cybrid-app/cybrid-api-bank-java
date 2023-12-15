

# IdentityVerificationWithDetailsBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the identity verification. |  [optional] |
|**customerGuid** | **String** | The identity verification&#39;s identifier. |  [optional] |
|**type** | **String** | The identity verification type; one of kyc or bank_account. |  [optional] |
|**method** | **String** | The identity verification method; one of business_registration, id_and_selfie, attested, plaid_identity_match, or document_submission. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |
|**state** | **String** | The identity verification state; one of storing, waiting, expired, or completed. |  [optional] |
|**outcome** | **String** | The identity verification outcome; one of passed or failed. |  [optional] |
|**failureCodes** | **List&lt;String&gt;** | The reason codes explaining the outcome. |  [optional] |
|**personaInquiryId** | **String** | The Persona identifier of the backing inquiry. |  [optional] |
|**personaState** | **String** | The Persona state of the backing inquiry; one of waiting, pending, reviewing, processing, expired, completed, or unknown. |  [optional] |
|**externalBankAccountGuid** | **String** | The external bank account&#39;s identifier. |  [optional] |




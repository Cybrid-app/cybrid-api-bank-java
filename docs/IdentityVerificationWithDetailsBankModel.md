

# IdentityVerificationWithDetailsBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the identity verification. |  [optional] |
|**type** | **String** | The identity verification type; one of kyc, bank_account, or counterparty. |  [optional] |
|**method** | **String** | The identity verification method; one of attested, document_submission, id_and_selfie, tax_id_and_selfie, business_registration, attested_id_and_selfie, attested_business_registration, watchlists, attested_ownership, or account_ownership. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |
|**customerGuid** | **String** | The identity verification&#39;s identifier. |  [optional] |
|**counterpartyGuid** | **String** | The identity verification&#39;s identifier. |  [optional] |
|**externalBankAccountGuid** | **String** | The identity verification&#39;s identifier. |  [optional] |
|**state** | **String** | The identity verification state; one of storing, waiting, pending, reviewing, expired, or completed. |  [optional] |
|**outcome** | **String** | The identity verification outcome; one of passed or failed. |  [optional] |
|**failureCodes** | **List&lt;String&gt;** | The reason codes explaining the outcome. |  [optional] |
|**complianceChecks** | [**List&lt;ComplianceCheckBankModel&gt;**](ComplianceCheckBankModel.md) | The compliance checks associated with the identity verification. |  [optional] |
|**complianceDecisions** | [**List&lt;ComplianceDecisionBankModel&gt;**](ComplianceDecisionBankModel.md) | The compliance decisions associated with the identity verification. |  [optional] |
|**personaInquiryId** | **String** | The Persona identifier of the backing inquiry. |  [optional] |
|**personaState** | **String** | The Persona state of the backing inquiry; one of waiting, pending, reviewing, processing, expired, completed, or unknown. |  [optional] |
|**pii** | [**IdentityVerificationWithDetailsPiiBankModel**](IdentityVerificationWithDetailsPiiBankModel.md) |  |  [optional] |
|**documents** | [**List&lt;IdentityVerificationDocumentBankModel&gt;**](IdentityVerificationDocumentBankModel.md) | The documents associated with the identity verification. |  [optional] |




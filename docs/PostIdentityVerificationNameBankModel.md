

# PostIdentityVerificationNameBankModel

The customer's name. Required when type is kyc and method is attested, type is kyc and method is attested_business_registration, type is kyc and method is attested_id_and_selfie, or type is bank_account and method is attested_ownership.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**first** | **String** | The customer&#39;s first name. Required when type is kyc and method is attested or type is kyc and method is attested_id_and_selfie. Optional when type is bank_account and method is attested_ownership. |  [optional] |
|**middle** | **String** | The customer&#39;s middle name. Optional when type is kyc and method is attested, type is kyc and method is attested_id_and_selfie, or type is bank_account and method is attested_ownership. |  [optional] |
|**last** | **String** | The customer&#39;s last name. Required when type is kyc and method is attested or type is kyc and method is attested_id_and_selfie. Optional when type is bank_account and method is attested_ownership. |  [optional] |
|**full** | **String** | The customer&#39;s full name. Required when type is kyc and method is attested_business_registration or type is bank_account and method is attested_ownership. Optional when type is kyc and method is attested or type is kyc and method is attested_id_and_selfie. |  [optional] |




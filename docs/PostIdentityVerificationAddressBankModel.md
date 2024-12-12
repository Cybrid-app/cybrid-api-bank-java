

# PostIdentityVerificationAddressBankModel

The customer's address. Required when type is kyc and method is attested or type is bank_account and method is attested_ownership.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**street** | **String** | The first line of the address. Required when type is kyc and method is attested or type is bank_account and method is attested_ownership. |  [optional] |
|**street2** | **String** | The optional second line of the address. Optional when type is kyc and method is attested or type is bank_account and method is attested_ownership. |  [optional] |
|**city** | **String** | The city of the address. Required when type is kyc and method is attested or type is bank_account and method is attested_ownership. |  [optional] |
|**subdivision** | **String** | The ISO 3166-2 subdivision code of the address. Applicable only for countries that use subnational states, provinces, lands, oblasts or regions. Optional when type is kyc and method is attested or type is bank_account and method is attested_ownership. |  [optional] |
|**postalCode** | **String** | The postal, zip or post code of the address. Applicable only for countries that use postal, zip or post codes. Optional when type is kyc and method is attested or type is bank_account and method is attested_ownership. |  [optional] |
|**countryCode** | **String** | The ISO 3166 country 2-Alpha country code of the address. Required when type is kyc and method is attested or type is bank_account and method is attested_ownership. |  [optional] |




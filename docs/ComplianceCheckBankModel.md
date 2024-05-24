

# ComplianceCheckBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** | The type of compliance check; one of business_watchlists, business_verification, business_tax_id_verification, person_attested, person_tax_id_attested, person_watchlists, person_verification, person_authentication, person_gov_id_verification, person_tax_id_verification, external_bank_account_verification, or external_bank_account_attested. |  |
|**outcome** | **String** | The outcome of the compliance check; one of passed, failed, or inconclusive. |  |
|**failureCodes** | **List&lt;String&gt;** | The reason codes explaining the outcome. |  [optional] |




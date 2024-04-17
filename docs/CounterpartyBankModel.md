

# CounterpartyBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the counterparty. |  [optional] |
|**type** | **String** | The counterparty type; one of business or individual. |  [optional] |
|**bankGuid** | **String** | Auto-generated unique identifier for the counterparty&#39;s bank. |  [optional] |
|**customerGuid** | **String** | Auto-generated unique identifier for the counterparty&#39;s customer. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |
|**state** | **String** | The counterparty state; one of storing, unverified, verified, or rejected. |  [optional] |
|**name** | [**CounterpartyNameBankModel**](CounterpartyNameBankModel.md) |  |  [optional] |
|**address** | [**CounterpartyAddressBankModel**](CounterpartyAddressBankModel.md) |  |  [optional] |
|**aliases** | [**List&lt;CounterpartyAliasesInnerBankModel&gt;**](CounterpartyAliasesInnerBankModel.md) | The counterparty&#39;s aliases. Only available for GET operations when &#39;include_pii&#39; is set. |  [optional] |
|**dateOfBirth** | **LocalDate** | The counterparty&#39;s DOB. Only available for GET operations when &#39;include_pii&#39; is set. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the customer. |  [optional] |
|**verificationChecks** | [**List&lt;VerificationCheckBankModel&gt;**](VerificationCheckBankModel.md) | The verification checks associated with the customer. |  [optional] |




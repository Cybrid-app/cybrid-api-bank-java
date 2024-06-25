

# CustomerBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the customer. |  [optional] |
|**bankGuid** | **String** | Auto-generated unique identifier for the customer&#39;s bank. |  [optional] |
|**type** | **String** | The customer type; one of business or individual. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |
|**state** | **String** | The customer state; one of storing, unverified, verified, rejected, or frozen. |  [optional] |
|**name** | [**CustomerNameBankModel**](CustomerNameBankModel.md) |  |  [optional] |
|**address** | [**CustomerAddressBankModel**](CustomerAddressBankModel.md) |  |  [optional] |
|**aliases** | [**List&lt;CustomerAliasesInnerBankModel&gt;**](CustomerAliasesInnerBankModel.md) | The customer&#39;s aliases. Only available for GET operations when &#39;include_pii&#39; is set. |  [optional] |
|**website** | **String** | The customer&#39;s website. Only available for GET operations when &#39;include_pii&#39; is set. |  [optional] |
|**dateOfBirth** | **LocalDate** | The customer&#39;s DOB. Only available for GET operations when &#39;include_pii&#39; is set. |  [optional] |
|**phoneNumber** | **String** | The customer&#39;s phone number. Only available for GET operations when &#39;include_pii&#39; is set. |  [optional] |
|**emailAddress** | **String** | The customer&#39;s email address. Only available for GET operations when &#39;include_pii&#39; is set. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the customer. |  [optional] |
|**complianceDecisions** | [**List&lt;ComplianceDecisionBankModel&gt;**](ComplianceDecisionBankModel.md) | The compliance decisions associated with the customer. |  [optional] |
|**identificationNumbers** | [**List&lt;IdentificationNumberBankModel&gt;**](IdentificationNumberBankModel.md) | The customer&#39;s identification numbers. Only available for GET operations when &#39;include_pii&#39; is set and bank has access. |  [optional] |
|**activityLimits** | [**List&lt;ActivityLimitBankModel&gt;**](ActivityLimitBankModel.md) | The asset limits associated with the customer. |  [optional] |




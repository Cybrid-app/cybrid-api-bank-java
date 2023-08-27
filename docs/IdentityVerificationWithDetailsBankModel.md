

# IdentityVerificationWithDetailsBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the identity verification. |  [optional] |
|**customerGuid** | **String** | The customer&#39;s identifier. |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of identity verification. |  [optional] |
|**method** | [**MethodEnum**](#MethodEnum) | The identity verification method. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the customer was created at. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The state of the verification process. |  [optional] |
|**outcome** | [**OutcomeEnum**](#OutcomeEnum) | The outcome of the verification process. |  [optional] |
|**failureCodes** | [**List&lt;FailureCodesEnum&gt;**](#List&lt;FailureCodesEnum&gt;) | The reason codes explaining the outcome. |  [optional] |
|**personaInquiryId** | **String** | The Persona identifier of the backing inquiry. |  [optional] |
|**personaState** | [**PersonaStateEnum**](#PersonaStateEnum) | The Persona state of the backing inquiry. |  [optional] |
|**externalBankAccountGuid** | **String** | The external bank account&#39;s identifier. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| KYC | &quot;kyc&quot; |
| BANK_ACCOUNT | &quot;bank_account&quot; |



## Enum: MethodEnum

| Name | Value |
|---- | -----|
| ID_AND_SELFIE | &quot;id_and_selfie&quot; |
| ATTESTED | &quot;attested&quot; |
| PLAID_IDENTITY_MATCH | &quot;plaid_identity_match&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| WAITING | &quot;waiting&quot; |
| EXPIRED | &quot;expired&quot; |
| COMPLETED | &quot;completed&quot; |



## Enum: OutcomeEnum

| Name | Value |
|---- | -----|
| PASSED | &quot;passed&quot; |
| FAILED | &quot;failed&quot; |



## Enum: List&lt;FailureCodesEnum&gt;

| Name | Value |
|---- | -----|
| REQUESTED_FAILURE | &quot;requested_failure&quot; |
| ID_CHECK_FAILURE | &quot;id_check_failure&quot; |
| DATABASE_CHECK_FAILURE | &quot;database_check_failure&quot; |
| SELFIE_FAILURE | &quot;selfie_failure&quot; |
| PEP_CHECK_FAILURE | &quot;pep_check_failure&quot; |
| WATCHLIST_CHECK_FAILURE | &quot;watchlist_check_failure&quot; |
| NAME_CHECK_FAILURE | &quot;name_check_failure&quot; |
| ADDRESS_CHECK_FAILURE | &quot;address_check_failure&quot; |
| DOB_CHECK_FAILURE | &quot;dob_check_failure&quot; |
| ID_NUMBER_CHECK_FAILURE | &quot;id_number_check_failure&quot; |
| PHONE_NUMBER_CHECK_FAILURE | &quot;phone_number_check_failure&quot; |
| EMAIL_ADDRESS_CHECK_FAILURE | &quot;email_address_check_failure&quot; |
| DECISION_TIMEOUT | &quot;decision_timeout&quot; |
| PLAID_FAILURE | &quot;plaid_failure&quot; |



## Enum: PersonaStateEnum

| Name | Value |
|---- | -----|
| WAITING | &quot;waiting&quot; |
| PENDING | &quot;pending&quot; |
| REVIEWING | &quot;reviewing&quot; |
| PROCESSING | &quot;processing&quot; |
| EXPIRED | &quot;expired&quot; |
| COMPLETED | &quot;completed&quot; |
| UNKNOWN | &quot;unknown&quot; |




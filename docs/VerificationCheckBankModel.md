

# VerificationCheckBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The type of verification check. |  |
|**state** | [**StateEnum**](#StateEnum) | The state of the verification check. |  |
|**failureCodes** | **List&lt;String&gt;** | The reason codes explaining the outcome. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BUSINESS_WATCHLISTS | &quot;business_watchlists&quot; |
| BUSINESS_VERIFICATION | &quot;business_verification&quot; |
| BUSINESS_TAX_ID_VERIFICATION | &quot;business_tax_id_verification&quot; |
| PERSON_ATTESTED | &quot;person_attested&quot; |
| PERSON_TAX_ID_ATTESTED | &quot;person_tax_id_attested&quot; |
| PERSON_WATCHLISTS | &quot;person_watchlists&quot; |
| PERSON_VERIFICATION | &quot;person_verification&quot; |
| PERSON_AUTHENTICATION | &quot;person_authentication&quot; |
| PERSON_GOV_ID_VERIFICATION | &quot;person_gov_id_verification&quot; |
| PERSON_TAX_ID_VERIFICATION | &quot;person_tax_id_verification&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| PASSED | &quot;passed&quot; |
| FAILED | &quot;failed&quot; |
| EXPIRED | &quot;expired&quot; |
| INVALIDATED | &quot;invalidated&quot; |




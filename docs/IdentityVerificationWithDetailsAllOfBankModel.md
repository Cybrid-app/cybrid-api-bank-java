

# IdentityVerificationWithDetailsAllOfBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**personaInquiryId** | **String** | The Persona identifier of the backing inquiry. |  [optional] |
|**personaState** | [**PersonaStateEnum**](#PersonaStateEnum) | The Persona state of the backing inquiry. |  [optional] |
|**externalBankAccountGuid** | **String** | The external bank account&#39;s identifier. |  [optional] |



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




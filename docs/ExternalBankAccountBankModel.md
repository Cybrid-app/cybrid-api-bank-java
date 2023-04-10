

# ExternalBankAccountBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the account. |  [optional] |
|**name** | **String** | The name of the account. |  [optional] |
|**asset** | **String** | The asset code. |  [optional] |
|**accountKind** | [**AccountKindEnum**](#AccountKindEnum) | The type of account. |  [optional] |
|**environment** | [**EnvironmentEnum**](#EnvironmentEnum) | The environment that the external bank account is operating in. |  [optional] |
|**bankGuid** | **String** | The bank identifier. |  [optional] |
|**customerGuid** | **String** | The customer identifier. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the exchange was created at. |  [optional] |
|**plaidInstitutionId** | **String** | The Plaid institution ID for the account. |  [optional] |
|**plaidAccountMask** | **String** | The account number mask for the account. |  [optional] |
|**plaidAccountName** | **String** | The name for the account. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The state of the external bank account. |  [optional] |
|**failureCode** | **String** | The failure code for failed transfers. |  [optional] |



## Enum: AccountKindEnum

| Name | Value |
|---- | -----|
| PLAID | &quot;plaid&quot; |
| PLAID_PROCESSOR_TOKEN | &quot;plaid_processor_token&quot; |



## Enum: EnvironmentEnum

| Name | Value |
|---- | -----|
| SANDBOX | &quot;sandbox&quot; |
| PRODUCTION | &quot;production&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| COMPLETED | &quot;completed&quot; |
| FAILED | &quot;failed&quot; |
| REFRESH_REQUIRED | &quot;refresh_required&quot; |
| DELETING | &quot;deleting&quot; |
| DELETED | &quot;deleted&quot; |




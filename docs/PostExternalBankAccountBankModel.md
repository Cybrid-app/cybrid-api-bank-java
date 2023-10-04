

# PostExternalBankAccountBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | The name of the account. |  |
|**accountKind** | [**AccountKindEnum**](#AccountKindEnum) | The account type |  |
|**customerGuid** | **String** | The customer identifier. |  [optional] |
|**asset** | **String** | The asset code. If not set will try and default to the Bank&#39;s configured fiat asset. |  |
|**plaidPublicToken** | **String** | The public token for the account. Required for &#39;plaid&#39; accounts. |  [optional] |
|**plaidAccountId** | **String** | The account identifier in plaid. Required for &#39;plaid&#39; accounts. |  [optional] |
|**plaidProcessorToken** | **String** | The Plaid processor token used to access the account. Required for &#39;plaid_processor_token&#39; accounts. |  [optional] |
|**plaidInstitutionId** | **String** | Plaid&#39;s institution ID for the account&#39;s institution. Required for &#39;plaid_processor_token&#39; accounts. |  [optional] |
|**plaidAccountMask** | **String** | The account mask for the account. Required for &#39;plaid_processor_token&#39; accounts. |  [optional] |
|**plaidAccountName** | **String** | The name of the account. Required for &#39;plaid_processor_token&#39; accounts. |  [optional] |
|**counterpartyBankAccount** | [**PostExternalBankAccountCounterpartyBankAccountBankModel**](PostExternalBankAccountCounterpartyBankAccountBankModel.md) |  |  [optional] |
|**counterpartyName** | [**PostExternalBankAccountCounterpartyNameBankModel**](PostExternalBankAccountCounterpartyNameBankModel.md) |  |  [optional] |
|**counterpartyAddress** | [**PostExternalBankAccountCounterpartyAddressBankModel**](PostExternalBankAccountCounterpartyAddressBankModel.md) |  |  [optional] |
|**counterpartyEmailAddress** | **String** | The counterparty&#39;s email address on the account. |  [optional] |



## Enum: AccountKindEnum

| Name | Value |
|---- | -----|
| PLAID | &quot;plaid&quot; |
| PLAID_PROCESSOR_TOKEN | &quot;plaid_processor_token&quot; |
| RAW_ROUTING_DETAILS | &quot;raw_routing_details&quot; |




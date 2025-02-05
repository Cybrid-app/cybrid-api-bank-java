

# PostSupportedPayoutSymbolsBankModel

Supported payout symbols details.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**primaryAsset** | **String** | The primary asset of the payout symbol, e.g., MXN. |  |
|**counterAsset** | **String** | The counter asset of the payout symbol, e.g., USD. |  |
|**countryCode** | **String** | The ISO 3166 country 2-Alpha country code is permitted in, e.g., MX. |  |
|**participantsType** | [**ParticipantsTypeEnum**](#ParticipantsTypeEnum) | The participants the symbol is permitted for. |  |
|**route** | [**RouteEnum**](#RouteEnum) | The route the symbol is permitted for. |  |



## Enum: ParticipantsTypeEnum

| Name | Value |
|---- | -----|
| C2C | &quot;C2C&quot; |
| C2B | &quot;C2B&quot; |
| B2C | &quot;B2C&quot; |
| B2B | &quot;B2B&quot; |



## Enum: RouteEnum

| Name | Value |
|---- | -----|
| BANK_ACCOUNT | &quot;bank_account&quot; |
| MOBILE_WALLET | &quot;mobile_wallet&quot; |




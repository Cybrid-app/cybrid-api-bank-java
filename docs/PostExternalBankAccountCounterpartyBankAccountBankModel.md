

# PostExternalBankAccountCounterpartyBankAccountBankModel

The counterparty's checking bank account information. Required when account_kind is raw_routing_details.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**routingNumberType** | [**RoutingNumberTypeEnum**](#RoutingNumberTypeEnum) | The type of routing number. Required when account_kind is raw_routing_details. |  [optional] |
|**routingNumber** | **String** | The routing number. Required when account_kind is raw_routing_details. |  [optional] |
|**accountNumber** | **String** | The account number. Required when account_kind is raw_routing_details. |  [optional] |



## Enum: RoutingNumberTypeEnum

| Name | Value |
|---- | -----|
| CPA | &quot;CPA&quot; |
| ABA | &quot;ABA&quot; |




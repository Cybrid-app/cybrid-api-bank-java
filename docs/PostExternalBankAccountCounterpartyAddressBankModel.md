

# PostExternalBankAccountCounterpartyAddressBankModel

The counterparty's address on their checking account. Required when account_kind is raw_routing_details and counterparty_guid is not present.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**street** | **String** | The first line of the address. Required when account_kind is raw_routing_details and counterparty_guid is not present. |  [optional] |
|**street2** | **String** | The optional second line of the address. Optional when account_kind is raw_routing_details and counterparty_guid is not present. |  [optional] |
|**city** | **String** | The city of the address. Required when account_kind is raw_routing_details and counterparty_guid is not present. |  [optional] |
|**subdivision** | **String** | The ISO 3166-2 subdivision code of the address; not used by all countries. Optional when account_kind is raw_routing_details and counterparty_guid is not present. |  [optional] |
|**postalCode** | **String** | The postal/post/zip code of the address; not used by all countries. Optional when account_kind is raw_routing_details and counterparty_guid is not present. |  [optional] |
|**countryCode** | **String** | The ISO 3166 country 2-Alpha country code of the address. Required when account_kind is raw_routing_details and counterparty_guid is not present. |  [optional] |




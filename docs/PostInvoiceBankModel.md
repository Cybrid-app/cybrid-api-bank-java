

# PostInvoiceBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**asset** | **String** | The asset code the customer will receive the funds in. |  |
|**customerGuid** | **String** | The unique identifier for the customer. |  [optional] |
|**receiveAmount** | **java.math.BigInteger** | The amount to be received in base units of the asset, i.e., the amount the customer will receive after fees. ONLY one of receive_amount or deliver_amount is required. |  [optional] |
|**deliverAmount** | **java.math.BigInteger** | The amount to be delivered in base units of the asset, i.e., the amount the customer will receive before fees. ONLY one of receive_amount or deliver_amount is required. |  [optional] |
|**accountGuid** | **String** | The identifier for the account to use for the transfer. Required if the customer has multiple fiat accounts. Currently only valid for invoices paid to a fiat account. |  [optional] |
|**labels** | **List&lt;String&gt;** | The labels associated with the customer. |  [optional] |






# PostFeeBankModel

Request body for fee creation.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The fee&#39;s type |  |
|**spreadFee** | **java.math.BigInteger** | The percentage amount, in basis points, to apply when charging a fee. Required when type is spread. |  [optional] |
|**fixedFee** | **java.math.BigInteger** | The fixed amount to apply when charging a fee; for trades, the fiat asset is used. Required when type is fixed. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SPREAD | &quot;spread&quot; |
| FIXED | &quot;fixed&quot; |




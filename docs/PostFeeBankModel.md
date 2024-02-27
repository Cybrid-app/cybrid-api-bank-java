

# PostFeeBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The fee&#39;s type |  |
|**spreadFee** | **java.math.BigInteger** | The percentage amount, in basis points, to apply when charging a fee. |  [optional] |
|**fixedFee** | **java.math.BigInteger** | The fixed amount to apply when charging a fee; for trades, the fiat asset is used. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SPREAD | &quot;spread&quot; |
| FIXED | &quot;fixed&quot; |






# FeeBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) | The fee&#39;s type |  [optional]
**spreadFee** | **java.math.BigInteger** | The percentage amount, in basis points, to apply when charging a fee. |  [optional]
**fixedFee** | **java.math.BigInteger** | The fixed amount, in the currency of the parent trading configuration, to apply when charging a fee. |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
SPREAD | &quot;spread&quot;
FIXED | &quot;fixed&quot;




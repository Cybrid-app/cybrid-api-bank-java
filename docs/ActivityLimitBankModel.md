

# ActivityLimitBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** | The type of the limit; one of rolling, daily, weekly, or monthly. |  [optional] |
|**name** | **String** | The name of the limit. |  [optional] |
|**asset** | **String** | The asset code for the limit. |  [optional] |
|**amount** | **java.math.BigInteger** | The limit amount for the asset. |  [optional] |
|**interval** | **java.math.BigInteger** | The limit interval in seconds for the asset. |  [optional] |
|**activities** | **List&lt;String&gt;** | The activities associated with the limit. |  [optional] |
|**sides** | **List&lt;String&gt;** | The sides associated with the limit. |  [optional] |




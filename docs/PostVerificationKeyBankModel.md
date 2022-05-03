

# PostVerificationKeyBankModel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) | The verification key&#39;s type. | 
**algorithm** | [**AlgorithmEnum**](#AlgorithmEnum) | The verification key&#39;s algorithm. | 
**publicKey** | **String** | DER encoded public key in Base64 format. | 
**nonce** | **String** | Value signed in the **signature** field. | 
**signature** | **String** | Signature on **nonce** using PKCS1v15 padding and the SHA512 hashing algorithm in Base64 format. | 



## Enum: TypeEnum

Name | Value
---- | -----
ATTESTATION | &quot;attestation&quot;



## Enum: AlgorithmEnum

Name | Value
---- | -----
RS512 | &quot;RS512&quot;




# VerificationKeysBankApi

All URIs are relative to *https://bank.demo.cybrid.app*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createVerificationKey**](VerificationKeysBankApi.md#createVerificationKey) | **POST** /api/bank_verification_keys | Create VerificationKey
[**getVerificationKey**](VerificationKeysBankApi.md#getVerificationKey) | **GET** /api/bank_verification_keys/{verification_key_guid} | Get VerificationKey
[**listVerificationKeys**](VerificationKeysBankApi.md#listVerificationKeys) | **GET** /api/bank_verification_keys | Get Verification Keys list



## createVerificationKey

> VerificationKeyBankModel createVerificationKey(postVerificationKeyBankModel)

Create VerificationKey

Creates a verification key.   Example code (python) for generating a Verification Key  &#x60;&#x60;&#x60;python import base64  from cryptography.hazmat.primitives import hashes from cryptography.hazmat.primitives import serialization from cryptography.hazmat.primitives.asymmetric import padding from cryptography.hazmat.primitives.asymmetric import rsa  nonce &#x3D; \&quot;wen moon\&quot; private_key &#x3D; rsa.generate_private_key(public_exponent&#x3D;65537, key_size&#x3D;2048) signature &#x3D; base64.b64encode(private_key.sign(     data&#x3D;nonce.encode(&#39;ascii&#39;), padding&#x3D;padding.PKCS1v15(), algorithm&#x3D;hashes.SHA512())).decode(&#39;ascii&#39;) public_key &#x3D; base64.b64encode(private_key.public_key().public_bytes(     encoding&#x3D;serialization.Encoding.DER, format&#x3D;serialization.PublicFormat.SubjectPublicKeyInfo)).decode(&#39;ascii&#39;)  ### DISCLAIMER:- Since NO ENCRYPTION is used in the key storage/formatting. Please DO NOT use this code in production environment. private_pem &#x3D; private_key.private_bytes(encoding&#x3D;serialization.Encoding.PEM, format&#x3D;serialization.PrivateFormat.TraditionalOpenSSL,        encryption_algorithm&#x3D;serialization.NoEncryption())  ## Store the private_key in a file verification_key.pem with open (\&quot;verification_key.pem\&quot;, &#39;wb&#39;) as pem_out:    pem_out.write(private_pem)    pem_out.close()  print(\&quot;Public Key: \&quot;, public_key) print(\&quot;Signature: \&quot;, signature)  &#x60;&#x60;&#x60;&#x60;  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the verification in our private key store | | pending | The Platform is verifying the verification key&#39;s signature | | verified | The Platform has verified the verification key&#39;s signature and the key can be used | | failed | The Platform was not able to verify the verification key&#39;s signature and the key cannot be used |    Required scope: **banks:write**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.VerificationKeysBankApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://bank.demo.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        VerificationKeysBankApi apiInstance = new VerificationKeysBankApi(defaultClient);
        PostVerificationKeyBankModel postVerificationKeyBankModel = new PostVerificationKeyBankModel(); // PostVerificationKeyBankModel | 
        try {
            VerificationKeyBankModel result = apiInstance.createVerificationKey(postVerificationKeyBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling VerificationKeysBankApi#createVerificationKey");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postVerificationKeyBankModel** | [**PostVerificationKeyBankModel**](PostVerificationKeyBankModel.md)|  |

### Return type

[**VerificationKeyBankModel**](VerificationKeyBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | verification key created |  -  |
| **400** | Invalid requests - malformed authentication header |  -  |
| **401** | Unauthorized - Authentication failed, invalid subject |  -  |
| **403** | Invalid scope |  -  |


## getVerificationKey

> VerificationKeyBankModel getVerificationKey(verificationKeyGuid)

Get VerificationKey

Retrieves a verification key.  Required scope: **banks:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.VerificationKeysBankApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://bank.demo.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        VerificationKeysBankApi apiInstance = new VerificationKeysBankApi(defaultClient);
        String verificationKeyGuid = "verificationKeyGuid_example"; // String | Identifier for the verification key.
        try {
            VerificationKeyBankModel result = apiInstance.getVerificationKey(verificationKeyGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling VerificationKeysBankApi#getVerificationKey");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **verificationKeyGuid** | **String**| Identifier for the verification key. |

### Return type

[**VerificationKeyBankModel**](VerificationKeyBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Verification Key found |  -  |
| **400** | Invalid requests - malformed authentication header |  -  |
| **401** | Unauthorized - Authentication failed, invalid subject |  -  |
| **403** | Invalid scope |  -  |
| **404** | verification key not found |  -  |


## listVerificationKeys

> VerificationKeyListBankModel listVerificationKeys(page, perPage)

Get Verification Keys list

Retrieves a listing of verification keys of a bank.  Required scope: **banks:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.VerificationKeysBankApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://bank.demo.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        VerificationKeysBankApi apiInstance = new VerificationKeysBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | 
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | 
        try {
            VerificationKeyListBankModel result = apiInstance.listVerificationKeys(page, perPage);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling VerificationKeysBankApi#listVerificationKeys");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **java.math.BigInteger**|  | [optional] [default to 0]
 **perPage** | **java.math.BigInteger**|  | [optional] [default to 10]

### Return type

[**VerificationKeyListBankModel**](VerificationKeyListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of verification keys |  -  |
| **400** | Invalid requests - malformed authentication header |  -  |
| **401** | Unauthorized - Authentication failed, invalid subject |  -  |
| **403** | Invalid scope |  -  |


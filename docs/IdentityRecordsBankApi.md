# IdentityRecordsBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createIdentityRecord**](IdentityRecordsBankApi.md#createIdentityRecord) | **POST** /api/identity_records | Create Identity Record |
| [**getIdentityRecord**](IdentityRecordsBankApi.md#getIdentityRecord) | **GET** /api/identity_records/{identity_record_guid} | Get Identity Record |
| [**listIdentityRecords**](IdentityRecordsBankApi.md#listIdentityRecords) | **GET** /api/identity_records | List Identity Records |



## createIdentityRecord

> IdentityRecordBankModel createIdentityRecord(postIdentityRecordBankModel)

Create Identity Record

Creates an identity record.  ## Identity Records  Identity Records verify an individual for inclusion on the platform. This know-your-customer (KYC) process is a requirement for individuals to be able to transact. At present, we offer support for Attestation Identity Records.  Once an Identity Record has been submitted, it will be reviewed by our system and transit through a lifecycle before ultimately being &#x60;verified&#x60; or &#x60;failed&#x60;. If an Identity Record is ends up &#x60;failed&#x60;, contextual information as to the reason may be provided on the resource and additional attempts can be made.  ## Attestation Identity Records  An Attestation Identity Record is a confirmation of fact that the Organization has completed their own KYC process and can vouch for its correctness.  Prior to uploading &#x60;verified&#x60; attestation identity records, an Organization must register their signing public key with their Bank through the create Verification Key API.  To create an attestation identity record, a signed JWT is required as proof that the Customer&#39;s identity has been verified by the Organization. When creating the JWT, the Organization must use the RS512 signing algorithm.  The JWT must contain the following headers:  - **alg**: The RS512 algorithm value, e.g., &#39;RS512&#39;. - **kid**: Set to the guid of the verification key that has been registered for the Bank  The JWT must contain the following claims:  - **iss**: Set to http://api.cybrid.app/banks/{bank_guid} - **aud**: Set to http://api.cybrid.app - **sub**: Set to http://api.cybrid.app/customers/{customer_guid} - **iat**: Set to the time at which the JWT was issued - **exp**: Set to the time after which the JWT expires - **jti**: Set to a unique identifier for the JWT  Example code (python) for generating an Attestation Identity Record JWT token:  &#x60;&#x60;&#x60;python # Assumes an RSA private key has been generated (&#x60;private_key&#x60;), a Verification Key has been created and a &#x60;verification_key_guid&#x60; is available. # # &#x60;customer_guid&#x60; should be set to the guid assigned to a Customer that has been created. # &#x60;bank_guid&#x60; should be set to the guid of your bank #  import uuid  from datetime import datetime, timezone, timedelta from jwcrypto import jwt, jwk from cryptography.hazmat.primitives import serialization from cryptography.hazmat.primitives.serialization import load_pem_private_key  algorithm &#x3D; &#39;RS512&#39; issued_at &#x3D; datetime.now(timezone.utc) expired_at &#x3D; issued_at + timedelta(days&#x3D;365)  with open(\&quot;verification_key.pem\&quot;, &#39;rb&#39;) as pem_in:   pem_lines &#x3D; pem_in.read()  private_key &#x3D; load_pem_private_key(pem_lines, None)  ### DISCLAIMER:- Since NO ENCRYPTION is used in the key storage/formatting. Please DO NOT use this code in production environment. signing_key &#x3D; jwk.JWK.from_pem(     private_key.private_bytes(         encoding&#x3D;serialization.Encoding.PEM,         format&#x3D;serialization.PrivateFormat.PKCS8,         encryption_algorithm&#x3D;serialization.NoEncryption()     ) ) signing_key.update({\&quot;kid\&quot;: verification_key_guid})  attestation_jwt &#x3D; jwt.JWT(     header&#x3D;{         \&quot;alg\&quot;: algorithm,         \&quot;kid\&quot;: verification_key_guid     },     claims&#x3D;{         \&quot;iss\&quot;: f\&quot;http://api.cybrid.app/banks/{bank_guid}\&quot;,         \&quot;aud\&quot;: \&quot;http://api.cybrid.app\&quot;,         \&quot;sub\&quot;: f\&quot;http://api.cybrid.app/customers/{customer_guid}\&quot;,         \&quot;iat\&quot;: int(issued_at.timestamp()),         \&quot;exp\&quot;: int(expired_at.timestamp()),         \&quot;jti\&quot;: str(uuid.uuid4())     },     key&#x3D;signing_key,     algs&#x3D;[algorithm] ) attestation_jwt.make_signed_token(signing_key)  token &#x3D; attestation_jwt.serialize(compact&#x3D;True) print(\&quot;Token is : \&quot;, token) &#x60;&#x60;&#x60;  ## Default Attestation Signing Key  The Cybrid Sandbox environment comes provisioned with a default signing key that can be used to perform identity record attestation. The default identity signing key provides a convenient starting point for testing Sandbox flows that require identity attestation, such as executing trades.  The signing key can be loaded directly into a client application by passing its PEM encoded value as an environment variable.  &#x60;&#x60;&#x60; -----BEGIN PRIVATE KEY----- MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDZ75nSfJy/eeuj 4f7EK7i+n4FUDE8BsD/acCdk9Pn56suuDc3SFcMoyjBIoDLZkbRsVfmBEcPDNJOp GNqzoaXa7qe7Yw0qpK9MbNbAYxiyAfxwVHM+ZpwP6M/r3LmsCRFXgNdCjfOzok7u V59hDjfHMMQm/M9ztGVhaJpgozY/7DKk+R6qY/DEBs63eXwfcHE0u0NbS8Y9Qp+6 7cB2f1iuy++5Uut1vx4qdgZ4UFMkwIdTWl/e6LDcdXhk3///T5WOnDlI+S4rhGUO xsAOfOa+T9uqYBr2hbQR9emTEYmwF1lgZ7VU4S9sSjAMKpB/TVlVVOsNhdNSGg6f 6hu7fuadAgMBAAECggEBAMUJL1VyfHVRUY5VoPTTYrBVnaPTjQrFwrVHeRZ5thgS BBxVNqSeMFgMlSLUU6UJasoX4QCkgw1V17qmUfTeTQlnhBaTMzA+vI6oSHCgJ4+o 5AbbE2Zzdt2ba4Cfiu7TM+6c+gGePZtHP32Vku84340jtfRZ1WWSz6YF4K1GYqHe y7I4POotHu2WcSTXYKs2zTu5KAO7gvx7yITVytaiUGUHk9FNyZPDIh0u7e9CAEti BangdYTfvbXAIx9lrg3XQ4gtFXTd0aY/3R9K3SE+s5iWh/SabjV4U7x+MuHZS5kv 8rcLCPQ5kUgiF4bQMy7QznUuNso65SbRJKHaU8UAuIECgYEA7+bNdz/uiN/JxUJY 3xwjD+CG4vXOyEmCioBjllYBeXQyB/VrsdzVrdF2JiECnStPRH6/6nd7/wUcLORv NyrQqnCa5/O8Kv9Z3t4TmxYf+ECIgx+gazehQHptUkr8QWtxceorUC9pu4cUJ8z3 nQLCggHYQ3g7xj73LLZ+5QQBC8kCgYEA6I91Dgs+HZWDMMcGbKV2cMkXK8BTOgZZ 6B6i6flO4tf9U2CPBZsjYLBN5EEuxxy9Yl7rlV7CxAhnnjdIKk2jQbzTPI0qmJfp 397rvdR8bur1OkALj2Tb39fz8z1Qy7AcN8siqXuortZZ5OI9XRWgnG/3B4gUFOnW 4Mr0dhfaxjUCgYEAmVcricehjneMnrtz1thDSQi47yUzES57dE/wV82Nj7ZHrHKg bcW8ByhVnrWG2DMwrZVe0l2hMjZv9fnlZJvHWMo1GYHfipRBO4UzfvO7Z5DIMRfs D9w1A+O9MNahOqeUkb2eBdjoemcy6OXId+Gltje7phSaEHN6xme34GaYzJECgYBP eRbLYdQsT/exJ5JudmzvRgkBDoxie+EljbKmumfW5XDQmWLGy6lfVWCI7C2MJaoi f8WKGgP88dJXIxUqP7XWtSyKuMMhumhV9Nwi1wZe8TQ0X8aTjigFassXCJEfymMa PfTubi/K771wlk/aC5YDX8/PZxVVwEOKNlEsOiKtMQKBgQDqRv5AUHhabqcMfbs7 DTeo/fS/eXJv8MN+CUU2RSrNUKjEdHT2R5KP550TyXr1JXLKpEEZu8wvvaQDV4Dw p0Eij6bKsh03X38NR+C5SxonXPosdvoiXR8uUgya2f/aJYV+aWZ9euFgYZAXf/0Q MnWdKylfZlV50XP2KFn07wPs7w&#x3D;&#x3D; -----END PRIVATE KEY----- &#x60;&#x60;&#x60;  A corresponding public verification key can be retrieved from the Cybrid Banks API using the &#x60;/api/bank_verification_keys&#x60; endpoint. Performing a &#x60;get&#x60; request to this endpoint returns the available Verification Key records, the first of which is the provisioned default. The endpoint can be hit directly or by using the Cybrid Banks API client:  &#x60;&#x60;&#x60;python ... api_client &#x3D; cybrid_api_bank.ApiClient(configuration) api_instance &#x3D; verification_keys_bank_api.VerificationKeysBankApi(api_client) verification_keys &#x3D; api_instance.list_verification_keys() verification_key &#x3D; verification_keys.objects[0] &#x60;&#x60;&#x60;  Once available to the application, the signing key and Verification Key record can be used in conjunction to create the attestation JWT. The Verification Key&#39;s GUID is passed as the JWT&#39;s &#x60;kid&#x60; while the signing key is used to sign the JWT.  ## Attestation State  | State | Description | |-------|-------------| | storing | The Platform is storing the attestation in our private store | | pending | The Platform is verifying the attestation&#39;s JWT | | verified | The Platform has verified the attestation and the customer is able to transact | | failed | The Platform was not able to verify the attestation and the customer is not able to transact |    Required scope: **customers:write**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.IdentityRecordsBankApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://bank.sandbox.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        IdentityRecordsBankApi apiInstance = new IdentityRecordsBankApi(defaultClient);
        PostIdentityRecordBankModel postIdentityRecordBankModel = new PostIdentityRecordBankModel(); // PostIdentityRecordBankModel | 
        try {
            IdentityRecordBankModel result = apiInstance.createIdentityRecord(postIdentityRecordBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IdentityRecordsBankApi#createIdentityRecord");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **postIdentityRecordBankModel** | [**PostIdentityRecordBankModel**](PostIdentityRecordBankModel.md)|  | |

### Return type

[**IdentityRecordBankModel**](IdentityRecordBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Identity Record created |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed, |  -  |
| **403** | Invalid scope |  -  |


## getIdentityRecord

> IdentityRecordBankModel getIdentityRecord(identityRecordGuid)

Get Identity Record

Retrieves an identity record.  Required scope: **customers:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.IdentityRecordsBankApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://bank.sandbox.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        IdentityRecordsBankApi apiInstance = new IdentityRecordsBankApi(defaultClient);
        String identityRecordGuid = "identityRecordGuid_example"; // String | Identifier for the identity record.
        try {
            IdentityRecordBankModel result = apiInstance.getIdentityRecord(identityRecordGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IdentityRecordsBankApi#getIdentityRecord");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **identityRecordGuid** | **String**| Identifier for the identity record. | |

### Return type

[**IdentityRecordBankModel**](IdentityRecordBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Identity Record found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | identity record not found |  -  |


## listIdentityRecords

> IdentityRecordListBankModel listIdentityRecords(customerGuid, page, perPage)

List Identity Records

Retrieves a listing of identity records for a bank.  Required scope: **customers:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.IdentityRecordsBankApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://bank.sandbox.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        IdentityRecordsBankApi apiInstance = new IdentityRecordsBankApi(defaultClient);
        String customerGuid = "customerGuid_example"; // String | Comma separated customer identifier to list identity records for.
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | 
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | 
        try {
            IdentityRecordListBankModel result = apiInstance.listIdentityRecords(customerGuid, page, perPage);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IdentityRecordsBankApi#listIdentityRecords");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **customerGuid** | **String**| Comma separated customer identifier to list identity records for. | [optional] |
| **page** | **java.math.BigInteger**|  | [optional] |
| **perPage** | **java.math.BigInteger**|  | [optional] |

### Return type

[**IdentityRecordListBankModel**](IdentityRecordListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | list of identity records |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


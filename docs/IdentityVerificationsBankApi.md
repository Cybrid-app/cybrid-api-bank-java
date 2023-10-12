# IdentityVerificationsBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createIdentityVerification**](IdentityVerificationsBankApi.md#createIdentityVerification) | **POST** /api/identity_verifications | Create Identity Verification |
| [**getIdentityVerification**](IdentityVerificationsBankApi.md#getIdentityVerification) | **GET** /api/identity_verifications/{identity_verification_guid} | Get Identity Verification |
| [**listIdentityVerifications**](IdentityVerificationsBankApi.md#listIdentityVerifications) | **GET** /api/identity_verifications | List Identity Verifications |



## createIdentityVerification

> IdentityVerificationBankModel createIdentityVerification(postIdentityVerificationBankModel)

Create Identity Verification

Creates an Identity Verification.  ## Identity Verifications  Identity Verifications confirm an individual&#39;s identity with for the purpose of inclusion on the platform. This know-your-customer (KYC) process is a requirement for individuals to be able to transact. At present, we offer support for Cybrid performing the verification or working with partners to accept their KYC/AML process and have it attested to in our platform.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the identity verification details in our private store | | waiting | The Platform is waiting for the customer to complete the identity verification process | | expired | The identity verification process has expired | | completed | The identity verification process has been completed |  ## Outcome  | State | Description | |-------|-------------| | passed | The customer has passed the identity verification process | | failed | The customer has failed the identity verification process |  ## Failure Codes  | Code | Description | |-------|-------------| | id_check_failure | Failure due to an issue when verifying the provided ID | | database_check_failure | Failure due to an issue when verifying the provided information against authoritative data sources | | selfie_failure | Failure due to an issue verifying the provided selfie photo | | duplicate_person_check_failure | Failure due to a customer already existing for this person | | name_check_failure | Failure due to an issue verifying the name of the person | | address_check_failure | Failure due to an issue verifying the address of the person | | dob_check_failure | Failure due to an issue verifying the date of birth of the person | | id_number_check_failure | Failure due to an issue verifying an identification number of the person | | phone_number_check_failure | Failure due to an issue verifying the phone number of the person | | email_address_check_failure | Failure due to an issue verifying the email address of the person | | plaid_failure | Failure due to an issue interacting with Plaid | | decision_timeout | Failure due to an issue verifying the email address of the person | | requested_failure | In sandbox, the caller requested that the process failed |    Required scope: **customers:write**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.IdentityVerificationsBankApi;

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

        IdentityVerificationsBankApi apiInstance = new IdentityVerificationsBankApi(defaultClient);
        PostIdentityVerificationBankModel postIdentityVerificationBankModel = new PostIdentityVerificationBankModel(); // PostIdentityVerificationBankModel | 
        try {
            IdentityVerificationBankModel result = apiInstance.createIdentityVerification(postIdentityVerificationBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IdentityVerificationsBankApi#createIdentityVerification");
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
| **postIdentityVerificationBankModel** | [**PostIdentityVerificationBankModel**](PostIdentityVerificationBankModel.md)|  | |

### Return type

[**IdentityVerificationBankModel**](IdentityVerificationBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Identity Verification created |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


## getIdentityVerification

> IdentityVerificationWithDetailsBankModel getIdentityVerification(identityVerificationGuid)

Get Identity Verification

Retrieves an identity verification.  Required scope: **customers:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.IdentityVerificationsBankApi;

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

        IdentityVerificationsBankApi apiInstance = new IdentityVerificationsBankApi(defaultClient);
        String identityVerificationGuid = "identityVerificationGuid_example"; // String | Identifier for the identity verification.
        try {
            IdentityVerificationWithDetailsBankModel result = apiInstance.getIdentityVerification(identityVerificationGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IdentityVerificationsBankApi#getIdentityVerification");
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
| **identityVerificationGuid** | **String**| Identifier for the identity verification. | |

### Return type

[**IdentityVerificationWithDetailsBankModel**](IdentityVerificationWithDetailsBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | identity verification found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | identity_verification not found |  -  |


## listIdentityVerifications

> IdentityVerificationListBankModel listIdentityVerifications(page, perPage, guid, bankGuid, customerGuid, state)

List Identity Verifications

Retrieves a list of identity verifications.  Required scope: **customers:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.IdentityVerificationsBankApi;

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

        IdentityVerificationsBankApi apiInstance = new IdentityVerificationsBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated guids to list identity verifications for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list identity verifications for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list identity verifications for.
        String state = "state_example"; // String | Comma separated states to list identity verifications for.
        try {
            IdentityVerificationListBankModel result = apiInstance.listIdentityVerifications(page, perPage, guid, bankGuid, customerGuid, state);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IdentityVerificationsBankApi#listIdentityVerifications");
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
| **page** | **java.math.BigInteger**| The page index to retrieve. | [optional] |
| **perPage** | **java.math.BigInteger**| The number of entities per page to return. | [optional] |
| **guid** | **String**| Comma separated guids to list identity verifications for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list identity verifications for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list identity verifications for. | [optional] |
| **state** | **String**| Comma separated states to list identity verifications for. | [optional] |

### Return type

[**IdentityVerificationListBankModel**](IdentityVerificationListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of identity verifications |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


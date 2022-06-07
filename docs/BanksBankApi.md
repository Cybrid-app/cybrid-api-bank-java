# BanksBankApi

All URIs are relative to *https://bank.demo.cybrid.app*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBank**](BanksBankApi.md#createBank) | **POST** /api/banks | Create Bank
[**getBank**](BanksBankApi.md#getBank) | **GET** /api/banks/{bank_guid} | Get Bank
[**listBanks**](BanksBankApi.md#listBanks) | **GET** /api/banks | Get banks list



## createBank

> BankBankModel createBank(postBankBankModel)

Create Bank

Creates a bank.  ## Bank Type  Bank&#39;s can be created in either &#x60;sandbox&#x60; or &#x60;production&#x60; mode. Sandbox Banks will not transact in real fiat dollars or cryptocurrencies.  Via the API, only &#x60;sandbox&#x60; banks can be created. In order to enable a &#x60;production&#x60; bank please contact [Support](mailto:support@cybrid.app).  ## Backstopped Funding Source  A Backstopped Funding Source is an agreement between the Organization and Cybrid on transaction settlement. A Backstopped Funding Source is an escrow bank account that the Organization tops up on a regular basis and is drawn down by the Cybrid Platform when trades are executed by the Bank for its customers.  This feature must specifically be enabled in the Bank&#39;s &#x60;features&#x60; array by including the &#x60;backstopped_funding_source&#x60; flag. At present, backstopped funding sources is the supported method for funding trades on the platform.  Please contact [Support](mailto:support@cybrid.app) to inquire about enabling this option for your Organization.  ## Attestation Identity Records  Attestation Identity Records is a method the Cybrid Platform uses to verify the identity of a Bank&#39;s customers. Please see the documentation under the create Identity Record API for more technical detail.  This feature must specifically be enabled in the Bank&#39;s &#x60;features&#x60; array by including the &#x60;attestation_identity_records&#x60; flag. At present, attestation identity records is the supported method for verifying a customer&#39;s identity on the platform.  Please contact [Support](mailto:support@cybrid.app) to inquire about enabling this option for your Organization.    Required scope: **banks:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.BanksBankApi;

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

        BanksBankApi apiInstance = new BanksBankApi(defaultClient);
        PostBankBankModel postBankBankModel = new PostBankBankModel(); // PostBankBankModel | 
        try {
            BankBankModel result = apiInstance.createBank(postBankBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BanksBankApi#createBank");
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
 **postBankBankModel** | [**PostBankBankModel**](PostBankBankModel.md)|  |

### Return type

[**BankBankModel**](BankBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Bank created |  -  |
| **400** | Invalid requests - malformed authentication header |  -  |
| **401** | Unauthorized - Authentication failed, invalid subject |  -  |
| **403** | Invalid scope |  -  |
| **415** | Unsupported values |  -  |


## getBank

> BankBankModel getBank(bankGuid)

Get Bank

Retrieves a bank.  Required scope: **banks:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.BanksBankApi;

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

        BanksBankApi apiInstance = new BanksBankApi(defaultClient);
        String bankGuid = "bankGuid_example"; // String | Identifier for the bank.
        try {
            BankBankModel result = apiInstance.getBank(bankGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BanksBankApi#getBank");
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
 **bankGuid** | **String**| Identifier for the bank. |

### Return type

[**BankBankModel**](BankBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | bank found |  -  |
| **400** | Invalid requests - invalid value in request |  -  |
| **401** | Unauthorized - Authentication failed, invalid subject |  -  |
| **403** | Invalid scope |  -  |


## listBanks

> BankListBankModel listBanks(page, perPage)

Get banks list

Retrieves a listing of bank.  Required scope: **banks:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.BanksBankApi;

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

        BanksBankApi apiInstance = new BanksBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        try {
            BankListBankModel result = apiInstance.listBanks(page, perPage);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BanksBankApi#listBanks");
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
 **page** | **java.math.BigInteger**| The page index to retrieve. | [optional] [default to 0]
 **perPage** | **java.math.BigInteger**| The number of entities per page to return. | [optional] [default to 10]

### Return type

[**BankListBankModel**](BankListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of banks |  -  |
| **400** | Invalid requests - malformed authentication header |  -  |
| **401** | Unauthorized - invalid subject, Authentication failed |  -  |
| **403** | Invalid scope |  -  |


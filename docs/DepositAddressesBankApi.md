# DepositAddressesBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createDepositAddress**](DepositAddressesBankApi.md#createDepositAddress) | **POST** /api/deposit_addresses | Create Deposit Address |
| [**getDepositAddress**](DepositAddressesBankApi.md#getDepositAddress) | **GET** /api/deposit_addresses/{deposit_address_guid} | Get Deposit Address |
| [**listDepositAddresses**](DepositAddressesBankApi.md#listDepositAddresses) | **GET** /api/deposit_addresses | List Deposit Addresses |



## createDepositAddress

> DepositAddressBankModel createDepositAddress(postDepositAddressBankModel)

Create Deposit Address

Create an Deposit Address.  Required scope: **deposit_addresses:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.DepositAddressesBankApi;

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

        DepositAddressesBankApi apiInstance = new DepositAddressesBankApi(defaultClient);
        PostDepositAddressBankModel postDepositAddressBankModel = new PostDepositAddressBankModel(); // PostDepositAddressBankModel | 
        try {
            DepositAddressBankModel result = apiInstance.createDepositAddress(postDepositAddressBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DepositAddressesBankApi#createDepositAddress");
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
| **postDepositAddressBankModel** | [**PostDepositAddressBankModel**](PostDepositAddressBankModel.md)|  | |

### Return type

[**DepositAddressBankModel**](DepositAddressBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Deposit Address created |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


## getDepositAddress

> DepositAddressBankModel getDepositAddress(depositAddressGuid)

Get Deposit Address

Retrieves a deposit address.  Required scope: **deposit_addresses:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.DepositAddressesBankApi;

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

        DepositAddressesBankApi apiInstance = new DepositAddressesBankApi(defaultClient);
        String depositAddressGuid = "depositAddressGuid_example"; // String | Identifier for the deposit address.
        try {
            DepositAddressBankModel result = apiInstance.getDepositAddress(depositAddressGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DepositAddressesBankApi#getDepositAddress");
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
| **depositAddressGuid** | **String**| Identifier for the deposit address. | |

### Return type

[**DepositAddressBankModel**](DepositAddressBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deposit address found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | deposit_address not found |  -  |


## listDepositAddresses

> DepositAddressListBankModel listDepositAddresses(page, perPage, guid, bankGuid, customerGuid)

List Deposit Addresses

Retrieves a list of deposit addresses.  Required scope: **deposit_addresses:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.DepositAddressesBankApi;

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

        DepositAddressesBankApi apiInstance = new DepositAddressesBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated guids to list deposit addresses for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list deposit addresses for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list deposit addresses for.
        try {
            DepositAddressListBankModel result = apiInstance.listDepositAddresses(page, perPage, guid, bankGuid, customerGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DepositAddressesBankApi#listDepositAddresses");
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
| **guid** | **String**| Comma separated guids to list deposit addresses for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list deposit addresses for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list deposit addresses for. | [optional] |

### Return type

[**DepositAddressListBankModel**](DepositAddressListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of deposit addresses |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


# TransfersBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTransfer**](TransfersBankApi.md#createTransfer) | **POST** /api/transfers | Create Transfer |
| [**getTransfer**](TransfersBankApi.md#getTransfer) | **GET** /api/transfers/{transfer_guid} | Get Transfer |
| [**listTransfers**](TransfersBankApi.md#listTransfers) | **GET** /api/transfers | Get transfers list |



## createTransfer

> TransferBankModel createTransfer(postTransferBankModel)

Create Transfer

Creates a transfer.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the trade details in our private store | | initiating | The Platform has begun to perform the transfer | | pending | The Platform is executing the transfer | | completed | The Platform has successfully completed the transfer | | failed | The Platform was not able to successfully complete the transfer |    Required scope: **transfers:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TransfersBankApi;

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

        TransfersBankApi apiInstance = new TransfersBankApi(defaultClient);
        PostTransferBankModel postTransferBankModel = new PostTransferBankModel(); // PostTransferBankModel | 
        try {
            TransferBankModel result = apiInstance.createTransfer(postTransferBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransfersBankApi#createTransfer");
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
| **postTransferBankModel** | [**PostTransferBankModel**](PostTransferBankModel.md)|  | |

### Return type

[**TransferBankModel**](TransferBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Transfer created |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **409** | Data already exists |  -  |
| **422** | Unable to process request |  -  |


## getTransfer

> TransferBankModel getTransfer(transferGuid)

Get Transfer

Retrieves a transfer.  Required scope: **transfers:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TransfersBankApi;

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

        TransfersBankApi apiInstance = new TransfersBankApi(defaultClient);
        String transferGuid = "transferGuid_example"; // String | Identifier for the transfer.
        try {
            TransferBankModel result = apiInstance.getTransfer(transferGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransfersBankApi#getTransfer");
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
| **transferGuid** | **String**| Identifier for the transfer. | |

### Return type

[**TransferBankModel**](TransferBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | transfer found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | transfer not found |  -  |


## listTransfers

> TransferListBankModel listTransfers(page, perPage, guid, transferType, bankGuid, customerGuid, accountGuid, state)

Get transfers list

Retrieves a listing of transfers.  Required scope: **transfers:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TransfersBankApi;

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

        TransfersBankApi apiInstance = new TransfersBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated transfer_guids to list transfers for.
        String transferType = "transferType_example"; // String | Comma separated transfer_types to list accounts for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list transfers for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list transfers for.
        String accountGuid = "accountGuid_example"; // String | Comma separated account_guids to list transfers for.
        String state = "state_example"; // String | Comma separated states to list transfers for.
        try {
            TransferListBankModel result = apiInstance.listTransfers(page, perPage, guid, transferType, bankGuid, customerGuid, accountGuid, state);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransfersBankApi#listTransfers");
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
| **guid** | **String**| Comma separated transfer_guids to list transfers for. | [optional] |
| **transferType** | **String**| Comma separated transfer_types to list accounts for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list transfers for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list transfers for. | [optional] |
| **accountGuid** | **String**| Comma separated account_guids to list transfers for. | [optional] |
| **state** | **String**| Comma separated states to list transfers for. | [optional] |

### Return type

[**TransferListBankModel**](TransferListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of transfers |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


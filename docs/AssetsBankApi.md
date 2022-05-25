# AssetsBankApi

All URIs are relative to *https://bank.demo.cybrid.app*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listAssets**](AssetsBankApi.md#listAssets) | **GET** /api/assets | Get assets list



## listAssets

> AssetListBankModel listAssets(page, perPage)

Get assets list

Retrieves a listing of assets.  Required scope: **prices:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.AssetsBankApi;

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

        AssetsBankApi apiInstance = new AssetsBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        try {
            AssetListBankModel result = apiInstance.listAssets(page, perPage);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetsBankApi#listAssets");
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

[**AssetListBankModel**](AssetListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of assets |  -  |
| **400** | Malformed Authentication Header |  -  |
| **401** | Invalid responses - Authentication failed, invalid subject |  -  |
| **403** | Invalid scope |  -  |


# QuotesBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createQuote**](QuotesBankApi.md#createQuote) | **POST** /api/quotes | Create Quote |
| [**getQuote**](QuotesBankApi.md#getQuote) | **GET** /api/quotes/{quote_guid} | Get Quote |
| [**listQuotes**](QuotesBankApi.md#listQuotes) | **GET** /api/quotes | Get quotes list |



## createQuote

> QuoteBankModel createQuote(postQuoteBankModel)

Create Quote

Creates a quote.  ## Quote creation  Quotes can be created for a Bank or a Customer.  To create quotes for your Bank, omit the &#x60;customer_guid&#x60; parameter in the request body. To create quotes for your Customers, include the &#x60;customer_guid&#x60; parameter in the request body.  ## Failure codes  | Code | Description | |------|-------------| | invalid_amount | The amount on the invoice is unprocessable | | insufficient_balance | There are insufficient funds to process the quote | | invalid_invoice | The invoice cannot be processed |    Required scope: **quotes:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.QuotesBankApi;

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

        QuotesBankApi apiInstance = new QuotesBankApi(defaultClient);
        PostQuoteBankModel postQuoteBankModel = new PostQuoteBankModel(); // PostQuoteBankModel | 
        try {
            QuoteBankModel result = apiInstance.createQuote(postQuoteBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuotesBankApi#createQuote");
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
| **postQuoteBankModel** | [**PostQuoteBankModel**](PostQuoteBankModel.md)|  | |

### Return type

[**QuoteBankModel**](QuoteBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | quote created |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **422** | Unable to process request |  -  |


## getQuote

> QuoteBankModel getQuote(quoteGuid)

Get Quote

Retrieves a quote.  Required scope: **quotes:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.QuotesBankApi;

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

        QuotesBankApi apiInstance = new QuotesBankApi(defaultClient);
        String quoteGuid = "quoteGuid_example"; // String | Identifier for the quote.
        try {
            QuoteBankModel result = apiInstance.getQuote(quoteGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuotesBankApi#getQuote");
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
| **quoteGuid** | **String**| Identifier for the quote. | |

### Return type

[**QuoteBankModel**](QuoteBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | quote found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | quote not found |  -  |


## listQuotes

> QuoteListBankModel listQuotes(page, perPage, guid, productType, bankGuid, customerGuid, side)

Get quotes list

Retrieves a listing of quotes for all customers of a bank.  Required scope: **quotes:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.QuotesBankApi;

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

        QuotesBankApi apiInstance = new QuotesBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | 
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | 
        String guid = "guid_example"; // String | Comma separated quote_guids to list quotes for.
        String productType = "productType_example"; // String | Comma separated product_types to list accounts for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list quotes for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list quotes for.
        String side = "side_example"; // String | Comma separated sides to list quotes for.
        try {
            QuoteListBankModel result = apiInstance.listQuotes(page, perPage, guid, productType, bankGuid, customerGuid, side);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuotesBankApi#listQuotes");
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
| **page** | **java.math.BigInteger**|  | [optional] |
| **perPage** | **java.math.BigInteger**|  | [optional] |
| **guid** | **String**| Comma separated quote_guids to list quotes for. | [optional] |
| **productType** | **String**| Comma separated product_types to list accounts for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list quotes for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list quotes for. | [optional] |
| **side** | **String**| Comma separated sides to list quotes for. | [optional] |

### Return type

[**QuoteListBankModel**](QuoteListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of quotes |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


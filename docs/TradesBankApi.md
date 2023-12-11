# TradesBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTrade**](TradesBankApi.md#createTrade) | **POST** /api/trades | Create Trade |
| [**getTrade**](TradesBankApi.md#getTrade) | **GET** /api/trades/{trade_guid} | Get Trade |
| [**listTrades**](TradesBankApi.md#listTrades) | **GET** /api/trades | Get trades list |



## createTrade

> TradeBankModel createTrade(postTradeBankModel)

Create Trade

Creates a trade.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the trade details in our private store | | pending | The Platform is executing the trade | | cancelled | The Platform has cancelled the trade | | settling | The Platform is settling the trade | | completed | The Platform has successfully completed the trade | | failed | The Platform was not able to successfully complete the trade |  ## Failure codes  | Code | Description | |------|-------------| | non_sufficient_funds | The customer does not have enough funds to complete the trade | | unsupported | The trading pair is not supported for this customer | | limit_exceeded | The customer is over the limits that have been set for them for this activity |    Required scope: **trades:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TradesBankApi;

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

        TradesBankApi apiInstance = new TradesBankApi(defaultClient);
        PostTradeBankModel postTradeBankModel = new PostTradeBankModel(); // PostTradeBankModel | 
        try {
            TradeBankModel result = apiInstance.createTrade(postTradeBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TradesBankApi#createTrade");
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
| **postTradeBankModel** | [**PostTradeBankModel**](PostTradeBankModel.md)|  | |

### Return type

[**TradeBankModel**](TradeBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Trade created |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **409** | Data already exists |  -  |
| **422** | Unable to process request |  -  |


## getTrade

> TradeBankModel getTrade(tradeGuid)

Get Trade

Retrieves a trade.  Required scope: **trades:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TradesBankApi;

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

        TradesBankApi apiInstance = new TradesBankApi(defaultClient);
        String tradeGuid = "tradeGuid_example"; // String | Identifier for the trade.
        try {
            TradeBankModel result = apiInstance.getTrade(tradeGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TradesBankApi#getTrade");
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
| **tradeGuid** | **String**| Identifier for the trade. | |

### Return type

[**TradeBankModel**](TradeBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | trade found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | trade not found |  -  |


## listTrades

> TradeListBankModel listTrades(page, perPage, guid, bankGuid, customerGuid, accountGuid, state, label, createdAtGte, createdAtLt, updatedAtGte, updatedAtLt)

Get trades list

Retrieves a listing of trades.  Required scope: **trades:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TradesBankApi;

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

        TradesBankApi apiInstance = new TradesBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated trade_guids to list trades for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list trades for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list trades for.
        String accountGuid = "accountGuid_example"; // String | Comma separated account_guids to list trades for.
        String state = "state_example"; // String | Comma separated states to list trades for.
        String label = "label_example"; // String | Comma separated labels to list trades for.
        String createdAtGte = "createdAtGte_example"; // String | Created at start date inclusive lower bound, ISO8601.
        String createdAtLt = "createdAtLt_example"; // String | Created at end date exclusive upper bound, ISO8601.
        String updatedAtGte = "updatedAtGte_example"; // String | Updated at start date inclusive lower bound, ISO8601.
        String updatedAtLt = "updatedAtLt_example"; // String | Updated at end date exclusive upper bound, ISO8601.
        try {
            TradeListBankModel result = apiInstance.listTrades(page, perPage, guid, bankGuid, customerGuid, accountGuid, state, label, createdAtGte, createdAtLt, updatedAtGte, updatedAtLt);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TradesBankApi#listTrades");
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
| **guid** | **String**| Comma separated trade_guids to list trades for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list trades for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list trades for. | [optional] |
| **accountGuid** | **String**| Comma separated account_guids to list trades for. | [optional] |
| **state** | **String**| Comma separated states to list trades for. | [optional] |
| **label** | **String**| Comma separated labels to list trades for. | [optional] |
| **createdAtGte** | **String**| Created at start date inclusive lower bound, ISO8601. | [optional] |
| **createdAtLt** | **String**| Created at end date exclusive upper bound, ISO8601. | [optional] |
| **updatedAtGte** | **String**| Updated at start date inclusive lower bound, ISO8601. | [optional] |
| **updatedAtLt** | **String**| Updated at end date exclusive upper bound, ISO8601. | [optional] |

### Return type

[**TradeListBankModel**](TradeListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of trades |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


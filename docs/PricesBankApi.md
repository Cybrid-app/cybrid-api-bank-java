# PricesBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listPrices**](PricesBankApi.md#listPrices) | **GET** /api/prices | Get Price |



## listPrices

> List&lt;SymbolPriceBankModel&gt; listPrices(symbol, tradingSymbol, payoutSymbol, payoutCountryCode, payoutParticipantsType, payoutRoute, bankGuid)

Get Price

Retrieves a listing of symbol prices.  ## Symbols  Symbol are pairs and are in the format asset-counter_asset, e.g., &#39;BTC-USD&#39; for the Bitcoin/ USD pair. See the Symbols API for a complete list of cryptocurrencies supported.    Required scope: **prices:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.PricesBankApi;

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

        PricesBankApi apiInstance = new PricesBankApi(defaultClient);
        String symbol = "symbol_example"; // String | Comma separated trading symbols to list prices for.
        String tradingSymbol = "tradingSymbol_example"; // String | Comma separated trading symbols to list prices for.
        String payoutSymbol = "payoutSymbol_example"; // String | Comma separated payout symbols to list prices for.
        String payoutCountryCode = "payoutCountryCode_example"; // String | Comma separated payout country codes to list prices for.
        String payoutParticipantsType = "payoutParticipantsType_example"; // String | Comma separated payout participants types to list prices for.
        String payoutRoute = "payoutRoute_example"; // String | Comma separated payout routes to list prices for.
        String bankGuid = "bankGuid_example"; // String | The bank identifier to retrieve prices for.
        try {
            List<SymbolPriceBankModel> result = apiInstance.listPrices(symbol, tradingSymbol, payoutSymbol, payoutCountryCode, payoutParticipantsType, payoutRoute, bankGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PricesBankApi#listPrices");
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
| **symbol** | **String**| Comma separated trading symbols to list prices for. | [optional] |
| **tradingSymbol** | **String**| Comma separated trading symbols to list prices for. | [optional] |
| **payoutSymbol** | **String**| Comma separated payout symbols to list prices for. | [optional] |
| **payoutCountryCode** | **String**| Comma separated payout country codes to list prices for. | [optional] |
| **payoutParticipantsType** | **String**| Comma separated payout participants types to list prices for. | [optional] |
| **payoutRoute** | **String**| Comma separated payout routes to list prices for. | [optional] |
| **bankGuid** | **String**| The bank identifier to retrieve prices for. | [optional] |

### Return type

[**List&lt;SymbolPriceBankModel&gt;**](SymbolPriceBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of price |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


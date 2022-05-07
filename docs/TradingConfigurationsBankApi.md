# TradingConfigurationsBankApi

All URIs are relative to *https://bank.demo.cybrid.app*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTradingConfiguration**](TradingConfigurationsBankApi.md#createTradingConfiguration) | **POST** /api/trading_configurations | Create TradingConfiguration
[**getTradingConfiguration**](TradingConfigurationsBankApi.md#getTradingConfiguration) | **GET** /api/trading_configurations/{trading_configuration_guid} | Get TradingConfiguration
[**listTradingConfigurations**](TradingConfigurationsBankApi.md#listTradingConfigurations) | **GET** /api/trading_configurations | List trading configurations



## createTradingConfiguration

> TradingConfigurationBankModel createTradingConfiguration(postTradingConfigurationBankModel)

Create TradingConfiguration

Creates a trading configuration.  Required scope: **banks:write**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TradingConfigurationsBankApi;

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

        TradingConfigurationsBankApi apiInstance = new TradingConfigurationsBankApi(defaultClient);
        PostTradingConfigurationBankModel postTradingConfigurationBankModel = new PostTradingConfigurationBankModel(); // PostTradingConfigurationBankModel | 
        try {
            TradingConfigurationBankModel result = apiInstance.createTradingConfiguration(postTradingConfigurationBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TradingConfigurationsBankApi#createTradingConfiguration");
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
 **postTradingConfigurationBankModel** | [**PostTradingConfigurationBankModel**](PostTradingConfigurationBankModel.md)|  |

### Return type

[**TradingConfigurationBankModel**](TradingConfigurationBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | trading configuration created |  -  |


## getTradingConfiguration

> TradingConfigurationBankModel getTradingConfiguration(tradingConfigurationGuid)

Get TradingConfiguration

Retrieves a trading configuration.  Required scope: **banks:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TradingConfigurationsBankApi;

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

        TradingConfigurationsBankApi apiInstance = new TradingConfigurationsBankApi(defaultClient);
        String tradingConfigurationGuid = "tradingConfigurationGuid_example"; // String | Identifier for the trading configuration.
        try {
            TradingConfigurationBankModel result = apiInstance.getTradingConfiguration(tradingConfigurationGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TradingConfigurationsBankApi#getTradingConfiguration");
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
 **tradingConfigurationGuid** | **String**| Identifier for the trading configuration. |

### Return type

[**TradingConfigurationBankModel**](TradingConfigurationBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | trading configuration found |  -  |


## listTradingConfigurations

> TradingConfigurationListBankModel listTradingConfigurations(page, perPage)

List trading configurations

Retrieves a listing of trading configurations for a bank.  Required scope: **banks:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TradingConfigurationsBankApi;

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

        TradingConfigurationsBankApi apiInstance = new TradingConfigurationsBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | 
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | 
        try {
            TradingConfigurationListBankModel result = apiInstance.listTradingConfigurations(page, perPage);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TradingConfigurationsBankApi#listTradingConfigurations");
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

[**TradingConfigurationListBankModel**](TradingConfigurationListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of trading configurations |  -  |


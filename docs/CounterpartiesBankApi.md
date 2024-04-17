# CounterpartiesBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createCounterparty**](CounterpartiesBankApi.md#createCounterparty) | **POST** /api/counterparties | Create Counterparty |
| [**getCounterparty**](CounterpartiesBankApi.md#getCounterparty) | **GET** /api/counterparties/{counterparty_guid} | Get Counterparty |
| [**listCounterparties**](CounterpartiesBankApi.md#listCounterparties) | **GET** /api/counterparties | Get counterparties list |



## createCounterparty

> CounterpartyBankModel createCounterparty(postCounterpartyBankModel)

Create Counterparty

Creates a counterparty.  ## Counterparty Type  Counterparty resources are an abstraction for real world individuals and businesses that are not directly on the Cybrid Platform.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the counterparty details in our private store | | unverified | The Platform has not yet verified the counterparty&#39;s identity | | verified | The Platform has verified the counterparty&#39;s identity | | rejected | The Platform was not able to successfully verify the counterparty&#39;s identity |    Required scope: **counterparties:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.CounterpartiesBankApi;

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

        CounterpartiesBankApi apiInstance = new CounterpartiesBankApi(defaultClient);
        PostCounterpartyBankModel postCounterpartyBankModel = new PostCounterpartyBankModel(); // PostCounterpartyBankModel | 
        try {
            CounterpartyBankModel result = apiInstance.createCounterparty(postCounterpartyBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CounterpartiesBankApi#createCounterparty");
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
| **postCounterpartyBankModel** | [**PostCounterpartyBankModel**](PostCounterpartyBankModel.md)|  | |

### Return type

[**CounterpartyBankModel**](CounterpartyBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | counterparty created |  -  |
| **422** | Unprocessable Entity |  -  |


## getCounterparty

> CounterpartyBankModel getCounterparty(counterpartyGuid, includePii)

Get Counterparty

Retrieves a counterparty.  Required scope: **counterparties:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.CounterpartiesBankApi;

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

        CounterpartiesBankApi apiInstance = new CounterpartiesBankApi(defaultClient);
        String counterpartyGuid = "counterpartyGuid_example"; // String | Identifier for the counterparty.
        Boolean includePii = true; // Boolean | Include PII in the response.
        try {
            CounterpartyBankModel result = apiInstance.getCounterparty(counterpartyGuid, includePii);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CounterpartiesBankApi#getCounterparty");
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
| **counterpartyGuid** | **String**| Identifier for the counterparty. | |
| **includePii** | **Boolean**| Include PII in the response. | [optional] |

### Return type

[**CounterpartyBankModel**](CounterpartyBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | counterparty found |  -  |


## listCounterparties

> CounterpartyListBankModel listCounterparties(page, perPage, bankGuid, customerGuid, guid, label)

Get counterparties list

Retrieves a listing of counterparties.  Required scope: **counterparties:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.CounterpartiesBankApi;

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

        CounterpartiesBankApi apiInstance = new CounterpartiesBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | 
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | 
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list counterparties for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list counterparties for.
        String guid = "guid_example"; // String | Comma separated counterparty_guids to list counterparties for.
        String label = "label_example"; // String | Comma separated labels to list counterparties for.
        try {
            CounterpartyListBankModel result = apiInstance.listCounterparties(page, perPage, bankGuid, customerGuid, guid, label);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CounterpartiesBankApi#listCounterparties");
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
| **bankGuid** | **String**| Comma separated bank_guids to list counterparties for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list counterparties for. | [optional] |
| **guid** | **String**| Comma separated counterparty_guids to list counterparties for. | [optional] |
| **label** | **String**| Comma separated labels to list counterparties for. | [optional] |

### Return type

[**CounterpartyListBankModel**](CounterpartyListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of counterparties |  -  |


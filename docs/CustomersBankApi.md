# CustomersBankApi

All URIs are relative to *https://bank.demo.cybrid.app*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCustomer**](CustomersBankApi.md#createCustomer) | **POST** /api/customers | Create Customer
[**getCustomer**](CustomersBankApi.md#getCustomer) | **GET** /api/customers/{customer_guid} | Get Customer
[**listCustomers**](CustomersBankApi.md#listCustomers) | **GET** /api/customers | Get customers list



## createCustomer

> CustomerBankModel createCustomer(postCustomerBankModel)

Create Customer

Creates a customer.  ## Customer Type  Customer resources are an abstraction for real world individuals and businesses on the Cybrid Platform and are used throughout the platform to perform high level operations, e.g., create a quote, execute a trade, etc..  Customers can have additional resources attached to them, e.g., identity records, accounts, etc.  At present, Customer&#39;s can be created with type &#x60;individual&#x60;.    Required scope: **customers:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.CustomersBankApi;

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

        CustomersBankApi apiInstance = new CustomersBankApi(defaultClient);
        PostCustomerBankModel postCustomerBankModel = new PostCustomerBankModel(); // PostCustomerBankModel | 
        try {
            CustomerBankModel result = apiInstance.createCustomer(postCustomerBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomersBankApi#createCustomer");
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
 **postCustomerBankModel** | [**PostCustomerBankModel**](PostCustomerBankModel.md)|  |

### Return type

[**CustomerBankModel**](CustomerBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | customer created |  -  |


## getCustomer

> CustomerBankModel getCustomer(customerGuid, bankGuid)

Get Customer

Retrieves a customer.  Required scope: **customers:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.CustomersBankApi;

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

        CustomersBankApi apiInstance = new CustomersBankApi(defaultClient);
        String customerGuid = "customerGuid_example"; // String | Identifier for the customer.
        String bankGuid = "bankGuid_example"; // String | Identifier for the bank.
        try {
            CustomerBankModel result = apiInstance.getCustomer(customerGuid, bankGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomersBankApi#getCustomer");
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
 **customerGuid** | **String**| Identifier for the customer. |
 **bankGuid** | **String**| Identifier for the bank. | [optional]

### Return type

[**CustomerBankModel**](CustomerBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | customer found |  -  |


## listCustomers

> CustomerListBankModel listCustomers(page, perPage, bankGuid, guid)

Get customers list

Retrieves a listing of customers.  Required scope: **customers:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.CustomersBankApi;

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

        CustomersBankApi apiInstance = new CustomersBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | 
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | 
        String bankGuid = "bankGuid_example"; // String | Identifier for the bank.
        String guid = "guid_example"; // String | Comma separated customer_guid to list customers for.
        try {
            CustomerListBankModel result = apiInstance.listCustomers(page, perPage, bankGuid, guid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomersBankApi#listCustomers");
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
 **bankGuid** | **String**| Identifier for the bank. | [optional]
 **guid** | **String**| Comma separated customer_guid to list customers for. | [optional]

### Return type

[**CustomerListBankModel**](CustomerListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of customers |  -  |


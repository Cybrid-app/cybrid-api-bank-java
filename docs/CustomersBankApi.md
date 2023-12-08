# CustomersBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createCustomer**](CustomersBankApi.md#createCustomer) | **POST** /api/customers | Create Customer |
| [**getCustomer**](CustomersBankApi.md#getCustomer) | **GET** /api/customers/{customer_guid} | Get Customer |
| [**listCustomers**](CustomersBankApi.md#listCustomers) | **GET** /api/customers | Get customers list |
| [**updateCustomer**](CustomersBankApi.md#updateCustomer) | **PATCH** /api/customers/{customer_guid} | Patch Customer |



## createCustomer

> CustomerBankModel createCustomer(postCustomerBankModel)

Create Customer

Creates a customer.  ## Customer Type  Customer resources are an abstraction for real world individuals and businesses on the Cybrid Platform and are used throughout the platform to perform high level operations, e.g., create a quote, execute a trade, etc..  Customers can have additional resources attached to them, e.g., identity verifications, accounts, etc.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the customer details in our private store | | unverified | The Platform has not yet verified the customer&#39;s identity | | verified | The Platform has verified the customer&#39;s identity | | rejected | The Platform was not able to successfully verify the customer&#39;s identity | | frozen | The customer has been frozen on the Platform |    Required scope: **customers:execute**

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
        defaultClient.setBasePath("https://bank.sandbox.cybrid.app");
        
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


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **postCustomerBankModel** | [**PostCustomerBankModel**](PostCustomerBankModel.md)|  | |

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
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed, invalid subject |  -  |
| **403** | Invalid scope |  -  |


## getCustomer

> CustomerBankModel getCustomer(customerGuid, includePii)

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
        defaultClient.setBasePath("https://bank.sandbox.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        CustomersBankApi apiInstance = new CustomersBankApi(defaultClient);
        String customerGuid = "customerGuid_example"; // String | Identifier for the customer.
        Boolean includePii = true; // Boolean | Include PII in the response.
        try {
            CustomerBankModel result = apiInstance.getCustomer(customerGuid, includePii);
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


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **customerGuid** | **String**| Identifier for the customer. | |
| **includePii** | **Boolean**| Include PII in the response. | [optional] |

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
| **401** | Unauthorized - Authentication failed, invalid subject |  -  |
| **403** | Invalid scope |  -  |
| **404** | customer not found |  -  |


## listCustomers

> CustomerListBankModel listCustomers(page, perPage, bankGuid, guid, label)

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
        defaultClient.setBasePath("https://bank.sandbox.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        CustomersBankApi apiInstance = new CustomersBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | 
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | 
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list customers for.
        String guid = "guid_example"; // String | Comma separated customer_guids to list customers for.
        String label = "label_example"; // String | Comma separated labels to list customers for.
        try {
            CustomerListBankModel result = apiInstance.listCustomers(page, perPage, bankGuid, guid, label);
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


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **java.math.BigInteger**|  | [optional] |
| **perPage** | **java.math.BigInteger**|  | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list customers for. | [optional] |
| **guid** | **String**| Comma separated customer_guids to list customers for. | [optional] |
| **label** | **String**| Comma separated labels to list customers for. | [optional] |

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
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed, invalid subject, |  -  |
| **403** | Invalid scope |  -  |


## updateCustomer

> CustomerBankModel updateCustomer(customerGuid, patchCustomerBankModel)

Patch Customer

Update a customer.  Required scope: **customers:write**

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
        defaultClient.setBasePath("https://bank.sandbox.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        CustomersBankApi apiInstance = new CustomersBankApi(defaultClient);
        String customerGuid = "customerGuid_example"; // String | Identifier for the customer.
        PatchCustomerBankModel patchCustomerBankModel = new PatchCustomerBankModel(); // PatchCustomerBankModel | 
        try {
            CustomerBankModel result = apiInstance.updateCustomer(customerGuid, patchCustomerBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomersBankApi#updateCustomer");
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
| **customerGuid** | **String**| Identifier for the customer. | |
| **patchCustomerBankModel** | [**PatchCustomerBankModel**](PatchCustomerBankModel.md)|  | |

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
| **200** | customer found |  -  |
| **401** | Unauthorized - Authentication failed, invalid subject |  -  |
| **403** | Invalid scope |  -  |
| **404** | customer not found |  -  |


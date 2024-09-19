# InvoicesBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**cancelInvoice**](InvoicesBankApi.md#cancelInvoice) | **DELETE** /api/invoices/{invoice_guid} | Cancel Invoice |
| [**createInvoice**](InvoicesBankApi.md#createInvoice) | **POST** /api/invoices | Create Invoice |
| [**getInvoice**](InvoicesBankApi.md#getInvoice) | **GET** /api/invoices/{invoice_guid} | Get Invoice |
| [**listInvoices**](InvoicesBankApi.md#listInvoices) | **GET** /api/invoices | List Invoices |



## cancelInvoice

> InvoiceBankModel cancelInvoice(invoiceGuid)

Cancel Invoice

Cancels an invoice.  Required scope: **invoices:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.InvoicesBankApi;

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

        InvoicesBankApi apiInstance = new InvoicesBankApi(defaultClient);
        String invoiceGuid = "invoiceGuid_example"; // String | Identifier for the invoice.
        try {
            InvoiceBankModel result = apiInstance.cancelInvoice(invoiceGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvoicesBankApi#cancelInvoice");
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
| **invoiceGuid** | **String**| Identifier for the invoice. | |

### Return type

[**InvoiceBankModel**](InvoiceBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Invoice cancelled |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | Invoice not found |  -  |


## createInvoice

> InvoiceBankModel createInvoice(postInvoiceBankModel)

Create Invoice

Creates a invoice.  ## State  | State | Description | |-------|-------------| | storing    | The Platform is storing the invoice details in our private store | | unpaid     | The invoice is unpaid. Payment instructions can be generated for an invoice in this state | | cancelling | The invocie is in the process of being cancelled | | cancelled  | The invoice has been cancelled |  | settling   | The invoice has been paid and the funds associated with this invoice are in the process of being settled | | paid       | The invoice has been paid and the funds associated with this invoice have been settled |     Required scope: **invoices:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.InvoicesBankApi;

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

        InvoicesBankApi apiInstance = new InvoicesBankApi(defaultClient);
        PostInvoiceBankModel postInvoiceBankModel = new PostInvoiceBankModel(); // PostInvoiceBankModel | 
        try {
            InvoiceBankModel result = apiInstance.createInvoice(postInvoiceBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvoicesBankApi#createInvoice");
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
| **postInvoiceBankModel** | [**PostInvoiceBankModel**](PostInvoiceBankModel.md)|  | |

### Return type

[**InvoiceBankModel**](InvoiceBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Invoice created |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


## getInvoice

> InvoiceBankModel getInvoice(invoiceGuid)

Get Invoice

Retrieves a invoice.  Required scope: **invoices:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.InvoicesBankApi;

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

        InvoicesBankApi apiInstance = new InvoicesBankApi(defaultClient);
        String invoiceGuid = "invoiceGuid_example"; // String | Identifier for the payment instruction.
        try {
            InvoiceBankModel result = apiInstance.getInvoice(invoiceGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvoicesBankApi#getInvoice");
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
| **invoiceGuid** | **String**| Identifier for the payment instruction. | |

### Return type

[**InvoiceBankModel**](InvoiceBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | invoice found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | invoice not found |  -  |


## listInvoices

> InvoiceListBankModel listInvoices(page, perPage, guid, bankGuid, customerGuid, accountGuid, state, asset, environment, label)

List Invoices

Retrieves a list of invoices.  Required scope: **invoices:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.InvoicesBankApi;

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

        InvoicesBankApi apiInstance = new InvoicesBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated guids to list invoices for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list invoices for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list invoices for.
        String accountGuid = "accountGuid_example"; // String | Comma separated account_guids to list invoices for.
        String state = "state_example"; // String | Comma separated states to list invoices for.
        String asset = "asset_example"; // String | Comma separated assets to list invoices for.
        String environment = "sandbox"; // String | 
        String label = "label_example"; // String | Comma separated labels to list invoices for.
        try {
            InvoiceListBankModel result = apiInstance.listInvoices(page, perPage, guid, bankGuid, customerGuid, accountGuid, state, asset, environment, label);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvoicesBankApi#listInvoices");
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
| **guid** | **String**| Comma separated guids to list invoices for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list invoices for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list invoices for. | [optional] |
| **accountGuid** | **String**| Comma separated account_guids to list invoices for. | [optional] |
| **state** | **String**| Comma separated states to list invoices for. | [optional] |
| **asset** | **String**| Comma separated assets to list invoices for. | [optional] |
| **environment** | **String**|  | [optional] [enum: sandbox, production] |
| **label** | **String**| Comma separated labels to list invoices for. | [optional] |

### Return type

[**InvoiceListBankModel**](InvoiceListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of invoices |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


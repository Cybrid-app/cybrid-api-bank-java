# PaymentInstructionsBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createPaymentInstruction**](PaymentInstructionsBankApi.md#createPaymentInstruction) | **POST** /api/payment_instructions | Create Payment Instruction |
| [**getPaymentInstruction**](PaymentInstructionsBankApi.md#getPaymentInstruction) | **GET** /api/payment_instructions/{payment_instruction_guid} | Get Payment Instruction |
| [**listPaymentInstructions**](PaymentInstructionsBankApi.md#listPaymentInstructions) | **GET** /api/payment_instructions | List Payment Instructions |



## createPaymentInstruction

> PaymentInstructionBankModel createPaymentInstruction(postPaymentInstructionBankModel)

Create Payment Instruction

Creates a payment instruction.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the payment instruction details in our private store | | created | The Platform has created the payment instruction | | expired | The PaymentInstruction is no longer valid |    Required scope: **invoices:write**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.PaymentInstructionsBankApi;

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

        PaymentInstructionsBankApi apiInstance = new PaymentInstructionsBankApi(defaultClient);
        PostPaymentInstructionBankModel postPaymentInstructionBankModel = new PostPaymentInstructionBankModel(); // PostPaymentInstructionBankModel | 
        try {
            PaymentInstructionBankModel result = apiInstance.createPaymentInstruction(postPaymentInstructionBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PaymentInstructionsBankApi#createPaymentInstruction");
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
| **postPaymentInstructionBankModel** | [**PostPaymentInstructionBankModel**](PostPaymentInstructionBankModel.md)|  | |

### Return type

[**PaymentInstructionBankModel**](PaymentInstructionBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Payment Instruction created |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


## getPaymentInstruction

> PaymentInstructionBankModel getPaymentInstruction(paymentInstructionGuid)

Get Payment Instruction

Retrieves a payment_instruction.  Required scope: **invoices:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.PaymentInstructionsBankApi;

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

        PaymentInstructionsBankApi apiInstance = new PaymentInstructionsBankApi(defaultClient);
        String paymentInstructionGuid = "paymentInstructionGuid_example"; // String | Identifier for the payment instruction.
        try {
            PaymentInstructionBankModel result = apiInstance.getPaymentInstruction(paymentInstructionGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PaymentInstructionsBankApi#getPaymentInstruction");
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
| **paymentInstructionGuid** | **String**| Identifier for the payment instruction. | |

### Return type

[**PaymentInstructionBankModel**](PaymentInstructionBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | payment_instruction found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | payment_instruction not found |  -  |


## listPaymentInstructions

> PaymentInstructionListBankModel listPaymentInstructions(page, perPage, guid, bankGuid, customerGuid, invoiceGuid)

List Payment Instructions

Retrieves a list of payment instructions.  Required scope: **invoices:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.PaymentInstructionsBankApi;

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

        PaymentInstructionsBankApi apiInstance = new PaymentInstructionsBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated guids to list payment instructions for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list payment instructions for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list payment instructions for.
        String invoiceGuid = "invoiceGuid_example"; // String | Comma separated invoice_guids to list payment instructions for.
        try {
            PaymentInstructionListBankModel result = apiInstance.listPaymentInstructions(page, perPage, guid, bankGuid, customerGuid, invoiceGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PaymentInstructionsBankApi#listPaymentInstructions");
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
| **guid** | **String**| Comma separated guids to list payment instructions for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list payment instructions for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list payment instructions for. | [optional] |
| **invoiceGuid** | **String**| Comma separated invoice_guids to list payment instructions for. | [optional] |

### Return type

[**PaymentInstructionListBankModel**](PaymentInstructionListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of payment instructions |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


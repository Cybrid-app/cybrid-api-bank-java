# DepositBankAccountsBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createDepositBankAccount**](DepositBankAccountsBankApi.md#createDepositBankAccount) | **POST** /api/deposit_bank_accounts | Create Deposit Bank Account |
| [**getDepositBankAccount**](DepositBankAccountsBankApi.md#getDepositBankAccount) | **GET** /api/deposit_bank_accounts/{deposit_bank_account_guid} | Get Deposit Bank Account |
| [**listDepositBankAccounts**](DepositBankAccountsBankApi.md#listDepositBankAccounts) | **GET** /api/deposit_bank_accounts | List Deposit Bank Accounts |



## createDepositBankAccount

> DepositBankAccountBankModel createDepositBankAccount(postDepositBankAccountBankModel)

Create Deposit Bank Account

Creates a deposit bank account.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the deposit bank account details in our private store | | created | The Platform has created the deposit bank account |    Required scope: **deposit_bank_accounts:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.DepositBankAccountsBankApi;

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

        DepositBankAccountsBankApi apiInstance = new DepositBankAccountsBankApi(defaultClient);
        PostDepositBankAccountBankModel postDepositBankAccountBankModel = new PostDepositBankAccountBankModel(); // PostDepositBankAccountBankModel | 
        try {
            DepositBankAccountBankModel result = apiInstance.createDepositBankAccount(postDepositBankAccountBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DepositBankAccountsBankApi#createDepositBankAccount");
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
| **postDepositBankAccountBankModel** | [**PostDepositBankAccountBankModel**](PostDepositBankAccountBankModel.md)|  | |

### Return type

[**DepositBankAccountBankModel**](DepositBankAccountBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Deposit Bank Account created |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **422** | Unable to process request |  -  |


## getDepositBankAccount

> DepositBankAccountBankModel getDepositBankAccount(depositBankAccountGuid)

Get Deposit Bank Account

Retrieves a deposit bank account.  Required scope: **deposit_bank_accounts:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.DepositBankAccountsBankApi;

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

        DepositBankAccountsBankApi apiInstance = new DepositBankAccountsBankApi(defaultClient);
        String depositBankAccountGuid = "depositBankAccountGuid_example"; // String | Identifier for the deposit bank account.
        try {
            DepositBankAccountBankModel result = apiInstance.getDepositBankAccount(depositBankAccountGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DepositBankAccountsBankApi#getDepositBankAccount");
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
| **depositBankAccountGuid** | **String**| Identifier for the deposit bank account. | |

### Return type

[**DepositBankAccountBankModel**](DepositBankAccountBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deposit bank account found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | deposit_bank_account not found |  -  |


## listDepositBankAccounts

> DepositBankAccountListBankModel listDepositBankAccounts(page, perPage, guid, bankGuid, customerGuid, label, uniqueMemoId, type, parentDepositBankAccountGuid)

List Deposit Bank Accounts

Retrieves a list of deposit bank accounts.  Required scope: **deposit_bank_accounts:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.DepositBankAccountsBankApi;

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

        DepositBankAccountsBankApi apiInstance = new DepositBankAccountsBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated guids to list deposit bank accounts for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list deposit bank accounts for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list deposit bank accounts for.
        String label = "label_example"; // String | Comma separated labels to list deposit bank accounts for.
        String uniqueMemoId = "uniqueMemoId_example"; // String | Comma separated unique memo ids to list deposit bank accounts for.
        String type = "type_example"; // String | Comma separated types to list deposit bank accounts for.
        String parentDepositBankAccountGuid = "parentDepositBankAccountGuid_example"; // String | Comma separated guids for parent accounts to list deposit bank accounts for.
        try {
            DepositBankAccountListBankModel result = apiInstance.listDepositBankAccounts(page, perPage, guid, bankGuid, customerGuid, label, uniqueMemoId, type, parentDepositBankAccountGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DepositBankAccountsBankApi#listDepositBankAccounts");
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
| **guid** | **String**| Comma separated guids to list deposit bank accounts for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list deposit bank accounts for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list deposit bank accounts for. | [optional] |
| **label** | **String**| Comma separated labels to list deposit bank accounts for. | [optional] |
| **uniqueMemoId** | **String**| Comma separated unique memo ids to list deposit bank accounts for. | [optional] |
| **type** | **String**| Comma separated types to list deposit bank accounts for. | [optional] |
| **parentDepositBankAccountGuid** | **String**| Comma separated guids for parent accounts to list deposit bank accounts for. | [optional] |

### Return type

[**DepositBankAccountListBankModel**](DepositBankAccountListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of deposit bank accounts |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


# ExternalBankAccountsBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createExternalBankAccount**](ExternalBankAccountsBankApi.md#createExternalBankAccount) | **POST** /api/external_bank_accounts | Create ExternalBankAccount |
| [**deleteExternalBankAccount**](ExternalBankAccountsBankApi.md#deleteExternalBankAccount) | **DELETE** /api/external_bank_accounts/{external_bank_account_guid} | Delete External Bank Account |
| [**getExternalBankAccount**](ExternalBankAccountsBankApi.md#getExternalBankAccount) | **GET** /api/external_bank_accounts/{external_bank_account_guid} | Get External Bank Account |
| [**listExternalBankAccounts**](ExternalBankAccountsBankApi.md#listExternalBankAccounts) | **GET** /api/external_bank_accounts | Get external bank accounts list |
| [**patchExternalBankAccount**](ExternalBankAccountsBankApi.md#patchExternalBankAccount) | **PATCH** /api/external_bank_accounts/{external_bank_account_guid} | Patch ExternalBankAccount |



## createExternalBankAccount

> ExternalBankAccountBankModel createExternalBankAccount(postExternalBankAccountBankModel)

Create ExternalBankAccount

Create an ExternalBankAccount.  Required scope: **external_bank_accounts:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.ExternalBankAccountsBankApi;

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

        ExternalBankAccountsBankApi apiInstance = new ExternalBankAccountsBankApi(defaultClient);
        PostExternalBankAccountBankModel postExternalBankAccountBankModel = new PostExternalBankAccountBankModel(); // PostExternalBankAccountBankModel | 
        try {
            ExternalBankAccountBankModel result = apiInstance.createExternalBankAccount(postExternalBankAccountBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExternalBankAccountsBankApi#createExternalBankAccount");
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
| **postExternalBankAccountBankModel** | [**PostExternalBankAccountBankModel**](PostExternalBankAccountBankModel.md)|  | |

### Return type

[**ExternalBankAccountBankModel**](ExternalBankAccountBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | ExternalBankAccount created |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **422** | Unable to process request |  -  |


## deleteExternalBankAccount

> ExternalBankAccountBankModel deleteExternalBankAccount(externalBankAccountGuid)

Delete External Bank Account

Deletes an external bank account.  Required scope: **external_bank_accounts:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.ExternalBankAccountsBankApi;

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

        ExternalBankAccountsBankApi apiInstance = new ExternalBankAccountsBankApi(defaultClient);
        String externalBankAccountGuid = "externalBankAccountGuid_example"; // String | Identifier for the external bank account.
        try {
            ExternalBankAccountBankModel result = apiInstance.deleteExternalBankAccount(externalBankAccountGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExternalBankAccountsBankApi#deleteExternalBankAccount");
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
| **externalBankAccountGuid** | **String**| Identifier for the external bank account. | |

### Return type

[**ExternalBankAccountBankModel**](ExternalBankAccountBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | External bank account deleted |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | ExternalBankAccount not found |  -  |


## getExternalBankAccount

> ExternalBankAccountBankModel getExternalBankAccount(externalBankAccountGuid)

Get External Bank Account

Retrieves an external bank account.  Required scope: **external_bank_accounts:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.ExternalBankAccountsBankApi;

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

        ExternalBankAccountsBankApi apiInstance = new ExternalBankAccountsBankApi(defaultClient);
        String externalBankAccountGuid = "externalBankAccountGuid_example"; // String | Identifier for the external bank account.
        try {
            ExternalBankAccountBankModel result = apiInstance.getExternalBankAccount(externalBankAccountGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExternalBankAccountsBankApi#getExternalBankAccount");
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
| **externalBankAccountGuid** | **String**| Identifier for the external bank account. | |

### Return type

[**ExternalBankAccountBankModel**](ExternalBankAccountBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | External bank account found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | ExternalBankAccount not found |  -  |


## listExternalBankAccounts

> ExternalBankAccountListBankModel listExternalBankAccounts(page, perPage, guid, bankGuid, customerGuid, state)

Get external bank accounts list

Retrieves a listing of external bank accounts.  Required scope: **external_bank_accounts:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.ExternalBankAccountsBankApi;

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

        ExternalBankAccountsBankApi apiInstance = new ExternalBankAccountsBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated external_bank_account_guids to list external_bank_accounts for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list external_bank_accounts for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list external_bank_accounts for.
        String state = "state_example"; // String | Comma separated states to list external_bank_accounts for.
        try {
            ExternalBankAccountListBankModel result = apiInstance.listExternalBankAccounts(page, perPage, guid, bankGuid, customerGuid, state);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExternalBankAccountsBankApi#listExternalBankAccounts");
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
| **guid** | **String**| Comma separated external_bank_account_guids to list external_bank_accounts for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list external_bank_accounts for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list external_bank_accounts for. | [optional] |
| **state** | **String**| Comma separated states to list external_bank_accounts for. | [optional] |

### Return type

[**ExternalBankAccountListBankModel**](ExternalBankAccountListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Get list of external_bank_accounts |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


## patchExternalBankAccount

> ExternalBankAccountBankModel patchExternalBankAccount(externalBankAccountGuid, patchExternalBankAccountBankModel)

Patch ExternalBankAccount

Patch an external bank account.  Required scope: **external_bank_accounts:write**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.ExternalBankAccountsBankApi;

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

        ExternalBankAccountsBankApi apiInstance = new ExternalBankAccountsBankApi(defaultClient);
        String externalBankAccountGuid = "externalBankAccountGuid_example"; // String | Identifier for the external bank account.
        PatchExternalBankAccountBankModel patchExternalBankAccountBankModel = new PatchExternalBankAccountBankModel(); // PatchExternalBankAccountBankModel | 
        try {
            ExternalBankAccountBankModel result = apiInstance.patchExternalBankAccount(externalBankAccountGuid, patchExternalBankAccountBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExternalBankAccountsBankApi#patchExternalBankAccount");
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
| **externalBankAccountGuid** | **String**| Identifier for the external bank account. | |
| **patchExternalBankAccountBankModel** | [**PatchExternalBankAccountBankModel**](PatchExternalBankAccountBankModel.md)|  | |

### Return type

[**ExternalBankAccountBankModel**](ExternalBankAccountBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | external bank account found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | ExternalBankAccount not found |  -  |


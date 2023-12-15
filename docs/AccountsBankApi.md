# AccountsBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAccount**](AccountsBankApi.md#createAccount) | **POST** /api/accounts | Create Account |
| [**getAccount**](AccountsBankApi.md#getAccount) | **GET** /api/accounts/{account_guid} | Get Account |
| [**listAccounts**](AccountsBankApi.md#listAccounts) | **GET** /api/accounts | List Accounts |



## createAccount

> AccountBankModel createAccount(postAccountBankModel)

Create Account

Creates an account.  ## Account Type  An Account is tied to a specific cryptocurrency or fiat and is comprised of transactions and a current balance.  An account is required to allow a Bank or Customer to hold cryptocurrency or a Customer to hold fiat on the Cybrid Platform.  At present, account&#39;s can be created as &#x60;trading&#x60; or &#x60;fiat &#x60; accounts and are required before a Customer can generate quotes or execute a &#x60;trade&#x60; or &#x60;transfer&#x60;.  ## Asset  The asset is the specific cryptocurrency or fiat that the account holds, e.g., &#39;BTC&#39; for Bitcoin or &#x60;USD&#x60; for US dollars. See the Symbols API for a complete list of cryptocurrencies and fiat supported.   ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the account details in our private store | | created | The Platform has created the account |    Required scope: **accounts:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.AccountsBankApi;

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

        AccountsBankApi apiInstance = new AccountsBankApi(defaultClient);
        PostAccountBankModel postAccountBankModel = new PostAccountBankModel(); // PostAccountBankModel | 
        try {
            AccountBankModel result = apiInstance.createAccount(postAccountBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountsBankApi#createAccount");
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
| **postAccountBankModel** | [**PostAccountBankModel**](PostAccountBankModel.md)|  | |

### Return type

[**AccountBankModel**](AccountBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | account created |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


## getAccount

> AccountBankModel getAccount(accountGuid)

Get Account

Retrieves an account.  Required scope: **accounts:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.AccountsBankApi;

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

        AccountsBankApi apiInstance = new AccountsBankApi(defaultClient);
        String accountGuid = "accountGuid_example"; // String | Identifier for the account.
        try {
            AccountBankModel result = apiInstance.getAccount(accountGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountsBankApi#getAccount");
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
| **accountGuid** | **String**| Identifier for the account. | |

### Return type

[**AccountBankModel**](AccountBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | account found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | account not found |  -  |


## listAccounts

> AccountListBankModel listAccounts(page, perPage, owner, guid, type, bankGuid, customerGuid, label)

List Accounts

Retrieves a list of accounts.  Required scope: **accounts:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.AccountsBankApi;

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

        AccountsBankApi apiInstance = new AccountsBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String owner = "owner_example"; // String | The owner of the entity.
        String guid = "guid_example"; // String | Comma separated account_guids to list accounts for.
        String type = "type_example"; // String | Comma separated account_types to list accounts for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list accounts for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list accounts for.
        String label = "label_example"; // String | Comma separated labels to list accounts for.
        try {
            AccountListBankModel result = apiInstance.listAccounts(page, perPage, owner, guid, type, bankGuid, customerGuid, label);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountsBankApi#listAccounts");
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
| **owner** | **String**| The owner of the entity. | [optional] |
| **guid** | **String**| Comma separated account_guids to list accounts for. | [optional] |
| **type** | **String**| Comma separated account_types to list accounts for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list accounts for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list accounts for. | [optional] |
| **label** | **String**| Comma separated labels to list accounts for. | [optional] |

### Return type

[**AccountListBankModel**](AccountListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of accounts |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


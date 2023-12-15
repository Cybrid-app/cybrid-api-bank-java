# ExternalWalletsBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createExternalWallet**](ExternalWalletsBankApi.md#createExternalWallet) | **POST** /api/external_wallets | Create ExternalWallet |
| [**deleteExternalWallet**](ExternalWalletsBankApi.md#deleteExternalWallet) | **DELETE** /api/external_wallets/{external_wallet_guid} | Delete External Wallet |
| [**getExternalWallet**](ExternalWalletsBankApi.md#getExternalWallet) | **GET** /api/external_wallets/{external_wallet_guid} | Get External Wallet |
| [**listExternalWallets**](ExternalWalletsBankApi.md#listExternalWallets) | **GET** /api/external_wallets | Get external wallets list |



## createExternalWallet

> ExternalWalletBankModel createExternalWallet(postExternalWalletBankModel)

Create ExternalWallet

Create an ExternalWallet.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the external wallet details in our private store | | pending | The Platform is waiting for the external wallet to be created | | completed | The Platform has created the external wallet | | failed | The Platform was not able to successfully create the external wallet | | deleting | The Platform is deleting the external wallet | | deleted | The Platform has deleted the external wallet |    External wallets can be added to the bank by leaving the customer_guid blank. External wallets added to the bank can be used by any customer of the bank.  External wallets can also be added to a specific customer by providing the customer_guid. External wallets added to a customer can only be used by that customer.  Required scope: **external_wallets:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.ExternalWalletsBankApi;

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

        ExternalWalletsBankApi apiInstance = new ExternalWalletsBankApi(defaultClient);
        PostExternalWalletBankModel postExternalWalletBankModel = new PostExternalWalletBankModel(); // PostExternalWalletBankModel | 
        try {
            ExternalWalletBankModel result = apiInstance.createExternalWallet(postExternalWalletBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExternalWalletsBankApi#createExternalWallet");
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
| **postExternalWalletBankModel** | [**PostExternalWalletBankModel**](PostExternalWalletBankModel.md)|  | |

### Return type

[**ExternalWalletBankModel**](ExternalWalletBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | ExternalWallet created |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **409** | Data already exists |  -  |
| **422** | Unable to process request |  -  |


## deleteExternalWallet

> ExternalWalletBankModel deleteExternalWallet(externalWalletGuid)

Delete External Wallet

Deletes an external wallet.  Required scope: **external_wallets:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.ExternalWalletsBankApi;

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

        ExternalWalletsBankApi apiInstance = new ExternalWalletsBankApi(defaultClient);
        String externalWalletGuid = "externalWalletGuid_example"; // String | Identifier for the external wallet.
        try {
            ExternalWalletBankModel result = apiInstance.deleteExternalWallet(externalWalletGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExternalWalletsBankApi#deleteExternalWallet");
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
| **externalWalletGuid** | **String**| Identifier for the external wallet. | |

### Return type

[**ExternalWalletBankModel**](ExternalWalletBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | External wallet deleted |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | ExternalWallet not found |  -  |


## getExternalWallet

> ExternalWalletBankModel getExternalWallet(externalWalletGuid)

Get External Wallet

Retrieves an external_wallet.  Required scope: **external_wallets:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.ExternalWalletsBankApi;

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

        ExternalWalletsBankApi apiInstance = new ExternalWalletsBankApi(defaultClient);
        String externalWalletGuid = "externalWalletGuid_example"; // String | Identifier for the external_wallet.
        try {
            ExternalWalletBankModel result = apiInstance.getExternalWallet(externalWalletGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExternalWalletsBankApi#getExternalWallet");
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
| **externalWalletGuid** | **String**| Identifier for the external_wallet. | |

### Return type

[**ExternalWalletBankModel**](ExternalWalletBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | External wallet found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | ExternalWallet not found |  -  |


## listExternalWallets

> ExternalWalletListBankModel listExternalWallets(page, perPage, owner, guid, bankGuid, customerGuid, state)

Get external wallets list

Retrieves a listing of external wallets.  Required scope: **external_wallets:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.ExternalWalletsBankApi;

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

        ExternalWalletsBankApi apiInstance = new ExternalWalletsBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String owner = "owner_example"; // String | The owner of the entity.
        String guid = "guid_example"; // String | Comma separated external_wallet_guids to list external_wallets for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list external_wallets for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list external_wallets for.
        String state = "state_example"; // String | Comma separated states to list external_wallets for.
        try {
            ExternalWalletListBankModel result = apiInstance.listExternalWallets(page, perPage, owner, guid, bankGuid, customerGuid, state);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExternalWalletsBankApi#listExternalWallets");
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
| **guid** | **String**| Comma separated external_wallet_guids to list external_wallets for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list external_wallets for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list external_wallets for. | [optional] |
| **state** | **String**| Comma separated states to list external_wallets for. | [optional] |

### Return type

[**ExternalWalletListBankModel**](ExternalWalletListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Get list of external_wallets |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


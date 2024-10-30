# TransfersBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTransfer**](TransfersBankApi.md#createTransfer) | **POST** /api/transfers | Create Transfer |
| [**getTransfer**](TransfersBankApi.md#getTransfer) | **GET** /api/transfers/{transfer_guid} | Get Transfer |
| [**listTransfers**](TransfersBankApi.md#listTransfers) | **GET** /api/transfers | Get transfers list |



## createTransfer

> TransferBankModel createTransfer(postTransferBankModel)

Create Transfer

Creates a transfer.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the trade details in our private store | | reviewing | The Platform is reviewing the transfer for compliance | | pending | The Platform is executing the transfer | | completed | The Platform has successfully completed the transfer | | failed | The Platform was not able to successfully complete the transfer |  ## Failure codes  | Code | Description | |------|-------------| | amount_too_low | The transfer was rejected due to the amount being too low | | cancelled | The transfer was manually cancelled | | compliance_rejection | The transfer was rejected for compliance reasons | | internal_error | An internal error occurred while processing the transfer, please try again | | invalid_address | The destination address is invalid for transfer | | invalid_balance | There was insufficient balance at the lightning provider to complete the transfer | | limit_exceeded | The customer is over the limits that have been set for them for this activity | | network_fee_too_low | The transfer was rejected due to the network fee being too low | | non_sufficient_funds | The customer does not have enough funds to complete the transfer | | party_name_invalid | The transfer&#39;s associated external bank account has an invalid party name | | payment_rail_invalid | The payment rail specified for the transfer is not supported by the external bank account | | plaid_access_not_granted | See the description from Plaid [here](https://plaid.com/docs/errors/item/#access_not_granted) | | plaid_institution_not_responding | See the description from Plaid [here](https://plaid.com/docs/errors/institution/#institution_not_responding) | | plaid_internal_server_error | See the description from Plaid [here](https://plaid.com/docs/errors/api/#internal_server_error-or-plaid-internal-error) | | plaid_item_not_found | See the description from Plaid [here](https://plaid.com/docs/errors/item/#item_not_found) | | plaid_item_not_supported | See the description from Plaid [here](https://plaid.com/docs/errors/item/#item_not_supported) | | plaid_multiple_accounts | Multiple accounts were selected through Plaid Link. | | plaid_no_accounts | See the description from Plaid [here](https://plaid.com/docs/errors/item/#no_accounts) | | plaid_none_balances_error | The transfer was rejected due to an error with the balances retrieved by Plaid | | plaid_unknown_error | See the description from Plaid [here](https://plaid.com/docs/errors/api/#unknown_error) | | refresh_required | The transfer&#39;s associated external_bank_account needs to be reconnected via Plaid | | reversed | The transfer was reversed |  ## Failure codes that will result in a state change for the associated external bank account  | Code | Description | |------|-------------| | refresh_required | The transfer was rejected due to the external bank account needing to be refreshed. The external bank account will be put in the state &#x60;refresh_required&#x60; | | plaid_access_not_granted | The transfer was rejected due to the external bank account needing to be reconnected via Plaid. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_item_not_found | The transfer was rejected due to the external bank account needing to be reconnected via Plaid. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_item_not_supported | The transfer was rejected because the account is not supported. A different account should be connected via Plaid. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_multiple_accounts | The transfer was rejected because multiple accounts were selected through Plaid Link. Only one account must be selected. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_no_accounts | The transfer was rejected because no compatible accounts could be found. The external bank account will be put in the state &#x60;deleted&#x60; |    Required scope: **transfers:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TransfersBankApi;

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

        TransfersBankApi apiInstance = new TransfersBankApi(defaultClient);
        PostTransferBankModel postTransferBankModel = new PostTransferBankModel(); // PostTransferBankModel | 
        try {
            TransferBankModel result = apiInstance.createTransfer(postTransferBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransfersBankApi#createTransfer");
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
| **postTransferBankModel** | [**PostTransferBankModel**](PostTransferBankModel.md)|  | |

### Return type

[**TransferBankModel**](TransferBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Transfer created |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **409** | Conflict |  -  |
| **422** | Unprocessable Content |  -  |


## getTransfer

> TransferBankModel getTransfer(transferGuid)

Get Transfer

Retrieves a transfer.  Required scope: **transfers:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TransfersBankApi;

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

        TransfersBankApi apiInstance = new TransfersBankApi(defaultClient);
        String transferGuid = "transferGuid_example"; // String | Identifier for the transfer.
        try {
            TransferBankModel result = apiInstance.getTransfer(transferGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransfersBankApi#getTransfer");
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
| **transferGuid** | **String**| Identifier for the transfer. | |

### Return type

[**TransferBankModel**](TransferBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | transfer found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | transfer not found |  -  |


## listTransfers

> TransferListBankModel listTransfers(page, perPage, guid, transferType, bankGuid, customerGuid, accountGuid, state, side, label, txnHash, createdAtGte, createdAtLt, updatedAtGte, updatedAtLt)

Get transfers list

Retrieves a listing of transfers.  Required scope: **transfers:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.TransfersBankApi;

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

        TransfersBankApi apiInstance = new TransfersBankApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated transfer_guids to list transfers for.
        String transferType = "transferType_example"; // String | Comma separated transfer_types to list accounts for.
        String bankGuid = "bankGuid_example"; // String | Comma separated bank_guids to list transfers for.
        String customerGuid = "customerGuid_example"; // String | Comma separated customer_guids to list transfers for.
        String accountGuid = "accountGuid_example"; // String | Comma separated account_guids to list transfers for.
        String state = "state_example"; // String | Comma separated states to list transfers for.
        String side = "side_example"; // String | Comma separated sides to list transfers for.
        String label = "label_example"; // String | Comma separated labels to list transfers for.
        String txnHash = "txnHash_example"; // String | Comma separated transaction hashes to list transfers for.
        String createdAtGte = "createdAtGte_example"; // String | Created at start date inclusive lower bound, ISO8601
        String createdAtLt = "createdAtLt_example"; // String | Created at end date exclusive upper bound, ISO8601.
        String updatedAtGte = "updatedAtGte_example"; // String | Created at start date inclusive lower bound, ISO8601
        String updatedAtLt = "updatedAtLt_example"; // String | Created at end date exclusive upper bound, ISO8601.
        try {
            TransferListBankModel result = apiInstance.listTransfers(page, perPage, guid, transferType, bankGuid, customerGuid, accountGuid, state, side, label, txnHash, createdAtGte, createdAtLt, updatedAtGte, updatedAtLt);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransfersBankApi#listTransfers");
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
| **guid** | **String**| Comma separated transfer_guids to list transfers for. | [optional] |
| **transferType** | **String**| Comma separated transfer_types to list accounts for. | [optional] |
| **bankGuid** | **String**| Comma separated bank_guids to list transfers for. | [optional] |
| **customerGuid** | **String**| Comma separated customer_guids to list transfers for. | [optional] |
| **accountGuid** | **String**| Comma separated account_guids to list transfers for. | [optional] |
| **state** | **String**| Comma separated states to list transfers for. | [optional] |
| **side** | **String**| Comma separated sides to list transfers for. | [optional] |
| **label** | **String**| Comma separated labels to list transfers for. | [optional] |
| **txnHash** | **String**| Comma separated transaction hashes to list transfers for. | [optional] |
| **createdAtGte** | **String**| Created at start date inclusive lower bound, ISO8601 | [optional] |
| **createdAtLt** | **String**| Created at end date exclusive upper bound, ISO8601. | [optional] |
| **updatedAtGte** | **String**| Created at start date inclusive lower bound, ISO8601 | [optional] |
| **updatedAtLt** | **String**| Created at end date exclusive upper bound, ISO8601. | [optional] |

### Return type

[**TransferListBankModel**](TransferListBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | get list of transfers |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


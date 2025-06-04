# PersonaSessionsBankApi

All URIs are relative to *https://bank.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createPersonaSession**](PersonaSessionsBankApi.md#createPersonaSession) | **POST** /api/persona_sessions | Create Persona Session |



## createPersonaSession

> PersonaSessionBankModel createPersonaSession(postPersonaSessionBankModel)

Create Persona Session

Create a Persona session.  Required scope: **persona_sessions:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_bank.client.ApiClient;
import app.cybrid.cybrid_api_bank.client.ApiException;
import app.cybrid.cybrid_api_bank.client.Configuration;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.models.*;
import app.cybrid.cybrid_api_bank.client.api.PersonaSessionsBankApi;

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

        PersonaSessionsBankApi apiInstance = new PersonaSessionsBankApi(defaultClient);
        PostPersonaSessionBankModel postPersonaSessionBankModel = new PostPersonaSessionBankModel(); // PostPersonaSessionBankModel | 
        try {
            PersonaSessionBankModel result = apiInstance.createPersonaSession(postPersonaSessionBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PersonaSessionsBankApi#createPersonaSession");
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
| **postPersonaSessionBankModel** | [**PostPersonaSessionBankModel**](PostPersonaSessionBankModel.md)|  | |

### Return type

[**PersonaSessionBankModel**](PersonaSessionBankModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | session created |  -  |
| **409** | Inquiry already completed |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | Identity verification not found |  -  |


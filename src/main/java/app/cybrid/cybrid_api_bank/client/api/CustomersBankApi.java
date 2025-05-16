package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.CustomerBankModel;
import app.cybrid.cybrid_api_bank.client.model.CustomerListBankModel;
import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PatchCustomerBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostCustomerBankModel;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-16T21:15:28.271537Z[Etc/UTC]")
public class CustomersBankApi {
    private ApiClient apiClient;

    public CustomersBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public CustomersBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Customer
     * Creates a customer.  ## Customer Type  Customer resources are an abstraction for real world individuals and businesses on the Cybrid Platform and are used throughout the platform to perform high level operations, e.g., create a quote, execute a trade, etc..  Customers can have additional resources attached to them, e.g., identity verifications, accounts, etc.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the customer details in our private store | | unverified | The Platform has not yet verified the customer&#39;s identity | | verified | The Platform has verified the customer&#39;s identity | | rejected | The Platform was not able to successfully verify the customer&#39;s identity | | frozen | The customer has been frozen on the Platform |    Required scope: **customers:execute**
     * <p><b>201</b> - customer created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>422</b> - Unprocessable Content
     * @param postCustomerBankModel The postCustomerBankModel parameter
     * @return CustomerBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createCustomerRequestCreation(PostCustomerBankModel postCustomerBankModel) throws WebClientResponseException {
        Object postBody = postCustomerBankModel;
        // verify the required parameter 'postCustomerBankModel' is set
        if (postCustomerBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postCustomerBankModel' when calling createCustomer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<CustomerBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerBankModel>() {};
        return apiClient.invokeAPI("/api/customers", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Customer
     * Creates a customer.  ## Customer Type  Customer resources are an abstraction for real world individuals and businesses on the Cybrid Platform and are used throughout the platform to perform high level operations, e.g., create a quote, execute a trade, etc..  Customers can have additional resources attached to them, e.g., identity verifications, accounts, etc.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the customer details in our private store | | unverified | The Platform has not yet verified the customer&#39;s identity | | verified | The Platform has verified the customer&#39;s identity | | rejected | The Platform was not able to successfully verify the customer&#39;s identity | | frozen | The customer has been frozen on the Platform |    Required scope: **customers:execute**
     * <p><b>201</b> - customer created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>422</b> - Unprocessable Content
     * @param postCustomerBankModel The postCustomerBankModel parameter
     * @return CustomerBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CustomerBankModel> createCustomer(PostCustomerBankModel postCustomerBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerBankModel>() {};
        return createCustomerRequestCreation(postCustomerBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<CustomerBankModel>> createCustomerWithHttpInfo(PostCustomerBankModel postCustomerBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerBankModel>() {};
        return createCustomerRequestCreation(postCustomerBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Customer
     * Retrieves a customer.  Required scope: **customers:read**
     * <p><b>200</b> - customer found
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - customer not found
     * @param customerGuid Identifier for the customer.
     * @param includePii Include PII in the response.
     * @return CustomerBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getCustomerRequestCreation(String customerGuid, Boolean includePii) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerGuid' is set
        if (customerGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerGuid' when calling getCustomer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customer_guid", customerGuid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_pii", includePii));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<CustomerBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerBankModel>() {};
        return apiClient.invokeAPI("/api/customers/{customer_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Customer
     * Retrieves a customer.  Required scope: **customers:read**
     * <p><b>200</b> - customer found
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - customer not found
     * @param customerGuid Identifier for the customer.
     * @param includePii Include PII in the response.
     * @return CustomerBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CustomerBankModel> getCustomer(String customerGuid, Boolean includePii) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerBankModel>() {};
        return getCustomerRequestCreation(customerGuid, includePii).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<CustomerBankModel>> getCustomerWithHttpInfo(String customerGuid, Boolean includePii) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerBankModel>() {};
        return getCustomerRequestCreation(customerGuid, includePii).toEntity(localVarReturnType);
    }
    /**
     * Get customers list
     * Retrieves a listing of customers.  Required scope: **customers:read**
     * <p><b>200</b> - get list of customers
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject,
     * <p><b>403</b> - Invalid scope
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @param type Comma separated types to list customers for.
     * @param bankGuid Comma separated bank_guids to list customers for.
     * @param guid Comma separated customer_guids to list customers for.
     * @param label Comma separated labels to list customers for.
     * @return CustomerListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listCustomersRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String type, String bankGuid, String guid, String label) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "per_page", perPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bank_guid", bankGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "guid", guid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "label", label));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<CustomerListBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerListBankModel>() {};
        return apiClient.invokeAPI("/api/customers", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get customers list
     * Retrieves a listing of customers.  Required scope: **customers:read**
     * <p><b>200</b> - get list of customers
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject,
     * <p><b>403</b> - Invalid scope
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @param type Comma separated types to list customers for.
     * @param bankGuid Comma separated bank_guids to list customers for.
     * @param guid Comma separated customer_guids to list customers for.
     * @param label Comma separated labels to list customers for.
     * @return CustomerListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CustomerListBankModel> listCustomers(java.math.BigInteger page, java.math.BigInteger perPage, String type, String bankGuid, String guid, String label) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerListBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerListBankModel>() {};
        return listCustomersRequestCreation(page, perPage, type, bankGuid, guid, label).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<CustomerListBankModel>> listCustomersWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String type, String bankGuid, String guid, String label) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerListBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerListBankModel>() {};
        return listCustomersRequestCreation(page, perPage, type, bankGuid, guid, label).toEntity(localVarReturnType);
    }
    /**
     * Patch Customer
     * Update a customer.  Required scope: **customers:write**
     * <p><b>200</b> - customer found
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>400</b> - Bad Request
     * @param customerGuid Identifier for the customer.
     * @param patchCustomerBankModel The patchCustomerBankModel parameter
     * @return CustomerBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateCustomerRequestCreation(String customerGuid, PatchCustomerBankModel patchCustomerBankModel) throws WebClientResponseException {
        Object postBody = patchCustomerBankModel;
        // verify the required parameter 'customerGuid' is set
        if (customerGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerGuid' when calling updateCustomer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'patchCustomerBankModel' is set
        if (patchCustomerBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'patchCustomerBankModel' when calling updateCustomer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customer_guid", customerGuid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<CustomerBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerBankModel>() {};
        return apiClient.invokeAPI("/api/customers/{customer_guid}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Patch Customer
     * Update a customer.  Required scope: **customers:write**
     * <p><b>200</b> - customer found
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>400</b> - Bad Request
     * @param customerGuid Identifier for the customer.
     * @param patchCustomerBankModel The patchCustomerBankModel parameter
     * @return CustomerBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CustomerBankModel> updateCustomer(String customerGuid, PatchCustomerBankModel patchCustomerBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerBankModel>() {};
        return updateCustomerRequestCreation(customerGuid, patchCustomerBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<CustomerBankModel>> updateCustomerWithHttpInfo(String customerGuid, PatchCustomerBankModel patchCustomerBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerBankModel>() {};
        return updateCustomerRequestCreation(customerGuid, patchCustomerBankModel).toEntity(localVarReturnType);
    }
}

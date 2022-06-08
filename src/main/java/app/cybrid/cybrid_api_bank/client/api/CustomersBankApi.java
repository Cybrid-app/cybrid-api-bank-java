package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.CustomerBankModel;
import app.cybrid.cybrid_api_bank.client.model.CustomerListBankModel;
import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-08T01:57:10.757480Z[Etc/UTC]")
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
     * Creates a customer.  ## Customer Type  Customer resources are an abstraction for real world individuals and businesses on the Cybrid Platform and are used throughout the platform to perform high level operations, e.g., create a quote, execute a trade, etc..  Customers can have additional resources attached to them, e.g., identity records, accounts, etc.  At present, Customer&#39;s can be created with type &#x60;individual&#x60;.    Required scope: **customers:execute**
     * <p><b>201</b> - customer created
     * <p><b>400</b> - Invalid requests - malformed authentication header
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
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
     * Creates a customer.  ## Customer Type  Customer resources are an abstraction for real world individuals and businesses on the Cybrid Platform and are used throughout the platform to perform high level operations, e.g., create a quote, execute a trade, etc..  Customers can have additional resources attached to them, e.g., identity records, accounts, etc.  At present, Customer&#39;s can be created with type &#x60;individual&#x60;.    Required scope: **customers:execute**
     * <p><b>201</b> - customer created
     * <p><b>400</b> - Invalid requests - malformed authentication header
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
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
     * <p><b>400</b> - Invalid requests - malformed authentication header
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - customer not found
     * @param customerGuid Identifier for the customer.
     * @return CustomerBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getCustomerRequestCreation(String customerGuid) throws WebClientResponseException {
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
     * <p><b>400</b> - Invalid requests - malformed authentication header
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - customer not found
     * @param customerGuid Identifier for the customer.
     * @return CustomerBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CustomerBankModel> getCustomer(String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerBankModel>() {};
        return getCustomerRequestCreation(customerGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<CustomerBankModel>> getCustomerWithHttpInfo(String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerBankModel>() {};
        return getCustomerRequestCreation(customerGuid).toEntity(localVarReturnType);
    }
    /**
     * Get customers list
     * Retrieves a listing of customers.  Required scope: **customers:read**
     * <p><b>200</b> - get list of customers
     * <p><b>400</b> - Invalid requests - malformed authentication header
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject,
     * <p><b>403</b> - Invalid scope
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @param bankGuid Comma separated bank_guids to list customers for.
     * @param guid Comma separated customer_guids to list customers for.
     * @return CustomerListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listCustomersRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String bankGuid, String guid) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "per_page", perPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bank_guid", bankGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "guid", guid));

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
     * <p><b>400</b> - Invalid requests - malformed authentication header
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject,
     * <p><b>403</b> - Invalid scope
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @param bankGuid Comma separated bank_guids to list customers for.
     * @param guid Comma separated customer_guids to list customers for.
     * @return CustomerListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CustomerListBankModel> listCustomers(java.math.BigInteger page, java.math.BigInteger perPage, String bankGuid, String guid) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerListBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerListBankModel>() {};
        return listCustomersRequestCreation(page, perPage, bankGuid, guid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<CustomerListBankModel>> listCustomersWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String bankGuid, String guid) throws WebClientResponseException {
        ParameterizedTypeReference<CustomerListBankModel> localVarReturnType = new ParameterizedTypeReference<CustomerListBankModel>() {};
        return listCustomersRequestCreation(page, perPage, bankGuid, guid).toEntity(localVarReturnType);
    }
}

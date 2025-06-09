package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.DepositAddressBankModel;
import app.cybrid.cybrid_api_bank.client.model.DepositAddressListBankModel;
import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostDepositAddressBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-09T14:09:02.760476Z[Etc/UTC]")
public class DepositAddressesBankApi {
    private ApiClient apiClient;

    public DepositAddressesBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public DepositAddressesBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Deposit Address
     * Creates a deposit address.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the deposit address details in our private store | | created | The Platform has created the deposit address |    Required scope: **deposit_addresses:execute**
     * <p><b>201</b> - Deposit Address created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postDepositAddressBankModel The postDepositAddressBankModel parameter
     * @return DepositAddressBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createDepositAddressRequestCreation(PostDepositAddressBankModel postDepositAddressBankModel) throws WebClientResponseException {
        Object postBody = postDepositAddressBankModel;
        // verify the required parameter 'postDepositAddressBankModel' is set
        if (postDepositAddressBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postDepositAddressBankModel' when calling createDepositAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<DepositAddressBankModel> localVarReturnType = new ParameterizedTypeReference<DepositAddressBankModel>() {};
        return apiClient.invokeAPI("/api/deposit_addresses", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Deposit Address
     * Creates a deposit address.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the deposit address details in our private store | | created | The Platform has created the deposit address |    Required scope: **deposit_addresses:execute**
     * <p><b>201</b> - Deposit Address created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postDepositAddressBankModel The postDepositAddressBankModel parameter
     * @return DepositAddressBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DepositAddressBankModel> createDepositAddress(PostDepositAddressBankModel postDepositAddressBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<DepositAddressBankModel> localVarReturnType = new ParameterizedTypeReference<DepositAddressBankModel>() {};
        return createDepositAddressRequestCreation(postDepositAddressBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<DepositAddressBankModel>> createDepositAddressWithHttpInfo(PostDepositAddressBankModel postDepositAddressBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<DepositAddressBankModel> localVarReturnType = new ParameterizedTypeReference<DepositAddressBankModel>() {};
        return createDepositAddressRequestCreation(postDepositAddressBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Deposit Address
     * Retrieves a deposit address.  Required scope: **deposit_addresses:read**
     * <p><b>200</b> - deposit address found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - deposit_address not found
     * @param depositAddressGuid Identifier for the deposit address.
     * @return DepositAddressBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getDepositAddressRequestCreation(String depositAddressGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'depositAddressGuid' is set
        if (depositAddressGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'depositAddressGuid' when calling getDepositAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("deposit_address_guid", depositAddressGuid);

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

        ParameterizedTypeReference<DepositAddressBankModel> localVarReturnType = new ParameterizedTypeReference<DepositAddressBankModel>() {};
        return apiClient.invokeAPI("/api/deposit_addresses/{deposit_address_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Deposit Address
     * Retrieves a deposit address.  Required scope: **deposit_addresses:read**
     * <p><b>200</b> - deposit address found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - deposit_address not found
     * @param depositAddressGuid Identifier for the deposit address.
     * @return DepositAddressBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DepositAddressBankModel> getDepositAddress(String depositAddressGuid) throws WebClientResponseException {
        ParameterizedTypeReference<DepositAddressBankModel> localVarReturnType = new ParameterizedTypeReference<DepositAddressBankModel>() {};
        return getDepositAddressRequestCreation(depositAddressGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<DepositAddressBankModel>> getDepositAddressWithHttpInfo(String depositAddressGuid) throws WebClientResponseException {
        ParameterizedTypeReference<DepositAddressBankModel> localVarReturnType = new ParameterizedTypeReference<DepositAddressBankModel>() {};
        return getDepositAddressRequestCreation(depositAddressGuid).toEntity(localVarReturnType);
    }
    /**
     * List Deposit Addresses
     * Retrieves a list of deposit addresses.  Required scope: **deposit_addresses:read**
     * <p><b>200</b> - get list of deposit addresses
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated guids to list deposit addresses for.
     * @param bankGuid Comma separated bank_guids to list deposit addresses for.
     * @param customerGuid Comma separated customer_guids to list deposit addresses for.
     * @param label Comma separated labels to list deposit addresses for.
     * @return DepositAddressListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listDepositAddressesRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String label) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "per_page", perPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "guid", guid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bank_guid", bankGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "customer_guid", customerGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "label", label));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<DepositAddressListBankModel> localVarReturnType = new ParameterizedTypeReference<DepositAddressListBankModel>() {};
        return apiClient.invokeAPI("/api/deposit_addresses", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Deposit Addresses
     * Retrieves a list of deposit addresses.  Required scope: **deposit_addresses:read**
     * <p><b>200</b> - get list of deposit addresses
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated guids to list deposit addresses for.
     * @param bankGuid Comma separated bank_guids to list deposit addresses for.
     * @param customerGuid Comma separated customer_guids to list deposit addresses for.
     * @param label Comma separated labels to list deposit addresses for.
     * @return DepositAddressListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DepositAddressListBankModel> listDepositAddresses(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String label) throws WebClientResponseException {
        ParameterizedTypeReference<DepositAddressListBankModel> localVarReturnType = new ParameterizedTypeReference<DepositAddressListBankModel>() {};
        return listDepositAddressesRequestCreation(page, perPage, guid, bankGuid, customerGuid, label).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<DepositAddressListBankModel>> listDepositAddressesWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String label) throws WebClientResponseException {
        ParameterizedTypeReference<DepositAddressListBankModel> localVarReturnType = new ParameterizedTypeReference<DepositAddressListBankModel>() {};
        return listDepositAddressesRequestCreation(page, perPage, guid, bankGuid, customerGuid, label).toEntity(localVarReturnType);
    }
}

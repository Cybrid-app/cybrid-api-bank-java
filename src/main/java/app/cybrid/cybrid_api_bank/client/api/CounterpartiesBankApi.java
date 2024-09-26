package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.CounterpartyBankModel;
import app.cybrid.cybrid_api_bank.client.model.CounterpartyListBankModel;
import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostCounterpartyBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-26T12:16:09.731143Z[Etc/UTC]")
public class CounterpartiesBankApi {
    private ApiClient apiClient;

    public CounterpartiesBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public CounterpartiesBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Counterparty
     * Creates a counterparty.  ## Counterparty Type  Counterparty resources are an abstraction for real world individuals and businesses that are not directly on the Cybrid Platform.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the counterparty details in our private store | | unverified | The Platform has not yet verified the counterparty&#39;s identity | | verified | The Platform has verified the counterparty&#39;s identity | | rejected | The Platform was not able to successfully verify the counterparty&#39;s identity |    Required scope: **counterparties:execute**
     * <p><b>201</b> - counterparty created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>422</b> - Unprocessable Content
     * @param postCounterpartyBankModel The postCounterpartyBankModel parameter
     * @return CounterpartyBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createCounterpartyRequestCreation(PostCounterpartyBankModel postCounterpartyBankModel) throws WebClientResponseException {
        Object postBody = postCounterpartyBankModel;
        // verify the required parameter 'postCounterpartyBankModel' is set
        if (postCounterpartyBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postCounterpartyBankModel' when calling createCounterparty", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<CounterpartyBankModel> localVarReturnType = new ParameterizedTypeReference<CounterpartyBankModel>() {};
        return apiClient.invokeAPI("/api/counterparties", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Counterparty
     * Creates a counterparty.  ## Counterparty Type  Counterparty resources are an abstraction for real world individuals and businesses that are not directly on the Cybrid Platform.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the counterparty details in our private store | | unverified | The Platform has not yet verified the counterparty&#39;s identity | | verified | The Platform has verified the counterparty&#39;s identity | | rejected | The Platform was not able to successfully verify the counterparty&#39;s identity |    Required scope: **counterparties:execute**
     * <p><b>201</b> - counterparty created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>422</b> - Unprocessable Content
     * @param postCounterpartyBankModel The postCounterpartyBankModel parameter
     * @return CounterpartyBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CounterpartyBankModel> createCounterparty(PostCounterpartyBankModel postCounterpartyBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<CounterpartyBankModel> localVarReturnType = new ParameterizedTypeReference<CounterpartyBankModel>() {};
        return createCounterpartyRequestCreation(postCounterpartyBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<CounterpartyBankModel>> createCounterpartyWithHttpInfo(PostCounterpartyBankModel postCounterpartyBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<CounterpartyBankModel> localVarReturnType = new ParameterizedTypeReference<CounterpartyBankModel>() {};
        return createCounterpartyRequestCreation(postCounterpartyBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Counterparty
     * Retrieves a counterparty.  Required scope: **counterparties:read**
     * <p><b>200</b> - counterparty found
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param counterpartyGuid Identifier for the counterparty.
     * @param includePii Include PII in the response.
     * @return CounterpartyBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getCounterpartyRequestCreation(String counterpartyGuid, Boolean includePii) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'counterpartyGuid' is set
        if (counterpartyGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'counterpartyGuid' when calling getCounterparty", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("counterparty_guid", counterpartyGuid);

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

        ParameterizedTypeReference<CounterpartyBankModel> localVarReturnType = new ParameterizedTypeReference<CounterpartyBankModel>() {};
        return apiClient.invokeAPI("/api/counterparties/{counterparty_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Counterparty
     * Retrieves a counterparty.  Required scope: **counterparties:read**
     * <p><b>200</b> - counterparty found
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param counterpartyGuid Identifier for the counterparty.
     * @param includePii Include PII in the response.
     * @return CounterpartyBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CounterpartyBankModel> getCounterparty(String counterpartyGuid, Boolean includePii) throws WebClientResponseException {
        ParameterizedTypeReference<CounterpartyBankModel> localVarReturnType = new ParameterizedTypeReference<CounterpartyBankModel>() {};
        return getCounterpartyRequestCreation(counterpartyGuid, includePii).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<CounterpartyBankModel>> getCounterpartyWithHttpInfo(String counterpartyGuid, Boolean includePii) throws WebClientResponseException {
        ParameterizedTypeReference<CounterpartyBankModel> localVarReturnType = new ParameterizedTypeReference<CounterpartyBankModel>() {};
        return getCounterpartyRequestCreation(counterpartyGuid, includePii).toEntity(localVarReturnType);
    }
    /**
     * Get counterparties list
     * Retrieves a listing of counterparties.  Required scope: **counterparties:read**
     * <p><b>200</b> - get list of counterparties
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @param type Comma separated types to list counterparties for.
     * @param bankGuid Comma separated bank_guids to list counterparties for.
     * @param customerGuid Comma separated customer_guids to list counterparties for.
     * @param guid Comma separated counterparty_guids to list counterparties for.
     * @param label Comma separated labels to list counterparties for.
     * @return CounterpartyListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listCounterpartiesRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String type, String bankGuid, String customerGuid, String guid, String label) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "customer_guid", customerGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "guid", guid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "label", label));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<CounterpartyListBankModel> localVarReturnType = new ParameterizedTypeReference<CounterpartyListBankModel>() {};
        return apiClient.invokeAPI("/api/counterparties", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get counterparties list
     * Retrieves a listing of counterparties.  Required scope: **counterparties:read**
     * <p><b>200</b> - get list of counterparties
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @param type Comma separated types to list counterparties for.
     * @param bankGuid Comma separated bank_guids to list counterparties for.
     * @param customerGuid Comma separated customer_guids to list counterparties for.
     * @param guid Comma separated counterparty_guids to list counterparties for.
     * @param label Comma separated labels to list counterparties for.
     * @return CounterpartyListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CounterpartyListBankModel> listCounterparties(java.math.BigInteger page, java.math.BigInteger perPage, String type, String bankGuid, String customerGuid, String guid, String label) throws WebClientResponseException {
        ParameterizedTypeReference<CounterpartyListBankModel> localVarReturnType = new ParameterizedTypeReference<CounterpartyListBankModel>() {};
        return listCounterpartiesRequestCreation(page, perPage, type, bankGuid, customerGuid, guid, label).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<CounterpartyListBankModel>> listCounterpartiesWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String type, String bankGuid, String customerGuid, String guid, String label) throws WebClientResponseException {
        ParameterizedTypeReference<CounterpartyListBankModel> localVarReturnType = new ParameterizedTypeReference<CounterpartyListBankModel>() {};
        return listCounterpartiesRequestCreation(page, perPage, type, bankGuid, customerGuid, guid, label).toEntity(localVarReturnType);
    }
}

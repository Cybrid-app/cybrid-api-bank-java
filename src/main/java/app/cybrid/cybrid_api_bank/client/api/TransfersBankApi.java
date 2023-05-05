package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostTransferBankModel;
import app.cybrid.cybrid_api_bank.client.model.TransferBankModel;
import app.cybrid.cybrid_api_bank.client.model.TransferListBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-05-05T12:17:53.746047Z[Etc/UTC]")
public class TransfersBankApi {
    private ApiClient apiClient;

    public TransfersBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public TransfersBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Transfer
     * Creates a transfer.  Required scope: **transfers:execute**
     * <p><b>201</b> - Transfer created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>409</b> - Data already exists
     * <p><b>422</b> - Unable to process request
     * @param postTransferBankModel The postTransferBankModel parameter
     * @return TransferBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createTransferRequestCreation(PostTransferBankModel postTransferBankModel) throws WebClientResponseException {
        Object postBody = postTransferBankModel;
        // verify the required parameter 'postTransferBankModel' is set
        if (postTransferBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postTransferBankModel' when calling createTransfer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<TransferBankModel> localVarReturnType = new ParameterizedTypeReference<TransferBankModel>() {};
        return apiClient.invokeAPI("/api/transfers", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Transfer
     * Creates a transfer.  Required scope: **transfers:execute**
     * <p><b>201</b> - Transfer created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>409</b> - Data already exists
     * <p><b>422</b> - Unable to process request
     * @param postTransferBankModel The postTransferBankModel parameter
     * @return TransferBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TransferBankModel> createTransfer(PostTransferBankModel postTransferBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<TransferBankModel> localVarReturnType = new ParameterizedTypeReference<TransferBankModel>() {};
        return createTransferRequestCreation(postTransferBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<TransferBankModel>> createTransferWithHttpInfo(PostTransferBankModel postTransferBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<TransferBankModel> localVarReturnType = new ParameterizedTypeReference<TransferBankModel>() {};
        return createTransferRequestCreation(postTransferBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Transfer
     * Retrieves a transfer.  Required scope: **transfers:read**
     * <p><b>200</b> - transfer found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - transfer not found
     * @param transferGuid Identifier for the transfer.
     * @return TransferBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTransferRequestCreation(String transferGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'transferGuid' is set
        if (transferGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'transferGuid' when calling getTransfer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("transfer_guid", transferGuid);

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

        ParameterizedTypeReference<TransferBankModel> localVarReturnType = new ParameterizedTypeReference<TransferBankModel>() {};
        return apiClient.invokeAPI("/api/transfers/{transfer_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Transfer
     * Retrieves a transfer.  Required scope: **transfers:read**
     * <p><b>200</b> - transfer found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - transfer not found
     * @param transferGuid Identifier for the transfer.
     * @return TransferBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TransferBankModel> getTransfer(String transferGuid) throws WebClientResponseException {
        ParameterizedTypeReference<TransferBankModel> localVarReturnType = new ParameterizedTypeReference<TransferBankModel>() {};
        return getTransferRequestCreation(transferGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<TransferBankModel>> getTransferWithHttpInfo(String transferGuid) throws WebClientResponseException {
        ParameterizedTypeReference<TransferBankModel> localVarReturnType = new ParameterizedTypeReference<TransferBankModel>() {};
        return getTransferRequestCreation(transferGuid).toEntity(localVarReturnType);
    }
    /**
     * Get transfers list
     * Retrieves a listing of transfers.  Required scope: **transfers:read**
     * <p><b>200</b> - get list of transfers
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated trade_guids to list transfers for.
     * @param bankGuid Comma separated bank_guids to list transfers for.
     * @param customerGuid Comma separated customer_guids to list transfers for.
     * @param accountGuid Comma separated account_guids to list transfers for.
     * @return TransferListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listTransfersRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String accountGuid) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_guid", accountGuid));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<TransferListBankModel> localVarReturnType = new ParameterizedTypeReference<TransferListBankModel>() {};
        return apiClient.invokeAPI("/api/transfers", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get transfers list
     * Retrieves a listing of transfers.  Required scope: **transfers:read**
     * <p><b>200</b> - get list of transfers
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated trade_guids to list transfers for.
     * @param bankGuid Comma separated bank_guids to list transfers for.
     * @param customerGuid Comma separated customer_guids to list transfers for.
     * @param accountGuid Comma separated account_guids to list transfers for.
     * @return TransferListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TransferListBankModel> listTransfers(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String accountGuid) throws WebClientResponseException {
        ParameterizedTypeReference<TransferListBankModel> localVarReturnType = new ParameterizedTypeReference<TransferListBankModel>() {};
        return listTransfersRequestCreation(page, perPage, guid, bankGuid, customerGuid, accountGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<TransferListBankModel>> listTransfersWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String accountGuid) throws WebClientResponseException {
        ParameterizedTypeReference<TransferListBankModel> localVarReturnType = new ParameterizedTypeReference<TransferListBankModel>() {};
        return listTransfersRequestCreation(page, perPage, guid, bankGuid, customerGuid, accountGuid).toEntity(localVarReturnType);
    }
}

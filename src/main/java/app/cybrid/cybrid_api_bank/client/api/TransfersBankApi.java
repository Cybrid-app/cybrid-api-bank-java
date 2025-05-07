package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PatchTransferBankModel;
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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-07T13:01:00.623701Z[Etc/UTC]")
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
     * Creates a transfer.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the transfer details in our private store | | reviewing | The Platform is reviewing the transfer for compliance | | pending | The Platform is executing the transfer | | completed | The Platform has successfully completed the transfer | | failed | The Platform was not able to successfully complete the transfer |  ## Failure codes  | Code | Description | |------|-------------| | amount_too_low | The transfer was rejected due to the amount being too low | | cancelled | The transfer was manually cancelled | | compliance_rejection | The transfer was rejected for compliance reasons | | internal_error | An internal error occurred while processing the transfer, please try again | | invalid_address | The destination address is invalid for transfer | | invalid_balance | There was insufficient balance for all required currencies to complete the transfer | | limit_exceeded | The customer is over the limits that have been set for them for this activity | | network_fee_too_low | The transfer was rejected due to the network fee being too low | | non_sufficient_funds | The customer does not have enough funds to complete the transfer | | party_name_invalid | The transfer&#39;s associated external bank account has an invalid party name | | payment_rail_invalid | The payment rail specified for the transfer is not supported by the external bank account | | plaid_access_not_granted | See the description from Plaid [here](https://plaid.com/docs/errors/item/#access_not_granted) | | plaid_institution_not_responding | See the description from Plaid [here](https://plaid.com/docs/errors/institution/#institution_not_responding) | | plaid_internal_server_error | See the description from Plaid [here](https://plaid.com/docs/errors/api/#internal_server_error-or-plaid-internal-error) | | plaid_item_not_found | See the description from Plaid [here](https://plaid.com/docs/errors/item/#item_not_found) | | plaid_item_not_supported | See the description from Plaid [here](https://plaid.com/docs/errors/item/#item_not_supported) | | plaid_multiple_accounts | Multiple accounts were selected through Plaid Link. | | plaid_no_accounts | See the description from Plaid [here](https://plaid.com/docs/errors/item/#no_accounts) | | plaid_none_balances_error | The transfer was rejected due to an error with the balances retrieved by Plaid | | plaid_unknown_error | See the description from Plaid [here](https://plaid.com/docs/errors/api/#unknown_error) | | refresh_required | The transfer&#39;s associated external_bank_account needs to be reconnected via Plaid | | reversed | The transfer was reversed |  ## Failure codes that will result in a state change for the associated external bank account  | Code | Description | |------|-------------| | refresh_required | The transfer was rejected due to the external bank account needing to be refreshed. The external bank account will be put in the state &#x60;refresh_required&#x60; | | plaid_access_not_granted | The transfer was rejected due to the external bank account needing to be reconnected via Plaid. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_item_not_found | The transfer was rejected due to the external bank account needing to be reconnected via Plaid. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_item_not_supported | The transfer was rejected because the account is not supported. A different account should be connected via Plaid. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_multiple_accounts | The transfer was rejected because multiple accounts were selected through Plaid Link. Only one account must be selected. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_no_accounts | The transfer was rejected because no compatible accounts could be found. The external bank account will be put in the state &#x60;deleted&#x60; |    Required scope: **transfers:execute**
     * <p><b>201</b> - Transfer created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
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
     * Creates a transfer.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the transfer details in our private store | | reviewing | The Platform is reviewing the transfer for compliance | | pending | The Platform is executing the transfer | | completed | The Platform has successfully completed the transfer | | failed | The Platform was not able to successfully complete the transfer |  ## Failure codes  | Code | Description | |------|-------------| | amount_too_low | The transfer was rejected due to the amount being too low | | cancelled | The transfer was manually cancelled | | compliance_rejection | The transfer was rejected for compliance reasons | | internal_error | An internal error occurred while processing the transfer, please try again | | invalid_address | The destination address is invalid for transfer | | invalid_balance | There was insufficient balance for all required currencies to complete the transfer | | limit_exceeded | The customer is over the limits that have been set for them for this activity | | network_fee_too_low | The transfer was rejected due to the network fee being too low | | non_sufficient_funds | The customer does not have enough funds to complete the transfer | | party_name_invalid | The transfer&#39;s associated external bank account has an invalid party name | | payment_rail_invalid | The payment rail specified for the transfer is not supported by the external bank account | | plaid_access_not_granted | See the description from Plaid [here](https://plaid.com/docs/errors/item/#access_not_granted) | | plaid_institution_not_responding | See the description from Plaid [here](https://plaid.com/docs/errors/institution/#institution_not_responding) | | plaid_internal_server_error | See the description from Plaid [here](https://plaid.com/docs/errors/api/#internal_server_error-or-plaid-internal-error) | | plaid_item_not_found | See the description from Plaid [here](https://plaid.com/docs/errors/item/#item_not_found) | | plaid_item_not_supported | See the description from Plaid [here](https://plaid.com/docs/errors/item/#item_not_supported) | | plaid_multiple_accounts | Multiple accounts were selected through Plaid Link. | | plaid_no_accounts | See the description from Plaid [here](https://plaid.com/docs/errors/item/#no_accounts) | | plaid_none_balances_error | The transfer was rejected due to an error with the balances retrieved by Plaid | | plaid_unknown_error | See the description from Plaid [here](https://plaid.com/docs/errors/api/#unknown_error) | | refresh_required | The transfer&#39;s associated external_bank_account needs to be reconnected via Plaid | | reversed | The transfer was reversed |  ## Failure codes that will result in a state change for the associated external bank account  | Code | Description | |------|-------------| | refresh_required | The transfer was rejected due to the external bank account needing to be refreshed. The external bank account will be put in the state &#x60;refresh_required&#x60; | | plaid_access_not_granted | The transfer was rejected due to the external bank account needing to be reconnected via Plaid. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_item_not_found | The transfer was rejected due to the external bank account needing to be reconnected via Plaid. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_item_not_supported | The transfer was rejected because the account is not supported. A different account should be connected via Plaid. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_multiple_accounts | The transfer was rejected because multiple accounts were selected through Plaid Link. Only one account must be selected. The external bank account will be put in the state &#x60;deleted&#x60; | | plaid_no_accounts | The transfer was rejected because no compatible accounts could be found. The external bank account will be put in the state &#x60;deleted&#x60; |    Required scope: **transfers:execute**
     * <p><b>201</b> - Transfer created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
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
     * @param guid Comma separated transfer_guids to list transfers for.
     * @param transferType Comma separated transfer_types to list accounts for.
     * @param bankGuid Comma separated bank_guids to list transfers for.
     * @param customerGuid Comma separated customer_guids to list transfers for.
     * @param accountGuid Comma separated account_guids to list transfers for.
     * @param state Comma separated states to list transfers for.
     * @param side Comma separated sides to list transfers for.
     * @param label Comma separated labels to list transfers for.
     * @param txnHash Comma separated transaction hashes to list transfers for.
     * @param createdAtGte Created at start date-time inclusive lower bound, ISO8601
     * @param createdAtLt Created at end date-time exclusive upper bound, ISO8601.
     * @param updatedAtGte Created at start date-time inclusive lower bound, ISO8601
     * @param updatedAtLt Created at end date-time exclusive upper bound, ISO8601.
     * @return TransferListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listTransfersRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String transferType, String bankGuid, String customerGuid, String accountGuid, String state, String side, String label, String txnHash, String createdAtGte, String createdAtLt, String updatedAtGte, String updatedAtLt) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "transfer_type", transferType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bank_guid", bankGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "customer_guid", customerGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_guid", accountGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "state", state));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "side", side));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "label", label));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "txn_hash", txnHash));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "created_at_gte", createdAtGte));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "created_at_lt", createdAtLt));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_at_gte", updatedAtGte));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_at_lt", updatedAtLt));

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
     * @param guid Comma separated transfer_guids to list transfers for.
     * @param transferType Comma separated transfer_types to list accounts for.
     * @param bankGuid Comma separated bank_guids to list transfers for.
     * @param customerGuid Comma separated customer_guids to list transfers for.
     * @param accountGuid Comma separated account_guids to list transfers for.
     * @param state Comma separated states to list transfers for.
     * @param side Comma separated sides to list transfers for.
     * @param label Comma separated labels to list transfers for.
     * @param txnHash Comma separated transaction hashes to list transfers for.
     * @param createdAtGte Created at start date-time inclusive lower bound, ISO8601
     * @param createdAtLt Created at end date-time exclusive upper bound, ISO8601.
     * @param updatedAtGte Created at start date-time inclusive lower bound, ISO8601
     * @param updatedAtLt Created at end date-time exclusive upper bound, ISO8601.
     * @return TransferListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TransferListBankModel> listTransfers(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String transferType, String bankGuid, String customerGuid, String accountGuid, String state, String side, String label, String txnHash, String createdAtGte, String createdAtLt, String updatedAtGte, String updatedAtLt) throws WebClientResponseException {
        ParameterizedTypeReference<TransferListBankModel> localVarReturnType = new ParameterizedTypeReference<TransferListBankModel>() {};
        return listTransfersRequestCreation(page, perPage, guid, transferType, bankGuid, customerGuid, accountGuid, state, side, label, txnHash, createdAtGte, createdAtLt, updatedAtGte, updatedAtLt).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<TransferListBankModel>> listTransfersWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String transferType, String bankGuid, String customerGuid, String accountGuid, String state, String side, String label, String txnHash, String createdAtGte, String createdAtLt, String updatedAtGte, String updatedAtLt) throws WebClientResponseException {
        ParameterizedTypeReference<TransferListBankModel> localVarReturnType = new ParameterizedTypeReference<TransferListBankModel>() {};
        return listTransfersRequestCreation(page, perPage, guid, transferType, bankGuid, customerGuid, accountGuid, state, side, label, txnHash, createdAtGte, createdAtLt, updatedAtGte, updatedAtLt).toEntity(localVarReturnType);
    }
    /**
     * Patch Transfer
     * Update a transfer.  Required scope: **transfers:write**
     * <p><b>200</b> - Transfer updated
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>422</b> - Unprocessable Content
     * @param transferGuid Identifier for the transfer.
     * @param patchTransferBankModel The patchTransferBankModel parameter
     * @return TransferBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateTransferRequestCreation(String transferGuid, PatchTransferBankModel patchTransferBankModel) throws WebClientResponseException {
        Object postBody = patchTransferBankModel;
        // verify the required parameter 'transferGuid' is set
        if (transferGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'transferGuid' when calling updateTransfer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'patchTransferBankModel' is set
        if (patchTransferBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'patchTransferBankModel' when calling updateTransfer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<TransferBankModel> localVarReturnType = new ParameterizedTypeReference<TransferBankModel>() {};
        return apiClient.invokeAPI("/api/transfers/{transfer_guid}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Patch Transfer
     * Update a transfer.  Required scope: **transfers:write**
     * <p><b>200</b> - Transfer updated
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>422</b> - Unprocessable Content
     * @param transferGuid Identifier for the transfer.
     * @param patchTransferBankModel The patchTransferBankModel parameter
     * @return TransferBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TransferBankModel> updateTransfer(String transferGuid, PatchTransferBankModel patchTransferBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<TransferBankModel> localVarReturnType = new ParameterizedTypeReference<TransferBankModel>() {};
        return updateTransferRequestCreation(transferGuid, patchTransferBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<TransferBankModel>> updateTransferWithHttpInfo(String transferGuid, PatchTransferBankModel patchTransferBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<TransferBankModel> localVarReturnType = new ParameterizedTypeReference<TransferBankModel>() {};
        return updateTransferRequestCreation(transferGuid, patchTransferBankModel).toEntity(localVarReturnType);
    }
}

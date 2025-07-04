package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.ExternalBankAccountBankModel;
import app.cybrid.cybrid_api_bank.client.model.ExternalBankAccountListBankModel;
import app.cybrid.cybrid_api_bank.client.model.PatchExternalBankAccountBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostExternalBankAccountBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-30T15:22:52.716328Z[Etc/UTC]")
public class ExternalBankAccountsBankApi {
    private ApiClient apiClient;

    public ExternalBankAccountsBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public ExternalBankAccountsBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create ExternalBankAccount
     * Create an ExternalBankAccount.  ## Account creation  Accounts can be created for a Bank or a Customer.  To create accounts for your Bank, omit the &#x60;customer_guid&#x60; parameter in the request body. To create accounts for your Customers, include the &#x60;customer_guid&#x60; parameter in the request body.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the external bank account details in our private store | | completed | The Platform has created the external bank account | | unverified | The external bank account is created, but it has not yet been verified | | failed | The Platform was not able to successfully create the external bank account | | refresh_required | The Platform has created the external bank account, but needs to be refreshed | | deleting | The Platform is deleting the external bank account | | deleted | The Platform has deleted the external bank account |  ## Failure codes  | Code | Description | |------|-------------| | invalid_routing_number | The provided routing number is invalid | | duplicate | An account with the same details already exists | | plaid_processor_token | An account could not be created due to an invalid Plaid processor token or an error with Plaid | | plaid_multiple_accounts | The supplied Plaid token is associated with multiple accounts. Must only be a single account. | | create_failed | The bank account and associated holder could not be created correctly | | unverified_counterparty | The counterparty account is unverified |    Required scope: **external_bank_accounts:execute**
     * <p><b>201</b> - ExternalBankAccount created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>422</b> - Unable to process request
     * @param postExternalBankAccountBankModel The postExternalBankAccountBankModel parameter
     * @return ExternalBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createExternalBankAccountRequestCreation(PostExternalBankAccountBankModel postExternalBankAccountBankModel) throws WebClientResponseException {
        Object postBody = postExternalBankAccountBankModel;
        // verify the required parameter 'postExternalBankAccountBankModel' is set
        if (postExternalBankAccountBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postExternalBankAccountBankModel' when calling createExternalBankAccount", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return apiClient.invokeAPI("/api/external_bank_accounts", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create ExternalBankAccount
     * Create an ExternalBankAccount.  ## Account creation  Accounts can be created for a Bank or a Customer.  To create accounts for your Bank, omit the &#x60;customer_guid&#x60; parameter in the request body. To create accounts for your Customers, include the &#x60;customer_guid&#x60; parameter in the request body.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the external bank account details in our private store | | completed | The Platform has created the external bank account | | unverified | The external bank account is created, but it has not yet been verified | | failed | The Platform was not able to successfully create the external bank account | | refresh_required | The Platform has created the external bank account, but needs to be refreshed | | deleting | The Platform is deleting the external bank account | | deleted | The Platform has deleted the external bank account |  ## Failure codes  | Code | Description | |------|-------------| | invalid_routing_number | The provided routing number is invalid | | duplicate | An account with the same details already exists | | plaid_processor_token | An account could not be created due to an invalid Plaid processor token or an error with Plaid | | plaid_multiple_accounts | The supplied Plaid token is associated with multiple accounts. Must only be a single account. | | create_failed | The bank account and associated holder could not be created correctly | | unverified_counterparty | The counterparty account is unverified |    Required scope: **external_bank_accounts:execute**
     * <p><b>201</b> - ExternalBankAccount created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>422</b> - Unable to process request
     * @param postExternalBankAccountBankModel The postExternalBankAccountBankModel parameter
     * @return ExternalBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ExternalBankAccountBankModel> createExternalBankAccount(PostExternalBankAccountBankModel postExternalBankAccountBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return createExternalBankAccountRequestCreation(postExternalBankAccountBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<ExternalBankAccountBankModel>> createExternalBankAccountWithHttpInfo(PostExternalBankAccountBankModel postExternalBankAccountBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return createExternalBankAccountRequestCreation(postExternalBankAccountBankModel).toEntity(localVarReturnType);
    }
    /**
     * Delete External Bank Account
     * Deletes an external bank account.  Required scope: **external_bank_accounts:execute**
     * <p><b>200</b> - External bank account deleted
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - ExternalBankAccount not found
     * @param externalBankAccountGuid Identifier for the external bank account.
     * @return ExternalBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteExternalBankAccountRequestCreation(String externalBankAccountGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'externalBankAccountGuid' is set
        if (externalBankAccountGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'externalBankAccountGuid' when calling deleteExternalBankAccount", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("external_bank_account_guid", externalBankAccountGuid);

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

        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return apiClient.invokeAPI("/api/external_bank_accounts/{external_bank_account_guid}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete External Bank Account
     * Deletes an external bank account.  Required scope: **external_bank_accounts:execute**
     * <p><b>200</b> - External bank account deleted
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - ExternalBankAccount not found
     * @param externalBankAccountGuid Identifier for the external bank account.
     * @return ExternalBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ExternalBankAccountBankModel> deleteExternalBankAccount(String externalBankAccountGuid) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return deleteExternalBankAccountRequestCreation(externalBankAccountGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<ExternalBankAccountBankModel>> deleteExternalBankAccountWithHttpInfo(String externalBankAccountGuid) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return deleteExternalBankAccountRequestCreation(externalBankAccountGuid).toEntity(localVarReturnType);
    }
    /**
     * Get External Bank Account
     * Retrieves an external bank account.  ## ExternalBankAccount retrieval  When retrieving an external bank account and include_balances is set to true, the Platform will attempt to retrieve the balance from the account&#39;s financial institution.  If force_balance_refresh is set to true, the Platform will always attempt to retrieve the most up to date balance from the account&#39;s financial institution. If force_balance_refresh is set to false, the Platform will return the cached balance.  If while getting the balance the Platform determines that the account needs to be refreshed, the Platform will return a 422 status code with the message \&quot;Bank account refresh required\&quot; and the ExternalBankAccount will be put into the refresh_required state.  If while getting the balance the Platform determines that the account is no longer valid, the Platform will return a 422 status code with the message \&quot;Bank account can no longer be used and is being deleted. It must be re-added\&quot; and the ExternalBankAccount will be deleted.  When retrieving an external bank account and include_pii is set to true, the Platform will include the account holder&#39;s information in the response.    Required scope: **external_bank_accounts:read**
     * <p><b>200</b> - External bank account found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - ExternalBankAccount not found
     * <p><b>422</b> - Unable to process request
     * @param externalBankAccountGuid Identifier for the external bank account.
     * @param forceBalanceRefresh Force the balance on the account to be retrieved.
     * @param includeBalances Include balance information in the response. If &#x60;force_balance_refresh&#x60; is &#x60;true&#x60;, the most up to date balance will be returned. If &#x60;force_balance_refresh&#x60; is &#x60;false&#x60;, the cached balance will be returned. &#x60;balance_updated_at&#x60; in the response will provide the timestamp the balance was last updated.
     * @param includePii Include the account holder&#39;s PII in the response.
     * @return ExternalBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getExternalBankAccountRequestCreation(String externalBankAccountGuid, Boolean forceBalanceRefresh, Boolean includeBalances, Boolean includePii) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'externalBankAccountGuid' is set
        if (externalBankAccountGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'externalBankAccountGuid' when calling getExternalBankAccount", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("external_bank_account_guid", externalBankAccountGuid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "force_balance_refresh", forceBalanceRefresh));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_balances", includeBalances));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_pii", includePii));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return apiClient.invokeAPI("/api/external_bank_accounts/{external_bank_account_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get External Bank Account
     * Retrieves an external bank account.  ## ExternalBankAccount retrieval  When retrieving an external bank account and include_balances is set to true, the Platform will attempt to retrieve the balance from the account&#39;s financial institution.  If force_balance_refresh is set to true, the Platform will always attempt to retrieve the most up to date balance from the account&#39;s financial institution. If force_balance_refresh is set to false, the Platform will return the cached balance.  If while getting the balance the Platform determines that the account needs to be refreshed, the Platform will return a 422 status code with the message \&quot;Bank account refresh required\&quot; and the ExternalBankAccount will be put into the refresh_required state.  If while getting the balance the Platform determines that the account is no longer valid, the Platform will return a 422 status code with the message \&quot;Bank account can no longer be used and is being deleted. It must be re-added\&quot; and the ExternalBankAccount will be deleted.  When retrieving an external bank account and include_pii is set to true, the Platform will include the account holder&#39;s information in the response.    Required scope: **external_bank_accounts:read**
     * <p><b>200</b> - External bank account found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - ExternalBankAccount not found
     * <p><b>422</b> - Unable to process request
     * @param externalBankAccountGuid Identifier for the external bank account.
     * @param forceBalanceRefresh Force the balance on the account to be retrieved.
     * @param includeBalances Include balance information in the response. If &#x60;force_balance_refresh&#x60; is &#x60;true&#x60;, the most up to date balance will be returned. If &#x60;force_balance_refresh&#x60; is &#x60;false&#x60;, the cached balance will be returned. &#x60;balance_updated_at&#x60; in the response will provide the timestamp the balance was last updated.
     * @param includePii Include the account holder&#39;s PII in the response.
     * @return ExternalBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ExternalBankAccountBankModel> getExternalBankAccount(String externalBankAccountGuid, Boolean forceBalanceRefresh, Boolean includeBalances, Boolean includePii) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return getExternalBankAccountRequestCreation(externalBankAccountGuid, forceBalanceRefresh, includeBalances, includePii).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<ExternalBankAccountBankModel>> getExternalBankAccountWithHttpInfo(String externalBankAccountGuid, Boolean forceBalanceRefresh, Boolean includeBalances, Boolean includePii) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return getExternalBankAccountRequestCreation(externalBankAccountGuid, forceBalanceRefresh, includeBalances, includePii).toEntity(localVarReturnType);
    }
    /**
     * Get external bank accounts list
     * Retrieves a listing of external bank accounts.  Required scope: **external_bank_accounts:read**
     * <p><b>200</b> - Get list of external_bank_accounts
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated external_bank_account_guids to list external_bank_accounts for.
     * @param bankGuid Comma separated bank_guids to list external_bank_accounts for.
     * @param customerGuid Comma separated customer_guids to list external_bank_accounts for.
     * @param asset Comma separated assets to list external_bank_accounts for.
     * @param state Comma separated states to list external_bank_accounts for. Filtering by \&quot;completed\&quot; and \&quot;unverified\&quot; states is only supported for individual customer accounts.
     * @return ExternalBankAccountListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listExternalBankAccountsRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String asset, String state) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "asset", asset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "state", state));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<ExternalBankAccountListBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountListBankModel>() {};
        return apiClient.invokeAPI("/api/external_bank_accounts", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get external bank accounts list
     * Retrieves a listing of external bank accounts.  Required scope: **external_bank_accounts:read**
     * <p><b>200</b> - Get list of external_bank_accounts
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated external_bank_account_guids to list external_bank_accounts for.
     * @param bankGuid Comma separated bank_guids to list external_bank_accounts for.
     * @param customerGuid Comma separated customer_guids to list external_bank_accounts for.
     * @param asset Comma separated assets to list external_bank_accounts for.
     * @param state Comma separated states to list external_bank_accounts for. Filtering by \&quot;completed\&quot; and \&quot;unverified\&quot; states is only supported for individual customer accounts.
     * @return ExternalBankAccountListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ExternalBankAccountListBankModel> listExternalBankAccounts(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String asset, String state) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalBankAccountListBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountListBankModel>() {};
        return listExternalBankAccountsRequestCreation(page, perPage, guid, bankGuid, customerGuid, asset, state).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<ExternalBankAccountListBankModel>> listExternalBankAccountsWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String asset, String state) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalBankAccountListBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountListBankModel>() {};
        return listExternalBankAccountsRequestCreation(page, perPage, guid, bankGuid, customerGuid, asset, state).toEntity(localVarReturnType);
    }
    /**
     * Patch ExternalBankAccount
     * Patch an external bank account.  Required scope: **external_bank_accounts:write**
     * <p><b>200</b> - external bank account found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - ExternalBankAccount not found
     * @param externalBankAccountGuid Identifier for the external bank account.
     * @param patchExternalBankAccountBankModel The patchExternalBankAccountBankModel parameter
     * @return ExternalBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec patchExternalBankAccountRequestCreation(String externalBankAccountGuid, PatchExternalBankAccountBankModel patchExternalBankAccountBankModel) throws WebClientResponseException {
        Object postBody = patchExternalBankAccountBankModel;
        // verify the required parameter 'externalBankAccountGuid' is set
        if (externalBankAccountGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'externalBankAccountGuid' when calling patchExternalBankAccount", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'patchExternalBankAccountBankModel' is set
        if (patchExternalBankAccountBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'patchExternalBankAccountBankModel' when calling patchExternalBankAccount", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("external_bank_account_guid", externalBankAccountGuid);

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

        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return apiClient.invokeAPI("/api/external_bank_accounts/{external_bank_account_guid}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Patch ExternalBankAccount
     * Patch an external bank account.  Required scope: **external_bank_accounts:write**
     * <p><b>200</b> - external bank account found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - ExternalBankAccount not found
     * @param externalBankAccountGuid Identifier for the external bank account.
     * @param patchExternalBankAccountBankModel The patchExternalBankAccountBankModel parameter
     * @return ExternalBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ExternalBankAccountBankModel> patchExternalBankAccount(String externalBankAccountGuid, PatchExternalBankAccountBankModel patchExternalBankAccountBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return patchExternalBankAccountRequestCreation(externalBankAccountGuid, patchExternalBankAccountBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<ExternalBankAccountBankModel>> patchExternalBankAccountWithHttpInfo(String externalBankAccountGuid, PatchExternalBankAccountBankModel patchExternalBankAccountBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalBankAccountBankModel>() {};
        return patchExternalBankAccountRequestCreation(externalBankAccountGuid, patchExternalBankAccountBankModel).toEntity(localVarReturnType);
    }
}

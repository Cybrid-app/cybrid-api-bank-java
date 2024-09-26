package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.AccountBankModel;
import app.cybrid.cybrid_api_bank.client.model.AccountListBankModel;
import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostAccountBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-26T14:18:55.166709Z[Etc/UTC]")
public class AccountsBankApi {
    private ApiClient apiClient;

    public AccountsBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public AccountsBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Account
     * Creates an account.  ## Account Type  An Account is tied to a specific cryptocurrency or fiat and is comprised of transactions and a current balance.  An account is required to allow a Bank or Customer to hold cryptocurrency or a Customer to hold fiat on the Cybrid Platform.  At present, accounts can be created as &#x60;trading&#x60; or &#x60;fiat &#x60; accounts and are required before a Customer can generate quotes or execute a &#x60;trade&#x60; or &#x60;transfer&#x60;.  To create accounts for your Bank, omit the &#x60;customer_guid&#x60; parameter in the request body. To create accounts for your Customers, include the &#x60;customer_guid&#x60; parameter in the request body.  At the bank level, &#x60;invoice_operations&#x60; accounts can be configured to pre-fund your customers&#39; Lightning Network operations.  ## Asset  The asset is the specific cryptocurrency or fiat that the account holds, e.g., &#39;BTC&#39; for Bitcoin or &#x60;USD&#x60; for US dollars. See the Symbols API for a complete list of cryptocurrencies and fiat supported.   ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the account details in our private store | | created | The Platform has created the account |    Required scope: **accounts:execute**
     * <p><b>201</b> - account created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postAccountBankModel The postAccountBankModel parameter
     * @return AccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createAccountRequestCreation(PostAccountBankModel postAccountBankModel) throws WebClientResponseException {
        Object postBody = postAccountBankModel;
        // verify the required parameter 'postAccountBankModel' is set
        if (postAccountBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postAccountBankModel' when calling createAccount", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<AccountBankModel> localVarReturnType = new ParameterizedTypeReference<AccountBankModel>() {};
        return apiClient.invokeAPI("/api/accounts", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Account
     * Creates an account.  ## Account Type  An Account is tied to a specific cryptocurrency or fiat and is comprised of transactions and a current balance.  An account is required to allow a Bank or Customer to hold cryptocurrency or a Customer to hold fiat on the Cybrid Platform.  At present, accounts can be created as &#x60;trading&#x60; or &#x60;fiat &#x60; accounts and are required before a Customer can generate quotes or execute a &#x60;trade&#x60; or &#x60;transfer&#x60;.  To create accounts for your Bank, omit the &#x60;customer_guid&#x60; parameter in the request body. To create accounts for your Customers, include the &#x60;customer_guid&#x60; parameter in the request body.  At the bank level, &#x60;invoice_operations&#x60; accounts can be configured to pre-fund your customers&#39; Lightning Network operations.  ## Asset  The asset is the specific cryptocurrency or fiat that the account holds, e.g., &#39;BTC&#39; for Bitcoin or &#x60;USD&#x60; for US dollars. See the Symbols API for a complete list of cryptocurrencies and fiat supported.   ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the account details in our private store | | created | The Platform has created the account |    Required scope: **accounts:execute**
     * <p><b>201</b> - account created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postAccountBankModel The postAccountBankModel parameter
     * @return AccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<AccountBankModel> createAccount(PostAccountBankModel postAccountBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<AccountBankModel> localVarReturnType = new ParameterizedTypeReference<AccountBankModel>() {};
        return createAccountRequestCreation(postAccountBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<AccountBankModel>> createAccountWithHttpInfo(PostAccountBankModel postAccountBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<AccountBankModel> localVarReturnType = new ParameterizedTypeReference<AccountBankModel>() {};
        return createAccountRequestCreation(postAccountBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Account
     * Retrieves an account.  Required scope: **accounts:read**
     * <p><b>200</b> - account found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - account not found
     * @param accountGuid Identifier for the account.
     * @return AccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getAccountRequestCreation(String accountGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'accountGuid' is set
        if (accountGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'accountGuid' when calling getAccount", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("account_guid", accountGuid);

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

        ParameterizedTypeReference<AccountBankModel> localVarReturnType = new ParameterizedTypeReference<AccountBankModel>() {};
        return apiClient.invokeAPI("/api/accounts/{account_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Account
     * Retrieves an account.  Required scope: **accounts:read**
     * <p><b>200</b> - account found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - account not found
     * @param accountGuid Identifier for the account.
     * @return AccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<AccountBankModel> getAccount(String accountGuid) throws WebClientResponseException {
        ParameterizedTypeReference<AccountBankModel> localVarReturnType = new ParameterizedTypeReference<AccountBankModel>() {};
        return getAccountRequestCreation(accountGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<AccountBankModel>> getAccountWithHttpInfo(String accountGuid) throws WebClientResponseException {
        ParameterizedTypeReference<AccountBankModel> localVarReturnType = new ParameterizedTypeReference<AccountBankModel>() {};
        return getAccountRequestCreation(accountGuid).toEntity(localVarReturnType);
    }
    /**
     * List Accounts
     * Retrieves a list of accounts.  Required scope: **accounts:read**
     * <p><b>200</b> - get list of accounts
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param owner The owner of the entity.
     * @param guid Comma separated account_guids to list accounts for.
     * @param type Comma separated account_types to list accounts for.
     * @param bankGuid Comma separated bank_guids to list accounts for.
     * @param customerGuid Comma separated customer_guids to list accounts for.
     * @param label Comma separated labels to list accounts for.
     * @return AccountListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listAccountsRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String owner, String guid, String type, String bankGuid, String customerGuid, String label) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "per_page", perPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "owner", owner));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "guid", guid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
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

        ParameterizedTypeReference<AccountListBankModel> localVarReturnType = new ParameterizedTypeReference<AccountListBankModel>() {};
        return apiClient.invokeAPI("/api/accounts", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Accounts
     * Retrieves a list of accounts.  Required scope: **accounts:read**
     * <p><b>200</b> - get list of accounts
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param owner The owner of the entity.
     * @param guid Comma separated account_guids to list accounts for.
     * @param type Comma separated account_types to list accounts for.
     * @param bankGuid Comma separated bank_guids to list accounts for.
     * @param customerGuid Comma separated customer_guids to list accounts for.
     * @param label Comma separated labels to list accounts for.
     * @return AccountListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<AccountListBankModel> listAccounts(java.math.BigInteger page, java.math.BigInteger perPage, String owner, String guid, String type, String bankGuid, String customerGuid, String label) throws WebClientResponseException {
        ParameterizedTypeReference<AccountListBankModel> localVarReturnType = new ParameterizedTypeReference<AccountListBankModel>() {};
        return listAccountsRequestCreation(page, perPage, owner, guid, type, bankGuid, customerGuid, label).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<AccountListBankModel>> listAccountsWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String owner, String guid, String type, String bankGuid, String customerGuid, String label) throws WebClientResponseException {
        ParameterizedTypeReference<AccountListBankModel> localVarReturnType = new ParameterizedTypeReference<AccountListBankModel>() {};
        return listAccountsRequestCreation(page, perPage, owner, guid, type, bankGuid, customerGuid, label).toEntity(localVarReturnType);
    }
}

package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.DepositBankAccountBankModel;
import app.cybrid.cybrid_api_bank.client.model.DepositBankAccountListBankModel;
import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostDepositBankAccountBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-01-15T20:00:07.053426Z[Etc/UTC]")
public class DepositBankAccountsBankApi {
    private ApiClient apiClient;

    public DepositBankAccountsBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public DepositBankAccountsBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Deposit Bank Account
     * Creates a deposit bank account.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the deposit bank account details in our private store | | created | The Platform has created the deposit bank account |    Required scope: **deposit_bank_accounts:execute**
     * <p><b>201</b> - Deposit Bank Account created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>422</b> - Unable to process request
     * <p><b>500</b> - Internal server error
     * @param postDepositBankAccountBankModel The postDepositBankAccountBankModel parameter
     * @return DepositBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createDepositBankAccountRequestCreation(PostDepositBankAccountBankModel postDepositBankAccountBankModel) throws WebClientResponseException {
        Object postBody = postDepositBankAccountBankModel;
        // verify the required parameter 'postDepositBankAccountBankModel' is set
        if (postDepositBankAccountBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postDepositBankAccountBankModel' when calling createDepositBankAccount", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<DepositBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<DepositBankAccountBankModel>() {};
        return apiClient.invokeAPI("/api/deposit_bank_accounts", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Deposit Bank Account
     * Creates a deposit bank account.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the deposit bank account details in our private store | | created | The Platform has created the deposit bank account |    Required scope: **deposit_bank_accounts:execute**
     * <p><b>201</b> - Deposit Bank Account created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>422</b> - Unable to process request
     * <p><b>500</b> - Internal server error
     * @param postDepositBankAccountBankModel The postDepositBankAccountBankModel parameter
     * @return DepositBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DepositBankAccountBankModel> createDepositBankAccount(PostDepositBankAccountBankModel postDepositBankAccountBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<DepositBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<DepositBankAccountBankModel>() {};
        return createDepositBankAccountRequestCreation(postDepositBankAccountBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<DepositBankAccountBankModel>> createDepositBankAccountWithHttpInfo(PostDepositBankAccountBankModel postDepositBankAccountBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<DepositBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<DepositBankAccountBankModel>() {};
        return createDepositBankAccountRequestCreation(postDepositBankAccountBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Deposit Bank Account
     * Retrieves a deposit bank account.  Required scope: **deposit_bank_accounts:read**
     * <p><b>200</b> - deposit bank account found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - deposit_bank_account not found
     * @param depositBankAccountGuid Identifier for the deposit bank account.
     * @return DepositBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getDepositBankAccountRequestCreation(String depositBankAccountGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'depositBankAccountGuid' is set
        if (depositBankAccountGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'depositBankAccountGuid' when calling getDepositBankAccount", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("deposit_bank_account_guid", depositBankAccountGuid);

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

        ParameterizedTypeReference<DepositBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<DepositBankAccountBankModel>() {};
        return apiClient.invokeAPI("/api/deposit_bank_accounts/{deposit_bank_account_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Deposit Bank Account
     * Retrieves a deposit bank account.  Required scope: **deposit_bank_accounts:read**
     * <p><b>200</b> - deposit bank account found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - deposit_bank_account not found
     * @param depositBankAccountGuid Identifier for the deposit bank account.
     * @return DepositBankAccountBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DepositBankAccountBankModel> getDepositBankAccount(String depositBankAccountGuid) throws WebClientResponseException {
        ParameterizedTypeReference<DepositBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<DepositBankAccountBankModel>() {};
        return getDepositBankAccountRequestCreation(depositBankAccountGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<DepositBankAccountBankModel>> getDepositBankAccountWithHttpInfo(String depositBankAccountGuid) throws WebClientResponseException {
        ParameterizedTypeReference<DepositBankAccountBankModel> localVarReturnType = new ParameterizedTypeReference<DepositBankAccountBankModel>() {};
        return getDepositBankAccountRequestCreation(depositBankAccountGuid).toEntity(localVarReturnType);
    }
    /**
     * List Deposit Bank Accounts
     * Retrieves a list of deposit bank accounts.  Required scope: **deposit_bank_accounts:read**
     * <p><b>200</b> - get list of deposit bank accounts
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated guids to list deposit bank accounts for.
     * @param bankGuid Comma separated bank_guids to list deposit bank accounts for.
     * @param customerGuid Comma separated customer_guids to list deposit bank accounts for.
     * @param label Comma separated labels to list deposit bank accounts for.
     * @param uniqueMemoId Comma separated unique memo ids to list deposit bank accounts for.
     * @return DepositBankAccountListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listDepositBankAccountsRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String label, String uniqueMemoId) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "unique_memo_id", uniqueMemoId));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<DepositBankAccountListBankModel> localVarReturnType = new ParameterizedTypeReference<DepositBankAccountListBankModel>() {};
        return apiClient.invokeAPI("/api/deposit_bank_accounts", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Deposit Bank Accounts
     * Retrieves a list of deposit bank accounts.  Required scope: **deposit_bank_accounts:read**
     * <p><b>200</b> - get list of deposit bank accounts
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated guids to list deposit bank accounts for.
     * @param bankGuid Comma separated bank_guids to list deposit bank accounts for.
     * @param customerGuid Comma separated customer_guids to list deposit bank accounts for.
     * @param label Comma separated labels to list deposit bank accounts for.
     * @param uniqueMemoId Comma separated unique memo ids to list deposit bank accounts for.
     * @return DepositBankAccountListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DepositBankAccountListBankModel> listDepositBankAccounts(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String label, String uniqueMemoId) throws WebClientResponseException {
        ParameterizedTypeReference<DepositBankAccountListBankModel> localVarReturnType = new ParameterizedTypeReference<DepositBankAccountListBankModel>() {};
        return listDepositBankAccountsRequestCreation(page, perPage, guid, bankGuid, customerGuid, label, uniqueMemoId).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<DepositBankAccountListBankModel>> listDepositBankAccountsWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String label, String uniqueMemoId) throws WebClientResponseException {
        ParameterizedTypeReference<DepositBankAccountListBankModel> localVarReturnType = new ParameterizedTypeReference<DepositBankAccountListBankModel>() {};
        return listDepositBankAccountsRequestCreation(page, perPage, guid, bankGuid, customerGuid, label, uniqueMemoId).toEntity(localVarReturnType);
    }
}

package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.ExternalWalletBankModel;
import app.cybrid.cybrid_api_bank.client.model.ExternalWalletListBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostExternalWalletBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-05-25T12:48:02.791640Z[Etc/UTC]")
public class ExternalWalletsBankApi {
    private ApiClient apiClient;

    public ExternalWalletsBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public ExternalWalletsBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create ExternalWallet
     * Create an ExternalWallet.  Required scope: **external_wallets:execute**
     * <p><b>201</b> - ExternalWallet created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>409</b> - Data already exists
     * <p><b>422</b> - Unable to process request
     * @param postExternalWalletBankModel The postExternalWalletBankModel parameter
     * @return ExternalWalletBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createExternalWalletRequestCreation(PostExternalWalletBankModel postExternalWalletBankModel) throws WebClientResponseException {
        Object postBody = postExternalWalletBankModel;
        // verify the required parameter 'postExternalWalletBankModel' is set
        if (postExternalWalletBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postExternalWalletBankModel' when calling createExternalWallet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ExternalWalletBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletBankModel>() {};
        return apiClient.invokeAPI("/api/external_wallets", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create ExternalWallet
     * Create an ExternalWallet.  Required scope: **external_wallets:execute**
     * <p><b>201</b> - ExternalWallet created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>409</b> - Data already exists
     * <p><b>422</b> - Unable to process request
     * @param postExternalWalletBankModel The postExternalWalletBankModel parameter
     * @return ExternalWalletBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ExternalWalletBankModel> createExternalWallet(PostExternalWalletBankModel postExternalWalletBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalWalletBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletBankModel>() {};
        return createExternalWalletRequestCreation(postExternalWalletBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<ExternalWalletBankModel>> createExternalWalletWithHttpInfo(PostExternalWalletBankModel postExternalWalletBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalWalletBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletBankModel>() {};
        return createExternalWalletRequestCreation(postExternalWalletBankModel).toEntity(localVarReturnType);
    }
    /**
     * Delete External Wallet
     * Deletes an external wallet.  Required scope: **external_wallets:execute**
     * <p><b>200</b> - External wallet deleted
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - ExternalWallet not found
     * @param externalWalletGuid Identifier for the external wallet.
     * @return ExternalWalletBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteExternalWalletRequestCreation(String externalWalletGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'externalWalletGuid' is set
        if (externalWalletGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'externalWalletGuid' when calling deleteExternalWallet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("external_wallet_guid", externalWalletGuid);

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

        ParameterizedTypeReference<ExternalWalletBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletBankModel>() {};
        return apiClient.invokeAPI("/api/external_wallets/{external_wallet_guid}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete External Wallet
     * Deletes an external wallet.  Required scope: **external_wallets:execute**
     * <p><b>200</b> - External wallet deleted
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - ExternalWallet not found
     * @param externalWalletGuid Identifier for the external wallet.
     * @return ExternalWalletBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ExternalWalletBankModel> deleteExternalWallet(String externalWalletGuid) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalWalletBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletBankModel>() {};
        return deleteExternalWalletRequestCreation(externalWalletGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<ExternalWalletBankModel>> deleteExternalWalletWithHttpInfo(String externalWalletGuid) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalWalletBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletBankModel>() {};
        return deleteExternalWalletRequestCreation(externalWalletGuid).toEntity(localVarReturnType);
    }
    /**
     * Get External Wallet
     * Retrieves an external_wallet.  Required scope: **external_wallets:read**
     * <p><b>200</b> - External wallet found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - ExternalWallet not found
     * @param externalWalletGuid Identifier for the external_wallet.
     * @return ExternalWalletBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getExternalWalletRequestCreation(String externalWalletGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'externalWalletGuid' is set
        if (externalWalletGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'externalWalletGuid' when calling getExternalWallet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("external_wallet_guid", externalWalletGuid);

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

        ParameterizedTypeReference<ExternalWalletBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletBankModel>() {};
        return apiClient.invokeAPI("/api/external_wallets/{external_wallet_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get External Wallet
     * Retrieves an external_wallet.  Required scope: **external_wallets:read**
     * <p><b>200</b> - External wallet found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - ExternalWallet not found
     * @param externalWalletGuid Identifier for the external_wallet.
     * @return ExternalWalletBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ExternalWalletBankModel> getExternalWallet(String externalWalletGuid) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalWalletBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletBankModel>() {};
        return getExternalWalletRequestCreation(externalWalletGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<ExternalWalletBankModel>> getExternalWalletWithHttpInfo(String externalWalletGuid) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalWalletBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletBankModel>() {};
        return getExternalWalletRequestCreation(externalWalletGuid).toEntity(localVarReturnType);
    }
    /**
     * Get external wallets list
     * Retrieves a listing of external wallets.  Required scope: **external_wallets:read**
     * <p><b>200</b> - Get list of external_wallets
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated external_wallet_guids to list external_wallets for.
     * @param bankGuid Comma separated bank_guids to list external_wallets for.
     * @param customerGuid Comma separated customer_guids to list external_wallets for.
     * @return ExternalWalletListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listExternalWalletsRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
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

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<ExternalWalletListBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletListBankModel>() {};
        return apiClient.invokeAPI("/api/external_wallets", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get external wallets list
     * Retrieves a listing of external wallets.  Required scope: **external_wallets:read**
     * <p><b>200</b> - Get list of external_wallets
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated external_wallet_guids to list external_wallets for.
     * @param bankGuid Comma separated bank_guids to list external_wallets for.
     * @param customerGuid Comma separated customer_guids to list external_wallets for.
     * @return ExternalWalletListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ExternalWalletListBankModel> listExternalWallets(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalWalletListBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletListBankModel>() {};
        return listExternalWalletsRequestCreation(page, perPage, guid, bankGuid, customerGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<ExternalWalletListBankModel>> listExternalWalletsWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<ExternalWalletListBankModel> localVarReturnType = new ParameterizedTypeReference<ExternalWalletListBankModel>() {};
        return listExternalWalletsRequestCreation(page, perPage, guid, bankGuid, customerGuid).toEntity(localVarReturnType);
    }
}

package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.IdentityVerificationBankModel;
import app.cybrid.cybrid_api_bank.client.model.IdentityVerificationListBankModel;
import app.cybrid.cybrid_api_bank.client.model.IdentityVerificationWithDetailsBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostIdentityVerificationBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-28T12:09:14.746366Z[Etc/UTC]")
public class IdentityVerificationsBankApi {
    private ApiClient apiClient;

    public IdentityVerificationsBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public IdentityVerificationsBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Identity Verification
     * Creates an Identity Verification.  ## Identity Verifications  Identity Verifications confirm an individual&#39;s identity with for the purpose of inclusion on the platform. This know-your-customer (KYC) process is a requirement for individuals to be able to transact. At present, we offer support for Cybrid performing the verification or working with partners to accept their KYC/AML process and have it attested to in our platform.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the identity verification details in our private store | | waiting | The Platform is waiting for the customer to complete the identity verification process | | expired | The identity verification process has expired | | completed | The identity verification process has been completed |  ## Outcome  | State | Description | |-------|-------------| | passed | The customer has passed the identity verification process | | failed | The customer has failed the identity verification process |    Required scope: **customers:write**
     * <p><b>201</b> - Identity Verification created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postIdentityVerificationBankModel The postIdentityVerificationBankModel parameter
     * @return IdentityVerificationBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createIdentityVerificationRequestCreation(PostIdentityVerificationBankModel postIdentityVerificationBankModel) throws WebClientResponseException {
        Object postBody = postIdentityVerificationBankModel;
        // verify the required parameter 'postIdentityVerificationBankModel' is set
        if (postIdentityVerificationBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postIdentityVerificationBankModel' when calling createIdentityVerification", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<IdentityVerificationBankModel> localVarReturnType = new ParameterizedTypeReference<IdentityVerificationBankModel>() {};
        return apiClient.invokeAPI("/api/identity_verifications", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Identity Verification
     * Creates an Identity Verification.  ## Identity Verifications  Identity Verifications confirm an individual&#39;s identity with for the purpose of inclusion on the platform. This know-your-customer (KYC) process is a requirement for individuals to be able to transact. At present, we offer support for Cybrid performing the verification or working with partners to accept their KYC/AML process and have it attested to in our platform.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the identity verification details in our private store | | waiting | The Platform is waiting for the customer to complete the identity verification process | | expired | The identity verification process has expired | | completed | The identity verification process has been completed |  ## Outcome  | State | Description | |-------|-------------| | passed | The customer has passed the identity verification process | | failed | The customer has failed the identity verification process |    Required scope: **customers:write**
     * <p><b>201</b> - Identity Verification created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postIdentityVerificationBankModel The postIdentityVerificationBankModel parameter
     * @return IdentityVerificationBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<IdentityVerificationBankModel> createIdentityVerification(PostIdentityVerificationBankModel postIdentityVerificationBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<IdentityVerificationBankModel> localVarReturnType = new ParameterizedTypeReference<IdentityVerificationBankModel>() {};
        return createIdentityVerificationRequestCreation(postIdentityVerificationBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<IdentityVerificationBankModel>> createIdentityVerificationWithHttpInfo(PostIdentityVerificationBankModel postIdentityVerificationBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<IdentityVerificationBankModel> localVarReturnType = new ParameterizedTypeReference<IdentityVerificationBankModel>() {};
        return createIdentityVerificationRequestCreation(postIdentityVerificationBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Identity Verification
     * Retrieves an identity verification.  Required scope: **customers:read**
     * <p><b>200</b> - identity verification found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - identity_verification not found
     * @param identityVerificationGuid Identifier for the identity verification.
     * @return IdentityVerificationWithDetailsBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getIdentityVerificationRequestCreation(String identityVerificationGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'identityVerificationGuid' is set
        if (identityVerificationGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'identityVerificationGuid' when calling getIdentityVerification", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("identity_verification_guid", identityVerificationGuid);

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

        ParameterizedTypeReference<IdentityVerificationWithDetailsBankModel> localVarReturnType = new ParameterizedTypeReference<IdentityVerificationWithDetailsBankModel>() {};
        return apiClient.invokeAPI("/api/identity_verifications/{identity_verification_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Identity Verification
     * Retrieves an identity verification.  Required scope: **customers:read**
     * <p><b>200</b> - identity verification found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - identity_verification not found
     * @param identityVerificationGuid Identifier for the identity verification.
     * @return IdentityVerificationWithDetailsBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<IdentityVerificationWithDetailsBankModel> getIdentityVerification(String identityVerificationGuid) throws WebClientResponseException {
        ParameterizedTypeReference<IdentityVerificationWithDetailsBankModel> localVarReturnType = new ParameterizedTypeReference<IdentityVerificationWithDetailsBankModel>() {};
        return getIdentityVerificationRequestCreation(identityVerificationGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<IdentityVerificationWithDetailsBankModel>> getIdentityVerificationWithHttpInfo(String identityVerificationGuid) throws WebClientResponseException {
        ParameterizedTypeReference<IdentityVerificationWithDetailsBankModel> localVarReturnType = new ParameterizedTypeReference<IdentityVerificationWithDetailsBankModel>() {};
        return getIdentityVerificationRequestCreation(identityVerificationGuid).toEntity(localVarReturnType);
    }
    /**
     * List Identity Verifications
     * Retrieves a list of identity verifications.  Required scope: **customers:read**
     * <p><b>200</b> - get list of identity verifications
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated guids to list identity verifications for.
     * @param bankGuid Comma separated bank_guids to list identity verifications for.
     * @param customerGuid Comma separated customer_guids to list identity verifications for.
     * @return IdentityVerificationListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listIdentityVerificationsRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
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

        ParameterizedTypeReference<IdentityVerificationListBankModel> localVarReturnType = new ParameterizedTypeReference<IdentityVerificationListBankModel>() {};
        return apiClient.invokeAPI("/api/identity_verifications", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Identity Verifications
     * Retrieves a list of identity verifications.  Required scope: **customers:read**
     * <p><b>200</b> - get list of identity verifications
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated guids to list identity verifications for.
     * @param bankGuid Comma separated bank_guids to list identity verifications for.
     * @param customerGuid Comma separated customer_guids to list identity verifications for.
     * @return IdentityVerificationListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<IdentityVerificationListBankModel> listIdentityVerifications(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<IdentityVerificationListBankModel> localVarReturnType = new ParameterizedTypeReference<IdentityVerificationListBankModel>() {};
        return listIdentityVerificationsRequestCreation(page, perPage, guid, bankGuid, customerGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<IdentityVerificationListBankModel>> listIdentityVerificationsWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<IdentityVerificationListBankModel> localVarReturnType = new ParameterizedTypeReference<IdentityVerificationListBankModel>() {};
        return listIdentityVerificationsRequestCreation(page, perPage, guid, bankGuid, customerGuid).toEntity(localVarReturnType);
    }
}

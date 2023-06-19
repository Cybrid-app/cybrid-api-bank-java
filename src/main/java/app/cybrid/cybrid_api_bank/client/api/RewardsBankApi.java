package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostRewardBankModel;
import app.cybrid.cybrid_api_bank.client.model.RewardBankModel;
import app.cybrid.cybrid_api_bank.client.model.RewardListBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-06-19T14:35:19.282410Z[Etc/UTC]")
public class RewardsBankApi {
    private ApiClient apiClient;

    public RewardsBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public RewardsBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Reward
     * Creates a reward.  Required scope: **rewards:execute**
     * <p><b>201</b> - reward created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postRewardBankModel The postRewardBankModel parameter
     * @return RewardBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createRewardsRequestCreation(PostRewardBankModel postRewardBankModel) throws WebClientResponseException {
        Object postBody = postRewardBankModel;
        // verify the required parameter 'postRewardBankModel' is set
        if (postRewardBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postRewardBankModel' when calling createRewards", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<RewardBankModel> localVarReturnType = new ParameterizedTypeReference<RewardBankModel>() {};
        return apiClient.invokeAPI("/api/rewards", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Reward
     * Creates a reward.  Required scope: **rewards:execute**
     * <p><b>201</b> - reward created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postRewardBankModel The postRewardBankModel parameter
     * @return RewardBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<RewardBankModel> createRewards(PostRewardBankModel postRewardBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<RewardBankModel> localVarReturnType = new ParameterizedTypeReference<RewardBankModel>() {};
        return createRewardsRequestCreation(postRewardBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<RewardBankModel>> createRewardsWithHttpInfo(PostRewardBankModel postRewardBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<RewardBankModel> localVarReturnType = new ParameterizedTypeReference<RewardBankModel>() {};
        return createRewardsRequestCreation(postRewardBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Reward
     * Retrieves a reward.  Required scope: **rewards:read**
     * <p><b>200</b> - reward found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - reward not found
     * @param rewardGuid Identifier for the reward.
     * @return RewardBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getRewardRequestCreation(String rewardGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'rewardGuid' is set
        if (rewardGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'rewardGuid' when calling getReward", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("reward_guid", rewardGuid);

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

        ParameterizedTypeReference<RewardBankModel> localVarReturnType = new ParameterizedTypeReference<RewardBankModel>() {};
        return apiClient.invokeAPI("/api/rewards/{reward_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Reward
     * Retrieves a reward.  Required scope: **rewards:read**
     * <p><b>200</b> - reward found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - reward not found
     * @param rewardGuid Identifier for the reward.
     * @return RewardBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<RewardBankModel> getReward(String rewardGuid) throws WebClientResponseException {
        ParameterizedTypeReference<RewardBankModel> localVarReturnType = new ParameterizedTypeReference<RewardBankModel>() {};
        return getRewardRequestCreation(rewardGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<RewardBankModel>> getRewardWithHttpInfo(String rewardGuid) throws WebClientResponseException {
        ParameterizedTypeReference<RewardBankModel> localVarReturnType = new ParameterizedTypeReference<RewardBankModel>() {};
        return getRewardRequestCreation(rewardGuid).toEntity(localVarReturnType);
    }
    /**
     * Get rewards list
     * Retrieves a listing of rewards.  Required scope: **rewards:read**
     * <p><b>200</b> - get list of rewards
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated reward_guids to list rewards for.
     * @param bankGuid Comma separated bank_guids to list rewards for.
     * @param customerGuid Comma separated customer_guids to list rewards for.
     * @return RewardListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listRewardsRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
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

        ParameterizedTypeReference<RewardListBankModel> localVarReturnType = new ParameterizedTypeReference<RewardListBankModel>() {};
        return apiClient.invokeAPI("/api/rewards", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get rewards list
     * Retrieves a listing of rewards.  Required scope: **rewards:read**
     * <p><b>200</b> - get list of rewards
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated reward_guids to list rewards for.
     * @param bankGuid Comma separated bank_guids to list rewards for.
     * @param customerGuid Comma separated customer_guids to list rewards for.
     * @return RewardListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<RewardListBankModel> listRewards(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<RewardListBankModel> localVarReturnType = new ParameterizedTypeReference<RewardListBankModel>() {};
        return listRewardsRequestCreation(page, perPage, guid, bankGuid, customerGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<RewardListBankModel>> listRewardsWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<RewardListBankModel> localVarReturnType = new ParameterizedTypeReference<RewardListBankModel>() {};
        return listRewardsRequestCreation(page, perPage, guid, bankGuid, customerGuid).toEntity(localVarReturnType);
    }
}

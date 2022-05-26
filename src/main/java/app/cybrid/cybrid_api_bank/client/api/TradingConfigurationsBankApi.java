package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.PostTradingConfigurationBankModel;
import app.cybrid.cybrid_api_bank.client.model.TradingConfigurationBankModel;
import app.cybrid.cybrid_api_bank.client.model.TradingConfigurationListBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-26T10:46:50.475781Z[Etc/UTC]")
public class TradingConfigurationsBankApi {
    private ApiClient apiClient;

    public TradingConfigurationsBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public TradingConfigurationsBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create TradingConfiguration
     * Creates a trading configuration.  Required scope: **banks:write**
     * <p><b>201</b> - trading configuration created
     * @param postTradingConfigurationBankModel The postTradingConfigurationBankModel parameter
     * @return TradingConfigurationBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createTradingConfigurationRequestCreation(PostTradingConfigurationBankModel postTradingConfigurationBankModel) throws WebClientResponseException {
        Object postBody = postTradingConfigurationBankModel;
        // verify the required parameter 'postTradingConfigurationBankModel' is set
        if (postTradingConfigurationBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postTradingConfigurationBankModel' when calling createTradingConfiguration", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<TradingConfigurationBankModel> localVarReturnType = new ParameterizedTypeReference<TradingConfigurationBankModel>() {};
        return apiClient.invokeAPI("/api/trading_configurations", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create TradingConfiguration
     * Creates a trading configuration.  Required scope: **banks:write**
     * <p><b>201</b> - trading configuration created
     * @param postTradingConfigurationBankModel The postTradingConfigurationBankModel parameter
     * @return TradingConfigurationBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TradingConfigurationBankModel> createTradingConfiguration(PostTradingConfigurationBankModel postTradingConfigurationBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<TradingConfigurationBankModel> localVarReturnType = new ParameterizedTypeReference<TradingConfigurationBankModel>() {};
        return createTradingConfigurationRequestCreation(postTradingConfigurationBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<TradingConfigurationBankModel>> createTradingConfigurationWithHttpInfo(PostTradingConfigurationBankModel postTradingConfigurationBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<TradingConfigurationBankModel> localVarReturnType = new ParameterizedTypeReference<TradingConfigurationBankModel>() {};
        return createTradingConfigurationRequestCreation(postTradingConfigurationBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get TradingConfiguration
     * Retrieves a trading configuration.  Required scope: **banks:read**
     * <p><b>200</b> - trading configuration found
     * @param tradingConfigurationGuid Identifier for the trading configuration.
     * @return TradingConfigurationBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTradingConfigurationRequestCreation(String tradingConfigurationGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'tradingConfigurationGuid' is set
        if (tradingConfigurationGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'tradingConfigurationGuid' when calling getTradingConfiguration", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("trading_configuration_guid", tradingConfigurationGuid);

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

        ParameterizedTypeReference<TradingConfigurationBankModel> localVarReturnType = new ParameterizedTypeReference<TradingConfigurationBankModel>() {};
        return apiClient.invokeAPI("/api/trading_configurations/{trading_configuration_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get TradingConfiguration
     * Retrieves a trading configuration.  Required scope: **banks:read**
     * <p><b>200</b> - trading configuration found
     * @param tradingConfigurationGuid Identifier for the trading configuration.
     * @return TradingConfigurationBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TradingConfigurationBankModel> getTradingConfiguration(String tradingConfigurationGuid) throws WebClientResponseException {
        ParameterizedTypeReference<TradingConfigurationBankModel> localVarReturnType = new ParameterizedTypeReference<TradingConfigurationBankModel>() {};
        return getTradingConfigurationRequestCreation(tradingConfigurationGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<TradingConfigurationBankModel>> getTradingConfigurationWithHttpInfo(String tradingConfigurationGuid) throws WebClientResponseException {
        ParameterizedTypeReference<TradingConfigurationBankModel> localVarReturnType = new ParameterizedTypeReference<TradingConfigurationBankModel>() {};
        return getTradingConfigurationRequestCreation(tradingConfigurationGuid).toEntity(localVarReturnType);
    }
    /**
     * List trading configurations
     * Retrieves a listing of trading configurations for a bank.  Required scope: **banks:read**
     * <p><b>200</b> - get list of trading configurations
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @return TradingConfigurationListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listTradingConfigurationsRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "per_page", perPage));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<TradingConfigurationListBankModel> localVarReturnType = new ParameterizedTypeReference<TradingConfigurationListBankModel>() {};
        return apiClient.invokeAPI("/api/trading_configurations", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List trading configurations
     * Retrieves a listing of trading configurations for a bank.  Required scope: **banks:read**
     * <p><b>200</b> - get list of trading configurations
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @return TradingConfigurationListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TradingConfigurationListBankModel> listTradingConfigurations(java.math.BigInteger page, java.math.BigInteger perPage) throws WebClientResponseException {
        ParameterizedTypeReference<TradingConfigurationListBankModel> localVarReturnType = new ParameterizedTypeReference<TradingConfigurationListBankModel>() {};
        return listTradingConfigurationsRequestCreation(page, perPage).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<TradingConfigurationListBankModel>> listTradingConfigurationsWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage) throws WebClientResponseException {
        ParameterizedTypeReference<TradingConfigurationListBankModel> localVarReturnType = new ParameterizedTypeReference<TradingConfigurationListBankModel>() {};
        return listTradingConfigurationsRequestCreation(page, perPage).toEntity(localVarReturnType);
    }
}

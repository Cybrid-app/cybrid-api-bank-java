package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.PostTradeBankModel;
import app.cybrid.cybrid_api_bank.client.model.TradeBankModel;
import app.cybrid.cybrid_api_bank.client.model.TradeListBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-16T11:30:37.512030Z[Etc/UTC]")
public class TradesBankApi {
    private ApiClient apiClient;

    public TradesBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public TradesBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Trade
     * Creates a trade.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the trade details in our private store | | initiating | The Platform has begun to perform the trade | | pending | The Platform is executing the trade | | completed | The Platform has successfully completed the trade | | failed | The Platform was not able to successfully complete the trade |    Required scope: **trades:execute**
     * <p><b>201</b> - Trade created
     * @param postTradeBankModel The postTradeBankModel parameter
     * @return TradeBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createTradeRequestCreation(PostTradeBankModel postTradeBankModel) throws WebClientResponseException {
        Object postBody = postTradeBankModel;
        // verify the required parameter 'postTradeBankModel' is set
        if (postTradeBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postTradeBankModel' when calling createTrade", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<TradeBankModel> localVarReturnType = new ParameterizedTypeReference<TradeBankModel>() {};
        return apiClient.invokeAPI("/api/trades", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Trade
     * Creates a trade.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the trade details in our private store | | initiating | The Platform has begun to perform the trade | | pending | The Platform is executing the trade | | completed | The Platform has successfully completed the trade | | failed | The Platform was not able to successfully complete the trade |    Required scope: **trades:execute**
     * <p><b>201</b> - Trade created
     * @param postTradeBankModel The postTradeBankModel parameter
     * @return TradeBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TradeBankModel> createTrade(PostTradeBankModel postTradeBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<TradeBankModel> localVarReturnType = new ParameterizedTypeReference<TradeBankModel>() {};
        return createTradeRequestCreation(postTradeBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<TradeBankModel>> createTradeWithHttpInfo(PostTradeBankModel postTradeBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<TradeBankModel> localVarReturnType = new ParameterizedTypeReference<TradeBankModel>() {};
        return createTradeRequestCreation(postTradeBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Trade
     * Retrieves a trade.  Required scope: **trades:read**
     * <p><b>200</b> - trade found
     * @param tradeGuid Identifier for the trade.
     * @return TradeBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTradeRequestCreation(String tradeGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'tradeGuid' is set
        if (tradeGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'tradeGuid' when calling getTrade", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("trade_guid", tradeGuid);

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

        ParameterizedTypeReference<TradeBankModel> localVarReturnType = new ParameterizedTypeReference<TradeBankModel>() {};
        return apiClient.invokeAPI("/api/trades/{trade_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Trade
     * Retrieves a trade.  Required scope: **trades:read**
     * <p><b>200</b> - trade found
     * @param tradeGuid Identifier for the trade.
     * @return TradeBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TradeBankModel> getTrade(String tradeGuid) throws WebClientResponseException {
        ParameterizedTypeReference<TradeBankModel> localVarReturnType = new ParameterizedTypeReference<TradeBankModel>() {};
        return getTradeRequestCreation(tradeGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<TradeBankModel>> getTradeWithHttpInfo(String tradeGuid) throws WebClientResponseException {
        ParameterizedTypeReference<TradeBankModel> localVarReturnType = new ParameterizedTypeReference<TradeBankModel>() {};
        return getTradeRequestCreation(tradeGuid).toEntity(localVarReturnType);
    }
    /**
     * Get trades list
     * Retrieves a listing of trades.  Required scope: **trades:read**
     * <p><b>200</b> - get list of trades
     * @param customerGuid The customer&#39;s identifier.
     * @param accountGuid The account&#39;s identifier.
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated trade_guids to list trades for.
     * @return TradeListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listTradesRequestCreation(String customerGuid, String accountGuid, java.math.BigInteger page, java.math.BigInteger perPage, String guid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerGuid' is set
        if (customerGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerGuid' when calling listTrades", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'accountGuid' is set
        if (accountGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'accountGuid' when calling listTrades", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "per_page", perPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "guid", guid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "customer_guid", customerGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_guid", accountGuid));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<TradeListBankModel> localVarReturnType = new ParameterizedTypeReference<TradeListBankModel>() {};
        return apiClient.invokeAPI("/api/trades", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get trades list
     * Retrieves a listing of trades.  Required scope: **trades:read**
     * <p><b>200</b> - get list of trades
     * @param customerGuid The customer&#39;s identifier.
     * @param accountGuid The account&#39;s identifier.
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated trade_guids to list trades for.
     * @return TradeListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TradeListBankModel> listTrades(String customerGuid, String accountGuid, java.math.BigInteger page, java.math.BigInteger perPage, String guid) throws WebClientResponseException {
        ParameterizedTypeReference<TradeListBankModel> localVarReturnType = new ParameterizedTypeReference<TradeListBankModel>() {};
        return listTradesRequestCreation(customerGuid, accountGuid, page, perPage, guid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<TradeListBankModel>> listTradesWithHttpInfo(String customerGuid, String accountGuid, java.math.BigInteger page, java.math.BigInteger perPage, String guid) throws WebClientResponseException {
        ParameterizedTypeReference<TradeListBankModel> localVarReturnType = new ParameterizedTypeReference<TradeListBankModel>() {};
        return listTradesRequestCreation(customerGuid, accountGuid, page, perPage, guid).toEntity(localVarReturnType);
    }
}

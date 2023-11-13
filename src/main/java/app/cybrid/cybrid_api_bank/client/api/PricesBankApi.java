package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.SymbolPriceBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:36:54.850726Z[Etc/UTC]")
public class PricesBankApi {
    private ApiClient apiClient;

    public PricesBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public PricesBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Price
     * Retrieves a listing of symbol prices.  ## Symbols  Symbol are pairs and are in the format asset-counter_asset, e.g., &#39;BTC-USD&#39; for the Bitcoin/ USD pair. See the Symbols API for a complete list of cryptocurrencies supported.    Required scope: **prices:read**
     * <p><b>200</b> - get list of price
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param symbol Comma separated symbols to list prices for.
     * @param bankGuid The bank identifier to retrieve prices for.
     * @return List&lt;SymbolPriceBankModel&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listPricesRequestCreation(String symbol, String bankGuid) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "symbol", symbol));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bank_guid", bankGuid));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<SymbolPriceBankModel> localVarReturnType = new ParameterizedTypeReference<SymbolPriceBankModel>() {};
        return apiClient.invokeAPI("/api/prices", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Price
     * Retrieves a listing of symbol prices.  ## Symbols  Symbol are pairs and are in the format asset-counter_asset, e.g., &#39;BTC-USD&#39; for the Bitcoin/ USD pair. See the Symbols API for a complete list of cryptocurrencies supported.    Required scope: **prices:read**
     * <p><b>200</b> - get list of price
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param symbol Comma separated symbols to list prices for.
     * @param bankGuid The bank identifier to retrieve prices for.
     * @return List&lt;SymbolPriceBankModel&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Flux<SymbolPriceBankModel> listPrices(String symbol, String bankGuid) throws WebClientResponseException {
        ParameterizedTypeReference<SymbolPriceBankModel> localVarReturnType = new ParameterizedTypeReference<SymbolPriceBankModel>() {};
        return listPricesRequestCreation(symbol, bankGuid).bodyToFlux(localVarReturnType);
    }

    public Mono<ResponseEntity<List<SymbolPriceBankModel>>> listPricesWithHttpInfo(String symbol, String bankGuid) throws WebClientResponseException {
        ParameterizedTypeReference<SymbolPriceBankModel> localVarReturnType = new ParameterizedTypeReference<SymbolPriceBankModel>() {};
        return listPricesRequestCreation(symbol, bankGuid).toEntityList(localVarReturnType);
    }
}

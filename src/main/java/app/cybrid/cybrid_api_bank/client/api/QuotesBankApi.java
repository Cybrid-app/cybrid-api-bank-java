package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostQuoteBankModel;
import app.cybrid.cybrid_api_bank.client.model.QuoteBankModel;
import app.cybrid.cybrid_api_bank.client.model.QuoteListBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-11-08T23:05:21.414626Z[Etc/UTC]")
public class QuotesBankApi {
    private ApiClient apiClient;

    public QuotesBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public QuotesBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Quote
     * Creates a quote.  ## Quote creation  Quotes can be created for a Bank or a Customer.  To create quotes for your Bank, omit the &#x60;customer_guid&#x60; parameter in the request body. To create quotes for your Customers, include the &#x60;customer_guid&#x60; parameter in the request body.  ## Failure codes  | Code | Description | |------|-------------| | invalid_amount | The amount on the invoice is unprocessable | | insufficient_balance | There are insufficient funds to process the quote | | invalid_invoice | The invoice cannot be processed |    Required scope: **quotes:execute**
     * <p><b>201</b> - quote created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>422</b> - Unable to process request
     * @param postQuoteBankModel The postQuoteBankModel parameter
     * @return QuoteBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createQuoteRequestCreation(PostQuoteBankModel postQuoteBankModel) throws WebClientResponseException {
        Object postBody = postQuoteBankModel;
        // verify the required parameter 'postQuoteBankModel' is set
        if (postQuoteBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postQuoteBankModel' when calling createQuote", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<QuoteBankModel> localVarReturnType = new ParameterizedTypeReference<QuoteBankModel>() {};
        return apiClient.invokeAPI("/api/quotes", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Quote
     * Creates a quote.  ## Quote creation  Quotes can be created for a Bank or a Customer.  To create quotes for your Bank, omit the &#x60;customer_guid&#x60; parameter in the request body. To create quotes for your Customers, include the &#x60;customer_guid&#x60; parameter in the request body.  ## Failure codes  | Code | Description | |------|-------------| | invalid_amount | The amount on the invoice is unprocessable | | insufficient_balance | There are insufficient funds to process the quote | | invalid_invoice | The invoice cannot be processed |    Required scope: **quotes:execute**
     * <p><b>201</b> - quote created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>422</b> - Unable to process request
     * @param postQuoteBankModel The postQuoteBankModel parameter
     * @return QuoteBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<QuoteBankModel> createQuote(PostQuoteBankModel postQuoteBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<QuoteBankModel> localVarReturnType = new ParameterizedTypeReference<QuoteBankModel>() {};
        return createQuoteRequestCreation(postQuoteBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<QuoteBankModel>> createQuoteWithHttpInfo(PostQuoteBankModel postQuoteBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<QuoteBankModel> localVarReturnType = new ParameterizedTypeReference<QuoteBankModel>() {};
        return createQuoteRequestCreation(postQuoteBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Quote
     * Retrieves a quote.  Required scope: **quotes:read**
     * <p><b>200</b> - quote found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - quote not found
     * @param quoteGuid Identifier for the quote.
     * @return QuoteBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getQuoteRequestCreation(String quoteGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'quoteGuid' is set
        if (quoteGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'quoteGuid' when calling getQuote", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("quote_guid", quoteGuid);

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

        ParameterizedTypeReference<QuoteBankModel> localVarReturnType = new ParameterizedTypeReference<QuoteBankModel>() {};
        return apiClient.invokeAPI("/api/quotes/{quote_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Quote
     * Retrieves a quote.  Required scope: **quotes:read**
     * <p><b>200</b> - quote found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - quote not found
     * @param quoteGuid Identifier for the quote.
     * @return QuoteBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<QuoteBankModel> getQuote(String quoteGuid) throws WebClientResponseException {
        ParameterizedTypeReference<QuoteBankModel> localVarReturnType = new ParameterizedTypeReference<QuoteBankModel>() {};
        return getQuoteRequestCreation(quoteGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<QuoteBankModel>> getQuoteWithHttpInfo(String quoteGuid) throws WebClientResponseException {
        ParameterizedTypeReference<QuoteBankModel> localVarReturnType = new ParameterizedTypeReference<QuoteBankModel>() {};
        return getQuoteRequestCreation(quoteGuid).toEntity(localVarReturnType);
    }
    /**
     * Get quotes list
     * Retrieves a listing of quotes for all customers of a bank.  Required scope: **quotes:read**
     * <p><b>200</b> - get list of quotes
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @param guid Comma separated quote_guids to list quotes for.
     * @param productType Comma separated product_types to list accounts for.
     * @param bankGuid Comma separated bank_guids to list quotes for.
     * @param customerGuid Comma separated customer_guids to list quotes for.
     * @param side Comma separated sides to list quotes for.
     * @return QuoteListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listQuotesRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String productType, String bankGuid, String customerGuid, String side) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "product_type", productType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bank_guid", bankGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "customer_guid", customerGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "side", side));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<QuoteListBankModel> localVarReturnType = new ParameterizedTypeReference<QuoteListBankModel>() {};
        return apiClient.invokeAPI("/api/quotes", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get quotes list
     * Retrieves a listing of quotes for all customers of a bank.  Required scope: **quotes:read**
     * <p><b>200</b> - get list of quotes
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @param guid Comma separated quote_guids to list quotes for.
     * @param productType Comma separated product_types to list accounts for.
     * @param bankGuid Comma separated bank_guids to list quotes for.
     * @param customerGuid Comma separated customer_guids to list quotes for.
     * @param side Comma separated sides to list quotes for.
     * @return QuoteListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<QuoteListBankModel> listQuotes(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String productType, String bankGuid, String customerGuid, String side) throws WebClientResponseException {
        ParameterizedTypeReference<QuoteListBankModel> localVarReturnType = new ParameterizedTypeReference<QuoteListBankModel>() {};
        return listQuotesRequestCreation(page, perPage, guid, productType, bankGuid, customerGuid, side).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<QuoteListBankModel>> listQuotesWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String productType, String bankGuid, String customerGuid, String side) throws WebClientResponseException {
        ParameterizedTypeReference<QuoteListBankModel> localVarReturnType = new ParameterizedTypeReference<QuoteListBankModel>() {};
        return listQuotesRequestCreation(page, perPage, guid, productType, bankGuid, customerGuid, side).toEntity(localVarReturnType);
    }
}

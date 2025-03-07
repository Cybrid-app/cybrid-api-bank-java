package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.InvoiceBankModel;
import app.cybrid.cybrid_api_bank.client.model.InvoiceListBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostInvoiceBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-07T14:41:12.090177Z[Etc/UTC]")
public class InvoicesBankApi {
    private ApiClient apiClient;

    public InvoicesBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public InvoicesBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Cancel Invoice
     * Cancels an invoice.  Required scope: **invoices:execute**
     * <p><b>200</b> - Invoice cancelled
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Invoice not found
     * @param invoiceGuid Identifier for the invoice.
     * @return InvoiceBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec cancelInvoiceRequestCreation(String invoiceGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'invoiceGuid' is set
        if (invoiceGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'invoiceGuid' when calling cancelInvoice", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("invoice_guid", invoiceGuid);

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

        ParameterizedTypeReference<InvoiceBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceBankModel>() {};
        return apiClient.invokeAPI("/api/invoices/{invoice_guid}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Cancel Invoice
     * Cancels an invoice.  Required scope: **invoices:execute**
     * <p><b>200</b> - Invoice cancelled
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Invoice not found
     * @param invoiceGuid Identifier for the invoice.
     * @return InvoiceBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoiceBankModel> cancelInvoice(String invoiceGuid) throws WebClientResponseException {
        ParameterizedTypeReference<InvoiceBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceBankModel>() {};
        return cancelInvoiceRequestCreation(invoiceGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<InvoiceBankModel>> cancelInvoiceWithHttpInfo(String invoiceGuid) throws WebClientResponseException {
        ParameterizedTypeReference<InvoiceBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceBankModel>() {};
        return cancelInvoiceRequestCreation(invoiceGuid).toEntity(localVarReturnType);
    }
    /**
     * Create Invoice
     * Creates a invoice.  ## State  | State | Description | |-------|-------------| | storing    | The Platform is storing the invoice details in our private store | | unpaid     | The invoice is unpaid. Payment instructions can be generated for an invoice in this state | | cancelling | The invocie is in the process of being cancelled | | cancelled  | The invoice has been cancelled |  | settling   | The invoice has been paid and the funds associated with this invoice are in the process of being settled | | paid       | The invoice has been paid and the funds associated with this invoice have been settled |     Required scope: **invoices:execute**
     * <p><b>201</b> - Invoice created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postInvoiceBankModel The postInvoiceBankModel parameter
     * @return InvoiceBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createInvoiceRequestCreation(PostInvoiceBankModel postInvoiceBankModel) throws WebClientResponseException {
        Object postBody = postInvoiceBankModel;
        // verify the required parameter 'postInvoiceBankModel' is set
        if (postInvoiceBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postInvoiceBankModel' when calling createInvoice", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<InvoiceBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceBankModel>() {};
        return apiClient.invokeAPI("/api/invoices", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Invoice
     * Creates a invoice.  ## State  | State | Description | |-------|-------------| | storing    | The Platform is storing the invoice details in our private store | | unpaid     | The invoice is unpaid. Payment instructions can be generated for an invoice in this state | | cancelling | The invocie is in the process of being cancelled | | cancelled  | The invoice has been cancelled |  | settling   | The invoice has been paid and the funds associated with this invoice are in the process of being settled | | paid       | The invoice has been paid and the funds associated with this invoice have been settled |     Required scope: **invoices:execute**
     * <p><b>201</b> - Invoice created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postInvoiceBankModel The postInvoiceBankModel parameter
     * @return InvoiceBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoiceBankModel> createInvoice(PostInvoiceBankModel postInvoiceBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<InvoiceBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceBankModel>() {};
        return createInvoiceRequestCreation(postInvoiceBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<InvoiceBankModel>> createInvoiceWithHttpInfo(PostInvoiceBankModel postInvoiceBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<InvoiceBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceBankModel>() {};
        return createInvoiceRequestCreation(postInvoiceBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Invoice
     * Retrieves a invoice.  Required scope: **invoices:read**
     * <p><b>200</b> - invoice found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - invoice not found
     * @param invoiceGuid Identifier for the payment instruction.
     * @return InvoiceBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getInvoiceRequestCreation(String invoiceGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'invoiceGuid' is set
        if (invoiceGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'invoiceGuid' when calling getInvoice", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("invoice_guid", invoiceGuid);

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

        ParameterizedTypeReference<InvoiceBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceBankModel>() {};
        return apiClient.invokeAPI("/api/invoices/{invoice_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Invoice
     * Retrieves a invoice.  Required scope: **invoices:read**
     * <p><b>200</b> - invoice found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - invoice not found
     * @param invoiceGuid Identifier for the payment instruction.
     * @return InvoiceBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoiceBankModel> getInvoice(String invoiceGuid) throws WebClientResponseException {
        ParameterizedTypeReference<InvoiceBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceBankModel>() {};
        return getInvoiceRequestCreation(invoiceGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<InvoiceBankModel>> getInvoiceWithHttpInfo(String invoiceGuid) throws WebClientResponseException {
        ParameterizedTypeReference<InvoiceBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceBankModel>() {};
        return getInvoiceRequestCreation(invoiceGuid).toEntity(localVarReturnType);
    }
    /**
     * List Invoices
     * Retrieves a list of invoices.  Required scope: **invoices:read**
     * <p><b>200</b> - get list of invoices
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated guids to list invoices for.
     * @param bankGuid Comma separated bank_guids to list invoices for.
     * @param customerGuid Comma separated customer_guids to list invoices for.
     * @param accountGuid Comma separated account_guids to list invoices for.
     * @param state Comma separated states to list invoices for.
     * @param asset Comma separated assets to list invoices for.
     * @param environment The environment parameter
     * @param label Comma separated labels to list invoices for.
     * @return InvoiceListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listInvoicesRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String accountGuid, String state, String asset, String environment, String label) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_guid", accountGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "state", state));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "asset", asset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "environment", environment));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "label", label));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<InvoiceListBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceListBankModel>() {};
        return apiClient.invokeAPI("/api/invoices", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Invoices
     * Retrieves a list of invoices.  Required scope: **invoices:read**
     * <p><b>200</b> - get list of invoices
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated guids to list invoices for.
     * @param bankGuid Comma separated bank_guids to list invoices for.
     * @param customerGuid Comma separated customer_guids to list invoices for.
     * @param accountGuid Comma separated account_guids to list invoices for.
     * @param state Comma separated states to list invoices for.
     * @param asset Comma separated assets to list invoices for.
     * @param environment The environment parameter
     * @param label Comma separated labels to list invoices for.
     * @return InvoiceListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoiceListBankModel> listInvoices(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String accountGuid, String state, String asset, String environment, String label) throws WebClientResponseException {
        ParameterizedTypeReference<InvoiceListBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceListBankModel>() {};
        return listInvoicesRequestCreation(page, perPage, guid, bankGuid, customerGuid, accountGuid, state, asset, environment, label).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<InvoiceListBankModel>> listInvoicesWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String accountGuid, String state, String asset, String environment, String label) throws WebClientResponseException {
        ParameterizedTypeReference<InvoiceListBankModel> localVarReturnType = new ParameterizedTypeReference<InvoiceListBankModel>() {};
        return listInvoicesRequestCreation(page, perPage, guid, bankGuid, customerGuid, accountGuid, state, asset, environment, label).toEntity(localVarReturnType);
    }
}

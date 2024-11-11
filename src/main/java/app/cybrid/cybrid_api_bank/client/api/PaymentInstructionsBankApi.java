package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PaymentInstructionBankModel;
import app.cybrid.cybrid_api_bank.client.model.PaymentInstructionListBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostPaymentInstructionBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-11-11T21:16:51.036387Z[Etc/UTC]")
public class PaymentInstructionsBankApi {
    private ApiClient apiClient;

    public PaymentInstructionsBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public PaymentInstructionsBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Payment Instruction
     * Creates a payment instruction.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the payment instruction details in our private store | | created | The Platform has created the payment instruction | | expired | The PaymentInstruction is no longer valid |    Required scope: **invoices:write**
     * <p><b>201</b> - Payment Instruction created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postPaymentInstructionBankModel The postPaymentInstructionBankModel parameter
     * @return PaymentInstructionBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createPaymentInstructionRequestCreation(PostPaymentInstructionBankModel postPaymentInstructionBankModel) throws WebClientResponseException {
        Object postBody = postPaymentInstructionBankModel;
        // verify the required parameter 'postPaymentInstructionBankModel' is set
        if (postPaymentInstructionBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postPaymentInstructionBankModel' when calling createPaymentInstruction", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PaymentInstructionBankModel> localVarReturnType = new ParameterizedTypeReference<PaymentInstructionBankModel>() {};
        return apiClient.invokeAPI("/api/payment_instructions", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Payment Instruction
     * Creates a payment instruction.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the payment instruction details in our private store | | created | The Platform has created the payment instruction | | expired | The PaymentInstruction is no longer valid |    Required scope: **invoices:write**
     * <p><b>201</b> - Payment Instruction created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postPaymentInstructionBankModel The postPaymentInstructionBankModel parameter
     * @return PaymentInstructionBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PaymentInstructionBankModel> createPaymentInstruction(PostPaymentInstructionBankModel postPaymentInstructionBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstructionBankModel> localVarReturnType = new ParameterizedTypeReference<PaymentInstructionBankModel>() {};
        return createPaymentInstructionRequestCreation(postPaymentInstructionBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<PaymentInstructionBankModel>> createPaymentInstructionWithHttpInfo(PostPaymentInstructionBankModel postPaymentInstructionBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstructionBankModel> localVarReturnType = new ParameterizedTypeReference<PaymentInstructionBankModel>() {};
        return createPaymentInstructionRequestCreation(postPaymentInstructionBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Payment Instruction
     * Retrieves a payment_instruction.  Required scope: **invoices:read**
     * <p><b>200</b> - payment_instruction found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - payment_instruction not found
     * @param paymentInstructionGuid Identifier for the payment instruction.
     * @return PaymentInstructionBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getPaymentInstructionRequestCreation(String paymentInstructionGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'paymentInstructionGuid' is set
        if (paymentInstructionGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'paymentInstructionGuid' when calling getPaymentInstruction", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("payment_instruction_guid", paymentInstructionGuid);

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

        ParameterizedTypeReference<PaymentInstructionBankModel> localVarReturnType = new ParameterizedTypeReference<PaymentInstructionBankModel>() {};
        return apiClient.invokeAPI("/api/payment_instructions/{payment_instruction_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Payment Instruction
     * Retrieves a payment_instruction.  Required scope: **invoices:read**
     * <p><b>200</b> - payment_instruction found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - payment_instruction not found
     * @param paymentInstructionGuid Identifier for the payment instruction.
     * @return PaymentInstructionBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PaymentInstructionBankModel> getPaymentInstruction(String paymentInstructionGuid) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstructionBankModel> localVarReturnType = new ParameterizedTypeReference<PaymentInstructionBankModel>() {};
        return getPaymentInstructionRequestCreation(paymentInstructionGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<PaymentInstructionBankModel>> getPaymentInstructionWithHttpInfo(String paymentInstructionGuid) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstructionBankModel> localVarReturnType = new ParameterizedTypeReference<PaymentInstructionBankModel>() {};
        return getPaymentInstructionRequestCreation(paymentInstructionGuid).toEntity(localVarReturnType);
    }
    /**
     * List Payment Instructions
     * Retrieves a list of payment instructions.  Required scope: **invoices:read**
     * <p><b>200</b> - get list of payment instructions
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated guids to list payment instructions for.
     * @param bankGuid Comma separated bank_guids to list payment instructions for.
     * @param customerGuid Comma separated customer_guids to list payment instructions for.
     * @param invoiceGuid Comma separated invoice_guids to list payment instructions for.
     * @return PaymentInstructionListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listPaymentInstructionsRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String invoiceGuid) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "invoice_guid", invoiceGuid));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<PaymentInstructionListBankModel> localVarReturnType = new ParameterizedTypeReference<PaymentInstructionListBankModel>() {};
        return apiClient.invokeAPI("/api/payment_instructions", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Payment Instructions
     * Retrieves a list of payment instructions.  Required scope: **invoices:read**
     * <p><b>200</b> - get list of payment instructions
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated guids to list payment instructions for.
     * @param bankGuid Comma separated bank_guids to list payment instructions for.
     * @param customerGuid Comma separated customer_guids to list payment instructions for.
     * @param invoiceGuid Comma separated invoice_guids to list payment instructions for.
     * @return PaymentInstructionListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PaymentInstructionListBankModel> listPaymentInstructions(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String invoiceGuid) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstructionListBankModel> localVarReturnType = new ParameterizedTypeReference<PaymentInstructionListBankModel>() {};
        return listPaymentInstructionsRequestCreation(page, perPage, guid, bankGuid, customerGuid, invoiceGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<PaymentInstructionListBankModel>> listPaymentInstructionsWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid, String invoiceGuid) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstructionListBankModel> localVarReturnType = new ParameterizedTypeReference<PaymentInstructionListBankModel>() {};
        return listPaymentInstructionsRequestCreation(page, perPage, guid, bankGuid, customerGuid, invoiceGuid).toEntity(localVarReturnType);
    }
}

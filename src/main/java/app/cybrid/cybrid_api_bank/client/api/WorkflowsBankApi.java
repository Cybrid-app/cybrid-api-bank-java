package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostWorkflowBankModel;
import app.cybrid.cybrid_api_bank.client.model.WorkflowBankModel;
import app.cybrid.cybrid_api_bank.client.model.WorkflowWithDetailsBankModel;
import app.cybrid.cybrid_api_bank.client.model.WorkflowsListBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-13T13:38:00.422222Z[Etc/UTC]")
public class WorkflowsBankApi {
    private ApiClient apiClient;

    public WorkflowsBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public WorkflowsBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Workflow
     * Creates a workflow.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the workflow details in our private store | | completed | The Platform has created the workflow | | failed | The workflow was not completed successfully |  ## Plaid  | Param | Description | |-------|-------------| | redirect_uri | All URIs must be registered with Cybrid. For local testing use &#x60;http://localhost:4200/bank-account-connect&#x60; |    Required scope: **workflows:execute**
     * <p><b>201</b> - Workflow created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>422</b> - Unable to process request
     * @param postWorkflowBankModel The postWorkflowBankModel parameter
     * @return WorkflowBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createWorkflowRequestCreation(PostWorkflowBankModel postWorkflowBankModel) throws WebClientResponseException {
        Object postBody = postWorkflowBankModel;
        // verify the required parameter 'postWorkflowBankModel' is set
        if (postWorkflowBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postWorkflowBankModel' when calling createWorkflow", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<WorkflowBankModel> localVarReturnType = new ParameterizedTypeReference<WorkflowBankModel>() {};
        return apiClient.invokeAPI("/api/workflows", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Workflow
     * Creates a workflow.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the workflow details in our private store | | completed | The Platform has created the workflow | | failed | The workflow was not completed successfully |  ## Plaid  | Param | Description | |-------|-------------| | redirect_uri | All URIs must be registered with Cybrid. For local testing use &#x60;http://localhost:4200/bank-account-connect&#x60; |    Required scope: **workflows:execute**
     * <p><b>201</b> - Workflow created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>422</b> - Unable to process request
     * @param postWorkflowBankModel The postWorkflowBankModel parameter
     * @return WorkflowBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<WorkflowBankModel> createWorkflow(PostWorkflowBankModel postWorkflowBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<WorkflowBankModel> localVarReturnType = new ParameterizedTypeReference<WorkflowBankModel>() {};
        return createWorkflowRequestCreation(postWorkflowBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<WorkflowBankModel>> createWorkflowWithHttpInfo(PostWorkflowBankModel postWorkflowBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<WorkflowBankModel> localVarReturnType = new ParameterizedTypeReference<WorkflowBankModel>() {};
        return createWorkflowRequestCreation(postWorkflowBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get Workflow
     * Retrieves a workflow.  Required scope: **workflows:read**
     * <p><b>200</b> - trade found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - workflow not found
     * @param workflowGuid Identifier for the workflow.
     * @return WorkflowWithDetailsBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getWorkflowRequestCreation(String workflowGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'workflowGuid' is set
        if (workflowGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'workflowGuid' when calling getWorkflow", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("workflow_guid", workflowGuid);

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

        ParameterizedTypeReference<WorkflowWithDetailsBankModel> localVarReturnType = new ParameterizedTypeReference<WorkflowWithDetailsBankModel>() {};
        return apiClient.invokeAPI("/api/workflows/{workflow_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Workflow
     * Retrieves a workflow.  Required scope: **workflows:read**
     * <p><b>200</b> - trade found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - workflow not found
     * @param workflowGuid Identifier for the workflow.
     * @return WorkflowWithDetailsBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<WorkflowWithDetailsBankModel> getWorkflow(String workflowGuid) throws WebClientResponseException {
        ParameterizedTypeReference<WorkflowWithDetailsBankModel> localVarReturnType = new ParameterizedTypeReference<WorkflowWithDetailsBankModel>() {};
        return getWorkflowRequestCreation(workflowGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<WorkflowWithDetailsBankModel>> getWorkflowWithHttpInfo(String workflowGuid) throws WebClientResponseException {
        ParameterizedTypeReference<WorkflowWithDetailsBankModel> localVarReturnType = new ParameterizedTypeReference<WorkflowWithDetailsBankModel>() {};
        return getWorkflowRequestCreation(workflowGuid).toEntity(localVarReturnType);
    }
    /**
     * Get workflows list
     * Retrieves a listing of workflows.  Required scope: **workflows:read**
     * <p><b>200</b> - get list of workflows
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated workflow_guids to list workflows for.
     * @param bankGuid Comma separated bank_guids to list workflows for.
     * @param customerGuid Comma separated customer_guids to list workflows for.
     * @return WorkflowsListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listWorkflowsRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
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

        ParameterizedTypeReference<WorkflowsListBankModel> localVarReturnType = new ParameterizedTypeReference<WorkflowsListBankModel>() {};
        return apiClient.invokeAPI("/api/workflows", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get workflows list
     * Retrieves a listing of workflows.  Required scope: **workflows:read**
     * <p><b>200</b> - get list of workflows
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated workflow_guids to list workflows for.
     * @param bankGuid Comma separated bank_guids to list workflows for.
     * @param customerGuid Comma separated customer_guids to list workflows for.
     * @return WorkflowsListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<WorkflowsListBankModel> listWorkflows(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<WorkflowsListBankModel> localVarReturnType = new ParameterizedTypeReference<WorkflowsListBankModel>() {};
        return listWorkflowsRequestCreation(page, perPage, guid, bankGuid, customerGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<WorkflowsListBankModel>> listWorkflowsWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String bankGuid, String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<WorkflowsListBankModel> localVarReturnType = new ParameterizedTypeReference<WorkflowsListBankModel>() {};
        return listWorkflowsRequestCreation(page, perPage, guid, bankGuid, customerGuid).toEntity(localVarReturnType);
    }
}

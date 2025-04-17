package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PlatformFileBankModel;
import app.cybrid.cybrid_api_bank.client.model.PlatformFileListBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostFileBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-17T18:34:32.326251Z[Etc/UTC]")
public class FilesBankApi {
    private ApiClient apiClient;

    public FilesBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public FilesBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create File
     * Creates a file.  #### This feature is currently in preview mode and is not yet available for partner use.  ## Data  The attribute contains the base64 encoded file content. The value needs to be smaller than 10MB otherwise the Platform will reject the request. To upload files larger than 10MB do not provide the content and use the returned upload URL to provide the file.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the file in our private store | | completed | The Platform has completed storing the file | | failed | The Platform failed to store the file |    Required scope: **files:execute**
     * <p><b>201</b> - file created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postFileBankModel The postFileBankModel parameter
     * @return PlatformFileBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createFileRequestCreation(PostFileBankModel postFileBankModel) throws WebClientResponseException {
        Object postBody = postFileBankModel;
        // verify the required parameter 'postFileBankModel' is set
        if (postFileBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postFileBankModel' when calling createFile", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PlatformFileBankModel> localVarReturnType = new ParameterizedTypeReference<PlatformFileBankModel>() {};
        return apiClient.invokeAPI("/api/files", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create File
     * Creates a file.  #### This feature is currently in preview mode and is not yet available for partner use.  ## Data  The attribute contains the base64 encoded file content. The value needs to be smaller than 10MB otherwise the Platform will reject the request. To upload files larger than 10MB do not provide the content and use the returned upload URL to provide the file.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the file in our private store | | completed | The Platform has completed storing the file | | failed | The Platform failed to store the file |    Required scope: **files:execute**
     * <p><b>201</b> - file created
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postFileBankModel The postFileBankModel parameter
     * @return PlatformFileBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PlatformFileBankModel> createFile(PostFileBankModel postFileBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<PlatformFileBankModel> localVarReturnType = new ParameterizedTypeReference<PlatformFileBankModel>() {};
        return createFileRequestCreation(postFileBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<PlatformFileBankModel>> createFileWithHttpInfo(PostFileBankModel postFileBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<PlatformFileBankModel> localVarReturnType = new ParameterizedTypeReference<PlatformFileBankModel>() {};
        return createFileRequestCreation(postFileBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get File
     * Retrieves a file.  Required scope: **files:read**
     * <p><b>200</b> - file found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - file not found
     * @param fileGuid Identifier for the file.
     * @return PlatformFileBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getFileRequestCreation(String fileGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'fileGuid' is set
        if (fileGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'fileGuid' when calling getFile", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("file_guid", fileGuid);

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

        ParameterizedTypeReference<PlatformFileBankModel> localVarReturnType = new ParameterizedTypeReference<PlatformFileBankModel>() {};
        return apiClient.invokeAPI("/api/files/{file_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get File
     * Retrieves a file.  Required scope: **files:read**
     * <p><b>200</b> - file found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - file not found
     * @param fileGuid Identifier for the file.
     * @return PlatformFileBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PlatformFileBankModel> getFile(String fileGuid) throws WebClientResponseException {
        ParameterizedTypeReference<PlatformFileBankModel> localVarReturnType = new ParameterizedTypeReference<PlatformFileBankModel>() {};
        return getFileRequestCreation(fileGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<PlatformFileBankModel>> getFileWithHttpInfo(String fileGuid) throws WebClientResponseException {
        ParameterizedTypeReference<PlatformFileBankModel> localVarReturnType = new ParameterizedTypeReference<PlatformFileBankModel>() {};
        return getFileRequestCreation(fileGuid).toEntity(localVarReturnType);
    }
    /**
     * List Files
     * Retrieves a list of files.  Required scope: **files:read**
     * <p><b>200</b> - get list of files
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated file_guids to list files for.
     * @param type Comma separated file types to list files for.
     * @param state Comma separated file states to list files for.
     * @param bankGuid Comma separated bank_guids to list files for.
     * @param customerGuid Comma separated customer_guids to list files for.
     * @return PlatformFileListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listFilesRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String type, String state, String bankGuid, String customerGuid) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "state", state));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bank_guid", bankGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "customer_guid", customerGuid));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<PlatformFileListBankModel> localVarReturnType = new ParameterizedTypeReference<PlatformFileListBankModel>() {};
        return apiClient.invokeAPI("/api/files", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Files
     * Retrieves a list of files.  Required scope: **files:read**
     * <p><b>200</b> - get list of files
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated file_guids to list files for.
     * @param type Comma separated file types to list files for.
     * @param state Comma separated file states to list files for.
     * @param bankGuid Comma separated bank_guids to list files for.
     * @param customerGuid Comma separated customer_guids to list files for.
     * @return PlatformFileListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PlatformFileListBankModel> listFiles(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String type, String state, String bankGuid, String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<PlatformFileListBankModel> localVarReturnType = new ParameterizedTypeReference<PlatformFileListBankModel>() {};
        return listFilesRequestCreation(page, perPage, guid, type, state, bankGuid, customerGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<PlatformFileListBankModel>> listFilesWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String type, String state, String bankGuid, String customerGuid) throws WebClientResponseException {
        ParameterizedTypeReference<PlatformFileListBankModel> localVarReturnType = new ParameterizedTypeReference<PlatformFileListBankModel>() {};
        return listFilesRequestCreation(page, perPage, guid, type, state, bankGuid, customerGuid).toEntity(localVarReturnType);
    }
}

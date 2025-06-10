package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PersonaSessionBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostPersonaSessionBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-10T17:32:32.128150Z[Etc/UTC]")
public class PersonaSessionsBankApi {
    private ApiClient apiClient;

    public PersonaSessionsBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public PersonaSessionsBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Persona Session
     * Create a Persona session.  Required scope: **persona_sessions:execute**
     * <p><b>201</b> - session created
     * <p><b>409</b> - Inquiry already completed
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Identity verification not found
     * @param postPersonaSessionBankModel The postPersonaSessionBankModel parameter
     * @return PersonaSessionBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createPersonaSessionRequestCreation(PostPersonaSessionBankModel postPersonaSessionBankModel) throws WebClientResponseException {
        Object postBody = postPersonaSessionBankModel;
        // verify the required parameter 'postPersonaSessionBankModel' is set
        if (postPersonaSessionBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postPersonaSessionBankModel' when calling createPersonaSession", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PersonaSessionBankModel> localVarReturnType = new ParameterizedTypeReference<PersonaSessionBankModel>() {};
        return apiClient.invokeAPI("/api/persona_sessions", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Persona Session
     * Create a Persona session.  Required scope: **persona_sessions:execute**
     * <p><b>201</b> - session created
     * <p><b>409</b> - Inquiry already completed
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Identity verification not found
     * @param postPersonaSessionBankModel The postPersonaSessionBankModel parameter
     * @return PersonaSessionBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PersonaSessionBankModel> createPersonaSession(PostPersonaSessionBankModel postPersonaSessionBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<PersonaSessionBankModel> localVarReturnType = new ParameterizedTypeReference<PersonaSessionBankModel>() {};
        return createPersonaSessionRequestCreation(postPersonaSessionBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<PersonaSessionBankModel>> createPersonaSessionWithHttpInfo(PostPersonaSessionBankModel postPersonaSessionBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<PersonaSessionBankModel> localVarReturnType = new ParameterizedTypeReference<PersonaSessionBankModel>() {};
        return createPersonaSessionRequestCreation(postPersonaSessionBankModel).toEntity(localVarReturnType);
    }
}

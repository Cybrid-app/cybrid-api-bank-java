package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.ApiClient;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostVerificationKeyBankModel;
import app.cybrid.cybrid_api_bank.client.model.VerificationKeyBankModel;
import app.cybrid.cybrid_api_bank.client.model.VerificationKeyListBankModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-05-24T17:46:22.440298Z[Etc/UTC]")
public class VerificationKeysBankApi {
    private ApiClient apiClient;

    public VerificationKeysBankApi() {
        this(new ApiClient());
    }

    @Autowired
    public VerificationKeysBankApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create VerificationKey
     * Creates a verification key.   Example code (python) for generating a Verification Key  &#x60;&#x60;&#x60;python import base64  from cryptography.hazmat.primitives import hashes from cryptography.hazmat.primitives import serialization from cryptography.hazmat.primitives.asymmetric import padding from cryptography.hazmat.primitives.asymmetric import rsa  nonce &#x3D; \&quot;wen moon\&quot; private_key &#x3D; rsa.generate_private_key(public_exponent&#x3D;65537, key_size&#x3D;2048) signature &#x3D; base64.b64encode(private_key.sign(     data&#x3D;nonce.encode(&#39;ascii&#39;), padding&#x3D;padding.PKCS1v15(), algorithm&#x3D;hashes.SHA512())).decode(&#39;ascii&#39;) public_key &#x3D; base64.b64encode(private_key.public_key().public_bytes(     encoding&#x3D;serialization.Encoding.DER, format&#x3D;serialization.PublicFormat.SubjectPublicKeyInfo)).decode(&#39;ascii&#39;)  ### DISCLAIMER:- Since NO ENCRYPTION is used in the key storage/formatting. Please DO NOT use this code in production environment. private_pem &#x3D; private_key.private_bytes(encoding&#x3D;serialization.Encoding.PEM, format&#x3D;serialization.PrivateFormat.TraditionalOpenSSL,        encryption_algorithm&#x3D;serialization.NoEncryption())  ## Store the private_key in a file verification_key.pem with open (\&quot;verification_key.pem\&quot;, &#39;wb&#39;) as pem_out:    pem_out.write(private_pem)    pem_out.close()  print(\&quot;Public Key: \&quot;, public_key) print(\&quot;Signature: \&quot;, signature)  &#x60;&#x60;&#x60;&#x60;  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the verification in our private key store | | pending | The Platform is verifying the verification key&#39;s signature | | verified | The Platform has verified the verification key&#39;s signature and the key can be used | | failed | The Platform was not able to verify the verification key&#39;s signature and the key cannot be used |    Required scope: **banks:write**
     * <p><b>201</b> - verification key created
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * @param postVerificationKeyBankModel The postVerificationKeyBankModel parameter
     * @return VerificationKeyBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createVerificationKeyRequestCreation(PostVerificationKeyBankModel postVerificationKeyBankModel) throws WebClientResponseException {
        Object postBody = postVerificationKeyBankModel;
        // verify the required parameter 'postVerificationKeyBankModel' is set
        if (postVerificationKeyBankModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postVerificationKeyBankModel' when calling createVerificationKey", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<VerificationKeyBankModel> localVarReturnType = new ParameterizedTypeReference<VerificationKeyBankModel>() {};
        return apiClient.invokeAPI("/api/bank_verification_keys", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create VerificationKey
     * Creates a verification key.   Example code (python) for generating a Verification Key  &#x60;&#x60;&#x60;python import base64  from cryptography.hazmat.primitives import hashes from cryptography.hazmat.primitives import serialization from cryptography.hazmat.primitives.asymmetric import padding from cryptography.hazmat.primitives.asymmetric import rsa  nonce &#x3D; \&quot;wen moon\&quot; private_key &#x3D; rsa.generate_private_key(public_exponent&#x3D;65537, key_size&#x3D;2048) signature &#x3D; base64.b64encode(private_key.sign(     data&#x3D;nonce.encode(&#39;ascii&#39;), padding&#x3D;padding.PKCS1v15(), algorithm&#x3D;hashes.SHA512())).decode(&#39;ascii&#39;) public_key &#x3D; base64.b64encode(private_key.public_key().public_bytes(     encoding&#x3D;serialization.Encoding.DER, format&#x3D;serialization.PublicFormat.SubjectPublicKeyInfo)).decode(&#39;ascii&#39;)  ### DISCLAIMER:- Since NO ENCRYPTION is used in the key storage/formatting. Please DO NOT use this code in production environment. private_pem &#x3D; private_key.private_bytes(encoding&#x3D;serialization.Encoding.PEM, format&#x3D;serialization.PrivateFormat.TraditionalOpenSSL,        encryption_algorithm&#x3D;serialization.NoEncryption())  ## Store the private_key in a file verification_key.pem with open (\&quot;verification_key.pem\&quot;, &#39;wb&#39;) as pem_out:    pem_out.write(private_pem)    pem_out.close()  print(\&quot;Public Key: \&quot;, public_key) print(\&quot;Signature: \&quot;, signature)  &#x60;&#x60;&#x60;&#x60;  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the verification in our private key store | | pending | The Platform is verifying the verification key&#39;s signature | | verified | The Platform has verified the verification key&#39;s signature and the key can be used | | failed | The Platform was not able to verify the verification key&#39;s signature and the key cannot be used |    Required scope: **banks:write**
     * <p><b>201</b> - verification key created
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * @param postVerificationKeyBankModel The postVerificationKeyBankModel parameter
     * @return VerificationKeyBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<VerificationKeyBankModel> createVerificationKey(PostVerificationKeyBankModel postVerificationKeyBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<VerificationKeyBankModel> localVarReturnType = new ParameterizedTypeReference<VerificationKeyBankModel>() {};
        return createVerificationKeyRequestCreation(postVerificationKeyBankModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<VerificationKeyBankModel>> createVerificationKeyWithHttpInfo(PostVerificationKeyBankModel postVerificationKeyBankModel) throws WebClientResponseException {
        ParameterizedTypeReference<VerificationKeyBankModel> localVarReturnType = new ParameterizedTypeReference<VerificationKeyBankModel>() {};
        return createVerificationKeyRequestCreation(postVerificationKeyBankModel).toEntity(localVarReturnType);
    }
    /**
     * Get VerificationKey
     * Retrieves a verification key.  Required scope: **banks:read**
     * <p><b>200</b> - Verification Key found
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - verification key not found
     * @param verificationKeyGuid Identifier for the verification key.
     * @return VerificationKeyBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getVerificationKeyRequestCreation(String verificationKeyGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'verificationKeyGuid' is set
        if (verificationKeyGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'verificationKeyGuid' when calling getVerificationKey", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("verification_key_guid", verificationKeyGuid);

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

        ParameterizedTypeReference<VerificationKeyBankModel> localVarReturnType = new ParameterizedTypeReference<VerificationKeyBankModel>() {};
        return apiClient.invokeAPI("/api/bank_verification_keys/{verification_key_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get VerificationKey
     * Retrieves a verification key.  Required scope: **banks:read**
     * <p><b>200</b> - Verification Key found
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - verification key not found
     * @param verificationKeyGuid Identifier for the verification key.
     * @return VerificationKeyBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<VerificationKeyBankModel> getVerificationKey(String verificationKeyGuid) throws WebClientResponseException {
        ParameterizedTypeReference<VerificationKeyBankModel> localVarReturnType = new ParameterizedTypeReference<VerificationKeyBankModel>() {};
        return getVerificationKeyRequestCreation(verificationKeyGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<VerificationKeyBankModel>> getVerificationKeyWithHttpInfo(String verificationKeyGuid) throws WebClientResponseException {
        ParameterizedTypeReference<VerificationKeyBankModel> localVarReturnType = new ParameterizedTypeReference<VerificationKeyBankModel>() {};
        return getVerificationKeyRequestCreation(verificationKeyGuid).toEntity(localVarReturnType);
    }
    /**
     * Get Verification Keys list
     * Retrieves a listing of verification keys of a bank.  Required scope: **banks:read**
     * <p><b>200</b> - get list of verification keys
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @return VerificationKeyListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listVerificationKeysRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage) throws WebClientResponseException {
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

        ParameterizedTypeReference<VerificationKeyListBankModel> localVarReturnType = new ParameterizedTypeReference<VerificationKeyListBankModel>() {};
        return apiClient.invokeAPI("/api/bank_verification_keys", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Verification Keys list
     * Retrieves a listing of verification keys of a bank.  Required scope: **banks:read**
     * <p><b>200</b> - get list of verification keys
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * @param page The page parameter
     * @param perPage The perPage parameter
     * @return VerificationKeyListBankModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<VerificationKeyListBankModel> listVerificationKeys(java.math.BigInteger page, java.math.BigInteger perPage) throws WebClientResponseException {
        ParameterizedTypeReference<VerificationKeyListBankModel> localVarReturnType = new ParameterizedTypeReference<VerificationKeyListBankModel>() {};
        return listVerificationKeysRequestCreation(page, perPage).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<VerificationKeyListBankModel>> listVerificationKeysWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage) throws WebClientResponseException {
        ParameterizedTypeReference<VerificationKeyListBankModel> localVarReturnType = new ParameterizedTypeReference<VerificationKeyListBankModel>() {};
        return listVerificationKeysRequestCreation(page, perPage).toEntity(localVarReturnType);
    }
}

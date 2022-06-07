/*
 * Cybrid Bank API
 * # Welcome  Welcome to the Cybrid platform; enabling turnkey crypto banking services!  In these documents, you will find information on the operations provided by our platform, as well as details on how our REST API operates more generally.  Our complete set of APIs allows you to manage all your resources: your Organization, your banks and your identities. The complete set of APIs can be found on the following pages:  | API                                                            | Description                  | |----------------------------------------------------------------|------------------------------| | [Organization API](https://organization.demo.cybrid.app/api/schema/swagger-ui) | APIs to manage organizations | | [Bank API](https://bank.demo.cybrid.app/api/schema/swagger-ui)                 | APIs to manage banks         | | [Identities API](https://id.demo.cybrid.app/api/schema/swagger-ui)                     | APIs to manage identities    |  When you're ready, [request access](https://www.cybrid.xyz/access) to your Dashboard to view and administer your Organization. Once you've logged in, you can begin creating Banks, either for sandbox or production usage, and start enabling your customers to leverage DeFi and web3 with confidence.  If you have any questions, please contact [Support](mailto:support@cybrid.app) at any time so that we can help.  ## Authentication  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create Organization and Bank tokens can be generated via your Dashboard ([request access](https://www.cybrid.xyz/access)).  An Organization Token applies broadly to the whole Organization and all of its Banks, whereas, a Bank Token is specific to an individual Bank.  Both Organization and Bank tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique Client ID and Secret that allows for machine-to-machine authentication.  **Never share your Client ID or Secret publicly or in your source code repository**  Your Client ID and Secret can be exchanged for a time-limited Bearer Token by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document:  ``` curl -X POST https://id.demo.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"<Your requested scopes -- space separated>\"   }' -H \"Content-Type: application/json\" ```  ## Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization or a Bank token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource      | Read scope         | Write scope          | Execute scope     | Token Type         | |---------------|--------------------|----------------------|-------------------|--------------------| | Organizations | organizations:read | organizations:write  |                   | Organization/ Bank | | Banks         | banks:read         | banks:write          | banks:execute     | Organization/ Bank | | Customers     | customers:read     | customers:write      | customers:execute | Bank               | | Assets        | prices:read        |                      |                   | Bank               | | Accounts      | accounts:read      |                      | accounts:execute  | Bank               | | Prices        | prices:read        |                      |                   | Bank               | | Symbols       | prices:read        |                      |                   | Bank               | | Quotes        | quotes:read        |                      | quotes:execute    | Bank               | | Trades        | trades:read        |                      | trades:execute    | Bank               |  ## Organizations  An Organization is meant to model the organization partnering with Cybrid to use our platform.  An Organization does not directly interact with customers. Instead, an Organization has one or more banks, which encompass the financial service offerings of the platform.  ## Banks  A Bank is owned by an Organization and can be thought of as an environment or container for Customers and product offerings. An example of a Bank would be your customer facing banking website, or an internal staging environment for testing and integration.  An Organization can have multiple banks, in sandbox or production environments. A sandbox Bank will be backed by stubbed data and process flows. For instance, identity record and funding source processes will be simulated rather than performed.  ## Customers  Customers represent your banking users on the platform. At present, we offer support for Individuals as Customers.  Customers must be verified in our system before they can play any part on the platform. See the Identity Records section for more details on how a customer can be verified.  Customers must also have an account to be able to transact. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.20.4
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostVerificationKeyBankModel;
import app.cybrid.cybrid_api_bank.client.model.VerificationKeyBankModel;
import app.cybrid.cybrid_api_bank.client.model.VerificationKeyListBankModel;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * API tests for VerificationKeysBankApi
 */
@Ignore
public class VerificationKeysBankApiTest {

    private final VerificationKeysBankApi api = new VerificationKeysBankApi();

    
    /**
     * Create VerificationKey
     *
     * Creates a verification key.   Example code (python) for generating a Verification Key  &#x60;&#x60;&#x60;python import base64  from cryptography.hazmat.primitives import hashes from cryptography.hazmat.primitives import serialization from cryptography.hazmat.primitives.asymmetric import padding from cryptography.hazmat.primitives.asymmetric import rsa  nonce &#x3D; \&quot;wen moon\&quot; private_key &#x3D; rsa.generate_private_key(public_exponent&#x3D;65537, key_size&#x3D;2048) signature &#x3D; base64.b64encode(private_key.sign(     data&#x3D;nonce.encode(&#39;ascii&#39;), padding&#x3D;padding.PKCS1v15(), algorithm&#x3D;hashes.SHA512())).decode(&#39;ascii&#39;) public_key &#x3D; base64.b64encode(private_key.public_key().public_bytes(     encoding&#x3D;serialization.Encoding.DER, format&#x3D;serialization.PublicFormat.SubjectPublicKeyInfo)).decode(&#39;ascii&#39;)  ### DISCLAIMER:- Since NO ENCRYPTION is used in the key storage/formatting. Please DO NOT use this code in production environment. private_pem &#x3D; private_key.private_bytes(encoding&#x3D;serialization.Encoding.PEM, format&#x3D;serialization.PrivateFormat.TraditionalOpenSSL,        encryption_algorithm&#x3D;serialization.NoEncryption())  ## Store the private_key in a file verification_key.pem with open (\&quot;verification_key.pem\&quot;, &#39;wb&#39;) as pem_out:    pem_out.write(private_pem)    pem_out.close()  print(\&quot;Public Key: \&quot;, public_key) print(\&quot;Signature: \&quot;, signature)  &#x60;&#x60;&#x60;&#x60;  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the verification in our private key store | | pending | The Platform is verifying the verification key&#39;s signature | | verified | The Platform has verified the verification key&#39;s signature and the key can be used | | failed | The Platform was not able to verify the verification key&#39;s signature and the key cannot be used |    Required scope: **banks:write**
     */
    @Test
    public void createVerificationKeyTest()  {
        PostVerificationKeyBankModel postVerificationKeyBankModel = null;
        VerificationKeyBankModel response = api.createVerificationKey(postVerificationKeyBankModel).block();

        // TODO: test validations
    }
    
    /**
     * Get VerificationKey
     *
     * Retrieves a verification key.  Required scope: **banks:read**
     */
    @Test
    public void getVerificationKeyTest()  {
        String verificationKeyGuid = null;
        VerificationKeyBankModel response = api.getVerificationKey(verificationKeyGuid).block();

        // TODO: test validations
    }
    
    /**
     * Get Verification Keys list
     *
     * Retrieves a listing of verification keys of a bank.  Required scope: **banks:read**
     */
    @Test
    public void listVerificationKeysTest()  {
        java.math.BigInteger page = null;
        java.math.BigInteger perPage = null;
        VerificationKeyListBankModel response = api.listVerificationKeys(page, perPage).block();

        // TODO: test validations
    }
    
}

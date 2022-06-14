/*
 * Cybrid Bank API
 * # Welcome  Welcome to the Cybrid platform; enabling turnkey crypto banking services!  In these documents, you will find information on the operations provided by our platform, as well as details on how our REST API operates more generally.  Our complete set of APIs allows you to manage all your resources: your Organization, your banks and your identities. The complete set of APIs can be found on the following pages:  | API                                                            | Description                  | |----------------------------------------------------------------|------------------------------| | [Organization API](https://organization.demo.cybrid.app/api/schema/swagger-ui) | APIs to manage organizations | | [Bank API](https://bank.demo.cybrid.app/api/schema/swagger-ui)                 | APIs to manage banks         | | [Identities API](https://id.demo.cybrid.app/api/schema/swagger-ui)                     | APIs to manage identities    |  When you're ready, [request access](https://www.cybrid.xyz/access) to your Dashboard to view and administer your Organization. Once you've logged in, you can begin creating Banks, either for sandbox or production usage, and start enabling your customers to leverage DeFi and web3 with confidence.  If you have any questions, please contact [Support](mailto:support@cybrid.app) at any time so that we can help.  ## Authentication  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create Organization and Bank tokens can be generated via your Dashboard ([request access](https://www.cybrid.xyz/access)).  An Organization Token applies broadly to the whole Organization and all of its Banks, whereas, a Bank Token is specific to an individual Bank.  Both Organization and Bank tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique Client ID and Secret that allows for machine-to-machine authentication.  **Never share your Client ID or Secret publicly or in your source code repository**  Your Client ID and Secret can be exchanged for a time-limited Bearer Token by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document:  ``` curl -X POST https://id.demo.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"<Your requested scopes -- space separated>\"   }' -H \"Content-Type: application/json\" ```  ## Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization or a Bank token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource      | Read scope         | Write scope          | Execute scope     | Token Type         | |---------------|--------------------|----------------------|-------------------|--------------------| | Organizations | organizations:read | organizations:write  |                   | Organization/ Bank | | Banks         | banks:read         | banks:write          | banks:execute     | Organization/ Bank | | Customers     | customers:read     | customers:write      | customers:execute | Bank               | | Assets        | prices:read        |                      |                   | Bank               | | Accounts      | accounts:read      |                      | accounts:execute  | Bank               | | Prices        | prices:read        |                      |                   | Bank               | | Symbols       | prices:read        |                      |                   | Bank               | | Quotes        | quotes:read        |                      | quotes:execute    | Bank               | | Trades        | trades:read        |                      | trades:execute    | Bank               |  ## Organizations  An Organization is meant to model the organization partnering with Cybrid to use our platform.  An Organization does not directly interact with customers. Instead, an Organization has one or more banks, which encompass the financial service offerings of the platform.  ## Banks  A Bank is owned by an Organization and can be thought of as an environment or container for Customers and product offerings. An example of a Bank would be your customer facing banking website, or an internal staging environment for testing and integration.  An Organization can have multiple banks, in sandbox or production environments. A sandbox Bank will be backed by stubbed data and process flows. For instance, identity record and funding source processes will be simulated rather than performed.  ## Customers  Customers represent your banking users on the platform. At present, we offer support for Individuals as Customers.  Customers must be verified in our system before they can play any part on the platform. See the Identity Records section for more details on how a customer can be verified.  Customers must also have an account to be able to transact. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.26.2
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.api;

import app.cybrid.cybrid_api_bank.client.model.ErrorResponseBankModel;
import app.cybrid.cybrid_api_bank.client.model.IdentityRecordBankModel;
import app.cybrid.cybrid_api_bank.client.model.IdentityRecordListBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostIdentityRecordBankModel;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * API tests for IdentityRecordsBankApi
 */
@Ignore
public class IdentityRecordsBankApiTest {

    private final IdentityRecordsBankApi api = new IdentityRecordsBankApi();

    
    /**
     * Create Identity Record
     *
     * Creates an identity record.  ## Identity Records  Identity Records verify an individual for inclusion on the platform. This know-your-customer (KYC) process is a requirement for individuals to be able to transact. At present, we offer support for Attestation Identity Records.  Once an Identity Record has been submitted, it will be reviewed by our system and transit through a lifecycle before ultimately being &#x60;verified&#x60; or &#x60;failed&#x60;. If an Identity Record is ends up &#x60;failed&#x60;, contextual information as to the reason may be provided on the resource and additional attempts can be made.  ## Attestation Identity Records  An Attestation Identity Record is a confirmation of fact that the Organization has completed their own KYC process and can vouch for its correctness.  Prior to uploading &#x60;verified&#x60; attestation identity records, an Organization must register their signing public key with their Bank through the create Verification Key API.  To create an attestation identity record, a signed JWT is required as proof that the Customer&#39;s identity has been verified by the Organization. When creating the JWT, the Organization must use the RS512 signing algorithm.  The JWT must contain the following headers:  - **alg**: The RS512 algorithm value, e.g., &#39;RS512&#39;. - **kid**: Set to the guid of the verification key that has been registered for the Bank  The JWT must contain the following claims:  - **iss**: Set to http://api.cybrid.app/banks/{bank_guid} - **aud**: Set to http://api.cybrid.app - **sub**: Set to http://api.cybrid.app/customers/{customer_guid} - **iat**: Set to the time at which the JWT was issued - **exp**: Set to the time after which the JWT expires - **jti**: Set to a unique identifier for the JWT  Example code (python) for generating an Attestation Identity Record JWT token:  &#x60;&#x60;&#x60;python # Assumes an RSA private key has been generated (&#x60;private_key&#x60;), a Verification Key has been created and a &#x60;verification_key_guid&#x60; is available. # # &#x60;customer_guid&#x60; should be set to the guid assigned to a Customer that has been created. # &#x60;bank_guid&#x60; should be set to the guid of your bank #  import uuid  from datetime import datetime, timezone, timedelta from jwcrypto import jwt, jwk from cryptography.hazmat.primitives import serialization from cryptography.hazmat.primitives.serialization import load_pem_private_key  algorithm &#x3D; &#39;RS512&#39; issued_at &#x3D; datetime.now(timezone.utc) expired_at &#x3D; issued_at + timedelta(days&#x3D;365)  with open(\&quot;verification_key.pem\&quot;, &#39;rb&#39;) as pem_in:   pem_lines &#x3D; pem_in.read()  private_key &#x3D; load_pem_private_key(pem_lines, None)  ### DISCLAIMER:- Since NO ENCRYPTION is used in the key storage/formatting. Please DO NOT use this code in production environment. signing_key &#x3D; jwk.JWK.from_pem(     private_key.private_bytes(         encoding&#x3D;serialization.Encoding.PEM,         format&#x3D;serialization.PrivateFormat.PKCS8,         encryption_algorithm&#x3D;serialization.NoEncryption()     ) ) signing_key.update({\&quot;kid\&quot;: verification_key_guid})  attestation_jwt &#x3D; jwt.JWT(     header&#x3D;{         \&quot;alg\&quot;: algorithm,         \&quot;kid\&quot;: verification_key_guid     },     claims&#x3D;{         \&quot;iss\&quot;: f\&quot;http://api.cybrid.app/banks/{bank_guid}\&quot;,         \&quot;aud\&quot;: \&quot;http://api.cybrid.app\&quot;,         \&quot;sub\&quot;: f\&quot;http://api.cybrid.app/customers/{customer_guid}\&quot;,         \&quot;iat\&quot;: int(issued_at.timestamp()),         \&quot;exp\&quot;: int(expired_at.timestamp()),         \&quot;jti\&quot;: str(uuid.uuid4())     },     key&#x3D;signing_key,     algs&#x3D;[algorithm] ) attestation_jwt.make_signed_token(signing_key)  token &#x3D; attestation_jwt.serialize(compact&#x3D;True) print(\&quot;Token is : \&quot;, token) &#x60;&#x60;&#x60;  ## Attestation State  | State | Description | |-------|-------------| | storing | The Platform is storing the attestation in our private store | | pending | The Platform is verifying the attestation&#39;s JWT | | verified | The Platform has verified the attestation and the customer is able to transact | | failed | The Platform was not able to verify the attestation and the customer is not able to transact |    Required scope: **customers:write**
     */
    @Test
    public void createIdentityRecordTest()  {
        PostIdentityRecordBankModel postIdentityRecordBankModel = null;
        IdentityRecordBankModel response = api.createIdentityRecord(postIdentityRecordBankModel).block();

        // TODO: test validations
    }
    
    /**
     * Get Identity Record
     *
     * Retrieves an identity record.  Required scope: **customers:read**
     */
    @Test
    public void getIdentityRecordTest()  {
        String identityRecordGuid = null;
        IdentityRecordBankModel response = api.getIdentityRecord(identityRecordGuid).block();

        // TODO: test validations
    }
    
    /**
     * List Identity Records
     *
     * Retrieves a listing of identity records for a bank.  Required scope: **customers:read**
     */
    @Test
    public void listIdentityRecordsTest()  {
        String customerGuid = null;
        java.math.BigInteger page = null;
        java.math.BigInteger perPage = null;
        IdentityRecordListBankModel response = api.listIdentityRecords(customerGuid, page, perPage).block();

        // TODO: test validations
    }
    
}

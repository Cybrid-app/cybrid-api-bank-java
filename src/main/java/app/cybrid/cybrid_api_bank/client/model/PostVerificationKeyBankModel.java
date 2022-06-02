/*
 * Cybrid Bank API
 * # Welcome  Welcome to the Cybrid platform; enabling turnkey crypto banking services!  In these documents, you will find information on the operations provided by our platform, as well as details on how our REST API operates more generally.  Our complete set of APIs allows you to manage all your resources: your Organization, your banks and your identities. The complete set of APIs can be found on the following pages:  | API                                                            | Description                  | |----------------------------------------------------------------|------------------------------| | [Organization API](https://organization.demo.cybrid.app/api/schema/swagger-ui) | APIs to manage organizations | | [Bank API](https://bank.demo.cybrid.app/api/schema/swagger-ui)                 | APIs to manage banks         | | [Identities API](https://id.demo.cybrid.app/api/schema/swagger-ui)                     | APIs to manage identities    |  When you're ready, [request access](https://www.cybrid.xyz/access) to your Dashboard to view and administer your Organization. Once you've logged in, you can begin creating Banks, either for sandbox or production usage, and start enabling your customers to leverage DeFi and web3 with confidence.  If you have any questions, please contact [Support](mailto:support@cybrid.app) at any time so that we can help.  ## Authentication  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create Organization and Bank tokens can be generated via your Dashboard ([request access](https://www.cybrid.xyz/access)).  An Organization Token applies broadly to the whole Organization and all of its Banks, whereas, a Bank Token is specific to an individual Bank.  Both Organization and Bank tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique Client ID and Secret that allows for machine-to-machine authentication.  **Never share your Client ID or Secret publicly or in your source code repository**  Your Client ID and Secret can be exchanged for a time-limited Bearer Token by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document:  ``` curl -X POST https://id.demo.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"<Your requested scopes -- space separated>\"   }' -H \"Content-Type: application/json\" ```  ## Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization or a Bank token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource      | Read scope         | Write scope          | Execute scope     | Token Type         | |---------------|--------------------|----------------------|-------------------|--------------------| | Organizations | organizations:read | organizations:write  |                   | Organization/ Bank | | Banks         | banks:read         | banks:write          | banks:execute     | Organization/ Bank | | Customers     | customers:read     | customers:write      | customers:execute | Bank               | | Assets        | prices:read        |                      |                   | Bank               | | Accounts      | accounts:read      |                      | accounts:execute  | Bank               | | Prices        | prices:read        |                      |                   | Bank               | | Symbols       | prices:read        |                      |                   | Bank               | | Quotes        | quotes:read        |                      | quotes:execute    | Bank               | | Trades        | trades:read        |                      | trades:execute    | Bank               |  ## Organizations  An Organization is meant to model the organization partnering with Cybrid to use our platform.  An Organization does not directly interact with customers. Instead, an Organization has one or more banks, which encompass the financial service offerings of the platform.  ## Banks  A Bank is owned by an Organization and can be thought of as an environment or container for Customers and product offerings. An example of a Bank would be your customer facing banking website, or an internal staging environment for testing and integration.  An Organization can have multiple banks, in sandbox or production environments. A sandbox Bank will be backed by stubbed data and process flows. For instance, identity record and funding source processes will be simulated rather than performed.  ## Customers  Customers represent your banking users on the platform. At present, we offer support for Individuals as Customers.  Customers must be verified in our system before they can play any part on the platform. See the Identity Records section for more details on how a customer can be verified.  Customers must also have an account to be able to transact. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.18.4
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * PostVerificationKeyBankModel
 */
@JsonPropertyOrder({
  PostVerificationKeyBankModel.JSON_PROPERTY_TYPE,
  PostVerificationKeyBankModel.JSON_PROPERTY_ALGORITHM,
  PostVerificationKeyBankModel.JSON_PROPERTY_PUBLIC_KEY,
  PostVerificationKeyBankModel.JSON_PROPERTY_NONCE,
  PostVerificationKeyBankModel.JSON_PROPERTY_SIGNATURE
})
@JsonTypeName("PostVerificationKey")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-02T14:20:29.832201Z[Etc/UTC]")
public class PostVerificationKeyBankModel {
  /**
   * The verification key&#39;s type.
   */
  public enum TypeEnum {
    ATTESTATION("attestation");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  /**
   * The verification key&#39;s algorithm.
   */
  public enum AlgorithmEnum {
    RS512("RS512");

    private String value;

    AlgorithmEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AlgorithmEnum fromValue(String value) {
      for (AlgorithmEnum b : AlgorithmEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ALGORITHM = "algorithm";
  private AlgorithmEnum algorithm;

  public static final String JSON_PROPERTY_PUBLIC_KEY = "public_key";
  private String publicKey;

  public static final String JSON_PROPERTY_NONCE = "nonce";
  private String nonce;

  public static final String JSON_PROPERTY_SIGNATURE = "signature";
  private String signature;

  public PostVerificationKeyBankModel() { 
  }

  public PostVerificationKeyBankModel type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * The verification key&#39;s type.
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The verification key's type.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TypeEnum getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(TypeEnum type) {
    this.type = type;
  }


  public PostVerificationKeyBankModel algorithm(AlgorithmEnum algorithm) {
    
    this.algorithm = algorithm;
    return this;
  }

   /**
   * The verification key&#39;s algorithm.
   * @return algorithm
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The verification key's algorithm.")
  @JsonProperty(JSON_PROPERTY_ALGORITHM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AlgorithmEnum getAlgorithm() {
    return algorithm;
  }


  @JsonProperty(JSON_PROPERTY_ALGORITHM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAlgorithm(AlgorithmEnum algorithm) {
    this.algorithm = algorithm;
  }


  public PostVerificationKeyBankModel publicKey(String publicKey) {
    
    this.publicKey = publicKey;
    return this;
  }

   /**
   * DER encoded public key in Base64 format.
   * @return publicKey
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "DER encoded public key in Base64 format.")
  @JsonProperty(JSON_PROPERTY_PUBLIC_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPublicKey() {
    return publicKey;
  }


  @JsonProperty(JSON_PROPERTY_PUBLIC_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }


  public PostVerificationKeyBankModel nonce(String nonce) {
    
    this.nonce = nonce;
    return this;
  }

   /**
   * Value signed in the **signature** field.
   * @return nonce
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Value signed in the **signature** field.")
  @JsonProperty(JSON_PROPERTY_NONCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNonce() {
    return nonce;
  }


  @JsonProperty(JSON_PROPERTY_NONCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNonce(String nonce) {
    this.nonce = nonce;
  }


  public PostVerificationKeyBankModel signature(String signature) {
    
    this.signature = signature;
    return this;
  }

   /**
   * Signature on **nonce** using PKCS1v15 padding and the SHA512 hashing algorithm in Base64 format.
   * @return signature
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Signature on **nonce** using PKCS1v15 padding and the SHA512 hashing algorithm in Base64 format.")
  @JsonProperty(JSON_PROPERTY_SIGNATURE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSignature() {
    return signature;
  }


  @JsonProperty(JSON_PROPERTY_SIGNATURE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSignature(String signature) {
    this.signature = signature;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostVerificationKeyBankModel postVerificationKey = (PostVerificationKeyBankModel) o;
    return Objects.equals(this.type, postVerificationKey.type) &&
        Objects.equals(this.algorithm, postVerificationKey.algorithm) &&
        Objects.equals(this.publicKey, postVerificationKey.publicKey) &&
        Objects.equals(this.nonce, postVerificationKey.nonce) &&
        Objects.equals(this.signature, postVerificationKey.signature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, algorithm, publicKey, nonce, signature);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostVerificationKeyBankModel {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    algorithm: ").append(toIndentedString(algorithm)).append("\n");
    sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
    sb.append("    nonce: ").append(toIndentedString(nonce)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


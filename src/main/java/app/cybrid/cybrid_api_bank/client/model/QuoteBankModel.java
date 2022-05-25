/*
 * Cybrid Bank API
 * # Welcome  Welcome to the Cybrid platform; enabling turnkey crypto banking services!  In these documents, you will find information on the operations provided by our platform, as well as details on how our REST API operates more generally.  Our complete set of APIs allows you to manage all your resources: your Organization, your banks and your identities. The complete set of APIs can be found on the following pages:  | API                                                            | Description                  | |----------------------------------------------------------------|------------------------------| | [Organization API](https://organization.demo.cybrid.app/api/schema/swagger-ui) | APIs to manage organizations | | [Bank API](https://bank.demo.cybrid.app/api/schema/swagger-ui)                 | APIs to manage banks         | | [Identities API](https://id.demo.cybrid.app/api/schema/swagger-ui)                     | APIs to manage identities    |  When you're ready, [request access](https://www.cybrid.xyz/access) to your Dashboard to view and administer your Organization. Once you've logged in, you can begin creating Banks, either for sandbox or production usage, and start enabling your customers to leverage DeFi and web3 with confidence.  If you have any questions, please contact [Support](mailto:support@cybrid.app) at any time so that we can help.  ## Authentication  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create Organization and Bank tokens can be generated via your Dashboard ([request access](https://www.cybrid.xyz/access)).  An Organization Token applies broadly to the whole Organization and all of its Banks, whereas, a Bank Token is specific to an individual Bank.  Both Organization and Bank tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique Client ID and Secret that allows for machine-to-machine authentication.  **Never share your Client ID or Secret publicly or in your source code repository**  Your Client ID and Secret can be exchanged for a time-limited Bearer Token by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document:  ``` curl -X POST https://id.demo.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"<Your requested scopes -- space separated>\"   }' -H \"Content-Type: application/json\" ```  ## Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization or a Bank token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource      | Read scope         | Write scope          | Execute scope     | Token Type         | |---------------|--------------------|----------------------|-------------------|--------------------| | Organizations | organizations:read | organizations:write  |                   | Organization/ Bank | | Banks         | banks:read         | banks:write          | banks:execute     | Organization/ Bank | | Customers     | customers:read     | customers:write      | customers:execute | Bank               | | Assets        | prices:read        |                      |                   | Bank               | | Accounts      | accounts:read      |                      | accounts:execute  | Bank               | | Prices        | prices:read        |                      |                   | Bank               | | Symbols       | prices:read        |                      |                   | Bank               | | Quotes        | quotes:read        |                      | quotes:execute    | Bank               | | Trades        | trades:read        |                      | trades:execute    | Bank               |  ## Organizations  An Organization is meant to model the organization partnering with Cybrid to use our platform.  An Organization does not directly interact with customers. Instead, an Organization has one or more banks, which encompass the financial service offerings of the platform.  ## Banks  A Bank is owned by an Organization and can be thought of as an environment or container for Customers and product offerings. An example of a Bank would be your customer facing banking website, or an internal staging environment for testing and integration.  An Organization can have multiple banks, in sandbox or production environments. A sandbox Bank will be backed by stubbed data and process flows. For instance, identity record and funding source processes will be simulated rather than performed.  ## Customers  Customers represent your banking users on the platform. At present, we offer support for Individuals as Customers.  Customers must be verified in our system before they can play any part on the platform. See the Identity Records section for more details on how a customer can be verified.  Customers must also have an account to be able to transact. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.14.10
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
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * QuoteBankModel
 */
@JsonPropertyOrder({
  QuoteBankModel.JSON_PROPERTY_GUID,
  QuoteBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  QuoteBankModel.JSON_PROPERTY_SYMBOL,
  QuoteBankModel.JSON_PROPERTY_SIDE,
  QuoteBankModel.JSON_PROPERTY_RECEIVE_AMOUNT,
  QuoteBankModel.JSON_PROPERTY_DELIVER_AMOUNT,
  QuoteBankModel.JSON_PROPERTY_FEE,
  QuoteBankModel.JSON_PROPERTY_ISSUED_AT,
  QuoteBankModel.JSON_PROPERTY_EXPIRES_AT
})
@JsonTypeName("Quote")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-25T10:30:14.498022Z[Etc/UTC]")
public class QuoteBankModel {
  public static final String JSON_PROPERTY_GUID = "guid";
  private String guid;

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private String customerGuid;

  public static final String JSON_PROPERTY_SYMBOL = "symbol";
  private String symbol;

  /**
   * The direction of the quote: either &#39;buy&#39; or &#39;sell&#39;.
   */
  public enum SideEnum {
    BUY("buy"),
    
    SELL("sell");

    private String value;

    SideEnum(String value) {
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
    public static SideEnum fromValue(String value) {
      for (SideEnum b : SideEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_SIDE = "side";
  private SideEnum side;

  public static final String JSON_PROPERTY_RECEIVE_AMOUNT = "receive_amount";
  private java.math.BigInteger receiveAmount;

  public static final String JSON_PROPERTY_DELIVER_AMOUNT = "deliver_amount";
  private java.math.BigInteger deliverAmount;

  public static final String JSON_PROPERTY_FEE = "fee";
  private java.math.BigInteger fee;

  public static final String JSON_PROPERTY_ISSUED_AT = "issued_at";
  private OffsetDateTime issuedAt;

  public static final String JSON_PROPERTY_EXPIRES_AT = "expires_at";
  private OffsetDateTime expiresAt;

  public QuoteBankModel() { 
  }

  public QuoteBankModel guid(String guid) {
    
    this.guid = guid;
    return this;
  }

   /**
   * Auto-generated unique identifier for the quote.
   * @return guid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Auto-generated unique identifier for the quote.")
  @JsonProperty(JSON_PROPERTY_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGuid() {
    return guid;
  }


  @JsonProperty(JSON_PROPERTY_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGuid(String guid) {
    this.guid = guid;
  }


  public QuoteBankModel customerGuid(String customerGuid) {
    
    this.customerGuid = customerGuid;
    return this;
  }

   /**
   * The unique identifier for the customer.
   * @return customerGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identifier for the customer.")
  @JsonProperty(JSON_PROPERTY_CUSTOMER_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCustomerGuid() {
    return customerGuid;
  }


  @JsonProperty(JSON_PROPERTY_CUSTOMER_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustomerGuid(String customerGuid) {
    this.customerGuid = customerGuid;
  }


  public QuoteBankModel symbol(String symbol) {
    
    this.symbol = symbol;
    return this;
  }

   /**
   * Symbol the quote is being requested for. Format is \&quot;asset-counter_asset\&quot; in uppercase.
   * @return symbol
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Symbol the quote is being requested for. Format is \"asset-counter_asset\" in uppercase.")
  @JsonProperty(JSON_PROPERTY_SYMBOL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSymbol() {
    return symbol;
  }


  @JsonProperty(JSON_PROPERTY_SYMBOL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }


  public QuoteBankModel side(SideEnum side) {
    
    this.side = side;
    return this;
  }

   /**
   * The direction of the quote: either &#39;buy&#39; or &#39;sell&#39;.
   * @return side
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The direction of the quote: either 'buy' or 'sell'.")
  @JsonProperty(JSON_PROPERTY_SIDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SideEnum getSide() {
    return side;
  }


  @JsonProperty(JSON_PROPERTY_SIDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSide(SideEnum side) {
    this.side = side;
  }


  public QuoteBankModel receiveAmount(java.math.BigInteger receiveAmount) {
    
    this.receiveAmount = receiveAmount;
    return this;
  }

   /**
   * The amount to be received in base units of the currency: currency is \&quot;asset\&quot; for buy and \&quot;counter_asset\&quot; for sell.
   * @return receiveAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount to be received in base units of the currency: currency is \"asset\" for buy and \"counter_asset\" for sell.")
  @JsonProperty(JSON_PROPERTY_RECEIVE_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public java.math.BigInteger getReceiveAmount() {
    return receiveAmount;
  }


  @JsonProperty(JSON_PROPERTY_RECEIVE_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReceiveAmount(java.math.BigInteger receiveAmount) {
    this.receiveAmount = receiveAmount;
  }


  public QuoteBankModel deliverAmount(java.math.BigInteger deliverAmount) {
    
    this.deliverAmount = deliverAmount;
    return this;
  }

   /**
   * The amount to be delivered in base units of the currency: currency is \&quot;counter_asset\&quot; for buy and \&quot;asset\&quot; for sell.
   * @return deliverAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount to be delivered in base units of the currency: currency is \"counter_asset\" for buy and \"asset\" for sell.")
  @JsonProperty(JSON_PROPERTY_DELIVER_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public java.math.BigInteger getDeliverAmount() {
    return deliverAmount;
  }


  @JsonProperty(JSON_PROPERTY_DELIVER_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeliverAmount(java.math.BigInteger deliverAmount) {
    this.deliverAmount = deliverAmount;
  }


  public QuoteBankModel fee(java.math.BigInteger fee) {
    
    this.fee = fee;
    return this;
  }

   /**
   * The fee associated with the trade. Denominated in \&quot;counter_asset\&quot; base units
   * @return fee
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The fee associated with the trade. Denominated in \"counter_asset\" base units")
  @JsonProperty(JSON_PROPERTY_FEE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public java.math.BigInteger getFee() {
    return fee;
  }


  @JsonProperty(JSON_PROPERTY_FEE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFee(java.math.BigInteger fee) {
    this.fee = fee;
  }


  public QuoteBankModel issuedAt(OffsetDateTime issuedAt) {
    
    this.issuedAt = issuedAt;
    return this;
  }

   /**
   * ISO8601 datetime the quote was created at.
   * @return issuedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the quote was created at.")
  @JsonProperty(JSON_PROPERTY_ISSUED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getIssuedAt() {
    return issuedAt;
  }


  @JsonProperty(JSON_PROPERTY_ISSUED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIssuedAt(OffsetDateTime issuedAt) {
    this.issuedAt = issuedAt;
  }


  public QuoteBankModel expiresAt(OffsetDateTime expiresAt) {
    
    this.expiresAt = expiresAt;
    return this;
  }

   /**
   * ISO8601 datetime the quote is expiring at.
   * @return expiresAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the quote is expiring at.")
  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getExpiresAt() {
    return expiresAt;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExpiresAt(OffsetDateTime expiresAt) {
    this.expiresAt = expiresAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuoteBankModel quote = (QuoteBankModel) o;
    return Objects.equals(this.guid, quote.guid) &&
        Objects.equals(this.customerGuid, quote.customerGuid) &&
        Objects.equals(this.symbol, quote.symbol) &&
        Objects.equals(this.side, quote.side) &&
        Objects.equals(this.receiveAmount, quote.receiveAmount) &&
        Objects.equals(this.deliverAmount, quote.deliverAmount) &&
        Objects.equals(this.fee, quote.fee) &&
        Objects.equals(this.issuedAt, quote.issuedAt) &&
        Objects.equals(this.expiresAt, quote.expiresAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(guid, customerGuid, symbol, side, receiveAmount, deliverAmount, fee, issuedAt, expiresAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuoteBankModel {\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
    sb.append("    side: ").append(toIndentedString(side)).append("\n");
    sb.append("    receiveAmount: ").append(toIndentedString(receiveAmount)).append("\n");
    sb.append("    deliverAmount: ").append(toIndentedString(deliverAmount)).append("\n");
    sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
    sb.append("    issuedAt: ").append(toIndentedString(issuedAt)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
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


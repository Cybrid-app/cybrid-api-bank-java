/*
 * Cybrid Bank API
 * # Welcome  Welcome to the Cybrid platform; enabling turnkey crypto banking services!  In these documents, you will find information on the operations provided by our platform, as well as details on how our REST API operates more generally.  Our complete set of APIs allows you to manage all your resources: your Organization, your banks and your identities. The complete set of APIs can be found on the following pages:  | API                                                            | Description                  | |----------------------------------------------------------------|------------------------------| | [Organization API](https://organization.demo.cybrid.app/api/schema/swagger-ui) | APIs to manage organizations | | [Bank API](https://bank.demo.cybrid.app/api/schema/swagger-ui)                 | APIs to manage banks         | | [Identities API](https://id.demo.cybrid.app/api/schema/swagger-ui)                     | APIs to manage identities    |  When you're ready, [request access](https://www.cybrid.xyz/access) to your Dashboard to view and administer your Organization. Once you've logged in, you can begin creating Banks, either for sandbox or production usage, and start enabling your customers to leverage DeFi and web3 with confidence.  If you have any questions, please contact [Support](mailto:support@cybrid.app) at any time so that we can help.  ## Authentication  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create Organization and Bank tokens can be generated via your Dashboard ([request access](https://www.cybrid.xyz/access)).  An Organization Token applies broadly to the whole Organization and all of its Banks, whereas, a Bank Token is specific to an individual Bank.  Both Organization and Bank tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique Client ID and Secret that allows for machine-to-machine authentication.  **Never share your Client ID or Secret publicly or in your source code repository**  Your Client ID and Secret can be exchanged for a time-limited Bearer Token by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document:  ``` curl -X POST https://id.demo.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"<Your requested scopes -- space separated>\"   }' -H \"Content-Type: application/json\" ```  ## Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization or a Bank token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource      | Read scope         | Write scope          | Execute scope     | Token Type         | |---------------|--------------------|----------------------|-------------------|--------------------| | Organizations | organizations:read | organizations:write  |                   | Organization/ Bank | | Banks         | banks:read         | banks:write          | banks:execute     | Organization/ Bank | | Customers     | customers:read     | customers:write      | customers:execute | Bank               | | Assets        | prices:read        |                      |                   | Bank               | | Accounts      | accounts:read      |                      | accounts:execute  | Bank               | | Prices        | prices:read        |                      |                   | Bank               | | Symbols       | prices:read        |                      |                   | Bank               | | Quotes        | quotes:read        |                      | quotes:execute    | Bank               | | Trades        | trades:read        |                      | trades:execute    | Bank               |  ## Organizations  An Organization is meant to model the organization partnering with Cybrid to use our platform.  An Organization does not directly interact with customers. Instead, an Organization has one or more banks, which encompass the financial service offerings of the platform.  ## Banks  A Bank is owned by an Organization and can be thought of as an environment or container for Customers and product offerings. An example of a Bank would be your customer facing banking website, or an internal staging environment for testing and integration.  An Organization can have multiple banks, in sandbox or production environments. A sandbox Bank will be backed by stubbed data and process flows. For instance, identity record and funding source processes will be simulated rather than performed.  ## Customers  Customers represent your banking users on the platform. At present, we offer support for Individuals as Customers.  Customers must be verified in our system before they can play any part on the platform. See the Identity Records section for more details on how a customer can be verified.  Customers must also have an account to be able to transact. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.18.12
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
 * TradeBankModel
 */
@JsonPropertyOrder({
  TradeBankModel.JSON_PROPERTY_GUID,
  TradeBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  TradeBankModel.JSON_PROPERTY_QUOTE_GUID,
  TradeBankModel.JSON_PROPERTY_SYMBOL,
  TradeBankModel.JSON_PROPERTY_SIDE,
  TradeBankModel.JSON_PROPERTY_STATE,
  TradeBankModel.JSON_PROPERTY_RECEIVE_AMOUNT,
  TradeBankModel.JSON_PROPERTY_DELIVER_AMOUNT,
  TradeBankModel.JSON_PROPERTY_FEE,
  TradeBankModel.JSON_PROPERTY_CREATED_AT
})
@JsonTypeName("Trade")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-06T12:08:22.263947Z[Etc/UTC]")
public class TradeBankModel {
  public static final String JSON_PROPERTY_GUID = "guid";
  private String guid;

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private String customerGuid;

  public static final String JSON_PROPERTY_QUOTE_GUID = "quote_guid";
  private String quoteGuid;

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

  /**
   * The trade&#39;s state
   */
  public enum StateEnum {
    STORING("storing"),
    
    INITIATING("initiating"),
    
    PENDING("pending"),
    
    COMPLETED("completed"),
    
    FAILED("failed");

    private String value;

    StateEnum(String value) {
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
    public static StateEnum fromValue(String value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_STATE = "state";
  private StateEnum state;

  public static final String JSON_PROPERTY_RECEIVE_AMOUNT = "receive_amount";
  private java.math.BigInteger receiveAmount;

  public static final String JSON_PROPERTY_DELIVER_AMOUNT = "deliver_amount";
  private java.math.BigInteger deliverAmount;

  public static final String JSON_PROPERTY_FEE = "fee";
  private java.math.BigInteger fee;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";
  private OffsetDateTime createdAt;

  public TradeBankModel() { 
  }

  public TradeBankModel guid(String guid) {
    
    this.guid = guid;
    return this;
  }

   /**
   * Auto-generated unique identifier for the trade.
   * @return guid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Auto-generated unique identifier for the trade.")
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


  public TradeBankModel customerGuid(String customerGuid) {
    
    this.customerGuid = customerGuid;
    return this;
  }

   /**
   * The associated customer&#39;s identifier.
   * @return customerGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The associated customer's identifier.")
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


  public TradeBankModel quoteGuid(String quoteGuid) {
    
    this.quoteGuid = quoteGuid;
    return this;
  }

   /**
   * The associated quote&#39;s identifier.
   * @return quoteGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The associated quote's identifier.")
  @JsonProperty(JSON_PROPERTY_QUOTE_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getQuoteGuid() {
    return quoteGuid;
  }


  @JsonProperty(JSON_PROPERTY_QUOTE_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQuoteGuid(String quoteGuid) {
    this.quoteGuid = quoteGuid;
  }


  public TradeBankModel symbol(String symbol) {
    
    this.symbol = symbol;
    return this;
  }

   /**
   * The trade symbol the pricing is related to. Format is asset-counter_asset, e.g., BTC-USD.
   * @return symbol
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The trade symbol the pricing is related to. Format is asset-counter_asset, e.g., BTC-USD.")
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


  public TradeBankModel side(SideEnum side) {
    
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


  public TradeBankModel state(StateEnum state) {
    
    this.state = state;
    return this;
  }

   /**
   * The trade&#39;s state
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The trade's state")
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public StateEnum getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(StateEnum state) {
    this.state = state;
  }


  public TradeBankModel receiveAmount(java.math.BigInteger receiveAmount) {
    
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


  public TradeBankModel deliverAmount(java.math.BigInteger deliverAmount) {
    
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


  public TradeBankModel fee(java.math.BigInteger fee) {
    
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


  public TradeBankModel createdAt(OffsetDateTime createdAt) {
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * ISO8601 datetime the bank was created at.
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the bank was created at.")
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }


  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradeBankModel trade = (TradeBankModel) o;
    return Objects.equals(this.guid, trade.guid) &&
        Objects.equals(this.customerGuid, trade.customerGuid) &&
        Objects.equals(this.quoteGuid, trade.quoteGuid) &&
        Objects.equals(this.symbol, trade.symbol) &&
        Objects.equals(this.side, trade.side) &&
        Objects.equals(this.state, trade.state) &&
        Objects.equals(this.receiveAmount, trade.receiveAmount) &&
        Objects.equals(this.deliverAmount, trade.deliverAmount) &&
        Objects.equals(this.fee, trade.fee) &&
        Objects.equals(this.createdAt, trade.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(guid, customerGuid, quoteGuid, symbol, side, state, receiveAmount, deliverAmount, fee, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeBankModel {\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    quoteGuid: ").append(toIndentedString(quoteGuid)).append("\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
    sb.append("    side: ").append(toIndentedString(side)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    receiveAmount: ").append(toIndentedString(receiveAmount)).append("\n");
    sb.append("    deliverAmount: ").append(toIndentedString(deliverAmount)).append("\n");
    sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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


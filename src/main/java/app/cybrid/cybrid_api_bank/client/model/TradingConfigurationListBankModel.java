/*
 * Cybrid Bank API
 * # Welcome  Welcome to the Cybrid platform; enabling turnkey crypto banking services!  In these documents, you will find information on the operations provided by our platform, as well as details on how our REST API operates more generally.  Our complete set of APIs allows you to manage all your resources: your Organization, your banks and your identities. The complete set of APIs can be found on the following pages:  | API                                                            | Description                  | |----------------------------------------------------------------|------------------------------| | [Organization API](https://organization.demo.cybrid.app/api/schema/swagger-ui) | APIs to manage organizations | | [Bank API](https://bank.demo.cybrid.app/api/schema/swagger-ui)                 | APIs to manage banks         | | [Identities API](https://id.demo.cybrid.app/api/schema/swagger-ui)                     | APIs to manage identities    |  When you're ready, [request access](https://www.cybrid.xyz/access) to your Dashboard to view and administer your Organization. Once you've logged in, you can begin creating Banks, either for sandbox or production usage, and start enabling your customers to leverage DeFi and web3 with confidence.  If you have any questions, please contact [Support](mailto:support@cybrid.app) at any time so that we can help.  ## Authentication  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create Organization and Bank tokens can be generated via your Dashboard ([request access](https://www.cybrid.xyz/access)).  An Organization Token applies broadly to the whole Organization and all of its Banks, whereas, a Bank Token is specific to an individual Bank.  Both Organization and Bank tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique Client ID and Secret that allows for machine-to-machine authentication.  **Never share your Client ID or Secret publicly or in your source code repository**  Your Client ID and Secret can be exchanged for a time-limited Bearer Token by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document:  ``` curl -X POST https://id.demo.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"<Your requested scopes -- space separated>\"   }' -H \"Content-Type: application/json\" ```  ## Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization or a Bank token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource      | Read scope         | Write scope          | Execute scope     | Token Type         | |---------------|--------------------|----------------------|-------------------|--------------------| | Organizations | organizations:read | organizations:write  |                   | Organization/ Bank | | Banks         | banks:read         | banks:write          | banks:execute     | Organization/ Bank | | Customers     | customers:read     | customers:write      | customers:execute | Bank               | | Assets        | prices:read        |                      |                   | Bank               | | Accounts      | accounts:read      |                      | accounts:execute  | Bank               | | Prices        | prices:read        |                      |                   | Bank               | | Symbols       | prices:read        |                      |                   | Bank               | | Quotes        | quotes:read        |                      | quotes:execute    | Bank               | | Trades        | trades:read        |                      | trades:execute    | Bank               |  ## Organizations  An Organization is meant to model the organization partnering with Cybrid to use our platform.  An Organization does not directly interact with customers. Instead, an Organization has one or more banks, which encompass the financial service offerings of the platform.  ## Banks  A Bank is owned by an Organization and can be thought of as an environment or container for Customers and product offerings. An example of a Bank would be your customer facing banking website, or an internal staging environment for testing and integration.  An Organization can have multiple banks, in sandbox or production environments. A sandbox Bank will be backed by stubbed data and process flows. For instance, identity record and funding source processes will be simulated rather than performed.  ## Customers  Customers represent your banking users on the platform. At present, we offer support for Individuals as Customers.  Customers must be verified in our system before they can play any part on the platform. See the Identity Records section for more details on how a customer can be verified.  Customers must also have an account to be able to transact. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.6.1
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.model;

import java.util.Objects;
import java.util.Arrays;
import app.cybrid.cybrid_api_bank.client.model.TradingConfigurationBankModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * TradingConfigurationListBankModel
 */
@JsonPropertyOrder({
  TradingConfigurationListBankModel.JSON_PROPERTY_TOTAL,
  TradingConfigurationListBankModel.JSON_PROPERTY_PAGE,
  TradingConfigurationListBankModel.JSON_PROPERTY_PER_PAGE,
  TradingConfigurationListBankModel.JSON_PROPERTY_OBJECTS
})
@JsonTypeName("TradingConfigurationList")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-07T02:57:51.414054Z[Etc/UTC]")
public class TradingConfigurationListBankModel {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private java.math.BigInteger total;

  public static final String JSON_PROPERTY_PAGE = "page";
  private java.math.BigInteger page;

  public static final String JSON_PROPERTY_PER_PAGE = "per_page";
  private java.math.BigInteger perPage;

  public static final String JSON_PROPERTY_OBJECTS = "objects";
  private List<TradingConfigurationBankModel> objects = null;

  public TradingConfigurationListBankModel() { 
  }

  public TradingConfigurationListBankModel total(java.math.BigInteger total) {
    
    this.total = total;
    return this;
  }

   /**
   * The total number of records available.
   * minimum: 0
   * @return total
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The total number of records available.")
  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public java.math.BigInteger getTotal() {
    return total;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotal(java.math.BigInteger total) {
    this.total = total;
  }


  public TradingConfigurationListBankModel page(java.math.BigInteger page) {
    
    this.page = page;
    return this;
  }

   /**
   * The page index to retrieve.
   * minimum: 0
   * @return page
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The page index to retrieve.")
  @JsonProperty(JSON_PROPERTY_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public java.math.BigInteger getPage() {
    return page;
  }


  @JsonProperty(JSON_PROPERTY_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPage(java.math.BigInteger page) {
    this.page = page;
  }


  public TradingConfigurationListBankModel perPage(java.math.BigInteger perPage) {
    
    this.perPage = perPage;
    return this;
  }

   /**
   * The number of entities per page to return.
   * minimum: 0
   * @return perPage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of entities per page to return.")
  @JsonProperty(JSON_PROPERTY_PER_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public java.math.BigInteger getPerPage() {
    return perPage;
  }


  @JsonProperty(JSON_PROPERTY_PER_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPerPage(java.math.BigInteger perPage) {
    this.perPage = perPage;
  }


  public TradingConfigurationListBankModel objects(List<TradingConfigurationBankModel> objects) {
    
    this.objects = objects;
    return this;
  }

  public TradingConfigurationListBankModel addObjectsItem(TradingConfigurationBankModel objectsItem) {
    if (this.objects == null) {
      this.objects = new ArrayList<>();
    }
    this.objects.add(objectsItem);
    return this;
  }

   /**
   * Get objects
   * @return objects
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_OBJECTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<TradingConfigurationBankModel> getObjects() {
    return objects;
  }


  @JsonProperty(JSON_PROPERTY_OBJECTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setObjects(List<TradingConfigurationBankModel> objects) {
    this.objects = objects;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradingConfigurationListBankModel tradingConfigurationList = (TradingConfigurationListBankModel) o;
    return Objects.equals(this.total, tradingConfigurationList.total) &&
        Objects.equals(this.page, tradingConfigurationList.page) &&
        Objects.equals(this.perPage, tradingConfigurationList.perPage) &&
        Objects.equals(this.objects, tradingConfigurationList.objects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, page, perPage, objects);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradingConfigurationListBankModel {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    perPage: ").append(toIndentedString(perPage)).append("\n");
    sb.append("    objects: ").append(toIndentedString(objects)).append("\n");
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

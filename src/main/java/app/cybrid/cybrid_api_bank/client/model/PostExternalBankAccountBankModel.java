/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.sandbox.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Understanding the Platform](https://kb.cybrid.xyz/understanding-the-platform) 2. [Getting Started in the Cybrid Sandbox](https://kb.cybrid.xyz/getting-started-guide) 3. [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading) 4. [Running the Web Demo App](https://kb.cybrid.xyz/locally-running-the-web-demo-app) (or, alternatively, [Testing with Hosted Web Demo App](https://kb.cybrid.xyz/testing-with-hosted-web-demo-app))  In [Getting Started in the Cybrid Sandbox](https://kb.cybrid.xyz/getting-started-guide), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  If you've already run through the first two guides, you can follow the [Running the Web Demo App](https://kb.cybrid.xyz/locally-running-the-web-demo-app) guide to test our web SDK with your sandbox `bank` and `customer`.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.sandbox.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.sandbox.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.sandbox.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.sandbox.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.sandbox.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.sandbox.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.sandbox.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute customers:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read rewards:execute rewards:read external_bank_accounts:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:execute customers:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:execute external_bank_accounts:read external_wallets:read workflows:read deposit_addresses:read' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  |                                                            |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Reward                | rewards:read (Bank, Customer)                              |                                               | rewards:execute (Bank)                           | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               |  ## Available Endpoints  The available APIs for the [Identity](https://id.sandbox.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.sandbox.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.sandbox.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create an organization user                                                                       | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Reward               | /api/rewards                   | Create a new reward (automates quote/trade for simplicity)                                        | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.92.1
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
 * PostExternalBankAccountBankModel
 */
@JsonPropertyOrder({
  PostExternalBankAccountBankModel.JSON_PROPERTY_NAME,
  PostExternalBankAccountBankModel.JSON_PROPERTY_ACCOUNT_KIND,
  PostExternalBankAccountBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  PostExternalBankAccountBankModel.JSON_PROPERTY_ASSET,
  PostExternalBankAccountBankModel.JSON_PROPERTY_PLAID_PUBLIC_TOKEN,
  PostExternalBankAccountBankModel.JSON_PROPERTY_PLAID_ACCOUNT_ID,
  PostExternalBankAccountBankModel.JSON_PROPERTY_PLAID_PROCESSOR_TOKEN,
  PostExternalBankAccountBankModel.JSON_PROPERTY_PLAID_INSTITUTION_ID,
  PostExternalBankAccountBankModel.JSON_PROPERTY_PLAID_ACCOUNT_MASK,
  PostExternalBankAccountBankModel.JSON_PROPERTY_PLAID_ACCOUNT_NAME
})
@JsonTypeName("PostExternalBankAccount")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-08T11:53:19.477156Z[Etc/UTC]")
public class PostExternalBankAccountBankModel {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  /**
   * The account type
   */
  public enum AccountKindEnum {
    PLAID("plaid"),
    
    PLAID_PROCESSOR_TOKEN("plaid_processor_token");

    private String value;

    AccountKindEnum(String value) {
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
    public static AccountKindEnum fromValue(String value) {
      for (AccountKindEnum b : AccountKindEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ACCOUNT_KIND = "account_kind";
  private AccountKindEnum accountKind;

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private String customerGuid;

  public static final String JSON_PROPERTY_ASSET = "asset";
  private String asset;

  public static final String JSON_PROPERTY_PLAID_PUBLIC_TOKEN = "plaid_public_token";
  private String plaidPublicToken;

  public static final String JSON_PROPERTY_PLAID_ACCOUNT_ID = "plaid_account_id";
  private String plaidAccountId;

  public static final String JSON_PROPERTY_PLAID_PROCESSOR_TOKEN = "plaid_processor_token";
  private String plaidProcessorToken;

  public static final String JSON_PROPERTY_PLAID_INSTITUTION_ID = "plaid_institution_id";
  private String plaidInstitutionId;

  public static final String JSON_PROPERTY_PLAID_ACCOUNT_MASK = "plaid_account_mask";
  private String plaidAccountMask;

  public static final String JSON_PROPERTY_PLAID_ACCOUNT_NAME = "plaid_account_name";
  private String plaidAccountName;

  public PostExternalBankAccountBankModel() { 
  }

  public PostExternalBankAccountBankModel name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the account.
   * @return name
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The name of the account.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }


  public PostExternalBankAccountBankModel accountKind(AccountKindEnum accountKind) {
    
    this.accountKind = accountKind;
    return this;
  }

   /**
   * The account type
   * @return accountKind
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The account type")
  @JsonProperty(JSON_PROPERTY_ACCOUNT_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AccountKindEnum getAccountKind() {
    return accountKind;
  }


  @JsonProperty(JSON_PROPERTY_ACCOUNT_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccountKind(AccountKindEnum accountKind) {
    this.accountKind = accountKind;
  }


  public PostExternalBankAccountBankModel customerGuid(String customerGuid) {
    
    this.customerGuid = customerGuid;
    return this;
  }

   /**
   * The customer identifier.
   * @return customerGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer identifier.")
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


  public PostExternalBankAccountBankModel asset(String asset) {
    
    this.asset = asset;
    return this;
  }

   /**
   * The asset code. If not set will try and default to the Bank&#39;s configured fiat asset.
   * @return asset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(required = true, value = "The asset code. If not set will try and default to the Bank's configured fiat asset.")
  @JsonProperty(JSON_PROPERTY_ASSET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAsset() {
    return asset;
  }


  @JsonProperty(JSON_PROPERTY_ASSET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAsset(String asset) {
    this.asset = asset;
  }


  public PostExternalBankAccountBankModel plaidPublicToken(String plaidPublicToken) {
    
    this.plaidPublicToken = plaidPublicToken;
    return this;
  }

   /**
   * The public token for the account. Required for &#39;plaid&#39; accounts.
   * @return plaidPublicToken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The public token for the account. Required for 'plaid' accounts.")
  @JsonProperty(JSON_PROPERTY_PLAID_PUBLIC_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPlaidPublicToken() {
    return plaidPublicToken;
  }


  @JsonProperty(JSON_PROPERTY_PLAID_PUBLIC_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPlaidPublicToken(String plaidPublicToken) {
    this.plaidPublicToken = plaidPublicToken;
  }


  public PostExternalBankAccountBankModel plaidAccountId(String plaidAccountId) {
    
    this.plaidAccountId = plaidAccountId;
    return this;
  }

   /**
   * The account identifier in plaid. Required for &#39;plaid&#39; accounts.
   * @return plaidAccountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The account identifier in plaid. Required for 'plaid' accounts.")
  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPlaidAccountId() {
    return plaidAccountId;
  }


  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPlaidAccountId(String plaidAccountId) {
    this.plaidAccountId = plaidAccountId;
  }


  public PostExternalBankAccountBankModel plaidProcessorToken(String plaidProcessorToken) {
    
    this.plaidProcessorToken = plaidProcessorToken;
    return this;
  }

   /**
   * The Plaid processor token used to access the account. Required for &#39;plaid_processor_token&#39; accounts.
   * @return plaidProcessorToken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Plaid processor token used to access the account. Required for 'plaid_processor_token' accounts.")
  @JsonProperty(JSON_PROPERTY_PLAID_PROCESSOR_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPlaidProcessorToken() {
    return plaidProcessorToken;
  }


  @JsonProperty(JSON_PROPERTY_PLAID_PROCESSOR_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPlaidProcessorToken(String plaidProcessorToken) {
    this.plaidProcessorToken = plaidProcessorToken;
  }


  public PostExternalBankAccountBankModel plaidInstitutionId(String plaidInstitutionId) {
    
    this.plaidInstitutionId = plaidInstitutionId;
    return this;
  }

   /**
   * Plaid&#39;s institution ID for the account&#39;s institution. Required for &#39;plaid_processor_token&#39; accounts.
   * @return plaidInstitutionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Plaid's institution ID for the account's institution. Required for 'plaid_processor_token' accounts.")
  @JsonProperty(JSON_PROPERTY_PLAID_INSTITUTION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPlaidInstitutionId() {
    return plaidInstitutionId;
  }


  @JsonProperty(JSON_PROPERTY_PLAID_INSTITUTION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPlaidInstitutionId(String plaidInstitutionId) {
    this.plaidInstitutionId = plaidInstitutionId;
  }


  public PostExternalBankAccountBankModel plaidAccountMask(String plaidAccountMask) {
    
    this.plaidAccountMask = plaidAccountMask;
    return this;
  }

   /**
   * The account mask for the account. Required for &#39;plaid_processor_token&#39; accounts.
   * @return plaidAccountMask
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The account mask for the account. Required for 'plaid_processor_token' accounts.")
  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_MASK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPlaidAccountMask() {
    return plaidAccountMask;
  }


  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_MASK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPlaidAccountMask(String plaidAccountMask) {
    this.plaidAccountMask = plaidAccountMask;
  }


  public PostExternalBankAccountBankModel plaidAccountName(String plaidAccountName) {
    
    this.plaidAccountName = plaidAccountName;
    return this;
  }

   /**
   * The name of the account. Required for &#39;plaid_processor_token&#39; accounts.
   * @return plaidAccountName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the account. Required for 'plaid_processor_token' accounts.")
  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPlaidAccountName() {
    return plaidAccountName;
  }


  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPlaidAccountName(String plaidAccountName) {
    this.plaidAccountName = plaidAccountName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostExternalBankAccountBankModel postExternalBankAccount = (PostExternalBankAccountBankModel) o;
    return Objects.equals(this.name, postExternalBankAccount.name) &&
        Objects.equals(this.accountKind, postExternalBankAccount.accountKind) &&
        Objects.equals(this.customerGuid, postExternalBankAccount.customerGuid) &&
        Objects.equals(this.asset, postExternalBankAccount.asset) &&
        Objects.equals(this.plaidPublicToken, postExternalBankAccount.plaidPublicToken) &&
        Objects.equals(this.plaidAccountId, postExternalBankAccount.plaidAccountId) &&
        Objects.equals(this.plaidProcessorToken, postExternalBankAccount.plaidProcessorToken) &&
        Objects.equals(this.plaidInstitutionId, postExternalBankAccount.plaidInstitutionId) &&
        Objects.equals(this.plaidAccountMask, postExternalBankAccount.plaidAccountMask) &&
        Objects.equals(this.plaidAccountName, postExternalBankAccount.plaidAccountName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, accountKind, customerGuid, asset, plaidPublicToken, plaidAccountId, plaidProcessorToken, plaidInstitutionId, plaidAccountMask, plaidAccountName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostExternalBankAccountBankModel {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    accountKind: ").append(toIndentedString(accountKind)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
    sb.append("    plaidPublicToken: ").append(toIndentedString(plaidPublicToken)).append("\n");
    sb.append("    plaidAccountId: ").append(toIndentedString(plaidAccountId)).append("\n");
    sb.append("    plaidProcessorToken: ").append(toIndentedString(plaidProcessorToken)).append("\n");
    sb.append("    plaidInstitutionId: ").append(toIndentedString(plaidInstitutionId)).append("\n");
    sb.append("    plaidAccountMask: ").append(toIndentedString(plaidAccountMask)).append("\n");
    sb.append("    plaidAccountName: ").append(toIndentedString(plaidAccountName)).append("\n");
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


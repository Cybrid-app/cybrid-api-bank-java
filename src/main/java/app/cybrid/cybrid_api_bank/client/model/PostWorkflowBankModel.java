/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Introduction](https://docs.cybrid.xyz/docs/introduction) 2. [Platform Introduction](https://docs.cybrid.xyz/docs/how-is-cybrid-architected) 3. [Testing with Hosted Web Demo App](https://docs.cybrid.xyz/docs/testing-with-hosted-web-demo-app)  In [Getting Started in the Cybrid Sandbox](https://docs.cybrid.xyz/docs/how-do-i-get-started-with-the-sandbox), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.production.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:write counterparties:execute customers:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read external_bank_accounts:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:write identity_verifications:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read customers:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:execute external_bank_accounts:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               | | Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |  ## Available Endpoints  The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create and list organization users                                                                | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             | | Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.123.111
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
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Request body for workflow creation.
 */
@ApiModel(description = "Request body for workflow creation.")
@JsonPropertyOrder({
  PostWorkflowBankModel.JSON_PROPERTY_TYPE,
  PostWorkflowBankModel.JSON_PROPERTY_KIND,
  PostWorkflowBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  PostWorkflowBankModel.JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID,
  PostWorkflowBankModel.JSON_PROPERTY_LANGUAGE,
  PostWorkflowBankModel.JSON_PROPERTY_LINK_CUSTOMIZATION_NAME,
  PostWorkflowBankModel.JSON_PROPERTY_REDIRECT_URI,
  PostWorkflowBankModel.JSON_PROPERTY_ANDROID_PACKAGE_NAME
})
@JsonTypeName("PostWorkflow")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-30T17:09:04.794741Z[Etc/UTC]")
public class PostWorkflowBankModel {
  /**
   * The workflow type.
   */
  public enum TypeEnum {
    PLAID("plaid");

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
   * The Plaid workflow kind. Required when type is plaid.
   */
  public enum KindEnum {
    CREATE("link_token_create"),
    
    UPDATE("link_token_update");

    private String value;

    KindEnum(String value) {
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
    public static KindEnum fromValue(String value) {
      for (KindEnum b : KindEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  public static final String JSON_PROPERTY_KIND = "kind";
  private JsonNullable<KindEnum> kind = JsonNullable.<KindEnum>undefined();

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private JsonNullable<String> customerGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID = "external_bank_account_guid";
  private JsonNullable<String> externalBankAccountGuid = JsonNullable.<String>undefined();

  /**
   * The language to initialize Plaid link. Required when type is plaid.
   */
  public enum LanguageEnum {
    EN("en"),
    
    FR("fr"),
    
    ES("es"),
    
    NL("nl"),
    
    DE("de");

    private String value;

    LanguageEnum(String value) {
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
    public static LanguageEnum fromValue(String value) {
      for (LanguageEnum b : LanguageEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  public static final String JSON_PROPERTY_LANGUAGE = "language";
  private JsonNullable<LanguageEnum> language = JsonNullable.<LanguageEnum>undefined();

  public static final String JSON_PROPERTY_LINK_CUSTOMIZATION_NAME = "link_customization_name";
  private JsonNullable<String> linkCustomizationName = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_REDIRECT_URI = "redirect_uri";
  private JsonNullable<String> redirectUri = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_ANDROID_PACKAGE_NAME = "android_package_name";
  private JsonNullable<String> androidPackageName = JsonNullable.<String>undefined();

  public PostWorkflowBankModel() { 
  }

  public PostWorkflowBankModel type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * The workflow type.
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The workflow type.")
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


  public PostWorkflowBankModel kind(KindEnum kind) {
    this.kind = JsonNullable.<KindEnum>of(kind);
    
    return this;
  }

   /**
   * The Plaid workflow kind. Required when type is plaid.
   * @return kind
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Plaid workflow kind. Required when type is plaid.")
  @JsonIgnore

  public KindEnum getKind() {
        return kind.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<KindEnum> getKind_JsonNullable() {
    return kind;
  }
  
  @JsonProperty(JSON_PROPERTY_KIND)
  public void setKind_JsonNullable(JsonNullable<KindEnum> kind) {
    this.kind = kind;
  }

  public void setKind(KindEnum kind) {
    this.kind = JsonNullable.<KindEnum>of(kind);
  }


  public PostWorkflowBankModel customerGuid(String customerGuid) {
    this.customerGuid = JsonNullable.<String>of(customerGuid);
    
    return this;
  }

   /**
   * The customer identifier associated with the workflow. Optional when type is plaid and kind is link_token_create.
   * @return customerGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer identifier associated with the workflow. Optional when type is plaid and kind is link_token_create.")
  @JsonIgnore

  public String getCustomerGuid() {
        return customerGuid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CUSTOMER_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getCustomerGuid_JsonNullable() {
    return customerGuid;
  }
  
  @JsonProperty(JSON_PROPERTY_CUSTOMER_GUID)
  public void setCustomerGuid_JsonNullable(JsonNullable<String> customerGuid) {
    this.customerGuid = customerGuid;
  }

  public void setCustomerGuid(String customerGuid) {
    this.customerGuid = JsonNullable.<String>of(customerGuid);
  }


  public PostWorkflowBankModel externalBankAccountGuid(String externalBankAccountGuid) {
    this.externalBankAccountGuid = JsonNullable.<String>of(externalBankAccountGuid);
    
    return this;
  }

   /**
   * The external bank account identifier associated with the workflow. Required when type is plaid and kind is link_token_update.
   * @return externalBankAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The external bank account identifier associated with the workflow. Required when type is plaid and kind is link_token_update.")
  @JsonIgnore

  public String getExternalBankAccountGuid() {
        return externalBankAccountGuid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getExternalBankAccountGuid_JsonNullable() {
    return externalBankAccountGuid;
  }
  
  @JsonProperty(JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID)
  public void setExternalBankAccountGuid_JsonNullable(JsonNullable<String> externalBankAccountGuid) {
    this.externalBankAccountGuid = externalBankAccountGuid;
  }

  public void setExternalBankAccountGuid(String externalBankAccountGuid) {
    this.externalBankAccountGuid = JsonNullable.<String>of(externalBankAccountGuid);
  }


  public PostWorkflowBankModel language(LanguageEnum language) {
    this.language = JsonNullable.<LanguageEnum>of(language);
    
    return this;
  }

   /**
   * The language to initialize Plaid link. Required when type is plaid.
   * @return language
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The language to initialize Plaid link. Required when type is plaid.")
  @JsonIgnore

  public LanguageEnum getLanguage() {
        return language.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<LanguageEnum> getLanguage_JsonNullable() {
    return language;
  }
  
  @JsonProperty(JSON_PROPERTY_LANGUAGE)
  public void setLanguage_JsonNullable(JsonNullable<LanguageEnum> language) {
    this.language = language;
  }

  public void setLanguage(LanguageEnum language) {
    this.language = JsonNullable.<LanguageEnum>of(language);
  }


  public PostWorkflowBankModel linkCustomizationName(String linkCustomizationName) {
    this.linkCustomizationName = JsonNullable.<String>of(linkCustomizationName);
    
    return this;
  }

   /**
   * The customization name for Plaid link. Currently only supports the value \&quot;default\&quot;. Required when type is plaid.
   * @return linkCustomizationName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customization name for Plaid link. Currently only supports the value \"default\". Required when type is plaid.")
  @JsonIgnore

  public String getLinkCustomizationName() {
        return linkCustomizationName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINK_CUSTOMIZATION_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getLinkCustomizationName_JsonNullable() {
    return linkCustomizationName;
  }
  
  @JsonProperty(JSON_PROPERTY_LINK_CUSTOMIZATION_NAME)
  public void setLinkCustomizationName_JsonNullable(JsonNullable<String> linkCustomizationName) {
    this.linkCustomizationName = linkCustomizationName;
  }

  public void setLinkCustomizationName(String linkCustomizationName) {
    this.linkCustomizationName = JsonNullable.<String>of(linkCustomizationName);
  }


  public PostWorkflowBankModel redirectUri(String redirectUri) {
    this.redirectUri = JsonNullable.<String>of(redirectUri);
    
    return this;
  }

   /**
   * The redirect URI for Plaid link. Optional when type is plaid.
   * @return redirectUri
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The redirect URI for Plaid link. Optional when type is plaid.")
  @JsonIgnore

  public String getRedirectUri() {
        return redirectUri.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REDIRECT_URI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getRedirectUri_JsonNullable() {
    return redirectUri;
  }
  
  @JsonProperty(JSON_PROPERTY_REDIRECT_URI)
  public void setRedirectUri_JsonNullable(JsonNullable<String> redirectUri) {
    this.redirectUri = redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
    this.redirectUri = JsonNullable.<String>of(redirectUri);
  }


  public PostWorkflowBankModel androidPackageName(String androidPackageName) {
    this.androidPackageName = JsonNullable.<String>of(androidPackageName);
    
    return this;
  }

   /**
   * The Android package name for Plaid link. Optional when type is plaid.
   * @return androidPackageName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Android package name for Plaid link. Optional when type is plaid.")
  @JsonIgnore

  public String getAndroidPackageName() {
        return androidPackageName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ANDROID_PACKAGE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getAndroidPackageName_JsonNullable() {
    return androidPackageName;
  }
  
  @JsonProperty(JSON_PROPERTY_ANDROID_PACKAGE_NAME)
  public void setAndroidPackageName_JsonNullable(JsonNullable<String> androidPackageName) {
    this.androidPackageName = androidPackageName;
  }

  public void setAndroidPackageName(String androidPackageName) {
    this.androidPackageName = JsonNullable.<String>of(androidPackageName);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostWorkflowBankModel postWorkflow = (PostWorkflowBankModel) o;
    return Objects.equals(this.type, postWorkflow.type) &&
        equalsNullable(this.kind, postWorkflow.kind) &&
        equalsNullable(this.customerGuid, postWorkflow.customerGuid) &&
        equalsNullable(this.externalBankAccountGuid, postWorkflow.externalBankAccountGuid) &&
        equalsNullable(this.language, postWorkflow.language) &&
        equalsNullable(this.linkCustomizationName, postWorkflow.linkCustomizationName) &&
        equalsNullable(this.redirectUri, postWorkflow.redirectUri) &&
        equalsNullable(this.androidPackageName, postWorkflow.androidPackageName);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, hashCodeNullable(kind), hashCodeNullable(customerGuid), hashCodeNullable(externalBankAccountGuid), hashCodeNullable(language), hashCodeNullable(linkCustomizationName), hashCodeNullable(redirectUri), hashCodeNullable(androidPackageName));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostWorkflowBankModel {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    externalBankAccountGuid: ").append(toIndentedString(externalBankAccountGuid)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    linkCustomizationName: ").append(toIndentedString(linkCustomizationName)).append("\n");
    sb.append("    redirectUri: ").append(toIndentedString(redirectUri)).append("\n");
    sb.append("    androidPackageName: ").append(toIndentedString(androidPackageName)).append("\n");
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


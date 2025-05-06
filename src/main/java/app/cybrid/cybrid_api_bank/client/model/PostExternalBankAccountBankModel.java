/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Introduction](https://docs.cybrid.xyz/docs/introduction) 2. [Platform Introduction](https://docs.cybrid.xyz/docs/how-is-cybrid-architected) 3. [Testing with Hosted Web Demo App](https://docs.cybrid.xyz/docs/testing-with-hosted-web-demo-app)  In [Getting Started in the Cybrid Sandbox](https://docs.cybrid.xyz/docs/how-do-i-get-started-with-the-sandbox), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.production.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:pii:read counterparties:write counterparties:execute customers:read customers:pii:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read transfers:write external_bank_accounts:read external_bank_accounts:pii:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:pii:read identity_verifications:write identity_verifications:execute files:read files:pii:read files:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read counterparties:pii:read customers:read customers:pii:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:write transfers:execute external_bank_accounts:read external_bank_accounts:pii:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read identity_verifications:pii:read files:read files:pii:read files:execute' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               | | Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |  ## Available Endpoints  The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create and list organization users                                                                | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             | | Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.123.454
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.model;

import java.util.Objects;
import java.util.Arrays;
import app.cybrid.cybrid_api_bank.client.model.PostExternalBankAccountCounterpartyAddressBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostExternalBankAccountCounterpartyBankAccountBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostExternalBankAccountCounterpartyNameBankModel;
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
 * Request body for external bank account creation.
 */
@ApiModel(description = "Request body for external bank account creation.")
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
  PostExternalBankAccountBankModel.JSON_PROPERTY_PLAID_ACCOUNT_NAME,
  PostExternalBankAccountBankModel.JSON_PROPERTY_COUNTERPARTY_GUID,
  PostExternalBankAccountBankModel.JSON_PROPERTY_COUNTERPARTY_BANK_ACCOUNT,
  PostExternalBankAccountBankModel.JSON_PROPERTY_COUNTERPARTY_NAME,
  PostExternalBankAccountBankModel.JSON_PROPERTY_COUNTERPARTY_ADDRESS,
  PostExternalBankAccountBankModel.JSON_PROPERTY_COUNTERPARTY_EMAIL_ADDRESS
})
@JsonTypeName("PostExternalBankAccount")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-06T15:33:44.840158Z[Etc/UTC]")
public class PostExternalBankAccountBankModel {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  /**
   * The account type
   */
  public enum AccountKindEnum {
    PLAID("plaid"),
    
    PLAID_PROCESSOR_TOKEN("plaid_processor_token"),
    
    RAW_ROUTING_DETAILS("raw_routing_details");

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
  private JsonNullable<String> customerGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_ASSET = "asset";
  private JsonNullable<String> asset = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_PLAID_PUBLIC_TOKEN = "plaid_public_token";
  private JsonNullable<String> plaidPublicToken = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_PLAID_ACCOUNT_ID = "plaid_account_id";
  private JsonNullable<String> plaidAccountId = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_PLAID_PROCESSOR_TOKEN = "plaid_processor_token";
  private JsonNullable<String> plaidProcessorToken = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_PLAID_INSTITUTION_ID = "plaid_institution_id";
  private JsonNullable<String> plaidInstitutionId = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_PLAID_ACCOUNT_MASK = "plaid_account_mask";
  private JsonNullable<String> plaidAccountMask = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_PLAID_ACCOUNT_NAME = "plaid_account_name";
  private JsonNullable<String> plaidAccountName = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_COUNTERPARTY_GUID = "counterparty_guid";
  private JsonNullable<String> counterpartyGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_COUNTERPARTY_BANK_ACCOUNT = "counterparty_bank_account";
  private JsonNullable<PostExternalBankAccountCounterpartyBankAccountBankModel> counterpartyBankAccount = JsonNullable.<PostExternalBankAccountCounterpartyBankAccountBankModel>undefined();

  public static final String JSON_PROPERTY_COUNTERPARTY_NAME = "counterparty_name";
  private JsonNullable<PostExternalBankAccountCounterpartyNameBankModel> counterpartyName = JsonNullable.<PostExternalBankAccountCounterpartyNameBankModel>undefined();

  public static final String JSON_PROPERTY_COUNTERPARTY_ADDRESS = "counterparty_address";
  private JsonNullable<PostExternalBankAccountCounterpartyAddressBankModel> counterpartyAddress = JsonNullable.<PostExternalBankAccountCounterpartyAddressBankModel>undefined();

  public static final String JSON_PROPERTY_COUNTERPARTY_EMAIL_ADDRESS = "counterparty_email_address";
  private JsonNullable<String> counterpartyEmailAddress = JsonNullable.<String>undefined();

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
    this.customerGuid = JsonNullable.<String>of(customerGuid);
    
    return this;
  }

   /**
   * The customer identifier.
   * @return customerGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer identifier.")
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


  public PostExternalBankAccountBankModel asset(String asset) {
    this.asset = JsonNullable.<String>of(asset);
    
    return this;
  }

   /**
   * The asset code. If not set will try and default to the Bank&#39;s configured fiat asset.
   * @return asset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The asset code. If not set will try and default to the Bank's configured fiat asset.")
  @JsonIgnore

  public String getAsset() {
        return asset.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ASSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getAsset_JsonNullable() {
    return asset;
  }
  
  @JsonProperty(JSON_PROPERTY_ASSET)
  public void setAsset_JsonNullable(JsonNullable<String> asset) {
    this.asset = asset;
  }

  public void setAsset(String asset) {
    this.asset = JsonNullable.<String>of(asset);
  }


  public PostExternalBankAccountBankModel plaidPublicToken(String plaidPublicToken) {
    this.plaidPublicToken = JsonNullable.<String>of(plaidPublicToken);
    
    return this;
  }

   /**
   * The public token for the account. Required for &#39;plaid&#39; accounts. Required when account_kind is plaid.
   * @return plaidPublicToken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The public token for the account. Required for 'plaid' accounts. Required when account_kind is plaid.")
  @JsonIgnore

  public String getPlaidPublicToken() {
        return plaidPublicToken.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PLAID_PUBLIC_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPlaidPublicToken_JsonNullable() {
    return plaidPublicToken;
  }
  
  @JsonProperty(JSON_PROPERTY_PLAID_PUBLIC_TOKEN)
  public void setPlaidPublicToken_JsonNullable(JsonNullable<String> plaidPublicToken) {
    this.plaidPublicToken = plaidPublicToken;
  }

  public void setPlaidPublicToken(String plaidPublicToken) {
    this.plaidPublicToken = JsonNullable.<String>of(plaidPublicToken);
  }


  public PostExternalBankAccountBankModel plaidAccountId(String plaidAccountId) {
    this.plaidAccountId = JsonNullable.<String>of(plaidAccountId);
    
    return this;
  }

   /**
   * The account identifier in plaid. Required for &#39;plaid&#39; accounts. Required when account_kind is plaid.
   * @return plaidAccountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The account identifier in plaid. Required for 'plaid' accounts. Required when account_kind is plaid.")
  @JsonIgnore

  public String getPlaidAccountId() {
        return plaidAccountId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPlaidAccountId_JsonNullable() {
    return plaidAccountId;
  }
  
  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_ID)
  public void setPlaidAccountId_JsonNullable(JsonNullable<String> plaidAccountId) {
    this.plaidAccountId = plaidAccountId;
  }

  public void setPlaidAccountId(String plaidAccountId) {
    this.plaidAccountId = JsonNullable.<String>of(plaidAccountId);
  }


  public PostExternalBankAccountBankModel plaidProcessorToken(String plaidProcessorToken) {
    this.plaidProcessorToken = JsonNullable.<String>of(plaidProcessorToken);
    
    return this;
  }

   /**
   * The Plaid processor token used to access the account. Required when account_kind is plaid_processor_token.
   * @return plaidProcessorToken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Plaid processor token used to access the account. Required when account_kind is plaid_processor_token.")
  @JsonIgnore

  public String getPlaidProcessorToken() {
        return plaidProcessorToken.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PLAID_PROCESSOR_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPlaidProcessorToken_JsonNullable() {
    return plaidProcessorToken;
  }
  
  @JsonProperty(JSON_PROPERTY_PLAID_PROCESSOR_TOKEN)
  public void setPlaidProcessorToken_JsonNullable(JsonNullable<String> plaidProcessorToken) {
    this.plaidProcessorToken = plaidProcessorToken;
  }

  public void setPlaidProcessorToken(String plaidProcessorToken) {
    this.plaidProcessorToken = JsonNullable.<String>of(plaidProcessorToken);
  }


  public PostExternalBankAccountBankModel plaidInstitutionId(String plaidInstitutionId) {
    this.plaidInstitutionId = JsonNullable.<String>of(plaidInstitutionId);
    
    return this;
  }

   /**
   * Plaid&#39;s institution ID for the account&#39;s institution. Required when account_kind is plaid_processor_token.
   * @return plaidInstitutionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Plaid's institution ID for the account's institution. Required when account_kind is plaid_processor_token.")
  @JsonIgnore

  public String getPlaidInstitutionId() {
        return plaidInstitutionId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PLAID_INSTITUTION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPlaidInstitutionId_JsonNullable() {
    return plaidInstitutionId;
  }
  
  @JsonProperty(JSON_PROPERTY_PLAID_INSTITUTION_ID)
  public void setPlaidInstitutionId_JsonNullable(JsonNullable<String> plaidInstitutionId) {
    this.plaidInstitutionId = plaidInstitutionId;
  }

  public void setPlaidInstitutionId(String plaidInstitutionId) {
    this.plaidInstitutionId = JsonNullable.<String>of(plaidInstitutionId);
  }


  public PostExternalBankAccountBankModel plaidAccountMask(String plaidAccountMask) {
    this.plaidAccountMask = JsonNullable.<String>of(plaidAccountMask);
    
    return this;
  }

   /**
   * The account mask for the account. Required when account_kind is plaid_processor_token.
   * @return plaidAccountMask
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The account mask for the account. Required when account_kind is plaid_processor_token.")
  @JsonIgnore

  public String getPlaidAccountMask() {
        return plaidAccountMask.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_MASK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPlaidAccountMask_JsonNullable() {
    return plaidAccountMask;
  }
  
  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_MASK)
  public void setPlaidAccountMask_JsonNullable(JsonNullable<String> plaidAccountMask) {
    this.plaidAccountMask = plaidAccountMask;
  }

  public void setPlaidAccountMask(String plaidAccountMask) {
    this.plaidAccountMask = JsonNullable.<String>of(plaidAccountMask);
  }


  public PostExternalBankAccountBankModel plaidAccountName(String plaidAccountName) {
    this.plaidAccountName = JsonNullable.<String>of(plaidAccountName);
    
    return this;
  }

   /**
   * The name of the account. Required when account_kind is plaid_processor_token.
   * @return plaidAccountName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the account. Required when account_kind is plaid_processor_token.")
  @JsonIgnore

  public String getPlaidAccountName() {
        return plaidAccountName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPlaidAccountName_JsonNullable() {
    return plaidAccountName;
  }
  
  @JsonProperty(JSON_PROPERTY_PLAID_ACCOUNT_NAME)
  public void setPlaidAccountName_JsonNullable(JsonNullable<String> plaidAccountName) {
    this.plaidAccountName = plaidAccountName;
  }

  public void setPlaidAccountName(String plaidAccountName) {
    this.plaidAccountName = JsonNullable.<String>of(plaidAccountName);
  }


  public PostExternalBankAccountBankModel counterpartyGuid(String counterpartyGuid) {
    this.counterpartyGuid = JsonNullable.<String>of(counterpartyGuid);
    
    return this;
  }

   /**
   * The counterparty identifier. Optional when account_kind is raw_routing_details.
   * @return counterpartyGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The counterparty identifier. Optional when account_kind is raw_routing_details.")
  @JsonIgnore

  public String getCounterpartyGuid() {
        return counterpartyGuid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getCounterpartyGuid_JsonNullable() {
    return counterpartyGuid;
  }
  
  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_GUID)
  public void setCounterpartyGuid_JsonNullable(JsonNullable<String> counterpartyGuid) {
    this.counterpartyGuid = counterpartyGuid;
  }

  public void setCounterpartyGuid(String counterpartyGuid) {
    this.counterpartyGuid = JsonNullable.<String>of(counterpartyGuid);
  }


  public PostExternalBankAccountBankModel counterpartyBankAccount(PostExternalBankAccountCounterpartyBankAccountBankModel counterpartyBankAccount) {
    this.counterpartyBankAccount = JsonNullable.<PostExternalBankAccountCounterpartyBankAccountBankModel>of(counterpartyBankAccount);
    
    return this;
  }

   /**
   * Get counterpartyBankAccount
   * @return counterpartyBankAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonIgnore

  public PostExternalBankAccountCounterpartyBankAccountBankModel getCounterpartyBankAccount() {
        return counterpartyBankAccount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_BANK_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<PostExternalBankAccountCounterpartyBankAccountBankModel> getCounterpartyBankAccount_JsonNullable() {
    return counterpartyBankAccount;
  }
  
  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_BANK_ACCOUNT)
  public void setCounterpartyBankAccount_JsonNullable(JsonNullable<PostExternalBankAccountCounterpartyBankAccountBankModel> counterpartyBankAccount) {
    this.counterpartyBankAccount = counterpartyBankAccount;
  }

  public void setCounterpartyBankAccount(PostExternalBankAccountCounterpartyBankAccountBankModel counterpartyBankAccount) {
    this.counterpartyBankAccount = JsonNullable.<PostExternalBankAccountCounterpartyBankAccountBankModel>of(counterpartyBankAccount);
  }


  public PostExternalBankAccountBankModel counterpartyName(PostExternalBankAccountCounterpartyNameBankModel counterpartyName) {
    this.counterpartyName = JsonNullable.<PostExternalBankAccountCounterpartyNameBankModel>of(counterpartyName);
    
    return this;
  }

   /**
   * Get counterpartyName
   * @return counterpartyName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonIgnore

  public PostExternalBankAccountCounterpartyNameBankModel getCounterpartyName() {
        return counterpartyName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<PostExternalBankAccountCounterpartyNameBankModel> getCounterpartyName_JsonNullable() {
    return counterpartyName;
  }
  
  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_NAME)
  public void setCounterpartyName_JsonNullable(JsonNullable<PostExternalBankAccountCounterpartyNameBankModel> counterpartyName) {
    this.counterpartyName = counterpartyName;
  }

  public void setCounterpartyName(PostExternalBankAccountCounterpartyNameBankModel counterpartyName) {
    this.counterpartyName = JsonNullable.<PostExternalBankAccountCounterpartyNameBankModel>of(counterpartyName);
  }


  public PostExternalBankAccountBankModel counterpartyAddress(PostExternalBankAccountCounterpartyAddressBankModel counterpartyAddress) {
    this.counterpartyAddress = JsonNullable.<PostExternalBankAccountCounterpartyAddressBankModel>of(counterpartyAddress);
    
    return this;
  }

   /**
   * Get counterpartyAddress
   * @return counterpartyAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonIgnore

  public PostExternalBankAccountCounterpartyAddressBankModel getCounterpartyAddress() {
        return counterpartyAddress.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<PostExternalBankAccountCounterpartyAddressBankModel> getCounterpartyAddress_JsonNullable() {
    return counterpartyAddress;
  }
  
  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_ADDRESS)
  public void setCounterpartyAddress_JsonNullable(JsonNullable<PostExternalBankAccountCounterpartyAddressBankModel> counterpartyAddress) {
    this.counterpartyAddress = counterpartyAddress;
  }

  public void setCounterpartyAddress(PostExternalBankAccountCounterpartyAddressBankModel counterpartyAddress) {
    this.counterpartyAddress = JsonNullable.<PostExternalBankAccountCounterpartyAddressBankModel>of(counterpartyAddress);
  }


  public PostExternalBankAccountBankModel counterpartyEmailAddress(String counterpartyEmailAddress) {
    this.counterpartyEmailAddress = JsonNullable.<String>of(counterpartyEmailAddress);
    
    return this;
  }

   /**
   * The counterparty&#39;s email address on their checking account. Optional when account_kind is raw_routing_details and counterparty_guid is not present.
   * @return counterpartyEmailAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The counterparty's email address on their checking account. Optional when account_kind is raw_routing_details and counterparty_guid is not present.")
  @JsonIgnore

  public String getCounterpartyEmailAddress() {
        return counterpartyEmailAddress.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_EMAIL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getCounterpartyEmailAddress_JsonNullable() {
    return counterpartyEmailAddress;
  }
  
  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_EMAIL_ADDRESS)
  public void setCounterpartyEmailAddress_JsonNullable(JsonNullable<String> counterpartyEmailAddress) {
    this.counterpartyEmailAddress = counterpartyEmailAddress;
  }

  public void setCounterpartyEmailAddress(String counterpartyEmailAddress) {
    this.counterpartyEmailAddress = JsonNullable.<String>of(counterpartyEmailAddress);
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
        equalsNullable(this.customerGuid, postExternalBankAccount.customerGuid) &&
        equalsNullable(this.asset, postExternalBankAccount.asset) &&
        equalsNullable(this.plaidPublicToken, postExternalBankAccount.plaidPublicToken) &&
        equalsNullable(this.plaidAccountId, postExternalBankAccount.plaidAccountId) &&
        equalsNullable(this.plaidProcessorToken, postExternalBankAccount.plaidProcessorToken) &&
        equalsNullable(this.plaidInstitutionId, postExternalBankAccount.plaidInstitutionId) &&
        equalsNullable(this.plaidAccountMask, postExternalBankAccount.plaidAccountMask) &&
        equalsNullable(this.plaidAccountName, postExternalBankAccount.plaidAccountName) &&
        equalsNullable(this.counterpartyGuid, postExternalBankAccount.counterpartyGuid) &&
        equalsNullable(this.counterpartyBankAccount, postExternalBankAccount.counterpartyBankAccount) &&
        equalsNullable(this.counterpartyName, postExternalBankAccount.counterpartyName) &&
        equalsNullable(this.counterpartyAddress, postExternalBankAccount.counterpartyAddress) &&
        equalsNullable(this.counterpartyEmailAddress, postExternalBankAccount.counterpartyEmailAddress);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, accountKind, hashCodeNullable(customerGuid), hashCodeNullable(asset), hashCodeNullable(plaidPublicToken), hashCodeNullable(plaidAccountId), hashCodeNullable(plaidProcessorToken), hashCodeNullable(plaidInstitutionId), hashCodeNullable(plaidAccountMask), hashCodeNullable(plaidAccountName), hashCodeNullable(counterpartyGuid), hashCodeNullable(counterpartyBankAccount), hashCodeNullable(counterpartyName), hashCodeNullable(counterpartyAddress), hashCodeNullable(counterpartyEmailAddress));
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
    sb.append("    counterpartyGuid: ").append(toIndentedString(counterpartyGuid)).append("\n");
    sb.append("    counterpartyBankAccount: ").append(toIndentedString(counterpartyBankAccount)).append("\n");
    sb.append("    counterpartyName: ").append(toIndentedString(counterpartyName)).append("\n");
    sb.append("    counterpartyAddress: ").append(toIndentedString(counterpartyAddress)).append("\n");
    sb.append("    counterpartyEmailAddress: ").append(toIndentedString(counterpartyEmailAddress)).append("\n");
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


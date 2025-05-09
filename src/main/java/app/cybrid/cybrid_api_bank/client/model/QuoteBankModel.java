/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Introduction](https://docs.cybrid.xyz/docs/introduction) 2. [Platform Introduction](https://docs.cybrid.xyz/docs/how-is-cybrid-architected) 3. [Testing with Hosted Web Demo App](https://docs.cybrid.xyz/docs/testing-with-hosted-web-demo-app)  In [Getting Started in the Cybrid Sandbox](https://docs.cybrid.xyz/docs/how-do-i-get-started-with-the-sandbox), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.production.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:pii:read counterparties:write counterparties:execute customers:read customers:pii:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read transfers:write external_bank_accounts:read external_bank_accounts:pii:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:pii:read identity_verifications:write identity_verifications:execute files:read files:pii:read files:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read counterparties:pii:read customers:read customers:pii:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:write transfers:execute external_bank_accounts:read external_bank_accounts:pii:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read identity_verifications:pii:read identity_verifications:execute files:read files:pii:read files:execute' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               | | Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |  ## Available Endpoints  The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create and list organization users                                                                | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             | | Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.123.473
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.model;

import java.util.Objects;
import java.util.Arrays;
import app.cybrid.cybrid_api_bank.client.model.QuoteEntryBankModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * QuoteBankModel
 */
@JsonPropertyOrder({
  QuoteBankModel.JSON_PROPERTY_GUID,
  QuoteBankModel.JSON_PROPERTY_PRODUCT_TYPE,
  QuoteBankModel.JSON_PROPERTY_BANK_GUID,
  QuoteBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  QuoteBankModel.JSON_PROPERTY_SYMBOL,
  QuoteBankModel.JSON_PROPERTY_SIDE,
  QuoteBankModel.JSON_PROPERTY_RECEIVE_AMOUNT,
  QuoteBankModel.JSON_PROPERTY_DELIVER_AMOUNT,
  QuoteBankModel.JSON_PROPERTY_FEE,
  QuoteBankModel.JSON_PROPERTY_CREATED_AT,
  QuoteBankModel.JSON_PROPERTY_UPDATED_AT,
  QuoteBankModel.JSON_PROPERTY_ISSUED_AT,
  QuoteBankModel.JSON_PROPERTY_EXPIRES_AT,
  QuoteBankModel.JSON_PROPERTY_ASSET,
  QuoteBankModel.JSON_PROPERTY_NETWORK_FEE,
  QuoteBankModel.JSON_PROPERTY_NETWORK_FEE_ASSET,
  QuoteBankModel.JSON_PROPERTY_NETWORK_ADDRESS,
  QuoteBankModel.JSON_PROPERTY_ENTRIES,
  QuoteBankModel.JSON_PROPERTY_TRADE_GUID,
  QuoteBankModel.JSON_PROPERTY_TRANSFER_GUID
})
@JsonTypeName("Quote")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-09T22:35:02.121084Z[Etc/UTC]")
public class QuoteBankModel {
  public static final String JSON_PROPERTY_GUID = "guid";
  private String guid;

  public static final String JSON_PROPERTY_PRODUCT_TYPE = "product_type";
  private String productType;

  public static final String JSON_PROPERTY_BANK_GUID = "bank_guid";
  private String bankGuid;

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private String customerGuid;

  public static final String JSON_PROPERTY_SYMBOL = "symbol";
  private JsonNullable<String> symbol = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_SIDE = "side";
  private String side;

  public static final String JSON_PROPERTY_RECEIVE_AMOUNT = "receive_amount";
  private java.math.BigInteger receiveAmount;

  public static final String JSON_PROPERTY_DELIVER_AMOUNT = "deliver_amount";
  private java.math.BigInteger deliverAmount;

  public static final String JSON_PROPERTY_FEE = "fee";
  private java.math.BigInteger fee;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";
  private OffsetDateTime createdAt;

  public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
  private OffsetDateTime updatedAt;

  public static final String JSON_PROPERTY_ISSUED_AT = "issued_at";
  private OffsetDateTime issuedAt;

  public static final String JSON_PROPERTY_EXPIRES_AT = "expires_at";
  private JsonNullable<OffsetDateTime> expiresAt = JsonNullable.<OffsetDateTime>undefined();

  public static final String JSON_PROPERTY_ASSET = "asset";
  private JsonNullable<String> asset = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_NETWORK_FEE = "network_fee";
  private JsonNullable<java.math.BigInteger> networkFee = JsonNullable.<java.math.BigInteger>undefined();

  public static final String JSON_PROPERTY_NETWORK_FEE_ASSET = "network_fee_asset";
  private JsonNullable<String> networkFeeAsset = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_NETWORK_ADDRESS = "network_address";
  private JsonNullable<String> networkAddress = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_ENTRIES = "entries";
  private JsonNullable<List<QuoteEntryBankModel>> entries = JsonNullable.<List<QuoteEntryBankModel>>undefined();

  public static final String JSON_PROPERTY_TRADE_GUID = "trade_guid";
  private JsonNullable<String> tradeGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_TRANSFER_GUID = "transfer_guid";
  private JsonNullable<String> transferGuid = JsonNullable.<String>undefined();

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


  public QuoteBankModel productType(String productType) {
    
    this.productType = productType;
    return this;
  }

   /**
   * The type of product the quote is for; one of trading, trading_exit, funding, crypto_transfer, inter_account, or lightning_transfer.
   * @return productType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of product the quote is for; one of trading, trading_exit, funding, crypto_transfer, inter_account, or lightning_transfer.")
  @JsonProperty(JSON_PROPERTY_PRODUCT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getProductType() {
    return productType;
  }


  @JsonProperty(JSON_PROPERTY_PRODUCT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProductType(String productType) {
    this.productType = productType;
  }


  public QuoteBankModel bankGuid(String bankGuid) {
    
    this.bankGuid = bankGuid;
    return this;
  }

   /**
   * The unique identifier for the bank.
   * @return bankGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identifier for the bank.")
  @JsonProperty(JSON_PROPERTY_BANK_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBankGuid() {
    return bankGuid;
  }


  @JsonProperty(JSON_PROPERTY_BANK_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBankGuid(String bankGuid) {
    this.bankGuid = bankGuid;
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
    this.symbol = JsonNullable.<String>of(symbol);
    
    return this;
  }

   /**
   * Symbol the quote was requested for. Format is \&quot;asset-counter_asset\&quot; in uppercase. Populated for trade quotes.
   * @return symbol
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Symbol the quote was requested for. Format is \"asset-counter_asset\" in uppercase. Populated for trade quotes.")
  @JsonIgnore

  public String getSymbol() {
        return symbol.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SYMBOL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getSymbol_JsonNullable() {
    return symbol;
  }
  
  @JsonProperty(JSON_PROPERTY_SYMBOL)
  public void setSymbol_JsonNullable(JsonNullable<String> symbol) {
    this.symbol = symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = JsonNullable.<String>of(symbol);
  }


  public QuoteBankModel side(String side) {
    
    this.side = side;
    return this;
  }

   /**
   * The direction of the quote; one of buy, sell, deposit, or withdrawal.
   * @return side
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The direction of the quote; one of buy, sell, deposit, or withdrawal.")
  @JsonProperty(JSON_PROPERTY_SIDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSide() {
    return side;
  }


  @JsonProperty(JSON_PROPERTY_SIDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSide(String side) {
    this.side = side;
  }


  public QuoteBankModel receiveAmount(java.math.BigInteger receiveAmount) {
    
    this.receiveAmount = receiveAmount;
    return this;
  }

   /**
   * The amount to be received in base units of the currency: currency is \&quot;asset\&quot; for buy and \&quot;counter_asset\&quot; for sell for trade quotes.
   * @return receiveAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount to be received in base units of the currency: currency is \"asset\" for buy and \"counter_asset\" for sell for trade quotes.")
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
   * The amount to be delivered in base units of the currency: currency is \&quot;counter_asset\&quot; for buy and \&quot;asset\&quot; for sell for trade quotes.
   * @return deliverAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount to be delivered in base units of the currency: currency is \"counter_asset\" for buy and \"asset\" for sell for trade quotes.")
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
   * The fee associated with the trade. Denominated in \&quot;counter_asset\&quot; base units for trade quotes.
   * @return fee
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The fee associated with the trade. Denominated in \"counter_asset\" base units for trade quotes.")
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


  public QuoteBankModel createdAt(OffsetDateTime createdAt) {
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * ISO8601 datetime the record was created at.
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the record was created at.")
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


  public QuoteBankModel updatedAt(OffsetDateTime updatedAt) {
    
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * ISO8601 datetime the record was last updated at.
   * @return updatedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the record was last updated at.")
  @JsonProperty(JSON_PROPERTY_UPDATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }


  @JsonProperty(JSON_PROPERTY_UPDATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
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
    this.expiresAt = JsonNullable.<OffsetDateTime>of(expiresAt);
    
    return this;
  }

   /**
   * ISO8601 datetime the quote is expiring at. Populated for trading quotes.
   * @return expiresAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the quote is expiring at. Populated for trading quotes.")
  @JsonIgnore

  public OffsetDateTime getExpiresAt() {
        return expiresAt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<OffsetDateTime> getExpiresAt_JsonNullable() {
    return expiresAt;
  }
  
  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  public void setExpiresAt_JsonNullable(JsonNullable<OffsetDateTime> expiresAt) {
    this.expiresAt = expiresAt;
  }

  public void setExpiresAt(OffsetDateTime expiresAt) {
    this.expiresAt = JsonNullable.<OffsetDateTime>of(expiresAt);
  }


  public QuoteBankModel asset(String asset) {
    this.asset = JsonNullable.<String>of(asset);
    
    return this;
  }

   /**
   * The asset code the quote was requested for. Populated for book transfer and funding quotes.
   * @return asset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The asset code the quote was requested for. Populated for book transfer and funding quotes.")
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


  public QuoteBankModel networkFee(java.math.BigInteger networkFee) {
    this.networkFee = JsonNullable.<java.math.BigInteger>of(networkFee);
    
    return this;
  }

   /**
   * The network fee in base units of network_fee_asset. Only present on &#x60;crypto_transfer&#x60; quotes.
   * @return networkFee
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The network fee in base units of network_fee_asset. Only present on `crypto_transfer` quotes.")
  @JsonIgnore

  public java.math.BigInteger getNetworkFee() {
        return networkFee.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NETWORK_FEE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<java.math.BigInteger> getNetworkFee_JsonNullable() {
    return networkFee;
  }
  
  @JsonProperty(JSON_PROPERTY_NETWORK_FEE)
  public void setNetworkFee_JsonNullable(JsonNullable<java.math.BigInteger> networkFee) {
    this.networkFee = networkFee;
  }

  public void setNetworkFee(java.math.BigInteger networkFee) {
    this.networkFee = JsonNullable.<java.math.BigInteger>of(networkFee);
  }


  public QuoteBankModel networkFeeAsset(String networkFeeAsset) {
    this.networkFeeAsset = JsonNullable.<String>of(networkFeeAsset);
    
    return this;
  }

   /**
   * The asset code of the network fee.
   * @return networkFeeAsset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The asset code of the network fee.")
  @JsonIgnore

  public String getNetworkFeeAsset() {
        return networkFeeAsset.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NETWORK_FEE_ASSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getNetworkFeeAsset_JsonNullable() {
    return networkFeeAsset;
  }
  
  @JsonProperty(JSON_PROPERTY_NETWORK_FEE_ASSET)
  public void setNetworkFeeAsset_JsonNullable(JsonNullable<String> networkFeeAsset) {
    this.networkFeeAsset = networkFeeAsset;
  }

  public void setNetworkFeeAsset(String networkFeeAsset) {
    this.networkFeeAsset = JsonNullable.<String>of(networkFeeAsset);
  }


  public QuoteBankModel networkAddress(String networkAddress) {
    this.networkAddress = JsonNullable.<String>of(networkAddress);
    
    return this;
  }

   /**
   * The network address to pay the invoice to. Populated for lightning_transfer quotes.
   * @return networkAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The network address to pay the invoice to. Populated for lightning_transfer quotes.")
  @JsonIgnore

  public String getNetworkAddress() {
        return networkAddress.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NETWORK_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getNetworkAddress_JsonNullable() {
    return networkAddress;
  }
  
  @JsonProperty(JSON_PROPERTY_NETWORK_ADDRESS)
  public void setNetworkAddress_JsonNullable(JsonNullable<String> networkAddress) {
    this.networkAddress = networkAddress;
  }

  public void setNetworkAddress(String networkAddress) {
    this.networkAddress = JsonNullable.<String>of(networkAddress);
  }


  public QuoteBankModel entries(List<QuoteEntryBankModel> entries) {
    this.entries = JsonNullable.<List<QuoteEntryBankModel>>of(entries);
    
    return this;
  }

  public QuoteBankModel addEntriesItem(QuoteEntryBankModel entriesItem) {
    if (this.entries == null || !this.entries.isPresent()) {
      this.entries = JsonNullable.<List<QuoteEntryBankModel>>of(new ArrayList<>());
    }
    try {
      this.entries.get().add(entriesItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The quote entries for a batch transfer quote
   * @return entries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The quote entries for a batch transfer quote")
  @JsonIgnore

  public List<QuoteEntryBankModel> getEntries() {
        return entries.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENTRIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<QuoteEntryBankModel>> getEntries_JsonNullable() {
    return entries;
  }
  
  @JsonProperty(JSON_PROPERTY_ENTRIES)
  public void setEntries_JsonNullable(JsonNullable<List<QuoteEntryBankModel>> entries) {
    this.entries = entries;
  }

  public void setEntries(List<QuoteEntryBankModel> entries) {
    this.entries = JsonNullable.<List<QuoteEntryBankModel>>of(entries);
  }


  public QuoteBankModel tradeGuid(String tradeGuid) {
    this.tradeGuid = JsonNullable.<String>of(tradeGuid);
    
    return this;
  }

   /**
   * The unique identifier for the trade.
   * @return tradeGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identifier for the trade.")
  @JsonIgnore

  public String getTradeGuid() {
        return tradeGuid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRADE_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getTradeGuid_JsonNullable() {
    return tradeGuid;
  }
  
  @JsonProperty(JSON_PROPERTY_TRADE_GUID)
  public void setTradeGuid_JsonNullable(JsonNullable<String> tradeGuid) {
    this.tradeGuid = tradeGuid;
  }

  public void setTradeGuid(String tradeGuid) {
    this.tradeGuid = JsonNullable.<String>of(tradeGuid);
  }


  public QuoteBankModel transferGuid(String transferGuid) {
    this.transferGuid = JsonNullable.<String>of(transferGuid);
    
    return this;
  }

   /**
   * The unique identifier for the transfer.
   * @return transferGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identifier for the transfer.")
  @JsonIgnore

  public String getTransferGuid() {
        return transferGuid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRANSFER_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getTransferGuid_JsonNullable() {
    return transferGuid;
  }
  
  @JsonProperty(JSON_PROPERTY_TRANSFER_GUID)
  public void setTransferGuid_JsonNullable(JsonNullable<String> transferGuid) {
    this.transferGuid = transferGuid;
  }

  public void setTransferGuid(String transferGuid) {
    this.transferGuid = JsonNullable.<String>of(transferGuid);
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
        Objects.equals(this.productType, quote.productType) &&
        Objects.equals(this.bankGuid, quote.bankGuid) &&
        Objects.equals(this.customerGuid, quote.customerGuid) &&
        equalsNullable(this.symbol, quote.symbol) &&
        Objects.equals(this.side, quote.side) &&
        Objects.equals(this.receiveAmount, quote.receiveAmount) &&
        Objects.equals(this.deliverAmount, quote.deliverAmount) &&
        Objects.equals(this.fee, quote.fee) &&
        Objects.equals(this.createdAt, quote.createdAt) &&
        Objects.equals(this.updatedAt, quote.updatedAt) &&
        Objects.equals(this.issuedAt, quote.issuedAt) &&
        equalsNullable(this.expiresAt, quote.expiresAt) &&
        equalsNullable(this.asset, quote.asset) &&
        equalsNullable(this.networkFee, quote.networkFee) &&
        equalsNullable(this.networkFeeAsset, quote.networkFeeAsset) &&
        equalsNullable(this.networkAddress, quote.networkAddress) &&
        equalsNullable(this.entries, quote.entries) &&
        equalsNullable(this.tradeGuid, quote.tradeGuid) &&
        equalsNullable(this.transferGuid, quote.transferGuid);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(guid, productType, bankGuid, customerGuid, hashCodeNullable(symbol), side, receiveAmount, deliverAmount, fee, createdAt, updatedAt, issuedAt, hashCodeNullable(expiresAt), hashCodeNullable(asset), hashCodeNullable(networkFee), hashCodeNullable(networkFeeAsset), hashCodeNullable(networkAddress), hashCodeNullable(entries), hashCodeNullable(tradeGuid), hashCodeNullable(transferGuid));
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
    sb.append("class QuoteBankModel {\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    bankGuid: ").append(toIndentedString(bankGuid)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
    sb.append("    side: ").append(toIndentedString(side)).append("\n");
    sb.append("    receiveAmount: ").append(toIndentedString(receiveAmount)).append("\n");
    sb.append("    deliverAmount: ").append(toIndentedString(deliverAmount)).append("\n");
    sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    issuedAt: ").append(toIndentedString(issuedAt)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
    sb.append("    networkFee: ").append(toIndentedString(networkFee)).append("\n");
    sb.append("    networkFeeAsset: ").append(toIndentedString(networkFeeAsset)).append("\n");
    sb.append("    networkAddress: ").append(toIndentedString(networkAddress)).append("\n");
    sb.append("    entries: ").append(toIndentedString(entries)).append("\n");
    sb.append("    tradeGuid: ").append(toIndentedString(tradeGuid)).append("\n");
    sb.append("    transferGuid: ").append(toIndentedString(transferGuid)).append("\n");
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


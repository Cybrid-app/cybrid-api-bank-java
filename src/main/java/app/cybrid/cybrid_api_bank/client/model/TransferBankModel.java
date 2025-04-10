/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Introduction](https://docs.cybrid.xyz/docs/introduction) 2. [Platform Introduction](https://docs.cybrid.xyz/docs/how-is-cybrid-architected) 3. [Testing with Hosted Web Demo App](https://docs.cybrid.xyz/docs/testing-with-hosted-web-demo-app)  In [Getting Started in the Cybrid Sandbox](https://docs.cybrid.xyz/docs/how-do-i-get-started-with-the-sandbox), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.production.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:write counterparties:execute customers:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read external_bank_accounts:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:write identity_verifications:execute files:read files:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read customers:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:execute external_bank_accounts:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read files:read files:execute' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               | | Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |  ## Available Endpoints  The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create and list organization users                                                                | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             | | Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.123.374
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.model;

import java.util.Objects;
import java.util.Arrays;
import app.cybrid.cybrid_api_bank.client.model.TransferDestinationAccountBankModel;
import app.cybrid.cybrid_api_bank.client.model.TransferEntryBankModel;
import app.cybrid.cybrid_api_bank.client.model.TransferParticipantBankModel;
import app.cybrid.cybrid_api_bank.client.model.TransferSourceAccountBankModel;
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
 * TransferBankModel
 */
@JsonPropertyOrder({
  TransferBankModel.JSON_PROPERTY_GUID,
  TransferBankModel.JSON_PROPERTY_TRANSFER_TYPE,
  TransferBankModel.JSON_PROPERTY_BANK_GUID,
  TransferBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  TransferBankModel.JSON_PROPERTY_QUOTE_GUID,
  TransferBankModel.JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID,
  TransferBankModel.JSON_PROPERTY_ASSET,
  TransferBankModel.JSON_PROPERTY_SIDE,
  TransferBankModel.JSON_PROPERTY_STATE,
  TransferBankModel.JSON_PROPERTY_FAILURE_CODE,
  TransferBankModel.JSON_PROPERTY_RETURN_CODE,
  TransferBankModel.JSON_PROPERTY_AMOUNT,
  TransferBankModel.JSON_PROPERTY_ESTIMATED_AMOUNT,
  TransferBankModel.JSON_PROPERTY_FEE,
  TransferBankModel.JSON_PROPERTY_ESTIMATED_NETWORK_FEE,
  TransferBankModel.JSON_PROPERTY_NETWORK_FEE,
  TransferBankModel.JSON_PROPERTY_NETWORK_FEE_ASSET,
  TransferBankModel.JSON_PROPERTY_NETWORK_FEE_LIABILITY_AMOUNT,
  TransferBankModel.JSON_PROPERTY_NETWORK_FEE_LIABILITY_AMOUNT_ASSET,
  TransferBankModel.JSON_PROPERTY_TXN_HASH,
  TransferBankModel.JSON_PROPERTY_REFERENCE_TRANSFER_GUID,
  TransferBankModel.JSON_PROPERTY_SOURCE_ACCOUNT,
  TransferBankModel.JSON_PROPERTY_SOURCE_PARTICIPANTS,
  TransferBankModel.JSON_PROPERTY_DESTINATION_ACCOUNT,
  TransferBankModel.JSON_PROPERTY_DESTINATION_PARTICIPANTS,
  TransferBankModel.JSON_PROPERTY_CREATED_AT,
  TransferBankModel.JSON_PROPERTY_UPDATED_AT,
  TransferBankModel.JSON_PROPERTY_TRANSFER_DETAILS,
  TransferBankModel.JSON_PROPERTY_PAYMENT_RAIL,
  TransferBankModel.JSON_PROPERTY_LABELS,
  TransferBankModel.JSON_PROPERTY_ENTRIES
})
@JsonTypeName("Transfer")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-10T12:13:16.453444Z[Etc/UTC]")
public class TransferBankModel {
  public static final String JSON_PROPERTY_GUID = "guid";
  private String guid;

  public static final String JSON_PROPERTY_TRANSFER_TYPE = "transfer_type";
  private String transferType;

  public static final String JSON_PROPERTY_BANK_GUID = "bank_guid";
  private JsonNullable<String> bankGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private JsonNullable<String> customerGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_QUOTE_GUID = "quote_guid";
  private String quoteGuid;

  public static final String JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID = "external_bank_account_guid";
  private JsonNullable<String> externalBankAccountGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_ASSET = "asset";
  private String asset;

  public static final String JSON_PROPERTY_SIDE = "side";
  private String side;

  public static final String JSON_PROPERTY_STATE = "state";
  private String state;

  public static final String JSON_PROPERTY_FAILURE_CODE = "failure_code";
  private JsonNullable<String> failureCode = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_RETURN_CODE = "return_code";
  private JsonNullable<String> returnCode = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private JsonNullable<java.math.BigInteger> amount = JsonNullable.<java.math.BigInteger>undefined();

  public static final String JSON_PROPERTY_ESTIMATED_AMOUNT = "estimated_amount";
  private java.math.BigInteger estimatedAmount;

  public static final String JSON_PROPERTY_FEE = "fee";
  private java.math.BigInteger fee;

  public static final String JSON_PROPERTY_ESTIMATED_NETWORK_FEE = "estimated_network_fee";
  private JsonNullable<java.math.BigInteger> estimatedNetworkFee = JsonNullable.<java.math.BigInteger>undefined();

  public static final String JSON_PROPERTY_NETWORK_FEE = "network_fee";
  private JsonNullable<java.math.BigInteger> networkFee = JsonNullable.<java.math.BigInteger>undefined();

  public static final String JSON_PROPERTY_NETWORK_FEE_ASSET = "network_fee_asset";
  private JsonNullable<String> networkFeeAsset = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_NETWORK_FEE_LIABILITY_AMOUNT = "network_fee_liability_amount";
  private JsonNullable<java.math.BigInteger> networkFeeLiabilityAmount = JsonNullable.<java.math.BigInteger>undefined();

  public static final String JSON_PROPERTY_NETWORK_FEE_LIABILITY_AMOUNT_ASSET = "network_fee_liability_amount_asset";
  private JsonNullable<String> networkFeeLiabilityAmountAsset = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_TXN_HASH = "txn_hash";
  private JsonNullable<String> txnHash = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_REFERENCE_TRANSFER_GUID = "reference_transfer_guid";
  private JsonNullable<String> referenceTransferGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_SOURCE_ACCOUNT = "source_account";
  private JsonNullable<TransferSourceAccountBankModel> sourceAccount = JsonNullable.<TransferSourceAccountBankModel>undefined();

  public static final String JSON_PROPERTY_SOURCE_PARTICIPANTS = "source_participants";
  private JsonNullable<List<TransferParticipantBankModel>> sourceParticipants = JsonNullable.<List<TransferParticipantBankModel>>undefined();

  public static final String JSON_PROPERTY_DESTINATION_ACCOUNT = "destination_account";
  private JsonNullable<TransferDestinationAccountBankModel> destinationAccount = JsonNullable.<TransferDestinationAccountBankModel>undefined();

  public static final String JSON_PROPERTY_DESTINATION_PARTICIPANTS = "destination_participants";
  private JsonNullable<List<TransferParticipantBankModel>> destinationParticipants = JsonNullable.<List<TransferParticipantBankModel>>undefined();

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";
  private OffsetDateTime createdAt;

  public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
  private OffsetDateTime updatedAt;

  public static final String JSON_PROPERTY_TRANSFER_DETAILS = "transfer_details";
  private JsonNullable<Object> transferDetails = JsonNullable.<Object>undefined();

  public static final String JSON_PROPERTY_PAYMENT_RAIL = "payment_rail";
  private JsonNullable<String> paymentRail = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_LABELS = "labels";
  private JsonNullable<List<String>> labels = JsonNullable.<List<String>>undefined();

  public static final String JSON_PROPERTY_ENTRIES = "entries";
  private JsonNullable<List<TransferEntryBankModel>> entries = JsonNullable.<List<TransferEntryBankModel>>undefined();

  public TransferBankModel() { 
  }

  public TransferBankModel guid(String guid) {
    
    this.guid = guid;
    return this;
  }

   /**
   * Auto-generated unique identifier for the transfer.
   * @return guid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Auto-generated unique identifier for the transfer.")
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


  public TransferBankModel transferType(String transferType) {
    
    this.transferType = transferType;
    return this;
  }

   /**
   * The type of transfer; one of funding, book, crypto, instant_funding, funding_return, crypto_return, loss_recovery, inter_account, lightning, or instant_funding_return.
   * @return transferType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of transfer; one of funding, book, crypto, instant_funding, funding_return, crypto_return, loss_recovery, inter_account, lightning, or instant_funding_return.")
  @JsonProperty(JSON_PROPERTY_TRANSFER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTransferType() {
    return transferType;
  }


  @JsonProperty(JSON_PROPERTY_TRANSFER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTransferType(String transferType) {
    this.transferType = transferType;
  }


  public TransferBankModel bankGuid(String bankGuid) {
    this.bankGuid = JsonNullable.<String>of(bankGuid);
    
    return this;
  }

   /**
   * The associated bank&#39;s identifier.
   * @return bankGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The associated bank's identifier.")
  @JsonIgnore

  public String getBankGuid() {
        return bankGuid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BANK_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getBankGuid_JsonNullable() {
    return bankGuid;
  }
  
  @JsonProperty(JSON_PROPERTY_BANK_GUID)
  public void setBankGuid_JsonNullable(JsonNullable<String> bankGuid) {
    this.bankGuid = bankGuid;
  }

  public void setBankGuid(String bankGuid) {
    this.bankGuid = JsonNullable.<String>of(bankGuid);
  }


  public TransferBankModel customerGuid(String customerGuid) {
    this.customerGuid = JsonNullable.<String>of(customerGuid);
    
    return this;
  }

   /**
   * The associated customer&#39;s identifier.
   * @return customerGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The associated customer's identifier.")
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


  public TransferBankModel quoteGuid(String quoteGuid) {
    
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


  public TransferBankModel externalBankAccountGuid(String externalBankAccountGuid) {
    this.externalBankAccountGuid = JsonNullable.<String>of(externalBankAccountGuid);
    
    return this;
  }

   /**
   * The associated external bank account&#39;s identifier.
   * @return externalBankAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The associated external bank account's identifier.")
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


  public TransferBankModel asset(String asset) {
    
    this.asset = asset;
    return this;
  }

   /**
   * The asset the transfer is related to, e.g., USD.
   * @return asset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The asset the transfer is related to, e.g., USD.")
  @JsonProperty(JSON_PROPERTY_ASSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAsset() {
    return asset;
  }


  @JsonProperty(JSON_PROPERTY_ASSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAsset(String asset) {
    this.asset = asset;
  }


  public TransferBankModel side(String side) {
    
    this.side = side;
    return this;
  }

   /**
   * The direction of the quote; one of deposit or withdrawal.
   * @return side
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The direction of the quote; one of deposit or withdrawal.")
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


  public TransferBankModel state(String state) {
    
    this.state = state;
    return this;
  }

   /**
   * The state of the transfer; one of storing, pending, reviewing, completed, or failed.
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The state of the transfer; one of storing, pending, reviewing, completed, or failed.")
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(String state) {
    this.state = state;
  }


  public TransferBankModel failureCode(String failureCode) {
    this.failureCode = JsonNullable.<String>of(failureCode);
    
    return this;
  }

   /**
   * The failure code for failed transfers; one of non_sufficient_funds, refresh_required, party_name_invalid, payment_rail_invalid, compliance_rejection, cancelled, reversed, limit_exceeded, network_fee_too_low, amount_too_low, internal_error, or invalid_address.
   * @return failureCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The failure code for failed transfers; one of non_sufficient_funds, refresh_required, party_name_invalid, payment_rail_invalid, compliance_rejection, cancelled, reversed, limit_exceeded, network_fee_too_low, amount_too_low, internal_error, or invalid_address.")
  @JsonIgnore

  public String getFailureCode() {
        return failureCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FAILURE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getFailureCode_JsonNullable() {
    return failureCode;
  }
  
  @JsonProperty(JSON_PROPERTY_FAILURE_CODE)
  public void setFailureCode_JsonNullable(JsonNullable<String> failureCode) {
    this.failureCode = failureCode;
  }

  public void setFailureCode(String failureCode) {
    this.failureCode = JsonNullable.<String>of(failureCode);
  }


  public TransferBankModel returnCode(String returnCode) {
    this.returnCode = JsonNullable.<String>of(returnCode);
    
    return this;
  }

   /**
   * The return code for reversed transfers
   * @return returnCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The return code for reversed transfers")
  @JsonIgnore

  public String getReturnCode() {
        return returnCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RETURN_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getReturnCode_JsonNullable() {
    return returnCode;
  }
  
  @JsonProperty(JSON_PROPERTY_RETURN_CODE)
  public void setReturnCode_JsonNullable(JsonNullable<String> returnCode) {
    this.returnCode = returnCode;
  }

  public void setReturnCode(String returnCode) {
    this.returnCode = JsonNullable.<String>of(returnCode);
  }


  public TransferBankModel amount(java.math.BigInteger amount) {
    this.amount = JsonNullable.<java.math.BigInteger>of(amount);
    
    return this;
  }

   /**
   * The actual amount in base units of the asset.
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The actual amount in base units of the asset.")
  @JsonIgnore

  public java.math.BigInteger getAmount() {
        return amount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<java.math.BigInteger> getAmount_JsonNullable() {
    return amount;
  }
  
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  public void setAmount_JsonNullable(JsonNullable<java.math.BigInteger> amount) {
    this.amount = amount;
  }

  public void setAmount(java.math.BigInteger amount) {
    this.amount = JsonNullable.<java.math.BigInteger>of(amount);
  }


  public TransferBankModel estimatedAmount(java.math.BigInteger estimatedAmount) {
    
    this.estimatedAmount = estimatedAmount;
    return this;
  }

   /**
   * The estimated amount in base units of the asset.
   * @return estimatedAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The estimated amount in base units of the asset.")
  @JsonProperty(JSON_PROPERTY_ESTIMATED_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public java.math.BigInteger getEstimatedAmount() {
    return estimatedAmount;
  }


  @JsonProperty(JSON_PROPERTY_ESTIMATED_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEstimatedAmount(java.math.BigInteger estimatedAmount) {
    this.estimatedAmount = estimatedAmount;
  }


  public TransferBankModel fee(java.math.BigInteger fee) {
    
    this.fee = fee;
    return this;
  }

   /**
   * The fee associated with the transfer.
   * @return fee
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The fee associated with the transfer.")
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


  public TransferBankModel estimatedNetworkFee(java.math.BigInteger estimatedNetworkFee) {
    this.estimatedNetworkFee = JsonNullable.<java.math.BigInteger>of(estimatedNetworkFee);
    
    return this;
  }

   /**
   * The estimated network fee in base units of network_fee_asset. Only present on &#x60;crypto&#x60; transfers.
   * @return estimatedNetworkFee
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The estimated network fee in base units of network_fee_asset. Only present on `crypto` transfers.")
  @JsonIgnore

  public java.math.BigInteger getEstimatedNetworkFee() {
        return estimatedNetworkFee.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ESTIMATED_NETWORK_FEE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<java.math.BigInteger> getEstimatedNetworkFee_JsonNullable() {
    return estimatedNetworkFee;
  }
  
  @JsonProperty(JSON_PROPERTY_ESTIMATED_NETWORK_FEE)
  public void setEstimatedNetworkFee_JsonNullable(JsonNullable<java.math.BigInteger> estimatedNetworkFee) {
    this.estimatedNetworkFee = estimatedNetworkFee;
  }

  public void setEstimatedNetworkFee(java.math.BigInteger estimatedNetworkFee) {
    this.estimatedNetworkFee = JsonNullable.<java.math.BigInteger>of(estimatedNetworkFee);
  }


  public TransferBankModel networkFee(java.math.BigInteger networkFee) {
    this.networkFee = JsonNullable.<java.math.BigInteger>of(networkFee);
    
    return this;
  }

   /**
   * The actual network fee in base units of network_fee_asset. Only present on &#x60;crypto&#x60; transfers that have successfully completed.
   * @return networkFee
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The actual network fee in base units of network_fee_asset. Only present on `crypto` transfers that have successfully completed.")
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


  public TransferBankModel networkFeeAsset(String networkFeeAsset) {
    this.networkFeeAsset = JsonNullable.<String>of(networkFeeAsset);
    
    return this;
  }

   /**
   * The asset code of the network fee. Only present on &#x60;crypto&#x60; transfers that have successfully completed.
   * @return networkFeeAsset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The asset code of the network fee. Only present on `crypto` transfers that have successfully completed.")
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


  public TransferBankModel networkFeeLiabilityAmount(java.math.BigInteger networkFeeLiabilityAmount) {
    this.networkFeeLiabilityAmount = JsonNullable.<java.math.BigInteger>of(networkFeeLiabilityAmount);
    
    return this;
  }

   /**
   * The equivalent fiat network fee in base units of network_fee_liability_amount_asset. Only present on &#x60;crypto&#x60; transfers that have successfully completed.
   * @return networkFeeLiabilityAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The equivalent fiat network fee in base units of network_fee_liability_amount_asset. Only present on `crypto` transfers that have successfully completed.")
  @JsonIgnore

  public java.math.BigInteger getNetworkFeeLiabilityAmount() {
        return networkFeeLiabilityAmount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NETWORK_FEE_LIABILITY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<java.math.BigInteger> getNetworkFeeLiabilityAmount_JsonNullable() {
    return networkFeeLiabilityAmount;
  }
  
  @JsonProperty(JSON_PROPERTY_NETWORK_FEE_LIABILITY_AMOUNT)
  public void setNetworkFeeLiabilityAmount_JsonNullable(JsonNullable<java.math.BigInteger> networkFeeLiabilityAmount) {
    this.networkFeeLiabilityAmount = networkFeeLiabilityAmount;
  }

  public void setNetworkFeeLiabilityAmount(java.math.BigInteger networkFeeLiabilityAmount) {
    this.networkFeeLiabilityAmount = JsonNullable.<java.math.BigInteger>of(networkFeeLiabilityAmount);
  }


  public TransferBankModel networkFeeLiabilityAmountAsset(String networkFeeLiabilityAmountAsset) {
    this.networkFeeLiabilityAmountAsset = JsonNullable.<String>of(networkFeeLiabilityAmountAsset);
    
    return this;
  }

   /**
   * The fiat asset the network_fee_liability_amount is denominated in. Only present on &#x60;crypto&#x60; transfers that have successfully completed.
   * @return networkFeeLiabilityAmountAsset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The fiat asset the network_fee_liability_amount is denominated in. Only present on `crypto` transfers that have successfully completed.")
  @JsonIgnore

  public String getNetworkFeeLiabilityAmountAsset() {
        return networkFeeLiabilityAmountAsset.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NETWORK_FEE_LIABILITY_AMOUNT_ASSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getNetworkFeeLiabilityAmountAsset_JsonNullable() {
    return networkFeeLiabilityAmountAsset;
  }
  
  @JsonProperty(JSON_PROPERTY_NETWORK_FEE_LIABILITY_AMOUNT_ASSET)
  public void setNetworkFeeLiabilityAmountAsset_JsonNullable(JsonNullable<String> networkFeeLiabilityAmountAsset) {
    this.networkFeeLiabilityAmountAsset = networkFeeLiabilityAmountAsset;
  }

  public void setNetworkFeeLiabilityAmountAsset(String networkFeeLiabilityAmountAsset) {
    this.networkFeeLiabilityAmountAsset = JsonNullable.<String>of(networkFeeLiabilityAmountAsset);
  }


  public TransferBankModel txnHash(String txnHash) {
    this.txnHash = JsonNullable.<String>of(txnHash);
    
    return this;
  }

   /**
   * The hash of the blockchain transaction
   * @return txnHash
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The hash of the blockchain transaction")
  @JsonIgnore

  public String getTxnHash() {
        return txnHash.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TXN_HASH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getTxnHash_JsonNullable() {
    return txnHash;
  }
  
  @JsonProperty(JSON_PROPERTY_TXN_HASH)
  public void setTxnHash_JsonNullable(JsonNullable<String> txnHash) {
    this.txnHash = txnHash;
  }

  public void setTxnHash(String txnHash) {
    this.txnHash = JsonNullable.<String>of(txnHash);
  }


  public TransferBankModel referenceTransferGuid(String referenceTransferGuid) {
    this.referenceTransferGuid = JsonNullable.<String>of(referenceTransferGuid);
    
    return this;
  }

   /**
   * The guid of the related transfer. Only present on return type transfers.
   * @return referenceTransferGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The guid of the related transfer. Only present on return type transfers.")
  @JsonIgnore

  public String getReferenceTransferGuid() {
        return referenceTransferGuid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE_TRANSFER_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getReferenceTransferGuid_JsonNullable() {
    return referenceTransferGuid;
  }
  
  @JsonProperty(JSON_PROPERTY_REFERENCE_TRANSFER_GUID)
  public void setReferenceTransferGuid_JsonNullable(JsonNullable<String> referenceTransferGuid) {
    this.referenceTransferGuid = referenceTransferGuid;
  }

  public void setReferenceTransferGuid(String referenceTransferGuid) {
    this.referenceTransferGuid = JsonNullable.<String>of(referenceTransferGuid);
  }


  public TransferBankModel sourceAccount(TransferSourceAccountBankModel sourceAccount) {
    this.sourceAccount = JsonNullable.<TransferSourceAccountBankModel>of(sourceAccount);
    
    return this;
  }

   /**
   * Get sourceAccount
   * @return sourceAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonIgnore

  public TransferSourceAccountBankModel getSourceAccount() {
        return sourceAccount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SOURCE_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<TransferSourceAccountBankModel> getSourceAccount_JsonNullable() {
    return sourceAccount;
  }
  
  @JsonProperty(JSON_PROPERTY_SOURCE_ACCOUNT)
  public void setSourceAccount_JsonNullable(JsonNullable<TransferSourceAccountBankModel> sourceAccount) {
    this.sourceAccount = sourceAccount;
  }

  public void setSourceAccount(TransferSourceAccountBankModel sourceAccount) {
    this.sourceAccount = JsonNullable.<TransferSourceAccountBankModel>of(sourceAccount);
  }


  public TransferBankModel sourceParticipants(List<TransferParticipantBankModel> sourceParticipants) {
    this.sourceParticipants = JsonNullable.<List<TransferParticipantBankModel>>of(sourceParticipants);
    
    return this;
  }

  public TransferBankModel addSourceParticipantsItem(TransferParticipantBankModel sourceParticipantsItem) {
    if (this.sourceParticipants == null || !this.sourceParticipants.isPresent()) {
      this.sourceParticipants = JsonNullable.<List<TransferParticipantBankModel>>of(new ArrayList<>());
    }
    try {
      this.sourceParticipants.get().add(sourceParticipantsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The participants in the source account.
   * @return sourceParticipants
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The participants in the source account.")
  @JsonIgnore

  public List<TransferParticipantBankModel> getSourceParticipants() {
        return sourceParticipants.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SOURCE_PARTICIPANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<TransferParticipantBankModel>> getSourceParticipants_JsonNullable() {
    return sourceParticipants;
  }
  
  @JsonProperty(JSON_PROPERTY_SOURCE_PARTICIPANTS)
  public void setSourceParticipants_JsonNullable(JsonNullable<List<TransferParticipantBankModel>> sourceParticipants) {
    this.sourceParticipants = sourceParticipants;
  }

  public void setSourceParticipants(List<TransferParticipantBankModel> sourceParticipants) {
    this.sourceParticipants = JsonNullable.<List<TransferParticipantBankModel>>of(sourceParticipants);
  }


  public TransferBankModel destinationAccount(TransferDestinationAccountBankModel destinationAccount) {
    this.destinationAccount = JsonNullable.<TransferDestinationAccountBankModel>of(destinationAccount);
    
    return this;
  }

   /**
   * Get destinationAccount
   * @return destinationAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonIgnore

  public TransferDestinationAccountBankModel getDestinationAccount() {
        return destinationAccount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<TransferDestinationAccountBankModel> getDestinationAccount_JsonNullable() {
    return destinationAccount;
  }
  
  @JsonProperty(JSON_PROPERTY_DESTINATION_ACCOUNT)
  public void setDestinationAccount_JsonNullable(JsonNullable<TransferDestinationAccountBankModel> destinationAccount) {
    this.destinationAccount = destinationAccount;
  }

  public void setDestinationAccount(TransferDestinationAccountBankModel destinationAccount) {
    this.destinationAccount = JsonNullable.<TransferDestinationAccountBankModel>of(destinationAccount);
  }


  public TransferBankModel destinationParticipants(List<TransferParticipantBankModel> destinationParticipants) {
    this.destinationParticipants = JsonNullable.<List<TransferParticipantBankModel>>of(destinationParticipants);
    
    return this;
  }

  public TransferBankModel addDestinationParticipantsItem(TransferParticipantBankModel destinationParticipantsItem) {
    if (this.destinationParticipants == null || !this.destinationParticipants.isPresent()) {
      this.destinationParticipants = JsonNullable.<List<TransferParticipantBankModel>>of(new ArrayList<>());
    }
    try {
      this.destinationParticipants.get().add(destinationParticipantsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The participants in the source account.
   * @return destinationParticipants
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The participants in the source account.")
  @JsonIgnore

  public List<TransferParticipantBankModel> getDestinationParticipants() {
        return destinationParticipants.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION_PARTICIPANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<TransferParticipantBankModel>> getDestinationParticipants_JsonNullable() {
    return destinationParticipants;
  }
  
  @JsonProperty(JSON_PROPERTY_DESTINATION_PARTICIPANTS)
  public void setDestinationParticipants_JsonNullable(JsonNullable<List<TransferParticipantBankModel>> destinationParticipants) {
    this.destinationParticipants = destinationParticipants;
  }

  public void setDestinationParticipants(List<TransferParticipantBankModel> destinationParticipants) {
    this.destinationParticipants = JsonNullable.<List<TransferParticipantBankModel>>of(destinationParticipants);
  }


  public TransferBankModel createdAt(OffsetDateTime createdAt) {
    
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


  public TransferBankModel updatedAt(OffsetDateTime updatedAt) {
    
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


  public TransferBankModel transferDetails(Object transferDetails) {
    this.transferDetails = JsonNullable.<Object>of(transferDetails);
    
    return this;
  }

   /**
   * The raw details on the transfer from the bank.
   * @return transferDetails
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The raw details on the transfer from the bank.")
  @JsonIgnore

  public Object getTransferDetails() {
        return transferDetails.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRANSFER_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getTransferDetails_JsonNullable() {
    return transferDetails;
  }
  
  @JsonProperty(JSON_PROPERTY_TRANSFER_DETAILS)
  public void setTransferDetails_JsonNullable(JsonNullable<Object> transferDetails) {
    this.transferDetails = transferDetails;
  }

  public void setTransferDetails(Object transferDetails) {
    this.transferDetails = JsonNullable.<Object>of(transferDetails);
  }


  public TransferBankModel paymentRail(String paymentRail) {
    this.paymentRail = JsonNullable.<String>of(paymentRail);
    
    return this;
  }

   /**
   * The rail the payment was done on. One of: ach, eft, wire, rtp
   * @return paymentRail
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The rail the payment was done on. One of: ach, eft, wire, rtp")
  @JsonIgnore

  public String getPaymentRail() {
        return paymentRail.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAYMENT_RAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPaymentRail_JsonNullable() {
    return paymentRail;
  }
  
  @JsonProperty(JSON_PROPERTY_PAYMENT_RAIL)
  public void setPaymentRail_JsonNullable(JsonNullable<String> paymentRail) {
    this.paymentRail = paymentRail;
  }

  public void setPaymentRail(String paymentRail) {
    this.paymentRail = JsonNullable.<String>of(paymentRail);
  }


  public TransferBankModel labels(List<String> labels) {
    this.labels = JsonNullable.<List<String>>of(labels);
    
    return this;
  }

  public TransferBankModel addLabelsItem(String labelsItem) {
    if (this.labels == null || !this.labels.isPresent()) {
      this.labels = JsonNullable.<List<String>>of(new ArrayList<>());
    }
    try {
      this.labels.get().add(labelsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The labels associated with the transfer.
   * @return labels
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The labels associated with the transfer.")
  @JsonIgnore

  public List<String> getLabels() {
        return labels.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LABELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<String>> getLabels_JsonNullable() {
    return labels;
  }
  
  @JsonProperty(JSON_PROPERTY_LABELS)
  public void setLabels_JsonNullable(JsonNullable<List<String>> labels) {
    this.labels = labels;
  }

  public void setLabels(List<String> labels) {
    this.labels = JsonNullable.<List<String>>of(labels);
  }


  public TransferBankModel entries(List<TransferEntryBankModel> entries) {
    this.entries = JsonNullable.<List<TransferEntryBankModel>>of(entries);
    
    return this;
  }

  public TransferBankModel addEntriesItem(TransferEntryBankModel entriesItem) {
    if (this.entries == null || !this.entries.isPresent()) {
      this.entries = JsonNullable.<List<TransferEntryBankModel>>of(new ArrayList<>());
    }
    try {
      this.entries.get().add(entriesItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Transfer entries associated with the batch transfer
   * @return entries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Transfer entries associated with the batch transfer")
  @JsonIgnore

  public List<TransferEntryBankModel> getEntries() {
        return entries.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENTRIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<TransferEntryBankModel>> getEntries_JsonNullable() {
    return entries;
  }
  
  @JsonProperty(JSON_PROPERTY_ENTRIES)
  public void setEntries_JsonNullable(JsonNullable<List<TransferEntryBankModel>> entries) {
    this.entries = entries;
  }

  public void setEntries(List<TransferEntryBankModel> entries) {
    this.entries = JsonNullable.<List<TransferEntryBankModel>>of(entries);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferBankModel transfer = (TransferBankModel) o;
    return Objects.equals(this.guid, transfer.guid) &&
        Objects.equals(this.transferType, transfer.transferType) &&
        equalsNullable(this.bankGuid, transfer.bankGuid) &&
        equalsNullable(this.customerGuid, transfer.customerGuid) &&
        Objects.equals(this.quoteGuid, transfer.quoteGuid) &&
        equalsNullable(this.externalBankAccountGuid, transfer.externalBankAccountGuid) &&
        Objects.equals(this.asset, transfer.asset) &&
        Objects.equals(this.side, transfer.side) &&
        Objects.equals(this.state, transfer.state) &&
        equalsNullable(this.failureCode, transfer.failureCode) &&
        equalsNullable(this.returnCode, transfer.returnCode) &&
        equalsNullable(this.amount, transfer.amount) &&
        Objects.equals(this.estimatedAmount, transfer.estimatedAmount) &&
        Objects.equals(this.fee, transfer.fee) &&
        equalsNullable(this.estimatedNetworkFee, transfer.estimatedNetworkFee) &&
        equalsNullable(this.networkFee, transfer.networkFee) &&
        equalsNullable(this.networkFeeAsset, transfer.networkFeeAsset) &&
        equalsNullable(this.networkFeeLiabilityAmount, transfer.networkFeeLiabilityAmount) &&
        equalsNullable(this.networkFeeLiabilityAmountAsset, transfer.networkFeeLiabilityAmountAsset) &&
        equalsNullable(this.txnHash, transfer.txnHash) &&
        equalsNullable(this.referenceTransferGuid, transfer.referenceTransferGuid) &&
        equalsNullable(this.sourceAccount, transfer.sourceAccount) &&
        equalsNullable(this.sourceParticipants, transfer.sourceParticipants) &&
        equalsNullable(this.destinationAccount, transfer.destinationAccount) &&
        equalsNullable(this.destinationParticipants, transfer.destinationParticipants) &&
        Objects.equals(this.createdAt, transfer.createdAt) &&
        Objects.equals(this.updatedAt, transfer.updatedAt) &&
        equalsNullable(this.transferDetails, transfer.transferDetails) &&
        equalsNullable(this.paymentRail, transfer.paymentRail) &&
        equalsNullable(this.labels, transfer.labels) &&
        equalsNullable(this.entries, transfer.entries);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(guid, transferType, hashCodeNullable(bankGuid), hashCodeNullable(customerGuid), quoteGuid, hashCodeNullable(externalBankAccountGuid), asset, side, state, hashCodeNullable(failureCode), hashCodeNullable(returnCode), hashCodeNullable(amount), estimatedAmount, fee, hashCodeNullable(estimatedNetworkFee), hashCodeNullable(networkFee), hashCodeNullable(networkFeeAsset), hashCodeNullable(networkFeeLiabilityAmount), hashCodeNullable(networkFeeLiabilityAmountAsset), hashCodeNullable(txnHash), hashCodeNullable(referenceTransferGuid), hashCodeNullable(sourceAccount), hashCodeNullable(sourceParticipants), hashCodeNullable(destinationAccount), hashCodeNullable(destinationParticipants), createdAt, updatedAt, hashCodeNullable(transferDetails), hashCodeNullable(paymentRail), hashCodeNullable(labels), hashCodeNullable(entries));
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
    sb.append("class TransferBankModel {\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    transferType: ").append(toIndentedString(transferType)).append("\n");
    sb.append("    bankGuid: ").append(toIndentedString(bankGuid)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    quoteGuid: ").append(toIndentedString(quoteGuid)).append("\n");
    sb.append("    externalBankAccountGuid: ").append(toIndentedString(externalBankAccountGuid)).append("\n");
    sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
    sb.append("    side: ").append(toIndentedString(side)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    failureCode: ").append(toIndentedString(failureCode)).append("\n");
    sb.append("    returnCode: ").append(toIndentedString(returnCode)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    estimatedAmount: ").append(toIndentedString(estimatedAmount)).append("\n");
    sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
    sb.append("    estimatedNetworkFee: ").append(toIndentedString(estimatedNetworkFee)).append("\n");
    sb.append("    networkFee: ").append(toIndentedString(networkFee)).append("\n");
    sb.append("    networkFeeAsset: ").append(toIndentedString(networkFeeAsset)).append("\n");
    sb.append("    networkFeeLiabilityAmount: ").append(toIndentedString(networkFeeLiabilityAmount)).append("\n");
    sb.append("    networkFeeLiabilityAmountAsset: ").append(toIndentedString(networkFeeLiabilityAmountAsset)).append("\n");
    sb.append("    txnHash: ").append(toIndentedString(txnHash)).append("\n");
    sb.append("    referenceTransferGuid: ").append(toIndentedString(referenceTransferGuid)).append("\n");
    sb.append("    sourceAccount: ").append(toIndentedString(sourceAccount)).append("\n");
    sb.append("    sourceParticipants: ").append(toIndentedString(sourceParticipants)).append("\n");
    sb.append("    destinationAccount: ").append(toIndentedString(destinationAccount)).append("\n");
    sb.append("    destinationParticipants: ").append(toIndentedString(destinationParticipants)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    transferDetails: ").append(toIndentedString(transferDetails)).append("\n");
    sb.append("    paymentRail: ").append(toIndentedString(paymentRail)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    entries: ").append(toIndentedString(entries)).append("\n");
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


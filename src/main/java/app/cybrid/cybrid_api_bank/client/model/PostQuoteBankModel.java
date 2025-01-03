/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Introduction](https://docs.cybrid.xyz/docs/introduction) 2. [Platform Introduction](https://docs.cybrid.xyz/docs/how-is-cybrid-architected) 3. [Testing with Hosted Web Demo App](https://docs.cybrid.xyz/docs/testing-with-hosted-web-demo-app)  In [Getting Started in the Cybrid Sandbox](https://docs.cybrid.xyz/docs/how-do-i-get-started-with-the-sandbox), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.production.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:write counterparties:execute customers:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read external_bank_accounts:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:write identity_verifications:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read customers:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:execute external_bank_accounts:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               | | Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |  ## Available Endpoints  The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create and list organization users                                                                | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             | | Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.123.120
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.model;

import java.util.Objects;
import java.util.Arrays;
import app.cybrid.cybrid_api_bank.client.model.PostFeeBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostQuoteEntryBankModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Request body for quote creation.
 */
@ApiModel(description = "Request body for quote creation.")
@JsonPropertyOrder({
  PostQuoteBankModel.JSON_PROPERTY_PRODUCT_TYPE,
  PostQuoteBankModel.JSON_PROPERTY_BANK_GUID,
  PostQuoteBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  PostQuoteBankModel.JSON_PROPERTY_RECEIVE_AMOUNT,
  PostQuoteBankModel.JSON_PROPERTY_DELIVER_AMOUNT,
  PostQuoteBankModel.JSON_PROPERTY_ASSET,
  PostQuoteBankModel.JSON_PROPERTY_NETWORK_ADDRESS,
  PostQuoteBankModel.JSON_PROPERTY_FEES,
  PostQuoteBankModel.JSON_PROPERTY_SIDE,
  PostQuoteBankModel.JSON_PROPERTY_SYMBOL,
  PostQuoteBankModel.JSON_PROPERTY_DESTINATION_ACCOUNTS,
  PostQuoteBankModel.JSON_PROPERTY_REFERENCE_TRADE_GUID,
  PostQuoteBankModel.JSON_PROPERTY_SOURCE_ACCOUNT_GUID,
  PostQuoteBankModel.JSON_PROPERTY_DESTINATION_ACCOUNT_GUID
})
@JsonTypeName("PostQuote")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-01-03T22:56:28.101729Z[Etc/UTC]")
public class PostQuoteBankModel {
  /**
   * The type of product the quote is for.
   */
  public enum ProductTypeEnum {
    TRADING("trading"),
    
    TRADING_EXIT("trading_exit"),
    
    FUNDING("funding"),
    
    BOOK_TRANSFER("book_transfer"),
    
    CRYPTO_TRANSFER("crypto_transfer"),
    
    INTER_ACCOUNT("inter_account"),
    
    LIGHTNING_TRANSFER("lightning_transfer");

    private String value;

    ProductTypeEnum(String value) {
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
    public static ProductTypeEnum fromValue(String value) {
      for (ProductTypeEnum b : ProductTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  public static final String JSON_PROPERTY_PRODUCT_TYPE = "product_type";
  private JsonNullable<ProductTypeEnum> productType = JsonNullable.<ProductTypeEnum>of(ProductTypeEnum.TRADING);

  public static final String JSON_PROPERTY_BANK_GUID = "bank_guid";
  private JsonNullable<String> bankGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private JsonNullable<String> customerGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_RECEIVE_AMOUNT = "receive_amount";
  private JsonNullable<java.math.BigInteger> receiveAmount = JsonNullable.<java.math.BigInteger>undefined();

  public static final String JSON_PROPERTY_DELIVER_AMOUNT = "deliver_amount";
  private JsonNullable<java.math.BigInteger> deliverAmount = JsonNullable.<java.math.BigInteger>undefined();

  public static final String JSON_PROPERTY_ASSET = "asset";
  private JsonNullable<String> asset = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_NETWORK_ADDRESS = "network_address";
  private JsonNullable<String> networkAddress = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_FEES = "fees";
  private JsonNullable<List<PostFeeBankModel>> fees = JsonNullable.<List<PostFeeBankModel>>undefined();

  /**
   * The direction for trade quotes: either &#39;buy&#39; or &#39;sell&#39;. The direction for funding quotes: either &#39;deposit&#39; or &#39;withdrawal&#39;. The direction for crypto transfer quotes: &#39;withdrawal&#39;. Book transfers do not require a side. They are all &#39;deposit&#39;s.  Required when product_type is funding, product_type is trading, or product_type is crypto_transfer.
   */
  public enum SideEnum {
    DEPOSIT("deposit"),
    
    WITHDRAWAL("withdrawal"),
    
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
      return null;
    }
  }

  public static final String JSON_PROPERTY_SIDE = "side";
  private JsonNullable<SideEnum> side = JsonNullable.<SideEnum>undefined();

  public static final String JSON_PROPERTY_SYMBOL = "symbol";
  private JsonNullable<String> symbol = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_DESTINATION_ACCOUNTS = "destination_accounts";
  private JsonNullable<List<PostQuoteEntryBankModel>> destinationAccounts = JsonNullable.<List<PostQuoteEntryBankModel>>undefined();

  public static final String JSON_PROPERTY_REFERENCE_TRADE_GUID = "reference_trade_guid";
  private JsonNullable<String> referenceTradeGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_SOURCE_ACCOUNT_GUID = "source_account_guid";
  private JsonNullable<String> sourceAccountGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_DESTINATION_ACCOUNT_GUID = "destination_account_guid";
  private JsonNullable<String> destinationAccountGuid = JsonNullable.<String>undefined();

  public PostQuoteBankModel() { 
  }

  public PostQuoteBankModel productType(ProductTypeEnum productType) {
    this.productType = JsonNullable.<ProductTypeEnum>of(productType);
    
    return this;
  }

   /**
   * The type of product the quote is for.
   * @return productType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of product the quote is for.")
  @JsonIgnore

  public ProductTypeEnum getProductType() {
        return productType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PRODUCT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<ProductTypeEnum> getProductType_JsonNullable() {
    return productType;
  }
  
  @JsonProperty(JSON_PROPERTY_PRODUCT_TYPE)
  public void setProductType_JsonNullable(JsonNullable<ProductTypeEnum> productType) {
    this.productType = productType;
  }

  public void setProductType(ProductTypeEnum productType) {
    this.productType = JsonNullable.<ProductTypeEnum>of(productType);
  }


  public PostQuoteBankModel bankGuid(String bankGuid) {
    this.bankGuid = JsonNullable.<String>of(bankGuid);
    
    return this;
  }

   /**
   * The unique identifier for the bank.
   * @return bankGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identifier for the bank.")
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


  public PostQuoteBankModel customerGuid(String customerGuid) {
    this.customerGuid = JsonNullable.<String>of(customerGuid);
    
    return this;
  }

   /**
   * The unique identifier for the customer.
   * @return customerGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identifier for the customer.")
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


  public PostQuoteBankModel receiveAmount(java.math.BigInteger receiveAmount) {
    this.receiveAmount = JsonNullable.<java.math.BigInteger>of(receiveAmount);
    
    return this;
  }

   /**
   * The amount to be received in base units of the currency: currency is \&quot;asset\&quot; for buy and \&quot;counter_asset\&quot; for sell for trade quotes.
   * @return receiveAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount to be received in base units of the currency: currency is \"asset\" for buy and \"counter_asset\" for sell for trade quotes.")
  @JsonIgnore

  public java.math.BigInteger getReceiveAmount() {
        return receiveAmount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECEIVE_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<java.math.BigInteger> getReceiveAmount_JsonNullable() {
    return receiveAmount;
  }
  
  @JsonProperty(JSON_PROPERTY_RECEIVE_AMOUNT)
  public void setReceiveAmount_JsonNullable(JsonNullable<java.math.BigInteger> receiveAmount) {
    this.receiveAmount = receiveAmount;
  }

  public void setReceiveAmount(java.math.BigInteger receiveAmount) {
    this.receiveAmount = JsonNullable.<java.math.BigInteger>of(receiveAmount);
  }


  public PostQuoteBankModel deliverAmount(java.math.BigInteger deliverAmount) {
    this.deliverAmount = JsonNullable.<java.math.BigInteger>of(deliverAmount);
    
    return this;
  }

   /**
   * The amount to be delivered in base units of the currency: currency is \&quot;counter_asset\&quot; for buy and \&quot;asset\&quot; for sell for trade quotes.
   * @return deliverAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount to be delivered in base units of the currency: currency is \"counter_asset\" for buy and \"asset\" for sell for trade quotes.")
  @JsonIgnore

  public java.math.BigInteger getDeliverAmount() {
        return deliverAmount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DELIVER_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<java.math.BigInteger> getDeliverAmount_JsonNullable() {
    return deliverAmount;
  }
  
  @JsonProperty(JSON_PROPERTY_DELIVER_AMOUNT)
  public void setDeliverAmount_JsonNullable(JsonNullable<java.math.BigInteger> deliverAmount) {
    this.deliverAmount = deliverAmount;
  }

  public void setDeliverAmount(java.math.BigInteger deliverAmount) {
    this.deliverAmount = JsonNullable.<java.math.BigInteger>of(deliverAmount);
  }


  public PostQuoteBankModel asset(String asset) {
    this.asset = JsonNullable.<String>of(asset);
    
    return this;
  }

   /**
   * The asset code the quote was requested for. Required when product_type is lightning_transfer, product_type is book_transfer, product_type is funding, product_type is crypto_transfer, or product_type is inter_account.
   * @return asset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The asset code the quote was requested for. Required when product_type is lightning_transfer, product_type is book_transfer, product_type is funding, product_type is crypto_transfer, or product_type is inter_account.")
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


  public PostQuoteBankModel networkAddress(String networkAddress) {
    this.networkAddress = JsonNullable.<String>of(networkAddress);
    
    return this;
  }

   /**
   * The network address to pay the invoice to. Required when product_type is lightning_transfer.
   * @return networkAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The network address to pay the invoice to. Required when product_type is lightning_transfer.")
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


  public PostQuoteBankModel fees(List<PostFeeBankModel> fees) {
    this.fees = JsonNullable.<List<PostFeeBankModel>>of(fees);
    
    return this;
  }

  public PostQuoteBankModel addFeesItem(PostFeeBankModel feesItem) {
    if (this.fees == null || !this.fees.isPresent()) {
      this.fees = JsonNullable.<List<PostFeeBankModel>>of(new ArrayList<>());
    }
    try {
      this.fees.get().add(feesItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The custom fees associated with the quote Optional when product_type is lightning_transfer, product_type is funding, product_type is trading, product_type is crypto_transfer, or product_type is trading_exit.
   * @return fees
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The custom fees associated with the quote Optional when product_type is lightning_transfer, product_type is funding, product_type is trading, product_type is crypto_transfer, or product_type is trading_exit.")
  @JsonIgnore

  public List<PostFeeBankModel> getFees() {
        return fees.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FEES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<PostFeeBankModel>> getFees_JsonNullable() {
    return fees;
  }
  
  @JsonProperty(JSON_PROPERTY_FEES)
  public void setFees_JsonNullable(JsonNullable<List<PostFeeBankModel>> fees) {
    this.fees = fees;
  }

  public void setFees(List<PostFeeBankModel> fees) {
    this.fees = JsonNullable.<List<PostFeeBankModel>>of(fees);
  }


  public PostQuoteBankModel side(SideEnum side) {
    this.side = JsonNullable.<SideEnum>of(side);
    
    return this;
  }

   /**
   * The direction for trade quotes: either &#39;buy&#39; or &#39;sell&#39;. The direction for funding quotes: either &#39;deposit&#39; or &#39;withdrawal&#39;. The direction for crypto transfer quotes: &#39;withdrawal&#39;. Book transfers do not require a side. They are all &#39;deposit&#39;s.  Required when product_type is funding, product_type is trading, or product_type is crypto_transfer.
   * @return side
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The direction for trade quotes: either 'buy' or 'sell'. The direction for funding quotes: either 'deposit' or 'withdrawal'. The direction for crypto transfer quotes: 'withdrawal'. Book transfers do not require a side. They are all 'deposit's.  Required when product_type is funding, product_type is trading, or product_type is crypto_transfer.")
  @JsonIgnore

  public SideEnum getSide() {
        return side.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SIDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<SideEnum> getSide_JsonNullable() {
    return side;
  }
  
  @JsonProperty(JSON_PROPERTY_SIDE)
  public void setSide_JsonNullable(JsonNullable<SideEnum> side) {
    this.side = side;
  }

  public void setSide(SideEnum side) {
    this.side = JsonNullable.<SideEnum>of(side);
  }


  public PostQuoteBankModel symbol(String symbol) {
    this.symbol = JsonNullable.<String>of(symbol);
    
    return this;
  }

   /**
   * Symbol the quote is being requested for. Format is \&quot;asset-counter_asset\&quot; in uppercase. See the Symbols API for a complete list of cryptocurrencies supported.  Required when product_type is trading.
   * @return symbol
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Symbol the quote is being requested for. Format is \"asset-counter_asset\" in uppercase. See the Symbols API for a complete list of cryptocurrencies supported.  Required when product_type is trading.")
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


  public PostQuoteBankModel destinationAccounts(List<PostQuoteEntryBankModel> destinationAccounts) {
    this.destinationAccounts = JsonNullable.<List<PostQuoteEntryBankModel>>of(destinationAccounts);
    
    return this;
  }

  public PostQuoteBankModel addDestinationAccountsItem(PostQuoteEntryBankModel destinationAccountsItem) {
    if (this.destinationAccounts == null || !this.destinationAccounts.isPresent()) {
      this.destinationAccounts = JsonNullable.<List<PostQuoteEntryBankModel>>of(new ArrayList<>());
    }
    try {
      this.destinationAccounts.get().add(destinationAccountsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Destination accounts for batch transactions Optional when product_type is crypto_transfer.
   * @return destinationAccounts
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Destination accounts for batch transactions Optional when product_type is crypto_transfer.")
  @JsonIgnore

  public List<PostQuoteEntryBankModel> getDestinationAccounts() {
        return destinationAccounts.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION_ACCOUNTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<PostQuoteEntryBankModel>> getDestinationAccounts_JsonNullable() {
    return destinationAccounts;
  }
  
  @JsonProperty(JSON_PROPERTY_DESTINATION_ACCOUNTS)
  public void setDestinationAccounts_JsonNullable(JsonNullable<List<PostQuoteEntryBankModel>> destinationAccounts) {
    this.destinationAccounts = destinationAccounts;
  }

  public void setDestinationAccounts(List<PostQuoteEntryBankModel> destinationAccounts) {
    this.destinationAccounts = JsonNullable.<List<PostQuoteEntryBankModel>>of(destinationAccounts);
  }


  public PostQuoteBankModel referenceTradeGuid(String referenceTradeGuid) {
    this.referenceTradeGuid = JsonNullable.<String>of(referenceTradeGuid);
    
    return this;
  }

   /**
   * The guid of the related trade. Only present on &#x60;exit&#x60; trades. Required when product_type is trading_exit.
   * @return referenceTradeGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The guid of the related trade. Only present on `exit` trades. Required when product_type is trading_exit.")
  @JsonIgnore

  public String getReferenceTradeGuid() {
        return referenceTradeGuid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE_TRADE_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getReferenceTradeGuid_JsonNullable() {
    return referenceTradeGuid;
  }
  
  @JsonProperty(JSON_PROPERTY_REFERENCE_TRADE_GUID)
  public void setReferenceTradeGuid_JsonNullable(JsonNullable<String> referenceTradeGuid) {
    this.referenceTradeGuid = referenceTradeGuid;
  }

  public void setReferenceTradeGuid(String referenceTradeGuid) {
    this.referenceTradeGuid = JsonNullable.<String>of(referenceTradeGuid);
  }


  public PostQuoteBankModel sourceAccountGuid(String sourceAccountGuid) {
    this.sourceAccountGuid = JsonNullable.<String>of(sourceAccountGuid);
    
    return this;
  }

   /**
   * The source account&#39;s identifier. Required when product_type is inter_account.
   * @return sourceAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The source account's identifier. Required when product_type is inter_account.")
  @JsonIgnore

  public String getSourceAccountGuid() {
        return sourceAccountGuid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SOURCE_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getSourceAccountGuid_JsonNullable() {
    return sourceAccountGuid;
  }
  
  @JsonProperty(JSON_PROPERTY_SOURCE_ACCOUNT_GUID)
  public void setSourceAccountGuid_JsonNullable(JsonNullable<String> sourceAccountGuid) {
    this.sourceAccountGuid = sourceAccountGuid;
  }

  public void setSourceAccountGuid(String sourceAccountGuid) {
    this.sourceAccountGuid = JsonNullable.<String>of(sourceAccountGuid);
  }


  public PostQuoteBankModel destinationAccountGuid(String destinationAccountGuid) {
    this.destinationAccountGuid = JsonNullable.<String>of(destinationAccountGuid);
    
    return this;
  }

   /**
   * The destination account&#39;s identifier. Required when product_type is inter_account.
   * @return destinationAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The destination account's identifier. Required when product_type is inter_account.")
  @JsonIgnore

  public String getDestinationAccountGuid() {
        return destinationAccountGuid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getDestinationAccountGuid_JsonNullable() {
    return destinationAccountGuid;
  }
  
  @JsonProperty(JSON_PROPERTY_DESTINATION_ACCOUNT_GUID)
  public void setDestinationAccountGuid_JsonNullable(JsonNullable<String> destinationAccountGuid) {
    this.destinationAccountGuid = destinationAccountGuid;
  }

  public void setDestinationAccountGuid(String destinationAccountGuid) {
    this.destinationAccountGuid = JsonNullable.<String>of(destinationAccountGuid);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostQuoteBankModel postQuote = (PostQuoteBankModel) o;
    return equalsNullable(this.productType, postQuote.productType) &&
        equalsNullable(this.bankGuid, postQuote.bankGuid) &&
        equalsNullable(this.customerGuid, postQuote.customerGuid) &&
        equalsNullable(this.receiveAmount, postQuote.receiveAmount) &&
        equalsNullable(this.deliverAmount, postQuote.deliverAmount) &&
        equalsNullable(this.asset, postQuote.asset) &&
        equalsNullable(this.networkAddress, postQuote.networkAddress) &&
        equalsNullable(this.fees, postQuote.fees) &&
        equalsNullable(this.side, postQuote.side) &&
        equalsNullable(this.symbol, postQuote.symbol) &&
        equalsNullable(this.destinationAccounts, postQuote.destinationAccounts) &&
        equalsNullable(this.referenceTradeGuid, postQuote.referenceTradeGuid) &&
        equalsNullable(this.sourceAccountGuid, postQuote.sourceAccountGuid) &&
        equalsNullable(this.destinationAccountGuid, postQuote.destinationAccountGuid);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(productType), hashCodeNullable(bankGuid), hashCodeNullable(customerGuid), hashCodeNullable(receiveAmount), hashCodeNullable(deliverAmount), hashCodeNullable(asset), hashCodeNullable(networkAddress), hashCodeNullable(fees), hashCodeNullable(side), hashCodeNullable(symbol), hashCodeNullable(destinationAccounts), hashCodeNullable(referenceTradeGuid), hashCodeNullable(sourceAccountGuid), hashCodeNullable(destinationAccountGuid));
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
    sb.append("class PostQuoteBankModel {\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    bankGuid: ").append(toIndentedString(bankGuid)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    receiveAmount: ").append(toIndentedString(receiveAmount)).append("\n");
    sb.append("    deliverAmount: ").append(toIndentedString(deliverAmount)).append("\n");
    sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
    sb.append("    networkAddress: ").append(toIndentedString(networkAddress)).append("\n");
    sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
    sb.append("    side: ").append(toIndentedString(side)).append("\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
    sb.append("    destinationAccounts: ").append(toIndentedString(destinationAccounts)).append("\n");
    sb.append("    referenceTradeGuid: ").append(toIndentedString(referenceTradeGuid)).append("\n");
    sb.append("    sourceAccountGuid: ").append(toIndentedString(sourceAccountGuid)).append("\n");
    sb.append("    destinationAccountGuid: ").append(toIndentedString(destinationAccountGuid)).append("\n");
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


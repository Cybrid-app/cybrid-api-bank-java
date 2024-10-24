/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Introduction](https://docs.cybrid.xyz/docs/introduction) 2. [Platform Introduction](https://docs.cybrid.xyz/docs/how-is-cybrid-architected) 3. [Testing with Hosted Web Demo App](https://docs.cybrid.xyz/docs/testing-with-hosted-web-demo-app)  In [Getting Started in the Cybrid Sandbox](https://docs.cybrid.xyz/docs/how-do-i-get-started-with-the-sandbox), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.production.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:write counterparties:execute customers:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read external_bank_accounts:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:write identity_verifications:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read customers:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:execute external_bank_accounts:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               | | Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |  ## Available Endpoints  The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create and list organization users                                                                | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             | | Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.121.43
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.model;

import java.util.Objects;
import java.util.Arrays;
import app.cybrid.cybrid_api_bank.client.model.PostTransferParticipantBankModel;
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
 * Request body for transfer creation.
 */
@ApiModel(description = "Request body for transfer creation.")
@JsonPropertyOrder({
  PostTransferBankModel.JSON_PROPERTY_QUOTE_GUID,
  PostTransferBankModel.JSON_PROPERTY_TRANSFER_TYPE,
  PostTransferBankModel.JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID,
  PostTransferBankModel.JSON_PROPERTY_FIAT_ACCOUNT_GUID,
  PostTransferBankModel.JSON_PROPERTY_SEND_AS_DEPOSIT_BANK_ACCOUNT_GUID,
  PostTransferBankModel.JSON_PROPERTY_PAYMENT_RAIL,
  PostTransferBankModel.JSON_PROPERTY_BENEFICIARY_MEMO,
  PostTransferBankModel.JSON_PROPERTY_SOURCE_PARTICIPANTS,
  PostTransferBankModel.JSON_PROPERTY_DESTINATION_PARTICIPANTS,
  PostTransferBankModel.JSON_PROPERTY_BANK_FIAT_ACCOUNT_GUID,
  PostTransferBankModel.JSON_PROPERTY_CUSTOMER_FIAT_ACCOUNT_GUID,
  PostTransferBankModel.JSON_PROPERTY_SOURCE_ACCOUNT_GUID,
  PostTransferBankModel.JSON_PROPERTY_DESTINATION_ACCOUNT_GUID,
  PostTransferBankModel.JSON_PROPERTY_EXTERNAL_WALLET_GUID,
  PostTransferBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  PostTransferBankModel.JSON_PROPERTY_NETWORK_FEE_ACCOUNT_GUID,
  PostTransferBankModel.JSON_PROPERTY_EXPECTED_BEHAVIOURS,
  PostTransferBankModel.JSON_PROPERTY_LABELS
})
@JsonTypeName("PostTransfer")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-10-24T21:40:38.997025Z[Etc/UTC]")
public class PostTransferBankModel {
  public static final String JSON_PROPERTY_QUOTE_GUID = "quote_guid";
  private String quoteGuid;

  /**
   * The type of transfer.
   */
  public enum TransferTypeEnum {
    FUNDING("funding"),
    
    BOOK("book"),
    
    CRYPTO("crypto"),
    
    INSTANT_FUNDING("instant_funding"),
    
    INTER_ACCOUNT("inter_account"),
    
    LIGHTNING("lightning");

    private String value;

    TransferTypeEnum(String value) {
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
    public static TransferTypeEnum fromValue(String value) {
      for (TransferTypeEnum b : TransferTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TRANSFER_TYPE = "transfer_type";
  private TransferTypeEnum transferType;

  public static final String JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID = "external_bank_account_guid";
  private String externalBankAccountGuid;

  public static final String JSON_PROPERTY_FIAT_ACCOUNT_GUID = "fiat_account_guid";
  private String fiatAccountGuid;

  public static final String JSON_PROPERTY_SEND_AS_DEPOSIT_BANK_ACCOUNT_GUID = "send_as_deposit_bank_account_guid";
  private String sendAsDepositBankAccountGuid;

  /**
   * The desired payment rail to initiate the transfer for. Optional when transfer_type is funding.
   */
  public enum PaymentRailEnum {
    ACH("ach"),
    
    EFT("eft"),
    
    WIRE("wire"),
    
    RTP("rtp");

    private String value;

    PaymentRailEnum(String value) {
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
    public static PaymentRailEnum fromValue(String value) {
      for (PaymentRailEnum b : PaymentRailEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  public static final String JSON_PROPERTY_PAYMENT_RAIL = "payment_rail";
  private PaymentRailEnum paymentRail;

  public static final String JSON_PROPERTY_BENEFICIARY_MEMO = "beneficiary_memo";
  private String beneficiaryMemo;

  public static final String JSON_PROPERTY_SOURCE_PARTICIPANTS = "source_participants";
  private List<PostTransferParticipantBankModel> sourceParticipants = null;

  public static final String JSON_PROPERTY_DESTINATION_PARTICIPANTS = "destination_participants";
  private List<PostTransferParticipantBankModel> destinationParticipants = null;

  public static final String JSON_PROPERTY_BANK_FIAT_ACCOUNT_GUID = "bank_fiat_account_guid";
  private String bankFiatAccountGuid;

  public static final String JSON_PROPERTY_CUSTOMER_FIAT_ACCOUNT_GUID = "customer_fiat_account_guid";
  private String customerFiatAccountGuid;

  public static final String JSON_PROPERTY_SOURCE_ACCOUNT_GUID = "source_account_guid";
  private String sourceAccountGuid;

  public static final String JSON_PROPERTY_DESTINATION_ACCOUNT_GUID = "destination_account_guid";
  private String destinationAccountGuid;

  public static final String JSON_PROPERTY_EXTERNAL_WALLET_GUID = "external_wallet_guid";
  private String externalWalletGuid;

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private String customerGuid;

  public static final String JSON_PROPERTY_NETWORK_FEE_ACCOUNT_GUID = "network_fee_account_guid";
  private String networkFeeAccountGuid;

  /**
   * Gets or Sets expectedBehaviours
   */
  public enum ExpectedBehavioursEnum {
    FORCE_REVIEW("force_review");

    private String value;

    ExpectedBehavioursEnum(String value) {
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
    public static ExpectedBehavioursEnum fromValue(String value) {
      for (ExpectedBehavioursEnum b : ExpectedBehavioursEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_EXPECTED_BEHAVIOURS = "expected_behaviours";
  private List<ExpectedBehavioursEnum> expectedBehaviours = null;

  public static final String JSON_PROPERTY_LABELS = "labels";
  private List<String> labels = null;

  public PostTransferBankModel() { 
  }

  public PostTransferBankModel quoteGuid(String quoteGuid) {
    
    this.quoteGuid = quoteGuid;
    return this;
  }

   /**
   * The associated quote&#39;s identifier.
   * @return quoteGuid
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The associated quote's identifier.")
  @JsonProperty(JSON_PROPERTY_QUOTE_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getQuoteGuid() {
    return quoteGuid;
  }


  @JsonProperty(JSON_PROPERTY_QUOTE_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setQuoteGuid(String quoteGuid) {
    this.quoteGuid = quoteGuid;
  }


  public PostTransferBankModel transferType(TransferTypeEnum transferType) {
    
    this.transferType = transferType;
    return this;
  }

   /**
   * The type of transfer.
   * @return transferType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The type of transfer.")
  @JsonProperty(JSON_PROPERTY_TRANSFER_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TransferTypeEnum getTransferType() {
    return transferType;
  }


  @JsonProperty(JSON_PROPERTY_TRANSFER_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTransferType(TransferTypeEnum transferType) {
    this.transferType = transferType;
  }


  public PostTransferBankModel externalBankAccountGuid(String externalBankAccountGuid) {
    
    this.externalBankAccountGuid = externalBankAccountGuid;
    return this;
  }

   /**
   * The customer&#39;s &#39;plaid&#39; or &#39;plaid_processor_token&#39; external bank account&#39;s identifier. Required when transfer_type is funding or transfer_type is instant_funding.
   * @return externalBankAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's 'plaid' or 'plaid_processor_token' external bank account's identifier. Required when transfer_type is funding or transfer_type is instant_funding.")
  @JsonProperty(JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExternalBankAccountGuid() {
    return externalBankAccountGuid;
  }


  @JsonProperty(JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExternalBankAccountGuid(String externalBankAccountGuid) {
    this.externalBankAccountGuid = externalBankAccountGuid;
  }


  public PostTransferBankModel fiatAccountGuid(String fiatAccountGuid) {
    
    this.fiatAccountGuid = fiatAccountGuid;
    return this;
  }

   /**
   * The identifier for the fiat account to use for the transfer. Required if the customer or bank has multiple fiat accounts. Optional when transfer_type is funding.
   * @return fiatAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identifier for the fiat account to use for the transfer. Required if the customer or bank has multiple fiat accounts. Optional when transfer_type is funding.")
  @JsonProperty(JSON_PROPERTY_FIAT_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFiatAccountGuid() {
    return fiatAccountGuid;
  }


  @JsonProperty(JSON_PROPERTY_FIAT_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFiatAccountGuid(String fiatAccountGuid) {
    this.fiatAccountGuid = fiatAccountGuid;
  }


  public PostTransferBankModel sendAsDepositBankAccountGuid(String sendAsDepositBankAccountGuid) {
    
    this.sendAsDepositBankAccountGuid = sendAsDepositBankAccountGuid;
    return this;
  }

   /**
   * The deposit bank account&#39;s identifier. Only valid for withdrawals. The deposit bank account must be owned by the customer or bank initiating the transfer. Optional when transfer_type is funding.
   * @return sendAsDepositBankAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The deposit bank account's identifier. Only valid for withdrawals. The deposit bank account must be owned by the customer or bank initiating the transfer. Optional when transfer_type is funding.")
  @JsonProperty(JSON_PROPERTY_SEND_AS_DEPOSIT_BANK_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSendAsDepositBankAccountGuid() {
    return sendAsDepositBankAccountGuid;
  }


  @JsonProperty(JSON_PROPERTY_SEND_AS_DEPOSIT_BANK_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSendAsDepositBankAccountGuid(String sendAsDepositBankAccountGuid) {
    this.sendAsDepositBankAccountGuid = sendAsDepositBankAccountGuid;
  }


  public PostTransferBankModel paymentRail(PaymentRailEnum paymentRail) {
    
    this.paymentRail = paymentRail;
    return this;
  }

   /**
   * The desired payment rail to initiate the transfer for. Optional when transfer_type is funding.
   * @return paymentRail
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The desired payment rail to initiate the transfer for. Optional when transfer_type is funding.")
  @JsonProperty(JSON_PROPERTY_PAYMENT_RAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PaymentRailEnum getPaymentRail() {
    return paymentRail;
  }


  @JsonProperty(JSON_PROPERTY_PAYMENT_RAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaymentRail(PaymentRailEnum paymentRail) {
    this.paymentRail = paymentRail;
  }


  public PostTransferBankModel beneficiaryMemo(String beneficiaryMemo) {
    
    this.beneficiaryMemo = beneficiaryMemo;
    return this;
  }

   /**
   * The memo to send to the counterparty. Optional when transfer_type is funding.
   * @return beneficiaryMemo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The memo to send to the counterparty. Optional when transfer_type is funding.")
  @JsonProperty(JSON_PROPERTY_BENEFICIARY_MEMO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBeneficiaryMemo() {
    return beneficiaryMemo;
  }


  @JsonProperty(JSON_PROPERTY_BENEFICIARY_MEMO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBeneficiaryMemo(String beneficiaryMemo) {
    this.beneficiaryMemo = beneficiaryMemo;
  }


  public PostTransferBankModel sourceParticipants(List<PostTransferParticipantBankModel> sourceParticipants) {
    
    this.sourceParticipants = sourceParticipants;
    return this;
  }

  public PostTransferBankModel addSourceParticipantsItem(PostTransferParticipantBankModel sourceParticipantsItem) {
    if (this.sourceParticipants == null) {
      this.sourceParticipants = new ArrayList<>();
    }
    this.sourceParticipants.add(sourceParticipantsItem);
    return this;
  }

   /**
   * The source participants for the transfer. Optional when transfer_type is funding, transfer_type is instant_funding, transfer_type is book, transfer_type is crypto, or transfer_type is lightning.
   * @return sourceParticipants
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The source participants for the transfer. Optional when transfer_type is funding, transfer_type is instant_funding, transfer_type is book, transfer_type is crypto, or transfer_type is lightning.")
  @JsonProperty(JSON_PROPERTY_SOURCE_PARTICIPANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PostTransferParticipantBankModel> getSourceParticipants() {
    return sourceParticipants;
  }


  @JsonProperty(JSON_PROPERTY_SOURCE_PARTICIPANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSourceParticipants(List<PostTransferParticipantBankModel> sourceParticipants) {
    this.sourceParticipants = sourceParticipants;
  }


  public PostTransferBankModel destinationParticipants(List<PostTransferParticipantBankModel> destinationParticipants) {
    
    this.destinationParticipants = destinationParticipants;
    return this;
  }

  public PostTransferBankModel addDestinationParticipantsItem(PostTransferParticipantBankModel destinationParticipantsItem) {
    if (this.destinationParticipants == null) {
      this.destinationParticipants = new ArrayList<>();
    }
    this.destinationParticipants.add(destinationParticipantsItem);
    return this;
  }

   /**
   * The destination participants for the transfer. Optional when transfer_type is funding, transfer_type is instant_funding, transfer_type is book, transfer_type is crypto, or transfer_type is lightning.
   * @return destinationParticipants
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The destination participants for the transfer. Optional when transfer_type is funding, transfer_type is instant_funding, transfer_type is book, transfer_type is crypto, or transfer_type is lightning.")
  @JsonProperty(JSON_PROPERTY_DESTINATION_PARTICIPANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PostTransferParticipantBankModel> getDestinationParticipants() {
    return destinationParticipants;
  }


  @JsonProperty(JSON_PROPERTY_DESTINATION_PARTICIPANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDestinationParticipants(List<PostTransferParticipantBankModel> destinationParticipants) {
    this.destinationParticipants = destinationParticipants;
  }


  public PostTransferBankModel bankFiatAccountGuid(String bankFiatAccountGuid) {
    
    this.bankFiatAccountGuid = bankFiatAccountGuid;
    return this;
  }

   /**
   * The identifier for the fiat account to use for the transfer. Required if the bank has multiple fiat accounts. Optional when transfer_type is instant_funding or transfer_type is lightning.
   * @return bankFiatAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identifier for the fiat account to use for the transfer. Required if the bank has multiple fiat accounts. Optional when transfer_type is instant_funding or transfer_type is lightning.")
  @JsonProperty(JSON_PROPERTY_BANK_FIAT_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBankFiatAccountGuid() {
    return bankFiatAccountGuid;
  }


  @JsonProperty(JSON_PROPERTY_BANK_FIAT_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBankFiatAccountGuid(String bankFiatAccountGuid) {
    this.bankFiatAccountGuid = bankFiatAccountGuid;
  }


  public PostTransferBankModel customerFiatAccountGuid(String customerFiatAccountGuid) {
    
    this.customerFiatAccountGuid = customerFiatAccountGuid;
    return this;
  }

   /**
   * The identifier for the fiat account to use for the transfer. Required if the customer has multiple fiat accounts. Optional when transfer_type is instant_funding or transfer_type is lightning.
   * @return customerFiatAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identifier for the fiat account to use for the transfer. Required if the customer has multiple fiat accounts. Optional when transfer_type is instant_funding or transfer_type is lightning.")
  @JsonProperty(JSON_PROPERTY_CUSTOMER_FIAT_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCustomerFiatAccountGuid() {
    return customerFiatAccountGuid;
  }


  @JsonProperty(JSON_PROPERTY_CUSTOMER_FIAT_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustomerFiatAccountGuid(String customerFiatAccountGuid) {
    this.customerFiatAccountGuid = customerFiatAccountGuid;
  }


  public PostTransferBankModel sourceAccountGuid(String sourceAccountGuid) {
    
    this.sourceAccountGuid = sourceAccountGuid;
    return this;
  }

   /**
   * The source account&#39;s identifier. Required when transfer_type is book or transfer_type is inter_account.
   * @return sourceAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The source account's identifier. Required when transfer_type is book or transfer_type is inter_account.")
  @JsonProperty(JSON_PROPERTY_SOURCE_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSourceAccountGuid() {
    return sourceAccountGuid;
  }


  @JsonProperty(JSON_PROPERTY_SOURCE_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSourceAccountGuid(String sourceAccountGuid) {
    this.sourceAccountGuid = sourceAccountGuid;
  }


  public PostTransferBankModel destinationAccountGuid(String destinationAccountGuid) {
    
    this.destinationAccountGuid = destinationAccountGuid;
    return this;
  }

   /**
   * The destination account&#39;s identifier. Required when transfer_type is book or transfer_type is inter_account.
   * @return destinationAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The destination account's identifier. Required when transfer_type is book or transfer_type is inter_account.")
  @JsonProperty(JSON_PROPERTY_DESTINATION_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDestinationAccountGuid() {
    return destinationAccountGuid;
  }


  @JsonProperty(JSON_PROPERTY_DESTINATION_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDestinationAccountGuid(String destinationAccountGuid) {
    this.destinationAccountGuid = destinationAccountGuid;
  }


  public PostTransferBankModel externalWalletGuid(String externalWalletGuid) {
    
    this.externalWalletGuid = externalWalletGuid;
    return this;
  }

   /**
   * The customer&#39;s external wallet&#39;s identifier. Optional when transfer_type is crypto.
   * @return externalWalletGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's external wallet's identifier. Optional when transfer_type is crypto.")
  @JsonProperty(JSON_PROPERTY_EXTERNAL_WALLET_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExternalWalletGuid() {
    return externalWalletGuid;
  }


  @JsonProperty(JSON_PROPERTY_EXTERNAL_WALLET_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExternalWalletGuid(String externalWalletGuid) {
    this.externalWalletGuid = externalWalletGuid;
  }


  public PostTransferBankModel customerGuid(String customerGuid) {
    
    this.customerGuid = customerGuid;
    return this;
  }

   /**
   * The customer&#39;s identifier. Required when transfer_type is lightning.
   * @return customerGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's identifier. Required when transfer_type is lightning.")
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


  public PostTransferBankModel networkFeeAccountGuid(String networkFeeAccountGuid) {
    
    this.networkFeeAccountGuid = networkFeeAccountGuid;
    return this;
  }

   /**
   * The network fee account&#39;s identifier. Required for network fee transfers. Must be the identifier for the customer&#39;s or bank&#39;s fiat or trading account. For customer&#39;s to pay the network fees, include the customer&#39;s fiat or trading account guid. For bank&#39;s to pay the network fees, include the bank&#39;s fiat or trading account guid. Required when transfer_type is lightning.
   * @return networkFeeAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The network fee account's identifier. Required for network fee transfers. Must be the identifier for the customer's or bank's fiat or trading account. For customer's to pay the network fees, include the customer's fiat or trading account guid. For bank's to pay the network fees, include the bank's fiat or trading account guid. Required when transfer_type is lightning.")
  @JsonProperty(JSON_PROPERTY_NETWORK_FEE_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNetworkFeeAccountGuid() {
    return networkFeeAccountGuid;
  }


  @JsonProperty(JSON_PROPERTY_NETWORK_FEE_ACCOUNT_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNetworkFeeAccountGuid(String networkFeeAccountGuid) {
    this.networkFeeAccountGuid = networkFeeAccountGuid;
  }


  public PostTransferBankModel expectedBehaviours(List<ExpectedBehavioursEnum> expectedBehaviours) {
    
    this.expectedBehaviours = expectedBehaviours;
    return this;
  }

  public PostTransferBankModel addExpectedBehavioursItem(ExpectedBehavioursEnum expectedBehavioursItem) {
    if (this.expectedBehaviours == null) {
      this.expectedBehaviours = new ArrayList<>();
    }
    this.expectedBehaviours.add(expectedBehavioursItem);
    return this;
  }

   /**
   * The optional expected behaviour to simulate. Only applicable for transfers under sandbox banks. The force_review behaviour will force the transfer to be reviewed for funding and instant_funding transfers.
   * @return expectedBehaviours
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The optional expected behaviour to simulate. Only applicable for transfers under sandbox banks. The force_review behaviour will force the transfer to be reviewed for funding and instant_funding transfers.")
  @JsonProperty(JSON_PROPERTY_EXPECTED_BEHAVIOURS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ExpectedBehavioursEnum> getExpectedBehaviours() {
    return expectedBehaviours;
  }


  @JsonProperty(JSON_PROPERTY_EXPECTED_BEHAVIOURS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExpectedBehaviours(List<ExpectedBehavioursEnum> expectedBehaviours) {
    this.expectedBehaviours = expectedBehaviours;
  }


  public PostTransferBankModel labels(List<String> labels) {
    
    this.labels = labels;
    return this;
  }

  public PostTransferBankModel addLabelsItem(String labelsItem) {
    if (this.labels == null) {
      this.labels = new ArrayList<>();
    }
    this.labels.add(labelsItem);
    return this;
  }

   /**
   * The labels associated with the transfer.
   * @return labels
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The labels associated with the transfer.")
  @JsonProperty(JSON_PROPERTY_LABELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getLabels() {
    return labels;
  }


  @JsonProperty(JSON_PROPERTY_LABELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLabels(List<String> labels) {
    this.labels = labels;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostTransferBankModel postTransfer = (PostTransferBankModel) o;
    return Objects.equals(this.quoteGuid, postTransfer.quoteGuid) &&
        Objects.equals(this.transferType, postTransfer.transferType) &&
        Objects.equals(this.externalBankAccountGuid, postTransfer.externalBankAccountGuid) &&
        Objects.equals(this.fiatAccountGuid, postTransfer.fiatAccountGuid) &&
        Objects.equals(this.sendAsDepositBankAccountGuid, postTransfer.sendAsDepositBankAccountGuid) &&
        Objects.equals(this.paymentRail, postTransfer.paymentRail) &&
        Objects.equals(this.beneficiaryMemo, postTransfer.beneficiaryMemo) &&
        Objects.equals(this.sourceParticipants, postTransfer.sourceParticipants) &&
        Objects.equals(this.destinationParticipants, postTransfer.destinationParticipants) &&
        Objects.equals(this.bankFiatAccountGuid, postTransfer.bankFiatAccountGuid) &&
        Objects.equals(this.customerFiatAccountGuid, postTransfer.customerFiatAccountGuid) &&
        Objects.equals(this.sourceAccountGuid, postTransfer.sourceAccountGuid) &&
        Objects.equals(this.destinationAccountGuid, postTransfer.destinationAccountGuid) &&
        Objects.equals(this.externalWalletGuid, postTransfer.externalWalletGuid) &&
        Objects.equals(this.customerGuid, postTransfer.customerGuid) &&
        Objects.equals(this.networkFeeAccountGuid, postTransfer.networkFeeAccountGuid) &&
        Objects.equals(this.expectedBehaviours, postTransfer.expectedBehaviours) &&
        Objects.equals(this.labels, postTransfer.labels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quoteGuid, transferType, externalBankAccountGuid, fiatAccountGuid, sendAsDepositBankAccountGuid, paymentRail, beneficiaryMemo, sourceParticipants, destinationParticipants, bankFiatAccountGuid, customerFiatAccountGuid, sourceAccountGuid, destinationAccountGuid, externalWalletGuid, customerGuid, networkFeeAccountGuid, expectedBehaviours, labels);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostTransferBankModel {\n");
    sb.append("    quoteGuid: ").append(toIndentedString(quoteGuid)).append("\n");
    sb.append("    transferType: ").append(toIndentedString(transferType)).append("\n");
    sb.append("    externalBankAccountGuid: ").append(toIndentedString(externalBankAccountGuid)).append("\n");
    sb.append("    fiatAccountGuid: ").append(toIndentedString(fiatAccountGuid)).append("\n");
    sb.append("    sendAsDepositBankAccountGuid: ").append(toIndentedString(sendAsDepositBankAccountGuid)).append("\n");
    sb.append("    paymentRail: ").append(toIndentedString(paymentRail)).append("\n");
    sb.append("    beneficiaryMemo: ").append(toIndentedString(beneficiaryMemo)).append("\n");
    sb.append("    sourceParticipants: ").append(toIndentedString(sourceParticipants)).append("\n");
    sb.append("    destinationParticipants: ").append(toIndentedString(destinationParticipants)).append("\n");
    sb.append("    bankFiatAccountGuid: ").append(toIndentedString(bankFiatAccountGuid)).append("\n");
    sb.append("    customerFiatAccountGuid: ").append(toIndentedString(customerFiatAccountGuid)).append("\n");
    sb.append("    sourceAccountGuid: ").append(toIndentedString(sourceAccountGuid)).append("\n");
    sb.append("    destinationAccountGuid: ").append(toIndentedString(destinationAccountGuid)).append("\n");
    sb.append("    externalWalletGuid: ").append(toIndentedString(externalWalletGuid)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    networkFeeAccountGuid: ").append(toIndentedString(networkFeeAccountGuid)).append("\n");
    sb.append("    expectedBehaviours: ").append(toIndentedString(expectedBehaviours)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
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


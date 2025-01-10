/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Introduction](https://docs.cybrid.xyz/docs/introduction) 2. [Platform Introduction](https://docs.cybrid.xyz/docs/how-is-cybrid-architected) 3. [Testing with Hosted Web Demo App](https://docs.cybrid.xyz/docs/testing-with-hosted-web-demo-app)  In [Getting Started in the Cybrid Sandbox](https://docs.cybrid.xyz/docs/how-do-i-get-started-with-the-sandbox), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.production.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:write counterparties:execute customers:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read external_bank_accounts:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:write identity_verifications:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read customers:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:execute external_bank_accounts:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               | | Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |  ## Available Endpoints  The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create and list organization users                                                                | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             | | Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.123.137
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.model;

import java.util.Objects;
import java.util.Arrays;
import app.cybrid.cybrid_api_bank.client.model.ComplianceCheckBankModel;
import app.cybrid.cybrid_api_bank.client.model.ComplianceDecisionBankModel;
import app.cybrid.cybrid_api_bank.client.model.IdentityVerificationWithDetailsPiiBankModel;
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
 * IdentityVerificationWithDetailsBankModel
 */
@JsonPropertyOrder({
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_GUID,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_TYPE,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_METHOD,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_CREATED_AT,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_UPDATED_AT,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_COUNTERPARTY_GUID,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_STATE,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_OUTCOME,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_FAILURE_CODES,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_COMPLIANCE_CHECKS,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_COMPLIANCE_DECISIONS,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_PERSONA_INQUIRY_ID,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_PERSONA_STATE,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_PII
})
@JsonTypeName("IdentityVerificationWithDetails")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-01-10T22:57:18.209891Z[Etc/UTC]")
public class IdentityVerificationWithDetailsBankModel {
  public static final String JSON_PROPERTY_GUID = "guid";
  private String guid;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_METHOD = "method";
  private String method;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";
  private OffsetDateTime createdAt;

  public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
  private OffsetDateTime updatedAt;

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private JsonNullable<String> customerGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_COUNTERPARTY_GUID = "counterparty_guid";
  private JsonNullable<String> counterpartyGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID = "external_bank_account_guid";
  private JsonNullable<String> externalBankAccountGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_STATE = "state";
  private String state;

  public static final String JSON_PROPERTY_OUTCOME = "outcome";
  private JsonNullable<String> outcome = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_FAILURE_CODES = "failure_codes";
  private JsonNullable<List<String>> failureCodes = JsonNullable.<List<String>>undefined();

  public static final String JSON_PROPERTY_COMPLIANCE_CHECKS = "compliance_checks";
  private List<ComplianceCheckBankModel> complianceChecks = null;

  public static final String JSON_PROPERTY_COMPLIANCE_DECISIONS = "compliance_decisions";
  private List<ComplianceDecisionBankModel> complianceDecisions = null;

  public static final String JSON_PROPERTY_PERSONA_INQUIRY_ID = "persona_inquiry_id";
  private JsonNullable<String> personaInquiryId = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_PERSONA_STATE = "persona_state";
  private JsonNullable<String> personaState = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_PII = "pii";
  private JsonNullable<IdentityVerificationWithDetailsPiiBankModel> pii = JsonNullable.<IdentityVerificationWithDetailsPiiBankModel>undefined();

  public IdentityVerificationWithDetailsBankModel() { 
  }

  public IdentityVerificationWithDetailsBankModel guid(String guid) {
    
    this.guid = guid;
    return this;
  }

   /**
   * Auto-generated unique identifier for the identity verification.
   * @return guid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Auto-generated unique identifier for the identity verification.")
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


  public IdentityVerificationWithDetailsBankModel type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * The identity verification type; one of kyc, bank_account, or counterparty.
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identity verification type; one of kyc, bank_account, or counterparty.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
  }


  public IdentityVerificationWithDetailsBankModel method(String method) {
    
    this.method = method;
    return this;
  }

   /**
   * The identity verification method; one of attested, document_submission, id_and_selfie, tax_id_and_selfie, business_registration, plaid_identity_match, attested_ownership, account_ownership, or watchlists.
   * @return method
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identity verification method; one of attested, document_submission, id_and_selfie, tax_id_and_selfie, business_registration, plaid_identity_match, attested_ownership, account_ownership, or watchlists.")
  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMethod() {
    return method;
  }


  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMethod(String method) {
    this.method = method;
  }


  public IdentityVerificationWithDetailsBankModel createdAt(OffsetDateTime createdAt) {
    
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


  public IdentityVerificationWithDetailsBankModel updatedAt(OffsetDateTime updatedAt) {
    
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


  public IdentityVerificationWithDetailsBankModel customerGuid(String customerGuid) {
    this.customerGuid = JsonNullable.<String>of(customerGuid);
    
    return this;
  }

   /**
   * The identity verification&#39;s identifier.
   * @return customerGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identity verification's identifier.")
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


  public IdentityVerificationWithDetailsBankModel counterpartyGuid(String counterpartyGuid) {
    this.counterpartyGuid = JsonNullable.<String>of(counterpartyGuid);
    
    return this;
  }

   /**
   * The identity verification&#39;s identifier.
   * @return counterpartyGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identity verification's identifier.")
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


  public IdentityVerificationWithDetailsBankModel externalBankAccountGuid(String externalBankAccountGuid) {
    this.externalBankAccountGuid = JsonNullable.<String>of(externalBankAccountGuid);
    
    return this;
  }

   /**
   * The identity verification&#39;s identifier.
   * @return externalBankAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identity verification's identifier.")
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


  public IdentityVerificationWithDetailsBankModel state(String state) {
    
    this.state = state;
    return this;
  }

   /**
   * The identity verification state; one of storing, waiting, pending, reviewing, expired, or completed.
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identity verification state; one of storing, waiting, pending, reviewing, expired, or completed.")
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


  public IdentityVerificationWithDetailsBankModel outcome(String outcome) {
    this.outcome = JsonNullable.<String>of(outcome);
    
    return this;
  }

   /**
   * The identity verification outcome; one of passed or failed.
   * @return outcome
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identity verification outcome; one of passed or failed.")
  @JsonIgnore

  public String getOutcome() {
        return outcome.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OUTCOME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getOutcome_JsonNullable() {
    return outcome;
  }
  
  @JsonProperty(JSON_PROPERTY_OUTCOME)
  public void setOutcome_JsonNullable(JsonNullable<String> outcome) {
    this.outcome = outcome;
  }

  public void setOutcome(String outcome) {
    this.outcome = JsonNullable.<String>of(outcome);
  }


  public IdentityVerificationWithDetailsBankModel failureCodes(List<String> failureCodes) {
    this.failureCodes = JsonNullable.<List<String>>of(failureCodes);
    
    return this;
  }

  public IdentityVerificationWithDetailsBankModel addFailureCodesItem(String failureCodesItem) {
    if (this.failureCodes == null || !this.failureCodes.isPresent()) {
      this.failureCodes = JsonNullable.<List<String>>of(new ArrayList<>());
    }
    try {
      this.failureCodes.get().add(failureCodesItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The reason codes explaining the outcome.
   * @return failureCodes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The reason codes explaining the outcome.")
  @JsonIgnore

  public List<String> getFailureCodes() {
        return failureCodes.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FAILURE_CODES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<String>> getFailureCodes_JsonNullable() {
    return failureCodes;
  }
  
  @JsonProperty(JSON_PROPERTY_FAILURE_CODES)
  public void setFailureCodes_JsonNullable(JsonNullable<List<String>> failureCodes) {
    this.failureCodes = failureCodes;
  }

  public void setFailureCodes(List<String> failureCodes) {
    this.failureCodes = JsonNullable.<List<String>>of(failureCodes);
  }


  public IdentityVerificationWithDetailsBankModel complianceChecks(List<ComplianceCheckBankModel> complianceChecks) {
    
    this.complianceChecks = complianceChecks;
    return this;
  }

  public IdentityVerificationWithDetailsBankModel addComplianceChecksItem(ComplianceCheckBankModel complianceChecksItem) {
    if (this.complianceChecks == null) {
      this.complianceChecks = new ArrayList<>();
    }
    this.complianceChecks.add(complianceChecksItem);
    return this;
  }

   /**
   * The compliance checks associated with the identity verification.
   * @return complianceChecks
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The compliance checks associated with the identity verification.")
  @JsonProperty(JSON_PROPERTY_COMPLIANCE_CHECKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ComplianceCheckBankModel> getComplianceChecks() {
    return complianceChecks;
  }


  @JsonProperty(JSON_PROPERTY_COMPLIANCE_CHECKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setComplianceChecks(List<ComplianceCheckBankModel> complianceChecks) {
    this.complianceChecks = complianceChecks;
  }


  public IdentityVerificationWithDetailsBankModel complianceDecisions(List<ComplianceDecisionBankModel> complianceDecisions) {
    
    this.complianceDecisions = complianceDecisions;
    return this;
  }

  public IdentityVerificationWithDetailsBankModel addComplianceDecisionsItem(ComplianceDecisionBankModel complianceDecisionsItem) {
    if (this.complianceDecisions == null) {
      this.complianceDecisions = new ArrayList<>();
    }
    this.complianceDecisions.add(complianceDecisionsItem);
    return this;
  }

   /**
   * The compliance decisions associated with the identity verification.
   * @return complianceDecisions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The compliance decisions associated with the identity verification.")
  @JsonProperty(JSON_PROPERTY_COMPLIANCE_DECISIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ComplianceDecisionBankModel> getComplianceDecisions() {
    return complianceDecisions;
  }


  @JsonProperty(JSON_PROPERTY_COMPLIANCE_DECISIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setComplianceDecisions(List<ComplianceDecisionBankModel> complianceDecisions) {
    this.complianceDecisions = complianceDecisions;
  }


  public IdentityVerificationWithDetailsBankModel personaInquiryId(String personaInquiryId) {
    this.personaInquiryId = JsonNullable.<String>of(personaInquiryId);
    
    return this;
  }

   /**
   * The Persona identifier of the backing inquiry.
   * @return personaInquiryId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Persona identifier of the backing inquiry.")
  @JsonIgnore

  public String getPersonaInquiryId() {
        return personaInquiryId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PERSONA_INQUIRY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPersonaInquiryId_JsonNullable() {
    return personaInquiryId;
  }
  
  @JsonProperty(JSON_PROPERTY_PERSONA_INQUIRY_ID)
  public void setPersonaInquiryId_JsonNullable(JsonNullable<String> personaInquiryId) {
    this.personaInquiryId = personaInquiryId;
  }

  public void setPersonaInquiryId(String personaInquiryId) {
    this.personaInquiryId = JsonNullable.<String>of(personaInquiryId);
  }


  public IdentityVerificationWithDetailsBankModel personaState(String personaState) {
    this.personaState = JsonNullable.<String>of(personaState);
    
    return this;
  }

   /**
   * The Persona state of the backing inquiry; one of waiting, pending, reviewing, processing, expired, completed, or unknown.
   * @return personaState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Persona state of the backing inquiry; one of waiting, pending, reviewing, processing, expired, completed, or unknown.")
  @JsonIgnore

  public String getPersonaState() {
        return personaState.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PERSONA_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPersonaState_JsonNullable() {
    return personaState;
  }
  
  @JsonProperty(JSON_PROPERTY_PERSONA_STATE)
  public void setPersonaState_JsonNullable(JsonNullable<String> personaState) {
    this.personaState = personaState;
  }

  public void setPersonaState(String personaState) {
    this.personaState = JsonNullable.<String>of(personaState);
  }


  public IdentityVerificationWithDetailsBankModel pii(IdentityVerificationWithDetailsPiiBankModel pii) {
    this.pii = JsonNullable.<IdentityVerificationWithDetailsPiiBankModel>of(pii);
    
    return this;
  }

   /**
   * Get pii
   * @return pii
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonIgnore

  public IdentityVerificationWithDetailsPiiBankModel getPii() {
        return pii.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PII)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<IdentityVerificationWithDetailsPiiBankModel> getPii_JsonNullable() {
    return pii;
  }
  
  @JsonProperty(JSON_PROPERTY_PII)
  public void setPii_JsonNullable(JsonNullable<IdentityVerificationWithDetailsPiiBankModel> pii) {
    this.pii = pii;
  }

  public void setPii(IdentityVerificationWithDetailsPiiBankModel pii) {
    this.pii = JsonNullable.<IdentityVerificationWithDetailsPiiBankModel>of(pii);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityVerificationWithDetailsBankModel identityVerificationWithDetails = (IdentityVerificationWithDetailsBankModel) o;
    return Objects.equals(this.guid, identityVerificationWithDetails.guid) &&
        Objects.equals(this.type, identityVerificationWithDetails.type) &&
        Objects.equals(this.method, identityVerificationWithDetails.method) &&
        Objects.equals(this.createdAt, identityVerificationWithDetails.createdAt) &&
        Objects.equals(this.updatedAt, identityVerificationWithDetails.updatedAt) &&
        equalsNullable(this.customerGuid, identityVerificationWithDetails.customerGuid) &&
        equalsNullable(this.counterpartyGuid, identityVerificationWithDetails.counterpartyGuid) &&
        equalsNullable(this.externalBankAccountGuid, identityVerificationWithDetails.externalBankAccountGuid) &&
        Objects.equals(this.state, identityVerificationWithDetails.state) &&
        equalsNullable(this.outcome, identityVerificationWithDetails.outcome) &&
        equalsNullable(this.failureCodes, identityVerificationWithDetails.failureCodes) &&
        Objects.equals(this.complianceChecks, identityVerificationWithDetails.complianceChecks) &&
        Objects.equals(this.complianceDecisions, identityVerificationWithDetails.complianceDecisions) &&
        equalsNullable(this.personaInquiryId, identityVerificationWithDetails.personaInquiryId) &&
        equalsNullable(this.personaState, identityVerificationWithDetails.personaState) &&
        equalsNullable(this.pii, identityVerificationWithDetails.pii);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(guid, type, method, createdAt, updatedAt, hashCodeNullable(customerGuid), hashCodeNullable(counterpartyGuid), hashCodeNullable(externalBankAccountGuid), state, hashCodeNullable(outcome), hashCodeNullable(failureCodes), complianceChecks, complianceDecisions, hashCodeNullable(personaInquiryId), hashCodeNullable(personaState), hashCodeNullable(pii));
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
    sb.append("class IdentityVerificationWithDetailsBankModel {\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    counterpartyGuid: ").append(toIndentedString(counterpartyGuid)).append("\n");
    sb.append("    externalBankAccountGuid: ").append(toIndentedString(externalBankAccountGuid)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    outcome: ").append(toIndentedString(outcome)).append("\n");
    sb.append("    failureCodes: ").append(toIndentedString(failureCodes)).append("\n");
    sb.append("    complianceChecks: ").append(toIndentedString(complianceChecks)).append("\n");
    sb.append("    complianceDecisions: ").append(toIndentedString(complianceDecisions)).append("\n");
    sb.append("    personaInquiryId: ").append(toIndentedString(personaInquiryId)).append("\n");
    sb.append("    personaState: ").append(toIndentedString(personaState)).append("\n");
    sb.append("    pii: ").append(toIndentedString(pii)).append("\n");
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


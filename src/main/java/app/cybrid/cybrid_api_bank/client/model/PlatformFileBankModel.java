/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Introduction](https://docs.cybrid.xyz/docs/introduction) 2. [Platform Introduction](https://docs.cybrid.xyz/docs/how-is-cybrid-architected) 3. [Testing with Hosted Web Demo App](https://docs.cybrid.xyz/docs/testing-with-hosted-web-demo-app)  In [Getting Started in the Cybrid Sandbox](https://docs.cybrid.xyz/docs/how-do-i-get-started-with-the-sandbox), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.production.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:pii:read counterparties:write counterparties:execute customers:read customers:pii:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read transfers:write external_bank_accounts:read external_bank_accounts:pii:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:pii:read identity_verifications:write identity_verifications:execute files:read files:pii:read files:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read counterparties:pii:read customers:read customers:pii:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:write transfers:execute external_bank_accounts:read external_bank_accounts:pii:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read identity_verifications:pii:read identity_verifications:execute files:read files:pii:read files:execute' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               | | Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |  ## Available Endpoints  The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create and list organization users                                                                | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             | | Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.123.493
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
import java.net.URI;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * PlatformFileBankModel
 */
@JsonPropertyOrder({
  PlatformFileBankModel.JSON_PROPERTY_GUID,
  PlatformFileBankModel.JSON_PROPERTY_ORGANIZATION_GUID,
  PlatformFileBankModel.JSON_PROPERTY_BANK_GUID,
  PlatformFileBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  PlatformFileBankModel.JSON_PROPERTY_TYPE,
  PlatformFileBankModel.JSON_PROPERTY_CONTENT_TYPE,
  PlatformFileBankModel.JSON_PROPERTY_FILENAME,
  PlatformFileBankModel.JSON_PROPERTY_COMPLETED_AT,
  PlatformFileBankModel.JSON_PROPERTY_FAILED_AT,
  PlatformFileBankModel.JSON_PROPERTY_STATE,
  PlatformFileBankModel.JSON_PROPERTY_FAILURE_CODE,
  PlatformFileBankModel.JSON_PROPERTY_UPLOAD_URL,
  PlatformFileBankModel.JSON_PROPERTY_UPLOAD_EXPIRES_AT,
  PlatformFileBankModel.JSON_PROPERTY_DOWNLOAD_URL,
  PlatformFileBankModel.JSON_PROPERTY_DOWNLOAD_EXPIRES_AT
})
@JsonTypeName("PlatformFile")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-16T13:51:07.887600Z[Etc/UTC]")
public class PlatformFileBankModel {
  public static final String JSON_PROPERTY_GUID = "guid";
  private String guid;

  public static final String JSON_PROPERTY_ORGANIZATION_GUID = "organization_guid";
  private String organizationGuid;

  public static final String JSON_PROPERTY_BANK_GUID = "bank_guid";
  private JsonNullable<String> bankGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private JsonNullable<String> customerGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_CONTENT_TYPE = "content_type";
  private String contentType;

  public static final String JSON_PROPERTY_FILENAME = "filename";
  private String filename;

  public static final String JSON_PROPERTY_COMPLETED_AT = "completed_at";
  private OffsetDateTime completedAt;

  public static final String JSON_PROPERTY_FAILED_AT = "failed_at";
  private OffsetDateTime failedAt;

  /**
   * The state of the file. One of storing, completed, or failed.
   */
  public enum StateEnum {
    STORING("storing"),
    
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

  public static final String JSON_PROPERTY_FAILURE_CODE = "failure_code";
  private JsonNullable<String> failureCode = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_UPLOAD_URL = "upload_url";
  private JsonNullable<URI> uploadUrl = JsonNullable.<URI>undefined();

  public static final String JSON_PROPERTY_UPLOAD_EXPIRES_AT = "upload_expires_at";
  private JsonNullable<OffsetDateTime> uploadExpiresAt = JsonNullable.<OffsetDateTime>undefined();

  public static final String JSON_PROPERTY_DOWNLOAD_URL = "download_url";
  private JsonNullable<URI> downloadUrl = JsonNullable.<URI>undefined();

  public static final String JSON_PROPERTY_DOWNLOAD_EXPIRES_AT = "download_expires_at";
  private JsonNullable<OffsetDateTime> downloadExpiresAt = JsonNullable.<OffsetDateTime>undefined();

  public PlatformFileBankModel() { 
  }

  public PlatformFileBankModel guid(String guid) {
    
    this.guid = guid;
    return this;
  }

   /**
   * The unique identifier for the file.
   * @return guid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identifier for the file.")
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


  public PlatformFileBankModel organizationGuid(String organizationGuid) {
    
    this.organizationGuid = organizationGuid;
    return this;
  }

   /**
   * The organization identifier.
   * @return organizationGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The organization identifier.")
  @JsonProperty(JSON_PROPERTY_ORGANIZATION_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOrganizationGuid() {
    return organizationGuid;
  }


  @JsonProperty(JSON_PROPERTY_ORGANIZATION_GUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOrganizationGuid(String organizationGuid) {
    this.organizationGuid = organizationGuid;
  }


  public PlatformFileBankModel bankGuid(String bankGuid) {
    this.bankGuid = JsonNullable.<String>of(bankGuid);
    
    return this;
  }

   /**
   * The bank identifier.
   * @return bankGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The bank identifier.")
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


  public PlatformFileBankModel customerGuid(String customerGuid) {
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


  public PlatformFileBankModel type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * The file type; one of drivers_license_front, drivers_license_back, passport, passport_card, visa, identification_card, residence_card, selfie, selfie_video, selfie_left, selfie_right, utility_bill, proof_of_address, bank_statement, property_tax, tax_document, ein_letter, incorporation_certificate, persona_inquiry_report, or persona_inquiry_export.
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The file type; one of drivers_license_front, drivers_license_back, passport, passport_card, visa, identification_card, residence_card, selfie, selfie_video, selfie_left, selfie_right, utility_bill, proof_of_address, bank_statement, property_tax, tax_document, ein_letter, incorporation_certificate, persona_inquiry_report, or persona_inquiry_export.")
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


  public PlatformFileBankModel contentType(String contentType) {
    
    this.contentType = contentType;
    return this;
  }

   /**
   * The media type; one of image/jpeg, image/png, application/pdf, application/json, or video/mp4.
   * @return contentType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The media type; one of image/jpeg, image/png, application/pdf, application/json, or video/mp4.")
  @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getContentType() {
    return contentType;
  }


  @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }


  public PlatformFileBankModel filename(String filename) {
    
    this.filename = filename;
    return this;
  }

   /**
   * The name of the file.
   * @return filename
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the file.")
  @JsonProperty(JSON_PROPERTY_FILENAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFilename() {
    return filename;
  }


  @JsonProperty(JSON_PROPERTY_FILENAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFilename(String filename) {
    this.filename = filename;
  }


  public PlatformFileBankModel completedAt(OffsetDateTime completedAt) {
    
    this.completedAt = completedAt;
    return this;
  }

   /**
   * The ISO8601 datetime the file was completed at.
   * @return completedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ISO8601 datetime the file was completed at.")
  @JsonProperty(JSON_PROPERTY_COMPLETED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCompletedAt() {
    return completedAt;
  }


  @JsonProperty(JSON_PROPERTY_COMPLETED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCompletedAt(OffsetDateTime completedAt) {
    this.completedAt = completedAt;
  }


  public PlatformFileBankModel failedAt(OffsetDateTime failedAt) {
    
    this.failedAt = failedAt;
    return this;
  }

   /**
   * The ISO8601 datetime the file failed at.
   * @return failedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ISO8601 datetime the file failed at.")
  @JsonProperty(JSON_PROPERTY_FAILED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getFailedAt() {
    return failedAt;
  }


  @JsonProperty(JSON_PROPERTY_FAILED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFailedAt(OffsetDateTime failedAt) {
    this.failedAt = failedAt;
  }


  public PlatformFileBankModel state(StateEnum state) {
    
    this.state = state;
    return this;
  }

   /**
   * The state of the file. One of storing, completed, or failed.
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The state of the file. One of storing, completed, or failed.")
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


  public PlatformFileBankModel failureCode(String failureCode) {
    this.failureCode = JsonNullable.<String>of(failureCode);
    
    return this;
  }

   /**
   * The failure code for failed files.
   * @return failureCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The failure code for failed files.")
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


  public PlatformFileBankModel uploadUrl(URI uploadUrl) {
    this.uploadUrl = JsonNullable.<URI>of(uploadUrl);
    
    return this;
  }

   /**
   * The URL to upload the file to.
   * @return uploadUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL to upload the file to.")
  @JsonIgnore

  public URI getUploadUrl() {
        return uploadUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UPLOAD_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<URI> getUploadUrl_JsonNullable() {
    return uploadUrl;
  }
  
  @JsonProperty(JSON_PROPERTY_UPLOAD_URL)
  public void setUploadUrl_JsonNullable(JsonNullable<URI> uploadUrl) {
    this.uploadUrl = uploadUrl;
  }

  public void setUploadUrl(URI uploadUrl) {
    this.uploadUrl = JsonNullable.<URI>of(uploadUrl);
  }


  public PlatformFileBankModel uploadExpiresAt(OffsetDateTime uploadExpiresAt) {
    this.uploadExpiresAt = JsonNullable.<OffsetDateTime>of(uploadExpiresAt);
    
    return this;
  }

   /**
   * The ISO8601 datetime the upload URL expires at.
   * @return uploadExpiresAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ISO8601 datetime the upload URL expires at.")
  @JsonIgnore

  public OffsetDateTime getUploadExpiresAt() {
        return uploadExpiresAt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UPLOAD_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<OffsetDateTime> getUploadExpiresAt_JsonNullable() {
    return uploadExpiresAt;
  }
  
  @JsonProperty(JSON_PROPERTY_UPLOAD_EXPIRES_AT)
  public void setUploadExpiresAt_JsonNullable(JsonNullable<OffsetDateTime> uploadExpiresAt) {
    this.uploadExpiresAt = uploadExpiresAt;
  }

  public void setUploadExpiresAt(OffsetDateTime uploadExpiresAt) {
    this.uploadExpiresAt = JsonNullable.<OffsetDateTime>of(uploadExpiresAt);
  }


  public PlatformFileBankModel downloadUrl(URI downloadUrl) {
    this.downloadUrl = JsonNullable.<URI>of(downloadUrl);
    
    return this;
  }

   /**
   * The URL to download the file from.
   * @return downloadUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL to download the file from.")
  @JsonIgnore

  public URI getDownloadUrl() {
        return downloadUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DOWNLOAD_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<URI> getDownloadUrl_JsonNullable() {
    return downloadUrl;
  }
  
  @JsonProperty(JSON_PROPERTY_DOWNLOAD_URL)
  public void setDownloadUrl_JsonNullable(JsonNullable<URI> downloadUrl) {
    this.downloadUrl = downloadUrl;
  }

  public void setDownloadUrl(URI downloadUrl) {
    this.downloadUrl = JsonNullable.<URI>of(downloadUrl);
  }


  public PlatformFileBankModel downloadExpiresAt(OffsetDateTime downloadExpiresAt) {
    this.downloadExpiresAt = JsonNullable.<OffsetDateTime>of(downloadExpiresAt);
    
    return this;
  }

   /**
   * The ISO8601 datetime the download URL expires at.
   * @return downloadExpiresAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ISO8601 datetime the download URL expires at.")
  @JsonIgnore

  public OffsetDateTime getDownloadExpiresAt() {
        return downloadExpiresAt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DOWNLOAD_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<OffsetDateTime> getDownloadExpiresAt_JsonNullable() {
    return downloadExpiresAt;
  }
  
  @JsonProperty(JSON_PROPERTY_DOWNLOAD_EXPIRES_AT)
  public void setDownloadExpiresAt_JsonNullable(JsonNullable<OffsetDateTime> downloadExpiresAt) {
    this.downloadExpiresAt = downloadExpiresAt;
  }

  public void setDownloadExpiresAt(OffsetDateTime downloadExpiresAt) {
    this.downloadExpiresAt = JsonNullable.<OffsetDateTime>of(downloadExpiresAt);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlatformFileBankModel platformFile = (PlatformFileBankModel) o;
    return Objects.equals(this.guid, platformFile.guid) &&
        Objects.equals(this.organizationGuid, platformFile.organizationGuid) &&
        equalsNullable(this.bankGuid, platformFile.bankGuid) &&
        equalsNullable(this.customerGuid, platformFile.customerGuid) &&
        Objects.equals(this.type, platformFile.type) &&
        Objects.equals(this.contentType, platformFile.contentType) &&
        Objects.equals(this.filename, platformFile.filename) &&
        Objects.equals(this.completedAt, platformFile.completedAt) &&
        Objects.equals(this.failedAt, platformFile.failedAt) &&
        Objects.equals(this.state, platformFile.state) &&
        equalsNullable(this.failureCode, platformFile.failureCode) &&
        equalsNullable(this.uploadUrl, platformFile.uploadUrl) &&
        equalsNullable(this.uploadExpiresAt, platformFile.uploadExpiresAt) &&
        equalsNullable(this.downloadUrl, platformFile.downloadUrl) &&
        equalsNullable(this.downloadExpiresAt, platformFile.downloadExpiresAt);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(guid, organizationGuid, hashCodeNullable(bankGuid), hashCodeNullable(customerGuid), type, contentType, filename, completedAt, failedAt, state, hashCodeNullable(failureCode), hashCodeNullable(uploadUrl), hashCodeNullable(uploadExpiresAt), hashCodeNullable(downloadUrl), hashCodeNullable(downloadExpiresAt));
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
    sb.append("class PlatformFileBankModel {\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    organizationGuid: ").append(toIndentedString(organizationGuid)).append("\n");
    sb.append("    bankGuid: ").append(toIndentedString(bankGuid)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    completedAt: ").append(toIndentedString(completedAt)).append("\n");
    sb.append("    failedAt: ").append(toIndentedString(failedAt)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    failureCode: ").append(toIndentedString(failureCode)).append("\n");
    sb.append("    uploadUrl: ").append(toIndentedString(uploadUrl)).append("\n");
    sb.append("    uploadExpiresAt: ").append(toIndentedString(uploadExpiresAt)).append("\n");
    sb.append("    downloadUrl: ").append(toIndentedString(downloadUrl)).append("\n");
    sb.append("    downloadExpiresAt: ").append(toIndentedString(downloadExpiresAt)).append("\n");
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


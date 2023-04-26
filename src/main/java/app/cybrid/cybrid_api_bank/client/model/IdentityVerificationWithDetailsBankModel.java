/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.sandbox.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Understanding the Platform](https://kb.cybrid.xyz/understanding-the-platform) 2. [Getting Started in the Cybrid Sandbox](https://kb.cybrid.xyz/getting-started-guide) 3. [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading) 4. [Running the Web Demo App](https://kb.cybrid.xyz/locally-running-the-web-demo-app) (or, alternatively, [Testing with Hosted Web Demo App](https://kb.cybrid.xyz/testing-with-hosted-web-demo-app))  In [Getting Started in the Cybrid Sandbox](https://www.cybrid.xyz/guides/getting-started), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://www.cybrid.xyz/guides/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  If you've already run through the first two guides, you can follow the [Running the Web Demo App](https://www.cybrid.xyz/guides/running-the-cybrid-web-demo-crypto-app) guide to test our web SDK with your sandbox `bank` and `customer`.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.sandbox.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.sandbox.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.sandbox.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.sandbox.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.sandbox.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.sandbox.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.sandbox.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write accounts:read accounts:execute customers:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read rewards:execute rewards:read external_bank_accounts:read external_bank_accounts:write external_bank_accounts:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write banks:read banks:write banks:execute customers:read accounts:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:execute external_bank_accounts:read workflows:read deposit_addresses:read' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Reward                | rewards:read (Bank, Customer)                              |                                               | rewards:execute (Bank)                           | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               |  ## Available Endpoints  The available APIs for the [Identity](https://id.sandbox.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.sandbox.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.sandbox.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | BankVerificationKey  | /api/bank_verification_keys    | Create, list and retrive verification keys, used for signing identities                           | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Reward               | /api/rewards                   | Create a new reward (automates quote/trade for simplicity)                                        | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.68.67
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.model;

import java.util.Objects;
import java.util.Arrays;
import app.cybrid.cybrid_api_bank.client.model.IdentityVerificationBankModel;
import app.cybrid.cybrid_api_bank.client.model.IdentityVerificationWithDetailsAllOfBankModel;
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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * IdentityVerificationWithDetailsBankModel
 */
@JsonPropertyOrder({
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_GUID,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_TYPE,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_METHOD,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_CREATED_AT,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_STATE,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_OUTCOME,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_FAILURE_CODES,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_PERSONA_INQUIRY_ID,
  IdentityVerificationWithDetailsBankModel.JSON_PROPERTY_PERSONA_STATE
})
@JsonTypeName("IdentityVerificationWithDetails")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-26T21:50:38.621239Z[Etc/UTC]")
public class IdentityVerificationWithDetailsBankModel {
  public static final String JSON_PROPERTY_GUID = "guid";
  private String guid;

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private String customerGuid;

  /**
   * The type of identity verification.
   */
  public enum TypeEnum {
    KYC("kyc");

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
   * The identity verification method.
   */
  public enum MethodEnum {
    ID_AND_SELFIE("id_and_selfie"),
    
    ATTESTED("attested");

    private String value;

    MethodEnum(String value) {
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
    public static MethodEnum fromValue(String value) {
      for (MethodEnum b : MethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_METHOD = "method";
  private MethodEnum method;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";
  private OffsetDateTime createdAt;

  /**
   * The state of the verification process.
   */
  public enum StateEnum {
    STORING("storing"),
    
    WAITING("waiting"),
    
    EXPIRED("expired"),
    
    COMPLETED("completed");

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

  /**
   * The outcome of the verification process.
   */
  public enum OutcomeEnum {
    PASSED("passed"),
    
    FAILED("failed");

    private String value;

    OutcomeEnum(String value) {
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
    public static OutcomeEnum fromValue(String value) {
      for (OutcomeEnum b : OutcomeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  public static final String JSON_PROPERTY_OUTCOME = "outcome";
  private OutcomeEnum outcome;

  /**
   * Gets or Sets failureCodes
   */
  public enum FailureCodesEnum {
    REQUESTED_FAILURE("requested_failure"),
    
    ID_CHECK_FAILURE("id_check_failure"),
    
    DATABASE_CHECK_FAILURE("database_check_failure"),
    
    SELFIE_FAILURE("selfie_failure"),
    
    PEP_CHECK_FAILURE("pep_check_failure"),
    
    WATCHLIST_CHECK_FAILURE("watchlist_check_failure"),
    
    NAME_CHECK_FAILURE("name_check_failure"),
    
    ADDRESS_CHECK_FAILURE("address_check_failure"),
    
    DOB_CHECK_FAILURE("dob_check_failure"),
    
    ID_NUMBER_CHECK_FAILURE("id_number_check_failure");

    private String value;

    FailureCodesEnum(String value) {
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
    public static FailureCodesEnum fromValue(String value) {
      for (FailureCodesEnum b : FailureCodesEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_FAILURE_CODES = "failure_codes";
  private List<FailureCodesEnum> failureCodes = null;

  public static final String JSON_PROPERTY_PERSONA_INQUIRY_ID = "persona_inquiry_id";
  private String personaInquiryId;

  /**
   * The Persona state of the backing inquiry.
   */
  public enum PersonaStateEnum {
    WAITING("waiting"),
    
    PENDING("pending"),
    
    REVIEWING("reviewing"),
    
    PROCESSING("processing"),
    
    EXPIRED("expired"),
    
    COMPLETED("completed"),
    
    UNKNOWN("unknown");

    private String value;

    PersonaStateEnum(String value) {
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
    public static PersonaStateEnum fromValue(String value) {
      for (PersonaStateEnum b : PersonaStateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  public static final String JSON_PROPERTY_PERSONA_STATE = "persona_state";
  private PersonaStateEnum personaState;

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


  public IdentityVerificationWithDetailsBankModel customerGuid(String customerGuid) {
    
    this.customerGuid = customerGuid;
    return this;
  }

   /**
   * The customer&#39;s identifier.
   * @return customerGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's identifier.")
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


  public IdentityVerificationWithDetailsBankModel type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * The type of identity verification.
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of identity verification.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TypeEnum getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }


  public IdentityVerificationWithDetailsBankModel method(MethodEnum method) {
    
    this.method = method;
    return this;
  }

   /**
   * The identity verification method.
   * @return method
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identity verification method.")
  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MethodEnum getMethod() {
    return method;
  }


  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMethod(MethodEnum method) {
    this.method = method;
  }


  public IdentityVerificationWithDetailsBankModel createdAt(OffsetDateTime createdAt) {
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * ISO8601 datetime the customer was created at.
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the customer was created at.")
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


  public IdentityVerificationWithDetailsBankModel state(StateEnum state) {
    
    this.state = state;
    return this;
  }

   /**
   * The state of the verification process.
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The state of the verification process.")
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


  public IdentityVerificationWithDetailsBankModel outcome(OutcomeEnum outcome) {
    
    this.outcome = outcome;
    return this;
  }

   /**
   * The outcome of the verification process.
   * @return outcome
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The outcome of the verification process.")
  @JsonProperty(JSON_PROPERTY_OUTCOME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OutcomeEnum getOutcome() {
    return outcome;
  }


  @JsonProperty(JSON_PROPERTY_OUTCOME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOutcome(OutcomeEnum outcome) {
    this.outcome = outcome;
  }


  public IdentityVerificationWithDetailsBankModel failureCodes(List<FailureCodesEnum> failureCodes) {
    
    this.failureCodes = failureCodes;
    return this;
  }

  public IdentityVerificationWithDetailsBankModel addFailureCodesItem(FailureCodesEnum failureCodesItem) {
    if (this.failureCodes == null) {
      this.failureCodes = new ArrayList<>();
    }
    this.failureCodes.add(failureCodesItem);
    return this;
  }

   /**
   * The reason codes explaining the outcome.
   * @return failureCodes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The reason codes explaining the outcome.")
  @JsonProperty(JSON_PROPERTY_FAILURE_CODES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<FailureCodesEnum> getFailureCodes() {
    return failureCodes;
  }


  @JsonProperty(JSON_PROPERTY_FAILURE_CODES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFailureCodes(List<FailureCodesEnum> failureCodes) {
    this.failureCodes = failureCodes;
  }


  public IdentityVerificationWithDetailsBankModel personaInquiryId(String personaInquiryId) {
    
    this.personaInquiryId = personaInquiryId;
    return this;
  }

   /**
   * The Persona identifier of the backing inquiry.
   * @return personaInquiryId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Persona identifier of the backing inquiry.")
  @JsonProperty(JSON_PROPERTY_PERSONA_INQUIRY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPersonaInquiryId() {
    return personaInquiryId;
  }


  @JsonProperty(JSON_PROPERTY_PERSONA_INQUIRY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPersonaInquiryId(String personaInquiryId) {
    this.personaInquiryId = personaInquiryId;
  }


  public IdentityVerificationWithDetailsBankModel personaState(PersonaStateEnum personaState) {
    
    this.personaState = personaState;
    return this;
  }

   /**
   * The Persona state of the backing inquiry.
   * @return personaState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Persona state of the backing inquiry.")
  @JsonProperty(JSON_PROPERTY_PERSONA_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PersonaStateEnum getPersonaState() {
    return personaState;
  }


  @JsonProperty(JSON_PROPERTY_PERSONA_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPersonaState(PersonaStateEnum personaState) {
    this.personaState = personaState;
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
        Objects.equals(this.customerGuid, identityVerificationWithDetails.customerGuid) &&
        Objects.equals(this.type, identityVerificationWithDetails.type) &&
        Objects.equals(this.method, identityVerificationWithDetails.method) &&
        Objects.equals(this.createdAt, identityVerificationWithDetails.createdAt) &&
        Objects.equals(this.state, identityVerificationWithDetails.state) &&
        Objects.equals(this.outcome, identityVerificationWithDetails.outcome) &&
        Objects.equals(this.failureCodes, identityVerificationWithDetails.failureCodes) &&
        Objects.equals(this.personaInquiryId, identityVerificationWithDetails.personaInquiryId) &&
        Objects.equals(this.personaState, identityVerificationWithDetails.personaState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(guid, customerGuid, type, method, createdAt, state, outcome, failureCodes, personaInquiryId, personaState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentityVerificationWithDetailsBankModel {\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    outcome: ").append(toIndentedString(outcome)).append("\n");
    sb.append("    failureCodes: ").append(toIndentedString(failureCodes)).append("\n");
    sb.append("    personaInquiryId: ").append(toIndentedString(personaInquiryId)).append("\n");
    sb.append("    personaState: ").append(toIndentedString(personaState)).append("\n");
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


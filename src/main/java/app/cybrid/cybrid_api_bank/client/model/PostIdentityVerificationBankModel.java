/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Introduction](https://docs.cybrid.xyz/docs/introduction) 2. [Platform Introduction](https://docs.cybrid.xyz/docs/how-is-cybrid-architected) 3. [Testing with Hosted Web Demo App](https://docs.cybrid.xyz/docs/testing-with-hosted-web-demo-app)  In [Getting Started in the Cybrid Sandbox](https://docs.cybrid.xyz/docs/how-do-i-get-started-with-the-sandbox), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.production.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:write counterparties:execute customers:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read external_bank_accounts:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:write identity_verifications:execute files:read files:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read customers:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:execute external_bank_accounts:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read files:read files:execute' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               | | Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |  ## Available Endpoints  The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create and list organization users                                                                | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             | | Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.123.359
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.model;

import java.util.Objects;
import java.util.Arrays;
import app.cybrid.cybrid_api_bank.client.model.PostIdentificationNumberBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostIdentityVerificationAddressBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostIdentityVerificationAliasesInnerBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostIdentityVerificationNameBankModel;
import app.cybrid.cybrid_api_bank.client.model.PostUltimateBeneficialOwnerBankModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Request body for identity verification creation.
 */
@ApiModel(description = "Request body for identity verification creation.")
@JsonPropertyOrder({
  PostIdentityVerificationBankModel.JSON_PROPERTY_TYPE,
  PostIdentityVerificationBankModel.JSON_PROPERTY_CUSTOMER_GUID,
  PostIdentityVerificationBankModel.JSON_PROPERTY_EXPECTED_BEHAVIOURS,
  PostIdentityVerificationBankModel.JSON_PROPERTY_METHOD,
  PostIdentityVerificationBankModel.JSON_PROPERTY_COUNTERPARTY_GUID,
  PostIdentityVerificationBankModel.JSON_PROPERTY_COUNTRY_CODE,
  PostIdentityVerificationBankModel.JSON_PROPERTY_NAME,
  PostIdentityVerificationBankModel.JSON_PROPERTY_ADDRESS,
  PostIdentityVerificationBankModel.JSON_PROPERTY_DATE_OF_BIRTH,
  PostIdentityVerificationBankModel.JSON_PROPERTY_IDENTIFICATION_NUMBERS,
  PostIdentityVerificationBankModel.JSON_PROPERTY_ALIASES,
  PostIdentityVerificationBankModel.JSON_PROPERTY_PHONE_NUMBER,
  PostIdentityVerificationBankModel.JSON_PROPERTY_EMAIL_ADDRESS,
  PostIdentityVerificationBankModel.JSON_PROPERTY_WEBSITE,
  PostIdentityVerificationBankModel.JSON_PROPERTY_NATURE_OF_BUSINESS,
  PostIdentityVerificationBankModel.JSON_PROPERTY_DIRECTOR_CUSTOMER_GUIDS,
  PostIdentityVerificationBankModel.JSON_PROPERTY_ULTIMATE_BENEFICIAL_OWNERS,
  PostIdentityVerificationBankModel.JSON_PROPERTY_SUPPORTING_FILE_GUIDS,
  PostIdentityVerificationBankModel.JSON_PROPERTY_OCCUPATION,
  PostIdentityVerificationBankModel.JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID
})
@JsonTypeName("PostIdentityVerification")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-07T13:39:08.990842Z[Etc/UTC]")
public class PostIdentityVerificationBankModel {
  /**
   * The type of identity verification.
   */
  public enum TypeEnum {
    KYC("kyc"),
    
    BANK_ACCOUNT("bank_account"),
    
    COUNTERPARTY("counterparty");

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

  public static final String JSON_PROPERTY_CUSTOMER_GUID = "customer_guid";
  private JsonNullable<String> customerGuid = JsonNullable.<String>undefined();

  /**
   * Gets or Sets expectedBehaviours
   */
  public enum ExpectedBehavioursEnum {
    PASSED_IMMEDIATELY("passed_immediately"),
    
    FAILED_IMMEDIATELY("failed_immediately"),
    
    TAX_ID_NOT_CHECKED("tax_id_not_checked");

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
  private JsonNullable<List<ExpectedBehavioursEnum>> expectedBehaviours = JsonNullable.<List<ExpectedBehavioursEnum>>undefined();

  /**
   * The identity verification method. Required when type is counterparty, type is kyc, or type is bank_account.
   */
  public enum MethodEnum {
    WATCHLISTS("watchlists"),
    
    ATTESTED("attested"),
    
    DOCUMENT_SUBMISSION("document_submission"),
    
    ID_AND_SELFIE("id_and_selfie"),
    
    TAX_ID_AND_SELFIE("tax_id_and_selfie"),
    
    BUSINESS_REGISTRATION("business_registration"),
    
    ATTESTED_ID_AND_SELFIE("attested_id_and_selfie"),
    
    ATTESTED_BUSINESS_REGISTRATION("attested_business_registration"),
    
    ATTESTED_OWNERSHIP("attested_ownership"),
    
    ACCOUNT_OWNERSHIP("account_ownership");

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
      return null;
    }
  }

  public static final String JSON_PROPERTY_METHOD = "method";
  private JsonNullable<MethodEnum> method = JsonNullable.<MethodEnum>undefined();

  public static final String JSON_PROPERTY_COUNTERPARTY_GUID = "counterparty_guid";
  private JsonNullable<String> counterpartyGuid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_COUNTRY_CODE = "country_code";
  private JsonNullable<String> countryCode = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_NAME = "name";
  private JsonNullable<PostIdentityVerificationNameBankModel> name = JsonNullable.<PostIdentityVerificationNameBankModel>undefined();

  public static final String JSON_PROPERTY_ADDRESS = "address";
  private JsonNullable<PostIdentityVerificationAddressBankModel> address = JsonNullable.<PostIdentityVerificationAddressBankModel>undefined();

  public static final String JSON_PROPERTY_DATE_OF_BIRTH = "date_of_birth";
  private JsonNullable<LocalDate> dateOfBirth = JsonNullable.<LocalDate>undefined();

  public static final String JSON_PROPERTY_IDENTIFICATION_NUMBERS = "identification_numbers";
  private JsonNullable<List<PostIdentificationNumberBankModel>> identificationNumbers = JsonNullable.<List<PostIdentificationNumberBankModel>>undefined();

  public static final String JSON_PROPERTY_ALIASES = "aliases";
  private JsonNullable<List<PostIdentityVerificationAliasesInnerBankModel>> aliases = JsonNullable.<List<PostIdentityVerificationAliasesInnerBankModel>>undefined();

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phone_number";
  private JsonNullable<String> phoneNumber = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_EMAIL_ADDRESS = "email_address";
  private JsonNullable<String> emailAddress = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_WEBSITE = "website";
  private JsonNullable<String> website = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_NATURE_OF_BUSINESS = "nature_of_business";
  private JsonNullable<String> natureOfBusiness = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_DIRECTOR_CUSTOMER_GUIDS = "director_customer_guids";
  private JsonNullable<List<String>> directorCustomerGuids = JsonNullable.<List<String>>undefined();

  public static final String JSON_PROPERTY_ULTIMATE_BENEFICIAL_OWNERS = "ultimate_beneficial_owners";
  private JsonNullable<List<PostUltimateBeneficialOwnerBankModel>> ultimateBeneficialOwners = JsonNullable.<List<PostUltimateBeneficialOwnerBankModel>>undefined();

  public static final String JSON_PROPERTY_SUPPORTING_FILE_GUIDS = "supporting_file_guids";
  private JsonNullable<List<String>> supportingFileGuids = JsonNullable.<List<String>>undefined();

  public static final String JSON_PROPERTY_OCCUPATION = "occupation";
  private JsonNullable<String> occupation = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_EXTERNAL_BANK_ACCOUNT_GUID = "external_bank_account_guid";
  private JsonNullable<String> externalBankAccountGuid = JsonNullable.<String>undefined();

  public PostIdentityVerificationBankModel() { 
  }

  public PostIdentityVerificationBankModel type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * The type of identity verification.
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The type of identity verification.")
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


  public PostIdentityVerificationBankModel customerGuid(String customerGuid) {
    this.customerGuid = JsonNullable.<String>of(customerGuid);
    
    return this;
  }

   /**
   * The customer&#39;s identifier. Required when type is kyc and method is attested_business_registration or type is kyc and method is attested_id_and_selfie.
   * @return customerGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's identifier. Required when type is kyc and method is attested_business_registration or type is kyc and method is attested_id_and_selfie.")
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


  public PostIdentityVerificationBankModel expectedBehaviours(List<ExpectedBehavioursEnum> expectedBehaviours) {
    this.expectedBehaviours = JsonNullable.<List<ExpectedBehavioursEnum>>of(expectedBehaviours);
    
    return this;
  }

  public PostIdentityVerificationBankModel addExpectedBehavioursItem(ExpectedBehavioursEnum expectedBehavioursItem) {
    if (this.expectedBehaviours == null || !this.expectedBehaviours.isPresent()) {
      this.expectedBehaviours = JsonNullable.<List<ExpectedBehavioursEnum>>of(new ArrayList<>());
    }
    try {
      this.expectedBehaviours.get().add(expectedBehavioursItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The optional expected behaviour to simulate.
   * @return expectedBehaviours
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The optional expected behaviour to simulate.")
  @JsonIgnore

  public List<ExpectedBehavioursEnum> getExpectedBehaviours() {
        return expectedBehaviours.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXPECTED_BEHAVIOURS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<ExpectedBehavioursEnum>> getExpectedBehaviours_JsonNullable() {
    return expectedBehaviours;
  }
  
  @JsonProperty(JSON_PROPERTY_EXPECTED_BEHAVIOURS)
  public void setExpectedBehaviours_JsonNullable(JsonNullable<List<ExpectedBehavioursEnum>> expectedBehaviours) {
    this.expectedBehaviours = expectedBehaviours;
  }

  public void setExpectedBehaviours(List<ExpectedBehavioursEnum> expectedBehaviours) {
    this.expectedBehaviours = JsonNullable.<List<ExpectedBehavioursEnum>>of(expectedBehaviours);
  }


  public PostIdentityVerificationBankModel method(MethodEnum method) {
    this.method = JsonNullable.<MethodEnum>of(method);
    
    return this;
  }

   /**
   * The identity verification method. Required when type is counterparty, type is kyc, or type is bank_account.
   * @return method
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identity verification method. Required when type is counterparty, type is kyc, or type is bank_account.")
  @JsonIgnore

  public MethodEnum getMethod() {
        return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<MethodEnum> getMethod_JsonNullable() {
    return method;
  }
  
  @JsonProperty(JSON_PROPERTY_METHOD)
  public void setMethod_JsonNullable(JsonNullable<MethodEnum> method) {
    this.method = method;
  }

  public void setMethod(MethodEnum method) {
    this.method = JsonNullable.<MethodEnum>of(method);
  }


  public PostIdentityVerificationBankModel counterpartyGuid(String counterpartyGuid) {
    this.counterpartyGuid = JsonNullable.<String>of(counterpartyGuid);
    
    return this;
  }

   /**
   * The counterparty&#39;s identifier. Required when type is counterparty.
   * @return counterpartyGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The counterparty's identifier. Required when type is counterparty.")
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


  public PostIdentityVerificationBankModel countryCode(String countryCode) {
    this.countryCode = JsonNullable.<String>of(countryCode);
    
    return this;
  }

   /**
   * The ISO 3166 country 2-Alpha country the customer is being verified in. If not present, will default to the Bank&#39;s configured country code. Optional when type is kyc and method is id_and_selfie, type is kyc and method is tax_id_and_selfie, or type is kyc and method is business_registration.
   * @return countryCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ISO 3166 country 2-Alpha country the customer is being verified in. If not present, will default to the Bank's configured country code. Optional when type is kyc and method is id_and_selfie, type is kyc and method is tax_id_and_selfie, or type is kyc and method is business_registration.")
  @JsonIgnore

  public String getCountryCode() {
        return countryCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getCountryCode_JsonNullable() {
    return countryCode;
  }
  
  @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
  public void setCountryCode_JsonNullable(JsonNullable<String> countryCode) {
    this.countryCode = countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = JsonNullable.<String>of(countryCode);
  }


  public PostIdentityVerificationBankModel name(PostIdentityVerificationNameBankModel name) {
    this.name = JsonNullable.<PostIdentityVerificationNameBankModel>of(name);
    
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonIgnore

  public PostIdentityVerificationNameBankModel getName() {
        return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<PostIdentityVerificationNameBankModel> getName_JsonNullable() {
    return name;
  }
  
  @JsonProperty(JSON_PROPERTY_NAME)
  public void setName_JsonNullable(JsonNullable<PostIdentityVerificationNameBankModel> name) {
    this.name = name;
  }

  public void setName(PostIdentityVerificationNameBankModel name) {
    this.name = JsonNullable.<PostIdentityVerificationNameBankModel>of(name);
  }


  public PostIdentityVerificationBankModel address(PostIdentityVerificationAddressBankModel address) {
    this.address = JsonNullable.<PostIdentityVerificationAddressBankModel>of(address);
    
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonIgnore

  public PostIdentityVerificationAddressBankModel getAddress() {
        return address.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<PostIdentityVerificationAddressBankModel> getAddress_JsonNullable() {
    return address;
  }
  
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  public void setAddress_JsonNullable(JsonNullable<PostIdentityVerificationAddressBankModel> address) {
    this.address = address;
  }

  public void setAddress(PostIdentityVerificationAddressBankModel address) {
    this.address = JsonNullable.<PostIdentityVerificationAddressBankModel>of(address);
  }


  public PostIdentityVerificationBankModel dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = JsonNullable.<LocalDate>of(dateOfBirth);
    
    return this;
  }

   /**
   * The customer&#39;s date of birth. Required when type is kyc and method is attested or type is kyc and method is attested_id_and_selfie.
   * @return dateOfBirth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's date of birth. Required when type is kyc and method is attested or type is kyc and method is attested_id_and_selfie.")
  @JsonIgnore

  public LocalDate getDateOfBirth() {
        return dateOfBirth.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DATE_OF_BIRTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<LocalDate> getDateOfBirth_JsonNullable() {
    return dateOfBirth;
  }
  
  @JsonProperty(JSON_PROPERTY_DATE_OF_BIRTH)
  public void setDateOfBirth_JsonNullable(JsonNullable<LocalDate> dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = JsonNullable.<LocalDate>of(dateOfBirth);
  }


  public PostIdentityVerificationBankModel identificationNumbers(List<PostIdentificationNumberBankModel> identificationNumbers) {
    this.identificationNumbers = JsonNullable.<List<PostIdentificationNumberBankModel>>of(identificationNumbers);
    
    return this;
  }

  public PostIdentityVerificationBankModel addIdentificationNumbersItem(PostIdentificationNumberBankModel identificationNumbersItem) {
    if (this.identificationNumbers == null || !this.identificationNumbers.isPresent()) {
      this.identificationNumbers = JsonNullable.<List<PostIdentificationNumberBankModel>>of(new ArrayList<>());
    }
    try {
      this.identificationNumbers.get().add(identificationNumbersItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The customer&#39;s identification numbers. Required when type is kyc and method is attested, type is kyc and method is attested_business_registration, or type is kyc and method is attested_id_and_selfie.
   * @return identificationNumbers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's identification numbers. Required when type is kyc and method is attested, type is kyc and method is attested_business_registration, or type is kyc and method is attested_id_and_selfie.")
  @JsonIgnore

  public List<PostIdentificationNumberBankModel> getIdentificationNumbers() {
        return identificationNumbers.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTIFICATION_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<PostIdentificationNumberBankModel>> getIdentificationNumbers_JsonNullable() {
    return identificationNumbers;
  }
  
  @JsonProperty(JSON_PROPERTY_IDENTIFICATION_NUMBERS)
  public void setIdentificationNumbers_JsonNullable(JsonNullable<List<PostIdentificationNumberBankModel>> identificationNumbers) {
    this.identificationNumbers = identificationNumbers;
  }

  public void setIdentificationNumbers(List<PostIdentificationNumberBankModel> identificationNumbers) {
    this.identificationNumbers = JsonNullable.<List<PostIdentificationNumberBankModel>>of(identificationNumbers);
  }


  public PostIdentityVerificationBankModel aliases(List<PostIdentityVerificationAliasesInnerBankModel> aliases) {
    this.aliases = JsonNullable.<List<PostIdentityVerificationAliasesInnerBankModel>>of(aliases);
    
    return this;
  }

  public PostIdentityVerificationBankModel addAliasesItem(PostIdentityVerificationAliasesInnerBankModel aliasesItem) {
    if (this.aliases == null || !this.aliases.isPresent()) {
      this.aliases = JsonNullable.<List<PostIdentityVerificationAliasesInnerBankModel>>of(new ArrayList<>());
    }
    try {
      this.aliases.get().add(aliasesItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The aliases of the customer. Optional when type is kyc and method is attested_business_registration.
   * @return aliases
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The aliases of the customer. Optional when type is kyc and method is attested_business_registration.")
  @JsonIgnore

  public List<PostIdentityVerificationAliasesInnerBankModel> getAliases() {
        return aliases.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ALIASES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<PostIdentityVerificationAliasesInnerBankModel>> getAliases_JsonNullable() {
    return aliases;
  }
  
  @JsonProperty(JSON_PROPERTY_ALIASES)
  public void setAliases_JsonNullable(JsonNullable<List<PostIdentityVerificationAliasesInnerBankModel>> aliases) {
    this.aliases = aliases;
  }

  public void setAliases(List<PostIdentityVerificationAliasesInnerBankModel> aliases) {
    this.aliases = JsonNullable.<List<PostIdentityVerificationAliasesInnerBankModel>>of(aliases);
  }


  public PostIdentityVerificationBankModel phoneNumber(String phoneNumber) {
    this.phoneNumber = JsonNullable.<String>of(phoneNumber);
    
    return this;
  }

   /**
   * The customer&#39;s phone number. Required when type is kyc and method is attested_business_registration or type is kyc and method is attested_id_and_selfie. Optional when type is bank_account and method is attested_ownership.
   * @return phoneNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's phone number. Required when type is kyc and method is attested_business_registration or type is kyc and method is attested_id_and_selfie. Optional when type is bank_account and method is attested_ownership.")
  @JsonIgnore

  public String getPhoneNumber() {
        return phoneNumber.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPhoneNumber_JsonNullable() {
    return phoneNumber;
  }
  
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  public void setPhoneNumber_JsonNullable(JsonNullable<String> phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = JsonNullable.<String>of(phoneNumber);
  }


  public PostIdentityVerificationBankModel emailAddress(String emailAddress) {
    this.emailAddress = JsonNullable.<String>of(emailAddress);
    
    return this;
  }

   /**
   * The customer&#39;s email address. Required when type is kyc and method is attested_business_registration or type is kyc and method is attested_id_and_selfie. Optional when type is bank_account and method is attested_ownership.
   * @return emailAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's email address. Required when type is kyc and method is attested_business_registration or type is kyc and method is attested_id_and_selfie. Optional when type is bank_account and method is attested_ownership.")
  @JsonIgnore

  public String getEmailAddress() {
        return emailAddress.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EMAIL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getEmailAddress_JsonNullable() {
    return emailAddress;
  }
  
  @JsonProperty(JSON_PROPERTY_EMAIL_ADDRESS)
  public void setEmailAddress_JsonNullable(JsonNullable<String> emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = JsonNullable.<String>of(emailAddress);
  }


  public PostIdentityVerificationBankModel website(String website) {
    this.website = JsonNullable.<String>of(website);
    
    return this;
  }

   /**
   * The customer&#39;s website. Required when type is kyc and method is attested_business_registration.
   * @return website
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's website. Required when type is kyc and method is attested_business_registration.")
  @JsonIgnore

  public String getWebsite() {
        return website.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WEBSITE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getWebsite_JsonNullable() {
    return website;
  }
  
  @JsonProperty(JSON_PROPERTY_WEBSITE)
  public void setWebsite_JsonNullable(JsonNullable<String> website) {
    this.website = website;
  }

  public void setWebsite(String website) {
    this.website = JsonNullable.<String>of(website);
  }


  public PostIdentityVerificationBankModel natureOfBusiness(String natureOfBusiness) {
    this.natureOfBusiness = JsonNullable.<String>of(natureOfBusiness);
    
    return this;
  }

   /**
   * The customer&#39;s nature of business. Required when type is kyc and method is attested_business_registration.
   * @return natureOfBusiness
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's nature of business. Required when type is kyc and method is attested_business_registration.")
  @JsonIgnore

  public String getNatureOfBusiness() {
        return natureOfBusiness.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NATURE_OF_BUSINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getNatureOfBusiness_JsonNullable() {
    return natureOfBusiness;
  }
  
  @JsonProperty(JSON_PROPERTY_NATURE_OF_BUSINESS)
  public void setNatureOfBusiness_JsonNullable(JsonNullable<String> natureOfBusiness) {
    this.natureOfBusiness = natureOfBusiness;
  }

  public void setNatureOfBusiness(String natureOfBusiness) {
    this.natureOfBusiness = JsonNullable.<String>of(natureOfBusiness);
  }


  public PostIdentityVerificationBankModel directorCustomerGuids(List<String> directorCustomerGuids) {
    this.directorCustomerGuids = JsonNullable.<List<String>>of(directorCustomerGuids);
    
    return this;
  }

  public PostIdentityVerificationBankModel addDirectorCustomerGuidsItem(String directorCustomerGuidsItem) {
    if (this.directorCustomerGuids == null || !this.directorCustomerGuids.isPresent()) {
      this.directorCustomerGuids = JsonNullable.<List<String>>of(new ArrayList<>());
    }
    try {
      this.directorCustomerGuids.get().add(directorCustomerGuidsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The customer guids of the directors of the business Required when type is kyc and method is attested_business_registration.
   * @return directorCustomerGuids
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer guids of the directors of the business Required when type is kyc and method is attested_business_registration.")
  @JsonIgnore

  public List<String> getDirectorCustomerGuids() {
        return directorCustomerGuids.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIRECTOR_CUSTOMER_GUIDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<String>> getDirectorCustomerGuids_JsonNullable() {
    return directorCustomerGuids;
  }
  
  @JsonProperty(JSON_PROPERTY_DIRECTOR_CUSTOMER_GUIDS)
  public void setDirectorCustomerGuids_JsonNullable(JsonNullable<List<String>> directorCustomerGuids) {
    this.directorCustomerGuids = directorCustomerGuids;
  }

  public void setDirectorCustomerGuids(List<String> directorCustomerGuids) {
    this.directorCustomerGuids = JsonNullable.<List<String>>of(directorCustomerGuids);
  }


  public PostIdentityVerificationBankModel ultimateBeneficialOwners(List<PostUltimateBeneficialOwnerBankModel> ultimateBeneficialOwners) {
    this.ultimateBeneficialOwners = JsonNullable.<List<PostUltimateBeneficialOwnerBankModel>>of(ultimateBeneficialOwners);
    
    return this;
  }

  public PostIdentityVerificationBankModel addUltimateBeneficialOwnersItem(PostUltimateBeneficialOwnerBankModel ultimateBeneficialOwnersItem) {
    if (this.ultimateBeneficialOwners == null || !this.ultimateBeneficialOwners.isPresent()) {
      this.ultimateBeneficialOwners = JsonNullable.<List<PostUltimateBeneficialOwnerBankModel>>of(new ArrayList<>());
    }
    try {
      this.ultimateBeneficialOwners.get().add(ultimateBeneficialOwnersItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The ultimate beneficial owners of the business with 10% or more ownership Required when type is kyc and method is attested_business_registration.
   * @return ultimateBeneficialOwners
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ultimate beneficial owners of the business with 10% or more ownership Required when type is kyc and method is attested_business_registration.")
  @JsonIgnore

  public List<PostUltimateBeneficialOwnerBankModel> getUltimateBeneficialOwners() {
        return ultimateBeneficialOwners.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ULTIMATE_BENEFICIAL_OWNERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<PostUltimateBeneficialOwnerBankModel>> getUltimateBeneficialOwners_JsonNullable() {
    return ultimateBeneficialOwners;
  }
  
  @JsonProperty(JSON_PROPERTY_ULTIMATE_BENEFICIAL_OWNERS)
  public void setUltimateBeneficialOwners_JsonNullable(JsonNullable<List<PostUltimateBeneficialOwnerBankModel>> ultimateBeneficialOwners) {
    this.ultimateBeneficialOwners = ultimateBeneficialOwners;
  }

  public void setUltimateBeneficialOwners(List<PostUltimateBeneficialOwnerBankModel> ultimateBeneficialOwners) {
    this.ultimateBeneficialOwners = JsonNullable.<List<PostUltimateBeneficialOwnerBankModel>>of(ultimateBeneficialOwners);
  }


  public PostIdentityVerificationBankModel supportingFileGuids(List<String> supportingFileGuids) {
    this.supportingFileGuids = JsonNullable.<List<String>>of(supportingFileGuids);
    
    return this;
  }

  public PostIdentityVerificationBankModel addSupportingFileGuidsItem(String supportingFileGuidsItem) {
    if (this.supportingFileGuids == null || !this.supportingFileGuids.isPresent()) {
      this.supportingFileGuids = JsonNullable.<List<String>>of(new ArrayList<>());
    }
    try {
      this.supportingFileGuids.get().add(supportingFileGuidsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * File guids supporting the verification Required when type is kyc and method is attested_business_registration or type is kyc and method is attested_id_and_selfie.
   * @return supportingFileGuids
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "File guids supporting the verification Required when type is kyc and method is attested_business_registration or type is kyc and method is attested_id_and_selfie.")
  @JsonIgnore

  public List<String> getSupportingFileGuids() {
        return supportingFileGuids.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SUPPORTING_FILE_GUIDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<String>> getSupportingFileGuids_JsonNullable() {
    return supportingFileGuids;
  }
  
  @JsonProperty(JSON_PROPERTY_SUPPORTING_FILE_GUIDS)
  public void setSupportingFileGuids_JsonNullable(JsonNullable<List<String>> supportingFileGuids) {
    this.supportingFileGuids = supportingFileGuids;
  }

  public void setSupportingFileGuids(List<String> supportingFileGuids) {
    this.supportingFileGuids = JsonNullable.<List<String>>of(supportingFileGuids);
  }


  public PostIdentityVerificationBankModel occupation(String occupation) {
    this.occupation = JsonNullable.<String>of(occupation);
    
    return this;
  }

   /**
   * The customer&#39;s occupation. Required when type is kyc and method is attested_id_and_selfie.
   * @return occupation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's occupation. Required when type is kyc and method is attested_id_and_selfie.")
  @JsonIgnore

  public String getOccupation() {
        return occupation.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OCCUPATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getOccupation_JsonNullable() {
    return occupation;
  }
  
  @JsonProperty(JSON_PROPERTY_OCCUPATION)
  public void setOccupation_JsonNullable(JsonNullable<String> occupation) {
    this.occupation = occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = JsonNullable.<String>of(occupation);
  }


  public PostIdentityVerificationBankModel externalBankAccountGuid(String externalBankAccountGuid) {
    this.externalBankAccountGuid = JsonNullable.<String>of(externalBankAccountGuid);
    
    return this;
  }

   /**
   * The external bank account&#39;s identifier. Required when type is bank_account.
   * @return externalBankAccountGuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The external bank account's identifier. Required when type is bank_account.")
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostIdentityVerificationBankModel postIdentityVerification = (PostIdentityVerificationBankModel) o;
    return Objects.equals(this.type, postIdentityVerification.type) &&
        equalsNullable(this.customerGuid, postIdentityVerification.customerGuid) &&
        equalsNullable(this.expectedBehaviours, postIdentityVerification.expectedBehaviours) &&
        equalsNullable(this.method, postIdentityVerification.method) &&
        equalsNullable(this.counterpartyGuid, postIdentityVerification.counterpartyGuid) &&
        equalsNullable(this.countryCode, postIdentityVerification.countryCode) &&
        equalsNullable(this.name, postIdentityVerification.name) &&
        equalsNullable(this.address, postIdentityVerification.address) &&
        equalsNullable(this.dateOfBirth, postIdentityVerification.dateOfBirth) &&
        equalsNullable(this.identificationNumbers, postIdentityVerification.identificationNumbers) &&
        equalsNullable(this.aliases, postIdentityVerification.aliases) &&
        equalsNullable(this.phoneNumber, postIdentityVerification.phoneNumber) &&
        equalsNullable(this.emailAddress, postIdentityVerification.emailAddress) &&
        equalsNullable(this.website, postIdentityVerification.website) &&
        equalsNullable(this.natureOfBusiness, postIdentityVerification.natureOfBusiness) &&
        equalsNullable(this.directorCustomerGuids, postIdentityVerification.directorCustomerGuids) &&
        equalsNullable(this.ultimateBeneficialOwners, postIdentityVerification.ultimateBeneficialOwners) &&
        equalsNullable(this.supportingFileGuids, postIdentityVerification.supportingFileGuids) &&
        equalsNullable(this.occupation, postIdentityVerification.occupation) &&
        equalsNullable(this.externalBankAccountGuid, postIdentityVerification.externalBankAccountGuid);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, hashCodeNullable(customerGuid), hashCodeNullable(expectedBehaviours), hashCodeNullable(method), hashCodeNullable(counterpartyGuid), hashCodeNullable(countryCode), hashCodeNullable(name), hashCodeNullable(address), hashCodeNullable(dateOfBirth), hashCodeNullable(identificationNumbers), hashCodeNullable(aliases), hashCodeNullable(phoneNumber), hashCodeNullable(emailAddress), hashCodeNullable(website), hashCodeNullable(natureOfBusiness), hashCodeNullable(directorCustomerGuids), hashCodeNullable(ultimateBeneficialOwners), hashCodeNullable(supportingFileGuids), hashCodeNullable(occupation), hashCodeNullable(externalBankAccountGuid));
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
    sb.append("class PostIdentityVerificationBankModel {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    customerGuid: ").append(toIndentedString(customerGuid)).append("\n");
    sb.append("    expectedBehaviours: ").append(toIndentedString(expectedBehaviours)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    counterpartyGuid: ").append(toIndentedString(counterpartyGuid)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    identificationNumbers: ").append(toIndentedString(identificationNumbers)).append("\n");
    sb.append("    aliases: ").append(toIndentedString(aliases)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    website: ").append(toIndentedString(website)).append("\n");
    sb.append("    natureOfBusiness: ").append(toIndentedString(natureOfBusiness)).append("\n");
    sb.append("    directorCustomerGuids: ").append(toIndentedString(directorCustomerGuids)).append("\n");
    sb.append("    ultimateBeneficialOwners: ").append(toIndentedString(ultimateBeneficialOwners)).append("\n");
    sb.append("    supportingFileGuids: ").append(toIndentedString(supportingFileGuids)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    externalBankAccountGuid: ").append(toIndentedString(externalBankAccountGuid)).append("\n");
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


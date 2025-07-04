/*
 * Cybrid Bank API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Introduction](https://docs.cybrid.xyz/docs/introduction) 2. [Platform Introduction](https://docs.cybrid.xyz/docs/how-is-cybrid-architected) 3. [Testing with Hosted Web Demo App](https://docs.cybrid.xyz/docs/testing-with-hosted-web-demo-app)  In [Getting Started in the Cybrid Sandbox](https://docs.cybrid.xyz/docs/how-do-i-get-started-with-the-sandbox), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.production.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:pii:read counterparties:write counterparties:execute customers:read customers:pii:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read transfers:write external_bank_accounts:read external_bank_accounts:pii:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:pii:read identity_verifications:write identity_verifications:execute persona_sessions:execute files:read files:pii:read files:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read counterparties:pii:read customers:read customers:pii:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:write transfers:execute external_bank_accounts:read external_bank_accounts:pii:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read identity_verifications:pii:read identity_verifications:execute persona_sessions:execute files:read files:pii:read files:execute' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               | | Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |  ## Available Endpoints  The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create and list organization users                                                                | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             | | Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.123.652
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_bank.client.model;

import java.util.Objects;
import java.util.Arrays;
import app.cybrid.cybrid_api_bank.client.model.IdentificationNumberBankModel;
import app.cybrid.cybrid_api_bank.client.model.IdentityVerificationWithDetailsPiiAddressBankModel;
import app.cybrid.cybrid_api_bank.client.model.IdentityVerificationWithDetailsPiiAliasesInnerBankModel;
import app.cybrid.cybrid_api_bank.client.model.IdentityVerificationWithDetailsPiiNameBankModel;
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
 * The personally identifiable information associated with the identity verification.
 */
@ApiModel(description = "The personally identifiable information associated with the identity verification.")
@JsonPropertyOrder({
  IdentityVerificationWithDetailsPiiBankModel.JSON_PROPERTY_NAME,
  IdentityVerificationWithDetailsPiiBankModel.JSON_PROPERTY_ALIASES,
  IdentityVerificationWithDetailsPiiBankModel.JSON_PROPERTY_ADDRESS,
  IdentityVerificationWithDetailsPiiBankModel.JSON_PROPERTY_DATE_OF_BIRTH,
  IdentityVerificationWithDetailsPiiBankModel.JSON_PROPERTY_PHONE_NUMBER,
  IdentityVerificationWithDetailsPiiBankModel.JSON_PROPERTY_EMAIL_ADDRESS,
  IdentityVerificationWithDetailsPiiBankModel.JSON_PROPERTY_OCCUPATION,
  IdentityVerificationWithDetailsPiiBankModel.JSON_PROPERTY_WEBSITE,
  IdentityVerificationWithDetailsPiiBankModel.JSON_PROPERTY_NATURE_OF_BUSINESS,
  IdentityVerificationWithDetailsPiiBankModel.JSON_PROPERTY_IDENTIFICATION_NUMBERS
})
@JsonTypeName("IdentityVerificationWithDetails_pii")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-30T15:22:52.716328Z[Etc/UTC]")
public class IdentityVerificationWithDetailsPiiBankModel {
  public static final String JSON_PROPERTY_NAME = "name";
  private JsonNullable<IdentityVerificationWithDetailsPiiNameBankModel> name = JsonNullable.<IdentityVerificationWithDetailsPiiNameBankModel>undefined();

  public static final String JSON_PROPERTY_ALIASES = "aliases";
  private JsonNullable<List<IdentityVerificationWithDetailsPiiAliasesInnerBankModel>> aliases = JsonNullable.<List<IdentityVerificationWithDetailsPiiAliasesInnerBankModel>>undefined();

  public static final String JSON_PROPERTY_ADDRESS = "address";
  private JsonNullable<IdentityVerificationWithDetailsPiiAddressBankModel> address = JsonNullable.<IdentityVerificationWithDetailsPiiAddressBankModel>undefined();

  public static final String JSON_PROPERTY_DATE_OF_BIRTH = "date_of_birth";
  private JsonNullable<LocalDate> dateOfBirth = JsonNullable.<LocalDate>undefined();

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phone_number";
  private JsonNullable<String> phoneNumber = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_EMAIL_ADDRESS = "email_address";
  private JsonNullable<String> emailAddress = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_OCCUPATION = "occupation";
  private JsonNullable<String> occupation = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_WEBSITE = "website";
  private JsonNullable<String> website = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_NATURE_OF_BUSINESS = "nature_of_business";
  private JsonNullable<String> natureOfBusiness = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_IDENTIFICATION_NUMBERS = "identification_numbers";
  private JsonNullable<List<IdentificationNumberBankModel>> identificationNumbers = JsonNullable.<List<IdentificationNumberBankModel>>undefined();

  public IdentityVerificationWithDetailsPiiBankModel() { 
  }

  public IdentityVerificationWithDetailsPiiBankModel name(IdentityVerificationWithDetailsPiiNameBankModel name) {
    this.name = JsonNullable.<IdentityVerificationWithDetailsPiiNameBankModel>of(name);
    
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonIgnore

  public IdentityVerificationWithDetailsPiiNameBankModel getName() {
        return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<IdentityVerificationWithDetailsPiiNameBankModel> getName_JsonNullable() {
    return name;
  }
  
  @JsonProperty(JSON_PROPERTY_NAME)
  public void setName_JsonNullable(JsonNullable<IdentityVerificationWithDetailsPiiNameBankModel> name) {
    this.name = name;
  }

  public void setName(IdentityVerificationWithDetailsPiiNameBankModel name) {
    this.name = JsonNullable.<IdentityVerificationWithDetailsPiiNameBankModel>of(name);
  }


  public IdentityVerificationWithDetailsPiiBankModel aliases(List<IdentityVerificationWithDetailsPiiAliasesInnerBankModel> aliases) {
    this.aliases = JsonNullable.<List<IdentityVerificationWithDetailsPiiAliasesInnerBankModel>>of(aliases);
    
    return this;
  }

  public IdentityVerificationWithDetailsPiiBankModel addAliasesItem(IdentityVerificationWithDetailsPiiAliasesInnerBankModel aliasesItem) {
    if (this.aliases == null || !this.aliases.isPresent()) {
      this.aliases = JsonNullable.<List<IdentityVerificationWithDetailsPiiAliasesInnerBankModel>>of(new ArrayList<>());
    }
    try {
      this.aliases.get().add(aliasesItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The business attested aliases.
   * @return aliases
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The business attested aliases.")
  @JsonIgnore

  public List<IdentityVerificationWithDetailsPiiAliasesInnerBankModel> getAliases() {
        return aliases.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ALIASES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<IdentityVerificationWithDetailsPiiAliasesInnerBankModel>> getAliases_JsonNullable() {
    return aliases;
  }
  
  @JsonProperty(JSON_PROPERTY_ALIASES)
  public void setAliases_JsonNullable(JsonNullable<List<IdentityVerificationWithDetailsPiiAliasesInnerBankModel>> aliases) {
    this.aliases = aliases;
  }

  public void setAliases(List<IdentityVerificationWithDetailsPiiAliasesInnerBankModel> aliases) {
    this.aliases = JsonNullable.<List<IdentityVerificationWithDetailsPiiAliasesInnerBankModel>>of(aliases);
  }


  public IdentityVerificationWithDetailsPiiBankModel address(IdentityVerificationWithDetailsPiiAddressBankModel address) {
    this.address = JsonNullable.<IdentityVerificationWithDetailsPiiAddressBankModel>of(address);
    
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonIgnore

  public IdentityVerificationWithDetailsPiiAddressBankModel getAddress() {
        return address.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<IdentityVerificationWithDetailsPiiAddressBankModel> getAddress_JsonNullable() {
    return address;
  }
  
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  public void setAddress_JsonNullable(JsonNullable<IdentityVerificationWithDetailsPiiAddressBankModel> address) {
    this.address = address;
  }

  public void setAddress(IdentityVerificationWithDetailsPiiAddressBankModel address) {
    this.address = JsonNullable.<IdentityVerificationWithDetailsPiiAddressBankModel>of(address);
  }


  public IdentityVerificationWithDetailsPiiBankModel dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = JsonNullable.<LocalDate>of(dateOfBirth);
    
    return this;
  }

   /**
   * The attested date of birth.
   * @return dateOfBirth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The attested date of birth.")
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


  public IdentityVerificationWithDetailsPiiBankModel phoneNumber(String phoneNumber) {
    this.phoneNumber = JsonNullable.<String>of(phoneNumber);
    
    return this;
  }

   /**
   * The attested phone number.
   * @return phoneNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The attested phone number.")
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


  public IdentityVerificationWithDetailsPiiBankModel emailAddress(String emailAddress) {
    this.emailAddress = JsonNullable.<String>of(emailAddress);
    
    return this;
  }

   /**
   * The attested email address.
   * @return emailAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The attested email address.")
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


  public IdentityVerificationWithDetailsPiiBankModel occupation(String occupation) {
    this.occupation = JsonNullable.<String>of(occupation);
    
    return this;
  }

   /**
   * The attested occupation.
   * @return occupation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The attested occupation.")
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


  public IdentityVerificationWithDetailsPiiBankModel website(String website) {
    this.website = JsonNullable.<String>of(website);
    
    return this;
  }

   /**
   * The attested website.
   * @return website
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The attested website.")
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


  public IdentityVerificationWithDetailsPiiBankModel natureOfBusiness(String natureOfBusiness) {
    this.natureOfBusiness = JsonNullable.<String>of(natureOfBusiness);
    
    return this;
  }

   /**
   * The attested nature of business.
   * @return natureOfBusiness
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The attested nature of business.")
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


  public IdentityVerificationWithDetailsPiiBankModel identificationNumbers(List<IdentificationNumberBankModel> identificationNumbers) {
    this.identificationNumbers = JsonNullable.<List<IdentificationNumberBankModel>>of(identificationNumbers);
    
    return this;
  }

  public IdentityVerificationWithDetailsPiiBankModel addIdentificationNumbersItem(IdentificationNumberBankModel identificationNumbersItem) {
    if (this.identificationNumbers == null || !this.identificationNumbers.isPresent()) {
      this.identificationNumbers = JsonNullable.<List<IdentificationNumberBankModel>>of(new ArrayList<>());
    }
    try {
      this.identificationNumbers.get().add(identificationNumbersItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * The attested identification numbers.
   * @return identificationNumbers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The attested identification numbers.")
  @JsonIgnore

  public List<IdentificationNumberBankModel> getIdentificationNumbers() {
        return identificationNumbers.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTIFICATION_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<IdentificationNumberBankModel>> getIdentificationNumbers_JsonNullable() {
    return identificationNumbers;
  }
  
  @JsonProperty(JSON_PROPERTY_IDENTIFICATION_NUMBERS)
  public void setIdentificationNumbers_JsonNullable(JsonNullable<List<IdentificationNumberBankModel>> identificationNumbers) {
    this.identificationNumbers = identificationNumbers;
  }

  public void setIdentificationNumbers(List<IdentificationNumberBankModel> identificationNumbers) {
    this.identificationNumbers = JsonNullable.<List<IdentificationNumberBankModel>>of(identificationNumbers);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityVerificationWithDetailsPiiBankModel identityVerificationWithDetailsPii = (IdentityVerificationWithDetailsPiiBankModel) o;
    return equalsNullable(this.name, identityVerificationWithDetailsPii.name) &&
        equalsNullable(this.aliases, identityVerificationWithDetailsPii.aliases) &&
        equalsNullable(this.address, identityVerificationWithDetailsPii.address) &&
        equalsNullable(this.dateOfBirth, identityVerificationWithDetailsPii.dateOfBirth) &&
        equalsNullable(this.phoneNumber, identityVerificationWithDetailsPii.phoneNumber) &&
        equalsNullable(this.emailAddress, identityVerificationWithDetailsPii.emailAddress) &&
        equalsNullable(this.occupation, identityVerificationWithDetailsPii.occupation) &&
        equalsNullable(this.website, identityVerificationWithDetailsPii.website) &&
        equalsNullable(this.natureOfBusiness, identityVerificationWithDetailsPii.natureOfBusiness) &&
        equalsNullable(this.identificationNumbers, identityVerificationWithDetailsPii.identificationNumbers);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(name), hashCodeNullable(aliases), hashCodeNullable(address), hashCodeNullable(dateOfBirth), hashCodeNullable(phoneNumber), hashCodeNullable(emailAddress), hashCodeNullable(occupation), hashCodeNullable(website), hashCodeNullable(natureOfBusiness), hashCodeNullable(identificationNumbers));
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
    sb.append("class IdentityVerificationWithDetailsPiiBankModel {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    aliases: ").append(toIndentedString(aliases)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    website: ").append(toIndentedString(website)).append("\n");
    sb.append("    natureOfBusiness: ").append(toIndentedString(natureOfBusiness)).append("\n");
    sb.append("    identificationNumbers: ").append(toIndentedString(identificationNumbers)).append("\n");
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


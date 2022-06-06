# cybrid-api-bank-java

Cybrid Bank API

- API version: v0.18.10

- Build date: 2022-06-06T10:03:24.934599Z[Etc/UTC]

# Welcome

Welcome to the Cybrid platform; enabling turnkey crypto banking services!

In these documents, you will find information on the operations provided by our platform, as well as details on how our REST API operates more generally.

Our complete set of APIs allows you to manage all your resources: your Organization, your banks and your identities. The complete set of APIs can be found on the following pages:

| API                                                            | Description                  |
|----------------------------------------------------------------|------------------------------|
| [Organization API](https://organization.demo.cybrid.app/api/schema/swagger-ui) | APIs to manage organizations |
| [Bank API](https://bank.demo.cybrid.app/api/schema/swagger-ui)                 | APIs to manage banks         |
| [Identities API](https://id.demo.cybrid.app/api/schema/swagger-ui)                     | APIs to manage identities    |

When you're ready, [request access](https://www.cybrid.xyz/access) to your Dashboard to view and administer your Organization. Once you've logged in, you can begin creating Banks, either for sandbox or production usage, and start enabling your customers to leverage DeFi and web3 with confidence.

If you have any questions, please contact [Support](mailto:support@cybrid.app) at any time so that we can help.

## Authentication

The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create Organization and Bank tokens can be generated via your Dashboard ([request access](https://www.cybrid.xyz/access)).

An Organization Token applies broadly to the whole Organization and all of its Banks, whereas, a Bank Token is specific to an individual Bank.

Both Organization and Bank tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique Client ID and Secret that allows for machine-to-machine authentication.

**Never share your Client ID or Secret publicly or in your source code repository**

Your Client ID and Secret can be exchanged for a time-limited Bearer Token by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document:

```
curl -X POST https://id.demo.cybrid.app/oauth/token -d '{
    \"grant_type\": \"client_credentials\",
    \"client_id\": \"<Your Client ID>\",
    \"client_secret\": \"<Your Secret>\",
    \"scope\": \"<Your requested scopes -- space separated>\"
  }' -H \"Content-Type: application/json\"
```

## Scopes

The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.

The following scopes are available on the platform and can be requested when generating either an Organization or a Bank token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.

| Resource      | Read scope         | Write scope          | Execute scope     | Token Type         |
|---------------|--------------------|----------------------|-------------------|--------------------|
| Organizations | organizations:read | organizations:write  |                   | Organization/ Bank |
| Banks         | banks:read         | banks:write          | banks:execute     | Organization/ Bank |
| Customers     | customers:read     | customers:write      | customers:execute | Bank               |
| Assets        | prices:read        |                      |                   | Bank               |
| Accounts      | accounts:read      |                      | accounts:execute  | Bank               |
| Prices        | prices:read        |                      |                   | Bank               |
| Symbols       | prices:read        |                      |                   | Bank               |
| Quotes        | quotes:read        |                      | quotes:execute    | Bank               |
| Trades        | trades:read        |                      | trades:execute    | Bank               |

## Organizations

An Organization is meant to model the organization partnering with Cybrid to use our platform.

An Organization does not directly interact with customers. Instead, an Organization has one or more banks, which encompass the financial service offerings of the platform.

## Banks

A Bank is owned by an Organization and can be thought of as an environment or container for Customers and product offerings. An example of a Bank would be your customer facing banking website, or an internal staging environment for testing and integration.

An Organization can have multiple banks, in sandbox or production environments. A sandbox Bank will be backed by stubbed data and process flows. For instance, identity record and funding source processes will be simulated rather than performed.

## Customers

Customers represent your banking users on the platform. At present, we offer support for Individuals as Customers.

Customers must be verified in our system before they can play any part on the platform. See the Identity Records section for more details on how a customer can be verified.

Customers must also have an account to be able to transact. See the Accounts APIs for more details on setting up accounts for the customer.



*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*

## Requirements

Building the API client library requires:

1. Java 1.8+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>app.cybrid</groupId>
  <artifactId>cybrid-api-bank-java</artifactId>
  <version>v0.18.10</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'cybrid-api-bank-java' jar has been published to maven central.
    mavenLocal()       // Needed if the 'cybrid-api-bank-java' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "app.cybrid:cybrid-api-bank-java:v0.18.10"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

- `target/cybrid-api-bank-java-v0.18.10.jar`
- `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import app.cybrid.cybrid_api_bank.client.*;
import app.cybrid.cybrid_api_bank.client.auth.*;
import app.cybrid.cybrid_api_bank.client.model.*;
import app.cybrid.cybrid_api_bank.client.api.AccountsBankApi;

public class AccountsBankApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://bank.demo.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        AccountsBankApi apiInstance = new AccountsBankApi(defaultClient);
        PostAccountBankModel postAccountBankModel = new PostAccountBankModel(); // PostAccountBankModel | 
        try {
            AccountBankModel result = apiInstance.createAccount(postAccountBankModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountsBankApi#createAccount");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://bank.demo.cybrid.app*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccountsBankApi* | [**createAccount**](docs/AccountsBankApi.md#createAccount) | **POST** /api/accounts | Create Account
*AccountsBankApi* | [**getAccount**](docs/AccountsBankApi.md#getAccount) | **GET** /api/accounts/{account_guid} | Get Account
*AccountsBankApi* | [**listAccounts**](docs/AccountsBankApi.md#listAccounts) | **GET** /api/accounts | List Accounts
*AssetsBankApi* | [**listAssets**](docs/AssetsBankApi.md#listAssets) | **GET** /api/assets | Get assets list
*BanksBankApi* | [**createBank**](docs/BanksBankApi.md#createBank) | **POST** /api/banks | Create Bank
*BanksBankApi* | [**getBank**](docs/BanksBankApi.md#getBank) | **GET** /api/banks/{bank_guid} | Get Bank
*BanksBankApi* | [**listBanks**](docs/BanksBankApi.md#listBanks) | **GET** /api/banks | Get banks list
*CustomersBankApi* | [**createCustomer**](docs/CustomersBankApi.md#createCustomer) | **POST** /api/customers | Create Customer
*CustomersBankApi* | [**getCustomer**](docs/CustomersBankApi.md#getCustomer) | **GET** /api/customers/{customer_guid} | Get Customer
*CustomersBankApi* | [**listCustomers**](docs/CustomersBankApi.md#listCustomers) | **GET** /api/customers | Get customers list
*IdentityRecordsBankApi* | [**createIdentityRecord**](docs/IdentityRecordsBankApi.md#createIdentityRecord) | **POST** /api/identity_records | Create Identity Record
*IdentityRecordsBankApi* | [**getIdentityRecord**](docs/IdentityRecordsBankApi.md#getIdentityRecord) | **GET** /api/identity_records/{identity_record_guid} | Get Identity Record
*IdentityRecordsBankApi* | [**listIdentityRecords**](docs/IdentityRecordsBankApi.md#listIdentityRecords) | **GET** /api/identity_records | List Identity Records
*PricesBankApi* | [**listPrices**](docs/PricesBankApi.md#listPrices) | **GET** /api/prices | Get Price
*QuotesBankApi* | [**createQuote**](docs/QuotesBankApi.md#createQuote) | **POST** /api/quotes | Create Quote
*QuotesBankApi* | [**getQuote**](docs/QuotesBankApi.md#getQuote) | **GET** /api/quotes/{quote_guid} | Get Quote
*QuotesBankApi* | [**listQuotes**](docs/QuotesBankApi.md#listQuotes) | **GET** /api/quotes | Get quotes list
*SymbolsBankApi* | [**listSymbols**](docs/SymbolsBankApi.md#listSymbols) | **GET** /api/symbols | Get Symbols list
*TradesBankApi* | [**createTrade**](docs/TradesBankApi.md#createTrade) | **POST** /api/trades | Create Trade
*TradesBankApi* | [**getTrade**](docs/TradesBankApi.md#getTrade) | **GET** /api/trades/{trade_guid} | Get Trade
*TradesBankApi* | [**listTrades**](docs/TradesBankApi.md#listTrades) | **GET** /api/trades | Get trades list
*TradingConfigurationsBankApi* | [**createTradingConfiguration**](docs/TradingConfigurationsBankApi.md#createTradingConfiguration) | **POST** /api/trading_configurations | Create TradingConfiguration
*TradingConfigurationsBankApi* | [**getTradingConfiguration**](docs/TradingConfigurationsBankApi.md#getTradingConfiguration) | **GET** /api/trading_configurations/{trading_configuration_guid} | Get TradingConfiguration
*TradingConfigurationsBankApi* | [**listTradingConfigurations**](docs/TradingConfigurationsBankApi.md#listTradingConfigurations) | **GET** /api/trading_configurations | List trading configurations
*VerificationKeysBankApi* | [**createVerificationKey**](docs/VerificationKeysBankApi.md#createVerificationKey) | **POST** /api/bank_verification_keys | Create VerificationKey
*VerificationKeysBankApi* | [**getVerificationKey**](docs/VerificationKeysBankApi.md#getVerificationKey) | **GET** /api/bank_verification_keys/{verification_key_guid} | Get VerificationKey
*VerificationKeysBankApi* | [**listVerificationKeys**](docs/VerificationKeysBankApi.md#listVerificationKeys) | **GET** /api/bank_verification_keys | Get Verification Keys list


## Documentation for Models

 - [AccountBankModel](docs/AccountBankModel.md)
 - [AccountListBankModel](docs/AccountListBankModel.md)
 - [AssetBankModel](docs/AssetBankModel.md)
 - [AssetListBankModel](docs/AssetListBankModel.md)
 - [AttestationDetailsBankModel](docs/AttestationDetailsBankModel.md)
 - [BankBankModel](docs/BankBankModel.md)
 - [BankListBankModel](docs/BankListBankModel.md)
 - [CustomerBankModel](docs/CustomerBankModel.md)
 - [CustomerListBankModel](docs/CustomerListBankModel.md)
 - [CybridAccountBankModel](docs/CybridAccountBankModel.md)
 - [ErrorResponseBankModel](docs/ErrorResponseBankModel.md)
 - [ExchangeAccountBankModel](docs/ExchangeAccountBankModel.md)
 - [ExchangeBankModel](docs/ExchangeBankModel.md)
 - [FeeBankModel](docs/FeeBankModel.md)
 - [IdentityRecordBankModel](docs/IdentityRecordBankModel.md)
 - [IdentityRecordListBankModel](docs/IdentityRecordListBankModel.md)
 - [PostAccountBankModel](docs/PostAccountBankModel.md)
 - [PostBankBankModel](docs/PostBankBankModel.md)
 - [PostCustomerBankModel](docs/PostCustomerBankModel.md)
 - [PostFeeBankModel](docs/PostFeeBankModel.md)
 - [PostIdentityRecordAttestationDetailsBankModel](docs/PostIdentityRecordAttestationDetailsBankModel.md)
 - [PostIdentityRecordBankModel](docs/PostIdentityRecordBankModel.md)
 - [PostQuoteBankModel](docs/PostQuoteBankModel.md)
 - [PostTradeBankModel](docs/PostTradeBankModel.md)
 - [PostTradingConfigurationBankModel](docs/PostTradingConfigurationBankModel.md)
 - [PostVerificationKeyBankModel](docs/PostVerificationKeyBankModel.md)
 - [QuoteBankModel](docs/QuoteBankModel.md)
 - [QuoteListBankModel](docs/QuoteListBankModel.md)
 - [SymbolPriceBankModel](docs/SymbolPriceBankModel.md)
 - [SystemAccountBankModel](docs/SystemAccountBankModel.md)
 - [TradeBankModel](docs/TradeBankModel.md)
 - [TradeListBankModel](docs/TradeListBankModel.md)
 - [TradingConfigurationBankModel](docs/TradingConfigurationBankModel.md)
 - [TradingConfigurationListBankModel](docs/TradingConfigurationListBankModel.md)
 - [VerificationKeyBankModel](docs/VerificationKeyBankModel.md)
 - [VerificationKeyListBankModel](docs/VerificationKeyListBankModel.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### BearerAuth


- **Type**: HTTP basic authentication

### oauth2


- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: 
- **Scopes**: 
  - banks:read: banks read
  - banks:write: banks write
  - accounts:read: accounts read
  - accounts:execute: accounts execute
  - customers:read: customers read
  - customers:write: customers write
  - customers:execute: customers execute
  - prices:read: prices read
  - quotes:execute: quotes execute
  - quotes:read: quotes read
  - trades:execute: trades execute
  - trades:read: trades read


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@cybrid.app


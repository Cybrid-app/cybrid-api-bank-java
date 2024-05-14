# cybrid-api-bank-java

Cybrid Bank API

- API version: v0.116.0

- Build date: 2024-05-14T11:01:19.686845Z[Etc/UTC]

# Cybrid API documentation

Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.

In these documents, you'll find details on how our REST API operates and generally how our platform functions.

If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).

💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.

## Getting Started

This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.sandbox.cybrid.app/api/schema/v1/swagger.yaml) for import.

If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:

1. [Understanding the Platform](https://kb.cybrid.xyz/understanding-the-platform)
2. [Getting Started in the Cybrid Sandbox](https://kb.cybrid.xyz/getting-started-guide)
3. [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading)
4. [Running the Web Demo App](https://kb.cybrid.xyz/locally-running-the-web-demo-app) (or, alternatively, [Testing with Hosted Web Demo App](https://kb.cybrid.xyz/testing-with-hosted-web-demo-app))

In [Getting Started in the Cybrid Sandbox](https://kb.cybrid.xyz/getting-started-guide), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.

If you've already run through the first two guides, you can follow the [Running the Web Demo App](https://kb.cybrid.xyz/locally-running-the-web-demo-app) guide to test our web SDK with your sandbox `bank` and `customer`.

## Working with the Cybrid Platform

There are three primary ways you can interact with the Cybrid platform:

1. Directly via our RESTful API (this documentation)
2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript))
3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))

Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.

*The complete set of APIs can be found on the following pages:*

| API                                                              | Description                                                 |
|------------------------------------------------------------------|-------------------------------------------------------------|
| [Organization API](https://organization.sandbox.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                |
| [Bank API](https://bank.sandbox.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) |
| [Identities API](https://id.sandbox.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |

For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.

## Authenticating with the API

The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.sandbox.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.sandbox.cybrid.app) as well.

An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.

Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.

A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.sandbox.cybrid.app/api/schema/swagger-ui).

<font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>

Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.

The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.

```
# Example request when using Bank credentials
curl -X POST https://id.sandbox.cybrid.app/oauth/token -d '{
    \"grant_type\": \"client_credentials\",
    \"client_id\": \"<Your Client ID>\",
    \"client_secret\": \"<Your Secret>\",
    \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:write counterparties:execute customers:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read external_bank_accounts:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute\"
  }' -H \"Content-Type: application/json\"

# When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read customers:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:execute external_bank_accounts:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute'
```
<font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>

## Authentication Scopes

The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.

The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.

| Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       |
|-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------|
| Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                |
| Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     |
| Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         |
| Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    |
| Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       |
| External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  |
| External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         |
| Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  |
| User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     |
| Price                 | prices:read (Bank, Customer)                               |                                               |                                                  |
| Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    |
| Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    |
| Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) |
| Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               |
| Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |

## Available Endpoints

The available APIs for the [Identity](https://id.sandbox.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.sandbox.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.sandbox.cybrid.app/api/schema/swagger-ui) API services are listed below:

| API Service  | Model                | API Endpoint Path              | Description                                                                                       |
|--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------|
| Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             |
| Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 |
| Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     |
| Identity     | Organization         | /api/users                     | Create and list organization users                                                                |
| Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     |
| Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             |
| Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     |
| Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             |
| Bank         | Customer             | /api/customers                 | Create and list customers                                                                         |
| Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    |
| Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            |
| Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform |
| Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     |
| Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  |
| Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             |
| Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            |
| Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 |
| Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      |
| Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           |
| Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          |
| Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              |
| Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |

## Understanding Object Models & Endpoints

**Organizations**

An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.

An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.

**Banks**

A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.

An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.

**Customers**

`Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.

`Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.

`Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer.



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
  <version>v0.116.0</version>
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
     implementation "app.cybrid:cybrid-api-bank-java:v0.116.0"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

- `target/cybrid-api-bank-java-v0.116.0.jar`
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
        defaultClient.setBasePath("https://bank.sandbox.cybrid.app");
        
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

All URIs are relative to *https://bank.sandbox.cybrid.app*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccountsBankApi* | [**createAccount**](docs/AccountsBankApi.md#createAccount) | **POST** /api/accounts | Create Account
*AccountsBankApi* | [**getAccount**](docs/AccountsBankApi.md#getAccount) | **GET** /api/accounts/{account_guid} | Get Account
*AccountsBankApi* | [**listAccounts**](docs/AccountsBankApi.md#listAccounts) | **GET** /api/accounts | List Accounts
*AssetsBankApi* | [**listAssets**](docs/AssetsBankApi.md#listAssets) | **GET** /api/assets | Get assets list
*BanksBankApi* | [**createBank**](docs/BanksBankApi.md#createBank) | **POST** /api/banks | Create Bank
*BanksBankApi* | [**getBank**](docs/BanksBankApi.md#getBank) | **GET** /api/banks/{bank_guid} | Get Bank
*BanksBankApi* | [**listBanks**](docs/BanksBankApi.md#listBanks) | **GET** /api/banks | Get banks list
*BanksBankApi* | [**updateBank**](docs/BanksBankApi.md#updateBank) | **PATCH** /api/banks/{bank_guid} | Patch Bank
*CounterpartiesBankApi* | [**createCounterparty**](docs/CounterpartiesBankApi.md#createCounterparty) | **POST** /api/counterparties | Create Counterparty
*CounterpartiesBankApi* | [**getCounterparty**](docs/CounterpartiesBankApi.md#getCounterparty) | **GET** /api/counterparties/{counterparty_guid} | Get Counterparty
*CounterpartiesBankApi* | [**listCounterparties**](docs/CounterpartiesBankApi.md#listCounterparties) | **GET** /api/counterparties | Get counterparties list
*CustomersBankApi* | [**createCustomer**](docs/CustomersBankApi.md#createCustomer) | **POST** /api/customers | Create Customer
*CustomersBankApi* | [**getCustomer**](docs/CustomersBankApi.md#getCustomer) | **GET** /api/customers/{customer_guid} | Get Customer
*CustomersBankApi* | [**listCustomers**](docs/CustomersBankApi.md#listCustomers) | **GET** /api/customers | Get customers list
*CustomersBankApi* | [**updateCustomer**](docs/CustomersBankApi.md#updateCustomer) | **PATCH** /api/customers/{customer_guid} | Patch Customer
*DepositAddressesBankApi* | [**createDepositAddress**](docs/DepositAddressesBankApi.md#createDepositAddress) | **POST** /api/deposit_addresses | Create Deposit Address
*DepositAddressesBankApi* | [**getDepositAddress**](docs/DepositAddressesBankApi.md#getDepositAddress) | **GET** /api/deposit_addresses/{deposit_address_guid} | Get Deposit Address
*DepositAddressesBankApi* | [**listDepositAddresses**](docs/DepositAddressesBankApi.md#listDepositAddresses) | **GET** /api/deposit_addresses | List Deposit Addresses
*DepositBankAccountsBankApi* | [**createDepositBankAccount**](docs/DepositBankAccountsBankApi.md#createDepositBankAccount) | **POST** /api/deposit_bank_accounts | Create Deposit Bank Account
*DepositBankAccountsBankApi* | [**getDepositBankAccount**](docs/DepositBankAccountsBankApi.md#getDepositBankAccount) | **GET** /api/deposit_bank_accounts/{deposit_bank_account_guid} | Get Deposit Bank Account
*DepositBankAccountsBankApi* | [**listDepositBankAccounts**](docs/DepositBankAccountsBankApi.md#listDepositBankAccounts) | **GET** /api/deposit_bank_accounts | List Deposit Bank Accounts
*ExternalBankAccountsBankApi* | [**createExternalBankAccount**](docs/ExternalBankAccountsBankApi.md#createExternalBankAccount) | **POST** /api/external_bank_accounts | Create ExternalBankAccount
*ExternalBankAccountsBankApi* | [**deleteExternalBankAccount**](docs/ExternalBankAccountsBankApi.md#deleteExternalBankAccount) | **DELETE** /api/external_bank_accounts/{external_bank_account_guid} | Delete External Bank Account
*ExternalBankAccountsBankApi* | [**getExternalBankAccount**](docs/ExternalBankAccountsBankApi.md#getExternalBankAccount) | **GET** /api/external_bank_accounts/{external_bank_account_guid} | Get External Bank Account
*ExternalBankAccountsBankApi* | [**listExternalBankAccounts**](docs/ExternalBankAccountsBankApi.md#listExternalBankAccounts) | **GET** /api/external_bank_accounts | Get external bank accounts list
*ExternalBankAccountsBankApi* | [**patchExternalBankAccount**](docs/ExternalBankAccountsBankApi.md#patchExternalBankAccount) | **PATCH** /api/external_bank_accounts/{external_bank_account_guid} | Patch ExternalBankAccount
*ExternalWalletsBankApi* | [**createExternalWallet**](docs/ExternalWalletsBankApi.md#createExternalWallet) | **POST** /api/external_wallets | Create ExternalWallet
*ExternalWalletsBankApi* | [**deleteExternalWallet**](docs/ExternalWalletsBankApi.md#deleteExternalWallet) | **DELETE** /api/external_wallets/{external_wallet_guid} | Delete External Wallet
*ExternalWalletsBankApi* | [**getExternalWallet**](docs/ExternalWalletsBankApi.md#getExternalWallet) | **GET** /api/external_wallets/{external_wallet_guid} | Get External Wallet
*ExternalWalletsBankApi* | [**listExternalWallets**](docs/ExternalWalletsBankApi.md#listExternalWallets) | **GET** /api/external_wallets | Get external wallets list
*IdentityVerificationsBankApi* | [**createIdentityVerification**](docs/IdentityVerificationsBankApi.md#createIdentityVerification) | **POST** /api/identity_verifications | Create Identity Verification
*IdentityVerificationsBankApi* | [**getIdentityVerification**](docs/IdentityVerificationsBankApi.md#getIdentityVerification) | **GET** /api/identity_verifications/{identity_verification_guid} | Get Identity Verification
*IdentityVerificationsBankApi* | [**listIdentityVerifications**](docs/IdentityVerificationsBankApi.md#listIdentityVerifications) | **GET** /api/identity_verifications | List Identity Verifications
*InvoicesBankApi* | [**cancelInvoice**](docs/InvoicesBankApi.md#cancelInvoice) | **DELETE** /api/invoices/{invoice_guid} | Cancel Invoice
*InvoicesBankApi* | [**createInvoice**](docs/InvoicesBankApi.md#createInvoice) | **POST** /api/invoices | Create Invoice
*InvoicesBankApi* | [**getInvoice**](docs/InvoicesBankApi.md#getInvoice) | **GET** /api/invoices/{invoice_guid} | Get Invoice
*InvoicesBankApi* | [**listInvoices**](docs/InvoicesBankApi.md#listInvoices) | **GET** /api/invoices | List Invoices
*PaymentInstructionsBankApi* | [**createPaymentInstruction**](docs/PaymentInstructionsBankApi.md#createPaymentInstruction) | **POST** /api/payment_instructions | Create Payment Instruction
*PaymentInstructionsBankApi* | [**getPaymentInstruction**](docs/PaymentInstructionsBankApi.md#getPaymentInstruction) | **GET** /api/payment_instructions/{payment_instruction_guid} | Get Payment Instruction
*PaymentInstructionsBankApi* | [**listPaymentInstructions**](docs/PaymentInstructionsBankApi.md#listPaymentInstructions) | **GET** /api/payment_instructions | List Payment Instructions
*PricesBankApi* | [**listPrices**](docs/PricesBankApi.md#listPrices) | **GET** /api/prices | Get Price
*QuotesBankApi* | [**createQuote**](docs/QuotesBankApi.md#createQuote) | **POST** /api/quotes | Create Quote
*QuotesBankApi* | [**getQuote**](docs/QuotesBankApi.md#getQuote) | **GET** /api/quotes/{quote_guid} | Get Quote
*QuotesBankApi* | [**listQuotes**](docs/QuotesBankApi.md#listQuotes) | **GET** /api/quotes | Get quotes list
*SymbolsBankApi* | [**listSymbols**](docs/SymbolsBankApi.md#listSymbols) | **GET** /api/symbols | Get Symbols list
*TradesBankApi* | [**createTrade**](docs/TradesBankApi.md#createTrade) | **POST** /api/trades | Create Trade
*TradesBankApi* | [**getTrade**](docs/TradesBankApi.md#getTrade) | **GET** /api/trades/{trade_guid} | Get Trade
*TradesBankApi* | [**listTrades**](docs/TradesBankApi.md#listTrades) | **GET** /api/trades | Get trades list
*TransfersBankApi* | [**createTransfer**](docs/TransfersBankApi.md#createTransfer) | **POST** /api/transfers | Create Transfer
*TransfersBankApi* | [**getTransfer**](docs/TransfersBankApi.md#getTransfer) | **GET** /api/transfers/{transfer_guid} | Get Transfer
*TransfersBankApi* | [**listTransfers**](docs/TransfersBankApi.md#listTransfers) | **GET** /api/transfers | Get transfers list
*WorkflowsBankApi* | [**createWorkflow**](docs/WorkflowsBankApi.md#createWorkflow) | **POST** /api/workflows | Create Workflow
*WorkflowsBankApi* | [**getWorkflow**](docs/WorkflowsBankApi.md#getWorkflow) | **GET** /api/workflows/{workflow_guid} | Get Workflow
*WorkflowsBankApi* | [**listWorkflows**](docs/WorkflowsBankApi.md#listWorkflows) | **GET** /api/workflows | Get workflows list


## Documentation for Models

 - [AccountBankModel](docs/AccountBankModel.md)
 - [AccountListBankModel](docs/AccountListBankModel.md)
 - [AccountStateBankModel](docs/AccountStateBankModel.md)
 - [AccountTypeBankModel](docs/AccountTypeBankModel.md)
 - [AssetBankModel](docs/AssetBankModel.md)
 - [AssetListBankModel](docs/AssetListBankModel.md)
 - [AssetTypesBankModel](docs/AssetTypesBankModel.md)
 - [BankBankModel](docs/BankBankModel.md)
 - [BankFeatureBankModel](docs/BankFeatureBankModel.md)
 - [BankListBankModel](docs/BankListBankModel.md)
 - [BankTypeBankModel](docs/BankTypeBankModel.md)
 - [ComplianceCheckBankModel](docs/ComplianceCheckBankModel.md)
 - [ComplianceCheckOutcomeBankModel](docs/ComplianceCheckOutcomeBankModel.md)
 - [ComplianceCheckTypeBankModel](docs/ComplianceCheckTypeBankModel.md)
 - [ComplianceDecisionBankModel](docs/ComplianceDecisionBankModel.md)
 - [ComplianceDecisionStateBankModel](docs/ComplianceDecisionStateBankModel.md)
 - [ComplianceDecisionTypeBankModel](docs/ComplianceDecisionTypeBankModel.md)
 - [CounterpartyAddressBankModel](docs/CounterpartyAddressBankModel.md)
 - [CounterpartyAliasesInnerBankModel](docs/CounterpartyAliasesInnerBankModel.md)
 - [CounterpartyBankModel](docs/CounterpartyBankModel.md)
 - [CounterpartyListBankModel](docs/CounterpartyListBankModel.md)
 - [CounterpartyNameBankModel](docs/CounterpartyNameBankModel.md)
 - [CounterpartyStateBankModel](docs/CounterpartyStateBankModel.md)
 - [CounterpartyTypeBankModel](docs/CounterpartyTypeBankModel.md)
 - [CustomerAddressBankModel](docs/CustomerAddressBankModel.md)
 - [CustomerAliasesInnerBankModel](docs/CustomerAliasesInnerBankModel.md)
 - [CustomerBankModel](docs/CustomerBankModel.md)
 - [CustomerListBankModel](docs/CustomerListBankModel.md)
 - [CustomerNameBankModel](docs/CustomerNameBankModel.md)
 - [CustomerStateBankModel](docs/CustomerStateBankModel.md)
 - [CustomerTypeBankModel](docs/CustomerTypeBankModel.md)
 - [DepositAddressBankModel](docs/DepositAddressBankModel.md)
 - [DepositAddressFormatBankModel](docs/DepositAddressFormatBankModel.md)
 - [DepositAddressListBankModel](docs/DepositAddressListBankModel.md)
 - [DepositAddressStateBankModel](docs/DepositAddressStateBankModel.md)
 - [DepositBankAccountAccountDetailsInnerBankModel](docs/DepositBankAccountAccountDetailsInnerBankModel.md)
 - [DepositBankAccountBankModel](docs/DepositBankAccountBankModel.md)
 - [DepositBankAccountCounterpartyAddressBankModel](docs/DepositBankAccountCounterpartyAddressBankModel.md)
 - [DepositBankAccountListBankModel](docs/DepositBankAccountListBankModel.md)
 - [DepositBankAccountRoutingDetailsInnerBankModel](docs/DepositBankAccountRoutingDetailsInnerBankModel.md)
 - [DepositBankAccountRoutingNumberTypeBankModel](docs/DepositBankAccountRoutingNumberTypeBankModel.md)
 - [DepositBankAccountStateBankModel](docs/DepositBankAccountStateBankModel.md)
 - [ErrorResponseBankModel](docs/ErrorResponseBankModel.md)
 - [ExternalBankAccountBalancesBankModel](docs/ExternalBankAccountBalancesBankModel.md)
 - [ExternalBankAccountBankModel](docs/ExternalBankAccountBankModel.md)
 - [ExternalBankAccountKindBankModel](docs/ExternalBankAccountKindBankModel.md)
 - [ExternalBankAccountListBankModel](docs/ExternalBankAccountListBankModel.md)
 - [ExternalBankAccountPiiInnerAddressesInnerBankModel](docs/ExternalBankAccountPiiInnerAddressesInnerBankModel.md)
 - [ExternalBankAccountPiiInnerBankModel](docs/ExternalBankAccountPiiInnerBankModel.md)
 - [ExternalBankAccountStateBankModel](docs/ExternalBankAccountStateBankModel.md)
 - [ExternalWalletBankModel](docs/ExternalWalletBankModel.md)
 - [ExternalWalletEnvironmentBankModel](docs/ExternalWalletEnvironmentBankModel.md)
 - [ExternalWalletListBankModel](docs/ExternalWalletListBankModel.md)
 - [ExternalWalletStateBankModel](docs/ExternalWalletStateBankModel.md)
 - [IdentityVerificationBankModel](docs/IdentityVerificationBankModel.md)
 - [IdentityVerificationListBankModel](docs/IdentityVerificationListBankModel.md)
 - [IdentityVerificationMethodBankModel](docs/IdentityVerificationMethodBankModel.md)
 - [IdentityVerificationOutcomeBankModel](docs/IdentityVerificationOutcomeBankModel.md)
 - [IdentityVerificationPersonaStateBankModel](docs/IdentityVerificationPersonaStateBankModel.md)
 - [IdentityVerificationStateBankModel](docs/IdentityVerificationStateBankModel.md)
 - [IdentityVerificationTypeBankModel](docs/IdentityVerificationTypeBankModel.md)
 - [IdentityVerificationWithDetailsBankModel](docs/IdentityVerificationWithDetailsBankModel.md)
 - [IdentityVerificationWithDetailsPiiAddressBankModel](docs/IdentityVerificationWithDetailsPiiAddressBankModel.md)
 - [IdentityVerificationWithDetailsPiiBankModel](docs/IdentityVerificationWithDetailsPiiBankModel.md)
 - [IdentityVerificationWithDetailsPiiNameBankModel](docs/IdentityVerificationWithDetailsPiiNameBankModel.md)
 - [InvoiceBankModel](docs/InvoiceBankModel.md)
 - [InvoiceListBankModel](docs/InvoiceListBankModel.md)
 - [PatchBankBankModel](docs/PatchBankBankModel.md)
 - [PatchCustomerBankModel](docs/PatchCustomerBankModel.md)
 - [PatchExternalBankAccountBankModel](docs/PatchExternalBankAccountBankModel.md)
 - [PaymentInstructionBankModel](docs/PaymentInstructionBankModel.md)
 - [PaymentInstructionListBankModel](docs/PaymentInstructionListBankModel.md)
 - [PostAccountBankModel](docs/PostAccountBankModel.md)
 - [PostBankBankModel](docs/PostBankBankModel.md)
 - [PostCounterpartyBankModel](docs/PostCounterpartyBankModel.md)
 - [PostCounterpartyNameBankModel](docs/PostCounterpartyNameBankModel.md)
 - [PostCustomerAddressBankModel](docs/PostCustomerAddressBankModel.md)
 - [PostCustomerBankModel](docs/PostCustomerBankModel.md)
 - [PostCustomerNameBankModel](docs/PostCustomerNameBankModel.md)
 - [PostDepositAddressBankModel](docs/PostDepositAddressBankModel.md)
 - [PostDepositBankAccountBankModel](docs/PostDepositBankAccountBankModel.md)
 - [PostExternalBankAccountBankModel](docs/PostExternalBankAccountBankModel.md)
 - [PostExternalBankAccountCounterpartyAddressBankModel](docs/PostExternalBankAccountCounterpartyAddressBankModel.md)
 - [PostExternalBankAccountCounterpartyBankAccountBankModel](docs/PostExternalBankAccountCounterpartyBankAccountBankModel.md)
 - [PostExternalBankAccountCounterpartyNameBankModel](docs/PostExternalBankAccountCounterpartyNameBankModel.md)
 - [PostExternalWalletBankModel](docs/PostExternalWalletBankModel.md)
 - [PostFeeBankModel](docs/PostFeeBankModel.md)
 - [PostIdentificationNumberBankModel](docs/PostIdentificationNumberBankModel.md)
 - [PostIdentityVerificationAddressBankModel](docs/PostIdentityVerificationAddressBankModel.md)
 - [PostIdentityVerificationBankModel](docs/PostIdentityVerificationBankModel.md)
 - [PostIdentityVerificationNameBankModel](docs/PostIdentityVerificationNameBankModel.md)
 - [PostInvoiceBankModel](docs/PostInvoiceBankModel.md)
 - [PostPaymentInstructionBankModel](docs/PostPaymentInstructionBankModel.md)
 - [PostQuoteBankModel](docs/PostQuoteBankModel.md)
 - [PostTradeBankModel](docs/PostTradeBankModel.md)
 - [PostTransferBankModel](docs/PostTransferBankModel.md)
 - [PostWorkflowBankModel](docs/PostWorkflowBankModel.md)
 - [QuoteBankModel](docs/QuoteBankModel.md)
 - [QuoteListBankModel](docs/QuoteListBankModel.md)
 - [QuoteSideBankModel](docs/QuoteSideBankModel.md)
 - [QuoteTypeBankModel](docs/QuoteTypeBankModel.md)
 - [SymbolPriceBankModel](docs/SymbolPriceBankModel.md)
 - [TradeBankModel](docs/TradeBankModel.md)
 - [TradeFailureCodeBankModel](docs/TradeFailureCodeBankModel.md)
 - [TradeListBankModel](docs/TradeListBankModel.md)
 - [TradeSideBankModel](docs/TradeSideBankModel.md)
 - [TradeStateBankModel](docs/TradeStateBankModel.md)
 - [TradeTypeBankModel](docs/TradeTypeBankModel.md)
 - [TransferAccountTypeBankModel](docs/TransferAccountTypeBankModel.md)
 - [TransferBankModel](docs/TransferBankModel.md)
 - [TransferDestinationAccountBankModel](docs/TransferDestinationAccountBankModel.md)
 - [TransferFailureCodeBankModel](docs/TransferFailureCodeBankModel.md)
 - [TransferListBankModel](docs/TransferListBankModel.md)
 - [TransferSideBankModel](docs/TransferSideBankModel.md)
 - [TransferSourceAccountBankModel](docs/TransferSourceAccountBankModel.md)
 - [TransferStateBankModel](docs/TransferStateBankModel.md)
 - [TransferTypeBankModel](docs/TransferTypeBankModel.md)
 - [WorkflowBankModel](docs/WorkflowBankModel.md)
 - [WorkflowStateBankModel](docs/WorkflowStateBankModel.md)
 - [WorkflowTypeBankModel](docs/WorkflowTypeBankModel.md)
 - [WorkflowWithDetailsAllOfBankModel](docs/WorkflowWithDetailsAllOfBankModel.md)
 - [WorkflowWithDetailsBankModel](docs/WorkflowWithDetailsBankModel.md)
 - [WorkflowsListBankModel](docs/WorkflowsListBankModel.md)


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
  - bank_applications:execute: bank_applications execute
  - accounts:read: accounts read
  - accounts:execute: accounts execute
  - counterparties:read: counterparties read
  - counterparties:write: counterparties write
  - counterparties:execute: counterparties execute
  - customers:read: customers read
  - customers:write: customers write
  - customers:execute: customers execute
  - prices:read: prices read
  - quotes:execute: quotes execute
  - quotes:read: quotes read
  - trades:execute: trades execute
  - trades:read: trades read
  - transfers:execute: transfers execute
  - transfers:read: transfers read
  - external_bank_accounts:read: external_bank_accounts read
  - external_bank_accounts:write: external_bank_accounts write
  - external_bank_accounts:execute: external_bank_accounts execute
  - external_wallets:read: external_wallets read
  - external_wallets:execute: external_wallets execute
  - workflows:read: workflows read
  - workflows:execute: workflows execute
  - deposit_addresses:read: deposit_addresses read
  - deposit_addresses:execute: deposit_addresses execute
  - deposit_bank_accounts:read: deposit_bank_accounts read
  - deposit_bank_accounts:execute: deposit_bank_accounts execute
  - invoices:read: invoices read
  - invoices:write: invoices write
  - invoices:execute: invoices execute


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@cybrid.app


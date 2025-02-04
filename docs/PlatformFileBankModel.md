

# PlatformFileBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | The unique identifier for the file. |  [optional] |
|**fileType** | [**FileTypeEnum**](#FileTypeEnum) | The file type; one of drivers_license_front, drivers_license_back, passport, identification_card, residence_card, selfie, selfie_left, selfie_right, utility_bill, bank_statement, property_tax, tax_document, ein_letter, or incorporation_certificate. |  [optional] |
|**contentType** | [**ContentTypeEnum**](#ContentTypeEnum) | The media type; one of image/jpeg, image/png, or application/pdf. |  [optional] |
|**completedAt** | **OffsetDateTime** | The ISO8601 datetime the file was completed at. |  [optional] |
|**failedAt** | **OffsetDateTime** | The ISO8601 datetime the file failed at. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The state of the file. One of storing, completed, or failed. |  [optional] |
|**failureCode** | **String** | The failure code for failed files. |  [optional] |



## Enum: FileTypeEnum

| Name | Value |
|---- | -----|
| DRIVERS_LICENSE_FRONT | &quot;drivers_license_front&quot; |
| DRIVERS_LICENSE_BACK | &quot;drivers_license_back&quot; |
| PASSPORT | &quot;passport&quot; |
| IDENTIFICATION_CARD | &quot;identification_card&quot; |
| RESIDENCE_CARD | &quot;residence_card&quot; |
| SELFIE | &quot;selfie&quot; |
| SELFIE_LEFT | &quot;selfie_left&quot; |
| SELFIE_RIGHT | &quot;selfie_right&quot; |
| UTILITY_BILL | &quot;utility_bill&quot; |
| BANK_STATEMENT | &quot;bank_statement&quot; |
| PROPERTY_TAX | &quot;property_tax&quot; |
| TAX_DOCUMENT | &quot;tax_document&quot; |
| EIN_LETTER | &quot;ein_letter&quot; |
| INCORPORATION_CERTIFICATE | &quot;incorporation_certificate&quot; |



## Enum: ContentTypeEnum

| Name | Value |
|---- | -----|
| IMAGE_JPEG | &quot;image/jpeg&quot; |
| IMAGE_PNG | &quot;image/png&quot; |
| APPLICATION_PDF | &quot;application/pdf&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| COMPLETED | &quot;completed&quot; |
| FAILED | &quot;failed&quot; |




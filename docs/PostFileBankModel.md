

# PostFileBankModel

Request body for a new file.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The type of file. |  |
|**customerGuid** | **String** | The customer identifier. |  |
|**filename** | **String** | The name of the file. |  |
|**contentType** | [**ContentTypeEnum**](#ContentTypeEnum) | The content type of the file. |  |
|**data** | **String** | Base64 encoded file content |  [optional] |



## Enum: TypeEnum

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




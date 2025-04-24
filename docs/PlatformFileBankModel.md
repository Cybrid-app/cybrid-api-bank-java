

# PlatformFileBankModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | The unique identifier for the file. |  [optional] |
|**type** | **String** | The file type; one of drivers_license_front, drivers_license_back, passport, visa, identification_card, residence_card, selfie, selfie_video, selfie_left, selfie_right, utility_bill, proof_of_address, bank_statement, property_tax, tax_document, ein_letter, incorporation_certificate, persona_inquiry_report, or persona_inquiry_export. |  [optional] |
|**contentType** | **String** | The media type; one of image/jpeg, image/png, application/pdf, application/json, or video/mp4. |  [optional] |
|**completedAt** | **OffsetDateTime** | The ISO8601 datetime the file was completed at. |  [optional] |
|**failedAt** | **OffsetDateTime** | The ISO8601 datetime the file failed at. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The state of the file. One of storing, completed, or failed. |  [optional] |
|**failureCode** | **String** | The failure code for failed files. |  [optional] |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| COMPLETED | &quot;completed&quot; |
| FAILED | &quot;failed&quot; |




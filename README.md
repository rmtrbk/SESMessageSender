# SESMessageSender
Sends a message to an `SES` so that the mail addresses will receive the email.

## Design
* `SESMessengerServiceImpl` has the method that is capable of sending an email to `SES`.

* `ClientBuilderManager` utility class build an `SES` client to access `SES` service APIs.

* `PropertyManager` reads required properties from the configuration file makes them available across the application.

## Configuring AWS Infrastructure
* Create an `IAM Group`.

* Create an `IAM User`.

* Add created `IAM User` to `IAM Group`'s `Amazon SES` service.

* Go to `IAM Users`, select the created user and generate `key`/`value` pair in `Security credentials` tab.

* Create an `SES` domain.

* In the `SES` domain, add your email id and verify.

## How to test
This is a simple `Java` `Maven` project.

Fill in the values in the `properties` file.

Add `TO` and `FROM` email addresses. `FROM` email address should be the verified email id.

Run `App` class.

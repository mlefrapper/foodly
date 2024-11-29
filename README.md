# Foodly
Foodly is an Android application that helps users make informed food choices by scanning product barcodes and providing detailed health and nutritional insights.

# Code Formatting with Spotless

This project uses the Spotless plugin to ensure consistent code style and formatting.

## Applying Formatting Rules

To apply code formatting rules, run the following command:
./gradlew spotlessApply

This will reformat your code according to the configured rules.

## Additional Resources

* [Spotless Website](https://github.com/diffplug/spotless)
* [Spotless Plugin Documentation](https://github.com/diffplug/spotless/tree/main/plugin-gradle)

# OWASP Dependency-Check

This project utilizes the OWASP Dependency-Check plugin to identify and mitigate security vulnerabilities in project dependencies.

## Dependency Vulnerability Analysis

The OWASP Dependency-Check plugin is a software composition analysis (SCA) tool that helps identify known vulnerabilities in your project's dependencies. It compares your dependencies against vulnerability databases (NVD, CVE, etc.) and generates reports detailing any potential security risks.

## Running the Analysis

To perform the dependency vulnerability analysis, execute the following command in your project's root directory:
./gradlew dependencyCheckAnalyze

## Additional Resources

* [OWASP Dependency-Check Website](https://owasp.org/www-project-dependency-check/)
* [OWASP Dependency-Check Plugin Documentation](https://jeremylong.github.io/DependencyCheck/dependency-check-gradle/index.html)
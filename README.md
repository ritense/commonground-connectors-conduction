# commonground-connectors-conduction
Common Ground connectors for Conduction components

## What is it?
A Spring Boot library including a collection of connectors to connect with https://github.com/ConductionNL components. Used in Dutch Government Common Ground initiative.  

### Which components are supported?
At the moment this library includes a connector for the following components:
- Adres Component
- Verzoek Registratie Component

### How do I use it?
- Clone this repository
- Run the Gradle command publishMavenPublicationToMavenLocal
- Include the following dependency in your Spring Boot project: 
```implementation "com.ritense.commonground.connectors:conduction:0.0.1-SNAPSHOT"```

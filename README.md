# NY Times
A simple app to hit the NY Times Most Popular Articles API and show a list of articles,
that shows details when an item on the list is tapped (a typical master/detail app), 
also user able to browse articles on the brwoser, also you can fetch articles for diffrent periond 1day, 1 week and 1month. 

## Built With
- ### kotlin
- ### Jetpack compose - Jetpack Compose is Android's recommended modern toolkit for building native UI
- ### Coroutines - For asynchronous and more.
- ### Flows - a flow is a type that can emit multiple values sequentially.
- ### Viewmodel - Stores UI-related data that isn't destroyed on UI changes.
- ### Hilt - Standard library to incorporate Dagger dependency injection into an Android application.
- ### Retrofit - A type-safe HTTP client for Android and Java.
- ### Coil - An image loading library for Android backed by Kotlin Coroutines.
- ### Jnit - For Unite test
- ### Mockito - mocking framework
- ### Espresso - UI Tests

- ## Architecture
  * MVI Architecture
  * Modularization by Feature combined with Layer
  * Repository pattern
  * Clean Architecture approach.

## APP Modules
- ### Core Module
     includes the base classes and Retrofit creation for the App.
- ### Utils Module
     includes the utils function can be used across the app.
- ### Design system Module
     includes Jetpack compose component used across the App, to make them resuable and maintenable.
- ### Features Module
     includes app featuers splitted by modules, and each feature splitted to 3 submodules (data, domain, presentation).







## **Date And Time Picker for Android**

It's a simple lib written in **Kotlin** that init `DatePickerDialog` and when you choose your date, it automatically opens `TimePickerDialog`, and then it's unify complete date in a **callback**.

The goal was to simplify apps that need to work with date and time.
As the application was written in kotlin, there is two extension functions to make it simpler.

## Installation

Add the JitPack repository in your build.gradle at the end of repositories:

```
allprojects {
 repositories {
	 maven {
		 url 'https://jitpack.io' }
	 }
 }
```
And add the dependency:

```
dependencies {
	 implementation 'com.github.jhonatansabadi:datetime-picker:1.0.5'
 }

```

**1 - Separete Date:**

Call function only from `Activity`. The function will return a `callback` with complete and separate date as `Int` type.


```kotlin
showDateAndTimePicker { year: Int, month: Int, dayOfMonth: Int, hourOfDay: Int, minute: Int ->
   //your code
}
```
**2 - Complete Date String with Pattern:**

Call function only from `Activity` and pass `pattern` and function will return date formatted as `String`

```kotlin
showDateAndTimePicker("dd/MM/YYYY HH:mm") { dateFormatted: String ->
   //your code
}
```
**3 - Complete Date Object:**

The function will return a `callback` with complete Date Object.

```kotlin
showDateAndTimePicker { date: Date ->
   //your code
}
```

<img src="images/date.jpg" width="200" height="400" />

<img src="images/time.jpg" width="200" height="400" />

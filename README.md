## **Date And Time Picker for Android**

It's a simple lib written in **Kotlin** that init `DatePickerDialog` and when you choose your date, it automatically opens `TimePickerDialog`, and then it's unify complete date in a **callback**.

The goal was to simplify apps that need to work with date and time. 

As the application was written in kotlin, there is two extension functions to make it simpler.

## Installation

Add the JitPack repository in your build.gradle at the end of repositories:

```css
allprojects {
	repositories {
			...
		maven { url 'https://jitpack.io' }
	}
}
```
And add the dependency:

```css
dependencies {
        implementation 'com.github.jhonatansabadi:datetime-picker:1.0.4'
}

```

**1 - Separete Date:**

Call function only from `Activity`. The function will return a `callback` with complete and separete date.


```kotlin
showDateAndTimePicker { year, month, dayOfMonth, hourOfDay, minute ->  
	//your code
}
 ```

**2 - Complete date String with pattern:**

Call function only from `Activity` and pass `pattern` and function will retorn date formatted as `String`

```kotlin
showDateAndTimePicker("dd/MM/YYYY HH:mm") { dateFormatted ->  
	//your code
}
```

<img src="images/date.jpg" width="200" height="400" />

<img src="images/time.jpg" width="200" height="400" />



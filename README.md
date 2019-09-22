# DateTimePickerLibrary

Provides easy access to Date and Time Picker and benefits developers by not writing the boilerplate code for it.

Add Dependency

Add this in module level gradle file

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency to the app level gradle file

```groovy
dependencies {
        implementation 'com.github.VaibhavAWD:DateTimePickerLibrary:v2.0.0'
}
```

If you have particular API use case then instead use separate dependencies

For DatePickerUtil

```groovy
implementation 'com.github.VaibhavAWD.DateTimePickerLibrary:datepickerutil:v2.0.0'
```

For TimePickerUtil

```groovy
implementation 'com.github.VaibhavAWD.DateTimePickerLibrary:timepickerutil:v2.0.0'
```

**Example**

```kotlin
btn_select_date.setOnClickListener {
    DatePickerUtil.getDate(this) // you can pass selected date as the second param
}

btn_select_time.setOnClickListener {
    TimePickerUtil.getTime(this)
    // #1 you can pass true / false as the second param if you want the picker to show 24 hour
    // format or 12 hour format.
    // #2 you can pass the selected time as the third param
}
```

If you want to use something like Date and Time Picker Dialog at the same time then simply call `getTime()` in the `onDateSet(timeInMillis: Long)` callback and pass the selected date time to the method. And finally you will get the date and time both selected in `onTimeSet(timeInMillis: Long)` callback method.

## Build tools & versions used
Android Studio, compileSdk 33
I also used Postman to get a full view of the JSON that I am getting, very helpful tool.

## Steps to run the app
On android studio, click File, Open, then open the location of the project.

## What areas of the app did you focus on?
I focus on what Architecture I should use on the project, on the project structure I use MVVM that uses dagger/hilt.

## What was the reason for your focus? What problems were you trying to solve?
The reason for that is using dependency injection such as dagger/hilt, it will make the app more easy to unit test.

## How long did you spend on this project?
6-7 hours.

## Did you make any trade-offs for this project? What would you have done differently with more time?
if I have more time I would like to modernize this project using JetPack compose. As of now I tried to build this project using the knowledge that I am confident with so I build the UI part using xml files.

## What do you think is the weakest part of your project?
I tried to make it the best as I know of but if I have more time I would add more unit test on GetEmployeeUseCaseImpl because there is also logic that is happening there.

## Did you copy any code or dependencies? Please make sure to attribute them here!
for build.gradle (Module):

    implementation "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0"
    implementation 'androidx.core:core-ktx:1.10.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.8.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.core:core-ktx:1.10.0'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.3'
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.3'

  
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
 
    implementation 'com.google.code.gson:gson:2.9.0'
   
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'androidx.core:core-ktx:1.10.0'

    implementation "androidx.fragment:fragment-ktx:1.5.6"
   
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1"
   
    implementation "com.google.dagger:hilt-android:2.44"
    testImplementation 'org.junit.jupiter:junit-jupiter'
    testImplementation 'junit:junit:4.13.2'
    kapt "com.google.dagger:hilt-compiler:2.44"
    
    implementation 'com.github.bumptech.glide:glide:4.13.2'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'

    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

    testImplementation "io.mockk:mockk-android:1.12.0"
    testImplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.2'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.2'

    testImplementation "io.mockk:mockk:1.12.2"
    testImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.2"
    testImplementation"androidx.arch.core:core-testing:2.2.0"
    testImplementation 'org.assertj:assertj-core:3.20.2'

for build.gradle (Project)

    dependencies {
        classpath 'com.google.dagger:hilt-android-gradle-plugin:2.44'
    }

    plugins {
        id 'com.android.application' version '8.0.0' apply false
        id 'com.android.library' version '8.0.0' apply false
        id 'org.jetbrains.kotlin.android' version '1.8.20' apply false
        id 'androidx.navigation.safeargs' version '2.5.3' apply false
        id 'com.google.dagger.hilt.android' version '2.44' apply false
        id 'org.jetbrains.kotlin.plugin.serialization' version '1.5.0' apply false
    }

for settings.gradle

    pluginManagement {
        repositories {
            google()
            mavenCentral()
            gradlePluginPortal()
        }
    }
    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            google()
            mavenCentral()
            gradlePluginPortal()
        }
        }
    rootProject.name = "Mobile Application Project"
    include ':app'


## Is there any other information you’d like us to know?
Since I build the project from a scratch I spent most of my time getting the correct dependencies.
Also had issue on android studio where when you try to create a blank project it will not build because you will have to add gradlePluginPortal() on the settings.gradle that I spent a lot of time researching.
I will also put all the dimens and strings to their proper locations. I added some on the strings.xml but not all.
Please give me some feedback! thanks!

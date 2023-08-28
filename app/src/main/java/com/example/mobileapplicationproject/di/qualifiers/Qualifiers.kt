package com.example.mobileapplicationproject.di.qualifiers

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Qualifier
import kotlin.reflect.KClass

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class DatabaseName

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class DatabaseVersion

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class NetworkApiKey

@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ViewModelKey(val value: KClass<out ViewModel>)
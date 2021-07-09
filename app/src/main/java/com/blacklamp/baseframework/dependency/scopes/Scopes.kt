package com.blacklamp.baseframework.dependency.scopes

import javax.inject.Scope

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScoped

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScoped

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class NestedFragmentScoped
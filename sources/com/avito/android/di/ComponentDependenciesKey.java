package com.avito.android.di;

import dagger.MapKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
@MapKey
@Target({ElementType.METHOD})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/di/ComponentDependenciesKey;", "", "Lkotlin/reflect/KClass;", "Lcom/avito/android/di/ComponentDependencies;", "value", "()Ljava/lang/Class;", "<init>", "(Lkotlin/reflect/KClass;)V", "dagger-scopes_release"}, k = 1, mv = {1, 4, 2})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentDependenciesKey {
    Class<? extends ComponentDependencies> value();
}

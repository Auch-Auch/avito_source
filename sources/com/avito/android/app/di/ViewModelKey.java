package com.avito.android.app.di;

import dagger.MapKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
@MapKey
@Target({ElementType.METHOD})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/app/di/ViewModelKey;", "", "Lkotlin/reflect/KClass;", "value", "()Ljava/lang/Class;", "<init>", "(Lkotlin/reflect/KClass;)V", "android_release"}, k = 1, mv = {1, 4, 2})
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModelKey {
    Class<?> value();
}

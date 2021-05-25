package com.avito.android.remote.di;

import com.avito.android.di.module.StreamGson;
import com.avito.android.remote.model.ab_tests.AbTest;
import com.avito.android.remote.parse.adapter.AbTestTypeAdapter;
import com.avito.android.remote.parse.adapter.AbTestsAdapterFactory;
import com.avito.android.util.OptimalTypeAdapterEntry;
import com.google.gson.TypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/di/AbTestJsonModule;", "", "", "Lcom/avito/android/util/OptimalTypeAdapterEntry;", "provideAbTestTypeAdapters", "()Ljava/util/Set;", "Lcom/google/gson/TypeAdapterFactory;", "provideAbTestTypeAdapterFactories", "<init>", "()V", "config_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AbTestJsonModule {
    @NotNull
    public static final AbTestJsonModule INSTANCE = new AbTestJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public static final Set<TypeAdapterFactory> provideAbTestTypeAdapterFactories() {
        return x.setOf(new AbTestsAdapterFactory());
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public static final Set<OptimalTypeAdapterEntry> provideAbTestTypeAdapters() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new OptimalTypeAdapterEntry(AbTest.class, new AbTestTypeAdapter()));
        return linkedHashSet;
    }
}

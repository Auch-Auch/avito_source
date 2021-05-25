package com.avito.android.di.module;

import com.avito.android.remote.model.section.SectionTypeElement;
import com.avito.android.remote.model.section.SectionTypeItem;
import com.avito.android.remote.parse.adapter.stream_gson.OptimalRuntimeTypeAdapterFactory;
import com.google.gson.TypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/di/module/SearchOptimalJsonModule;", "", "", "Lcom/google/gson/TypeAdapterFactory;", "provideSearchTypeAdapterFactories", "()Ljava/util/Set;", "<init>", "()V", "search_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SearchOptimalJsonModule {
    @NotNull
    public static final SearchOptimalJsonModule INSTANCE = new SearchOptimalJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public static final Set<TypeAdapterFactory> provideSearchTypeAdapterFactories() {
        return x.setOf(OptimalRuntimeTypeAdapterFactory.Companion.of(SectionTypeElement.class).registerSubtype(SectionTypeItem.class, "section"));
    }
}

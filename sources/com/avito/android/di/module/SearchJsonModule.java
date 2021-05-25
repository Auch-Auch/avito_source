package com.avito.android.di.module;

import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.section.SectionTypeElement;
import com.avito.android.remote.parse.adapter.MarkerTypeAdapterFactory;
import com.avito.android.remote.parse.adapter.RecommendationTypeAdapter;
import com.avito.android.remote.parse.adapter.SearchDeviceResourcesProvider;
import com.avito.android.remote.parse.adapter.TabletDisplayTypeFallbackTypeAdapterFactory;
import com.avito.android.remote.parse.adapter.inline_filters.InlineFilterMultiSelectValueTypeAdapter;
import com.avito.android.remote.parse.adapter.inline_filters.InlineFilterSelectValueTypeAdapter;
import com.avito.android.remote.parse.adapter.inline_filters.InlineFilterTypeAdapterFactory;
import com.avito.android.util.TypeAdapterEntry;
import com.google.gson.TypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/di/module/SearchJsonModule;", "", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "()Ljava/util/Set;", "Lcom/avito/android/remote/parse/adapter/SearchDeviceResourcesProvider;", "resourceProvider", "Lcom/google/gson/TypeAdapterFactory;", "provideCommonTypeAdapterFactories", "(Lcom/avito/android/remote/parse/adapter/SearchDeviceResourcesProvider;)Ljava/util/Set;", "<init>", "()V", "search_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SearchJsonModule {
    @NotNull
    public static final SearchJsonModule INSTANCE = new SearchJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterFactory> provideCommonTypeAdapterFactories(@NotNull SearchDeviceResourcesProvider searchDeviceResourcesProvider) {
        Intrinsics.checkNotNullParameter(searchDeviceResourcesProvider, "resourceProvider");
        return y.setOf((Object[]) new TypeAdapterFactory[]{new MarkerTypeAdapterFactory().create(), InlineFilterTypeAdapterFactory.Companion.create(), new TabletDisplayTypeFallbackTypeAdapterFactory(searchDeviceResourcesProvider)});
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(SectionTypeElement.class, new RecommendationTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(InlineFilterValue.InlineFilterSelectValue.class, new InlineFilterSelectValueTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(InlineFilterValue.InlineFilterMultiSelectValue.class, new InlineFilterMultiSelectValueTypeAdapter()));
        return linkedHashSet;
    }
}

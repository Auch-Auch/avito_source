package com.avito.android.di.module;

import com.avito.android.remote.model.FavoritesLoadingResult;
import com.avito.android.remote.parse.adapter.FavoritesLoadingResultOkTypeAdapter;
import com.avito.android.util.CustomTypeAdapterEntry;
import com.avito.android.util.GsonSetsKt;
import com.avito.android.util.TypeAdapterEntry;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/di/module/FavoritesJsonModule;", "", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "()Ljava/util/Set;", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapter", "<init>", "()V", "favorite_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class FavoritesJsonModule {
    @NotNull
    public static final FavoritesJsonModule INSTANCE = new FavoritesJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapter() {
        return GsonSetsKt.registerCustomType(new LinkedHashSet(), FavoritesLoadingResult.class, r.mapOf(TuplesKt.to("ok", FavoritesLoadingResult.Ok.class), TuplesKt.to("list-expired", FavoritesLoadingResult.ListExpiredError.class)));
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(FavoritesLoadingResult.Ok.class, new FavoritesLoadingResultOkTypeAdapter()));
        return linkedHashSet;
    }
}

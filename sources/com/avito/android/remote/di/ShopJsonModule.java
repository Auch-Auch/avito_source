package com.avito.android.remote.di;

import com.avito.android.remote.parse.adapter.ShopInfoOkAdapter;
import com.avito.android.remote.shop.detailed.ShopElement;
import com.avito.android.remote.shop.info.ShopInfoResult;
import com.avito.android.shop.detailed.remote.ShopDetailedOkAdapter;
import com.avito.android.shop.detailed.remote.ShopDetailedResult;
import com.avito.android.shop.detailed.remote.ShopElementTypeAdapter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/di/ShopJsonModule;", "", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "()Ljava/util/Set;", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapters", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ShopJsonModule {
    @NotNull
    public static final ShopJsonModule INSTANCE = new ShopJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(new LinkedHashSet(), ShopDetailedResult.class, r.mapOf(TuplesKt.to("ok", ShopDetailedResult.Ok.class), TuplesKt.to("not-found", ShopDetailedResult.NotFound.class))), ShopInfoResult.class, r.mapOf(TuplesKt.to("ok", ShopInfoResult.Ok.class), TuplesKt.to("not-found", ShopInfoResult.NotFound.class)));
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(ShopDetailedResult.Ok.class, new ShopDetailedOkAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(ShopInfoResult.Ok.class, new ShopInfoOkAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(ShopElement.class, new ShopElementTypeAdapter()));
        return linkedHashSet;
    }
}

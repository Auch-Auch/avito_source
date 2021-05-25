package com.avito.android.item_map.remote.di;

import com.avito.android.item_map.remote.ItemMapApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/item_map/remote/di/ItemMapApiModule;", "", "Lcom/avito/android/remote/RetrofitFactory;", "retrofit", "Lcom/avito/android/item_map/remote/ItemMapApi;", "provideItemMapApi$item_map_release", "(Lcom/avito/android/remote/RetrofitFactory;)Lcom/avito/android/item_map/remote/ItemMapApi;", "provideItemMapApi", "<init>", "()V", "item-map_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ItemMapApiModule {
    @NotNull
    public static final ItemMapApiModule INSTANCE = new ItemMapApiModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ItemMapApi provideItemMapApi$item_map_release(@NotNull RetrofitFactory retrofitFactory) {
        Intrinsics.checkNotNullParameter(retrofitFactory, "retrofit");
        return (ItemMapApi) retrofitFactory.create(ItemMapApi.class);
    }
}

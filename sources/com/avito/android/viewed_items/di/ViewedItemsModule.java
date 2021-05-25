package com.avito.android.viewed_items.di;

import a2.b.a.a.a;
import com.avito.android.di.PerFragment;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter;
import com.avito.android.favorites.di.FavoriteAdvertsModule;
import com.avito.android.viewed_items.ViewedItemsInteractor;
import com.avito.android.viewed_items.ViewedItemsInteractorImpl;
import com.avito.android.viewed_items.ViewedItemsPresenter;
import com.avito.android.viewed_items.ViewedItemsPresenterImpl;
import com.avito.android.viewed_items.adapter.ViewedItemsBlueprint;
import com.avito.android.viewed_items.adapter.ViewedItemsLoadingItemBlueprint;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/viewed_items/di/ViewedItemsModule;", "", "Lcom/avito/android/viewed_items/adapter/ViewedItemsBlueprint;", "viewedItemsBlueprint", "Lcom/avito/android/viewed_items/adapter/ViewedItemsLoadingItemBlueprint;", "loadingItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideViewedItemsItemBinder$favorites_release", "(Lcom/avito/android/viewed_items/adapter/ViewedItemsBlueprint;Lcom/avito/android/viewed_items/adapter/ViewedItemsLoadingItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideViewedItemsItemBinder", "viewedItemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideViewedItemsAdapterPresenter$favorites_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideViewedItemsAdapterPresenter", "<init>", "()V", "Declarations", "favorites_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, FavoriteAdvertsModule.class})
public final class ViewedItemsModule {
    @NotNull
    public static final ViewedItemsModule INSTANCE = new ViewedItemsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/viewed_items/di/ViewedItemsModule$Declarations;", "", "Lcom/avito/android/viewed_items/ViewedItemsPresenterImpl;", "presenter", "Lcom/avito/android/viewed_items/ViewedItemsPresenter;", "bindViewedItemsPresenter", "(Lcom/avito/android/viewed_items/ViewedItemsPresenterImpl;)Lcom/avito/android/viewed_items/ViewedItemsPresenter;", "Lcom/avito/android/viewed_items/ViewedItemsInteractorImpl;", "interactor", "Lcom/avito/android/viewed_items/ViewedItemsInteractor;", "bindViewedItemsInteractor", "(Lcom/avito/android/viewed_items/ViewedItemsInteractorImpl;)Lcom/avito/android/viewed_items/ViewedItemsInteractor;", "viewedItemsActionListener", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenter$Listener;", "bindFavoriteAdvertItemPresenterListener", "(Lcom/avito/android/viewed_items/ViewedItemsPresenter;)Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenter$Listener;", "favorites_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @ViewedItems
        @NotNull
        @PerFragment
        FavoriteAdvertItemPresenter.Listener bindFavoriteAdvertItemPresenterListener(@NotNull ViewedItemsPresenter viewedItemsPresenter);

        @PerFragment
        @Binds
        @NotNull
        ViewedItemsInteractor bindViewedItemsInteractor(@NotNull ViewedItemsInteractorImpl viewedItemsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewedItemsPresenter bindViewedItemsPresenter(@NotNull ViewedItemsPresenterImpl viewedItemsPresenterImpl);
    }

    @Provides
    @JvmStatic
    @ViewedItems
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideViewedItemsAdapterPresenter$favorites_release(@ViewedItems @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "viewedItemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @ViewedItems
    @NotNull
    @PerFragment
    public static final ItemBinder provideViewedItemsItemBinder$favorites_release(@NotNull ViewedItemsBlueprint viewedItemsBlueprint, @NotNull ViewedItemsLoadingItemBlueprint viewedItemsLoadingItemBlueprint) {
        Intrinsics.checkNotNullParameter(viewedItemsBlueprint, "viewedItemsBlueprint");
        Intrinsics.checkNotNullParameter(viewedItemsLoadingItemBlueprint, "loadingItemBlueprint");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        builder.registerItem(viewedItemsBlueprint);
        builder.registerItem(viewedItemsLoadingItemBlueprint);
        return builder.build();
    }
}

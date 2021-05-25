package com.avito.android.tns_gallery.di;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.tns_gallery.TnsGalleryItemBlueprint;
import com.avito.android.tns_gallery.TnsGalleryItemPresenter;
import com.avito.android.tns_gallery.TnsGalleryItemPresenterImpl;
import com.avito.android.tns_gallery.TnsGalleryItemSizeHelper;
import com.avito.android.tns_gallery.TnsGalleryItemSizeHelperImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/tns_gallery/di/TnsGalleryItemModule;", "", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/android/tns_gallery/TnsGalleryItemPresenter;", "presenter", "Lcom/avito/android/Features;", "features", "provideItemBinder", "(Lcom/avito/android/tns_gallery/TnsGalleryItemPresenter;Lcom/avito/android/Features;)Lcom/avito/konveyor/ItemBinder;", "<init>", "()V", "Declarations", "tns-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class TnsGalleryItemModule {
    @NotNull
    public static final TnsGalleryItemModule INSTANCE = new TnsGalleryItemModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/tns_gallery/di/TnsGalleryItemModule$Declarations;", "", "Lcom/avito/android/tns_gallery/TnsGalleryItemPresenterImpl;", "impl", "Lcom/avito/android/tns_gallery/TnsGalleryItemPresenter;", "bindItemPresenter", "(Lcom/avito/android/tns_gallery/TnsGalleryItemPresenterImpl;)Lcom/avito/android/tns_gallery/TnsGalleryItemPresenter;", "Lcom/avito/android/tns_gallery/TnsGalleryItemSizeHelperImpl;", "Lcom/avito/android/tns_gallery/TnsGalleryItemSizeHelper;", "bindHelper", "(Lcom/avito/android/tns_gallery/TnsGalleryItemSizeHelperImpl;)Lcom/avito/android/tns_gallery/TnsGalleryItemSizeHelper;", "tns-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        TnsGalleryItemSizeHelper bindHelper(@NotNull TnsGalleryItemSizeHelperImpl tnsGalleryItemSizeHelperImpl);

        @Binds
        @NotNull
        TnsGalleryItemPresenter bindItemPresenter(@NotNull TnsGalleryItemPresenterImpl tnsGalleryItemPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final ItemBinder provideItemBinder(@NotNull TnsGalleryItemPresenter tnsGalleryItemPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(tnsGalleryItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ItemBinder.Builder().registerItem(new TnsGalleryItemBlueprint(tnsGalleryItemPresenter, features)).build();
    }
}

package com.avito.android.advert.item.guide.di;

import a2.b.a.a.a;
import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.item.guide.AdvertDetailsGuideBlueprint;
import com.avito.android.advert.item.guide.AdvertDetailsGuidePresenter;
import com.avito.android.advert.item.guide.AdvertDetailsGuidePresenterImpl;
import com.avito.android.advert.item.guide.section.GuideSectionItemBlueprint;
import com.avito.android.advert.item.guide.section.GuideSectionItemPresenter;
import com.avito.android.advert.item.guide.section.GuideSectionItemPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert/item/guide/di/AdvertDetailsGuideModule;", "", "Lcom/avito/android/advert/item/guide/section/GuideSectionItemBlueprint;", "guideSectionItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Lcom/avito/android/advert/item/guide/section/GuideSectionItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideSectionsAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSectionsAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "<init>", "()V", "Declaration", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declaration.class})
public final class AdvertDetailsGuideModule {
    @NotNull
    public static final AdvertDetailsGuideModule INSTANCE = new AdvertDetailsGuideModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/item/guide/di/AdvertDetailsGuideModule$Declaration;", "", "Lcom/avito/android/advert/item/guide/section/GuideSectionItemPresenterImpl;", "presenter", "Lcom/avito/android/advert/item/guide/section/GuideSectionItemPresenter;", "bindGuideSectionItemPresenter", "(Lcom/avito/android/advert/item/guide/section/GuideSectionItemPresenterImpl;)Lcom/avito/android/advert/item/guide/section/GuideSectionItemPresenter;", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenterImpl;", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter;", "bindAdvertDetailsGuidePresenter", "(Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenterImpl;)Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter;", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuideBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindAdvertDetailsGuideBlueprint", "(Lcom/avito/android/advert/item/guide/AdvertDetailsGuideBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declaration {
        @AdvertFragmentModule.AdvertBlueprints
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindAdvertDetailsGuideBlueprint(@NotNull AdvertDetailsGuideBlueprint advertDetailsGuideBlueprint);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsGuidePresenter bindAdvertDetailsGuidePresenter(@NotNull AdvertDetailsGuidePresenterImpl advertDetailsGuidePresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        GuideSectionItemPresenter bindGuideSectionItemPresenter(@NotNull GuideSectionItemPresenterImpl guideSectionItemPresenterImpl);
    }

    @Provides
    @NotNull
    @GuideSections
    @PerFragment
    public final ItemBinder provideItemBinder(@NotNull GuideSectionItemBlueprint guideSectionItemBlueprint) {
        Intrinsics.checkNotNullParameter(guideSectionItemBlueprint, "guideSectionItemBlueprint");
        return new ItemBinder.Builder().registerItem(guideSectionItemBlueprint).build();
    }

    @Provides
    @NotNull
    @GuideSections
    @PerFragment
    public final SimpleRecyclerAdapter provideSectionsAdapter(@GuideSections @NotNull AdapterPresenter adapterPresenter, @GuideSections @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @NotNull
    @GuideSections
    @PerFragment
    public final AdapterPresenter provideSectionsAdapterPresenter(@GuideSections @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }
}

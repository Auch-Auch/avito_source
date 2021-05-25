package com.avito.android.shop.awards.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.shop.awards.AwardsInteractor;
import com.avito.android.shop.awards.AwardsInteractorImpl;
import com.avito.android.shop.awards.AwardsPresenter;
import com.avito.android.shop.awards.AwardsPresenterImpl;
import com.avito.android.shop.awards.AwardsResourceProvider;
import com.avito.android.shop.awards.AwardsResourceProviderImpl;
import com.avito.android.shop.awards.ShopAwardsItemsConverter;
import com.avito.android.shop.awards.ShopAwardsItemsConverterImpl;
import com.avito.android.shop.awards.item.action.ActionClickProvider;
import com.avito.android.shop.awards.item.action.ActionClickProviderImpl;
import com.avito.android.shop.awards.item.action.ActionItemBlueprint;
import com.avito.android.shop.awards.item.action.ActionItemPresenter;
import com.avito.android.shop.awards.item.award.AwardItemBlueprint;
import com.avito.android.shop.awards.item.subtitle.SubtitleItemBlueprint;
import com.avito.android.shop.awards.item.title.TitleItemBlueprint;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u00013B\t\b\u0002¢\u0006\u0004\b1\u00102JI\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010$\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\nH\u0007¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020.2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/android/shop/awards/di/AwardsModule;", "", "Lcom/avito/android/shop/awards/AwardsInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/shop/awards/AwardsResourceProvider;", "resourceProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/shop/awards/ShopAwardsItemsConverter;", "shopAwardsItemsConverter", "Lcom/avito/android/shop/awards/item/action/ActionClickProvider;", "actionClickProvider", "Lcom/avito/android/util/Kundle;", "state", "Lcom/avito/android/shop/awards/AwardsPresenter;", "providePresenter", "(Lcom/avito/android/shop/awards/AwardsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/shop/awards/AwardsResourceProvider;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/shop/awards/ShopAwardsItemsConverter;Lcom/avito/android/shop/awards/item/action/ActionClickProvider;Lcom/avito/android/util/Kundle;)Lcom/avito/android/shop/awards/AwardsPresenter;", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "awards", "provideInteractor", "(Lcom/avito/android/remote/model/SellerVerification$AwardsItem;)Lcom/avito/android/shop/awards/AwardsInteractor;", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/shop/awards/item/title/TitleItemBlueprint;", "titleItemBlueprint", "Lcom/avito/android/shop/awards/item/subtitle/SubtitleItemBlueprint;", "subtitleItemBlueprint", "Lcom/avito/android/shop/awards/item/award/AwardItemBlueprint;", "awardItemBlueprint", "Lcom/avito/android/shop/awards/item/action/ActionItemBlueprint;", "actionItemBlueprint", "provideItemBinder", "(Lcom/avito/android/shop/awards/item/title/TitleItemBlueprint;Lcom/avito/android/shop/awards/item/subtitle/SubtitleItemBlueprint;Lcom/avito/android/shop/awards/item/award/AwardItemBlueprint;Lcom/avito/android/shop/awards/item/action/ActionItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "Landroid/content/res/Resources;", "resources", "provideResourceProvider", "(Landroid/content/res/Resources;)Lcom/avito/android/shop/awards/AwardsResourceProvider;", "provideShopAwardsItemsConverter", "()Lcom/avito/android/shop/awards/ShopAwardsItemsConverter;", "Lcom/avito/android/shop/awards/item/action/ActionItemPresenter;", "provideActionItemPresenter", "(Lcom/avito/android/shop/awards/item/action/ActionClickProvider;)Lcom/avito/android/shop/awards/item/action/ActionItemPresenter;", "<init>", "()V", "Declarations", "shop_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class AwardsModule {
    @NotNull
    public static final AwardsModule INSTANCE = new AwardsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/shop/awards/di/AwardsModule$Declarations;", "", "Lcom/avito/android/shop/awards/item/action/ActionClickProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/shop/awards/item/action/ActionClickProvider;", "bindActionClickProvider", "(Lcom/avito/android/shop/awards/item/action/ActionClickProviderImpl;)Lcom/avito/android/shop/awards/item/action/ActionClickProvider;", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        ActionClickProvider bindActionClickProvider(@NotNull ActionClickProviderImpl actionClickProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ActionItemPresenter provideActionItemPresenter(@NotNull ActionClickProvider actionClickProvider) {
        Intrinsics.checkNotNullParameter(actionClickProvider, "actionClickProvider");
        return new ActionItemPresenter(actionClickProvider.getClickConsumer());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SimpleRecyclerAdapter provideAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AwardsInteractor provideInteractor(@NotNull SellerVerification.AwardsItem awardsItem) {
        Intrinsics.checkNotNullParameter(awardsItem, "awards");
        return new AwardsInteractorImpl(awardsItem);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ItemBinder provideItemBinder(@NotNull TitleItemBlueprint titleItemBlueprint, @NotNull SubtitleItemBlueprint subtitleItemBlueprint, @NotNull AwardItemBlueprint awardItemBlueprint, @NotNull ActionItemBlueprint actionItemBlueprint) {
        Intrinsics.checkNotNullParameter(titleItemBlueprint, "titleItemBlueprint");
        Intrinsics.checkNotNullParameter(subtitleItemBlueprint, "subtitleItemBlueprint");
        Intrinsics.checkNotNullParameter(awardItemBlueprint, "awardItemBlueprint");
        Intrinsics.checkNotNullParameter(actionItemBlueprint, "actionItemBlueprint");
        return new ItemBinder.Builder().registerItem(titleItemBlueprint).registerItem(subtitleItemBlueprint).registerItem(awardItemBlueprint).registerItem(actionItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AwardsPresenter providePresenter(@NotNull AwardsInteractor awardsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AwardsResourceProvider awardsResourceProvider, @NotNull AdapterPresenter adapterPresenter, @NotNull ShopAwardsItemsConverter shopAwardsItemsConverter, @NotNull ActionClickProvider actionClickProvider, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(awardsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(awardsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(shopAwardsItemsConverter, "shopAwardsItemsConverter");
        Intrinsics.checkNotNullParameter(actionClickProvider, "actionClickProvider");
        return new AwardsPresenterImpl(awardsInteractor, schedulersFactory3, awardsResourceProvider, adapterPresenter, shopAwardsItemsConverter, actionClickProvider.getClickObservable(), kundle);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AwardsResourceProvider provideResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new AwardsResourceProviderImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ShopAwardsItemsConverter provideShopAwardsItemsConverter() {
        return new ShopAwardsItemsConverterImpl();
    }
}

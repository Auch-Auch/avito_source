package com.avito.android.notification_center.landing.recommends.review_list.di;

import a2.b.a.a.a;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerFragment;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListInteractor;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListInteractorImpl;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListPresenter;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListPresenterImpl;
import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItem;
import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItemBlueprint;
import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItemPresenter;
import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItemPresenterImpl;
import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItemView;
import com.avito.android.notification_center.landing.recommends.review_list.title.NcRecommendsReviewListTitle;
import com.avito.android.notification_center.landing.recommends.review_list.title.NcRecommendsReviewListTitleBlueprint;
import com.avito.android.notification_center.landing.recommends.review_list.title.NcRecommendsReviewListTitlePresenter;
import com.avito.android.notification_center.landing.recommends.review_list.title.NcRecommendsReviewListTitlePresenterImpl;
import com.avito.android.notification_center.landing.recommends.review_list.title.NcRecommendsReviewListTitleView;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListModule;", "", "Lcom/jakewharton/rxrelay2/Relay;", "", "provideItemRelay", "()Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/notification_center/landing/recommends/review_list/item/NcRecommendsReviewListItemBlueprint;", "itemBlueprint", "Lcom/avito/android/notification_center/landing/recommends/review_list/title/NcRecommendsReviewListTitleBlueprint;", "titleBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Lcom/avito/android/notification_center/landing/recommends/review_list/item/NcRecommendsReviewListItemBlueprint;Lcom/avito/android/notification_center/landing/recommends/review_list/title/NcRecommendsReviewListTitleBlueprint;)Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "<init>", "()V", "Declarations", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class, Declarations.class})
public final class NcRecommendsReviewListModule {
    @NotNull
    public static final NcRecommendsReviewListModule INSTANCE = new NcRecommendsReviewListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListModule$Declarations;", "", "Lcom/avito/android/notification_center/landing/recommends/review_list/item/NcRecommendsReviewListItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/recommends/review_list/item/NcRecommendsReviewListItemView;", "Lcom/avito/android/notification_center/landing/recommends/review_list/item/NcRecommendsReviewListItem;", "bindNcRecommendsReviewListItemBlueprint", "(Lcom/avito/android/notification_center/landing/recommends/review_list/item/NcRecommendsReviewListItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/recommends/review_list/item/NcRecommendsReviewListItemPresenterImpl;", "presenter", "Lcom/avito/android/notification_center/landing/recommends/review_list/item/NcRecommendsReviewListItemPresenter;", "bindNcRecommendsReviewListItemPresenter", "(Lcom/avito/android/notification_center/landing/recommends/review_list/item/NcRecommendsReviewListItemPresenterImpl;)Lcom/avito/android/notification_center/landing/recommends/review_list/item/NcRecommendsReviewListItemPresenter;", "Lcom/avito/android/notification_center/landing/recommends/review_list/title/NcRecommendsReviewListTitleBlueprint;", "Lcom/avito/android/notification_center/landing/recommends/review_list/title/NcRecommendsReviewListTitleView;", "Lcom/avito/android/notification_center/landing/recommends/review_list/title/NcRecommendsReviewListTitle;", "bindNcRecommendsReviewListTitleBlueprint", "(Lcom/avito/android/notification_center/landing/recommends/review_list/title/NcRecommendsReviewListTitleBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/recommends/review_list/title/NcRecommendsReviewListTitlePresenterImpl;", "Lcom/avito/android/notification_center/landing/recommends/review_list/title/NcRecommendsReviewListTitlePresenter;", "bindNcRecommendsReviewListTitlePresenter", "(Lcom/avito/android/notification_center/landing/recommends/review_list/title/NcRecommendsReviewListTitlePresenterImpl;)Lcom/avito/android/notification_center/landing/recommends/review_list/title/NcRecommendsReviewListTitlePresenter;", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListPresenterImpl;", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListPresenter;", "bindNcRecommendsReviewListPresenter", "(Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListPresenterImpl;)Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListPresenter;", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListInteractorImpl;", "interactor", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListInteractor;", "bindNcRecommendsReviewListInteractor", "(Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListInteractorImpl;)Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListInteractor;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        NcRecommendsReviewListInteractor bindNcRecommendsReviewListInteractor(@NotNull NcRecommendsReviewListInteractorImpl ncRecommendsReviewListInteractorImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<NcRecommendsReviewListItemView, NcRecommendsReviewListItem> bindNcRecommendsReviewListItemBlueprint(@NotNull NcRecommendsReviewListItemBlueprint ncRecommendsReviewListItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        NcRecommendsReviewListItemPresenter bindNcRecommendsReviewListItemPresenter(@NotNull NcRecommendsReviewListItemPresenterImpl ncRecommendsReviewListItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        NcRecommendsReviewListPresenter bindNcRecommendsReviewListPresenter(@NotNull NcRecommendsReviewListPresenterImpl ncRecommendsReviewListPresenterImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<NcRecommendsReviewListTitleView, NcRecommendsReviewListTitle> bindNcRecommendsReviewListTitleBlueprint(@NotNull NcRecommendsReviewListTitleBlueprint ncRecommendsReviewListTitleBlueprint);

        @PerFragment
        @Binds
        @NotNull
        NcRecommendsReviewListTitlePresenter bindNcRecommendsReviewListTitlePresenter(@NotNull NcRecommendsReviewListTitlePresenterImpl ncRecommendsReviewListTitlePresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder(@NotNull NcRecommendsReviewListItemBlueprint ncRecommendsReviewListItemBlueprint, @NotNull NcRecommendsReviewListTitleBlueprint ncRecommendsReviewListTitleBlueprint) {
        Intrinsics.checkNotNullParameter(ncRecommendsReviewListItemBlueprint, "itemBlueprint");
        Intrinsics.checkNotNullParameter(ncRecommendsReviewListTitleBlueprint, "titleBlueprint");
        return new ItemBinder.Builder().registerItem(ncRecommendsReviewListItemBlueprint).registerItem(ncRecommendsReviewListTitleBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final Relay<Integer> provideItemRelay() {
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }
}

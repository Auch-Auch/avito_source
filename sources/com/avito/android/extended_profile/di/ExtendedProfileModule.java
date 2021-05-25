package com.avito.android.extended_profile.di;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactory;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactoryImpl;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerFragment;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.extended_profile.ExtendedProfileContactsInteractor;
import com.avito.android.extended_profile.ExtendedProfileContactsInteractorImpl;
import com.avito.android.extended_profile.ExtendedProfileInteractor;
import com.avito.android.extended_profile.ExtendedProfileInteractorImpl;
import com.avito.android.extended_profile.ExtendedProfileResourceProvider;
import com.avito.android.extended_profile.ExtendedProfileResourceProviderImpl;
import com.avito.android.extended_profile.ExtendedProfileSubscriptionInteractorImpl;
import com.avito.android.extended_profile.ExtendedProfileViewModel;
import com.avito.android.extended_profile.ExtendedProfileViewModelFactory;
import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.extended_profile.adapter.badge_bar.di.BadgeBarItemModule;
import com.avito.android.extended_profile.adapter.category.category_advert.di.CategoryAdvertItemModule;
import com.avito.android.extended_profile.adapter.category.category_button.di.CategoryButtonItemModule;
import com.avito.android.extended_profile.adapter.category.category_header.di.CategoryHeaderItemModule;
import com.avito.android.extended_profile.adapter.contact_bar.di.ContactBarItemModule;
import com.avito.android.extended_profile.adapter.divider.di.DividerItemModule;
import com.avito.android.extended_profile.adapter.error.di.ErrorItemModule;
import com.avito.android.extended_profile.adapter.gallery.di.GalleryItemModule;
import com.avito.android.extended_profile.adapter.header.di.HeaderItemModule;
import com.avito.android.extended_profile.adapter.info.di.InfoItemModule;
import com.avito.android.extended_profile.adapter.progress.di.ProgressItemModule;
import com.avito.android.extended_profile.adapter.title.di.TitleItemModule;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerModule;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.public_profile.ui.PublicProfileResourceProviderImpl;
import com.avito.android.public_profile.ui.SubscribeInteractor;
import com.avito.android.public_profile.ui.SubscriptionStateListener;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenterImpl;
import com.avito.android.public_profile.ui.SubscriptionsResourceProvider;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.SerpAdvertConverterImpl;
import com.avito.android.serp.adapter.SimpleAdvertSpanCountProvider;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.ui_components.R;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001@B\t\b\u0002¢\u0006\u0004\b>\u0010?J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0001¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016Jm\u0010-\u001a\u00020,2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b-\u0010.J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H\u0007¢\u0006\u0004\b2\u00103J\u0017\u00107\u001a\u0002042\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u0002082\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020;2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/avito/android/extended_profile/di/ExtendedProfileModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/extended_profile/ExtendedProfileViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/extended_profile/ExtendedProfileViewModel;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", "provideActionRelay", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "provideCommentGalleryClicksStream$extended_profile_release", "provideCommentGalleryClicksStream", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "provideAdvertConverter", "(Landroid/content/res/Resources;Lcom/avito/android/Features;)Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", "Lcom/avito/android/FavoriteSellersRepository;", "favoriteSellersRepository", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "resourceProvider", "Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "interactor", "Ldagger/Lazy;", "Lcom/avito/android/public_profile/ui/SubscriptionStateListener;", "stateListener", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "provideSubscriptionsPresenter", "(Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/FavoriteSellersRepository;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;Lcom/avito/android/public_profile/ui/SubscribeInteractor;Ldagger/Lazy;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/Features;)Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "Landroid/content/Context;", "context", "Landroidx/core/app/NotificationManagerCompat;", "provideNotificationManager", "(Landroid/content/Context;)Landroidx/core/app/NotificationManagerCompat;", "Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "provideAdvertActionIconFactory$extended_profile_release", "(Landroid/content/Context;)Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "provideAdvertActionIconFactory", "", "provideAdvertsColumnCount", "(Landroid/content/res/Resources;)I", "", "provideIsTablet", "(Landroid/content/res/Resources;)Z", "<init>", "()V", "Declarations", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class, HeaderItemModule.class, ContactBarItemModule.class, DividerItemModule.class, TitleItemModule.class, InfoItemModule.class, BadgeBarItemModule.class, GalleryItemModule.class, CategoryButtonItemModule.class, CategoryHeaderItemModule.class, CategoryAdvertItemModule.class, ProgressItemModule.class, ErrorItemModule.class, ErrorHelperModule.class, CompositeSnackbarModule.class, NotificationManagerModule.class, PhoneNumberFormatterModule.class, DialogRouterModule.class})
public final class ExtendedProfileModule {
    @NotNull
    public static final ExtendedProfileModule INSTANCE = new ExtendedProfileModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H'¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00192\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H'¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0013H'¢\u0006\u0004\b\u001d\u0010\u0018J#\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0013H'¢\u0006\u0004\b\u001e\u0010\u001bJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020(H'¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/avito/android/extended_profile/di/ExtendedProfileModule$Declarations;", "", "Lcom/avito/android/extended_profile/ExtendedProfileInteractorImpl;", "impl", "Lcom/avito/android/extended_profile/ExtendedProfileInteractor;", "bindInteractor", "(Lcom/avito/android/extended_profile/ExtendedProfileInteractorImpl;)Lcom/avito/android/extended_profile/ExtendedProfileInteractor;", "Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractorImpl;", "Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractor;", "bindContactsInteractor", "(Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractorImpl;)Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractor;", "Lcom/avito/android/extended_profile/ExtendedProfileSubscriptionInteractorImpl;", "Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "bindSubscriptionInteractor", "(Lcom/avito/android/extended_profile/ExtendedProfileSubscriptionInteractorImpl;)Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "Lcom/avito/android/extended_profile/ExtendedProfileViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "bindViewModelFactory", "(Lcom/avito/android/extended_profile/ExtendedProfileViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", "relay", "Lio/reactivex/rxjava3/core/Observable;", "bindActionObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindActionConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "bindTnsGalleryClicksObservable", "bindTnsGalleryClicksConsumer", "Lcom/avito/android/extended_profile/ExtendedProfileResourceProviderImpl;", "Lcom/avito/android/extended_profile/ExtendedProfileResourceProvider;", "bindResourceProvider", "(Lcom/avito/android/extended_profile/ExtendedProfileResourceProviderImpl;)Lcom/avito/android/extended_profile/ExtendedProfileResourceProvider;", "Lcom/avito/android/public_profile/ui/PublicProfileResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "bindSubscriptionsResourceProvider", "(Lcom/avito/android/public_profile/ui/PublicProfileResourceProviderImpl;)Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "Lcom/avito/android/extended_profile/ExtendedProfileViewModel;", "Lcom/avito/android/public_profile/ui/SubscriptionStateListener;", "bindSubscriptionStateListener", "(Lcom/avito/android/extended_profile/ExtendedProfileViewModel;)Lcom/avito/android/public_profile/ui/SubscriptionStateListener;", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @PerFragment
        Consumer<ExtendedProfileItemAction> bindActionConsumer(@NotNull PublishRelay<ExtendedProfileItemAction> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<ExtendedProfileItemAction> bindActionObservable(@NotNull PublishRelay<ExtendedProfileItemAction> publishRelay);

        @PerFragment
        @Binds
        @NotNull
        ExtendedProfileContactsInteractor bindContactsInteractor(@NotNull ExtendedProfileContactsInteractorImpl extendedProfileContactsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ExtendedProfileInteractor bindInteractor(@NotNull ExtendedProfileInteractorImpl extendedProfileInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ExtendedProfileResourceProvider bindResourceProvider(@NotNull ExtendedProfileResourceProviderImpl extendedProfileResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        SubscribeInteractor bindSubscriptionInteractor(@NotNull ExtendedProfileSubscriptionInteractorImpl extendedProfileSubscriptionInteractorImpl);

        @Binds
        @NotNull
        SubscriptionStateListener bindSubscriptionStateListener(@NotNull ExtendedProfileViewModel extendedProfileViewModel);

        @PerFragment
        @Binds
        @NotNull
        SubscriptionsResourceProvider bindSubscriptionsResourceProvider(@NotNull PublicProfileResourceProviderImpl publicProfileResourceProviderImpl);

        @Binds
        @NotNull
        Consumer<TnsGalleryItemClickAction> bindTnsGalleryClicksConsumer(@NotNull PublishRelay<TnsGalleryItemClickAction> publishRelay);

        @Binds
        @NotNull
        Observable<TnsGalleryItemClickAction> bindTnsGalleryClicksObservable(@NotNull PublishRelay<TnsGalleryItemClickAction> publishRelay);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory bindViewModelFactory(@NotNull ExtendedProfileViewModelFactory extendedProfileViewModelFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final PublishRelay<ExtendedProfileItemAction> provideActionRelay() {
        PublishRelay<ExtendedProfileItemAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SerpAdvertConverter provideAdvertConverter(@NotNull Resources resources, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(features, "features");
        int i = R.integer.serp_item_span_count;
        return new SerpAdvertConverterImpl(new SimpleAdvertSpanCountProvider(resources.getInteger(i)), new SimpleAdvertSpanCountProvider(resources.getInteger(i)), resources.getBoolean(R.bool.is_tablet), features);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final PublishRelay<TnsGalleryItemClickAction> provideCommentGalleryClicksStream$extended_profile_release() {
        PublishRelay<TnsGalleryItemClickAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final NotificationManagerCompat provideNotificationManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "NotificationManagerCompat.from(context)");
        return from;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SubscriptionsPresenter provideSubscriptionsPresenter(@NotNull NotificationManagerProvider notificationManagerProvider, @NotNull FavoriteSellersRepository favoriteSellersRepository, @NotNull AccountStateProvider accountStateProvider, @NotNull SubscriptionsResourceProvider subscriptionsResourceProvider, @NotNull SubscribeInteractor subscribeInteractor, @NotNull Lazy<SubscriptionStateListener> lazy, @NotNull ErrorHelper errorHelper, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "favoriteSellersRepository");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(subscriptionsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(subscribeInteractor, "interactor");
        Intrinsics.checkNotNullParameter(lazy, "stateListener");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SubscriptionsPresenterImpl(notificationManagerProvider, favoriteSellersRepository, accountStateProvider, subscriptionsResourceProvider, subscribeInteractor, errorHelper, lazy, schedulersFactory3, analytics, null, SubscriptionSource.EXTENDED_PROFILE, compositeSnackbarPresenter, features);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ExtendedProfileViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, factory).get(ExtendedProfileViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (ExtendedProfileViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdvertActionIconFactory provideAdvertActionIconFactory$extended_profile_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new AdvertActionIconFactoryImpl(context, false, 2, null);
    }

    @Provides
    @PerFragment
    public final int provideAdvertsColumnCount(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return resources.getInteger(R.integer.serp_columns);
    }

    @Provides
    @PerFragment
    public final boolean provideIsTablet(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return resources.getBoolean(R.bool.is_tablet);
    }
}

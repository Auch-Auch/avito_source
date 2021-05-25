package com.avito.android.profile.di;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.account.AccountInteractor;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screen.UserProfileTracker;
import com.avito.android.analytics.screen.UserProfileTrackerImpl;
import com.avito.android.analytics.screen.UserProfileTrackerImpl_Factory;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.cart_fab.CartFabModule_ProvideCartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabPreferences;
import com.avito.android.cart_fab.CartFabPreferencesImpl;
import com.avito.android.cart_fab.CartFabPreferencesImpl_Factory;
import com.avito.android.cart_fab.CartFabQuantityVisibilityHandler_Factory;
import com.avito.android.cart_fab.CartFabRepository;
import com.avito.android.cart_fab.CartFabRepositoryImpl;
import com.avito.android.cart_fab.CartFabRepositoryImpl_Factory;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabViewModelFactory_Factory;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl_Factory;
import com.avito.android.code_confirmation.di.CodeConfirmationModule;
import com.avito.android.code_confirmation.di.CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory;
import com.avito.android.code_confirmation.timer.RxTimer;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.dialog.DialogPresenterImpl;
import com.avito.android.dialog.DialogPresenterImpl_Factory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.profile.UserProfileFragment;
import com.avito.android.profile.UserProfileFragment_MembersInjector;
import com.avito.android.profile.UserProfileInteractor;
import com.avito.android.profile.UserProfileItemConverter;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.cards.AdvertsCardItemPresenter;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.profile.cards.ContactsCardItemPresenter;
import com.avito.android.profile.cards.DeliverySettingsItemPresenter;
import com.avito.android.profile.cards.ExtensionsCardItemPresenter;
import com.avito.android.profile.cards.HelpCenterCardItemPresenter;
import com.avito.android.profile.cards.IncomeSettingsCardItemPresenter;
import com.avito.android.profile.cards.InfoCardItemPresenter;
import com.avito.android.profile.cards.LfPackagesCardItemPresenter;
import com.avito.android.profile.cards.LogoutCardItemPresenter;
import com.avito.android.profile.cards.ReviewsCardItemPresenter;
import com.avito.android.profile.cards.ShopSettingsCardItemPresenter;
import com.avito.android.profile.cards.SocialCardItemPresenter;
import com.avito.android.profile.cards.SubscribersCardItemPresenter;
import com.avito.android.profile.cards.SubscriptionCardItemPresenter;
import com.avito.android.profile.cards.UserProfileResourceProvider;
import com.avito.android.profile.cards.action.ActionItemBlueprint;
import com.avito.android.profile.cards.action.ActionItemBlueprint_Factory;
import com.avito.android.profile.cards.action.ActionItemPresenter;
import com.avito.android.profile.cards.action.ActionItemPresenterImpl;
import com.avito.android.profile.cards.action.ActionItemPresenterImpl_Factory;
import com.avito.android.profile.cards.phones.PhonesActionResourceProvider;
import com.avito.android.profile.cards.phones.PhonesCardItemPresenter;
import com.avito.android.profile.cards.phones.PhonesCardItemPresenterOld;
import com.avito.android.profile.cards.phones.PhonesCardItemResourceProvider;
import com.avito.android.profile.cards.phones_empty.PhonesEmptyCardItemPresenter;
import com.avito.android.profile.cards.sessions.ProfileSessionsBlueprint;
import com.avito.android.profile.cards.sessions.ProfileSessionsBlueprint_Factory;
import com.avito.android.profile.cards.sessions.ProfileSessionsItemPresenter;
import com.avito.android.profile.cards.sessions.ProfileSessionsItemPresenterImpl;
import com.avito.android.profile.cards.sessions.ProfileSessionsItemPresenterImpl_Factory;
import com.avito.android.profile.cards.tfa.TfaSettingsBlueprint;
import com.avito.android.profile.cards.tfa.TfaSettingsBlueprint_Factory;
import com.avito.android.profile.cards.tfa.TfaSettingsItemPresenter;
import com.avito.android.profile.cards.tfa.TfaSettingsItemPresenterImpl;
import com.avito.android.profile.cards.tfa.TfaSettingsItemPresenterImpl_Factory;
import com.avito.android.profile.cards.verification.VerificationCardPresenter;
import com.avito.android.profile.cards.verification_platform.VerificationPlatformCardBlueprint;
import com.avito.android.profile.cards.verification_platform.VerificationPlatformCardBlueprint_Factory;
import com.avito.android.profile.cards.verification_platform.VerificationPlatformCardPresenter;
import com.avito.android.profile.cards.verification_platform.VerificationPlatformCardPresenterImpl;
import com.avito.android.profile.cards.verification_platform.VerificationPlatformCardPresenterImpl_Factory;
import com.avito.android.profile.cards.verified_profile.VerifiedProfileCardPresenter;
import com.avito.android.profile.cards.wallet.action.ActionWalletCardItemPresenter;
import com.avito.android.profile.cards.wallet.separate_action.SeparateWalletCardWithActionItemPresenter;
import com.avito.android.profile.di.UserProfileComponent;
import com.avito.android.profile.header.ProfileHeaderPresenter;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.cart.CartApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.FacebookSocialManagerImpl_Factory;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.GoogleSocialManagerImpl;
import com.avito.android.social.GoogleSocialManagerImpl_Factory;
import com.avito.android.social.Logoutable;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManagerImpl;
import com.avito.android.social.OdnoklassnikiSocialManagerImpl_Factory;
import com.avito.android.social.VkontakteSocialManager;
import com.avito.android.social.VkontakteSocialManagerImpl;
import com.avito.android.social.VkontakteSocialManagerImpl_Factory;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.common.base.Optional;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerUserProfileComponent implements UserProfileComponent {
    public static final Provider v1 = InstanceFactory.create(Optional.absent());
    public Provider<ItemBlueprint<?, ?>> A;
    public Provider<Set<ItemBlueprint<?, ?>>> A0;
    public Provider<SocialCardItemPresenter> B;
    public Provider<ItemBinder> B0;
    public Provider<ItemBlueprint<?, ?>> C;
    public Provider<AdapterPresenter> C0;
    public Provider<PhonesActionResourceProvider> D;
    public Provider<UserProfileResourceProvider> D0;
    public Provider<Analytics> E;
    public Provider<AccountInteractor> E0;
    public Provider<PhonesCardItemPresenterOld> F;
    public Provider<AccountStorageInteractor> F0;
    public Provider<PhonesCardItemResourceProvider> G;
    public Provider<Context> G0;
    public Provider<PhonesCardItemPresenter> H;
    public Provider<GoogleSocialManagerImpl> H0;
    public Provider<ItemBlueprint<?, ?>> I;
    public Provider<GoogleSocialManager> I0;
    public Provider<PhonesEmptyCardItemPresenter> J;
    public Provider<FacebookSocialManager> J0 = SingleCheck.provider(FacebookSocialManagerImpl_Factory.create());
    public Provider<ItemBlueprint<?, ?>> K;
    public Provider<OdnoklassnikiSocialManagerImpl> K0;
    public Provider<ReviewsCardItemPresenter> L;
    public Provider<OdnoklassnikiSocialManager> L0;
    public Provider<ItemBlueprint<?, ?>> M;
    public Provider<VkontakteSocialManagerImpl> M0;
    public Provider<ContactsCardItemPresenter> N;
    public Provider<VkontakteSocialManager> N0;
    public Provider<ItemBlueprint<?, ?>> O;
    public Provider<Logoutable> O0;
    public Provider<SubscriptionCardItemPresenter> P;
    public Provider<Activity> P0;
    public Provider<ItemBlueprint<?, ?>> Q;
    public Provider<DialogRouter> Q0;
    public Provider<LfPackagesCardItemPresenter> R;
    public Provider<DialogPresenterImpl> R0;
    public Provider<ItemBlueprint<?, ?>> S;
    public Provider<DialogPresenter> S0;
    public Provider<ShopSettingsCardItemPresenter> T;
    public Provider<ErrorFormatterImpl> T0;
    public Provider<ItemBlueprint<?, ?>> U;
    public Provider<ErrorFormatter> U0;
    public Provider<DeliverySettingsItemPresenter> V;
    public Provider<ErrorHelperImpl> V0;
    public Provider<ItemBlueprint<?, ?>> W;
    public Provider<ErrorHelper> W0;
    public Provider<IncomeSettingsCardItemPresenter> X;
    public Provider<RxTimer> X0;
    public Provider<ItemBlueprint<?, ?>> Y;
    public Provider<ScreenTrackerFactory> Y0;
    public Provider<HelpCenterCardItemPresenter> Z;
    public Provider<TimerFactory> Z0;
    public final UserProfileDependencies a;
    public Provider<ItemBlueprint<?, ?>> a0;
    public Provider<ScreenDiInjectTracker> a1;
    public Provider<ProfileApi> b;
    public Provider<LogoutCardItemPresenter> b0;
    public Provider<ScreenInitTracker> b1;
    public Provider<SchedulersFactory> c;
    public Provider<ItemBlueprint<?, ?>> c0;
    public Provider<ScreenFlowTrackerProvider> c1;
    public Provider<Resources> d;
    public Provider<UserProfilePresenter> d0;
    public Provider<UserProfileTrackerImpl> d1;
    public Provider<CodeConfirmationResourceProviderImpl> e;
    public Provider<OnDeepLinkClickListener> e0;
    public Provider<UserProfileTracker> e1;
    public Provider<CodeConfirmationResourceProvider> f;
    public Provider<ExtensionsCardItemPresenter> f0;
    public Provider<UserAdvertsTabTestGroup> f1;
    public Provider<TypedErrorThrowableConverter> g;
    public Provider<ItemBlueprint<?, ?>> g0;
    public Provider<NotificationCenterCounterInteractor> g1;
    public Provider<String> h;
    public Provider<SubscribersCardItemPresenter> h0;
    public Provider<SchedulersFactory3> h1;
    public Provider<Boolean> i;
    public Provider<ItemBlueprint<?, ?>> i0;
    public Provider<ProfileHeaderPresenter> i1;
    public Provider<CodeConfirmationInteractor> j;
    public Provider<VerificationPlatformCardPresenterImpl> j0;
    public Provider<ViewModelStoreOwner> j1;
    public Provider<UserProfileInteractor> k;
    public Provider<VerificationPlatformCardPresenter> k0;
    public Provider<CartApi> k1;
    public Provider<Features> l;
    public Provider<VerificationPlatformCardBlueprint> l0;
    public Provider<CartFabRepositoryImpl> l1;
    public Provider<UserProfileItemConverter> m;
    public Provider<ItemBlueprint<?, ?>> m0;
    public Provider<CartFabRepository> m1;
    public Provider<InfoCardItemPresenter> n;
    public Provider<ActionItemPresenterImpl> n0;
    public Provider<Preferences> n1;
    public Provider<ItemBlueprint<?, ?>> o;
    public Provider<ActionItemPresenter> o0;
    public Provider<CartFabPreferencesImpl> o1;
    public Provider<AdvertsCardItemPresenter> p;
    public Provider<ActionItemBlueprint> p0;
    public Provider<CartFabPreferences> p1;
    public Provider<ItemBlueprint<?, ?>> q;
    public Provider<ItemBlueprint<?, ?>> q0;
    public Provider<AccountStateProvider> q1;
    public Provider<ActionWalletCardItemPresenter> r;
    public Provider<ProfileSessionsItemPresenterImpl> r0;
    public Provider<Optional<SearchContextWrapper>> r1;
    public Provider<ItemBlueprint<?, ?>> s;
    public Provider<ProfileSessionsItemPresenter> s0;
    public Provider<CartFabViewModelFactory> s1;
    public Provider<VerifiedProfileCardPresenter> t;
    public Provider<ProfileSessionsBlueprint> t0;
    public Provider<CartFabViewModel> t1;
    public Provider<ItemBlueprint<?, ?>> u;
    public Provider<ItemBlueprint<?, ?>> u0;
    public Provider<CartQuantityChangesHandler> u1;
    public Provider<PublishRelay<DeepLink>> v;
    public Provider<PublishRelay<CardItem.TfaSettingsCardItem>> v0;
    public Provider<VerificationCardPresenter> w;
    public Provider<TfaSettingsItemPresenterImpl> w0;
    public Provider<AttributedTextFormatter> x;
    public Provider<TfaSettingsItemPresenter> x0;
    public Provider<ItemBlueprint<?, ?>> y;
    public Provider<TfaSettingsBlueprint> y0;
    public Provider<SeparateWalletCardWithActionItemPresenter> z;
    public Provider<ItemBlueprint<?, ?>> z0;

    public static final class b implements UserProfileComponent.Builder {
        public UserProfileDependencies a;
        public UserProfileModule b;
        public Activity c;
        public Resources d;
        public String e;
        public Boolean f;
        public ViewModelStoreOwner g;

        public b(a aVar) {
        }

        @Override // com.avito.android.profile.di.UserProfileComponent.Builder
        public UserProfileComponent build() {
            Preconditions.checkBuilderRequirement(this.a, UserProfileDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, UserProfileModule.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.f, Boolean.class);
            Preconditions.checkBuilderRequirement(this.g, ViewModelStoreOwner.class);
            return new DaggerUserProfileComponent(this.b, this.a, this.c, this.d, this.e, this.f, this.g, null);
        }

        @Override // com.avito.android.profile.di.UserProfileComponent.Builder
        public UserProfileComponent.Builder dependencies(UserProfileDependencies userProfileDependencies) {
            this.a = (UserProfileDependencies) Preconditions.checkNotNull(userProfileDependencies);
            return this;
        }

        @Override // com.avito.android.profile.di.UserProfileComponent.Builder
        public UserProfileComponent.Builder plus(UserProfileModule userProfileModule) {
            this.b = (UserProfileModule) Preconditions.checkNotNull(userProfileModule);
            return this;
        }

        @Override // com.avito.android.profile.di.UserProfileComponent.Builder
        public UserProfileComponent.Builder with(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.profile.di.UserProfileComponent.Builder
        public UserProfileComponent.Builder withRetry(boolean z) {
            this.f = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.profile.di.UserProfileComponent.Builder
        public UserProfileComponent.Builder withSrc(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.profile.di.UserProfileComponent.Builder
        public UserProfileComponent.Builder withViewModelStoreOwner(ViewModelStoreOwner viewModelStoreOwner) {
            this.g = (ViewModelStoreOwner) Preconditions.checkNotNull(viewModelStoreOwner);
            return this;
        }

        @Override // com.avito.android.profile.di.UserProfileComponent.Builder
        @Deprecated
        public UserProfileComponent.Builder plus(CodeConfirmationModule codeConfirmationModule) {
            Preconditions.checkNotNull(codeConfirmationModule);
            return this;
        }

        @Override // com.avito.android.profile.di.UserProfileComponent.Builder
        public UserProfileComponent.Builder with(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<AccountInteractor> {
        public final UserProfileDependencies a;

        public c(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountInteractor get() {
            return (AccountInteractor) Preconditions.checkNotNullFromComponent(this.a.accountInteractor());
        }
    }

    public static class d implements Provider<AccountStateProvider> {
        public final UserProfileDependencies a;

        public d(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class e implements Provider<AccountStorageInteractor> {
        public final UserProfileDependencies a;

        public e(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStorageInteractor get() {
            return (AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor());
        }
    }

    public static class f implements Provider<Analytics> {
        public final UserProfileDependencies a;

        public f(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class g implements Provider<CartApi> {
        public final UserProfileDependencies a;

        public g(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CartApi get() {
            return (CartApi) Preconditions.checkNotNullFromComponent(this.a.cartApi());
        }
    }

    public static class h implements Provider<Context> {
        public final UserProfileDependencies a;

        public h(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class i implements Provider<Features> {
        public final UserProfileDependencies a;

        public i(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class j implements Provider<NotificationCenterCounterInteractor> {
        public final UserProfileDependencies a;

        public j(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationCenterCounterInteractor get() {
            return (NotificationCenterCounterInteractor) Preconditions.checkNotNullFromComponent(this.a.notificationCenterCounterInteractor());
        }
    }

    public static class k implements Provider<Preferences> {
        public final UserProfileDependencies a;

        public k(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class l implements Provider<ProfileApi> {
        public final UserProfileDependencies a;

        public l(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class m implements Provider<SchedulersFactory3> {
        public final UserProfileDependencies a;

        public m(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class n implements Provider<SchedulersFactory> {
        public final UserProfileDependencies a;

        public n(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class o implements Provider<ScreenTrackerFactory> {
        public final UserProfileDependencies a;

        public o(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class p implements Provider<TimerFactory> {
        public final UserProfileDependencies a;

        public p(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class q implements Provider<TypedErrorThrowableConverter> {
        public final UserProfileDependencies a;

        public q(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class r implements Provider<UserAdvertsTabTestGroup> {
        public final UserProfileDependencies a;

        public r(UserProfileDependencies userProfileDependencies) {
            this.a = userProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAdvertsTabTestGroup get() {
            return (UserAdvertsTabTestGroup) Preconditions.checkNotNullFromComponent(this.a.userAdvertsTabTestGroup());
        }
    }

    public DaggerUserProfileComponent(UserProfileModule userProfileModule, UserProfileDependencies userProfileDependencies, Activity activity, Resources resources, String str, Boolean bool, ViewModelStoreOwner viewModelStoreOwner, a aVar) {
        this.a = userProfileDependencies;
        this.b = new l(userProfileDependencies);
        this.c = new n(userProfileDependencies);
        Factory create = InstanceFactory.create(resources);
        this.d = create;
        CodeConfirmationResourceProviderImpl_Factory create2 = CodeConfirmationResourceProviderImpl_Factory.create(create);
        this.e = create2;
        this.f = DoubleCheck.provider(create2);
        this.g = new q(userProfileDependencies);
        this.h = InstanceFactory.create(str);
        Factory create3 = InstanceFactory.create(bool);
        this.i = create3;
        Provider<CodeConfirmationInteractor> provider = DoubleCheck.provider(CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory.create(this.b, this.c, this.f, this.g, this.h, create3));
        this.j = provider;
        this.k = DoubleCheck.provider(UserProfileModule_ProvideInteractorFactory.create(userProfileModule, this.b, this.c, provider));
        i iVar = new i(userProfileDependencies);
        this.l = iVar;
        this.m = DoubleCheck.provider(UserProfileModule_ProvideConverterFactory.create(userProfileModule, iVar));
        Provider<InfoCardItemPresenter> provider2 = DoubleCheck.provider(UserProfileModule_ProvideInfoCardItemPresenter$profile_releaseFactory.create(userProfileModule, this.l));
        this.n = provider2;
        this.o = DoubleCheck.provider(UserProfileModule_ProvideInfoCardBlueprint$profile_releaseFactory.create(userProfileModule, provider2));
        Provider<AdvertsCardItemPresenter> provider3 = DoubleCheck.provider(UserProfileModule_ProvideAdvertsCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.p = provider3;
        this.q = DoubleCheck.provider(UserProfileModule_ProvideAdvertsCardBlueprint$profile_releaseFactory.create(userProfileModule, provider3));
        Provider<ActionWalletCardItemPresenter> provider4 = DoubleCheck.provider(UserProfileModule_ProvideActionWalletCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.r = provider4;
        this.s = DoubleCheck.provider(UserProfileModule_ProvideActionWalletCardBlueprint$profile_releaseFactory.create(userProfileModule, provider4, this.l));
        Provider<VerifiedProfileCardPresenter> provider5 = DoubleCheck.provider(UserProfileModule_ProvideVerifiedProfileCardPresenter$profile_releaseFactory.create(userProfileModule));
        this.t = provider5;
        this.u = DoubleCheck.provider(UserProfileModule_ProvideVerifiedProfileCardBlueprint$profile_releaseFactory.create(userProfileModule, provider5));
        Provider<PublishRelay<DeepLink>> provider6 = DoubleCheck.provider(UserProfileModule_ProvideDeeplinkClickStreamFactory.create(userProfileModule));
        this.v = provider6;
        this.w = DoubleCheck.provider(UserProfileModule_ProvideVerificationCardPresenter$profile_releaseFactory.create(userProfileModule, provider6));
        Provider<AttributedTextFormatter> provider7 = DoubleCheck.provider(UserProfileModule_ProvidesAttributedTextFormatterFactory.create(userProfileModule));
        this.x = provider7;
        this.y = DoubleCheck.provider(UserProfileModule_ProvideVerificationCardBlueprint$profile_releaseFactory.create(userProfileModule, this.w, provider7));
        Provider<SeparateWalletCardWithActionItemPresenter> provider8 = DoubleCheck.provider(UserProfileModule_ProvideSeparateWalletCardWithActionItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.z = provider8;
        this.A = DoubleCheck.provider(UserProfileModule_ProvideSeparateWalletCardWithActionBlueprint$profile_releaseFactory.create(userProfileModule, provider8, this.l));
        Provider<SocialCardItemPresenter> provider9 = DoubleCheck.provider(UserProfileModule_ProvideSocialCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.B = provider9;
        this.C = DoubleCheck.provider(UserProfileModule_ProvideSocialCardBlueprint$profile_releaseFactory.create(userProfileModule, provider9));
        Provider<PhonesActionResourceProvider> provider10 = DoubleCheck.provider(UserProfileModule_ProvidePhonesActionResourceProvider$profile_releaseFactory.create(userProfileModule));
        this.D = provider10;
        f fVar = new f(userProfileDependencies);
        this.E = fVar;
        this.F = DoubleCheck.provider(UserProfileModule_ProvidePhonesCardItemPresenterOld$profile_releaseFactory.create(userProfileModule, provider10, fVar));
        Provider<PhonesCardItemResourceProvider> provider11 = DoubleCheck.provider(UserProfileModule_ProvidePhonesCardResourceProvider$profile_releaseFactory.create(userProfileModule));
        this.G = provider11;
        Provider<PhonesCardItemPresenter> provider12 = DoubleCheck.provider(UserProfileModule_ProvidePhonesCardItemPresenter$profile_releaseFactory.create(userProfileModule, provider11));
        this.H = provider12;
        this.I = DoubleCheck.provider(UserProfileModule_ProvidePhonesCardBlueprint$profile_releaseFactory.create(userProfileModule, this.F, provider12, this.l));
        Provider<PhonesEmptyCardItemPresenter> provider13 = DoubleCheck.provider(UserProfileModule_ProvidePhonesEmptyCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.J = provider13;
        this.K = DoubleCheck.provider(UserProfileModule_ProvidePhonesEmptyCardBlueprint$profile_releaseFactory.create(userProfileModule, provider13));
        Provider<ReviewsCardItemPresenter> provider14 = DoubleCheck.provider(UserProfileModule_ProvideReviewsCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.L = provider14;
        this.M = DoubleCheck.provider(UserProfileModule_ProvideReviewsCardBlueprint$profile_releaseFactory.create(userProfileModule, provider14));
        Provider<ContactsCardItemPresenter> provider15 = DoubleCheck.provider(UserProfileModule_ProvideContactsCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.N = provider15;
        this.O = DoubleCheck.provider(UserProfileModule_ProvideContactsCardBlueprint$profile_releaseFactory.create(userProfileModule, provider15));
        Provider<SubscriptionCardItemPresenter> provider16 = DoubleCheck.provider(UserProfileModule_ProvideSubscriptionCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.P = provider16;
        this.Q = DoubleCheck.provider(UserProfileModule_ProvideSubscriptionCardBlueprint$profile_releaseFactory.create(userProfileModule, provider16, this.x));
        Provider<LfPackagesCardItemPresenter> provider17 = DoubleCheck.provider(UserProfileModule_ProvideLfPackagesCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.R = provider17;
        this.S = DoubleCheck.provider(UserProfileModule_ProvideLfPackagesCardBlueprint$profile_releaseFactory.create(userProfileModule, provider17));
        Provider<ShopSettingsCardItemPresenter> provider18 = DoubleCheck.provider(UserProfileModule_ProvideShopSettingsCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.T = provider18;
        this.U = DoubleCheck.provider(UserProfileModule_ProvideShopSettingsCardBlueprint$profile_releaseFactory.create(userProfileModule, provider18));
        Provider<DeliverySettingsItemPresenter> provider19 = DoubleCheck.provider(UserProfileModule_ProvideDeliverySettingsItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.V = provider19;
        this.W = DoubleCheck.provider(UserProfileModule_ProvideDeliverySettingsCardBlueprint$profile_releaseFactory.create(userProfileModule, provider19));
        Provider<IncomeSettingsCardItemPresenter> provider20 = DoubleCheck.provider(UserProfileModule_ProvideIncomeSettingsItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.X = provider20;
        this.Y = DoubleCheck.provider(UserProfileModule_ProvideIncomeSettingsCardBlueprint$profile_releaseFactory.create(userProfileModule, provider20));
        Provider<HelpCenterCardItemPresenter> provider21 = DoubleCheck.provider(UserProfileModule_ProvideHelpCenterCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.Z = provider21;
        this.a0 = DoubleCheck.provider(UserProfileModule_ProvideHelpCenterCardBlueprint$profile_releaseFactory.create(userProfileModule, provider21));
        Provider<LogoutCardItemPresenter> provider22 = DoubleCheck.provider(UserProfileModule_ProvideLogoutCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.b0 = provider22;
        this.c0 = DoubleCheck.provider(UserProfileModule_ProvideLogoutCardBlueprint$profile_releaseFactory.create(userProfileModule, provider22));
        DelegateFactory delegateFactory = new DelegateFactory();
        this.d0 = delegateFactory;
        Provider<OnDeepLinkClickListener> provider23 = DoubleCheck.provider(UserProfileModule_ProvideDeepLinkClickListenerFactory.create(userProfileModule, delegateFactory));
        this.e0 = provider23;
        Provider<ExtensionsCardItemPresenter> provider24 = DoubleCheck.provider(UserProfileModule_ProvideExtensionsCardItemPresenter$profile_releaseFactory.create(userProfileModule, provider23));
        this.f0 = provider24;
        this.g0 = DoubleCheck.provider(UserProfileModule_ProvideExtensionCardBlueprint$profile_releaseFactory.create(userProfileModule, provider24));
        Provider<SubscribersCardItemPresenter> provider25 = DoubleCheck.provider(UserProfileModule_ProviderSubscribersCardItemPresenter$profile_releaseFactory.create(userProfileModule));
        this.h0 = provider25;
        this.i0 = DoubleCheck.provider(UserProfileModule_ProvideSubscribersCardBlueprint$profile_releaseFactory.create(userProfileModule, provider25));
        VerificationPlatformCardPresenterImpl_Factory create4 = VerificationPlatformCardPresenterImpl_Factory.create(this.v);
        this.j0 = create4;
        Provider<VerificationPlatformCardPresenter> provider26 = DoubleCheck.provider(create4);
        this.k0 = provider26;
        VerificationPlatformCardBlueprint_Factory create5 = VerificationPlatformCardBlueprint_Factory.create(provider26);
        this.l0 = create5;
        this.m0 = DoubleCheck.provider(create5);
        ActionItemPresenterImpl_Factory create6 = ActionItemPresenterImpl_Factory.create(this.v);
        this.n0 = create6;
        Provider<ActionItemPresenter> provider27 = DoubleCheck.provider(create6);
        this.o0 = provider27;
        ActionItemBlueprint_Factory create7 = ActionItemBlueprint_Factory.create(provider27);
        this.p0 = create7;
        this.q0 = DoubleCheck.provider(create7);
        ProfileSessionsItemPresenterImpl_Factory create8 = ProfileSessionsItemPresenterImpl_Factory.create(this.v);
        this.r0 = create8;
        Provider<ProfileSessionsItemPresenter> provider28 = DoubleCheck.provider(create8);
        this.s0 = provider28;
        ProfileSessionsBlueprint_Factory create9 = ProfileSessionsBlueprint_Factory.create(provider28);
        this.t0 = create9;
        this.u0 = DoubleCheck.provider(create9);
        Provider<PublishRelay<CardItem.TfaSettingsCardItem>> provider29 = DoubleCheck.provider(UserProfileModule_ProvidesTfaSettingsClickStreamFactory.create(userProfileModule));
        this.v0 = provider29;
        TfaSettingsItemPresenterImpl_Factory create10 = TfaSettingsItemPresenterImpl_Factory.create(provider29);
        this.w0 = create10;
        Provider<TfaSettingsItemPresenter> provider30 = DoubleCheck.provider(create10);
        this.x0 = provider30;
        TfaSettingsBlueprint_Factory create11 = TfaSettingsBlueprint_Factory.create(provider30);
        this.y0 = create11;
        this.z0 = DoubleCheck.provider(create11);
        SetFactory build = SetFactory.builder(24, 0).addProvider(this.o).addProvider(this.q).addProvider(this.s).addProvider(this.u).addProvider(this.y).addProvider(this.A).addProvider(this.C).addProvider(this.I).addProvider(this.K).addProvider(this.M).addProvider(this.O).addProvider(this.Q).addProvider(this.S).addProvider(this.U).addProvider(this.W).addProvider(this.Y).addProvider(this.a0).addProvider(this.c0).addProvider(this.g0).addProvider(this.i0).addProvider(this.m0).addProvider(this.q0).addProvider(this.u0).addProvider(this.z0).build();
        this.A0 = build;
        Provider<ItemBinder> provider31 = DoubleCheck.provider(UserProfileModule_ProvideItemBinder$profile_releaseFactory.create(userProfileModule, build));
        this.B0 = provider31;
        this.C0 = DoubleCheck.provider(UserProfileModule_ProvideAdapterPresenter$profile_releaseFactory.create(userProfileModule, provider31));
        this.D0 = DoubleCheck.provider(UserProfileModule_ProvideUserProfileResourceProvider$profile_releaseFactory.create(userProfileModule));
        this.E0 = new c(userProfileDependencies);
        this.F0 = new e(userProfileDependencies);
        h hVar = new h(userProfileDependencies);
        this.G0 = hVar;
        GoogleSocialManagerImpl_Factory create12 = GoogleSocialManagerImpl_Factory.create(hVar);
        this.H0 = create12;
        this.I0 = SingleCheck.provider(create12);
        OdnoklassnikiSocialManagerImpl_Factory create13 = OdnoklassnikiSocialManagerImpl_Factory.create(this.G0);
        this.K0 = create13;
        this.L0 = SingleCheck.provider(create13);
        VkontakteSocialManagerImpl_Factory create14 = VkontakteSocialManagerImpl_Factory.create(this.G0);
        this.M0 = create14;
        Provider<VkontakteSocialManager> provider32 = SingleCheck.provider(create14);
        this.N0 = provider32;
        this.O0 = DoubleCheck.provider(UserProfileModule_ProvideLogoutable$profile_releaseFactory.create(userProfileModule, this.I0, this.J0, this.L0, provider32));
        Factory create15 = InstanceFactory.create(activity);
        this.P0 = create15;
        Provider<DialogRouter> provider33 = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create15));
        this.Q0 = provider33;
        DialogPresenterImpl_Factory create16 = DialogPresenterImpl_Factory.create(this.P0, provider33);
        this.R0 = create16;
        this.S0 = SingleCheck.provider(create16);
        ErrorFormatterImpl_Factory create17 = ErrorFormatterImpl_Factory.create(this.d);
        this.T0 = create17;
        Provider<ErrorFormatter> provider34 = SingleCheck.provider(create17);
        this.U0 = provider34;
        ErrorHelperImpl_Factory create18 = ErrorHelperImpl_Factory.create(provider34);
        this.V0 = create18;
        this.W0 = SingleCheck.provider(create18);
        this.X0 = DoubleCheck.provider(UserProfileModule_ProvideRxTimer$profile_releaseFactory.create(userProfileModule, this.c));
        o oVar = new o(userProfileDependencies);
        this.Y0 = oVar;
        p pVar = new p(userProfileDependencies);
        this.Z0 = pVar;
        this.a1 = DoubleCheck.provider(UserProfileModule_ProvidesScreenDiInjectTracker$profile_releaseFactory.create(userProfileModule, oVar, pVar));
        this.b1 = DoubleCheck.provider(UserProfileModule_ProvidesScreenInitTrackerFactory.create(userProfileModule, this.Y0, this.Z0));
        Provider<ScreenFlowTrackerProvider> provider35 = DoubleCheck.provider(UserProfileModule_ProvidesScreenFlowTrackerProviderFactory.create(userProfileModule, this.Y0, this.Z0));
        this.c1 = provider35;
        UserProfileTrackerImpl_Factory create19 = UserProfileTrackerImpl_Factory.create(this.a1, this.b1, provider35);
        this.d1 = create19;
        this.e1 = DoubleCheck.provider(create19);
        r rVar = new r(userProfileDependencies);
        this.f1 = rVar;
        j jVar = new j(userProfileDependencies);
        this.g1 = jVar;
        m mVar = new m(userProfileDependencies);
        this.h1 = mVar;
        Provider<ProfileHeaderPresenter> provider36 = DoubleCheck.provider(UserProfileModule_ProvideProfileHeaderPresenterFactory.create(userProfileModule, rVar, this.D0, this.E, jVar, mVar));
        this.i1 = provider36;
        DelegateFactory.setDelegate(this.d0, DoubleCheck.provider(UserProfileModule_ProvidePresenterFactory.create(userProfileModule, this.k, this.m, this.c, this.C0, this.D0, this.E0, this.F0, this.O0, this.E, this.l, this.S0, this.W0, this.X0, this.v, this.v0, this.e1, provider36)));
        this.j1 = InstanceFactory.create(viewModelStoreOwner);
        g gVar = new g(userProfileDependencies);
        this.k1 = gVar;
        CartFabRepositoryImpl_Factory create20 = CartFabRepositoryImpl_Factory.create(gVar, this.h1);
        this.l1 = create20;
        this.m1 = SingleCheck.provider(create20);
        k kVar = new k(userProfileDependencies);
        this.n1 = kVar;
        CartFabPreferencesImpl_Factory create21 = CartFabPreferencesImpl_Factory.create(kVar);
        this.o1 = create21;
        Provider<CartFabPreferences> provider37 = SingleCheck.provider(create21);
        this.p1 = provider37;
        d dVar = new d(userProfileDependencies);
        this.q1 = dVar;
        Provider<Optional<SearchContextWrapper>> provider38 = v1;
        this.r1 = provider38;
        CartFabViewModelFactory_Factory create22 = CartFabViewModelFactory_Factory.create(this.l, this.m1, provider37, dVar, this.h1, this.E, provider38);
        this.s1 = create22;
        this.t1 = SingleCheck.provider(CartFabModule_ProvideCartFabViewModelFactory.create(this.j1, create22));
        this.u1 = SingleCheck.provider(CartFabQuantityVisibilityHandler_Factory.create());
    }

    public static UserProfileComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.profile.di.UserProfileComponent
    public void inject(UserProfileFragment userProfileFragment) {
        UserProfileFragment_MembersInjector.injectActivityIntentFactory(userProfileFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        UserProfileFragment_MembersInjector.injectImplicitIntentFactory(userProfileFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        UserProfileFragment_MembersInjector.injectDeepLinkIntentFactory(userProfileFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        UserProfileFragment_MembersInjector.injectPresenter(userProfileFragment, this.d0.get());
        UserProfileFragment_MembersInjector.injectInteractor(userProfileFragment, this.k.get());
        UserProfileFragment_MembersInjector.injectAdapterPresenter(userProfileFragment, this.C0.get());
        UserProfileFragment_MembersInjector.injectItemBinder(userProfileFragment, this.B0.get());
        UserProfileFragment_MembersInjector.injectFeatures(userProfileFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        UserProfileFragment_MembersInjector.injectAnalytics(userProfileFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        UserProfileFragment_MembersInjector.injectTracker(userProfileFragment, this.e1.get());
        UserProfileFragment_MembersInjector.injectCartFabViewModel(userProfileFragment, this.t1.get());
        UserProfileFragment_MembersInjector.injectCartQuantityHandler(userProfileFragment, this.u1.get());
        UserProfileFragment_MembersInjector.injectTabTestGroup(userProfileFragment, (UserAdvertsTabTestGroup) Preconditions.checkNotNullFromComponent(this.a.userAdvertsTabTestGroup()));
    }
}

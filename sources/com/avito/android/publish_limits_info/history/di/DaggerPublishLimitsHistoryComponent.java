package com.avito.android.publish_limits_info.history.di;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl_Factory;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.publish_limits_info.analytics.PublishLimitsAnalyticsModule_ProvideAnalyticsFactory;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryActivity;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryActivity_MembersInjector;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryInteractorImpl;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryInteractorImpl_Factory;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryViewModel;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryViewModelFactory;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryViewModelFactory_Factory;
import com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryComponent;
import com.avito.android.publish_limits_info.history.tab.ExtraInfoClickListener;
import com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryProvider;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerPublishLimitsHistoryComponent implements PublishLimitsHistoryComponent {
    public final PublishLimitsHistoryDependencies a;
    public final ExtraInfoClickListener b;
    public Provider<FragmentActivity> c;
    public Provider<ItemId> d;
    public Provider<PublishLimitsApi> e;
    public Provider<SchedulersFactory3> f;
    public Provider<TypedErrorThrowableConverter> g;
    public Provider<PublishLimitsHistoryInteractorImpl> h;
    public Provider<RandomKeyProvider> i;
    public Provider<PublishLimitsHistoryViewModelFactory> j;
    public Provider<ViewModelProvider.Factory> k;
    public Provider<PublishLimitsHistoryViewModel> l;
    public Provider<PublishAdvertsHistoryProvider> m;
    public Provider<AttributedTextFormatter> n = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
    public Provider<Analytics> o;
    public Provider<ProgressDialogRouter> p;
    public Provider<LoadingProgressOverlayImpl> q;
    public Provider<LoadingProgressOverlay> r;

    public static final class b implements PublishLimitsHistoryComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryComponent.Factory
        public PublishLimitsHistoryComponent create(FragmentActivity fragmentActivity, ItemId itemId, ExtraInfoClickListener extraInfoClickListener, PublishLimitsHistoryDependencies publishLimitsHistoryDependencies) {
            Preconditions.checkNotNull(fragmentActivity);
            Preconditions.checkNotNull(itemId);
            Preconditions.checkNotNull(extraInfoClickListener);
            Preconditions.checkNotNull(publishLimitsHistoryDependencies);
            return new DaggerPublishLimitsHistoryComponent(publishLimitsHistoryDependencies, fragmentActivity, itemId, extraInfoClickListener, null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final PublishLimitsHistoryDependencies a;

        public c(PublishLimitsHistoryDependencies publishLimitsHistoryDependencies) {
            this.a = publishLimitsHistoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<PublishLimitsApi> {
        public final PublishLimitsHistoryDependencies a;

        public d(PublishLimitsHistoryDependencies publishLimitsHistoryDependencies) {
            this.a = publishLimitsHistoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishLimitsApi get() {
            return (PublishLimitsApi) Preconditions.checkNotNullFromComponent(this.a.publishLimitsApi());
        }
    }

    public static class e implements Provider<RandomKeyProvider> {
        public final PublishLimitsHistoryDependencies a;

        public e(PublishLimitsHistoryDependencies publishLimitsHistoryDependencies) {
            this.a = publishLimitsHistoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class f implements Provider<SchedulersFactory3> {
        public final PublishLimitsHistoryDependencies a;

        public f(PublishLimitsHistoryDependencies publishLimitsHistoryDependencies) {
            this.a = publishLimitsHistoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class g implements Provider<TypedErrorThrowableConverter> {
        public final PublishLimitsHistoryDependencies a;

        public g(PublishLimitsHistoryDependencies publishLimitsHistoryDependencies) {
            this.a = publishLimitsHistoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerPublishLimitsHistoryComponent(PublishLimitsHistoryDependencies publishLimitsHistoryDependencies, FragmentActivity fragmentActivity, ItemId itemId, ExtraInfoClickListener extraInfoClickListener, a aVar) {
        this.a = publishLimitsHistoryDependencies;
        this.b = extraInfoClickListener;
        this.c = InstanceFactory.create(fragmentActivity);
        this.d = InstanceFactory.create(itemId);
        d dVar = new d(publishLimitsHistoryDependencies);
        this.e = dVar;
        f fVar = new f(publishLimitsHistoryDependencies);
        this.f = fVar;
        g gVar = new g(publishLimitsHistoryDependencies);
        this.g = gVar;
        PublishLimitsHistoryInteractorImpl_Factory create = PublishLimitsHistoryInteractorImpl_Factory.create(dVar, fVar, gVar);
        this.h = create;
        e eVar = new e(publishLimitsHistoryDependencies);
        this.i = eVar;
        PublishLimitsHistoryViewModelFactory_Factory create2 = PublishLimitsHistoryViewModelFactory_Factory.create(this.d, create, this.f, eVar);
        this.j = create2;
        Provider<ViewModelProvider.Factory> provider = DoubleCheck.provider(create2);
        this.k = provider;
        Provider<PublishLimitsHistoryViewModel> provider2 = DoubleCheck.provider(PublishLimitsHistoryModule_ProvideViewModelFactory.create(this.c, provider));
        this.l = provider2;
        this.m = DoubleCheck.provider(PublishLimitsHistoryModule_ProvideHistoryProviderFactory.create(provider2));
        this.o = new c(publishLimitsHistoryDependencies);
        Provider<ProgressDialogRouter> provider3 = DoubleCheck.provider(PublishLimitsHistoryModule_ProvideDialogRouterFactory.create(this.c));
        this.p = provider3;
        LoadingProgressOverlayImpl_Factory create3 = LoadingProgressOverlayImpl_Factory.create(this.o, provider3);
        this.q = create3;
        this.r = DoubleCheck.provider(create3);
    }

    public static PublishLimitsHistoryComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.publish_limits_info.history.tab.di.PublishAdvertsHistoryDependencies
    public AttributedTextFormatter attributedTextFormatter() {
        return this.n.get();
    }

    @Override // com.avito.android.publish_limits_info.history.tab.di.PublishAdvertsHistoryDependencies
    public DeepLinkIntentFactory deeplinkIntentFactory() {
        return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory());
    }

    @Override // com.avito.android.publish_limits_info.history.tab.di.PublishAdvertsHistoryDependencies
    public ExtraInfoClickListener extraInfoClickListener() {
        return this.b;
    }

    @Override // com.avito.android.publish_limits_info.history.tab.di.PublishAdvertsHistoryDependencies
    public PublishAdvertsHistoryProvider historyProvider() {
        return this.m.get();
    }

    @Override // com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryComponent
    public void inject(PublishLimitsHistoryActivity publishLimitsHistoryActivity) {
        PublishLimitsHistoryActivity_MembersInjector.injectHistoryViewModel(publishLimitsHistoryActivity, this.l.get());
        PublishLimitsHistoryActivity_MembersInjector.injectLoadingProgress(publishLimitsHistoryActivity, this.r.get());
        PublishLimitsHistoryActivity_MembersInjector.injectLimitsEventTracker(publishLimitsHistoryActivity, PublishLimitsAnalyticsModule_ProvideAnalyticsFactory.provideAnalytics((Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics())));
    }
}

package com.avito.android.feedback_adverts.di;

import arrow.core.Option;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.feedback_adverts.FeedbackAdvertsActivity;
import com.avito.android.feedback_adverts.FeedbackAdvertsActivity_MembersInjector;
import com.avito.android.feedback_adverts.FeedbackAdvertsInteractor;
import com.avito.android.feedback_adverts.FeedbackAdvertsInteractorImpl;
import com.avito.android.feedback_adverts.FeedbackAdvertsInteractorImpl_Factory;
import com.avito.android.feedback_adverts.FeedbackAdvertsItemBluePrint;
import com.avito.android.feedback_adverts.FeedbackAdvertsItemBluePrint_Factory;
import com.avito.android.feedback_adverts.FeedbackAdvertsItemPresenter;
import com.avito.android.feedback_adverts.FeedbackAdvertsItemPresenterImpl;
import com.avito.android.feedback_adverts.FeedbackAdvertsItemPresenterImpl_Factory;
import com.avito.android.feedback_adverts.FeedbackAdvertsPresenter;
import com.avito.android.feedback_adverts.FeedbackAdvertsPresenterImpl;
import com.avito.android.feedback_adverts.FeedbackAdvertsPresenterImpl_Factory;
import com.avito.android.feedback_adverts.FeedbackAdvertsPresenterState;
import com.avito.android.feedback_adverts.di.FeedbackAdvertsComponent;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerFeedbackAdvertsComponent implements FeedbackAdvertsComponent {
    public final FeedbackAdvertsDependencies a;
    public Provider<MessengerClient<AvitoMessengerApi>> b;
    public Provider<FeedbackAdvertsInteractorImpl> c;
    public Provider<FeedbackAdvertsInteractor> d;
    public Provider<SchedulersFactory> e;
    public Provider<FeedbackAdvertsPresenter> f = new DelegateFactory();
    public Provider<String> g;
    public Provider<FeedbackAdvertsItemPresenterImpl> h;
    public Provider<FeedbackAdvertsItemPresenter> i;
    public Provider<FeedbackAdvertsItemBluePrint> j;
    public Provider<ItemBinder> k;
    public Provider<AdapterPresenter> l;
    public Provider<Option<String>> m;
    public Provider<String> n;
    public Provider<FeedbackAdvertsPresenterState> o;
    public Provider<FeedbackAdvertsPresenterImpl> p;

    public static final class b implements FeedbackAdvertsComponent.Builder {
        public Option<String> a;
        public String b;
        public String c;
        public FeedbackAdvertsPresenterState d;
        public FeedbackAdvertsDependencies e;

        public b(a aVar) {
        }

        @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsComponent.Builder
        public FeedbackAdvertsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Option.class);
            Preconditions.checkBuilderRequirement(this.e, FeedbackAdvertsDependencies.class);
            return new DaggerFeedbackAdvertsComponent(this.e, this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsComponent.Builder
        public FeedbackAdvertsComponent.Builder feedbackAdvertsDependencies(FeedbackAdvertsDependencies feedbackAdvertsDependencies) {
            this.e = (FeedbackAdvertsDependencies) Preconditions.checkNotNull(feedbackAdvertsDependencies);
            return this;
        }

        @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsComponent.Builder
        public FeedbackAdvertsComponent.Builder itemId(Option option) {
            this.a = (Option) Preconditions.checkNotNull(option);
            return this;
        }

        @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsComponent.Builder
        public FeedbackAdvertsComponent.Builder presenterState(FeedbackAdvertsPresenterState feedbackAdvertsPresenterState) {
            this.d = feedbackAdvertsPresenterState;
            return this;
        }

        @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsComponent.Builder
        public FeedbackAdvertsComponent.Builder selectedItemId(String str) {
            this.b = str;
            return this;
        }

        @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsComponent.Builder
        public FeedbackAdvertsComponent.Builder title(String str) {
            this.c = str;
            return this;
        }
    }

    public static class c implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final FeedbackAdvertsDependencies a;

        public c(FeedbackAdvertsDependencies feedbackAdvertsDependencies) {
            this.a = feedbackAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final FeedbackAdvertsDependencies a;

        public d(FeedbackAdvertsDependencies feedbackAdvertsDependencies) {
            this.a = feedbackAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerFeedbackAdvertsComponent(FeedbackAdvertsDependencies feedbackAdvertsDependencies, Option option, String str, String str2, FeedbackAdvertsPresenterState feedbackAdvertsPresenterState, a aVar) {
        this.a = feedbackAdvertsDependencies;
        c cVar = new c(feedbackAdvertsDependencies);
        this.b = cVar;
        FeedbackAdvertsInteractorImpl_Factory create = FeedbackAdvertsInteractorImpl_Factory.create(cVar);
        this.c = create;
        this.d = DoubleCheck.provider(create);
        this.e = new d(feedbackAdvertsDependencies);
        Factory createNullable = InstanceFactory.createNullable(str);
        this.g = createNullable;
        FeedbackAdvertsItemPresenterImpl_Factory create2 = FeedbackAdvertsItemPresenterImpl_Factory.create(this.f, createNullable);
        this.h = create2;
        Provider<FeedbackAdvertsItemPresenter> provider = DoubleCheck.provider(create2);
        this.i = provider;
        FeedbackAdvertsItemBluePrint_Factory create3 = FeedbackAdvertsItemBluePrint_Factory.create(provider);
        this.j = create3;
        Provider<ItemBinder> provider2 = DoubleCheck.provider(FeedbackAdvertsModule_ProvideVHFactory$feedback_adverts_releaseFactory.create(create3));
        this.k = provider2;
        this.l = DoubleCheck.provider(FeedbackAdvertsModule_ProvideAdapterPresenter$feedback_adverts_releaseFactory.create(provider2));
        this.m = InstanceFactory.create(option);
        this.n = InstanceFactory.createNullable(str2);
        Factory createNullable2 = InstanceFactory.createNullable(feedbackAdvertsPresenterState);
        this.o = createNullable2;
        FeedbackAdvertsPresenterImpl_Factory create4 = FeedbackAdvertsPresenterImpl_Factory.create(this.d, this.e, this.l, this.m, this.n, createNullable2);
        this.p = create4;
        DelegateFactory.setDelegate(this.f, DoubleCheck.provider(create4));
    }

    public static FeedbackAdvertsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsComponent
    public void inject(FeedbackAdvertsActivity feedbackAdvertsActivity) {
        FeedbackAdvertsActivity_MembersInjector.injectPresenter(feedbackAdvertsActivity, this.f.get());
        FeedbackAdvertsActivity_MembersInjector.injectAdapterPresenter(feedbackAdvertsActivity, this.l.get());
        FeedbackAdvertsActivity_MembersInjector.injectItemBinder(feedbackAdvertsActivity, this.k.get());
        FeedbackAdvertsActivity_MembersInjector.injectAnalytics(feedbackAdvertsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        FeedbackAdvertsActivity_MembersInjector.injectFeatures(feedbackAdvertsActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        FeedbackAdvertsActivity_MembersInjector.injectActivityIntentFactory(feedbackAdvertsActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}

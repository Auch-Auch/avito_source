package com.avito.android.abuse.details.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.abuse.details.AbuseDetailsActivity;
import com.avito.android.abuse.details.AbuseDetailsActivity_MembersInjector;
import com.avito.android.abuse.details.AbuseDetailsInteractorImpl;
import com.avito.android.abuse.details.AbuseDetailsPresenterImpl;
import com.avito.android.abuse.details.AbuseDetailsResourceProviderImpl;
import com.avito.android.abuse.details.adapter.AbuseField;
import com.avito.android.abuse.details.adapter.CommentItemBlueprint;
import com.avito.android.abuse.details.adapter.CommentItemBlueprint_Factory;
import com.avito.android.abuse.details.adapter.CommentItemPresenterImpl;
import com.avito.android.abuse.details.adapter.CommentItemPresenterImpl_Factory;
import com.avito.android.abuse.details.adapter.EmotionItemBlueprint;
import com.avito.android.abuse.details.adapter.EmotionItemBlueprint_Factory;
import com.avito.android.abuse.details.adapter.EmotionItemPresenterImpl;
import com.avito.android.abuse.details.adapter.EmotionItemPresenterImpl_Factory;
import com.avito.android.abuse.details.adapter.ErrorLabelItemBlueprint;
import com.avito.android.abuse.details.adapter.ErrorLabelItemBlueprint_Factory;
import com.avito.android.abuse.details.adapter.ErrorLabelItemPresenterImpl_Factory;
import com.avito.android.abuse.details.adapter.PrimaryButtonItemBlueprint;
import com.avito.android.abuse.details.adapter.PrimaryButtonItemBlueprint_Factory;
import com.avito.android.abuse.details.adapter.PrimaryButtonItemPresenterImpl;
import com.avito.android.abuse.details.adapter.PrimaryButtonItemPresenterImpl_Factory;
import com.avito.android.abuse.details.adapter.SecondaryButtonItemBlueprint;
import com.avito.android.abuse.details.adapter.SecondaryButtonItemBlueprint_Factory;
import com.avito.android.abuse.details.adapter.SecondaryButtonItemPresenterImpl;
import com.avito.android.abuse.details.adapter.SecondaryButtonItemPresenterImpl_Factory;
import com.avito.android.abuse.details.adapter.SendingSuccessItemBlueprint;
import com.avito.android.abuse.details.adapter.SendingSuccessItemBlueprint_Factory;
import com.avito.android.abuse.details.adapter.SendingSuccessItemPresenterImpl_Factory;
import com.avito.android.abuse.details.di.AbuseDetailsComponent;
import com.avito.android.abuse.details.remote.AbuseApi;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.remote.model.Action;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerAbuseDetailsComponent implements AbuseDetailsComponent {
    public Provider<AdapterPresenter> A;
    public Provider<Resources> B;
    public Provider<ErrorFormatterImpl> C;
    public Provider<ErrorFormatter> D;
    public final Integer a;
    public final String b;
    public final String c;
    public final List<Action> d;
    public final AbuseDetailsDependencies e;
    public final Resources f;
    public final PublishRelay<AbuseField> g;
    public final PublishRelay<AbuseField> h;
    public final PublishRelay<DeepLink> i;
    public final Kundle j;
    public Provider<Set<ItemBlueprint<?, ?>>> k = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PublishRelay<AbuseField>> l;
    public Provider<CommentItemPresenterImpl> m;
    public Provider<CommentItemBlueprint> n;
    public Provider<PublishRelay<AbuseField>> o;
    public Provider<EmotionItemPresenterImpl> p;
    public Provider<EmotionItemBlueprint> q;
    public Provider<PublishRelay<DeepLink>> r;
    public Provider<PrimaryButtonItemPresenterImpl> s;
    public Provider<PrimaryButtonItemBlueprint> t;
    public Provider<SecondaryButtonItemPresenterImpl> u;
    public Provider<SecondaryButtonItemBlueprint> v;
    public Provider<SendingSuccessItemBlueprint> w;
    public Provider<ErrorLabelItemBlueprint> x;
    public Provider<Set<ItemBlueprint<?, ?>>> y;
    public Provider<ItemBinder> z;

    public static final class b implements AbuseDetailsComponent.Builder {
        public AbuseDetailsDependencies a;
        public Resources b;
        public Integer c;
        public String d;
        public String e;
        public List<Action> f;
        public Kundle g;
        public PublishRelay<AbuseField> h;
        public PublishRelay<AbuseField> i;
        public PublishRelay<DeepLink> j;

        public b(a aVar) {
        }

        @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent.Builder
        public AbuseDetailsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AbuseDetailsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Integer.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.h, PublishRelay.class);
            Preconditions.checkBuilderRequirement(this.i, PublishRelay.class);
            Preconditions.checkBuilderRequirement(this.j, PublishRelay.class);
            return new DaggerAbuseDetailsComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
        }

        @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent.Builder
        public AbuseDetailsComponent.Builder dependentOn(AbuseDetailsDependencies abuseDetailsDependencies) {
            this.a = (AbuseDetailsDependencies) Preconditions.checkNotNull(abuseDetailsDependencies);
            return this;
        }

        @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent.Builder
        public AbuseDetailsComponent.Builder with(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent.Builder
        public AbuseDetailsComponent.Builder withChanged(PublishRelay publishRelay) {
            this.h = (PublishRelay) Preconditions.checkNotNull(publishRelay);
            return this;
        }

        @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent.Builder
        public AbuseDetailsComponent.Builder withClicked(PublishRelay publishRelay) {
            this.j = (PublishRelay) Preconditions.checkNotNull(publishRelay);
            return this;
        }

        @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent.Builder
        public AbuseDetailsComponent.Builder withFocused(PublishRelay publishRelay) {
            this.i = (PublishRelay) Preconditions.checkNotNull(publishRelay);
            return this;
        }

        @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent.Builder
        public AbuseDetailsComponent.Builder withItemId(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent.Builder
        public AbuseDetailsComponent.Builder withSrc(String str) {
            this.e = str;
            return this;
        }

        @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent.Builder
        public AbuseDetailsComponent.Builder with(int i2) {
            this.c = (Integer) Preconditions.checkNotNull(Integer.valueOf(i2));
            return this;
        }

        @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent.Builder
        public AbuseDetailsComponent.Builder with(List list) {
            this.f = list;
            return this;
        }

        @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent.Builder
        public AbuseDetailsComponent.Builder with(Kundle kundle) {
            this.g = kundle;
            return this;
        }
    }

    public DaggerAbuseDetailsComponent(AbuseDetailsDependencies abuseDetailsDependencies, Resources resources, Integer num, String str, String str2, List list, Kundle kundle, PublishRelay publishRelay, PublishRelay publishRelay2, PublishRelay publishRelay3, a aVar) {
        this.a = num;
        this.b = str;
        this.c = str2;
        this.d = list;
        this.e = abuseDetailsDependencies;
        this.f = resources;
        this.g = publishRelay;
        this.h = publishRelay2;
        this.i = publishRelay3;
        this.j = kundle;
        Factory create = InstanceFactory.create(publishRelay);
        this.l = create;
        CommentItemPresenterImpl_Factory create2 = CommentItemPresenterImpl_Factory.create(create);
        this.m = create2;
        this.n = CommentItemBlueprint_Factory.create(create2);
        Factory create3 = InstanceFactory.create(publishRelay2);
        this.o = create3;
        EmotionItemPresenterImpl_Factory create4 = EmotionItemPresenterImpl_Factory.create(create3);
        this.p = create4;
        this.q = EmotionItemBlueprint_Factory.create(create4);
        Factory create5 = InstanceFactory.create(publishRelay3);
        this.r = create5;
        PrimaryButtonItemPresenterImpl_Factory create6 = PrimaryButtonItemPresenterImpl_Factory.create(create5);
        this.s = create6;
        this.t = PrimaryButtonItemBlueprint_Factory.create(create6);
        SecondaryButtonItemPresenterImpl_Factory create7 = SecondaryButtonItemPresenterImpl_Factory.create(this.r);
        this.u = create7;
        this.v = SecondaryButtonItemBlueprint_Factory.create(create7);
        this.w = SendingSuccessItemBlueprint_Factory.create(SendingSuccessItemPresenterImpl_Factory.create());
        this.x = ErrorLabelItemBlueprint_Factory.create(ErrorLabelItemPresenterImpl_Factory.create());
        SetFactory build = SetFactory.builder(6, 1).addCollectionProvider(this.k).addProvider(this.n).addProvider(this.q).addProvider(this.t).addProvider(this.v).addProvider(this.w).addProvider(this.x).build();
        this.y = build;
        Provider<ItemBinder> provider = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.z = provider;
        this.A = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider));
        Factory create8 = InstanceFactory.create(resources);
        this.B = create8;
        ErrorFormatterImpl_Factory create9 = ErrorFormatterImpl_Factory.create(create8);
        this.C = create9;
        this.D = DoubleCheck.provider(create9);
    }

    public static AbuseDetailsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.abuse.details.di.AbuseDetailsComponent
    public void inject(AbuseDetailsActivity abuseDetailsActivity) {
        AbuseDetailsActivity_MembersInjector.injectPresenter(abuseDetailsActivity, new AbuseDetailsPresenterImpl(new AbuseDetailsInteractorImpl(this.a.intValue(), this.b, this.c, this.d, (AbuseApi) Preconditions.checkNotNullFromComponent(this.e.abuseApi()), (AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.e.accountStorageInteractor()), new AbuseDetailsResourceProviderImpl(this.f), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.e.schedulersFactory3())), this.A.get(), this.g, this.h, this.i, this.D.get(), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.e.schedulersFactory3()), this.j));
        AbuseDetailsActivity_MembersInjector.injectAdapterPresenter(abuseDetailsActivity, this.A.get());
        AbuseDetailsActivity_MembersInjector.injectItemBinder(abuseDetailsActivity, this.z.get());
        AbuseDetailsActivity_MembersInjector.injectFeatures(abuseDetailsActivity, (Features) Preconditions.checkNotNullFromComponent(this.e.features()));
        AbuseDetailsActivity_MembersInjector.injectAnalytics(abuseDetailsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.e.analytics()));
        AbuseDetailsActivity_MembersInjector.injectIntentFactory(abuseDetailsActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.e.activityIntentFactory()));
    }
}

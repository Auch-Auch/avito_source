package com.avito.android.advert.consultation_form.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.advert.consultation_form.ConsultationFormActivity;
import com.avito.android.advert.consultation_form.ConsultationFormActivity_MembersInjector;
import com.avito.android.advert.consultation_form.ConsultationFormViewModelFactory;
import com.avito.android.advert.consultation_form.data.ConsultationFormRepository;
import com.avito.android.advert.consultation_form.data.ConsultationFormRepositoryImpl;
import com.avito.android.advert.consultation_form.data.ConsultationFormRepositoryImpl_Factory;
import com.avito.android.advert.consultation_form.di.ConsultationFormComponent;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerConsultationFormComponent implements ConsultationFormComponent {
    public final String a;
    public final String b;
    public final ConsultationFormDependencies c;
    public final ConsultationFormData d;
    public Provider<AdvertDetailsApi> e;
    public Provider<ConsultationFormData> f;
    public Provider<ShortTermRentApi> g;
    public Provider<ConsultationFormRepositoryImpl> h;
    public Provider<ConsultationFormRepository> i;

    public static final class b implements ConsultationFormComponent.Builder {
        public ConsultationFormDependencies a;
        public String b;
        public String c;
        public ConsultationFormData d;

        public b(a aVar) {
        }

        @Override // com.avito.android.advert.consultation_form.di.ConsultationFormComponent.Builder
        public ConsultationFormComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ConsultationFormDependencies.class);
            return new DaggerConsultationFormComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.advert.consultation_form.di.ConsultationFormComponent.Builder
        public ConsultationFormComponent.Builder consultationFormDependencies(ConsultationFormDependencies consultationFormDependencies) {
            this.a = (ConsultationFormDependencies) Preconditions.checkNotNull(consultationFormDependencies);
            return this;
        }

        @Override // com.avito.android.advert.consultation_form.di.ConsultationFormComponent.Builder
        public ConsultationFormComponent.Builder withAdvertId(String str) {
            this.b = str;
            return this;
        }

        @Override // com.avito.android.advert.consultation_form.di.ConsultationFormComponent.Builder
        public ConsultationFormComponent.Builder withDevelopmentId(String str) {
            this.c = str;
            return this;
        }

        @Override // com.avito.android.advert.consultation_form.di.ConsultationFormComponent.Builder
        public ConsultationFormComponent.Builder withForm(ConsultationFormData consultationFormData) {
            this.d = consultationFormData;
            return this;
        }
    }

    public static class c implements Provider<AdvertDetailsApi> {
        public final ConsultationFormDependencies a;

        public c(ConsultationFormDependencies consultationFormDependencies) {
            this.a = consultationFormDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AdvertDetailsApi get() {
            return (AdvertDetailsApi) Preconditions.checkNotNullFromComponent(this.a.advertDetailsApi());
        }
    }

    public static class d implements Provider<ShortTermRentApi> {
        public final ConsultationFormDependencies a;

        public d(ConsultationFormDependencies consultationFormDependencies) {
            this.a = consultationFormDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShortTermRentApi get() {
            return (ShortTermRentApi) Preconditions.checkNotNullFromComponent(this.a.shortTermRentApi());
        }
    }

    public DaggerConsultationFormComponent(ConsultationFormDependencies consultationFormDependencies, String str, String str2, ConsultationFormData consultationFormData, a aVar) {
        this.a = str;
        this.b = str2;
        this.c = consultationFormDependencies;
        this.d = consultationFormData;
        this.e = new c(consultationFormDependencies);
        Factory createNullable = InstanceFactory.createNullable(consultationFormData);
        this.f = createNullable;
        d dVar = new d(consultationFormDependencies);
        this.g = dVar;
        ConsultationFormRepositoryImpl_Factory create = ConsultationFormRepositoryImpl_Factory.create(this.e, createNullable, dVar);
        this.h = create;
        this.i = DoubleCheck.provider(create);
    }

    public static ConsultationFormComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.advert.consultation_form.di.ConsultationFormComponent
    public void inject(ConsultationFormActivity consultationFormActivity) {
        ConsultationFormActivity_MembersInjector.injectViewModelFactory(consultationFormActivity, new ConsultationFormViewModelFactory(this.a, this.b, this.i.get(), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.c.schedulersFactory3()), (Analytics) Preconditions.checkNotNullFromComponent(this.c.analytics()), this.d));
        ConsultationFormActivity_MembersInjector.injectIntentFactory(consultationFormActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.c.activityIntentFactory()));
        ConsultationFormActivity_MembersInjector.injectDeepLinkIntentFactory(consultationFormActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.c.getDeepLinkIntentFactory()));
    }
}

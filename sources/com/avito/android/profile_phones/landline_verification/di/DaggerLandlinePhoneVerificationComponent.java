package com.avito.android.profile_phones.landline_verification.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment_MembersInjector;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationInteractor;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationVMFactory;
import com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationComponent;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerLandlinePhoneVerificationComponent implements LandlinePhoneVerificationComponent {
    public final LandlinePhoneVerificationDependencies a;
    public Provider<AttributedTextFormatter> b = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());

    public static final class b implements LandlinePhoneVerificationComponent.Builder {
        public LandlinePhoneVerificationDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationComponent.Builder
        public LandlinePhoneVerificationComponent build() {
            Preconditions.checkBuilderRequirement(this.a, LandlinePhoneVerificationDependencies.class);
            return new DaggerLandlinePhoneVerificationComponent(this.a, null);
        }

        @Override // com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationComponent.Builder
        public LandlinePhoneVerificationComponent.Builder landlinePhoneVerificationDependencies(LandlinePhoneVerificationDependencies landlinePhoneVerificationDependencies) {
            this.a = (LandlinePhoneVerificationDependencies) Preconditions.checkNotNull(landlinePhoneVerificationDependencies);
            return this;
        }

        @Override // com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationComponent.Builder
        @Deprecated
        public LandlinePhoneVerificationComponent.Builder landlinePhoneVerificationModule(LandlinePhoneVerificationModule landlinePhoneVerificationModule) {
            Preconditions.checkNotNull(landlinePhoneVerificationModule);
            return this;
        }
    }

    public DaggerLandlinePhoneVerificationComponent(LandlinePhoneVerificationDependencies landlinePhoneVerificationDependencies, a aVar) {
        this.a = landlinePhoneVerificationDependencies;
    }

    public static LandlinePhoneVerificationComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationComponent
    public void inject(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment) {
        LandlinePhoneVerificationFragment_MembersInjector.injectViewModelFactory(landlinePhoneVerificationFragment, new LandlinePhoneVerificationVMFactory(new LandlinePhoneVerificationInteractor((ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.throwableConverter()))));
        LandlinePhoneVerificationFragment_MembersInjector.injectActivityIntentFactory(landlinePhoneVerificationFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.intentFactory()));
        LandlinePhoneVerificationFragment_MembersInjector.injectAttributedTextFormatter(landlinePhoneVerificationFragment, this.b.get());
        LandlinePhoneVerificationFragment_MembersInjector.injectAnalytics(landlinePhoneVerificationFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}

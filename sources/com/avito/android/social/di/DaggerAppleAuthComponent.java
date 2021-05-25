package com.avito.android.social.di;

import com.avito.android.Features;
import com.avito.android.social.apple.AppleAuthFragment;
import com.avito.android.social.apple.AppleAuthFragment_MembersInjector;
import com.avito.android.social.apple.AppleAuthPresenterImpl;
import com.avito.android.social.apple.AppleAuthWebViewClientImpl;
import com.avito.android.social.di.AppleAuthComponent;
import dagger.internal.Preconditions;
public final class DaggerAppleAuthComponent implements AppleAuthComponent {
    public final AppleAuthDependencies a;

    public static final class b implements AppleAuthComponent.Builder {
        public AppleAuthDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.social.di.AppleAuthComponent.Builder
        public AppleAuthComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AppleAuthDependencies.class);
            return new DaggerAppleAuthComponent(this.a, null);
        }

        @Override // com.avito.android.social.di.AppleAuthComponent.Builder
        public AppleAuthComponent.Builder dependentOn(AppleAuthDependencies appleAuthDependencies) {
            this.a = (AppleAuthDependencies) Preconditions.checkNotNull(appleAuthDependencies);
            return this;
        }
    }

    public DaggerAppleAuthComponent(AppleAuthDependencies appleAuthDependencies, a aVar) {
        this.a = appleAuthDependencies;
    }

    public static AppleAuthComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.social.di.AppleAuthComponent
    public void inject(AppleAuthFragment appleAuthFragment) {
        AppleAuthFragment_MembersInjector.injectPresenter(appleAuthFragment, new AppleAuthPresenterImpl((Features) Preconditions.checkNotNullFromComponent(this.a.features())));
        AppleAuthFragment_MembersInjector.injectWebViewClient(appleAuthFragment, new AppleAuthWebViewClientImpl());
    }
}

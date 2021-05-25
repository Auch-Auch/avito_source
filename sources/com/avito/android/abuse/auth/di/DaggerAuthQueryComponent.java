package com.avito.android.abuse.auth.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.abuse.auth.AuthQueryActivity;
import com.avito.android.abuse.auth.AuthQueryActivity_MembersInjector;
import com.avito.android.abuse.auth.AuthQueryPresenterImpl;
import com.avito.android.abuse.auth.di.AuthQueryComponent;
import dagger.internal.Preconditions;
public final class DaggerAuthQueryComponent implements AuthQueryComponent {
    public final AuthQueryDependencies a;

    public static final class b implements AuthQueryComponent.Builder {
        public AuthQueryDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.abuse.auth.di.AuthQueryComponent.Builder
        public AuthQueryComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AuthQueryDependencies.class);
            return new DaggerAuthQueryComponent(this.a, null);
        }

        @Override // com.avito.android.abuse.auth.di.AuthQueryComponent.Builder
        public AuthQueryComponent.Builder dependentOn(AuthQueryDependencies authQueryDependencies) {
            this.a = (AuthQueryDependencies) Preconditions.checkNotNull(authQueryDependencies);
            return this;
        }
    }

    public DaggerAuthQueryComponent(AuthQueryDependencies authQueryDependencies, a aVar) {
        this.a = authQueryDependencies;
    }

    public static AuthQueryComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.abuse.auth.di.AuthQueryComponent
    public void inject(AuthQueryActivity authQueryActivity) {
        AuthQueryActivity_MembersInjector.injectPresenter(authQueryActivity, new AuthQueryPresenterImpl());
        AuthQueryActivity_MembersInjector.injectIntentFactory(authQueryActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}

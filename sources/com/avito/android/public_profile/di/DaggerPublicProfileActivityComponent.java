package com.avito.android.public_profile.di;

import com.avito.android.public_profile.PublicProfileActivity;
import com.avito.android.public_profile.di.PublicProfileActivityComponent;
import dagger.internal.Preconditions;
public final class DaggerPublicProfileActivityComponent implements PublicProfileActivityComponent {

    public static final class b implements PublicProfileActivityComponent.Builder {
        public PublicProfileActivityDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.public_profile.di.PublicProfileActivityComponent.Builder
        public PublicProfileActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublicProfileActivityDependencies.class);
            return new DaggerPublicProfileActivityComponent(this.a);
        }

        @Override // com.avito.android.public_profile.di.PublicProfileActivityComponent.Builder
        public PublicProfileActivityComponent.Builder publicProfileActivityDependencies(PublicProfileActivityDependencies publicProfileActivityDependencies) {
            this.a = (PublicProfileActivityDependencies) Preconditions.checkNotNull(publicProfileActivityDependencies);
            return this;
        }
    }

    public DaggerPublicProfileActivityComponent() {
    }

    public static PublicProfileActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.public_profile.di.PublicProfileActivityComponent
    public void inject(PublicProfileActivity publicProfileActivity) {
    }

    public DaggerPublicProfileActivityComponent(PublicProfileActivityDependencies publicProfileActivityDependencies) {
    }
}

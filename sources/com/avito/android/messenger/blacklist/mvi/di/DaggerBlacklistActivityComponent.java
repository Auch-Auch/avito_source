package com.avito.android.messenger.blacklist.mvi.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.messenger.blacklist.mvi.BlacklistActivity;
import com.avito.android.messenger.blacklist.mvi.BlacklistActivity_MembersInjector;
import com.avito.android.messenger.blacklist.mvi.di.BlacklistActivityComponent;
import dagger.internal.Preconditions;
public final class DaggerBlacklistActivityComponent implements BlacklistActivityComponent {
    public final BlacklistActivityComponentDependencies a;

    public static final class b implements BlacklistActivityComponent.Builder {
        public BlacklistActivityComponentDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.blacklist.mvi.di.BlacklistActivityComponent.Builder
        public BlacklistActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, BlacklistActivityComponentDependencies.class);
            return new DaggerBlacklistActivityComponent(this.a, null);
        }

        @Override // com.avito.android.messenger.blacklist.mvi.di.BlacklistActivityComponent.Builder
        public BlacklistActivityComponent.Builder dependencies(BlacklistActivityComponentDependencies blacklistActivityComponentDependencies) {
            this.a = (BlacklistActivityComponentDependencies) Preconditions.checkNotNull(blacklistActivityComponentDependencies);
            return this;
        }
    }

    public DaggerBlacklistActivityComponent(BlacklistActivityComponentDependencies blacklistActivityComponentDependencies, a aVar) {
        this.a = blacklistActivityComponentDependencies;
    }

    public static BlacklistActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.blacklist.mvi.di.BlacklistActivityComponent
    public void inject(BlacklistActivity blacklistActivity) {
        BlacklistActivity_MembersInjector.injectActivityIntentFactory(blacklistActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}

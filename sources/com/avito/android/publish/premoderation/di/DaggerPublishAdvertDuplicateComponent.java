package com.avito.android.publish.premoderation.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.publish.di.PublishDependencies;
import com.avito.android.publish.premoderation.AdvertDuplicateFragment;
import com.avito.android.publish.premoderation.AdvertDuplicateFragment_MembersInjector;
import com.avito.android.publish.premoderation.AdvertDuplicatePresenter;
import com.avito.android.publish.premoderation.di.PublishAdvertDuplicateComponent;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerPublishAdvertDuplicateComponent implements PublishAdvertDuplicateComponent {
    public final PublishDependencies a;
    public Provider<SchedulersFactory> b;
    public Provider<AdvertDuplicatePresenter> c;

    public static final class b implements PublishAdvertDuplicateComponent.Builder {
        public PublishDependencies a;
        public PublishAdvertDuplicateModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.premoderation.di.PublishAdvertDuplicateComponent.Builder
        public PublishAdvertDuplicateComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, PublishAdvertDuplicateModule.class);
            return new DaggerPublishAdvertDuplicateComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.publish.premoderation.di.PublishAdvertDuplicateComponent.Builder
        public PublishAdvertDuplicateComponent.Builder publishAdvertDuplicateModule(PublishAdvertDuplicateModule publishAdvertDuplicateModule) {
            this.b = (PublishAdvertDuplicateModule) Preconditions.checkNotNull(publishAdvertDuplicateModule);
            return this;
        }

        @Override // com.avito.android.publish.premoderation.di.PublishAdvertDuplicateComponent.Builder
        public PublishAdvertDuplicateComponent.Builder publishDependencies(PublishDependencies publishDependencies) {
            this.a = (PublishDependencies) Preconditions.checkNotNull(publishDependencies);
            return this;
        }
    }

    public static class c implements Provider<SchedulersFactory> {
        public final PublishDependencies a;

        public c(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerPublishAdvertDuplicateComponent(PublishAdvertDuplicateModule publishAdvertDuplicateModule, PublishDependencies publishDependencies, a aVar) {
        this.a = publishDependencies;
        c cVar = new c(publishDependencies);
        this.b = cVar;
        this.c = DoubleCheck.provider(PublishAdvertDuplicateModule_ProvideAdvertDuplicatePresenterFactory.create(publishAdvertDuplicateModule, cVar));
    }

    public static PublishAdvertDuplicateComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.premoderation.di.PublishAdvertDuplicateComponent
    public void inject(AdvertDuplicateFragment advertDuplicateFragment) {
        AdvertDuplicateFragment_MembersInjector.injectPresenter(advertDuplicateFragment, this.c.get());
        AdvertDuplicateFragment_MembersInjector.injectActivityIntentFactory(advertDuplicateFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        AdvertDuplicateFragment_MembersInjector.injectDeepLinkIntentFactory(advertDuplicateFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}

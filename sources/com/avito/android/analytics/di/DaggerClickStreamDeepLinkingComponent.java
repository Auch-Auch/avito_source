package com.avito.android.analytics.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.ClickStreamDeepLinkActivity;
import com.avito.android.analytics.ClickStreamDeepLinkActivity_MembersInjector;
import com.avito.android.analytics.di.ClickStreamDeepLinkingComponent;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerClickStreamDeepLinkingComponent implements ClickStreamDeepLinkingComponent {
    public final ClickStreamDeepLinkingDependencies a;
    public Provider<Analytics> b;
    public Provider<SimpleClickStreamLinkHandler> c;
    public Provider<ClickStreamLinkHandler> d;

    public static final class b implements ClickStreamDeepLinkingComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.analytics.di.ClickStreamDeepLinkingComponent.Factory
        public ClickStreamDeepLinkingComponent create(ClickStreamDeepLinkingDependencies clickStreamDeepLinkingDependencies) {
            Preconditions.checkNotNull(clickStreamDeepLinkingDependencies);
            return new DaggerClickStreamDeepLinkingComponent(clickStreamDeepLinkingDependencies, null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final ClickStreamDeepLinkingDependencies a;

        public c(ClickStreamDeepLinkingDependencies clickStreamDeepLinkingDependencies) {
            this.a = clickStreamDeepLinkingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public DaggerClickStreamDeepLinkingComponent(ClickStreamDeepLinkingDependencies clickStreamDeepLinkingDependencies, a aVar) {
        this.a = clickStreamDeepLinkingDependencies;
        c cVar = new c(clickStreamDeepLinkingDependencies);
        this.b = cVar;
        SimpleClickStreamLinkHandler_Factory create = SimpleClickStreamLinkHandler_Factory.create(cVar);
        this.c = create;
        this.d = DoubleCheck.provider(create);
    }

    public static ClickStreamDeepLinkingComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.analytics.di.ClickStreamDeepLinkingComponent
    public void inject(ClickStreamDeepLinkActivity clickStreamDeepLinkActivity) {
        ClickStreamDeepLinkActivity_MembersInjector.injectClickStreamLinkHandler(clickStreamDeepLinkActivity, this.d.get());
        ClickStreamDeepLinkActivity_MembersInjector.injectDeepLinkIntentFactory(clickStreamDeepLinkActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}

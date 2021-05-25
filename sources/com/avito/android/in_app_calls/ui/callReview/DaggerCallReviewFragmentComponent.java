package com.avito.android.in_app_calls.ui.callReview;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.app.arch_components.ViewModelFactory;
import com.avito.android.app.arch_components.ViewModelFactory_Factory;
import com.avito.android.in_app_calls.ui.callReview.CallReviewFragmentComponent;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReview;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReviewAnalyticEventProviderImpl_Factory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;
public final class DaggerCallReviewFragmentComponent implements CallReviewFragmentComponent {
    public final Fragment a;
    public Provider<Analytics> b;
    public Provider<CallReview> c;
    public Provider<SchedulersFactory> d;
    public Provider<CallReviewPresenterImpl> e;
    public Provider<Map<Class<?>, Provider<ViewModel>>> f;
    public Provider<ViewModelFactory> g;

    public static final class b implements CallReviewFragmentComponent.Builder {
        public Fragment a;
        public Resources b;
        public CallReview c;
        public CallReviewComponentDependencies d;

        public b(a aVar) {
        }

        @Override // com.avito.android.in_app_calls.ui.callReview.CallReviewFragmentComponent.Builder
        public CallReviewFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Fragment.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, CallReview.class);
            Preconditions.checkBuilderRequirement(this.d, CallReviewComponentDependencies.class);
            return new DaggerCallReviewFragmentComponent(this.d, this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.in_app_calls.ui.callReview.CallReviewFragmentComponent.Builder
        public CallReviewFragmentComponent.Builder dependencies(CallReviewComponentDependencies callReviewComponentDependencies) {
            this.d = (CallReviewComponentDependencies) Preconditions.checkNotNull(callReviewComponentDependencies);
            return this;
        }

        @Override // com.avito.android.in_app_calls.ui.callReview.CallReviewFragmentComponent.Builder
        public CallReviewFragmentComponent.Builder fragment(Fragment fragment) {
            this.a = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.in_app_calls.ui.callReview.CallReviewFragmentComponent.Builder
        public CallReviewFragmentComponent.Builder params(CallReview callReview) {
            this.c = (CallReview) Preconditions.checkNotNull(callReview);
            return this;
        }

        @Override // com.avito.android.in_app_calls.ui.callReview.CallReviewFragmentComponent.Builder
        public CallReviewFragmentComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final CallReviewComponentDependencies a;

        public c(CallReviewComponentDependencies callReviewComponentDependencies) {
            this.a = callReviewComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final CallReviewComponentDependencies a;

        public d(CallReviewComponentDependencies callReviewComponentDependencies) {
            this.a = callReviewComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerCallReviewFragmentComponent(CallReviewComponentDependencies callReviewComponentDependencies, Fragment fragment, Resources resources, CallReview callReview, a aVar) {
        this.a = fragment;
        this.b = new c(callReviewComponentDependencies);
        Factory create = InstanceFactory.create(callReview);
        this.c = create;
        this.d = new d(callReviewComponentDependencies);
        this.e = CallReviewPresenterImpl_Factory.create(this.b, create, CallReviewAnalyticEventProviderImpl_Factory.create(), this.d);
        MapProviderFactory build = MapProviderFactory.builder(1).put((MapProviderFactory.Builder) CallReviewPresenterImpl.class, (Provider) this.e).build();
        this.f = build;
        this.g = SingleCheck.provider(ViewModelFactory_Factory.create(build));
    }

    public static CallReviewFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.in_app_calls.ui.callReview.CallReviewFragmentComponent
    public void inject(CallReviewFragment callReviewFragment) {
        CallReviewFragment_MembersInjector.injectPresenter(callReviewFragment, CallReviewFragmentModule_ProvideCallReviewPresenterFactory.provideCallReviewPresenter(this.a, this.g.get()));
    }
}

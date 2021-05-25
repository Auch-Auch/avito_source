package com.avito.android.call_feedback.di;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.call_feedback.CallFeedbackActivity;
import com.avito.android.call_feedback.CallFeedbackActivity_MembersInjector;
import com.avito.android.call_feedback.CallFeedbackInteractor;
import com.avito.android.call_feedback.CallFeedbackInteractor_Impl_Factory;
import com.avito.android.call_feedback.CallFeedbackPresenter;
import com.avito.android.call_feedback.CallFeedbackPresenter_Impl_Factory;
import com.avito.android.call_feedback.di.CallFeedbackComponent;
import com.avito.android.call_feedback.list.item.CallFeedbackListItemBlueprint;
import com.avito.android.call_feedback.list.item.CallFeedbackListItemBlueprint_Factory;
import com.avito.android.call_feedback.list.item.CallFeedbackListItemPresenter;
import com.avito.android.call_feedback.list.item.CallFeedbackListItemPresenter_Impl_Factory;
import com.avito.android.call_feedback.list.title.CallFeedbackListTitleBlueprint;
import com.avito.android.call_feedback.list.title.CallFeedbackListTitleBlueprint_Factory;
import com.avito.android.call_feedback.list.title.CallFeedbackListTitlePresenter;
import com.avito.android.call_feedback.list.title.CallFeedbackListTitlePresenter_Impl_Factory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.remote.CallFeedbackApi;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerCallFeedbackComponent implements CallFeedbackComponent {
    public final CallFeedbackDependencies a;
    public Provider<Relay<String>> b;
    public Provider<CallFeedbackListItemPresenter.Impl> c;
    public Provider<CallFeedbackListItemPresenter> d;
    public Provider<CallFeedbackListItemBlueprint> e;
    public Provider<CallFeedbackListTitlePresenter> f;
    public Provider<CallFeedbackListTitleBlueprint> g;
    public Provider<ItemBinder> h;
    public Provider<AdapterPresenter> i;
    public Provider<CallFeedbackApi> j;
    public Provider<String> k;
    public Provider<SchedulersFactory> l;
    public Provider<CallFeedbackInteractor.Impl> m;
    public Provider<CallFeedbackInteractor> n;
    public Provider<Kundle> o;
    public Provider<CallFeedbackPresenter.Impl> p;
    public Provider<CallFeedbackPresenter> q;
    public Provider<Activity> r;
    public Provider<DialogRouter> s;
    public Provider<RecyclerView.Adapter<?>> t = DoubleCheck.provider(CallFeedbackModule_ProvideRecyclerViewAdapter$call_feedback_releaseFactory.create(this.i, this.h));

    public static final class b implements CallFeedbackComponent.Builder {
        public CallFeedbackDependencies a;
        public Activity b;
        public String c;
        public Kundle d;

        public b(a aVar) {
        }

        @Override // com.avito.android.call_feedback.di.CallFeedbackComponent.Builder
        public CallFeedbackComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CallFeedbackDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            return new DaggerCallFeedbackComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.call_feedback.di.CallFeedbackComponent.Builder
        public CallFeedbackComponent.Builder dependencies(CallFeedbackDependencies callFeedbackDependencies) {
            this.a = (CallFeedbackDependencies) Preconditions.checkNotNull(callFeedbackDependencies);
            return this;
        }

        @Override // com.avito.android.call_feedback.di.CallFeedbackComponent.Builder
        public CallFeedbackComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.call_feedback.di.CallFeedbackComponent.Builder
        public CallFeedbackComponent.Builder withCallId(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.call_feedback.di.CallFeedbackComponent.Builder
        public CallFeedbackComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }
    }

    public static class c implements Provider<CallFeedbackApi> {
        public final CallFeedbackDependencies a;

        public c(CallFeedbackDependencies callFeedbackDependencies) {
            this.a = callFeedbackDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallFeedbackApi get() {
            return (CallFeedbackApi) Preconditions.checkNotNullFromComponent(this.a.callFeedbackApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final CallFeedbackDependencies a;

        public d(CallFeedbackDependencies callFeedbackDependencies) {
            this.a = callFeedbackDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerCallFeedbackComponent(CallFeedbackDependencies callFeedbackDependencies, Activity activity, String str, Kundle kundle, a aVar) {
        this.a = callFeedbackDependencies;
        Provider<Relay<String>> provider = DoubleCheck.provider(CallFeedbackModule_ProvideRelay$call_feedback_releaseFactory.create());
        this.b = provider;
        CallFeedbackListItemPresenter_Impl_Factory create = CallFeedbackListItemPresenter_Impl_Factory.create(provider);
        this.c = create;
        Provider<CallFeedbackListItemPresenter> provider2 = DoubleCheck.provider(create);
        this.d = provider2;
        this.e = CallFeedbackListItemBlueprint_Factory.create(provider2);
        Provider<CallFeedbackListTitlePresenter> provider3 = DoubleCheck.provider(CallFeedbackListTitlePresenter_Impl_Factory.create());
        this.f = provider3;
        CallFeedbackListTitleBlueprint_Factory create2 = CallFeedbackListTitleBlueprint_Factory.create(provider3);
        this.g = create2;
        Provider<ItemBinder> provider4 = DoubleCheck.provider(CallFeedbackModule_ProvideItemBinder$call_feedback_releaseFactory.create(this.e, create2));
        this.h = provider4;
        this.i = DoubleCheck.provider(CallFeedbackModule_ProvideAdapterPresenter$call_feedback_releaseFactory.create(provider4));
        this.j = new c(callFeedbackDependencies);
        Factory create3 = InstanceFactory.create(str);
        this.k = create3;
        d dVar = new d(callFeedbackDependencies);
        this.l = dVar;
        CallFeedbackInteractor_Impl_Factory create4 = CallFeedbackInteractor_Impl_Factory.create(this.j, create3, dVar);
        this.m = create4;
        this.n = DoubleCheck.provider(create4);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.o = createNullable;
        CallFeedbackPresenter_Impl_Factory create5 = CallFeedbackPresenter_Impl_Factory.create(this.i, this.n, this.b, createNullable, this.l);
        this.p = create5;
        this.q = DoubleCheck.provider(create5);
        Factory create6 = InstanceFactory.create(activity);
        this.r = create6;
        this.s = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create6));
    }

    public static CallFeedbackComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.call_feedback.di.CallFeedbackComponent
    public void inject(CallFeedbackActivity callFeedbackActivity) {
        CallFeedbackActivity_MembersInjector.injectAnalytics(callFeedbackActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        CallFeedbackActivity_MembersInjector.injectPresenter(callFeedbackActivity, this.q.get());
        CallFeedbackActivity_MembersInjector.injectDialogRouter(callFeedbackActivity, this.s.get());
        CallFeedbackActivity_MembersInjector.injectRecyclerViewAdapter(callFeedbackActivity, this.t.get());
    }
}

package com.avito.android.autoteka_details;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.autoteka_details.AutotekaDetailsPresenter;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.autoteka_details.di.AutotekaDetailsComponent;
import com.avito.android.autoteka_details.di.AutotekaDetailsDependencies;
import com.avito.android.autoteka_details.di.DaggerAutotekaDetailsComponent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.Views;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001HB\u0007¢\u0006\u0004\bG\u0010\u0011J-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\r2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016¢\u0006\u0004\b\u001f\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter$Router;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "onBackClicked", "Landroid/net/Uri;", "url", "reportExampleClicked", "(Landroid/net/Uri;)V", "receiveReportClicked", "", BookingInfoActivity.EXTRA_ITEM_ID, "utmQuery", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntent", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntent", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntent", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter;", "presenter", "Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter;", "getPresenter", "()Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter;", "setPresenter", "(Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter;)V", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "interactor", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "getInteractor", "()Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "setInteractor", "(Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "Factory", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaDetailsFragment extends BaseFragment implements AutotekaDetailsPresenter.Router {
    @Inject
    public Analytics analytics;
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory implicitIntent;
    @Inject
    public AutotekaDetailsInteractor interactor;
    @Inject
    public AutotekaDetailsPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsFragment$Factory;", "", "", "id", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "autotekaDetails", "utmQuery", "Lcom/avito/android/autoteka_details/AutotekaDetailsFragment;", "createInstance", "(Ljava/lang/String;Lcom/avito/android/remote/model/AutotekaDetailsResponse;Ljava/lang/String;)Lcom/avito/android/autoteka_details/AutotekaDetailsFragment;", "<init>", "()V", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final AutotekaDetailsFragment createInstance(@NotNull String str, @Nullable AutotekaDetailsResponse autotekaDetailsResponse, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            AutotekaDetailsFragment autotekaDetailsFragment = new AutotekaDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("autoteka_id", str);
            bundle.putParcelable("autoteka_details", autotekaDetailsResponse);
            bundle.putString("utm_query", str2);
            autotekaDetailsFragment.setArguments(bundle);
            return autotekaDetailsFragment;
        }
    }

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ AutotekaDetailsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AutotekaDetailsFragment autotekaDetailsFragment) {
            super(1);
            this.a = autotekaDetailsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            View view = this.a.getView();
            if (view != null) {
                Views.showSnackBar$default(view, R.string.no_application_installed_to_perform_this_action, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ AutotekaDetailsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AutotekaDetailsFragment autotekaDetailsFragment) {
            super(1);
            this.a = autotekaDetailsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            View view = this.a.getView();
            if (view != null) {
                Views.showSnackBar$default(view, R.string.no_application_installed_to_perform_this_action, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ AutotekaDetailsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AutotekaDetailsFragment autotekaDetailsFragment) {
            super(1);
            this.a = autotekaDetailsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            View view = this.a.getView();
            if (view != null) {
                Views.showSnackBar$default(view, R.string.no_application_installed_to_perform_this_action, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
            }
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntent() {
        ImplicitIntentFactory implicitIntentFactory = this.implicitIntent;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntent");
        }
        return implicitIntentFactory;
    }

    @NotNull
    public final AutotekaDetailsInteractor getInteractor() {
        AutotekaDetailsInteractor autotekaDetailsInteractor = this.interactor;
        if (autotekaDetailsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return autotekaDetailsInteractor;
    }

    @NotNull
    public final AutotekaDetailsPresenter getPresenter() {
        AutotekaDetailsPresenter autotekaDetailsPresenter = this.presenter;
        if (autotekaDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return autotekaDetailsPresenter;
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsPresenter.Router
    public void onBackClicked() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.autoteka_details_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AutotekaDetailsPresenter autotekaDetailsPresenter = this.presenter;
        if (autotekaDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autotekaDetailsPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        AutotekaDetailsInteractor autotekaDetailsInteractor = this.interactor;
        if (autotekaDetailsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putParcelable("autoteka_interactor_state", autotekaDetailsInteractor.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AutotekaDetailsPresenter autotekaDetailsPresenter = this.presenter;
        if (autotekaDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autotekaDetailsPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        AutotekaDetailsPresenter autotekaDetailsPresenter = this.presenter;
        if (autotekaDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autotekaDetailsPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        AutotekaDetailsPresenter autotekaDetailsPresenter = this.presenter;
        if (autotekaDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        autotekaDetailsPresenter.attachView(new AutotekaDetailsViewImpl(view, analytics2));
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsPresenter.Router
    public void receiveReportClicked(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "url");
        ImplicitIntentFactory implicitIntentFactory = this.implicitIntent;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntent");
        }
        FragmentsKt.startActivitySafely(this, ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(implicitIntentFactory, uri, false, 2, null), new a(this));
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsPresenter.Router
    public void reportExampleClicked(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "url");
        ImplicitIntentFactory implicitIntentFactory = this.implicitIntent;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntent");
        }
        FragmentsKt.startActivitySafely(this, ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(implicitIntentFactory, uri, false, 2, null), new c(this));
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImplicitIntent(@NotNull ImplicitIntentFactory implicitIntentFactory) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "<set-?>");
        this.implicitIntent = implicitIntentFactory;
    }

    public final void setInteractor(@NotNull AutotekaDetailsInteractor autotekaDetailsInteractor) {
        Intrinsics.checkNotNullParameter(autotekaDetailsInteractor, "<set-?>");
        this.interactor = autotekaDetailsInteractor;
    }

    public final void setPresenter(@NotNull AutotekaDetailsPresenter autotekaDetailsPresenter) {
        Intrinsics.checkNotNullParameter(autotekaDetailsPresenter, "<set-?>");
        this.presenter = autotekaDetailsPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String string = requireArguments().getString("autoteka_id");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "requireArguments().getString(ITEM_ID_KEY)!!");
        AutotekaDetailsResponse autotekaDetailsResponse = (AutotekaDetailsResponse) requireArguments().getParcelable("autoteka_details");
        String string2 = requireArguments().getString("utm_query");
        Kundle kundle = bundle != null ? (Kundle) bundle.getParcelable("autoteka_interactor_state") : null;
        boolean z = bundle != null;
        AutotekaDetailsComponent.Builder dependentOn = DaggerAutotekaDetailsComponent.builder().dependentOn((AutotekaDetailsDependencies) ComponentDependenciesKt.getDependencies(AutotekaDetailsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        dependentOn.withResources(resources).withAdvertId(string).withUtmQuery(string2).withIsRestored(z).withInteractorState(kundle).withAutotekaDetails(autotekaDetailsResponse).build().inject(this);
        return true;
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsPresenter.Router
    public void receiveReportClicked(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "utmQuery");
        ImplicitIntentFactory implicitIntentFactory = this.implicitIntent;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntent");
        }
        FragmentsKt.startActivitySafely(this, implicitIntentFactory.autotekaBuyReportCustomChromeTabsIntent(str, str2), new b(this));
    }
}

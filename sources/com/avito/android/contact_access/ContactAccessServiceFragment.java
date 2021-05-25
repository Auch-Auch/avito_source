package com.avito.android.contact_access;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.contact_access.di.ContactAccessDependencies;
import com.avito.android.contact_access.di.ContactAccessServiceComponent;
import com.avito.android.contact_access.di.DaggerContactAccessServiceComponent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.LegacyPaymentSessionLink;
import com.avito.android.deep_linking.links.PaymentSessionLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.dialog.advert_details.IncompleteRegisterDialog;
import com.avito.android.dialog.advert_details.IncompleteRegisterDialogKt;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.ui.fragments.BaseFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bD\u0010\u001bJ+\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\rH\u0016¢\u0006\u0004\b#\u0010\u001bJ\u000f\u0010$\u001a\u00020\rH\u0016¢\u0006\u0004\b$\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\u00020=8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/avito/android/contact_access/ContactAccessServiceFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/contact_access/ContactAccessServiceRouter;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onDestroyView", "()V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onActionRequest", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "showIncompleteRegister", "close", "Lcom/avito/android/contact_access/ContactAccessServiceView;", "c", "Lcom/avito/android/contact_access/ContactAccessServiceView;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/contact_access/ContactAccessServicePresenter;", "presenter", "Lcom/avito/android/contact_access/ContactAccessServicePresenter;", "getPresenter", "()Lcom/avito/android/contact_access/ContactAccessServicePresenter;", "setPresenter", "(Lcom/avito/android/contact_access/ContactAccessServicePresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class ContactAccessServiceFragment extends BaseFragment implements ContactAccessServiceRouter {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    public ContactAccessServiceView c;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ContactAccessServicePresenter presenter;

    @Override // com.avito.android.contact_access.ContactAccessServiceRouter
    public void close() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
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
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final ContactAccessServicePresenter getPresenter() {
        ContactAccessServicePresenter contactAccessServicePresenter = this.presenter;
        if (contactAccessServicePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return contactAccessServicePresenter;
    }

    @Override // com.avito.android.contact_access.ContactAccessServiceRouter
    public void onActionRequest(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        boolean z = (deepLink instanceof LegacyPaymentSessionLink) || (deepLink instanceof PaymentSessionLink);
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent == null) {
            return;
        }
        if (z) {
            startActivityForResult(intent, 1);
        } else {
            startActivity(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String stringExtra;
        ContactAccessServiceView contactAccessServiceView;
        if (i == 1) {
            if (i2 == -1) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.setResult(-1);
                }
                close();
            }
            if (i2 == 0 && intent != null && (stringExtra = intent.getStringExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT)) != null && (contactAccessServiceView = this.c) != null) {
                contactAccessServiceView.showSnackbar(stringExtra);
            }
        } else if (i == 2) {
            if (i2 == -1) {
                ContactAccessServicePresenter contactAccessServicePresenter = this.presenter;
                if (contactAccessServicePresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                contactAccessServicePresenter.onIncompleteRegisterFinished();
                return;
            }
            close();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.contact_access_service, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ervice, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ContactAccessServicePresenter contactAccessServicePresenter = this.presenter;
        if (contactAccessServicePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        contactAccessServicePresenter.detachRouter();
        ContactAccessServicePresenter contactAccessServicePresenter2 = this.presenter;
        if (contactAccessServicePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        contactAccessServicePresenter2.unsubscribe();
        this.c = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ContactAccessServicePresenter contactAccessServicePresenter = this.presenter;
        if (contactAccessServicePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        contactAccessServicePresenter.onSaveState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        IncompleteRegisterDialog incompleteRegisterDialog = (IncompleteRegisterDialog) getChildFragmentManager().findFragmentByTag("tag_register");
        if (incompleteRegisterDialog != null) {
            incompleteRegisterDialog.attachRouter(new ContactAccessServiceFragment$setIncompleteRegisterRouter$incompleteRegisterRouter$1(this));
        }
        ViewGroup viewGroup = (ViewGroup) view;
        ContactAccessServicePresenter contactAccessServicePresenter = this.presenter;
        if (contactAccessServicePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ContactAccessServiceViewImpl contactAccessServiceViewImpl = new ContactAccessServiceViewImpl(viewGroup, contactAccessServicePresenter, analytics2);
        this.c = contactAccessServiceViewImpl;
        ContactAccessServicePresenter contactAccessServicePresenter2 = this.presenter;
        if (contactAccessServicePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        contactAccessServicePresenter2.subscribe(contactAccessServiceViewImpl);
        ContactAccessServicePresenter contactAccessServicePresenter3 = this.presenter;
        if (contactAccessServicePresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        contactAccessServicePresenter3.attachRouter(this);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPresenter(@NotNull ContactAccessServicePresenter contactAccessServicePresenter) {
        Intrinsics.checkNotNullParameter(contactAccessServicePresenter, "<set-?>");
        this.presenter = contactAccessServicePresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Parcelable parcelable = requireArguments().getParcelable(ContactAccessServiceActivityKt.EXTRA_ARGS);
        Intrinsics.checkNotNull(parcelable);
        Intrinsics.checkNotNullExpressionValue(parcelable, "requireArguments().getPa…eArguments>(EXTRA_ARGS)!!");
        ContactAccessServiceComponent.Builder withState = DaggerContactAccessServiceComponent.builder().dependentOn((ContactAccessDependencies) ComponentDependenciesKt.getDependencies(ContactAccessDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withArgs((ContactAccessServiceArguments) parcelable).withState(bundle);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withState.withResources(resources).build().inject(this);
        return true;
    }

    @Override // com.avito.android.contact_access.ContactAccessServiceRouter
    public void showIncompleteRegister() {
        if (((IncompleteRegisterDialog) getChildFragmentManager().findFragmentByTag("tag_register")) == null) {
            IncompleteRegisterDialog createIncompleteRegisterDialog = IncompleteRegisterDialogKt.createIncompleteRegisterDialog();
            createIncompleteRegisterDialog.attachRouter(new ContactAccessServiceFragment$setIncompleteRegisterRouter$incompleteRegisterRouter$1(this));
            createIncompleteRegisterDialog.show(getChildFragmentManager(), "tag_register");
        }
    }
}

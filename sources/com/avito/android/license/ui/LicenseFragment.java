package com.avito.android.license.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.license.LicenseModel;
import com.avito.android.license.LicenseView;
import com.avito.android.license.R;
import com.avito.android.license.di.DaggerLicenseComponent;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0007¢\u0006\u0004\b9\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001e\u001a\u00020\u00052\n\u0010\u001d\u001a\u00060\u001bj\u0002`\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0015J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0015R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/avito/android/license/ui/LicenseFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/avito/android/license/LicenseView;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onActivityCreated", "onStart", "()V", "onDestroy", "", "htmlText", "showLicense", "(Ljava/lang/String;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ex", "handleError", "(Ljava/lang/Exception;)V", "onLoadingStart", "onLoadingFinish", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/webkit/WebView;", "c", "Landroid/webkit/WebView;", "webView", "Lcom/avito/android/license/LicenseModel;", "d", "Lcom/avito/android/license/LicenseModel;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "", AuthSource.SEND_ABUSE, "Z", "isLicenseLoaded", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "Companion", "license_release"}, k = 1, mv = {1, 4, 2})
public final class LicenseFragment extends DialogFragment implements LicenseView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "LicensesFragment";
    public boolean a;
    @Inject
    public Analytics analytics;
    public ProgressOverlay b;
    public WebView c;
    public LicenseModel d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/license/ui/LicenseFragment$Companion;", "", "Lcom/avito/android/license/ui/LicenseFragment;", "newInstance", "()Lcom/avito/android/license/ui/LicenseFragment;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "license_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final LicenseFragment newInstance() {
            return new LicenseFragment();
        }

        public Companion(j jVar) {
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

    @Override // com.avito.android.license.LicenseView
    public void handleError(@NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "ex");
        Logs.error(TAG, "onError", exc);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        DaggerLicenseComponent.builder().dependentOn((CoreComponentDependencies) ComponentDependenciesKt.getDependencies(CoreComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.d = new LicenseModel(activity != null ? activity.getApplicationContext() : null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setTitle(getString(R.string.open_source_licences));
        }
        View inflate = layoutInflater.inflate(R.layout.fr_licenses, viewGroup, false);
        int i = R.id.content;
        View findViewById = inflate.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.webkit.WebView");
        this.c = (WebView) findViewById;
        Dialog dialog2 = getDialog();
        View findViewById2 = (dialog2 == null || (window = dialog2.getWindow()) == null) ? null : window.findViewById(16908290);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) findViewById2;
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.b = new ProgressOverlay(viewGroup2, i, analytics2, false, 0, 24, null);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LicenseModel licenseModel = this.d;
        if (licenseModel != null) {
            licenseModel.unsubscribe();
        }
    }

    @Override // com.avito.android.license.LicenseView
    public void onLoadingFinish() {
        ProgressOverlay progressOverlay = this.b;
        if (progressOverlay != null) {
            progressOverlay.showContent();
        }
    }

    @Override // com.avito.android.license.LicenseView
    public void onLoadingStart() {
        ProgressOverlay progressOverlay = this.b;
        if (progressOverlay != null) {
            progressOverlay.showLoading();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        LicenseModel licenseModel;
        super.onStart();
        LicenseModel licenseModel2 = this.d;
        if (licenseModel2 != null) {
            licenseModel2.subscribe(this);
        }
        if (!this.a && (licenseModel = this.d) != null) {
            licenseModel.refresh();
        }
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    @Override // com.avito.android.license.LicenseView
    public void showLicense(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "htmlText");
        if (getActivity() != null) {
            WebView webView = this.c;
            if (webView != null) {
                webView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
            }
            this.a = true;
        }
    }
}

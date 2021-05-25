package com.avito.android.details_sheet;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.details_sheet.di.DaggerDetailsSheetActivityComponent;
import com.avito.android.details_sheet.di.DetailsSheetActivityDependencies;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.text.AttributedTextFormatter;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b1\u0010\fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/avito/android/details_sheet/DetailsSheetActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/deep_linking/links/OnUrlClickListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "()V", "", "url", "onUrlClick", "(Ljava/lang/String;)Z", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeeplinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "k", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "Companion", "details-sheet_release"}, k = 1, mv = {1, 4, 2})
public final class DetailsSheetActivity extends BaseActivity implements OnUrlClickListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_BODY = "DETAILS_SHEET_ACTIVITY_EXTRA_BODY";
    @NotNull
    public static final String EXTRA_BUTTON_CLICK_EVENT = "DETAILS_SHEET_ACTIVITY_EXTRA_CLICK_EVENT";
    @Inject
    public Analytics analytics;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    @Inject
    public DeepLinkIntentFactory deeplinkIntentFactory;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    public BottomSheetDialog k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/details_sheet/DetailsSheetActivity$Companion;", "", "", "EXTRA_BODY", "Ljava/lang/String;", "EXTRA_BUTTON_CLICK_EVENT", "<init>", "()V", "details-sheet_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
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

    @NotNull
    public final AttributedTextFormatter getAttributedTextFormatter() {
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        return attributedTextFormatter2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeeplinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory = this.deeplinkIntentFactory;
        if (deepLinkIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deeplinkIntentFactory");
        }
        return deepLinkIntentFactory;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01bf  */
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r27) {
        /*
        // Method dump skipped, instructions count: 548
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.details_sheet.DetailsSheetActivity.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BottomSheetDialog bottomSheetDialog = this.k;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.setOnDismissListener(null);
            boolean z = true;
            if (!bottomSheetDialog.isShowing()) {
                z = false;
            }
            if (z) {
                bottomSheetDialog.dismiss();
            }
        }
    }

    @Override // com.avito.android.deep_linking.links.OnUrlClickListener
    public boolean onUrlClick(@NotNull String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "url");
        Uri parse = Uri.parse(str);
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        Intrinsics.checkNotNullExpressionValue(parse, "originUri");
        List<Intent> externalIntentsForUrl = implicitIntentFactory2.getExternalIntentsForUrl(parse);
        int size = externalIntentsForUrl.size();
        if (size != 0) {
            if (size != 1) {
                List<? extends Intent> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) externalIntentsForUrl);
                Intent intent = (Intent) mutableList.remove(0);
                ImplicitIntentFactory implicitIntentFactory3 = this.implicitIntentFactory;
                if (implicitIntentFactory3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
                }
                String string = getString(R.string.details_sheet_open_with);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.details_sheet_open_with)");
                startActivity(implicitIntentFactory3.chooserIntent(string, intent, mutableList));
            } else {
                startActivity(externalIntentsForUrl.get(0));
            }
            z = true;
        } else {
            z = false;
        }
        if (z) {
            finish();
            return true;
        }
        ToastsKt.showToast$default(this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
        return false;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    public final void setDeeplinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "<set-?>");
        this.deeplinkIntentFactory = deepLinkIntentFactory;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        DaggerDetailsSheetActivityComponent.builder().dependencies((DetailsSheetActivityDependencies) ComponentDependenciesKt.getDependencies(DetailsSheetActivityDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        return true;
    }
}

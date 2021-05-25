package com.avito.android.advert_core.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avito.android.advert_core.dialog.di.DaggerDialogDeepLinkActivityComponent;
import com.avito.android.advert_core.dialog.di.DialogDeepLinkActivityComponent;
import com.avito.android.advert_core.dialog.di.DialogDeepLinkActivityDependencies;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DialogDeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.dialog.DialogWithDeeplinkActionsKt;
import com.avito.android.dialog.DialogWithDeeplinkActionsRouter;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0007¢\u0006\u0004\b\u0015\u0010\rJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert_core/dialog/DialogDeepLinkActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/dialog/DialogWithDeeplinkActionsRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onDialogDismiss", "()V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "intentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "Companion", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class DialogDeepLinkActivity extends BaseActivity implements DialogWithDeeplinkActionsRouter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public DeepLinkIntentFactory intentFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_core/dialog/DialogDeepLinkActivity$Companion;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/deep_linking/links/DialogDeepLink;", "link", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Lcom/avito/android/deep_linking/links/DialogDeepLink;)Landroid/content/Intent;", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull DialogDeepLink dialogDeepLink) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dialogDeepLink, "link");
            Intent intent = new Intent(context, DialogDeepLinkActivity.class);
            intent.putExtra(DialogDeepLinkActivityKt.DEEPLINK_ARG, dialogDeepLink);
            return intent;
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final DeepLinkIntentFactory getIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory = this.intentFactory;
        if (deepLinkIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return deepLinkIntentFactory;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        DialogDeepLink dialogDeepLink;
        DialogDeepLinkActivityComponent.Builder builder = DaggerDialogDeepLinkActivityComponent.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "DaggerDialogDeepLinkActivityComponent.builder()");
        builder.bindDependencies((DialogDeepLinkActivityDependencies) ComponentDependenciesKt.getDependencies(DialogDeepLinkActivityDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        super.onCreate(bundle);
        if (bundle == null) {
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            Bundle extras = intent.getExtras();
            if (extras == null || (dialogDeepLink = (DialogDeepLink) extras.getParcelable(DialogDeepLinkActivityKt.DEEPLINK_ARG)) == null) {
                throw new IllegalArgumentException("Deeplink not specified");
            }
            Intrinsics.checkNotNullExpressionValue(dialogDeepLink, "intent.extras?.getParcel…\"Deeplink not specified\")");
            DialogWithDeeplinkActionsKt.createDialogWithDeepLinkActions(DialogDeepLinkActivityKt.access$toInfo(dialogDeepLink)).show(getSupportFragmentManager(), "DialogWithDeepLink");
        }
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActionsRouter
    public void onDialogDismiss() {
        if (!isFinishing()) {
            finish();
        }
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActionsRouter
    public void openDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory = this.intentFactory;
        if (deepLinkIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent intent = deepLinkIntentFactory.getIntent(deepLink);
        if (intent != null) {
            try {
                startActivity(IntentsKt.makeSafeForExternalApps(intent));
            } catch (Exception e) {
                Logs.error("Error while trying to open " + deepLink, e);
            }
        }
    }

    public final void setIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "<set-?>");
        this.intentFactory = deepLinkIntentFactory;
    }
}

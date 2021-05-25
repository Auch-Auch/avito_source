package com.avito.android.verification.verification_status.actions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import androidx.lifecycle.Observer;
import com.avito.android.VerificationIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.verification.R;
import com.avito.android.verification.VerificationActivityKt;
import com.avito.android.verification.di.DaggerVerificationActionComponent;
import com.avito.android.verification.di.VerificationActionDependencies;
import com.avito.android.verification.verification_status.actions.VerificationActionViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/verification/verification_status/actions/VerificationActionActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onBackPressed", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "getContentLayoutId", "()I", "Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "k", "Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "progressDialogRouter", "Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel;", "viewModel", "Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel;", "getViewModel$verification_release", "()Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel;", "setViewModel$verification_release", "(Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel;)V", "<init>", "Companion", "Result", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationActionActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public ProgressDialogRouter k = new ProgressDialogRouter(this);
    @Inject
    public VerificationActionViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/verification/verification_status/actions/VerificationActionActivity$Companion;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/VerificationIntentFactory$VerificationAction;", "action", "", "type", "Landroid/content/Intent;", "createVerificationActionActivity", "(Landroid/content/Context;Lcom/avito/android/VerificationIntentFactory$VerificationAction;Ljava/lang/String;)Landroid/content/Intent;", "intent", "Lcom/avito/android/verification/verification_status/actions/VerificationActionActivity$Result;", "getResultFrom", "(Landroid/content/Intent;)Lcom/avito/android/verification/verification_status/actions/VerificationActionActivity$Result;", "<init>", "()V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent createVerificationActionActivity(@NotNull Context context, @NotNull VerificationIntentFactory.VerificationAction verificationAction, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(verificationAction, "action");
            Intrinsics.checkNotNullParameter(str, "type");
            Intent intent = new Intent(context, VerificationActionActivity.class);
            intent.putExtra("key.verification_action", verificationAction);
            intent.putExtra(VerificationActivityKt.KEY_VERIFICATION_TYPE, str);
            return intent;
        }

        @NotNull
        public final Result getResultFrom(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            boolean booleanExtra = intent.getBooleanExtra("result.status", true);
            String stringExtra = intent.getStringExtra("result.message");
            Parcelable parcelableExtra = intent.getParcelableExtra("result.action");
            Intrinsics.checkNotNull(parcelableExtra);
            return new Result(booleanExtra, stringExtra, (DeepLink) parcelableExtra);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\n¨\u0006\""}, d2 = {"Lcom/avito/android/verification/verification_status/actions/VerificationActionActivity$Result;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "()Lcom/avito/android/deep_linking/links/DeepLink;", "success", "message", "action", "copy", "(ZLjava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/verification/verification_status/actions/VerificationActionActivity$Result;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", AuthSource.SEND_ABUSE, "Z", "getSuccess", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getAction", "<init>", "(ZLjava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Result {
        public final boolean a;
        @Nullable
        public final String b;
        @NotNull
        public final DeepLink c;

        public Result(boolean z, @Nullable String str, @NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(deepLink, "action");
            this.a = z;
            this.b = str;
            this.c = deepLink;
        }

        public static /* synthetic */ Result copy$default(Result result, boolean z, String str, DeepLink deepLink, int i, Object obj) {
            if ((i & 1) != 0) {
                z = result.a;
            }
            if ((i & 2) != 0) {
                str = result.b;
            }
            if ((i & 4) != 0) {
                deepLink = result.c;
            }
            return result.copy(z, str, deepLink);
        }

        public final boolean component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final DeepLink component3() {
            return this.c;
        }

        @NotNull
        public final Result copy(boolean z, @Nullable String str, @NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(deepLink, "action");
            return new Result(z, str, deepLink);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return this.a == result.a && Intrinsics.areEqual(this.b, result.b) && Intrinsics.areEqual(this.c, result.c);
        }

        @NotNull
        public final DeepLink getAction() {
            return this.c;
        }

        @Nullable
        public final String getMessage() {
            return this.b;
        }

        public final boolean getSuccess() {
            return this.a;
        }

        public int hashCode() {
            boolean z = this.a;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = i * 31;
            String str = this.b;
            int i5 = 0;
            int hashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
            DeepLink deepLink = this.c;
            if (deepLink != null) {
                i5 = deepLink.hashCode();
            }
            return hashCode + i5;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Result(success=");
            L.append(this.a);
            L.append(", message=");
            L.append(this.b);
            L.append(", action=");
            return a2.b.a.a.a.m(L, this.c, ")");
        }
    }

    public static final class a<T> implements Observer<VerificationActionViewModel.RouterAction> {
        public final /* synthetic */ VerificationActionActivity a;

        public a(VerificationActionActivity verificationActionActivity) {
            this.a = verificationActionActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(VerificationActionViewModel.RouterAction routerAction) {
            VerificationActionViewModel.RouterAction routerAction2 = routerAction;
            if (routerAction2 instanceof VerificationActionViewModel.RouterAction.Close) {
                new Handler().postDelayed(new a2.a.a.r3.a.k.a(this, routerAction2), 200);
                this.a.finish();
            } else if (routerAction2 instanceof VerificationActionViewModel.RouterAction.Cancel) {
                this.a.finish();
            }
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.verification_action;
    }

    @NotNull
    public final VerificationActionViewModel getViewModel$verification_release() {
        VerificationActionViewModel verificationActionViewModel = this.viewModel;
        if (verificationActionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return verificationActionViewModel;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.k.removeDialog();
        VerificationActionViewModel verificationActionViewModel = this.viewModel;
        if (verificationActionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        verificationActionViewModel.onCancelRequest();
        super.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        VerificationActionViewModel verificationActionViewModel = this.viewModel;
        if (verificationActionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        verificationActionViewModel.getRouterAction().observe(this, new a(this));
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.k.showDialog();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.k.removeDialog();
        super.onStop();
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        String stringExtra = getIntent().getStringExtra(VerificationActivityKt.KEY_VERIFICATION_TYPE);
        Intrinsics.checkNotNull(stringExtra);
        DaggerVerificationActionComponent.factory().create(this, (VerificationActionDependencies) ComponentDependenciesKt.getDependencies(VerificationActionDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)), resources, stringExtra).inject(this);
        return true;
    }

    public final void setViewModel$verification_release(@NotNull VerificationActionViewModel verificationActionViewModel) {
        Intrinsics.checkNotNullParameter(verificationActionViewModel, "<set-?>");
        this.viewModel = verificationActionViewModel;
    }
}

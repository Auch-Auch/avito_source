package com.avito.android.verification;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.verification.verification_status.VerificationStatusFragment;
import com.avito.android.verification.verifications_list.VerificationsListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B\u0007¢\u0006\u0004\b \u0010\u0012J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0012J#\u0010\u0019\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/verification/VerificationActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/verification/verifications_list/VerificationsListFragment$VerificationsListRouter;", "Lcom/avito/android/verification/verification_status/VerificationStatusFragment$VerificationsStatusRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "", "type", "navigateToVerificationStatus", "(Ljava/lang/String;)V", "closeActivity", "()V", "", "getContentLayoutId", "()I", "onBackPressed", "", "addToBackStack", AuthSource.SEND_ABUSE, "(Landroid/content/Intent;Z)V", "Landroidx/fragment/app/Fragment;", "fragment", "tag", AuthSource.BOOKING_ORDER, "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Z)V", "<init>", "Companion", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationActivity extends BaseActivity implements VerificationsListFragment.VerificationsListRouter, VerificationStatusFragment.VerificationsStatusRouter {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/verification/VerificationActivity$Companion;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "createVerificationsListActivity", "(Landroid/content/Context;)Landroid/content/Intent;", "", "type", "createVerificationStatusActivity", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent createVerificationStatusActivity(@NotNull Context context, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "type");
            Intent intent = new Intent(context, VerificationActivity.class);
            intent.putExtra(VerificationActivityKt.KEY_VERIFICATION_TYPE, str);
            return intent;
        }

        @NotNull
        public final Intent createVerificationsListActivity(@NotNull Context context) {
            return a.X0(context, "context", context, VerificationActivity.class);
        }

        public Companion(j jVar) {
        }
    }

    public final void a(Intent intent, boolean z) {
        if (intent == null || !intent.hasExtra(VerificationActivityKt.KEY_VERIFICATION_TYPE)) {
            b(VerificationsListFragment.Companion.newInstance(), VerificationActivityKt.TAG_VERIFICATION_LIST, z);
            return;
        }
        String stringExtra = intent.getStringExtra(VerificationActivityKt.KEY_VERIFICATION_TYPE);
        Intrinsics.checkNotNull(stringExtra);
        b(VerificationStatusFragment.Companion.newInstance(stringExtra), VerificationActivityKt.TAG_VERIFICATION_STATUS, z);
    }

    public final void b(Fragment fragment, String str, boolean z) {
        FragmentTransaction replace = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment, str);
        if (z) {
            replace.addToBackStack(str);
        }
        replace.commit();
    }

    @Override // com.avito.android.verification.verification_status.VerificationStatusFragment.VerificationsStatusRouter
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.verification_activity;
    }

    @Override // com.avito.android.verification.verifications_list.VerificationsListFragment.VerificationsListRouter
    public void navigateToVerificationStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        b(VerificationStatusFragment.Companion.newInstance(str), VerificationActivityKt.TAG_VERIFICATION_STATUS, true);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1);
        super.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            a(getIntent(), false);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        a(intent, true);
    }
}

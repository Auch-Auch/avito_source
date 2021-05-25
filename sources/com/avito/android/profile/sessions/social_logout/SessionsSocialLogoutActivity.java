package com.avito.android.profile.sessions.social_logout;

import android.content.Intent;
import android.os.Bundle;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutFragment;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Constants;
import com.sumsub.sns.core.common.SNSConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", "<init>", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsSocialLogoutActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent upIntent = getUpIntent();
        if (upIntent != null) {
            startActivity(upIntent);
        }
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            SessionsSocialLogoutFragment.Companion companion = SessionsSocialLogoutFragment.Companion;
            String stringExtra = getIntent().getStringExtra("source");
            String stringExtra2 = getIntent().getStringExtra("user_id");
            String stringExtra3 = getIntent().getStringExtra("login_type");
            String stringExtra4 = getIntent().getStringExtra("session_id_hash");
            String stringExtra5 = getIntent().getStringExtra(SNSConstants.Preference.KEY_DEVICE_ID);
            Intrinsics.checkNotNullExpressionValue(stringExtra5, "intent.getStringExtra(EXTRA_DEVICE_ID)");
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, companion.newInstance(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, (Intent) getIntent().getParcelableExtra(Constants.UP_INTENT)), "sessions_social_logout_tag").commit();
        }
    }
}

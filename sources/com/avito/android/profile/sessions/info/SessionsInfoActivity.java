package com.avito.android.profile.sessions.info;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/sessions/info/SessionsInfoActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", "<init>", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsInfoActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("sessions_info_tag");
        if (!(findFragmentByTag instanceof SessionsInfoFragment)) {
            findFragmentByTag = null;
        }
        SessionsInfoFragment sessionsInfoFragment = (SessionsInfoFragment) findFragmentByTag;
        if (sessionsInfoFragment != null) {
            sessionsInfoFragment.navigateToSessionsList();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        SessionsInfoFragment sessionsInfoFragment;
        super.onCreate(bundle);
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            Intent intent = getIntent();
            if (intent == null || !intent.getBooleanExtra("password_change", false)) {
                sessionsInfoFragment = SessionsInfoFragment.Companion.newInstanceForLogout();
            } else {
                sessionsInfoFragment = SessionsInfoFragment.Companion.newInstanceForPasswordChange();
            }
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, sessionsInfoFragment, "sessions_info_tag").commit();
        }
    }
}

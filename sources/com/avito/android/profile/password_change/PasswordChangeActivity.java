package com.avito.android.profile.password_change;

import android.content.Intent;
import android.os.Bundle;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/password_change/PasswordChangeActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", "<init>", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordChangeActivity extends BaseActivity {
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
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, PasswordChangeFragment.Companion.newInstance(getIntent().getBooleanExtra("is_sessions_flow", false), getIntent().getStringExtra("extra_source"), getIntent().getStringExtra("extra_login"), getIntent().getStringExtra("extra_login_type"), getIntent().getStringExtra("extra_session_id_hash"), getIntent().getStringExtra("extra_device_id"), getIntent().getStringExtra("extra_user_id"), (Intent) getIntent().getParcelableExtra(Constants.UP_INTENT)), "change_password_tag").commit();
        }
    }
}

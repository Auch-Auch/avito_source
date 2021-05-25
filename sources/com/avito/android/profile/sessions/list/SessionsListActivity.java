package com.avito.android.profile.sessions.list;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionsListActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onBackPressed", "()V", "<init>", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsListActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("sessions_list_tag");
        if (!(findFragmentByTag instanceof SessionsListFragment)) {
            findFragmentByTag = null;
        }
        SessionsListFragment sessionsListFragment = (SessionsListFragment) findFragmentByTag;
        if (sessionsListFragment != null) {
            sessionsListFragment.closeScreen();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, SessionsListFragment.Companion.newInstance(getIntent().getStringExtra("source")), "sessions_list_tag").commit();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("sessions_list_tag");
        if (!(findFragmentByTag instanceof SessionsListFragment)) {
            findFragmentByTag = null;
        }
        SessionsListFragment sessionsListFragment = (SessionsListFragment) findFragmentByTag;
        if (sessionsListFragment != null) {
            sessionsListFragment.loadData();
        }
    }
}

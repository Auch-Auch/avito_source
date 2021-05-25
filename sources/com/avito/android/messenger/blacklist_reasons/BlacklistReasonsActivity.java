package com.avito.android.messenger.blacklist_reasons;

import android.content.Intent;
import android.os.Bundle;
import com.avito.android.messenger.R;
import com.avito.android.ui.activity.BaseActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "getContentLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistReasonsActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.messenger_blacklist_reasons_activity;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        String str = null;
        String stringExtra = intent != null ? intent.getStringExtra("user_id") : null;
        if (stringExtra != null) {
            Intent intent2 = getIntent();
            String stringExtra2 = intent2 != null ? intent2.getStringExtra("channel_id") : null;
            if (stringExtra2 != null) {
                Intent intent3 = getIntent();
                if (intent3 != null) {
                    str = intent3.getStringExtra("item_id");
                }
                super.onCreate(bundle);
                if (bundle == null) {
                    getSupportFragmentManager().beginTransaction().add(R.id.messenger_blacklist_reasons_screen_root, BlacklistReasonsActivityKt.access$createBlacklistReasonsFragment(stringExtra, stringExtra2, str)).commit();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Channel id is required".toString());
        }
        throw new IllegalArgumentException("User id is required".toString());
    }
}

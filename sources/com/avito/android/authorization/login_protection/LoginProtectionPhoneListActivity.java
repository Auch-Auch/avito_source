package com.avito.android.authorization.login_protection;

import android.content.Intent;
import android.os.Bundle;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListFragment;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginProtectionPhoneListActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            LoginProtectionPhoneListFragment.Companion companion = LoginProtectionPhoneListFragment.Companion;
            Intent intent = getIntent();
            String str2 = null;
            List<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("extra_phones") : null;
            if (stringArrayListExtra == null) {
                stringArrayListExtra = CollectionsKt__CollectionsKt.emptyList();
            }
            Intent intent2 = getIntent();
            if (intent2 == null || (str = intent2.getStringExtra("challenge_id")) == null) {
                str = "";
            }
            Intent intent3 = getIntent();
            if (intent3 != null) {
                str2 = intent3.getStringExtra("login");
            }
            Intent intent4 = getIntent();
            boolean z = true;
            if (intent4 != null) {
                z = intent4.getBooleanExtra(LoginProtectionPhoneListActivityKt.EXTRA_IS_ANTIHACK_MODE, true);
            }
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, companion.newInstance(stringArrayListExtra, str2, str, z), "antihack_tag").commit();
        }
    }
}

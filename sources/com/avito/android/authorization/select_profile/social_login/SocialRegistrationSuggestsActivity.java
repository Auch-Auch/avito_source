package com.avito.android.authorization.select_profile.social_login;

import android.os.Bundle;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsFragment;
import com.avito.android.social.SocialActivity;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SocialRegistrationSuggestsActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            SocialRegistrationSuggestsFragment.Companion companion = SocialRegistrationSuggestsFragment.Companion;
            String stringExtra = getIntent().getStringExtra("extra_title");
            if (stringExtra != null) {
                String stringExtra2 = getIntent().getStringExtra("extra_suggest_key");
                if (stringExtra2 != null) {
                    ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("extra_profiles");
                    if (parcelableArrayListExtra != null) {
                        String stringExtra3 = getIntent().getStringExtra(SocialActivity.EXTRA_SOCIAL_TYPE);
                        if (stringExtra3 != null) {
                            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, companion.newInstance(stringExtra, stringExtra2, parcelableArrayListExtra, stringExtra3), "select_profile_social_tag").commit();
                            return;
                        }
                        throw new IllegalStateException("Social type must not be null");
                    }
                    throw new IllegalStateException("Profiles must not be null");
                }
                throw new IllegalStateException("Suggest key  must not be null");
            }
            throw new IllegalStateException("Title must not be null");
        }
    }
}

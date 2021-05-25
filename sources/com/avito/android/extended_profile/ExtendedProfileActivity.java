package com.avito.android.extended_profile;

import android.content.Intent;
import android.os.Bundle;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "<init>", "()V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        ExtendedProfileArguments extendedProfileArguments;
        super.onCreate(bundle);
        if (bundle == null) {
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            Bundle extras = intent.getExtras();
            if (extras == null || (extendedProfileArguments = (ExtendedProfileArguments) extras.getParcelable("extra_args")) == null) {
                throw new IllegalArgumentException("Arguments must be specified");
            }
            Intrinsics.checkNotNullExpressionValue(extendedProfileArguments, "intent.extras?.getParcel…ments must be specified\")");
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, ExtendedProfileFragment.Companion.newInstance(extendedProfileArguments)).commitAllowingStateLoss();
        }
    }
}

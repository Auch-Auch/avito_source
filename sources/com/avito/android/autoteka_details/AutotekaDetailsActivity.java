package com.avito.android.autoteka_details;

import android.os.Bundle;
import com.avito.android.autoteka_details.AutotekaDetailsFragment;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaDetailsActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra("autoteka_id");
            String stringExtra2 = getIntent().getStringExtra("autoteka_utm_query");
            AutotekaDetailsFragment.Factory factory = new AutotekaDetailsFragment.Factory();
            Intrinsics.checkNotNullExpressionValue(stringExtra, "id");
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, factory.createInstance(stringExtra, (AutotekaDetailsResponse) getIntent().getParcelableExtra("autoteka_details"), stringExtra2)).commitAllowingStateLoss();
        }
    }
}

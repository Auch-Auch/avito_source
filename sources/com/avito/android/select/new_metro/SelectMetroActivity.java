package com.avito.android.select.new_metro;

import android.os.Bundle;
import android.os.Parcelable;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.select.new_metro.di.DaggerSelectMetroActivityComponent;
import com.avito.android.select.new_metro.di.SelectMetroActivityComponent;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Activities;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/select/new_metro/SelectMetroActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectMetroActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            Parcelable parcelableExtra = getIntent().getParcelableExtra("new_metro_arguments");
            if (parcelableExtra != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, SelectMetroFragment.Companion.newInstance(null, (SelectMetroParams) parcelableExtra), "select_dialog_tag").commitAllowingStateLoss();
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        SelectMetroActivityComponent.Builder builder = DaggerSelectMetroActivityComponent.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "DaggerSelectMetroActivityComponent.builder()");
        builder.setDependencies((CoreComponentDependencies) Activities.appComponent(this)).build().inject(this);
        return true;
    }
}

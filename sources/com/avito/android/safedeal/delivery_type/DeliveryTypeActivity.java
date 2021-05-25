package com.avito.android.safedeal.delivery_type;

import android.os.Bundle;
import android.os.Parcelable;
import com.avito.android.safedeal.R;
import com.avito.android.ui.activity.BaseActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "setUpCustomToolbar", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryTypeActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.delivery_type_screen;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Parcelable parcelableExtra = getIntent().getParcelableExtra(DeliveryTypeActivityKt.KEY_EXTRA_DELIVERY_TYPE_DATA);
        if (parcelableExtra != null) {
            DeliveryTypeData deliveryTypeData = (DeliveryTypeData) parcelableExtra;
            if (bundle == null) {
                getSupportFragmentManager().beginTransaction().add(com.avito.android.ui_components.R.id.fragment_container, DeliveryTypeFragment.Companion.newInstance(deliveryTypeData)).commit();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("delivery_type_data was not passed to " + this).toString());
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}

package com.avito.android.delivery.suggest;

import android.os.Bundle;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.delivery.R;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment;
import com.avito.android.ui.activity.BaseActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", "<init>", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryLocationSuggestActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rds_delivery_activity_location_suggest);
        if (bundle == null) {
            AvitoMapBounds avitoMapBounds = (AvitoMapBounds) getIntent().getParcelableExtra(DeliveryLocationSuggestActivityKt.EXTRA_VISIBLE_REGION);
            if (avitoMapBounds != null) {
                getSupportFragmentManager().beginTransaction().add(com.avito.android.ui_components.R.id.fragment_container, new DeliveryLocationSuggestFragment.Factory().createInstance(avitoMapBounds)).addToBackStack(null).commit();
                return;
            }
            throw new IllegalArgumentException("Visible region not found");
        }
    }
}

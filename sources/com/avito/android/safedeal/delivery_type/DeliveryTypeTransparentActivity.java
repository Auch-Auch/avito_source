package com.avito.android.safedeal.delivery_type;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.safedeal.delivery_courier.ScreenStyle;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeTransparentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryTypeTransparentActivity extends AppCompatActivity {
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Parcelable parcelableExtra = getIntent().getParcelableExtra(DeliveryTypeActivityKt.KEY_EXTRA_DELIVERY_TYPE_DATA);
        if (parcelableExtra != null) {
            DeliveryTypeData deliveryTypeData = (DeliveryTypeData) parcelableExtra;
            if (deliveryTypeData.getStyle() != ScreenStyle.BOTTOM_SHEET) {
                setTheme(R.style.Theme_Avito);
            }
            super.onCreate(bundle);
            setContentView(com.avito.android.safedeal.R.layout.delivery_type_screen);
            if (bundle == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, DeliveryTypeFragment.Companion.newInstance(deliveryTypeData)).commit();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("delivery_type_data was not passed to " + this).toString());
    }
}

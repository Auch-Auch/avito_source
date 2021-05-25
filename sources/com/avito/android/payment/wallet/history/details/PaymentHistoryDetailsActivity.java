package com.avito.android.payment.wallet.history.details;

import android.os.Bundle;
import com.avito.android.payment.wallet.history.details.HistoryDetailsBottomSheetDialogFragment;
import com.avito.android.ui.activity.BaseActivity;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryDetailsActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("EXTRA_PAYMENT_DETAILS_TYPE");
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.avito.android.payment.wallet.history.details.PaymentDetailsType");
            String stringExtra = getIntent().getStringExtra("EXTRA_PAYMENT_DETAILS_ID");
            HistoryDetailsBottomSheetDialogFragment.Companion companion = HistoryDetailsBottomSheetDialogFragment.Companion;
            Intrinsics.checkNotNullExpressionValue(stringExtra, "id");
            companion.create((PaymentDetailsType) serializableExtra, stringExtra).show(getSupportFragmentManager(), (String) null);
        }
    }
}

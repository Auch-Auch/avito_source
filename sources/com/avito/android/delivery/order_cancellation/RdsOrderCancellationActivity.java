package com.avito.android.delivery.order_cancellation;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.delivery.R;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ReasonRds;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Keyboards;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", "", "activityResult", "forceLeaveScreen", "(I)V", "Lcom/avito/android/remote/model/ReasonRds;", "reason", "commentMaxLength", "openReasonDetailsScreen", "(Lcom/avito/android/remote/model/ReasonRds;I)V", "Landroidx/fragment/app/Fragment;", "fragment", AuthSource.SEND_ABUSE, "(Landroidx/fragment/app/Fragment;)V", "<init>", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class RdsOrderCancellationActivity extends BaseActivity implements RdsOrderCancellationRouter {
    public final void a(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).addToBackStack(fragment instanceof ReasonDetailsFragment ? ErrorBundle.DETAIL_ENTRY : "reasons").setTransition(4097).commit();
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationRouter
    public void forceLeaveScreen(int i) {
        Keyboards.hideKeyboard(this);
        if (i == 0) {
            setResult(0, getIntent());
        } else {
            setResult(i);
        }
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() > 1) {
            Keyboards.hideKeyboard(this);
            getSupportFragmentManager().popBackStack();
            return;
        }
        setResult(-1);
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.delivery_rds_order_cancellation_activity);
        if (bundle == null) {
            RdsOrderCancellationReasonsFragment.Factory factory = new RdsOrderCancellationReasonsFragment.Factory();
            String stringExtra = getIntent().getStringExtra("EXTRA_ORDER_ID");
            if (stringExtra != null) {
                a(factory.createInstance(stringExtra));
                return;
            }
            throw new IllegalStateException("An order id was expected");
        }
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationRouter
    public void openReasonDetailsScreen(@NotNull ReasonRds reasonRds, int i) {
        String stringExtra;
        Intrinsics.checkNotNullParameter(reasonRds, "reason");
        ReasonDetailsFragment.Factory factory = new ReasonDetailsFragment.Factory();
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("EXTRA_ORDER_ID")) == null) {
            throw new IllegalStateException("An order id was expected");
        }
        a(factory.createInstance(reasonRds, stringExtra, i));
    }
}

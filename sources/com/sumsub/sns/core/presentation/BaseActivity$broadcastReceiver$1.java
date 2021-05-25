package com.sumsub.sns.core.presentation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sumsub.sns.core.common.SNSConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/sumsub/sns/core/presentation/BaseActivity$broadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class BaseActivity$broadcastReceiver$1 extends BroadcastReceiver {
    public final /* synthetic */ BaseActivity a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public BaseActivity$broadcastReceiver$1(BaseActivity baseActivity) {
        this.a = baseActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, SNSConstants.Intent.SNS_ACTION_CLOSE)) {
            Timber.d("ACTION_CLOSE received. Finishing...", new Object[0]);
            this.a.onClose();
        }
    }
}

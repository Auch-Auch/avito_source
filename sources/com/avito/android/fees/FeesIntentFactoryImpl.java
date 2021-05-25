package com.avito.android.fees;

import android.content.Context;
import android.content.Intent;
import com.avito.android.FeesIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.fees.FeesActivity;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/fees/FeesIntentFactoryImpl;", "Lcom/avito/android/FeesIntentFactory;", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "isFromPublish", "skipSuccessDialogAfterPayment", "Landroid/content/Intent;", "feesIntent", "(Ljava/lang/String;ZZ)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class FeesIntentFactoryImpl implements FeesIntentFactory {
    public final Context a;

    @Inject
    public FeesIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.FeesIntentFactory
    @NotNull
    public Intent feesIntent(@NotNull String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return FeesActivity.IntentFactory.create$default(new FeesActivity.IntentFactory(), this.a, str, z, z2, null, 16, null);
    }
}

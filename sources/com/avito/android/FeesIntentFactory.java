package com.avito.android;

import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/FeesIntentFactory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "isFromPublish", "skipSuccessDialogAfterPayment", "Landroid/content/Intent;", "feesIntent", "(Ljava/lang/String;ZZ)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface FeesIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent feesIntent$default(FeesIntentFactory feesIntentFactory, String str, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                if ((i & 4) != 0) {
                    z2 = false;
                }
                return feesIntentFactory.feesIntent(str, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: feesIntent");
        }
    }

    @NotNull
    Intent feesIntent(@NotNull String str, boolean z, boolean z2);
}

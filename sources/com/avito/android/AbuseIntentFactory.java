package com.avito.android;

import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.Action;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¢\u0006\u0004\b\t\u0010\nJ=\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/AbuseIntentFactory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "src", "", "Lcom/avito/android/remote/model/Action;", "actions", "Landroid/content/Intent;", "abuseCategoryIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Landroid/content/Intent;", "", "abuseCategoryId", "itemId", "abuseDetails", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)Landroid/content/Intent;", "authQueryIntent", "()Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface AbuseIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.avito.android.AbuseIntentFactory */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Intent abuseCategoryIntent$default(AbuseIntentFactory abuseIntentFactory, String str, String str2, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    list = null;
                }
                return abuseIntentFactory.abuseCategoryIntent(str, str2, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: abuseCategoryIntent");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.avito.android.AbuseIntentFactory */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Intent abuseDetails$default(AbuseIntentFactory abuseIntentFactory, int i, String str, String str2, List list, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    str2 = null;
                }
                if ((i2 & 8) != 0) {
                    list = null;
                }
                return abuseIntentFactory.abuseDetails(i, str, str2, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: abuseDetails");
        }
    }

    @NotNull
    Intent abuseCategoryIntent(@NotNull String str, @Nullable String str2, @Nullable List<Action> list);

    @NotNull
    Intent abuseDetails(int i, @NotNull String str, @Nullable String str2, @Nullable List<Action> list);

    @NotNull
    Intent authQueryIntent();
}

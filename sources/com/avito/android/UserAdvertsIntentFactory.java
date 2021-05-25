package com.avito.android;

import android.content.Intent;
import com.avito.android.user_advert.AdvertActionTransferData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/UserAdvertsIntentFactory;", "", "", "shortcut", "Lcom/avito/android/user_advert/AdvertActionTransferData;", "advertAction", "", "openPublish", "Landroid/content/Intent;", "createUserAdvertsIntent", "(Ljava/lang/String;Lcom/avito/android/user_advert/AdvertActionTransferData;Z)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertsIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent createUserAdvertsIntent$default(UserAdvertsIntentFactory userAdvertsIntentFactory, String str, AdvertActionTransferData advertActionTransferData, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    advertActionTransferData = null;
                }
                if ((i & 4) != 0) {
                    z = false;
                }
                return userAdvertsIntentFactory.createUserAdvertsIntent(str, advertActionTransferData, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createUserAdvertsIntent");
        }
    }

    @NotNull
    Intent createUserAdvertsIntent(@Nullable String str, @Nullable AdvertActionTransferData advertActionTransferData, boolean z);
}

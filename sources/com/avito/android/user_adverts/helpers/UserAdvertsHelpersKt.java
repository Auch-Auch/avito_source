package com.avito.android.user_adverts.helpers;

import android.content.Intent;
import android.os.Bundle;
import com.avito.android.user_advert.AdvertActionTransferData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/content/Intent;", "Lcom/avito/android/user_advert/AdvertActionTransferData;", "action", "", "putAdvertActionTransferData", "(Landroid/content/Intent;Lcom/avito/android/user_advert/AdvertActionTransferData;)V", "getAdvertActionTransferData", "(Landroid/content/Intent;)Lcom/avito/android/user_advert/AdvertActionTransferData;", "user-adverts_release"}, k = 2, mv = {1, 4, 2})
public final class UserAdvertsHelpersKt {
    @Nullable
    public static final AdvertActionTransferData getAdvertActionTransferData(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getAdvertActionTransferData");
        Bundle extras = intent.getExtras();
        boolean z = false;
        boolean containsKey = extras != null ? extras.containsKey("advert_action_message") : false;
        Bundle extras2 = intent.getExtras();
        boolean containsKey2 = extras2 != null ? extras2.containsKey("advert_action_category_id") : false;
        Bundle extras3 = intent.getExtras();
        if (extras3 != null) {
            z = extras3.containsKey("advert_action_action_type");
        }
        AdvertActionTransferData.Type type = null;
        if (!containsKey && !containsKey2 && !z) {
            return null;
        }
        Bundle extras4 = intent.getExtras();
        String string = extras4 != null ? extras4.getString("advert_action_message") : null;
        Bundle extras5 = intent.getExtras();
        String string2 = extras5 != null ? extras5.getString("advert_action_category_id") : null;
        Bundle extras6 = intent.getExtras();
        Serializable serializable = extras6 != null ? extras6.getSerializable("advert_action_action_type") : null;
        if (serializable instanceof AdvertActionTransferData.Type) {
            type = serializable;
        }
        return new AdvertActionTransferData(null, string, string2, type, 1, null);
    }

    public static final void putAdvertActionTransferData(@NotNull Intent intent, @NotNull AdvertActionTransferData advertActionTransferData) {
        Intrinsics.checkNotNullParameter(intent, "$this$putAdvertActionTransferData");
        Intrinsics.checkNotNullParameter(advertActionTransferData, "action");
        intent.putExtra("advert_action_message", advertActionTransferData.getMessage());
        intent.putExtra("advert_action_category_id", advertActionTransferData.getCategoryId());
        intent.putExtra("advert_action_action_type", advertActionTransferData.getActionType());
    }
}

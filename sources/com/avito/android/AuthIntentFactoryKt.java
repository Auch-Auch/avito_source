package com.avito.android;

import android.content.Intent;
import android.os.Parcelable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/content/Intent;", "Landroid/os/Parcelable;", "getSuccessAuthResultData", "(Landroid/content/Intent;)Landroid/os/Parcelable;", "core_release"}, k = 2, mv = {1, 4, 2})
public final class AuthIntentFactoryKt {
    @Nullable
    public static final Parcelable getSuccessAuthResultData(@Nullable Intent intent) {
        if (intent != null) {
            return intent.getParcelableExtra("SuccessAuthResultData");
        }
        return null;
    }
}

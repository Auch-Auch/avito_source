package com.avito.android.util.architecture_components;

import android.content.Intent;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/architecture_components/IntentDataHolder;", "", "Landroid/content/Intent;", AuthSource.SEND_ABUSE, "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "intent", "", AuthSource.BOOKING_ORDER, "Z", "getShouldFinish", "()Z", "shouldFinish", "<init>", "(Landroid/content/Intent;Z)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class IntentDataHolder {
    @NotNull
    public final Intent a;
    public final boolean b;

    public IntentDataHolder(@NotNull Intent intent, boolean z) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.a = intent;
        this.b = z;
    }

    @NotNull
    public final Intent getIntent() {
        return this.a;
    }

    public final boolean getShouldFinish() {
        return this.b;
    }
}

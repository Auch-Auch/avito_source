package com.avito.android.messenger.conversation.mvi.deeplinks;

import a2.b.a.a.a;
import android.content.Intent;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/ActivityResult;", "", "", "component1", "()I", "component2", "Landroid/content/Intent;", "component3", "()Landroid/content/Intent;", "requestCode", "resultCode", "data", "copy", "(IILandroid/content/Intent;)Lcom/avito/android/messenger/conversation/mvi/deeplinks/ActivityResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Landroid/content/Intent;", "getData", AuthSource.SEND_ABUSE, "I", "getRequestCode", AuthSource.BOOKING_ORDER, "getResultCode", "<init>", "(IILandroid/content/Intent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ActivityResult {
    public final int a;
    public final int b;
    @Nullable
    public final Intent c;

    public ActivityResult(int i, int i2, @Nullable Intent intent) {
        this.a = i;
        this.b = i2;
        this.c = intent;
    }

    public static /* synthetic */ ActivityResult copy$default(ActivityResult activityResult, int i, int i2, Intent intent, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = activityResult.a;
        }
        if ((i3 & 2) != 0) {
            i2 = activityResult.b;
        }
        if ((i3 & 4) != 0) {
            intent = activityResult.c;
        }
        return activityResult.copy(i, i2, intent);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @Nullable
    public final Intent component3() {
        return this.c;
    }

    @NotNull
    public final ActivityResult copy(int i, int i2, @Nullable Intent intent) {
        return new ActivityResult(i, i2, intent);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityResult)) {
            return false;
        }
        ActivityResult activityResult = (ActivityResult) obj;
        return this.a == activityResult.a && this.b == activityResult.b && Intrinsics.areEqual(this.c, activityResult.c);
    }

    @Nullable
    public final Intent getData() {
        return this.c;
    }

    public final int getRequestCode() {
        return this.a;
    }

    public final int getResultCode() {
        return this.b;
    }

    public int hashCode() {
        int i = ((this.a * 31) + this.b) * 31;
        Intent intent = this.c;
        return i + (intent != null ? intent.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ActivityResult(requestCode=");
        L.append(this.a);
        L.append(", resultCode=");
        L.append(this.b);
        L.append(", data=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}

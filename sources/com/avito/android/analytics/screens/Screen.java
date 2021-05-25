package com.avito.android.analytics.screens;

import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/analytics/screens/Screen;", "Landroid/os/Parcelable;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "", AuthSource.BOOKING_ORDER, "Z", "getHasSmallEventsCount", "()Z", "hasSmallEventsCount", "<init>", "(Ljava/lang/String;Z)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public abstract class Screen implements Parcelable {
    @NotNull
    public final String a;
    public final boolean b;

    public Screen(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = str;
        this.b = z;
    }

    public final boolean getHasSmallEventsCount() {
        return this.b;
    }

    @NotNull
    public final String getName() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Screen(String str, boolean z, int i, j jVar) {
        this(str, (i & 2) != 0 ? true : z);
    }
}

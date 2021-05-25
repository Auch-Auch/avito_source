package com.avito.android.analytics.sideload;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.event.ErrorWithExtras;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.applinks.AppLinkData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004JB\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010!\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0018R(\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/analytics/sideload/SideloadResourceNotFoundError;", "Lcom/avito/android/analytics/event/ErrorWithExtras;", "", "component5", "()Ljava/lang/Throwable;", "", "className", "method", "resourceName", "", "isSideload", "cause", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Throwable;)Lcom/avito/android/analytics/sideload/SideloadResourceNotFoundError;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "e", "f", "Z", g.a, "Ljava/lang/Throwable;", "getCause", AuthSource.SEND_ABUSE, "getMessage", "message", "c", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Throwable;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class SideloadResourceNotFoundError extends ErrorWithExtras {
    @NotNull
    public final String a;
    @NotNull
    public final Map<String, Object> b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    @NotNull
    public final Throwable g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SideloadResourceNotFoundError(String str, String str2, String str3, boolean z, Throwable th, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? "" : str3, z, th);
    }

    public static /* synthetic */ SideloadResourceNotFoundError copy$default(SideloadResourceNotFoundError sideloadResourceNotFoundError, String str, String str2, String str3, boolean z, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sideloadResourceNotFoundError.c;
        }
        if ((i & 2) != 0) {
            str2 = sideloadResourceNotFoundError.d;
        }
        if ((i & 4) != 0) {
            str3 = sideloadResourceNotFoundError.e;
        }
        if ((i & 8) != 0) {
            z = sideloadResourceNotFoundError.f;
        }
        if ((i & 16) != 0) {
            th = sideloadResourceNotFoundError.getCause();
        }
        return sideloadResourceNotFoundError.copy(str, str2, str3, z, th);
    }

    @NotNull
    public final Throwable component5() {
        return getCause();
    }

    @NotNull
    public final SideloadResourceNotFoundError copy(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, "method");
        Intrinsics.checkNotNullParameter(str3, "resourceName");
        Intrinsics.checkNotNullParameter(th, "cause");
        return new SideloadResourceNotFoundError(str, str2, str3, z, th);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SideloadResourceNotFoundError)) {
            return false;
        }
        SideloadResourceNotFoundError sideloadResourceNotFoundError = (SideloadResourceNotFoundError) obj;
        return Intrinsics.areEqual(this.c, sideloadResourceNotFoundError.c) && Intrinsics.areEqual(this.d, sideloadResourceNotFoundError.d) && Intrinsics.areEqual(this.e, sideloadResourceNotFoundError.e) && this.f == sideloadResourceNotFoundError.f && Intrinsics.areEqual(getCause(), sideloadResourceNotFoundError.getCause());
    }

    @Override // com.avito.android.analytics.event.ErrorWithExtras, java.lang.Throwable
    @NotNull
    public Throwable getCause() {
        return this.g;
    }

    @Override // com.avito.android.analytics.event.ErrorWithExtras
    @NotNull
    public Map<String, Object> getExtras() {
        return this.b;
    }

    @Override // com.avito.android.analytics.event.ErrorWithExtras, java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.c;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.f;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode3 + i2) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i = cause.hashCode();
        }
        return i5 + i;
    }

    @Override // java.lang.Throwable, java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SideloadResourceNotFoundError(className=");
        L.append(this.c);
        L.append(", method=");
        L.append(this.d);
        L.append(", resourceName=");
        L.append(this.e);
        L.append(", isSideload=");
        L.append(this.f);
        L.append(", cause=");
        L.append(getCause());
        L.append(")");
        return L.toString();
    }

    public SideloadResourceNotFoundError(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, "method");
        Intrinsics.checkNotNullParameter(str3, "resourceName");
        Intrinsics.checkNotNullParameter(th, "cause");
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = z;
        this.g = th;
        StringBuilder W = a.W("Not found resource in <", str, "> in method: <", str2, "> with resource: <");
        W.append(str3);
        W.append(">. Is sideload: ");
        W.append(z);
        this.a = W.toString();
        this.b = q.mapOf(TuplesKt.to("Sideload", "catch"));
    }
}

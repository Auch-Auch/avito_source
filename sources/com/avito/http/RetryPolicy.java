package com.avito.http;

import androidx.browser.trusted.sharing.ShareTarget;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\b\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jd\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\r2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u001a\u0010 \u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0017\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\fR%\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0013R\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\bR\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010)\u001a\u0004\b,\u0010\bR\u0019\u0010\u0018\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u000fR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0004¨\u00065"}, d2 = {"Lcom/avito/http/RetryPolicy;", "", "", "component1", "()I", "", "", "component2", "()Ljava/util/List;", "component3", "", "component4", "()J", "", "component5", "()Z", "Lkotlin/Function1;", "Lokhttp3/Request;", "component6", "()Lkotlin/jvm/functions/Function1;", "tries", "allowedMethods", "allowedCodes", "delayBetweenTriesMs", "useIncreasingDelay", "modifyRetryRequest", "copy", "(ILjava/util/List;Ljava/util/List;JZLkotlin/jvm/functions/Function1;)Lcom/avito/http/RetryPolicy;", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "d", "J", "getDelayBetweenTriesMs", "f", "Lkotlin/jvm/functions/Function1;", "getModifyRetryRequest", "c", "Ljava/util/List;", "getAllowedCodes", AuthSource.BOOKING_ORDER, "getAllowedMethods", "e", "Z", "getUseIncreasingDelay", AuthSource.SEND_ABUSE, "I", "getTries", "<init>", "(ILjava/util/List;Ljava/util/List;JZLkotlin/jvm/functions/Function1;)V", "okhttp"}, k = 1, mv = {1, 4, 2})
public final class RetryPolicy {
    public final int a;
    @NotNull
    public final List<String> b;
    @NotNull
    public final List<Integer> c;
    public final long d;
    public final boolean e;
    @NotNull
    public final Function1<Request, Request> f;

    public static final class a extends Lambda implements Function1<Request, Request> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Request invoke(Request request) {
            Request request2 = request;
            Intrinsics.checkNotNullParameter(request2, "it");
            return request2;
        }
    }

    public RetryPolicy() {
        this(0, null, null, 0, false, null, 63, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kotlin.jvm.functions.Function1<? super okhttp3.Request, okhttp3.Request> */
    /* JADX WARN: Multi-variable type inference failed */
    public RetryPolicy(int i, @NotNull List<String> list, @NotNull List<Integer> list2, long j, boolean z, @NotNull Function1<? super Request, Request> function1) {
        Intrinsics.checkNotNullParameter(list, "allowedMethods");
        Intrinsics.checkNotNullParameter(list2, "allowedCodes");
        Intrinsics.checkNotNullParameter(function1, "modifyRetryRequest");
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = j;
        this.e = z;
        this.f = function1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.http.RetryPolicy */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RetryPolicy copy$default(RetryPolicy retryPolicy, int i, List list, List list2, long j, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = retryPolicy.a;
        }
        if ((i2 & 2) != 0) {
            list = retryPolicy.b;
        }
        if ((i2 & 4) != 0) {
            list2 = retryPolicy.c;
        }
        if ((i2 & 8) != 0) {
            j = retryPolicy.d;
        }
        if ((i2 & 16) != 0) {
            z = retryPolicy.e;
        }
        if ((i2 & 32) != 0) {
            function1 = retryPolicy.f;
        }
        return retryPolicy.copy(i, list, list2, j, z, function1);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final List<String> component2() {
        return this.b;
    }

    @NotNull
    public final List<Integer> component3() {
        return this.c;
    }

    public final long component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @NotNull
    public final Function1<Request, Request> component6() {
        return this.f;
    }

    @NotNull
    public final RetryPolicy copy(int i, @NotNull List<String> list, @NotNull List<Integer> list2, long j, boolean z, @NotNull Function1<? super Request, Request> function1) {
        Intrinsics.checkNotNullParameter(list, "allowedMethods");
        Intrinsics.checkNotNullParameter(list2, "allowedCodes");
        Intrinsics.checkNotNullParameter(function1, "modifyRetryRequest");
        return new RetryPolicy(i, list, list2, j, z, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetryPolicy)) {
            return false;
        }
        RetryPolicy retryPolicy = (RetryPolicy) obj;
        return this.a == retryPolicy.a && Intrinsics.areEqual(this.b, retryPolicy.b) && Intrinsics.areEqual(this.c, retryPolicy.c) && this.d == retryPolicy.d && this.e == retryPolicy.e && Intrinsics.areEqual(this.f, retryPolicy.f);
    }

    @NotNull
    public final List<Integer> getAllowedCodes() {
        return this.c;
    }

    @NotNull
    public final List<String> getAllowedMethods() {
        return this.b;
    }

    public final long getDelayBetweenTriesMs() {
        return this.d;
    }

    @NotNull
    public final Function1<Request, Request> getModifyRetryRequest() {
        return this.f;
    }

    public final int getTries() {
        return this.a;
    }

    public final boolean getUseIncreasingDelay() {
        return this.e;
    }

    public int hashCode() {
        int i = this.a * 31;
        List<String> list = this.b;
        int i2 = 0;
        int hashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<Integer> list2 = this.c;
        int hashCode2 = (((hashCode + (list2 != null ? list2.hashCode() : 0)) * 31) + c.a(this.d)) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode2 + i3) * 31;
        Function1<Request, Request> function1 = this.f;
        if (function1 != null) {
            i2 = function1.hashCode();
        }
        return i6 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("RetryPolicy(tries=");
        L.append(this.a);
        L.append(", allowedMethods=");
        L.append(this.b);
        L.append(", allowedCodes=");
        L.append(this.c);
        L.append(", delayBetweenTriesMs=");
        L.append(this.d);
        L.append(", useIncreasingDelay=");
        L.append(this.e);
        L.append(", modifyRetryRequest=");
        L.append(this.f);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RetryPolicy(int i, List list, List list2, long j, boolean z, Function1 function1, int i2, j jVar) {
        this((i2 & 1) != 0 ? 5 : i, (i2 & 2) != 0 ? d.listOf(ShareTarget.METHOD_GET) : list, (i2 & 4) != 0 ? CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{408, 500, 502, 503, 504}) : list2, (i2 & 8) != 0 ? 1000 : j, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? a.a : function1);
    }
}

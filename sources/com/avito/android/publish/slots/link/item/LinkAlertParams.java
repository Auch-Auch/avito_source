package com.avito.android.publish.slots.link.item;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJJ\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/publish/slots/link/item/LinkAlertParams;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lkotlin/Function0;", "", "component5", "()Lkotlin/jvm/functions/Function0;", "title", "message", "confirmText", "cancelText", "confirmListener", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lcom/avito/android/publish/slots/link/item/LinkAlertParams;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "e", "Lkotlin/jvm/functions/Function0;", "getConfirmListener", "d", "getCancelText", "c", "getConfirmText", AuthSource.BOOKING_ORDER, "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class LinkAlertParams {
    @Nullable
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final Function0<Unit> e;

    public LinkAlertParams(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "confirmText");
        Intrinsics.checkNotNullParameter(str4, "cancelText");
        Intrinsics.checkNotNullParameter(function0, "confirmListener");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = function0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.publish.slots.link.item.LinkAlertParams */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LinkAlertParams copy$default(LinkAlertParams linkAlertParams, String str, String str2, String str3, String str4, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = linkAlertParams.a;
        }
        if ((i & 2) != 0) {
            str2 = linkAlertParams.b;
        }
        if ((i & 4) != 0) {
            str3 = linkAlertParams.c;
        }
        if ((i & 8) != 0) {
            str4 = linkAlertParams.d;
        }
        if ((i & 16) != 0) {
            function0 = linkAlertParams.e;
        }
        return linkAlertParams.copy(str, str2, str3, str4, function0);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final Function0<Unit> component5() {
        return this.e;
    }

    @NotNull
    public final LinkAlertParams copy(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "confirmText");
        Intrinsics.checkNotNullParameter(str4, "cancelText");
        Intrinsics.checkNotNullParameter(function0, "confirmListener");
        return new LinkAlertParams(str, str2, str3, str4, function0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkAlertParams)) {
            return false;
        }
        LinkAlertParams linkAlertParams = (LinkAlertParams) obj;
        return Intrinsics.areEqual(this.a, linkAlertParams.a) && Intrinsics.areEqual(this.b, linkAlertParams.b) && Intrinsics.areEqual(this.c, linkAlertParams.c) && Intrinsics.areEqual(this.d, linkAlertParams.d) && Intrinsics.areEqual(this.e, linkAlertParams.e);
    }

    @NotNull
    public final String getCancelText() {
        return this.d;
    }

    @NotNull
    public final Function0<Unit> getConfirmListener() {
        return this.e;
    }

    @NotNull
    public final String getConfirmText() {
        return this.c;
    }

    @NotNull
    public final String getMessage() {
        return this.b;
    }

    @Nullable
    public final String getTitle() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Function0<Unit> function0 = this.e;
        if (function0 != null) {
            i = function0.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("LinkAlertParams(title=");
        L.append(this.a);
        L.append(", message=");
        L.append(this.b);
        L.append(", confirmText=");
        L.append(this.c);
        L.append(", cancelText=");
        L.append(this.d);
        L.append(", confirmListener=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }
}

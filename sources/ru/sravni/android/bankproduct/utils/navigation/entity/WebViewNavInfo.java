package ru.sravni.android.bankproduct.utils.navigation.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lru/sravni/android/bankproduct/utils/navigation/entity/WebViewNavInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "url", "title", "backFragmentId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lru/sravni/android/bankproduct/utils/navigation/entity/WebViewNavInfo;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", AuthSource.SEND_ABUSE, "getUrl", "c", "Ljava/lang/Integer;", "getBackFragmentId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class WebViewNavInfo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final Integer c;

    public WebViewNavInfo(@NotNull String str, @NotNull String str2, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str2, "title");
        this.a = str;
        this.b = str2;
        this.c = num;
    }

    public static /* synthetic */ WebViewNavInfo copy$default(WebViewNavInfo webViewNavInfo, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = webViewNavInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = webViewNavInfo.b;
        }
        if ((i & 4) != 0) {
            num = webViewNavInfo.c;
        }
        return webViewNavInfo.copy(str, str2, num);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final Integer component3() {
        return this.c;
    }

    @NotNull
    public final WebViewNavInfo copy(@NotNull String str, @NotNull String str2, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str2, "title");
        return new WebViewNavInfo(str, str2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebViewNavInfo)) {
            return false;
        }
        WebViewNavInfo webViewNavInfo = (WebViewNavInfo) obj;
        return Intrinsics.areEqual(this.a, webViewNavInfo.a) && Intrinsics.areEqual(this.b, webViewNavInfo.b) && Intrinsics.areEqual(this.c, webViewNavInfo.c);
    }

    @Nullable
    public final Integer getBackFragmentId() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    @NotNull
    public final String getUrl() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.c;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("WebViewNavInfo(url=");
        L.append(this.a);
        L.append(", title=");
        L.append(this.b);
        L.append(", backFragmentId=");
        return a.p(L, this.c, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebViewNavInfo(String str, String str2, Integer num, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : num);
    }
}

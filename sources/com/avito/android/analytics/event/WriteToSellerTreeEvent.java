package com.avito.android.analytics.event;

import a2.b.a.a.a;
import a2.g.r.g;
import android.annotation.SuppressLint;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.SearchContextWrapperKt;
import com.avito.android.util.UrlParams;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*Bw\b\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b'\u0010(BE\b\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b'\u0010)J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\bR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006+"}, d2 = {"Lcom/avito/android/analytics/event/WriteToSellerTreeEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "h", "Ljava/lang/String;", "categoryId", "n", "fromPage", "e", "source", g.a, BookingInfoActivity.EXTRA_ITEM_ID, "l", "locationId", "k", "userHashId", "o", "x", "j", UrlParams.METRO_ID, AuthSource.OPEN_CHANNEL_LIST, "shopId", "", "f", "I", BookingInfoActivity.EXTRA_FROM_BLOCK, "", "i", "Ljava/lang/Boolean;", "isFromCompany", "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "context", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Companion", "core_release"}, k = 1, mv = {1, 4, 2})
public final class WriteToSellerTreeEvent extends TreeClickStreamEvent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String SOURCE_ADVERT_SCREEN = "item";
    @NotNull
    public static final String SOURCE_ADVERT_SNIPPET = "s";
    @NotNull
    public static final String SOURCE_DISCOUNTS_DIALOG = "d";
    @NotNull
    public static final String SOURCE_SAFE_SHOW_DIALOG = "o";
    @NotNull
    public static final String SOURCE_XL_ADVERT_SNIPPET = "xl";
    public final String e;
    public final int f;
    public String g;
    public String h;
    public Boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/event/WriteToSellerTreeEvent$Companion;", "", "", "SOURCE_ADVERT_SCREEN", "Ljava/lang/String;", "SOURCE_ADVERT_SNIPPET", "SOURCE_DISCOUNTS_DIALOG", "SOURCE_SAFE_SHOW_DIALOG", "SOURCE_XL_ADVERT_SNIPPET", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SuppressLint({"VisibleForTests"})
    public WriteToSellerTreeEvent(long j2, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull String str, @Nullable String str2, boolean z, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @NotNull String str7, int i2, @Nullable String str8) {
        super(j2, treeClickStreamParent, 2654, 11);
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str7, "source");
        this.e = str7;
        this.f = i2;
        this.g = str;
        this.h = str2;
        this.i = Boolean.valueOf(z);
        this.j = str3;
        this.k = str4;
        this.l = str5;
        this.m = str6;
        this.o = SearchContextWrapperKt.extractSearchXFromContext(new SearchContextWrapper(str8));
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "iid", this.g);
        String str = this.h;
        if (str != null) {
            putParam(linkedHashMap, "cid", str);
        }
        Boolean bool = this.i;
        if (bool != null) {
            bool.booleanValue();
            putParam(linkedHashMap, "oc", this.i);
        }
        String str2 = this.j;
        if (str2 != null) {
            putParam(linkedHashMap, "mid", str2);
        }
        String str3 = this.k;
        if (str3 != null) {
            putParam(linkedHashMap, "oid", str3);
        }
        String str4 = this.l;
        if (str4 != null) {
            putParam(linkedHashMap, "lid", str4);
        }
        String str5 = this.m;
        if (str5 != null) {
            putParam(linkedHashMap, "sid", str5);
        }
        String str6 = this.n;
        if (str6 != null) {
            putParam(linkedHashMap, WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, str6);
        }
        String str7 = this.o;
        if (str7 != null) {
            putParam(linkedHashMap, "x", str7);
        }
        putParam(linkedHashMap, "wsrc", this.e);
        putParam(linkedHashMap, "from_block", Integer.valueOf(this.f));
        return linkedHashMap;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SuppressLint({"VisibleForTests"})
    public WriteToSellerTreeEvent(long j2, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull String str, @NotNull String str2, int i2, @NotNull String str3, @Nullable String str4) {
        super(j2, treeClickStreamParent, 2654, 11);
        a.Z0(str, BookingInfoActivity.EXTRA_ITEM_ID, str2, "source", str3, "fromPage");
        this.e = str2;
        this.f = i2;
        this.g = str;
        this.n = str3;
        this.o = SearchContextWrapperKt.extractSearchXFromContext(new SearchContextWrapper(str4));
    }
}

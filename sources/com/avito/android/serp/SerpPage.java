package com.avito.android.serp;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchDescription;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b.\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010(\u001a\u00020\u0006\u0012\u0006\u0010)\u001a\u00020\t\u0012\u0006\u0010*\u001a\u00020\f\u0012\u0006\u0010+\u001a\u00020\u000f\u0012\b\u0010,\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010-\u001a\u00020\u0013\u0012\u0006\u0010.\u001a\u00020\u000f\u0012\u0006\u0010/\u001a\u00020\u0017\u0012\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001a\u0012\u0006\u00101\u001a\u00020\u001d\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f¢\u0006\u0004\be\u0010fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010$\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b&\u0010\u000eJ¸\u0001\u00105\u001a\u00020\u00002\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\t2\b\b\u0002\u0010*\u001a\u00020\f2\b\b\u0002\u0010+\u001a\u00020\u000f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010-\u001a\u00020\u00132\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u00172\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001a2\b\b\u0002\u00101\u001a\u00020\u001d2\n\b\u0002\u00102\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u00010#2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b7\u0010\u000eJ\u0010\u00108\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b8\u0010\u000bJ\u001a\u0010;\u001a\u00020\u000f2\b\u0010:\u001a\u0004\u0018\u000109HÖ\u0003¢\u0006\u0004\b;\u0010<R\u001b\u0010,\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u000eR\u0019\u0010/\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\u0019R\u0019\u00101\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u001fR\u0019\u0010(\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010\bR'\u00100\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\u001cR\u0019\u0010.\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010\u0011R$\u00104\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bO\u0010>\u001a\u0004\bP\u0010\u000e\"\u0004\bQ\u0010RR\u001b\u00103\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010%R\u0019\u0010)\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010\u000bR\u001b\u00102\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\"R\u0019\u0010*\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\\\u0010>\u001a\u0004\b]\u0010\u000eR\u0019\u0010-\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010\u0015R\u0019\u0010+\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010M\u001a\u0004\b+\u0010\u0011R\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010\u0005¨\u0006g"}, d2 = {"Lcom/avito/android/serp/SerpPage;", "Lcom/avito/android/serp/Serp;", "", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "component1", "()Ljava/util/List;", "Lcom/avito/android/serp/SerpPageParams;", "component2", "()Lcom/avito/android/serp/SerpPageParams;", "", "component3", "()I", "", "component4", "()Ljava/lang/String;", "", "component5", "()Z", "component6", "", "component7", "()J", "component8", "Lcom/avito/android/remote/model/SerpDisplayType;", "component9", "()Lcom/avito/android/remote/model/SerpDisplayType;", "", "component10", "()Ljava/util/Map;", "Lcom/avito/android/serp/SerpParameters;", "component11", "()Lcom/avito/android/serp/SerpParameters;", "Lcom/avito/android/remote/model/search/InlineFilters;", "component12", "()Lcom/avito/android/remote/model/search/InlineFilters;", "Lcom/avito/android/remote/model/SearchDescription;", "component13", "()Lcom/avito/android/remote/model/SearchDescription;", "component14", MessengerShareContentUtility.ELEMENTS, "nextPageParams", "lastSortedIndex", "searchHint", "isSubscribed", "subscriptionId", "count", "hasMorePages", "displayType", "firebaseParams", "serpParameters", "inlineFilters", "searchDescription", "xHash", "copy", "(Ljava/util/List;Lcom/avito/android/serp/SerpPageParams;ILjava/lang/String;ZLjava/lang/String;JZLcom/avito/android/remote/model/SerpDisplayType;Ljava/util/Map;Lcom/avito/android/serp/SerpParameters;Lcom/avito/android/remote/model/search/InlineFilters;Lcom/avito/android/remote/model/SearchDescription;Ljava/lang/String;)Lcom/avito/android/serp/SerpPage;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "f", "Ljava/lang/String;", "getSubscriptionId", "i", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "k", "Lcom/avito/android/serp/SerpParameters;", "getSerpParameters", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/SerpPageParams;", "getNextPageParams", "j", "Ljava/util/Map;", "getFirebaseParams", "h", "Z", "getHasMorePages", "n", "getXHash", "setXHash", "(Ljava/lang/String;)V", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/SearchDescription;", "getSearchDescription", "c", "I", "getLastSortedIndex", "l", "Lcom/avito/android/remote/model/search/InlineFilters;", "getInlineFilters", "d", "getSearchHint", g.a, "J", "getCount", "e", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getElements", "<init>", "(Ljava/util/List;Lcom/avito/android/serp/SerpPageParams;ILjava/lang/String;ZLjava/lang/String;JZLcom/avito/android/remote/model/SerpDisplayType;Ljava/util/Map;Lcom/avito/android/serp/SerpParameters;Lcom/avito/android/remote/model/search/InlineFilters;Lcom/avito/android/remote/model/SearchDescription;Ljava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpPage extends Serp {
    @NotNull
    public final List<ViewTypeSerpItem> a;
    @NotNull
    public final SerpPageParams b;
    public final int c;
    @NotNull
    public final String d;
    public final boolean e;
    @Nullable
    public final String f;
    public final long g;
    public final boolean h;
    @NotNull
    public final SerpDisplayType i;
    @Nullable
    public final Map<String, String> j;
    @NotNull
    public final SerpParameters k;
    @Nullable
    public final InlineFilters l;
    @Nullable
    public final SearchDescription m;
    @Nullable
    public String n;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpPage(List list, SerpPageParams serpPageParams, int i2, String str, boolean z, String str2, long j2, boolean z2, SerpDisplayType serpDisplayType, Map map, SerpParameters serpParameters, InlineFilters inlineFilters, SearchDescription searchDescription, String str3, int i3, j jVar) {
        this(list, serpPageParams, i2, str, z, str2, j2, z2, serpDisplayType, map, serpParameters, (i3 & 2048) != 0 ? null : inlineFilters, (i3 & 4096) != 0 ? null : searchDescription, (i3 & 8192) != 0 ? null : str3);
    }

    public static /* synthetic */ SerpPage copy$default(SerpPage serpPage, List list, SerpPageParams serpPageParams, int i2, String str, boolean z, String str2, long j2, boolean z2, SerpDisplayType serpDisplayType, Map map, SerpParameters serpParameters, InlineFilters inlineFilters, SearchDescription searchDescription, String str3, int i3, Object obj) {
        return serpPage.copy((i3 & 1) != 0 ? serpPage.a : list, (i3 & 2) != 0 ? serpPage.b : serpPageParams, (i3 & 4) != 0 ? serpPage.c : i2, (i3 & 8) != 0 ? serpPage.d : str, (i3 & 16) != 0 ? serpPage.e : z, (i3 & 32) != 0 ? serpPage.f : str2, (i3 & 64) != 0 ? serpPage.g : j2, (i3 & 128) != 0 ? serpPage.h : z2, (i3 & 256) != 0 ? serpPage.i : serpDisplayType, (i3 & 512) != 0 ? serpPage.j : map, (i3 & 1024) != 0 ? serpPage.k : serpParameters, (i3 & 2048) != 0 ? serpPage.l : inlineFilters, (i3 & 4096) != 0 ? serpPage.m : searchDescription, (i3 & 8192) != 0 ? serpPage.n : str3);
    }

    @NotNull
    public final List<ViewTypeSerpItem> component1() {
        return this.a;
    }

    @Nullable
    public final Map<String, String> component10() {
        return this.j;
    }

    @NotNull
    public final SerpParameters component11() {
        return this.k;
    }

    @Nullable
    public final InlineFilters component12() {
        return this.l;
    }

    @Nullable
    public final SearchDescription component13() {
        return this.m;
    }

    @Nullable
    public final String component14() {
        return this.n;
    }

    @NotNull
    public final SerpPageParams component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    public final long component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    @NotNull
    public final SerpDisplayType component9() {
        return this.i;
    }

    @NotNull
    public final SerpPage copy(@NotNull List<? extends ViewTypeSerpItem> list, @NotNull SerpPageParams serpPageParams, int i2, @NotNull String str, boolean z, @Nullable String str2, long j2, boolean z2, @NotNull SerpDisplayType serpDisplayType, @Nullable Map<String, String> map, @NotNull SerpParameters serpParameters, @Nullable InlineFilters inlineFilters, @Nullable SearchDescription searchDescription, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        Intrinsics.checkNotNullParameter(serpPageParams, "nextPageParams");
        Intrinsics.checkNotNullParameter(str, "searchHint");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpParameters, "serpParameters");
        return new SerpPage(list, serpPageParams, i2, str, z, str2, j2, z2, serpDisplayType, map, serpParameters, inlineFilters, searchDescription, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SerpPage)) {
            return false;
        }
        SerpPage serpPage = (SerpPage) obj;
        return Intrinsics.areEqual(this.a, serpPage.a) && Intrinsics.areEqual(this.b, serpPage.b) && this.c == serpPage.c && Intrinsics.areEqual(this.d, serpPage.d) && this.e == serpPage.e && Intrinsics.areEqual(this.f, serpPage.f) && this.g == serpPage.g && this.h == serpPage.h && Intrinsics.areEqual(this.i, serpPage.i) && Intrinsics.areEqual(this.j, serpPage.j) && Intrinsics.areEqual(this.k, serpPage.k) && Intrinsics.areEqual(this.l, serpPage.l) && Intrinsics.areEqual(this.m, serpPage.m) && Intrinsics.areEqual(this.n, serpPage.n);
    }

    public final long getCount() {
        return this.g;
    }

    @NotNull
    public final SerpDisplayType getDisplayType() {
        return this.i;
    }

    @NotNull
    public final List<ViewTypeSerpItem> getElements() {
        return this.a;
    }

    @Nullable
    public final Map<String, String> getFirebaseParams() {
        return this.j;
    }

    public final boolean getHasMorePages() {
        return this.h;
    }

    @Nullable
    public final InlineFilters getInlineFilters() {
        return this.l;
    }

    public final int getLastSortedIndex() {
        return this.c;
    }

    @NotNull
    public final SerpPageParams getNextPageParams() {
        return this.b;
    }

    @Nullable
    public final SearchDescription getSearchDescription() {
        return this.m;
    }

    @NotNull
    public final String getSearchHint() {
        return this.d;
    }

    @NotNull
    public final SerpParameters getSerpParameters() {
        return this.k;
    }

    @Nullable
    public final String getSubscriptionId() {
        return this.f;
    }

    @Nullable
    public final String getXHash() {
        return this.n;
    }

    public int hashCode() {
        List<ViewTypeSerpItem> list = this.a;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        SerpPageParams serpPageParams = this.b;
        int hashCode2 = (((hashCode + (serpPageParams != null ? serpPageParams.hashCode() : 0)) * 31) + this.c) * 31;
        String str = this.d;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.e;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode3 + i4) * 31;
        String str2 = this.f;
        int hashCode4 = (((i7 + (str2 != null ? str2.hashCode() : 0)) * 31) + c.a(this.g)) * 31;
        boolean z2 = this.h;
        if (!z2) {
            i3 = z2 ? 1 : 0;
        }
        int i8 = (hashCode4 + i3) * 31;
        SerpDisplayType serpDisplayType = this.i;
        int hashCode5 = (i8 + (serpDisplayType != null ? serpDisplayType.hashCode() : 0)) * 31;
        Map<String, String> map = this.j;
        int hashCode6 = (hashCode5 + (map != null ? map.hashCode() : 0)) * 31;
        SerpParameters serpParameters = this.k;
        int hashCode7 = (hashCode6 + (serpParameters != null ? serpParameters.hashCode() : 0)) * 31;
        InlineFilters inlineFilters = this.l;
        int hashCode8 = (hashCode7 + (inlineFilters != null ? inlineFilters.hashCode() : 0)) * 31;
        SearchDescription searchDescription = this.m;
        int hashCode9 = (hashCode8 + (searchDescription != null ? searchDescription.hashCode() : 0)) * 31;
        String str3 = this.n;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode9 + i2;
    }

    public final boolean isSubscribed() {
        return this.e;
    }

    public final void setXHash(@Nullable String str) {
        this.n = str;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SerpPage(elements=");
        L.append(this.a);
        L.append(", nextPageParams=");
        L.append(this.b);
        L.append(", lastSortedIndex=");
        L.append(this.c);
        L.append(", searchHint=");
        L.append(this.d);
        L.append(", isSubscribed=");
        L.append(this.e);
        L.append(", subscriptionId=");
        L.append(this.f);
        L.append(", count=");
        L.append(this.g);
        L.append(", hasMorePages=");
        L.append(this.h);
        L.append(", displayType=");
        L.append(this.i);
        L.append(", firebaseParams=");
        L.append(this.j);
        L.append(", serpParameters=");
        L.append(this.k);
        L.append(", inlineFilters=");
        L.append(this.l);
        L.append(", searchDescription=");
        L.append(this.m);
        L.append(", xHash=");
        return a.t(L, this.n, ")");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.List<? extends com.avito.android.serp.adapter.ViewTypeSerpItem> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerpPage(@NotNull List<? extends ViewTypeSerpItem> list, @NotNull SerpPageParams serpPageParams, int i2, @NotNull String str, boolean z, @Nullable String str2, long j2, boolean z2, @NotNull SerpDisplayType serpDisplayType, @Nullable Map<String, String> map, @NotNull SerpParameters serpParameters, @Nullable InlineFilters inlineFilters, @Nullable SearchDescription searchDescription, @Nullable String str3) {
        super(null);
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        Intrinsics.checkNotNullParameter(serpPageParams, "nextPageParams");
        Intrinsics.checkNotNullParameter(str, "searchHint");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpParameters, "serpParameters");
        this.a = list;
        this.b = serpPageParams;
        this.c = i2;
        this.d = str;
        this.e = z;
        this.f = str2;
        this.g = j2;
        this.h = z2;
        this.i = serpDisplayType;
        this.j = map;
        this.k = serpParameters;
        this.l = inlineFilters;
        this.m = searchDescription;
        this.n = str3;
    }
}

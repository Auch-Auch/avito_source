package com.avito.android.home;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u001d\b\b\u0018\u0000 @2\u00020\u0001:\u0001@BG\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\u0011\u0012\u0006\u0010 \u001a\u00020\u0014\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010!\u001a\u00020\u0011¢\u0006\u0004\b>\u0010?J\r\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u0003J\r\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0013J^\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010 \u001a\u00020\u00142\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010!\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b'\u0010\u000fJ\u001a\u0010)\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0000H\u0002¢\u0006\u0004\b+\u0010\u0003R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u001bR\u0019\u0010!\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0013R\u0019\u0010 \u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0016R\u0019\u0010\u001e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u000fR\u0019\u0010\u001f\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b8\u00100\u001a\u0004\b9\u0010\u0013R\u0019\u0010\u001d\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b+\u00106\u001a\u0004\b:\u0010\u000fR\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00178\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u0019¨\u0006A"}, d2 = {"Lcom/avito/android/home/TabState;", "", "loadingElements", "()Lcom/avito/android/home/TabState;", "", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "appendElements", "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/home/TabState;", "loadElementsError", "postRefresh", "", "component1", "()I", "component2", "", "component3", "()Z", "Lcom/avito/android/home/LoadState;", "component4", "()Lcom/avito/android/home/LoadState;", "", "component5", "()Ljava/util/List;", "component6", "()Lcom/avito/android/remote/model/SerpDisplayType;", "component7", "page", "offset", "hasMorePages", "elementsState", "refreshElements", "copy", "(IIZLcom/avito/android/home/LoadState;Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;Z)Lcom/avito/android/home/TabState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", g.a, "Z", "getRefreshElements", "d", "Lcom/avito/android/home/LoadState;", "getElementsState", AuthSource.BOOKING_ORDER, "I", "getOffset", "c", "getHasMorePages", "getPage", "e", "Ljava/util/List;", "getElements", "<init>", "(IIZLcom/avito/android/home/LoadState;Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;Z)V", "Companion", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class TabState {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a;
    public final int b;
    public final boolean c;
    @NotNull
    public final LoadState d;
    @NotNull
    public final List<ViewTypeSerpItem> e;
    @Nullable
    public final SerpDisplayType f;
    public final boolean g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/home/TabState$Companion;", "", "Lcom/avito/android/home/TabState;", "createNewState", "()Lcom/avito/android/home/TabState;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final TabState createNewState() {
            return new TabState(0, 0, true, LoadState.NONE, new ArrayList(), null, false);
        }

        public Companion(j jVar) {
        }
    }

    public TabState(int i, int i2, boolean z, @NotNull LoadState loadState, @NotNull List<ViewTypeSerpItem> list, @Nullable SerpDisplayType serpDisplayType, boolean z2) {
        Intrinsics.checkNotNullParameter(loadState, "elementsState");
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = loadState;
        this.e = list;
        this.f = serpDisplayType;
        this.g = z2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.home.TabState */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabState copy$default(TabState tabState, int i, int i2, boolean z, LoadState loadState, List list, SerpDisplayType serpDisplayType, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = tabState.a;
        }
        if ((i3 & 2) != 0) {
            i2 = tabState.b;
        }
        if ((i3 & 4) != 0) {
            z = tabState.c;
        }
        if ((i3 & 8) != 0) {
            loadState = tabState.d;
        }
        if ((i3 & 16) != 0) {
            list = tabState.e;
        }
        if ((i3 & 32) != 0) {
            serpDisplayType = tabState.f;
        }
        if ((i3 & 64) != 0) {
            z2 = tabState.g;
        }
        return tabState.copy(i, i2, z, loadState, list, serpDisplayType, z2);
    }

    public final TabState a() {
        return this.g ? copy$default(this, 0, 0, false, null, new ArrayList(), null, false, 15, null) : this;
    }

    @NotNull
    public final TabState appendElements(@NotNull List<? extends ViewTypeSerpItem> list, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        TabState a3 = a();
        ArrayList arrayList = new ArrayList(a3.e);
        arrayList.addAll(list);
        int size = list.size();
        int i = a3.a + 1;
        int i2 = a3.b + size;
        boolean z = size > 0;
        LoadState loadState = LoadState.LOAD;
        SerpDisplayType serpDisplayType2 = a3.f;
        return copy$default(a3, i, i2, z, loadState, arrayList, serpDisplayType2 != null ? serpDisplayType2 : serpDisplayType, false, 64, null);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final LoadState component4() {
        return this.d;
    }

    @NotNull
    public final List<ViewTypeSerpItem> component5() {
        return this.e;
    }

    @Nullable
    public final SerpDisplayType component6() {
        return this.f;
    }

    public final boolean component7() {
        return this.g;
    }

    @NotNull
    public final TabState copy(int i, int i2, boolean z, @NotNull LoadState loadState, @NotNull List<ViewTypeSerpItem> list, @Nullable SerpDisplayType serpDisplayType, boolean z2) {
        Intrinsics.checkNotNullParameter(loadState, "elementsState");
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        return new TabState(i, i2, z, loadState, list, serpDisplayType, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabState)) {
            return false;
        }
        TabState tabState = (TabState) obj;
        return this.a == tabState.a && this.b == tabState.b && this.c == tabState.c && Intrinsics.areEqual(this.d, tabState.d) && Intrinsics.areEqual(this.e, tabState.e) && Intrinsics.areEqual(this.f, tabState.f) && this.g == tabState.g;
    }

    @Nullable
    public final SerpDisplayType getDisplayType() {
        return this.f;
    }

    @NotNull
    public final List<ViewTypeSerpItem> getElements() {
        return this.e;
    }

    @NotNull
    public final LoadState getElementsState() {
        return this.d;
    }

    public final boolean getHasMorePages() {
        return this.c;
    }

    public final int getOffset() {
        return this.b;
    }

    public final int getPage() {
        return this.a;
    }

    public final boolean getRefreshElements() {
        return this.g;
    }

    public int hashCode() {
        int i = ((this.a * 31) + this.b) * 31;
        boolean z = this.c;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (i + i3) * 31;
        LoadState loadState = this.d;
        int i7 = 0;
        int hashCode = (i6 + (loadState != null ? loadState.hashCode() : 0)) * 31;
        List<ViewTypeSerpItem> list = this.e;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        SerpDisplayType serpDisplayType = this.f;
        if (serpDisplayType != null) {
            i7 = serpDisplayType.hashCode();
        }
        int i8 = (hashCode2 + i7) * 31;
        boolean z2 = this.g;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        return i8 + i2;
    }

    @NotNull
    public final TabState loadElementsError() {
        return copy$default(a(), 0, 0, false, LoadState.ERROR, null, null, false, 119, null);
    }

    @NotNull
    public final TabState loadingElements() {
        return copy$default(this, 0, 0, false, LoadState.LOADING, null, null, false, 119, null);
    }

    @NotNull
    public final TabState postRefresh() {
        return copy$default(this, 0, 0, true, LoadState.NONE, null, null, true, 48, null);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TabState(page=");
        L.append(this.a);
        L.append(", offset=");
        L.append(this.b);
        L.append(", hasMorePages=");
        L.append(this.c);
        L.append(", elementsState=");
        L.append(this.d);
        L.append(", elements=");
        L.append(this.e);
        L.append(", displayType=");
        L.append(this.f);
        L.append(", refreshElements=");
        return a.B(L, this.g, ")");
    }
}

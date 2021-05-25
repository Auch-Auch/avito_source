package com.avito.android.tariff.edit_info.item.tabs;

import a2.b.a.a.a;
import com.avito.android.design.widget.tab.Tab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJF\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000eJ\u001a\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0013\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u000bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\b¨\u0006,"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;", "Lcom/avito/android/design/widget/tab/Tab;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/text/AttributedText;", "component3", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "component4", "()Z", "", "component5", "()I", "title", "label", "attributedTitle", "hasRedBadge", FirebaseAnalytics.Param.INDEX, "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ZI)Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "e", "I", "getIndex", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "getLabel", "d", "Z", "getHasRedBadge", "c", "Lcom/avito/android/remote/model/text/AttributedText;", "getAttributedTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ZI)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class PeriodTab implements Tab {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final AttributedText c;
    public final boolean d;
    public final int e;

    public PeriodTab(@NotNull String str, @Nullable String str2, @Nullable AttributedText attributedText, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = str;
        this.b = str2;
        this.c = attributedText;
        this.d = z;
        this.e = i;
    }

    public static /* synthetic */ PeriodTab copy$default(PeriodTab periodTab, String str, String str2, AttributedText attributedText, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = periodTab.getTitle();
        }
        if ((i2 & 2) != 0) {
            str2 = periodTab.getLabel();
        }
        if ((i2 & 4) != 0) {
            attributedText = periodTab.c;
        }
        if ((i2 & 8) != 0) {
            z = periodTab.d;
        }
        if ((i2 & 16) != 0) {
            i = periodTab.e;
        }
        return periodTab.copy(str, str2, attributedText, z, i);
    }

    @NotNull
    public final String component1() {
        return getTitle();
    }

    @Nullable
    public final String component2() {
        return getLabel();
    }

    @Nullable
    public final AttributedText component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    public final int component5() {
        return this.e;
    }

    @NotNull
    public final PeriodTab copy(@NotNull String str, @Nullable String str2, @Nullable AttributedText attributedText, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new PeriodTab(str, str2, attributedText, z, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PeriodTab)) {
            return false;
        }
        PeriodTab periodTab = (PeriodTab) obj;
        return Intrinsics.areEqual(getTitle(), periodTab.getTitle()) && Intrinsics.areEqual(getLabel(), periodTab.getLabel()) && Intrinsics.areEqual(this.c, periodTab.c) && this.d == periodTab.d && this.e == periodTab.e;
    }

    @Nullable
    public final AttributedText getAttributedTitle() {
        return this.c;
    }

    public final boolean getHasRedBadge() {
        return this.d;
    }

    public final int getIndex() {
        return this.e;
    }

    @Override // com.avito.android.design.widget.tab.Tab
    @Nullable
    public String getLabel() {
        return this.b;
    }

    @Override // com.avito.android.design.widget.tab.Tab
    @NotNull
    public String getTitle() {
        return this.a;
    }

    public int hashCode() {
        String title = getTitle();
        int i = 0;
        int hashCode = (title != null ? title.hashCode() : 0) * 31;
        String label = getLabel();
        int hashCode2 = (hashCode + (label != null ? label.hashCode() : 0)) * 31;
        AttributedText attributedText = this.c;
        if (attributedText != null) {
            i = attributedText.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.d;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return ((i2 + i3) * 31) + this.e;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PeriodTab(title=");
        L.append(getTitle());
        L.append(", label=");
        L.append(getLabel());
        L.append(", attributedTitle=");
        L.append(this.c);
        L.append(", hasRedBadge=");
        L.append(this.d);
        L.append(", index=");
        return a.j(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PeriodTab(String str, String str2, AttributedText attributedText, boolean z, int i, int i2, j jVar) {
        this(str, (i2 & 2) != 0 ? null : str2, attributedText, (i2 & 8) != 0 ? false : z, i);
    }
}

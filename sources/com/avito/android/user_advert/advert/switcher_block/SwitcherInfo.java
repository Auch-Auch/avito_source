package com.avito.android.user_advert.advert.switcher_block;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/avito/android/user_advert/advert/switcher_block/SwitcherInfo;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "title", MessengerShareContentUtility.SUBTITLE, "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/user_advert/advert/switcher_block/SwitcherInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class SwitcherInfo {
    @NotNull
    public final String a;
    @Nullable
    public final AttributedText b;

    public SwitcherInfo(@NotNull String str, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = str;
        this.b = attributedText;
    }

    public static /* synthetic */ SwitcherInfo copy$default(SwitcherInfo switcherInfo, String str, AttributedText attributedText, int i, Object obj) {
        if ((i & 1) != 0) {
            str = switcherInfo.a;
        }
        if ((i & 2) != 0) {
            attributedText = switcherInfo.b;
        }
        return switcherInfo.copy(str, attributedText);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final AttributedText component2() {
        return this.b;
    }

    @NotNull
    public final SwitcherInfo copy(@NotNull String str, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new SwitcherInfo(str, attributedText);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwitcherInfo)) {
            return false;
        }
        SwitcherInfo switcherInfo = (SwitcherInfo) obj;
        return Intrinsics.areEqual(this.a, switcherInfo.a) && Intrinsics.areEqual(this.b, switcherInfo.b);
    }

    @Nullable
    public final AttributedText getSubtitle() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AttributedText attributedText = this.b;
        if (attributedText != null) {
            i = attributedText.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SwitcherInfo(title=");
        L.append(this.a);
        L.append(", subtitle=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}

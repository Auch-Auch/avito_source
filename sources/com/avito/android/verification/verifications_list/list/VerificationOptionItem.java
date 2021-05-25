package com.avito.android.verification.verifications_list.list;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.verification.VerificationStatus;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\nR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/verification/verifications_list/list/VerificationOptionItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lcom/avito/android/verification/VerificationStatus;", "component5", "()Lcom/avito/android/verification/VerificationStatus;", "stringId", "type", "title", MessengerShareContentUtility.SUBTITLE, "status", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/verification/VerificationStatus;)Lcom/avito/android/verification/verifications_list/list/VerificationOptionItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "c", "getTitle", "e", "Lcom/avito/android/verification/VerificationStatus;", "getStatus", AuthSource.BOOKING_ORDER, "getType", "d", "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/verification/VerificationStatus;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationOptionItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final VerificationStatus e;

    public VerificationOptionItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull VerificationStatus verificationStatus) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(verificationStatus, "status");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = verificationStatus;
    }

    public static /* synthetic */ VerificationOptionItem copy$default(VerificationOptionItem verificationOptionItem, String str, String str2, String str3, String str4, VerificationStatus verificationStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verificationOptionItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = verificationOptionItem.b;
        }
        if ((i & 4) != 0) {
            str3 = verificationOptionItem.c;
        }
        if ((i & 8) != 0) {
            str4 = verificationOptionItem.d;
        }
        if ((i & 16) != 0) {
            verificationStatus = verificationOptionItem.e;
        }
        return verificationOptionItem.copy(str, str2, str3, str4, verificationStatus);
    }

    @NotNull
    public final String component1() {
        return getStringId();
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
    public final VerificationStatus component5() {
        return this.e;
    }

    @NotNull
    public final VerificationOptionItem copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull VerificationStatus verificationStatus) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(verificationStatus, "status");
        return new VerificationOptionItem(str, str2, str3, str4, verificationStatus);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerificationOptionItem)) {
            return false;
        }
        VerificationOptionItem verificationOptionItem = (VerificationOptionItem) obj;
        return Intrinsics.areEqual(getStringId(), verificationOptionItem.getStringId()) && Intrinsics.areEqual(this.b, verificationOptionItem.b) && Intrinsics.areEqual(this.c, verificationOptionItem.c) && Intrinsics.areEqual(this.d, verificationOptionItem.d) && Intrinsics.areEqual(this.e, verificationOptionItem.e);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final VerificationStatus getStatus() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getSubtitle() {
        return this.d;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    @NotNull
    public final String getType() {
        return this.b;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        VerificationStatus verificationStatus = this.e;
        if (verificationStatus != null) {
            i = verificationStatus.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("VerificationOptionItem(stringId=");
        L.append(getStringId());
        L.append(", type=");
        L.append(this.b);
        L.append(", title=");
        L.append(this.c);
        L.append(", subtitle=");
        L.append(this.d);
        L.append(", status=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }
}

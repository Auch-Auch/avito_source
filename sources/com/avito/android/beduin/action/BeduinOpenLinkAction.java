package com.avito.android.beduin.action;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.action.BeduinActionType;
import com.avito.android.beduin.core.common.BeduinApiTypeName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Keep
@BeduinApiTypeName(types = {"openLink"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/avito/android/beduin/action/BeduinOpenLinkAction;", "Lcom/avito/android/beduin/core/action/BeduinAction;", "Lcom/avito/android/beduin/core/action/BeduinActionType;", "component1", "()Lcom/avito/android/beduin/core/action/BeduinActionType;", "", "component2", "()Ljava/lang/String;", "actionType", "link", "copy", "(Lcom/avito/android/beduin/core/action/BeduinActionType;Ljava/lang/String;)Lcom/avito/android/beduin/action/BeduinOpenLinkAction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/beduin/core/action/BeduinActionType;", "getActionType", "Ljava/lang/String;", "getLink", "<init>", "(Lcom/avito/android/beduin/core/action/BeduinActionType;Ljava/lang/String;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinOpenLinkAction implements BeduinAction {
    public static final Parcelable.Creator<BeduinOpenLinkAction> CREATOR = new Creator();
    @NotNull
    private final BeduinActionType actionType;
    @NotNull
    private final String link;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BeduinOpenLinkAction> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinOpenLinkAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BeduinOpenLinkAction((BeduinActionType) Enum.valueOf(BeduinActionType.class, parcel.readString()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinOpenLinkAction[] newArray(int i) {
            return new BeduinOpenLinkAction[i];
        }
    }

    public BeduinOpenLinkAction(@NotNull BeduinActionType beduinActionType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(beduinActionType, "actionType");
        Intrinsics.checkNotNullParameter(str, "link");
        this.actionType = beduinActionType;
        this.link = str;
    }

    public static /* synthetic */ BeduinOpenLinkAction copy$default(BeduinOpenLinkAction beduinOpenLinkAction, BeduinActionType beduinActionType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            beduinActionType = beduinOpenLinkAction.getActionType();
        }
        if ((i & 2) != 0) {
            str = beduinOpenLinkAction.link;
        }
        return beduinOpenLinkAction.copy(beduinActionType, str);
    }

    @NotNull
    public final BeduinActionType component1() {
        return getActionType();
    }

    @NotNull
    public final String component2() {
        return this.link;
    }

    @NotNull
    public final BeduinOpenLinkAction copy(@NotNull BeduinActionType beduinActionType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(beduinActionType, "actionType");
        Intrinsics.checkNotNullParameter(str, "link");
        return new BeduinOpenLinkAction(beduinActionType, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BeduinOpenLinkAction)) {
            return false;
        }
        BeduinOpenLinkAction beduinOpenLinkAction = (BeduinOpenLinkAction) obj;
        return Intrinsics.areEqual(getActionType(), beduinOpenLinkAction.getActionType()) && Intrinsics.areEqual(this.link, beduinOpenLinkAction.link);
    }

    @Override // com.avito.android.beduin.core.action.BeduinAction
    @NotNull
    public BeduinActionType getActionType() {
        return this.actionType;
    }

    @NotNull
    public final String getLink() {
        return this.link;
    }

    @Override // java.lang.Object
    public int hashCode() {
        BeduinActionType actionType2 = getActionType();
        int i = 0;
        int hashCode = (actionType2 != null ? actionType2.hashCode() : 0) * 31;
        String str = this.link;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinOpenLinkAction(actionType=");
        L.append(getActionType());
        L.append(", link=");
        return a.t(L, this.link, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.actionType.name());
        parcel.writeString(this.link);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeduinOpenLinkAction(BeduinActionType beduinActionType, String str, int i, j jVar) {
        this((i & 1) != 0 ? BeduinActionType.ON_CLICK : beduinActionType, str);
    }
}

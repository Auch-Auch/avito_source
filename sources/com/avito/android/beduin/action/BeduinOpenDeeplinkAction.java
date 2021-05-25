package com.avito.android.beduin.action;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.action.BeduinActionType;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/beduin/action/BeduinOpenDeeplinkAction;", "Lcom/avito/android/beduin/core/action/BeduinAction;", "Lcom/avito/android/beduin/core/action/BeduinActionType;", "component1", "()Lcom/avito/android/beduin/core/action/BeduinActionType;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "actionType", "deeplink", "copy", "(Lcom/avito/android/beduin/core/action/BeduinActionType;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/beduin/action/BeduinOpenDeeplinkAction;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "Lcom/avito/android/beduin/core/action/BeduinActionType;", "getActionType", "<init>", "(Lcom/avito/android/beduin/core/action/BeduinActionType;Lcom/avito/android/deep_linking/links/DeepLink;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinOpenDeeplinkAction implements BeduinAction {
    public static final Parcelable.Creator<BeduinOpenDeeplinkAction> CREATOR = new Creator();
    @NotNull
    private final BeduinActionType actionType;
    @NotNull
    private final DeepLink deeplink;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BeduinOpenDeeplinkAction> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinOpenDeeplinkAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BeduinOpenDeeplinkAction((BeduinActionType) Enum.valueOf(BeduinActionType.class, parcel.readString()), (DeepLink) parcel.readParcelable(BeduinOpenDeeplinkAction.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinOpenDeeplinkAction[] newArray(int i) {
            return new BeduinOpenDeeplinkAction[i];
        }
    }

    public BeduinOpenDeeplinkAction(@NotNull BeduinActionType beduinActionType, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(beduinActionType, "actionType");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        this.actionType = beduinActionType;
        this.deeplink = deepLink;
    }

    public static /* synthetic */ BeduinOpenDeeplinkAction copy$default(BeduinOpenDeeplinkAction beduinOpenDeeplinkAction, BeduinActionType beduinActionType, DeepLink deepLink, int i, Object obj) {
        if ((i & 1) != 0) {
            beduinActionType = beduinOpenDeeplinkAction.getActionType();
        }
        if ((i & 2) != 0) {
            deepLink = beduinOpenDeeplinkAction.deeplink;
        }
        return beduinOpenDeeplinkAction.copy(beduinActionType, deepLink);
    }

    @NotNull
    public final BeduinActionType component1() {
        return getActionType();
    }

    @NotNull
    public final DeepLink component2() {
        return this.deeplink;
    }

    @NotNull
    public final BeduinOpenDeeplinkAction copy(@NotNull BeduinActionType beduinActionType, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(beduinActionType, "actionType");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        return new BeduinOpenDeeplinkAction(beduinActionType, deepLink);
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
        if (!(obj instanceof BeduinOpenDeeplinkAction)) {
            return false;
        }
        BeduinOpenDeeplinkAction beduinOpenDeeplinkAction = (BeduinOpenDeeplinkAction) obj;
        return Intrinsics.areEqual(getActionType(), beduinOpenDeeplinkAction.getActionType()) && Intrinsics.areEqual(this.deeplink, beduinOpenDeeplinkAction.deeplink);
    }

    @Override // com.avito.android.beduin.core.action.BeduinAction
    @NotNull
    public BeduinActionType getActionType() {
        return this.actionType;
    }

    @NotNull
    public final DeepLink getDeeplink() {
        return this.deeplink;
    }

    @Override // java.lang.Object
    public int hashCode() {
        BeduinActionType actionType2 = getActionType();
        int i = 0;
        int hashCode = (actionType2 != null ? actionType2.hashCode() : 0) * 31;
        DeepLink deepLink = this.deeplink;
        if (deepLink != null) {
            i = deepLink.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinOpenDeeplinkAction(actionType=");
        L.append(getActionType());
        L.append(", deeplink=");
        return a.m(L, this.deeplink, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.actionType.name());
        parcel.writeParcelable(this.deeplink, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeduinOpenDeeplinkAction(BeduinActionType beduinActionType, DeepLink deepLink, int i, j jVar) {
        this((i & 1) != 0 ? BeduinActionType.ON_CLICK : beduinActionType, deepLink);
    }
}

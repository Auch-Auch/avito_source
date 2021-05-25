package com.avito.android.remote.model.messenger.context;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JH\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b'\u0010\u0007R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b*\u0010\u000bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b+\u0010\u0004¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChannelMenuAction;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "component4", "()Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "component5", "title", "deepLink", "icon", "confirmation", "rawDeepLink", "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/ActionConfirmation;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/context/ChannelMenuAction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "getIcon", "Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "getConfirmation", "getRawDeepLink", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/ActionConfirmation;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelMenuAction implements Parcelable {
    public static final Parcelable.Creator<ChannelMenuAction> CREATOR = new Creator();
    @Nullable
    private final ActionConfirmation confirmation;
    @NotNull
    private final DeepLink deepLink;
    @Nullable
    private final String icon;
    @Nullable
    private final String rawDeepLink;
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ChannelMenuAction> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ChannelMenuAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ChannelMenuAction(parcel.readString(), (DeepLink) parcel.readParcelable(ChannelMenuAction.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0 ? ActionConfirmation.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ChannelMenuAction[] newArray(int i) {
            return new ChannelMenuAction[i];
        }
    }

    public ChannelMenuAction(@NotNull String str, @NotNull DeepLink deepLink2, @Nullable String str2, @Nullable ActionConfirmation actionConfirmation, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        this.title = str;
        this.deepLink = deepLink2;
        this.icon = str2;
        this.confirmation = actionConfirmation;
        this.rawDeepLink = str3;
    }

    public static /* synthetic */ ChannelMenuAction copy$default(ChannelMenuAction channelMenuAction, String str, DeepLink deepLink2, String str2, ActionConfirmation actionConfirmation, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelMenuAction.title;
        }
        if ((i & 2) != 0) {
            deepLink2 = channelMenuAction.deepLink;
        }
        if ((i & 4) != 0) {
            str2 = channelMenuAction.icon;
        }
        if ((i & 8) != 0) {
            actionConfirmation = channelMenuAction.confirmation;
        }
        if ((i & 16) != 0) {
            str3 = channelMenuAction.rawDeepLink;
        }
        return channelMenuAction.copy(str, deepLink2, str2, actionConfirmation, str3);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final DeepLink component2() {
        return this.deepLink;
    }

    @Nullable
    public final String component3() {
        return this.icon;
    }

    @Nullable
    public final ActionConfirmation component4() {
        return this.confirmation;
    }

    @Nullable
    public final String component5() {
        return this.rawDeepLink;
    }

    @NotNull
    public final ChannelMenuAction copy(@NotNull String str, @NotNull DeepLink deepLink2, @Nullable String str2, @Nullable ActionConfirmation actionConfirmation, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        return new ChannelMenuAction(str, deepLink2, str2, actionConfirmation, str3);
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
        if (!(obj instanceof ChannelMenuAction)) {
            return false;
        }
        ChannelMenuAction channelMenuAction = (ChannelMenuAction) obj;
        return Intrinsics.areEqual(this.title, channelMenuAction.title) && Intrinsics.areEqual(this.deepLink, channelMenuAction.deepLink) && Intrinsics.areEqual(this.icon, channelMenuAction.icon) && Intrinsics.areEqual(this.confirmation, channelMenuAction.confirmation) && Intrinsics.areEqual(this.rawDeepLink, channelMenuAction.rawDeepLink);
    }

    @Nullable
    public final ActionConfirmation getConfirmation() {
        return this.confirmation;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getRawDeepLink() {
        return this.rawDeepLink;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        DeepLink deepLink2 = this.deepLink;
        int hashCode2 = (hashCode + (deepLink2 != null ? deepLink2.hashCode() : 0)) * 31;
        String str2 = this.icon;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ActionConfirmation actionConfirmation = this.confirmation;
        int hashCode4 = (hashCode3 + (actionConfirmation != null ? actionConfirmation.hashCode() : 0)) * 31;
        String str3 = this.rawDeepLink;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelMenuAction(title=");
        L.append(this.title);
        L.append(", deepLink=");
        L.append(this.deepLink);
        L.append(", icon=");
        L.append(this.icon);
        L.append(", confirmation=");
        L.append(this.confirmation);
        L.append(", rawDeepLink=");
        return a.t(L, this.rawDeepLink, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.deepLink, i);
        parcel.writeString(this.icon);
        ActionConfirmation actionConfirmation = this.confirmation;
        if (actionConfirmation != null) {
            parcel.writeInt(1);
            actionConfirmation.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.rawDeepLink);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelMenuAction(String str, DeepLink deepLink2, String str2, ActionConfirmation actionConfirmation, String str3, int i, j jVar) {
        this(str, deepLink2, str2, actionConfirmation, (i & 16) != 0 ? null : str3);
    }
}

package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001:\u0003345BI\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJX\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b!\u0010\u001cJ \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b&\u0010'R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010\u0004R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b.\u0010\tR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b/\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b0\u0010\u0004¨\u00066"}, d2 = {"Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/avito/android/remote/model/DeepLinksDialogInfo$Action;", "component3", "()Ljava/util/List;", "Lcom/avito/android/remote/model/DeepLinksDialogInfo$ControlsDirection;", "component4", "()Lcom/avito/android/remote/model/DeepLinksDialogInfo$ControlsDirection;", "", "component5", "()Ljava/lang/Boolean;", "component6", "title", "description", "items", "controlsDirection", "isCancellable", "shouldShowCloseControl", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/DeepLinksDialogInfo$ControlsDirection;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/DeepLinksDialogInfo$ControlsDirection;", "getControlsDirection", "Ljava/lang/Boolean;", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getItems", "getShouldShowCloseControl", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/DeepLinksDialogInfo$ControlsDirection;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "Action", "ActionType", "ControlsDirection", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinksDialogInfo implements Parcelable {
    public static final Parcelable.Creator<DeepLinksDialogInfo> CREATOR = new Creator();
    @SerializedName("controlsDirection")
    @Nullable
    private final ControlsDirection controlsDirection;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("isCancellable")
    @Nullable
    private final Boolean isCancellable;
    @SerializedName("actions")
    @NotNull
    private final List<Action> items;
    @SerializedName("shouldShowCloseControl")
    @Nullable
    private final Boolean shouldShowCloseControl;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\r\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/DeepLinksDialogInfo$Action;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/DeepLinksDialogInfo$ActionType;", "component3", "()Lcom/avito/android/remote/model/DeepLinksDialogInfo$ActionType;", "title", "uriLink", "type", "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/DeepLinksDialogInfo$ActionType;)Lcom/avito/android/remote/model/DeepLinksDialogInfo$Action;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/remote/model/DeepLinksDialogInfo$ActionType;", "getType", "Lcom/avito/android/deep_linking/links/DeepLink;", "getUriLink", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/DeepLinksDialogInfo$ActionType;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action implements Parcelable {
        public static final Parcelable.Creator<Action> CREATOR = new Creator();
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("type")
        @NotNull
        private final ActionType type;
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink uriLink;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Action> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Action createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Action(parcel.readString(), (DeepLink) parcel.readParcelable(Action.class.getClassLoader()), (ActionType) Enum.valueOf(ActionType.class, parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Action[] newArray(int i) {
                return new Action[i];
            }
        }

        public Action(@NotNull String str, @Nullable DeepLink deepLink, @NotNull ActionType actionType) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(actionType, "type");
            this.title = str;
            this.uriLink = deepLink;
            this.type = actionType;
        }

        public static /* synthetic */ Action copy$default(Action action, String str, DeepLink deepLink, ActionType actionType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = action.title;
            }
            if ((i & 2) != 0) {
                deepLink = action.uriLink;
            }
            if ((i & 4) != 0) {
                actionType = action.type;
            }
            return action.copy(str, deepLink, actionType);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @Nullable
        public final DeepLink component2() {
            return this.uriLink;
        }

        @NotNull
        public final ActionType component3() {
            return this.type;
        }

        @NotNull
        public final Action copy(@NotNull String str, @Nullable DeepLink deepLink, @NotNull ActionType actionType) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(actionType, "type");
            return new Action(str, deepLink, actionType);
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
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return Intrinsics.areEqual(this.title, action.title) && Intrinsics.areEqual(this.uriLink, action.uriLink) && Intrinsics.areEqual(this.type, action.type);
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final ActionType getType() {
            return this.type;
        }

        @Nullable
        public final DeepLink getUriLink() {
            return this.uriLink;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            DeepLink deepLink = this.uriLink;
            int hashCode2 = (hashCode + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
            ActionType actionType = this.type;
            if (actionType != null) {
                i = actionType.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Action(title=");
            L.append(this.title);
            L.append(", uriLink=");
            L.append(this.uriLink);
            L.append(", type=");
            L.append(this.type);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.uriLink, i);
            parcel.writeString(this.type.name());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/DeepLinksDialogInfo$ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "POSITIVE", "NEGATIVE", "NEUTRAL", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum ActionType {
        POSITIVE,
        NEGATIVE,
        NEUTRAL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/DeepLinksDialogInfo$ControlsDirection;", "", "<init>", "(Ljava/lang/String;I)V", "HORIZONTAL", "VERTICAL", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum ControlsDirection {
        HORIZONTAL,
        VERTICAL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeepLinksDialogInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeepLinksDialogInfo createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Action.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            ControlsDirection controlsDirection = parcel.readInt() != 0 ? (ControlsDirection) Enum.valueOf(ControlsDirection.class, parcel.readString()) : null;
            boolean z = true;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool2 = Boolean.valueOf(z);
            } else {
                bool2 = null;
            }
            return new DeepLinksDialogInfo(readString, readString2, arrayList, controlsDirection, bool, bool2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeepLinksDialogInfo[] newArray(int i) {
            return new DeepLinksDialogInfo[i];
        }
    }

    public DeepLinksDialogInfo(@NotNull String str, @NotNull String str2, @NotNull List<Action> list, @Nullable ControlsDirection controlsDirection2, @Nullable Boolean bool, @Nullable Boolean bool2) {
        a.c1(str, "title", str2, "description", list, "items");
        this.title = str;
        this.description = str2;
        this.items = list;
        this.controlsDirection = controlsDirection2;
        this.isCancellable = bool;
        this.shouldShowCloseControl = bool2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.remote.model.DeepLinksDialogInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeepLinksDialogInfo copy$default(DeepLinksDialogInfo deepLinksDialogInfo, String str, String str2, List list, ControlsDirection controlsDirection2, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deepLinksDialogInfo.title;
        }
        if ((i & 2) != 0) {
            str2 = deepLinksDialogInfo.description;
        }
        if ((i & 4) != 0) {
            list = deepLinksDialogInfo.items;
        }
        if ((i & 8) != 0) {
            controlsDirection2 = deepLinksDialogInfo.controlsDirection;
        }
        if ((i & 16) != 0) {
            bool = deepLinksDialogInfo.isCancellable;
        }
        if ((i & 32) != 0) {
            bool2 = deepLinksDialogInfo.shouldShowCloseControl;
        }
        return deepLinksDialogInfo.copy(str, str2, list, controlsDirection2, bool, bool2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final List<Action> component3() {
        return this.items;
    }

    @Nullable
    public final ControlsDirection component4() {
        return this.controlsDirection;
    }

    @Nullable
    public final Boolean component5() {
        return this.isCancellable;
    }

    @Nullable
    public final Boolean component6() {
        return this.shouldShowCloseControl;
    }

    @NotNull
    public final DeepLinksDialogInfo copy(@NotNull String str, @NotNull String str2, @NotNull List<Action> list, @Nullable ControlsDirection controlsDirection2, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(list, "items");
        return new DeepLinksDialogInfo(str, str2, list, controlsDirection2, bool, bool2);
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
        if (!(obj instanceof DeepLinksDialogInfo)) {
            return false;
        }
        DeepLinksDialogInfo deepLinksDialogInfo = (DeepLinksDialogInfo) obj;
        return Intrinsics.areEqual(this.title, deepLinksDialogInfo.title) && Intrinsics.areEqual(this.description, deepLinksDialogInfo.description) && Intrinsics.areEqual(this.items, deepLinksDialogInfo.items) && Intrinsics.areEqual(this.controlsDirection, deepLinksDialogInfo.controlsDirection) && Intrinsics.areEqual(this.isCancellable, deepLinksDialogInfo.isCancellable) && Intrinsics.areEqual(this.shouldShowCloseControl, deepLinksDialogInfo.shouldShowCloseControl);
    }

    @Nullable
    public final ControlsDirection getControlsDirection() {
        return this.controlsDirection;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final List<Action> getItems() {
        return this.items;
    }

    @Nullable
    public final Boolean getShouldShowCloseControl() {
        return this.shouldShowCloseControl;
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
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Action> list = this.items;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        ControlsDirection controlsDirection2 = this.controlsDirection;
        int hashCode4 = (hashCode3 + (controlsDirection2 != null ? controlsDirection2.hashCode() : 0)) * 31;
        Boolean bool = this.isCancellable;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.shouldShowCloseControl;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode5 + i;
    }

    @Nullable
    public final Boolean isCancellable() {
        return this.isCancellable;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DeepLinksDialogInfo(title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", items=");
        L.append(this.items);
        L.append(", controlsDirection=");
        L.append(this.controlsDirection);
        L.append(", isCancellable=");
        L.append(this.isCancellable);
        L.append(", shouldShowCloseControl=");
        return a.o(L, this.shouldShowCloseControl, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        Iterator n0 = a.n0(this.items, parcel);
        while (n0.hasNext()) {
            ((Action) n0.next()).writeToParcel(parcel, 0);
        }
        ControlsDirection controlsDirection2 = this.controlsDirection;
        if (controlsDirection2 != null) {
            parcel.writeInt(1);
            parcel.writeString(controlsDirection2.name());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.isCancellable;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool2 = this.shouldShowCloseControl;
        if (bool2 != null) {
            a.G0(parcel, 1, bool2);
        } else {
            parcel.writeInt(0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeepLinksDialogInfo(String str, String str2, List list, ControlsDirection controlsDirection2, Boolean bool, Boolean bool2, int i, j jVar) {
        this(str, str2, list, (i & 8) != 0 ? null : controlsDirection2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2);
    }
}

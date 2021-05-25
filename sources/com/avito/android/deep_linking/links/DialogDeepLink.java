package com.avito.android.deep_linking.links;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 .2\u00020\u0001:\u0004./01BG\u0012\b\b\u0002\u0010)\u001a\u00020$\u0012\b\b\u0002\u0010+\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010 \u001a\u00020\u000b¢\u0006\u0004\b,\u0010-J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010 \u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010#\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000fR\u0019\u0010)\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010+\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010\u0015¨\u00062"}, d2 = {"Lcom/avito/android/deep_linking/links/DialogDeepLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", g.a, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "", "f", "Z", "getShouldShowCloseControl", "()Z", "shouldShowCloseControl", "", "Lcom/avito/android/deep_linking/links/DialogDeepLink$DialogButton;", "h", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", MessengerShareContentUtility.BUTTONS, "i", "getTitle", "title", "c", "getPath", MessageMetaInfo.COLUMN_PATH, "Lcom/avito/android/deep_linking/links/DialogDeepLink$ControlsDirection;", "d", "Lcom/avito/android/deep_linking/links/DialogDeepLink$ControlsDirection;", "getControlsDirection", "()Lcom/avito/android/deep_linking/links/DialogDeepLink$ControlsDirection;", "controlsDirection", "e", "isCancellable", "<init>", "(Lcom/avito/android/deep_linking/links/DialogDeepLink$ControlsDirection;ZZLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Companion", "ControlsDirection", "DialogButton", "DialogButtonStyle", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DialogDeepLink extends DeepLink {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<DialogDeepLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/dialog/show";
    @NotNull
    public final String c;
    @NotNull
    public final ControlsDirection d;
    public final boolean e;
    public final boolean f;
    @NotNull
    public final String g;
    @NotNull
    public final List<DialogButton> h;
    @NotNull
    public final String i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/DialogDeepLink$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/DialogDeepLink;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/deep_linking/links/DialogDeepLink$ControlsDirection;", "", "<init>", "(Ljava/lang/String;I)V", "HORIZONTAL", "VERTICAL", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum ControlsDirection {
        HORIZONTAL,
        VERTICAL
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0007R\u001c\u0010\r\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/avito/android/deep_linking/links/DialogDeepLink$DialogButton;", "Landroid/os/Parcelable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DialogDeepLink$DialogButtonStyle;", "component3", "()Lcom/avito/android/deep_linking/links/DialogDeepLink$DialogButtonStyle;", "action", "text", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DialogDeepLink$DialogButtonStyle;)Lcom/avito/android/deep_linking/links/DialogDeepLink$DialogButton;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getText", "Lcom/avito/android/deep_linking/links/DialogDeepLink$DialogButtonStyle;", "getStyle", "Lcom/avito/android/deep_linking/links/DeepLink;", "getAction", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DialogDeepLink$DialogButtonStyle;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class DialogButton implements Parcelable {
        public static final Parcelable.Creator<DialogButton> CREATOR = new Creator();
        @SerializedName("action")
        @Nullable
        private final DeepLink action;
        @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
        @NotNull
        private final DialogButtonStyle style;
        @SerializedName("text")
        @NotNull
        private final String text;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<DialogButton> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DialogButton createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new DialogButton((DeepLink) parcel.readParcelable(DialogButton.class.getClassLoader()), parcel.readString(), (DialogButtonStyle) Enum.valueOf(DialogButtonStyle.class, parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DialogButton[] newArray(int i) {
                return new DialogButton[i];
            }
        }

        public DialogButton(@Nullable DeepLink deepLink, @NotNull String str, @NotNull DialogButtonStyle dialogButtonStyle) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(dialogButtonStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            this.action = deepLink;
            this.text = str;
            this.style = dialogButtonStyle;
        }

        public static /* synthetic */ DialogButton copy$default(DialogButton dialogButton, DeepLink deepLink, String str, DialogButtonStyle dialogButtonStyle, int i, Object obj) {
            if ((i & 1) != 0) {
                deepLink = dialogButton.action;
            }
            if ((i & 2) != 0) {
                str = dialogButton.text;
            }
            if ((i & 4) != 0) {
                dialogButtonStyle = dialogButton.style;
            }
            return dialogButton.copy(deepLink, str, dialogButtonStyle);
        }

        @Nullable
        public final DeepLink component1() {
            return this.action;
        }

        @NotNull
        public final String component2() {
            return this.text;
        }

        @NotNull
        public final DialogButtonStyle component3() {
            return this.style;
        }

        @NotNull
        public final DialogButton copy(@Nullable DeepLink deepLink, @NotNull String str, @NotNull DialogButtonStyle dialogButtonStyle) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(dialogButtonStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            return new DialogButton(deepLink, str, dialogButtonStyle);
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
            if (!(obj instanceof DialogButton)) {
                return false;
            }
            DialogButton dialogButton = (DialogButton) obj;
            return Intrinsics.areEqual(this.action, dialogButton.action) && Intrinsics.areEqual(this.text, dialogButton.text) && Intrinsics.areEqual(this.style, dialogButton.style);
        }

        @Nullable
        public final DeepLink getAction() {
            return this.action;
        }

        @NotNull
        public final DialogButtonStyle getStyle() {
            return this.style;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @Override // java.lang.Object
        public int hashCode() {
            DeepLink deepLink = this.action;
            int i = 0;
            int hashCode = (deepLink != null ? deepLink.hashCode() : 0) * 31;
            String str = this.text;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            DialogButtonStyle dialogButtonStyle = this.style;
            if (dialogButtonStyle != null) {
                i = dialogButtonStyle.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("DialogButton(action=");
            L.append(this.action);
            L.append(", text=");
            L.append(this.text);
            L.append(", style=");
            L.append(this.style);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.action, i);
            parcel.writeString(this.text);
            parcel.writeString(this.style.name());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/DialogDeepLink$DialogButtonStyle;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY", "SECONDARY", "DANGER", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum DialogButtonStyle {
        PRIMARY,
        SECONDARY,
        DANGER
    }

    public static final class a extends Lambda implements Function1<Parcel, DialogDeepLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public DialogDeepLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            ControlsDirection controlsDirection = (ControlsDirection) ParcelsKt.readEnum(parcel2, ControlsDirection.values());
            boolean readBool = ParcelsKt.readBool(parcel2);
            boolean readBool2 = ParcelsKt.readBool(parcel2);
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, DialogButton.class);
            if (createParcelableList == null) {
                createParcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            return new DialogDeepLink(controlsDirection, readBool, readBool2, u22, createParcelableList, u2);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DialogDeepLink(ControlsDirection controlsDirection, boolean z, boolean z2, String str, List list, String str2, int i2, j jVar) {
        this((i2 & 1) != 0 ? ControlsDirection.VERTICAL : controlsDirection, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, str2);
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<DialogButton> getButtons() {
        return this.h;
    }

    @NotNull
    public final ControlsDirection getControlsDirection() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    public final boolean getShouldShowCloseControl() {
        return this.f;
    }

    @NotNull
    public final String getText() {
        return this.g;
    }

    @NotNull
    public final String getTitle() {
        return this.i;
    }

    public final boolean isCancellable() {
        return this.e;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeEnum(parcel, this.d);
        ParcelsKt.writeBool(parcel, this.e);
        ParcelsKt.writeBool(parcel, this.f);
        parcel.writeString(this.i);
        parcel.writeString(this.g);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.h, i2);
    }

    public DialogDeepLink(@NotNull ControlsDirection controlsDirection, boolean z, boolean z2, @NotNull String str, @NotNull List<DialogButton> list, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(controlsDirection, "controlsDirection");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.BUTTONS);
        Intrinsics.checkNotNullParameter(str2, "title");
        this.d = controlsDirection;
        this.e = z;
        this.f = z2;
        this.g = str;
        this.h = list;
        this.i = str2;
        this.c = PATH;
    }
}

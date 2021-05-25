package com.avito.android.remote.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.delivery.DeliveryLabel;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB%\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/AdvertDeliveryC2C$Switcher;", "switcher", "Lcom/avito/android/remote/model/AdvertDeliveryC2C$Switcher;", "getSwitcher", "()Lcom/avito/android/remote/model/AdvertDeliveryC2C$Switcher;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C$Info;", "info", "Lcom/avito/android/remote/model/AdvertDeliveryC2C$Info;", "getInfo", "()Lcom/avito/android/remote/model/AdvertDeliveryC2C$Info;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C$Actions;", "actions", "Lcom/avito/android/remote/model/AdvertDeliveryC2C$Actions;", "getActions", "()Lcom/avito/android/remote/model/AdvertDeliveryC2C$Actions;", "<init>", "(Lcom/avito/android/remote/model/AdvertDeliveryC2C$Actions;Lcom/avito/android/remote/model/AdvertDeliveryC2C$Info;Lcom/avito/android/remote/model/AdvertDeliveryC2C$Switcher;)V", "Actions", "Info", "Switcher", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDeliveryC2C implements Parcelable {
    public static final Parcelable.Creator<AdvertDeliveryC2C> CREATOR = new Creator();
    @SerializedName("actions")
    @Nullable
    private final Actions actions;
    @SerializedName("info")
    @Nullable
    private final Info info;
    @SerializedName("switcher")
    @Nullable
    private final Switcher switcher;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/AdvertDeliveryC2C$Actions;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SimpleAction;", "secondary", "Lcom/avito/android/remote/model/SimpleAction;", "getSecondary", "()Lcom/avito/android/remote/model/SimpleAction;", "Lcom/avito/android/remote/model/delivery/DeliveryLabel;", "secondaryLabel", "Lcom/avito/android/remote/model/delivery/DeliveryLabel;", "getSecondaryLabel", "()Lcom/avito/android/remote/model/delivery/DeliveryLabel;", "primary", "getPrimary", "<init>", "(Lcom/avito/android/remote/model/SimpleAction;Lcom/avito/android/remote/model/SimpleAction;Lcom/avito/android/remote/model/delivery/DeliveryLabel;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Actions implements Parcelable {
        public static final Parcelable.Creator<Actions> CREATOR = new Creator();
        @SerializedName("primary")
        @Nullable
        private final SimpleAction primary;
        @SerializedName("secondary")
        @Nullable
        private final SimpleAction secondary;
        @SerializedName("secondaryLabel")
        @Nullable
        private final DeliveryLabel secondaryLabel;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Actions> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Actions createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Actions((SimpleAction) parcel.readParcelable(Actions.class.getClassLoader()), (SimpleAction) parcel.readParcelable(Actions.class.getClassLoader()), parcel.readInt() != 0 ? DeliveryLabel.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Actions[] newArray(int i) {
                return new Actions[i];
            }
        }

        public Actions(@Nullable SimpleAction simpleAction, @Nullable SimpleAction simpleAction2, @Nullable DeliveryLabel deliveryLabel) {
            this.primary = simpleAction;
            this.secondary = simpleAction2;
            this.secondaryLabel = deliveryLabel;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final SimpleAction getPrimary() {
            return this.primary;
        }

        @Nullable
        public final SimpleAction getSecondary() {
            return this.secondary;
        }

        @Nullable
        public final DeliveryLabel getSecondaryLabel() {
            return this.secondaryLabel;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.primary, i);
            parcel.writeParcelable(this.secondary, i);
            DeliveryLabel deliveryLabel = this.secondaryLabel;
            if (deliveryLabel != null) {
                parcel.writeInt(1);
                deliveryLabel.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDeliveryC2C> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDeliveryC2C createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Switcher switcher = null;
            Actions createFromParcel = parcel.readInt() != 0 ? Actions.CREATOR.createFromParcel(parcel) : null;
            Info createFromParcel2 = parcel.readInt() != 0 ? Info.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                switcher = Switcher.CREATOR.createFromParcel(parcel);
            }
            return new AdvertDeliveryC2C(createFromParcel, createFromParcel2, switcher);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDeliveryC2C[] newArray(int i) {
            return new AdvertDeliveryC2C[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/AdvertDeliveryC2C$Info;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Landroid/net/Uri;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Info implements Parcelable {
        public static final Parcelable.Creator<Info> CREATOR = new Creator();
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final AttributedText subtitle;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final Uri uri;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Info> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Info createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Info(parcel.readString(), (AttributedText) parcel.readParcelable(Info.class.getClassLoader()), (Uri) parcel.readParcelable(Info.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Info[] newArray(int i) {
                return new Info[i];
            }
        }

        public Info(@NotNull String str, @Nullable AttributedText attributedText, @Nullable Uri uri2) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.subtitle = attributedText;
            this.uri = uri2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final AttributedText getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Uri getUri() {
            return this.uri;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.subtitle, i);
            parcel.writeParcelable(this.uri, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/AdvertDeliveryC2C$Switcher;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "value", "Z", "getValue", "()Z", "setValue", "(Z)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Ljava/lang/String;ZLcom/avito/android/remote/model/text/AttributedText;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Switcher implements Parcelable {
        public static final Parcelable.Creator<Switcher> CREATOR = new Creator();
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final AttributedText subtitle;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("value")
        private boolean value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Switcher> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Switcher createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Switcher(parcel.readString(), parcel.readInt() != 0, (AttributedText) parcel.readParcelable(Switcher.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Switcher[] newArray(int i) {
                return new Switcher[i];
            }
        }

        public Switcher(@NotNull String str, boolean z, @Nullable AttributedText attributedText) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.value = z;
            this.subtitle = attributedText;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final AttributedText getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final boolean getValue() {
            return this.value;
        }

        public final void setValue(boolean z) {
            this.value = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeInt(this.value ? 1 : 0);
            parcel.writeParcelable(this.subtitle, i);
        }
    }

    public AdvertDeliveryC2C(@Nullable Actions actions2, @Nullable Info info2, @Nullable Switcher switcher2) {
        this.actions = actions2;
        this.info = info2;
        this.switcher = switcher2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Actions getActions() {
        return this.actions;
    }

    @Nullable
    public final Info getInfo() {
        return this.info;
    }

    @Nullable
    public final Switcher getSwitcher() {
        return this.switcher;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Actions actions2 = this.actions;
        if (actions2 != null) {
            parcel.writeInt(1);
            actions2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Info info2 = this.info;
        if (info2 != null) {
            parcel.writeInt(1);
            info2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Switcher switcher2 = this.switcher;
        if (switcher2 != null) {
            parcel.writeInt(1);
            switcher2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}

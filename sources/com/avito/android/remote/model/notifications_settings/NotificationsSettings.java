package com.avito.android.remote.model.notifications_settings;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u001d\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "info", "Ljava/lang/String;", "getInfo", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section;", "sections", "Ljava/util/List;", "getSections", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "Section", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsSettings implements Parcelable {
    public static final Parcelable.Creator<NotificationsSettings> CREATOR = new Creator();
    @SerializedName("info")
    @NotNull
    private final String info;
    @SerializedName("sections")
    @NotNull
    private final List<Section> sections;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NotificationsSettings> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationsSettings createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Section.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new NotificationsSettings(arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationsSettings[] newArray(int i) {
            return new NotificationsSettings[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB-\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0018\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section$Channel;", ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS, "Ljava/util/List;", "getChannels", "()Ljava/util/List;", "", MessengerShareContentUtility.SUBTITLE, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "type", "getType", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", ScreenPublicConstsKt.CHANNEL_NAME, "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Section implements Parcelable {
        public static final Parcelable.Creator<Section> CREATOR = new Creator();
        @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS)
        @NotNull
        private final List<Channel> channels;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @NotNull
        private final String subtitle;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("type")
        @NotNull
        private final String type;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\u00020\t8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section$Channel;", "Landroid/os/Parcelable;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "title", "getTitle", "", "value", "Z", "getValue", "()Z", "setValue", "(Z)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Email", "Other", "Push", "notifications_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Channel implements Parcelable {
            @NotNull
            private final String title;
            @NotNull
            private final String type;
            private boolean value;

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section$Channel$Email;", "Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section$Channel;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "value", "Z", "getValue", "()Z", "setValue", "(Z)V", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
            public static final class Email extends Channel {
                public static final Parcelable.Creator<Email> CREATOR = new Creator();
                @NotNull
                private final String title;
                @NotNull
                private final String type;
                private boolean value;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Email> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Email createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Email(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Email[] newArray(int i) {
                        return new Email[i];
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Email(@NotNull String str, @NotNull String str2, boolean z) {
                    super(str, str2, z);
                    Intrinsics.checkNotNullParameter(str, "type");
                    Intrinsics.checkNotNullParameter(str2, "title");
                    this.type = str;
                    this.title = str2;
                    this.value = z;
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                @NotNull
                public String getTitle() {
                    return this.title;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                @NotNull
                public String getType() {
                    return this.type;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                public boolean getValue() {
                    return this.value;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                public void setValue(boolean z) {
                    this.value = z;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeString(this.type);
                    parcel.writeString(this.title);
                    parcel.writeInt(this.value ? 1 : 0);
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section$Channel$Other;", "Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section$Channel;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "value", "Z", "getValue", "()Z", "setValue", "(Z)V", "type", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
            public static final class Other extends Channel {
                public static final Parcelable.Creator<Other> CREATOR = new Creator();
                @NotNull
                private final String title;
                @NotNull
                private final String type;
                private boolean value;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Other> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Other createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Other(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Other[] newArray(int i) {
                        return new Other[i];
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Other(@NotNull String str, @NotNull String str2, boolean z) {
                    super(str, str2, z);
                    Intrinsics.checkNotNullParameter(str, "type");
                    Intrinsics.checkNotNullParameter(str2, "title");
                    this.type = str;
                    this.title = str2;
                    this.value = z;
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                @NotNull
                public String getTitle() {
                    return this.title;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                @NotNull
                public String getType() {
                    return this.type;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                public boolean getValue() {
                    return this.value;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                public void setValue(boolean z) {
                    this.value = z;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeString(this.type);
                    parcel.writeString(this.title);
                    parcel.writeInt(this.value ? 1 : 0);
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section$Channel$Push;", "Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section$Channel;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "value", "Z", "getValue", "()Z", "setValue", "(Z)V", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
            public static final class Push extends Channel {
                public static final Parcelable.Creator<Push> CREATOR = new Creator();
                @NotNull
                private final String title;
                @NotNull
                private final String type;
                private boolean value;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Push> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Push createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Push(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Push[] newArray(int i) {
                        return new Push[i];
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Push(@NotNull String str, @NotNull String str2, boolean z) {
                    super(str, str2, z);
                    Intrinsics.checkNotNullParameter(str, "type");
                    Intrinsics.checkNotNullParameter(str2, "title");
                    this.type = str;
                    this.title = str2;
                    this.value = z;
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                @NotNull
                public String getTitle() {
                    return this.title;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                @NotNull
                public String getType() {
                    return this.type;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                public boolean getValue() {
                    return this.value;
                }

                @Override // com.avito.android.remote.model.notifications_settings.NotificationsSettings.Section.Channel
                public void setValue(boolean z) {
                    this.value = z;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeString(this.type);
                    parcel.writeString(this.title);
                    parcel.writeInt(this.value ? 1 : 0);
                }
            }

            public Channel(@NotNull String str, @NotNull String str2, boolean z) {
                Intrinsics.checkNotNullParameter(str, "type");
                Intrinsics.checkNotNullParameter(str2, "title");
                this.type = str;
                this.title = str2;
                this.value = z;
            }

            @NotNull
            public String getTitle() {
                return this.title;
            }

            @NotNull
            public String getType() {
                return this.type;
            }

            public boolean getValue() {
                return this.value;
            }

            public void setValue(boolean z) {
                this.value = z;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Section> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Section createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Channel) parcel.readParcelable(Section.class.getClassLoader()));
                    readInt--;
                }
                return new Section(readString, readString2, readString3, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Section[] newArray(int i) {
                return new Section[i];
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.remote.model.notifications_settings.NotificationsSettings$Section$Channel> */
        /* JADX WARN: Multi-variable type inference failed */
        public Section(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<? extends Channel> list) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, MessengerShareContentUtility.SUBTITLE);
            Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS);
            this.type = str;
            this.title = str2;
            this.subtitle = str3;
            this.channels = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<Channel> getChannels() {
            return this.channels;
        }

        @NotNull
        public final String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.type);
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            Iterator n0 = a.n0(this.channels, parcel);
            while (n0.hasNext()) {
                parcel.writeParcelable((Channel) n0.next(), i);
            }
        }
    }

    public NotificationsSettings(@NotNull List<Section> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "sections");
        Intrinsics.checkNotNullParameter(str, "info");
        this.sections = list;
        this.info = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getInfo() {
        return this.info;
    }

    @NotNull
    public final List<Section> getSections() {
        return this.sections;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.sections, parcel);
        while (n0.hasNext()) {
            ((Section) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeString(this.info);
    }
}

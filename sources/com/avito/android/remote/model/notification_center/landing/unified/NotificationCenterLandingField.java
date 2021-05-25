package com.avito.android.remote.model.notification_center.landing.unified;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Sort;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "Landroid/os/Parcelable;", "<init>", "()V", "Button", "Description", "Divider", "Image", "Item", "PairButton", "Space", "Subtitle", "Title", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Button;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Description;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Divider;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Image;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Item;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$PairButton;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Space;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Subtitle;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Title;", "notifications_release"}, k = 1, mv = {1, 4, 2})
public abstract class NotificationCenterLandingField implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR*\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Button;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", "analyticParams", "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "<init>", "(Lcom/avito/android/remote/model/Action;Ljava/util/Map;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Button extends NotificationCenterLandingField {
        public static final Parcelable.Creator<Button> CREATOR = new Creator();
        @SerializedName("action")
        @NotNull
        private final Action action;
        @SerializedName("analyticParams")
        @Nullable
        private final Map<String, String> analyticParams;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Button> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Button createFromParcel(@NotNull Parcel parcel) {
                LinkedHashMap linkedHashMap;
                Intrinsics.checkNotNullParameter(parcel, "in");
                Action action = (Action) parcel.readParcelable(Button.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    linkedHashMap = new LinkedHashMap(readInt);
                    while (readInt != 0) {
                        readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                    }
                } else {
                    linkedHashMap = null;
                }
                return new Button(action, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Button[] newArray(int i) {
                return new Button[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Button(@NotNull Action action2, @Nullable Map<String, String> map) {
            super(null);
            Intrinsics.checkNotNullParameter(action2, "action");
            this.action = action2;
            this.analyticParams = map;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final Action getAction() {
            return this.action;
        }

        @Nullable
        public final Map<String, String> getAnalyticParams() {
            return this.analyticParams;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Map$Entry, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // android.os.Parcelable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
            /*
                r2 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                com.avito.android.remote.model.Action r0 = r2.action
                r3.writeParcelable(r0, r4)
                java.util.Map<java.lang.String, java.lang.String> r4 = r2.analyticParams
                if (r4 == 0) goto L_0x0030
                r0 = 1
                java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
            L_0x0013:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x0034
                java.lang.Object r0 = r4.next()
                java.lang.Object r1 = r0.getKey()
                java.lang.String r1 = (java.lang.String) r1
                r3.writeString(r1)
                java.lang.Object r0 = r0.getValue()
                java.lang.String r0 = (java.lang.String) r0
                r3.writeString(r0)
                goto L_0x0013
            L_0x0030:
                r4 = 0
                r3.writeInt(r4)
            L_0x0034:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingField.Button.writeToParcel(android.os.Parcel, int):void");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Description;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Description extends NotificationCenterLandingField {
        public static final Parcelable.Creator<Description> CREATOR = new Creator();
        @SerializedName("description")
        @NotNull
        private final String description;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Description> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Description createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Description(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Description[] newArray(int i) {
                return new Description[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Description(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "description");
            this.description = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.description);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Divider;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Divider extends NotificationCenterLandingField {
        public static final Parcelable.Creator<Divider> CREATOR = new Creator();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Divider> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Divider createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return new Divider();
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Divider[] newArray(int i) {
                return new Divider[i];
            }
        }

        public Divider() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Image;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "<init>", "(Lcom/avito/android/remote/model/Image;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Image extends NotificationCenterLandingField {
        public static final Parcelable.Creator<Image> CREATOR = new Creator();
        @SerializedName("image")
        @NotNull
        private final com.avito.android.remote.model.Image image;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Image> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Image createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Image((com.avito.android.remote.model.Image) parcel.readParcelable(Image.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Image[] newArray(int i) {
                return new Image[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Image(@NotNull com.avito.android.remote.model.Image image2) {
            super(null);
            Intrinsics.checkNotNullParameter(image2, "image");
            this.image = image2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final com.avito.android.remote.model.Image getImage() {
            return this.image;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.image, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\"\u001a\u00020\u0010¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R*\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R\u001e\u0010$\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0014R\u001c\u0010'\u001a\u00020&8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010\u0014R\u001e\u0010-\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014¨\u00061"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Item;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "price", "Ljava/lang/String;", "getPrice", "()Ljava/lang/String;", "", "isFavorite", "Z", "()Z", "id", "getId", Sort.DISTANCE, "getDistance", "", "analyticParams", "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "title", "getTitle", "priceWithoutDiscount", "getPriceWithoutDiscount", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "location", "getLocation", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "getAddress", "<init>", "(ZLcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Item extends NotificationCenterLandingField {
        public static final Parcelable.Creator<Item> CREATOR = new Creator();
        @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
        @Nullable
        private final String address;
        @SerializedName("analyticParams")
        @Nullable
        private final Map<String, String> analyticParams;
        @SerializedName(ShareConstants.MEDIA_URI)
        @NotNull
        private final DeepLink deepLink;
        @SerializedName(Sort.DISTANCE)
        @Nullable
        private final String distance;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("image")
        @NotNull
        private final com.avito.android.remote.model.Image image;
        @SerializedName("isFavorite")
        private final boolean isFavorite;
        @SerializedName("location")
        @Nullable
        private final String location;
        @SerializedName("price")
        @NotNull
        private final String price;
        @SerializedName("priceWithoutDiscount")
        @Nullable
        private final String priceWithoutDiscount;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Item> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item createFromParcel(@NotNull Parcel parcel) {
                LinkedHashMap linkedHashMap;
                Intrinsics.checkNotNullParameter(parcel, "in");
                boolean z = parcel.readInt() != 0;
                DeepLink deepLink = (DeepLink) parcel.readParcelable(Item.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    linkedHashMap = new LinkedHashMap(readInt);
                    while (readInt != 0) {
                        readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                    }
                } else {
                    linkedHashMap = null;
                }
                return new Item(z, deepLink, linkedHashMap, (com.avito.android.remote.model.Image) parcel.readParcelable(Item.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item[] newArray(int i) {
                return new Item[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Item(boolean z, @NotNull DeepLink deepLink2, @Nullable Map<String, String> map, @NotNull com.avito.android.remote.model.Image image2, @Nullable String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @Nullable String str6, @NotNull String str7) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
            Intrinsics.checkNotNullParameter(image2, "image");
            Intrinsics.checkNotNullParameter(str3, "id");
            Intrinsics.checkNotNullParameter(str5, "price");
            Intrinsics.checkNotNullParameter(str7, "title");
            this.isFavorite = z;
            this.deepLink = deepLink2;
            this.analyticParams = map;
            this.image = image2;
            this.address = str;
            this.distance = str2;
            this.id = str3;
            this.location = str4;
            this.price = str5;
            this.priceWithoutDiscount = str6;
            this.title = str7;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getAddress() {
            return this.address;
        }

        @Nullable
        public final Map<String, String> getAnalyticParams() {
            return this.analyticParams;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.deepLink;
        }

        @Nullable
        public final String getDistance() {
            return this.distance;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final com.avito.android.remote.model.Image getImage() {
            return this.image;
        }

        @Nullable
        public final String getLocation() {
            return this.location;
        }

        @NotNull
        public final String getPrice() {
            return this.price;
        }

        @Nullable
        public final String getPriceWithoutDiscount() {
            return this.priceWithoutDiscount;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final boolean isFavorite() {
            return this.isFavorite;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Map$Entry, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // android.os.Parcelable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r4, int r5) {
            /*
                r3 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                boolean r0 = r3.isFavorite
                r4.writeInt(r0)
                com.avito.android.deep_linking.links.DeepLink r0 = r3.deepLink
                r4.writeParcelable(r0, r5)
                java.util.Map<java.lang.String, java.lang.String> r0 = r3.analyticParams
                if (r0 == 0) goto L_0x0035
                r1 = 1
                java.util.Iterator r0 = a2.b.a.a.a.m0(r4, r1, r0)
            L_0x0018:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0039
                java.lang.Object r1 = r0.next()
                java.lang.Object r2 = r1.getKey()
                java.lang.String r2 = (java.lang.String) r2
                r4.writeString(r2)
                java.lang.Object r1 = r1.getValue()
                java.lang.String r1 = (java.lang.String) r1
                r4.writeString(r1)
                goto L_0x0018
            L_0x0035:
                r0 = 0
                r4.writeInt(r0)
            L_0x0039:
                com.avito.android.remote.model.Image r0 = r3.image
                r4.writeParcelable(r0, r5)
                java.lang.String r5 = r3.address
                r4.writeString(r5)
                java.lang.String r5 = r3.distance
                r4.writeString(r5)
                java.lang.String r5 = r3.id
                r4.writeString(r5)
                java.lang.String r5 = r3.location
                r4.writeString(r5)
                java.lang.String r5 = r3.price
                r4.writeString(r5)
                java.lang.String r5 = r3.priceWithoutDiscount
                r4.writeString(r5)
                java.lang.String r5 = r3.title
                r4.writeString(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingField.Item.writeToParcel(android.os.Parcel, int):void");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$PairButton;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$PairButton$OneButton;", "second", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$PairButton$OneButton;", "getSecond", "()Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$PairButton$OneButton;", InternalConstsKt.FIRST_IMAGE, "getFirst", "<init>", "(Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$PairButton$OneButton;Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$PairButton$OneButton;)V", "OneButton", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class PairButton extends NotificationCenterLandingField {
        public static final Parcelable.Creator<PairButton> CREATOR = new Creator();
        @SerializedName(InternalConstsKt.FIRST_IMAGE)
        @NotNull
        private final OneButton first;
        @SerializedName("second")
        @NotNull
        private final OneButton second;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<PairButton> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PairButton createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                Parcelable.Creator<OneButton> creator = OneButton.CREATOR;
                return new PairButton(creator.createFromParcel(parcel), creator.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PairButton[] newArray(int i) {
                return new PairButton[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR*\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$PairButton$OneButton;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", "analyticParams", "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "<init>", "(Lcom/avito/android/remote/model/Action;Ljava/util/Map;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
        public static final class OneButton implements Parcelable {
            public static final Parcelable.Creator<OneButton> CREATOR = new Creator();
            @SerializedName("action")
            @NotNull
            private final Action action;
            @SerializedName("analyticParams")
            @Nullable
            private final Map<String, String> analyticParams;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<OneButton> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final OneButton createFromParcel(@NotNull Parcel parcel) {
                    LinkedHashMap linkedHashMap;
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    Action action = (Action) parcel.readParcelable(OneButton.class.getClassLoader());
                    if (parcel.readInt() != 0) {
                        int readInt = parcel.readInt();
                        linkedHashMap = new LinkedHashMap(readInt);
                        while (readInt != 0) {
                            readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                        }
                    } else {
                        linkedHashMap = null;
                    }
                    return new OneButton(action, linkedHashMap);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final OneButton[] newArray(int i) {
                    return new OneButton[i];
                }
            }

            public OneButton(@NotNull Action action2, @Nullable Map<String, String> map) {
                Intrinsics.checkNotNullParameter(action2, "action");
                this.action = action2;
                this.analyticParams = map;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final Action getAction() {
                return this.action;
            }

            @Nullable
            public final Map<String, String> getAnalyticParams() {
                return this.analyticParams;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Map$Entry, java.lang.Object] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // android.os.Parcelable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
                /*
                    r2 = this;
                    java.lang.String r0 = "parcel"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    com.avito.android.remote.model.Action r0 = r2.action
                    r3.writeParcelable(r0, r4)
                    java.util.Map<java.lang.String, java.lang.String> r4 = r2.analyticParams
                    if (r4 == 0) goto L_0x0030
                    r0 = 1
                    java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
                L_0x0013:
                    boolean r0 = r4.hasNext()
                    if (r0 == 0) goto L_0x0034
                    java.lang.Object r0 = r4.next()
                    java.lang.Object r1 = r0.getKey()
                    java.lang.String r1 = (java.lang.String) r1
                    r3.writeString(r1)
                    java.lang.Object r0 = r0.getValue()
                    java.lang.String r0 = (java.lang.String) r0
                    r3.writeString(r0)
                    goto L_0x0013
                L_0x0030:
                    r4 = 0
                    r3.writeInt(r4)
                L_0x0034:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingField.PairButton.OneButton.writeToParcel(android.os.Parcel, int):void");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PairButton(@NotNull OneButton oneButton, @NotNull OneButton oneButton2) {
            super(null);
            Intrinsics.checkNotNullParameter(oneButton, InternalConstsKt.FIRST_IMAGE);
            Intrinsics.checkNotNullParameter(oneButton2, "second");
            this.first = oneButton;
            this.second = oneButton2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final OneButton getFirst() {
            return this.first;
        }

        @NotNull
        public final OneButton getSecond() {
            return this.second;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.first.writeToParcel(parcel, 0);
            this.second.writeToParcel(parcel, 0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Space;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Space extends NotificationCenterLandingField {
        public static final Parcelable.Creator<Space> CREATOR = new Creator();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Space> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Space createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return new Space();
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Space[] newArray(int i) {
                return new Space[i];
            }
        }

        public Space() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Subtitle;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "", "", "analyticParams", "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Lcom/avito/android/remote/model/Action;Ljava/util/Map;Ljava/lang/String;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Subtitle extends NotificationCenterLandingField {
        public static final Parcelable.Creator<Subtitle> CREATOR = new Creator();
        @SerializedName("action")
        @Nullable
        private final Action action;
        @SerializedName("analyticParams")
        @Nullable
        private final Map<String, String> analyticParams;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Subtitle> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Subtitle createFromParcel(@NotNull Parcel parcel) {
                LinkedHashMap linkedHashMap;
                Intrinsics.checkNotNullParameter(parcel, "in");
                Action action = (Action) parcel.readParcelable(Subtitle.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    linkedHashMap = new LinkedHashMap(readInt);
                    while (readInt != 0) {
                        readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                    }
                } else {
                    linkedHashMap = null;
                }
                return new Subtitle(action, linkedHashMap, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Subtitle[] newArray(int i) {
                return new Subtitle[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Subtitle(@Nullable Action action2, @Nullable Map<String, String> map, @NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.action = action2;
            this.analyticParams = map;
            this.title = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Action getAction() {
            return this.action;
        }

        @Nullable
        public final Map<String, String> getAnalyticParams() {
            return this.analyticParams;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Map$Entry, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // android.os.Parcelable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
            /*
                r2 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                com.avito.android.remote.model.Action r0 = r2.action
                r3.writeParcelable(r0, r4)
                java.util.Map<java.lang.String, java.lang.String> r4 = r2.analyticParams
                if (r4 == 0) goto L_0x0030
                r0 = 1
                java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
            L_0x0013:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x0034
                java.lang.Object r0 = r4.next()
                java.lang.Object r1 = r0.getKey()
                java.lang.String r1 = (java.lang.String) r1
                r3.writeString(r1)
                java.lang.Object r0 = r0.getValue()
                java.lang.String r0 = (java.lang.String) r0
                r3.writeString(r0)
                goto L_0x0013
            L_0x0030:
                r4 = 0
                r3.writeInt(r4)
            L_0x0034:
                java.lang.String r4 = r2.title
                r3.writeString(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingField.Subtitle.writeToParcel(android.os.Parcel, int):void");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField$Title;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Title extends NotificationCenterLandingField {
        public static final Parcelable.Creator<Title> CREATOR = new Creator();
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Title> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Title createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Title(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Title[] newArray(int i) {
                return new Title[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Title(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
        }
    }

    private NotificationCenterLandingField() {
    }

    public /* synthetic */ NotificationCenterLandingField(j jVar) {
        this();
    }
}

package com.avito.android.remote.model.notification_center;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0017\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0019\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R*\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingFeedback;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "", "positiveActionTitle", "Ljava/lang/String;", "getPositiveActionTitle", "()Ljava/lang/String;", "title", "getTitle", "description", "getDescription", "negativeActionTitle", "getNegativeActionTitle", "", "analyticParams", "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "<init>", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingFeedback implements Parcelable {
    public static final Parcelable.Creator<NotificationCenterLandingFeedback> CREATOR = new Creator();
    @SerializedName("analyticParams")
    @Nullable
    private final Map<String, String> analyticParams;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("image")
    @NotNull
    private final Image image;
    @SerializedName("negativeActionTitle")
    @NotNull
    private final String negativeActionTitle;
    @SerializedName("positiveActionTitle")
    @NotNull
    private final String positiveActionTitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NotificationCenterLandingFeedback> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationCenterLandingFeedback createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            Image image = (Image) parcel.readParcelable(NotificationCenterLandingFeedback.class.getClassLoader());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new NotificationCenterLandingFeedback(image, readString, readString2, readString3, readString4, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationCenterLandingFeedback[] newArray(int i) {
            return new NotificationCenterLandingFeedback[i];
        }
    }

    public NotificationCenterLandingFeedback(@NotNull Image image2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "positiveActionTitle");
        Intrinsics.checkNotNullParameter(str4, "negativeActionTitle");
        this.image = image2;
        this.title = str;
        this.description = str2;
        this.positiveActionTitle = str3;
        this.negativeActionTitle = str4;
        this.analyticParams = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Map<String, String> getAnalyticParams() {
        return this.analyticParams;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final String getNegativeActionTitle() {
        return this.negativeActionTitle;
    }

    @NotNull
    public final String getPositiveActionTitle() {
        return this.positiveActionTitle;
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
            com.avito.android.remote.model.Image r0 = r2.image
            r3.writeParcelable(r0, r4)
            java.lang.String r4 = r2.title
            r3.writeString(r4)
            java.lang.String r4 = r2.description
            r3.writeString(r4)
            java.lang.String r4 = r2.positiveActionTitle
            r3.writeString(r4)
            java.lang.String r4 = r2.negativeActionTitle
            r3.writeString(r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.analyticParams
            if (r4 == 0) goto L_0x0044
            r0 = 1
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x0027:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0048
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x0027
        L_0x0044:
            r4 = 0
            r3.writeInt(r4)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.notification_center.NotificationCenterLandingFeedback.writeToParcel(android.os.Parcel, int):void");
    }
}

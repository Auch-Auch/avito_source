package com.avito.android.remote.model.notification_center;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR*\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u00020\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingMain;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", "analyticParams", "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "<init>", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/util/Map;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingMain implements Parcelable {
    public static final Parcelable.Creator<NotificationCenterLandingMain> CREATOR = new Creator();
    @SerializedName("action")
    @NotNull
    private final Action action;
    @SerializedName("analyticParams")
    @Nullable
    private final Map<String, String> analyticParams;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("image")
    @Nullable
    private final Image image;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NotificationCenterLandingMain> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationCenterLandingMain createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            Image image = (Image) parcel.readParcelable(NotificationCenterLandingMain.class.getClassLoader());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Action action = (Action) parcel.readParcelable(NotificationCenterLandingMain.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new NotificationCenterLandingMain(image, readString, readString2, action, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationCenterLandingMain[] newArray(int i) {
            return new NotificationCenterLandingMain[i];
        }
    }

    public NotificationCenterLandingMain(@Nullable Image image2, @NotNull String str, @NotNull String str2, @NotNull Action action2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(action2, "action");
        this.image = image2;
        this.title = str;
        this.description = str2;
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

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.Map$Entry, java.lang.Object] */
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
            java.lang.String r0 = r2.title
            r3.writeString(r0)
            java.lang.String r0 = r2.description
            r3.writeString(r0)
            com.avito.android.remote.model.Action r0 = r2.action
            r3.writeParcelable(r0, r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.analyticParams
            if (r4 == 0) goto L_0x003f
            r0 = 1
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x0022:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0043
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x0022
        L_0x003f:
            r4 = 0
            r3.writeInt(r4)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.notification_center.NotificationCenterLandingMain.writeToParcel(android.os.Parcel, int):void");
    }
}

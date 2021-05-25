package com.avito.android.remote.model.notification;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Sort;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010$¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u00020\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010 \u001a\u00020\u001f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R*\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010$8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/notification/Notification;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "", "isRead", "Z", "()Z", "setRead", "(Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "id", "getId", "", Sort.DATE, "J", "getDate", "()J", "", "analyticParams", "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class Notification implements Parcelable {
    public static final Parcelable.Creator<Notification> CREATOR = new Creator();
    @SerializedName("analyticParams")
    @Nullable
    private final Map<String, String> analyticParams;
    @SerializedName(Sort.DATE)
    private final long date;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("isRead")
    private boolean isRead;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink uri;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Notification> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Notification createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            long readLong = parcel.readLong();
            boolean z = parcel.readInt() != 0;
            DeepLink deepLink = (DeepLink) parcel.readParcelable(Notification.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new Notification(readString, readString2, readString3, readLong, z, deepLink, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Notification[] newArray(int i) {
            return new Notification[i];
        }
    }

    public Notification(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, boolean z, @NotNull DeepLink deepLink, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
        this.id = str;
        this.title = str2;
        this.description = str3;
        this.date = j;
        this.isRead = z;
        this.uri = deepLink;
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

    public final long getDate() {
        return this.date;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final DeepLink getUri() {
        return this.uri;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final void setRead(boolean z) {
        this.isRead = z;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = r2.id
            r3.writeString(r0)
            java.lang.String r0 = r2.title
            r3.writeString(r0)
            java.lang.String r0 = r2.description
            r3.writeString(r0)
            long r0 = r2.date
            r3.writeLong(r0)
            boolean r0 = r2.isRead
            r3.writeInt(r0)
            com.avito.android.deep_linking.links.DeepLink r0 = r2.uri
            r3.writeParcelable(r0, r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.analyticParams
            if (r4 == 0) goto L_0x0049
            r0 = 1
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x002c:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x004d
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x002c
        L_0x0049:
            r4 = 0
            r3.writeInt(r4)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.notification.Notification.writeToParcel(android.os.Parcel, int):void");
    }
}

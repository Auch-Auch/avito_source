package com.avito.android.user_advert.advert.service;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
public final class NotificationAnalyticParams implements Parcelable {
    public static final Parcelable.Creator<NotificationAnalyticParams> CREATOR = new Creator();
    @NotNull
    public final Map<String, String> a;
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NotificationAnalyticParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationAnalyticParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            while (readInt != 0) {
                readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
            }
            return new NotificationAnalyticParams(linkedHashMap, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationAnalyticParams[] newArray(int i) {
            return new NotificationAnalyticParams[i];
        }
    }

    public NotificationAnalyticParams(@NotNull Map<String, String> map, @NotNull String str) {
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(str, "buttonName");
        this.a = map;
        this.b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
        /*
            r2 = this;
            java.lang.String r4 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.a
            java.util.Iterator r4 = a2.b.a.a.a.o0(r4, r3)
        L_0x000b:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x000b
        L_0x0028:
            java.lang.String r4 = r2.b
            r3.writeString(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_advert.advert.service.NotificationAnalyticParams.writeToParcel(android.os.Parcel, int):void");
    }
}

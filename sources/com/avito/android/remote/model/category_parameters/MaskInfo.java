package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.model.Color;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/MaskInfo;", "Landroid/os/Parcelable;", "", InternalConstsKt.PLACEHOLDER, "", "isConstrainedPlaceholder", "(C)Z", FirebaseAnalytics.Param.CHARACTER, "isCharacterMatchesToConstraints", "(CC)Z", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", "constraints", "Ljava/util/Map;", "getConstraints", "()Ljava/util/Map;", "mask", "Ljava/lang/String;", "getMask", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Color;", "backgroundColor", "Lcom/avito/android/remote/model/Color;", "getBackgroundColor", "()Lcom/avito/android/remote/model/Color;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Color;Ljava/util/Map;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MaskInfo implements Parcelable {
    public static final Parcelable.Creator<MaskInfo> CREATOR = new Creator();
    @SerializedName("color")
    @Nullable
    private final Color backgroundColor;
    @SerializedName("constraints")
    @Nullable
    private final Map<String, String> constraints;
    @SerializedName("mask")
    @NotNull
    private final String mask;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MaskInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MaskInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            LinkedHashMap linkedHashMap = null;
            Color createFromParcel = parcel.readInt() != 0 ? Color.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap2, parcel.readString(), readInt, -1);
                }
                linkedHashMap = linkedHashMap2;
            }
            return new MaskInfo(readString, createFromParcel, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MaskInfo[] newArray(int i) {
            return new MaskInfo[i];
        }
    }

    public MaskInfo(@NotNull String str, @Nullable Color color, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "mask");
        this.mask = str;
        this.backgroundColor = color;
        this.constraints = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final Map<String, String> getConstraints() {
        return this.constraints;
    }

    @NotNull
    public final String getMask() {
        return this.mask;
    }

    public final boolean isCharacterMatchesToConstraints(char c, char c2) {
        String str;
        Map<String, String> map = this.constraints;
        if (map == null || (str = map.get(String.valueOf(c))) == null) {
            return false;
        }
        return StringsKt__StringsKt.contains$default((CharSequence) str, c2, false, 2, (Object) null);
    }

    public final boolean isConstrainedPlaceholder(char c) {
        Map<String, String> map = this.constraints;
        return (map != null ? map.get(String.valueOf(c)) : null) != null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
        /*
            r2 = this;
            java.lang.String r4 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            java.lang.String r4 = r2.mask
            r3.writeString(r4)
            com.avito.android.remote.model.Color r4 = r2.backgroundColor
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0017
            r3.writeInt(r0)
            r4.writeToParcel(r3, r1)
            goto L_0x001a
        L_0x0017:
            r3.writeInt(r1)
        L_0x001a:
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.constraints
            if (r4 == 0) goto L_0x003f
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x0022:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0042
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x0022
        L_0x003f:
            r3.writeInt(r1)
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.category_parameters.MaskInfo.writeToParcel(android.os.Parcel, int):void");
    }
}

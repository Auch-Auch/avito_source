package com.avito.android.calls_shared;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bF\u0010GB1\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010H\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\bF\u0010IJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017Jf\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b)\u0010$J \u0010.\u001a\u00020-2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b.\u0010/R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u000bR\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0011R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0017R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b?\u00101\u001a\u0004\b@\u0010\u0013R\u0019\u0010\u0019\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\u001b\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u000e¨\u0006J"}, d2 = {"Lcom/avito/android/calls_shared/AppCallInfo;", "Landroid/os/Parcelable;", "", "toString", "()Ljava/lang/String;", "component1", "", "component2", "()Z", "Lcom/avito/android/calls_shared/CallerInfo;", "component3", "()Lcom/avito/android/calls_shared/CallerInfo;", "", "component4", "()J", "Lcom/avito/android/calls_shared/AppCallScenario;", "component5", "()Lcom/avito/android/calls_shared/AppCallScenario;", "component6", "()Ljava/lang/Long;", "component7", "Lcom/avito/android/calls_shared/ItemInfo;", "component8", "()Lcom/avito/android/calls_shared/ItemInfo;", "callId", "isIncoming", "caller", "startTimestamp", "scenario", "connectTimestamp", "endTimestamp", "item", "copy", "(Ljava/lang/String;ZLcom/avito/android/calls_shared/CallerInfo;JLcom/avito/android/calls_shared/AppCallScenario;Ljava/lang/Long;Ljava/lang/Long;Lcom/avito/android/calls_shared/ItemInfo;)Lcom/avito/android/calls_shared/AppCallInfo;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "Ljava/lang/Long;", "getConnectTimestamp", "c", "Lcom/avito/android/calls_shared/CallerInfo;", "getCaller", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCallId", "e", "Lcom/avito/android/calls_shared/AppCallScenario;", "getScenario", "h", "Lcom/avito/android/calls_shared/ItemInfo;", "getItem", g.a, "getEndTimestamp", AuthSource.BOOKING_ORDER, "Z", "d", "J", "getStartTimestamp", "<init>", "(Ljava/lang/String;ZLcom/avito/android/calls_shared/CallerInfo;JLcom/avito/android/calls_shared/AppCallScenario;Ljava/lang/Long;Ljava/lang/Long;Lcom/avito/android/calls_shared/ItemInfo;)V", "contact", "(Ljava/lang/String;Ljava/lang/String;ZJLcom/avito/android/calls_shared/AppCallScenario;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class AppCallInfo implements Parcelable {
    public static final Parcelable.Creator<AppCallInfo> CREATOR = new Creator();
    @NotNull
    public final String a;
    public final boolean b;
    @NotNull
    public final CallerInfo c;
    public final long d;
    @NotNull
    public final AppCallScenario e;
    @Nullable
    public final Long f;
    @Nullable
    public final Long g;
    @Nullable
    public final ItemInfo h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AppCallInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppCallInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AppCallInfo(parcel.readString(), parcel.readInt() != 0, CallerInfo.CREATOR.createFromParcel(parcel), parcel.readLong(), (AppCallScenario) Enum.valueOf(AppCallScenario.class, parcel.readString()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? ItemInfo.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppCallInfo[] newArray(int i) {
            return new AppCallInfo[i];
        }
    }

    public AppCallInfo(@NotNull String str, boolean z, @NotNull CallerInfo callerInfo, long j, @NotNull AppCallScenario appCallScenario, @Nullable Long l, @Nullable Long l2, @Nullable ItemInfo itemInfo) {
        Intrinsics.checkNotNullParameter(str, "callId");
        Intrinsics.checkNotNullParameter(callerInfo, "caller");
        Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
        this.a = str;
        this.b = z;
        this.c = callerInfo;
        this.d = j;
        this.e = appCallScenario;
        this.f = l;
        this.g = l2;
        this.h = itemInfo;
    }

    public static /* synthetic */ AppCallInfo copy$default(AppCallInfo appCallInfo, String str, boolean z, CallerInfo callerInfo, long j, AppCallScenario appCallScenario, Long l, Long l2, ItemInfo itemInfo, int i, Object obj) {
        return appCallInfo.copy((i & 1) != 0 ? appCallInfo.a : str, (i & 2) != 0 ? appCallInfo.b : z, (i & 4) != 0 ? appCallInfo.c : callerInfo, (i & 8) != 0 ? appCallInfo.d : j, (i & 16) != 0 ? appCallInfo.e : appCallScenario, (i & 32) != 0 ? appCallInfo.f : l, (i & 64) != 0 ? appCallInfo.g : l2, (i & 128) != 0 ? appCallInfo.h : itemInfo);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    @NotNull
    public final CallerInfo component3() {
        return this.c;
    }

    public final long component4() {
        return this.d;
    }

    @NotNull
    public final AppCallScenario component5() {
        return this.e;
    }

    @Nullable
    public final Long component6() {
        return this.f;
    }

    @Nullable
    public final Long component7() {
        return this.g;
    }

    @Nullable
    public final ItemInfo component8() {
        return this.h;
    }

    @NotNull
    public final AppCallInfo copy(@NotNull String str, boolean z, @NotNull CallerInfo callerInfo, long j, @NotNull AppCallScenario appCallScenario, @Nullable Long l, @Nullable Long l2, @Nullable ItemInfo itemInfo) {
        Intrinsics.checkNotNullParameter(str, "callId");
        Intrinsics.checkNotNullParameter(callerInfo, "caller");
        Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
        return new AppCallInfo(str, z, callerInfo, j, appCallScenario, l, l2, itemInfo);
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
        if (!(obj instanceof AppCallInfo)) {
            return false;
        }
        AppCallInfo appCallInfo = (AppCallInfo) obj;
        return Intrinsics.areEqual(this.a, appCallInfo.a) && this.b == appCallInfo.b && Intrinsics.areEqual(this.c, appCallInfo.c) && this.d == appCallInfo.d && Intrinsics.areEqual(this.e, appCallInfo.e) && Intrinsics.areEqual(this.f, appCallInfo.f) && Intrinsics.areEqual(this.g, appCallInfo.g) && Intrinsics.areEqual(this.h, appCallInfo.h);
    }

    @NotNull
    public final String getCallId() {
        return this.a;
    }

    @NotNull
    public final CallerInfo getCaller() {
        return this.c;
    }

    @Nullable
    public final Long getConnectTimestamp() {
        return this.f;
    }

    @Nullable
    public final Long getEndTimestamp() {
        return this.g;
    }

    @Nullable
    public final ItemInfo getItem() {
        return this.h;
    }

    @NotNull
    public final AppCallScenario getScenario() {
        return this.e;
    }

    public final long getStartTimestamp() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode + i2) * 31;
        CallerInfo callerInfo = this.c;
        int hashCode2 = (((i5 + (callerInfo != null ? callerInfo.hashCode() : 0)) * 31) + c.a(this.d)) * 31;
        AppCallScenario appCallScenario = this.e;
        int hashCode3 = (hashCode2 + (appCallScenario != null ? appCallScenario.hashCode() : 0)) * 31;
        Long l = this.f;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.g;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        ItemInfo itemInfo = this.h;
        if (itemInfo != null) {
            i = itemInfo.hashCode();
        }
        return hashCode5 + i;
    }

    public final boolean isIncoming() {
        return this.b;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AppCallInfo(callId=");
        L.append(this.a);
        L.append(", isIncoming=");
        L.append(this.b);
        L.append(", callerContact=");
        L.append(this.c.getContact());
        L.append(", item=");
        L.append(this.h);
        L.append(')');
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeInt(this.b ? 1 : 0);
        this.c.writeToParcel(parcel, 0);
        parcel.writeLong(this.d);
        parcel.writeString(this.e.name());
        Long l = this.f;
        if (l != null) {
            a.I0(parcel, 1, l);
        } else {
            parcel.writeInt(0);
        }
        Long l2 = this.g;
        if (l2 != null) {
            a.I0(parcel, 1, l2);
        } else {
            parcel.writeInt(0);
        }
        ItemInfo itemInfo = this.h;
        if (itemInfo != null) {
            parcel.writeInt(1);
            itemInfo.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppCallInfo(String str, boolean z, CallerInfo callerInfo, long j, AppCallScenario appCallScenario, Long l, Long l2, ItemInfo itemInfo, int i, j jVar) {
        this(str, z, callerInfo, j, appCallScenario, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : l2, (i & 128) != 0 ? null : itemInfo);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AppCallInfo(@NotNull String str, @NotNull String str2, boolean z, long j, @NotNull AppCallScenario appCallScenario) {
        this(str, z, new CallerInfo(str2), j, appCallScenario, null, null, null, 128, null);
        Intrinsics.checkNotNullParameter(str, "callId");
        Intrinsics.checkNotNullParameter(str2, "contact");
        Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
    }
}

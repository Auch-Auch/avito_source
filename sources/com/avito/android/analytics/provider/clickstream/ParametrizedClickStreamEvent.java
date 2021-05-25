package com.avito.android.analytics.provider.clickstream;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ParcelUtils;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\t\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B5\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070!\u0012\b\b\u0002\u0010 \u001a\u00020\u0003¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u000eR\u001c\u0010\u0019\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000eR\u001c\u0010\u001c\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u000eR\u0019\u0010 \u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R(\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "Landroid/os/Parcelable;", "", "toString", "()Ljava/lang/String;", "description", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", AuthSource.BOOKING_ORDER, "I", "getVersion", "version", AuthSource.SEND_ABUSE, "getEventId", "eventId", "d", "Ljava/lang/String;", "getName", "name", "", "c", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "<init>", "(IILjava/util/Map;Ljava/lang/String;)V", "Companion", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public final class ParametrizedClickStreamEvent implements ClickStreamEvent, Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ParametrizedClickStreamEvent> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a;
    public final int b;
    @NotNull
    public final Map<String, Object> c;
    @NotNull
    public final String d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ParametrizedClickStreamEvent> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ParametrizedClickStreamEvent invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            int readInt = parcel2.readInt();
            int readInt2 = parcel2.readInt();
            Map createValueMap = ParcelUtils.createValueMap(parcel2, String.class, Object.class);
            if (createValueMap == null) {
                createValueMap = r.emptyMap();
            }
            return new ParametrizedClickStreamEvent(readInt, readInt2, createValueMap, a2.b.a.a.a.u2(parcel2, "readString()!!"));
        }
    }

    public ParametrizedClickStreamEvent(int i, int i2, @NotNull Map<String, ? extends Object> map, @NotNull String str) {
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = i;
        this.b = i2;
        this.c = map;
        this.d = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.d + " (id:" + getEventId() + ", params:" + getParams() + ", version:" + getVersion() + ')';
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(ParametrizedClickStreamEvent.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent");
        ParametrizedClickStreamEvent parametrizedClickStreamEvent = (ParametrizedClickStreamEvent) obj;
        return getEventId() == parametrizedClickStreamEvent.getEventId() && getVersion() == parametrizedClickStreamEvent.getVersion() && !(Intrinsics.areEqual(getParams(), parametrizedClickStreamEvent.getParams()) ^ true);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.a;
    }

    @NotNull
    public final String getName() {
        return this.d;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.c;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int version = getVersion();
        return getParams().hashCode() + ((version + (getEventId() * 31)) * 31);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return description();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeInt(getEventId());
        parcel.writeInt(getVersion());
        ParcelsKt.writeValueMap(parcel, getParams());
        parcel.writeString(this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParametrizedClickStreamEvent(int i, int i2, Map map, String str, int i3, j jVar) {
        this(i, i2, map, (i3 & 8) != 0 ? "ParametrizedClickStreamEvent" : str);
    }
}

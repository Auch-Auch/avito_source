package com.avito.android.serp.warning;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ParcelUtils;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR%\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/avito/android/serp/warning/TemporalWarningStateStorageState;", "Lcom/avito/android/serp/warning/WarningStateStorageState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "", "Lcom/avito/android/serp/warning/WarningState;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "map", "<init>", "(Ljava/util/Map;)V", "Companion", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class TemporalWarningStateStorageState extends WarningStateStorageState {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<TemporalWarningStateStorageState> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final Map<String, WarningState> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/warning/TemporalWarningStateStorageState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/serp/warning/TemporalWarningStateStorageState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, TemporalWarningStateStorageState> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public TemporalWarningStateStorageState invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            Map createValueMap = ParcelUtils.createValueMap(parcel2, String.class, WarningState.class);
            if (createValueMap == null) {
                createValueMap = r.emptyMap();
            }
            return new TemporalWarningStateStorageState(createValueMap);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, ? extends com.avito.android.serp.warning.WarningState> */
    /* JADX WARN: Multi-variable type inference failed */
    public TemporalWarningStateStorageState(@NotNull Map<String, ? extends WarningState> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.a = map;
    }

    @Override // com.avito.android.serp.warning.WarningStateStorageState, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Map<String, WarningState> getMap() {
        return this.a;
    }

    @Override // com.avito.android.serp.warning.WarningStateStorageState, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeValueMap(parcel, this.a);
    }
}

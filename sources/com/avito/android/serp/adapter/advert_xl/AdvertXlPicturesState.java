package com.avito.android.serp.adapter.advert_xl;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ParcelUtils;
import com.avito.android.util.ParcelsKt;
import com.vk.sdk.api.VKApiConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/avito/android/serp/adapter/advert_xl/AdvertXlPicturesState;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "id", VKApiConst.POSITION, "saveSelectedPosition", "(Ljava/lang/String;I)V", "getSelectedPosition", "(Ljava/lang/String;)I", "clear", "()V", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "selectedPictureMap", "", ResidentialComplexModuleKt.VALUES, "<init>", "(Ljava/util/Map;)V", "CREATOR", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertXlPicturesState implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    public final Map<String, Integer> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/serp/adapter/advert_xl/AdvertXlPicturesState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlPicturesState;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/serp/adapter/advert_xl/AdvertXlPicturesState;", "", "size", "", "newArray", "(I)[Lcom/avito/android/serp/adapter/advert_xl/AdvertXlPicturesState;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<AdvertXlPicturesState> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AdvertXlPicturesState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AdvertXlPicturesState(ParcelUtils.createValueMap(parcel, String.class, Integer.class));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AdvertXlPicturesState[] newArray(int i) {
            return new AdvertXlPicturesState[i];
        }
    }

    public AdvertXlPicturesState() {
        this(null, 1, null);
    }

    public AdvertXlPicturesState(@Nullable Map<String, Integer> map) {
        Map<String, Integer> linkedHashMap;
        this.a = (map == null || (linkedHashMap = r.toMutableMap(map)) == null) ? new LinkedHashMap<>() : linkedHashMap;
    }

    public final void clear() {
        this.a.clear();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getSelectedPosition(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Integer num = this.a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final void saveSelectedPosition(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.a.put(str, Integer.valueOf(i));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        ParcelsKt.writeValueMap(parcel, this.a);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertXlPicturesState(Map map, int i, j jVar) {
        this((i & 1) != 0 ? null : map);
    }
}

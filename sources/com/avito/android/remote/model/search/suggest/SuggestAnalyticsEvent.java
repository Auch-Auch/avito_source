package com.avito.android.remote.model.search.suggest;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\f\u001a\u0004\b\u000f\u0010\u0004R(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;", "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "version", "I", "getVersion", "id", "getId", "", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Ljava/util/Map;", "getParameters", "()Ljava/util/Map;", "<init>", "(IILjava/util/Map;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestAnalyticsEvent extends SuggestAction {
    public static final Parcelable.Creator<SuggestAnalyticsEvent> CREATOR = new Creator();
    @SerializedName("id")
    private final int id;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT)
    @NotNull
    private final Map<String, String> parameters;
    @SerializedName("version")
    private final int version;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SuggestAnalyticsEvent> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestAnalyticsEvent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt3);
            while (readInt3 != 0) {
                readInt3 = a.U(parcel, linkedHashMap, parcel.readString(), readInt3, -1);
            }
            return new SuggestAnalyticsEvent(readInt, readInt2, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestAnalyticsEvent[] newArray(int i) {
            return new SuggestAnalyticsEvent[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestAnalyticsEvent(int i, int i2, @NotNull Map<String, String> map) {
        super(null);
        Intrinsics.checkNotNullParameter(map, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        this.id = i;
        this.version = i2;
        this.parameters = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final int getVersion() {
        return this.version;
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
            int r4 = r2.id
            r3.writeInt(r4)
            int r4 = r2.version
            r3.writeInt(r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.parameters
            java.util.Iterator r4 = a2.b.a.a.a.o0(r4, r3)
        L_0x0015:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0032
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x0015
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent.writeToParcel(android.os.Parcel, int):void");
    }
}

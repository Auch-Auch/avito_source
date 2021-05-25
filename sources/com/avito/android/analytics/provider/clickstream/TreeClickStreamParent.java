package com.avito.android.analytics.provider.clickstream;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.VisibleForTesting;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B3\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u001a\u001a\u00020\f\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b#\u0010$J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001a\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001e¨\u0006&"}, d2 = {"Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "", "", "getParams", "()Ljava/util/Map;", "", AuthSource.SEND_ABUSE, "J", "getStateId", "()J", "stateId", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getFromPage", "()Ljava/lang/String;", "fromPage", "d", "Ljava/lang/Integer;", "getFromPosition", "()Ljava/lang/Integer;", "fromPosition", "c", "getFromBlock", BookingInfoActivity.EXTRA_FROM_BLOCK, "<init>", "(JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public final class TreeClickStreamParent implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<TreeClickStreamParent> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;
    @Nullable
    public final Integer c;
    @Nullable
    public final Integer d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, TreeClickStreamParent> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public TreeClickStreamParent invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            long readLong = parcel2.readLong();
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            Object readValue = parcel2.readValue(Integer.class.getClassLoader());
            Integer num = null;
            if (!(readValue instanceof Integer)) {
                readValue = null;
            }
            Integer num2 = (Integer) readValue;
            Object readValue2 = parcel2.readValue(Integer.class.getClassLoader());
            if (readValue2 instanceof Integer) {
                num = readValue2;
            }
            return new TreeClickStreamParent(readLong, u2, num2, num);
        }
    }

    public TreeClickStreamParent(@VisibleForTesting long j, @VisibleForTesting @NotNull String str, @VisibleForTesting @Nullable Integer num, @VisibleForTesting @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "fromPage");
        this.a = j;
        this.b = str;
        this.c = num;
        this.d = num2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Integer getFromBlock() {
        return this.c;
    }

    @NotNull
    public final String getFromPage() {
        return this.b;
    }

    @Nullable
    public final Integer getFromPosition() {
        return this.d;
    }

    @NotNull
    public final Map<String, Object> getParams() {
        Map<String, Object> mutableMapOf = r.mutableMapOf(TuplesKt.to("parentstate_id", Long.valueOf(this.a)), TuplesKt.to(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, this.b));
        Integer num = this.c;
        if (num != null) {
            mutableMapOf.put("from_block", num);
        }
        Integer num2 = this.d;
        if (num2 != null) {
            mutableMapOf.put("from_position", num2);
        }
        return mutableMapOf;
    }

    public final long getStateId() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeLong(this.a);
        }
        if (parcel != null) {
            parcel.writeString(this.b);
        }
        if (parcel != null) {
            parcel.writeValue(this.c);
        }
        if (parcel != null) {
            parcel.writeValue(this.d);
        }
    }
}

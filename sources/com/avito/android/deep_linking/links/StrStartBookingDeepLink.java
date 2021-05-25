package com.avito.android.deep_linking.links;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u0000 (2\u00020\u0001:\u0001(B?\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\b\u0010%\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b&\u0010'J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016XD¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\u001d\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010!R\u001b\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r¨\u0006)"}, d2 = {"Lcom/avito/android/deep_linking/links/StrStartBookingDeepLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "f", "getCheckInDate", "checkInDate", "", "h", "Z", "getShowCalendar", "()Z", "showCalendar", "i", "getWorkflow", "workflow", "d", "getItemId", "itemId", "e", "getSource", "setSource", "(Ljava/lang/String;)V", "source", g.a, "getCheckOutDate", "checkOutDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class StrStartBookingDeepLink extends DeepLink {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<StrStartBookingDeepLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/shortTermRent/booking/request";
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    public final boolean h;
    @Nullable
    public final String i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/StrStartBookingDeepLink$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/StrStartBookingDeepLink;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, StrStartBookingDeepLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public StrStartBookingDeepLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            Object readValue = parcel2.readValue(String.class.getClassLoader());
            String str = null;
            if (!(readValue instanceof String)) {
                readValue = null;
            }
            String str2 = (String) readValue;
            Object readValue2 = parcel2.readValue(String.class.getClassLoader());
            if (!(readValue2 instanceof String)) {
                readValue2 = null;
            }
            String str3 = (String) readValue2;
            boolean readBool = ParcelsKt.readBool(parcel2);
            Object readValue3 = parcel2.readValue(String.class.getClassLoader());
            if (readValue3 instanceof String) {
                str = readValue3;
            }
            return new StrStartBookingDeepLink(u2, u22, str2, str3, readBool, str);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StrStartBookingDeepLink(String str, String str2, String str3, String str4, boolean z, String str5, int i2, j jVar) {
        this(str, str2, str3, str4, (i2 & 16) != 0 ? false : z, str5);
    }

    @Nullable
    public final String getCheckInDate() {
        return this.f;
    }

    @Nullable
    public final String getCheckOutDate() {
        return this.g;
    }

    @NotNull
    public final String getItemId() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    public final boolean getShowCalendar() {
        return this.h;
    }

    @NotNull
    public final String getSource() {
        return this.e;
    }

    @Nullable
    public final String getWorkflow() {
        return this.i;
    }

    public final void setSource(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        ParcelsKt.writeNullableValue(parcel, this.f);
        ParcelsKt.writeNullableValue(parcel, this.g);
        ParcelsKt.writeBool(parcel, this.h);
        ParcelsKt.writeNullableValue(parcel, this.i);
    }

    public StrStartBookingDeepLink(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, boolean z, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "source");
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = z;
        this.i = str5;
        this.c = PATH;
    }
}

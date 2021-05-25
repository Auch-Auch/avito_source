package com.avito.android.deep_linking.links;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB-\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0018\u001a\u00020\n8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u0019\u0010\u001b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/deep_linking/links/AutotekaBuyReportLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/deep_linking/links/UTMLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "e", "Ljava/lang/String;", "getUtmSource", "()Ljava/lang/String;", "utmSource", g.a, "getUtmCampaign", "utmCampaign", "f", "getUtmMedium", "utmMedium", "c", "getPath", MessageMetaInfo.COLUMN_PATH, "d", "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaBuyReportLink extends DeepLink implements UTMLink {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AutotekaBuyReportLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/autoteka/buyReport";
    @NotNull
    public final String c = PATH;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/AutotekaBuyReportLink$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/AutotekaBuyReportLink;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AutotekaBuyReportLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AutotekaBuyReportLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new AutotekaBuyReportLink(a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readString(), parcel2.readString(), parcel2.readString());
        }
    }

    public AutotekaBuyReportLink(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    @NotNull
    public final String getAdvertId() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Override // com.avito.android.deep_linking.links.UTMLink
    @Nullable
    public String getUtmCampaign() {
        return this.g;
    }

    @Override // com.avito.android.deep_linking.links.UTMLink
    @Nullable
    public String getUtmMedium() {
        return this.f;
    }

    @Override // com.avito.android.deep_linking.links.UTMLink
    @Nullable
    public String getUtmSource() {
        return this.e;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.d);
        parcel.writeString(getUtmSource());
        parcel.writeString(getUtmMedium());
        parcel.writeString(getUtmCampaign());
    }
}

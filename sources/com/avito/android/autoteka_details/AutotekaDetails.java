package com.avito.android.autoteka_details;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0001(B9\u0012\u0006\u0010\u001f\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\b\u0010%\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u0019\u0010\u001f\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R\u001b\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetails;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/net/Uri;", "d", "Landroid/net/Uri;", "getReportUrl", "()Landroid/net/Uri;", "reportUrl", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSubTitle", "()Ljava/lang/String;", "subTitle", "c", "getDescription", "description", "e", "getExampleUrl", "exampleUrl", AuthSource.SEND_ABUSE, "getTitle", "title", "", "f", "Ljava/lang/CharSequence;", "getDisclaimer", "()Ljava/lang/CharSequence;", "disclaimer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/CharSequence;)V", "Companion", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaDetails implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AutotekaDetails> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final Uri d;
    @NotNull
    public final Uri e;
    @Nullable
    public final CharSequence f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetails$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/autoteka_details/AutotekaDetails;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AutotekaDetails> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AutotekaDetails invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new AutotekaDetails(a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), (Uri) a2.b.a.a.a.z1(Uri.class, parcel2), (Uri) a2.b.a.a.a.z1(Uri.class, parcel2), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2));
        }
    }

    public AutotekaDetails(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Uri uri, @NotNull Uri uri2, @Nullable CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subTitle");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(uri, "reportUrl");
        Intrinsics.checkNotNullParameter(uri2, "exampleUrl");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = uri;
        this.e = uri2;
        this.f = charSequence;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getDescription() {
        return this.c;
    }

    @Nullable
    public final CharSequence getDisclaimer() {
        return this.f;
    }

    @NotNull
    public final Uri getExampleUrl() {
        return this.e;
    }

    @NotNull
    public final Uri getReportUrl() {
        return this.d;
    }

    @NotNull
    public final String getSubTitle() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeParcelable(this.e, i);
        TextUtils.writeToParcel(this.f, parcel, i);
    }
}

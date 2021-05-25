package com.avito.android.deep_linking.links;

import android.net.Uri;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0011\b\b\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b'\u0010(J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0010\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u001c\u0010#\u001a\u00020\u00148\u0016@\u0016XD¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0016R\u0019\u0010\u0011\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u000f¨\u0006*"}, d2 = {"Lcom/avito/android/deep_linking/links/PromoLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/deep_linking/links/NotificationCenterMarker;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/net/Uri;", "component1", "()Landroid/net/Uri;", "", "component2", "()Z", "extendedUrl", "withAuthorization", "copy", "(Landroid/net/Uri;Z)Lcom/avito/android/deep_linking/links/PromoLink;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Landroid/net/Uri;", "getExtendedUrl", "c", "Ljava/lang/String;", "getPath", MessageMetaInfo.COLUMN_PATH, "e", "Z", "getWithAuthorization", "<init>", "(Landroid/net/Uri;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PromoLink extends DeepLink implements NotificationCenterMarker {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PromoLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/webview";
    @NotNull
    public final String c;
    @NotNull
    public final Uri d;
    public final boolean e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/PromoLink$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/PromoLink;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, PromoLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PromoLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new PromoLink((Uri) a2.b.a.a.a.z1(Uri.class, parcel2), ParcelsKt.readBool(parcel2));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromoLink(Uri uri, boolean z, int i, j jVar) {
        this(uri, (i & 2) != 0 ? false : z);
    }

    public static /* synthetic */ PromoLink copy$default(PromoLink promoLink, Uri uri, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = promoLink.d;
        }
        if ((i & 2) != 0) {
            z = promoLink.e;
        }
        return promoLink.copy(uri, z);
    }

    @NotNull
    public final Uri component1() {
        return this.d;
    }

    public final boolean component2() {
        return this.e;
    }

    @NotNull
    public final PromoLink copy(@NotNull Uri uri, boolean z) {
        Intrinsics.checkNotNullParameter(uri, "extendedUrl");
        return new PromoLink(uri, z);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromoLink)) {
            return false;
        }
        PromoLink promoLink = (PromoLink) obj;
        return Intrinsics.areEqual(this.d, promoLink.d) && this.e == promoLink.e;
    }

    @NotNull
    public final Uri getExtendedUrl() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    public final boolean getWithAuthorization() {
        return this.e;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Uri uri = this.d;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("PromoLink(extendedUrl=");
        L.append(this.d);
        L.append(", withAuthorization=");
        return a2.b.a.a.a.B(L, this.e, ")");
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.d, i);
        ParcelsKt.writeBool(parcel, this.e);
    }

    public PromoLink(@NotNull Uri uri, boolean z) {
        Intrinsics.checkNotNullParameter(uri, "extendedUrl");
        this.d = uri;
        this.e = z;
        this.c = PATH;
    }
}

package com.avito.android.deep_linking.links;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/avito/android/deep_linking/links/ShopsLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/deep_linking/links/LocationOwnerLink;", "", "getLocationId", "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "d", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "getSearchParams", "()Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParams", "c", "Ljava/lang/String;", "getPath", MessageMetaInfo.COLUMN_PATH, "<init>", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ShopsLink extends DeepLink implements LocationOwnerLink {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShopsLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/shops/search";
    @NotNull
    public final String c;
    @NotNull
    public final ShopsSearchParameters d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/ShopsLink$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/ShopsLink;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ShopsLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ShopsLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new ShopsLink((ShopsSearchParameters) a2.b.a.a.a.z1(ShopsSearchParameters.class, parcel2));
        }
    }

    public ShopsLink() {
        this(null, 1, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopsLink(ShopsSearchParameters shopsSearchParameters, int i, j jVar) {
        this((i & 1) != 0 ? new ShopsSearchParameters(null, null, null, 7, null) : shopsSearchParameters);
    }

    @Override // com.avito.android.deep_linking.links.LocationOwnerLink
    @Nullable
    public String getLocationId() {
        return this.d.getLocationId();
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @NotNull
    public final ShopsSearchParameters getSearchParams() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.d, i);
    }

    public ShopsLink(@NotNull ShopsSearchParameters shopsSearchParameters) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "searchParams");
        this.d = shopsSearchParameters;
        this.c = PATH;
    }
}

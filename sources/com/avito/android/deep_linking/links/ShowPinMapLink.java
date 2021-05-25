package com.avito.android.deep_linking.links;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.appevents.integrity.IntegrityManager;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 #2\u00020\u0001:\u0001#B+\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001b\u0010 \u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019¨\u0006$"}, d2 = {"Lcom/avito/android/deep_linking/links/ShowPinMapLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", g.a, "Z", "getCreateRoute", "()Z", "createRoute", "Lcom/avito/android/remote/model/Coordinates;", "f", "Lcom/avito/android/remote/model/Coordinates;", "getPin", "()Lcom/avito/android/remote/model/Coordinates;", "pin", "", "c", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "d", "getTitle", "title", "e", "getAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ShowPinMapLink extends DeepLink {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShowPinMapLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/map/showPin";
    @NotNull
    public final String c = PATH;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @NotNull
    public final Coordinates f;
    public final boolean g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/ShowPinMapLink$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/ShowPinMapLink;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ShowPinMapLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ShowPinMapLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new ShowPinMapLink(parcel2.readString(), parcel2.readString(), (Coordinates) a2.b.a.a.a.z1(Coordinates.class, parcel2), ParcelsKt.readBool(parcel2));
        }
    }

    public ShowPinMapLink(@Nullable String str, @Nullable String str2, @NotNull Coordinates coordinates, boolean z) {
        Intrinsics.checkNotNullParameter(coordinates, "pin");
        this.d = str;
        this.e = str2;
        this.f = coordinates;
        this.g = z;
    }

    @Nullable
    public final String getAddress() {
        return this.e;
    }

    public final boolean getCreateRoute() {
        return this.g;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @NotNull
    public final Coordinates getPin() {
        return this.f;
    }

    @Nullable
    public final String getTitle() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i);
        ParcelsKt.writeBool(parcel, this.g);
    }
}

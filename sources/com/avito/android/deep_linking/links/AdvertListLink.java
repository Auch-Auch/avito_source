package com.avito.android.deep_linking.links;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB)\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u001c\u0010\u001a\u001a\u00020\t8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/avito/android/deep_linking/links/AdvertListLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "f", "Ljava/util/List;", "getAdvertIds", "()Ljava/util/List;", "advertIds", "e", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "c", "getPath", MessageMetaInfo.COLUMN_PATH, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertListLink extends DeepLink {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertListLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/items";
    @NotNull
    public final String c = PATH;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @NotNull
    public final List<String> f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/AdvertListLink$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/AdvertListLink;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertListLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertListLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            ArrayList arrayList = new ArrayList();
            parcel2.readStringList(arrayList);
            return new AdvertListLink(readString, readString2, arrayList);
        }
    }

    public AdvertListLink(@Nullable String str, @Nullable String str2, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "advertIds");
        this.d = str;
        this.e = str2;
        this.f = list;
    }

    @NotNull
    public final List<String> getAdvertIds() {
        return this.f;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Nullable
    public final String getSubtitle() {
        return this.e;
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
        parcel.writeStringList(this.f);
    }
}

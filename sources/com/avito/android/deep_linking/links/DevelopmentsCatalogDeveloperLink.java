package com.avito.android.deep_linking.links;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/avito/android/deep_linking/links/DevelopmentsCatalogDeveloperLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "e", "getDeveloperId", "developerId", "Landroid/net/Uri;", "d", "Landroid/net/Uri;", "getUrl", "()Landroid/net/Uri;", "url", "<init>", "(Landroid/net/Uri;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogDeveloperLink extends DeepLink {
    public static final Parcelable.Creator<DevelopmentsCatalogDeveloperLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String FACTORY_MAPPING_PATH = "1/developmentsCatalog/developer/show";
    @NotNull
    public final String c = "/developmentsCatalog/developer/show";
    @NotNull
    public final Uri d;
    @Nullable
    public final String e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/deep_linking/links/DevelopmentsCatalogDeveloperLink$Companion;", "", "", "FACTORY_MAPPING_PATH", "Ljava/lang/String;", "PATH", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DevelopmentsCatalogDeveloperLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DevelopmentsCatalogDeveloperLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DevelopmentsCatalogDeveloperLink((Uri) parcel.readParcelable(DevelopmentsCatalogDeveloperLink.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DevelopmentsCatalogDeveloperLink[] newArray(int i) {
            return new DevelopmentsCatalogDeveloperLink[i];
        }
    }

    public DevelopmentsCatalogDeveloperLink(@NotNull Uri uri, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uri, "url");
        this.d = uri;
        this.e = str;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @Nullable
    public final String getDeveloperId() {
        return this.e;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @NotNull
    public final Uri getUrl() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
    }
}

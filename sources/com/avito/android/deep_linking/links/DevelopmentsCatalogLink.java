package com.avito.android.deep_linking.links;

import a2.g.r.g;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB+\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\"\u0010\u001c\u001a\u00020\t8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0019\u0010\r¨\u0006 "}, d2 = {"Lcom/avito/android/deep_linking/links/DevelopmentsCatalogLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "e", "Ljava/lang/String;", "getItemTitle", "()Ljava/lang/String;", "itemTitle", g.a, "getFromPage", "fromPage", "d", "getItemId", "itemId", "f", "getSearchContext", "searchContext", "c", "getPath", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogLink extends DeepLink {
    public static final Parcelable.Creator<DevelopmentsCatalogLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String FACTORY_MAPPING_PATH = "1/developmentsCatalog/item/show";
    @NotNull
    public final String c = "/developmentsCatalog/item/show";
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/deep_linking/links/DevelopmentsCatalogLink$Companion;", "", "", "FACTORY_MAPPING_PATH", "Ljava/lang/String;", "PATH", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DevelopmentsCatalogLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DevelopmentsCatalogLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DevelopmentsCatalogLink(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DevelopmentsCatalogLink[] newArray(int i) {
            return new DevelopmentsCatalogLink[i];
        }
    }

    public DevelopmentsCatalogLink(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "itemTitle");
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @Nullable
    public final String getFromPage() {
        return this.g;
    }

    @NotNull
    public final String getItemId() {
        return this.d;
    }

    @NotNull
    public final String getItemTitle() {
        return this.e;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Nullable
    public final String getSearchContext() {
        return this.f;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
    }
}

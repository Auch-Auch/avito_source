package com.avito.android.deep_linking.links;

import a2.b.a.a.a;
import a2.g.r.g;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001d\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/deep_linking/links/FallbackableLink;", "Lcom/avito/android/deep_linking/links/DeepLinkContainer;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/net/Uri;", g.a, "Landroid/net/Uri;", "getFullUri", "()Landroid/net/Uri;", "fullUri", "", "e", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "", "Lcom/avito/android/deep_linking/links/DeepLink;", "f", "Ljava/util/List;", "getFallbacks", "()Ljava/util/List;", "fallbacks", "<init>", "(Ljava/util/List;Landroid/net/Uri;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class FallbackableLink extends DeepLinkContainer {
    public static final Parcelable.Creator<FallbackableLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/deepLinks/fallbackable/open";
    @NotNull
    public final String e = PATH;
    @NotNull
    public final List<DeepLink> f;
    @NotNull
    public final Uri g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/FallbackableLink$Companion;", "", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FallbackableLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FallbackableLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((DeepLink) parcel.readParcelable(FallbackableLink.class.getClassLoader()));
                readInt--;
            }
            return new FallbackableLink(arrayList, (Uri) parcel.readParcelable(FallbackableLink.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FallbackableLink[] newArray(int i) {
            return new FallbackableLink[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.deep_linking.links.DeepLink> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FallbackableLink(@NotNull List<? extends DeepLink> list, @NotNull Uri uri) {
        super(list, uri);
        Intrinsics.checkNotNullParameter(list, "fallbacks");
        Intrinsics.checkNotNullParameter(uri, "fullUri");
        this.f = list;
        this.g = uri;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<DeepLink> getFallbacks() {
        return this.f;
    }

    @NotNull
    public final Uri getFullUri() {
        return this.g;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.e;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.f, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((DeepLink) n0.next(), i);
        }
        parcel.writeParcelable(this.g, i);
    }
}

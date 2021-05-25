package com.avito.android.deep_linking.links;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/avito/android/deep_linking/links/AuthenticateLink;", "Lcom/avito/android/deep_linking/links/ChainedDeepLink;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getSrc", "()Ljava/lang/String;", "src", "Lcom/avito/android/deep_linking/links/DeepLink;", "e", "Lcom/avito/android/deep_linking/links/DeepLink;", "getThen", "()Lcom/avito/android/deep_linking/links/DeepLink;", "then", "c", "getPath", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AuthenticateLink extends ChainedDeepLink {
    public static final Parcelable.Creator<AuthenticateLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/authenticate";
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final DeepLink e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/AuthenticateLink$Companion;", "", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AuthenticateLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AuthenticateLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AuthenticateLink(parcel.readString(), (DeepLink) parcel.readParcelable(AuthenticateLink.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AuthenticateLink[] newArray(int i) {
            return new AuthenticateLink[i];
        }
    }

    public AuthenticateLink() {
        this(null, null, 3, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthenticateLink(String str, DeepLink deepLink, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : deepLink);
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Nullable
    public final String getSrc() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.ChainedDeepLink
    @Nullable
    public DeepLink getThen() {
        return this.e;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i);
    }

    public AuthenticateLink(@Nullable String str, @Nullable DeepLink deepLink) {
        this.d = str;
        this.e = deepLink;
        this.c = PATH;
    }
}

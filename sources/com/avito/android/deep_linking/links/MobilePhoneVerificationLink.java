package com.avito.android.deep_linking.links;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0014J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/deep_linking/links/MobilePhoneVerificationLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "d", "getPhone", "setPhone", "(Ljava/lang/String;)V", "phone", "<init>", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MobilePhoneVerificationLink extends DeepLink {
    public static final Parcelable.Creator<MobilePhoneVerificationLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/phone/verification/mobile";
    @NotNull
    public final String c;
    @NotNull
    public String d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/MobilePhoneVerificationLink$Companion;", "", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MobilePhoneVerificationLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MobilePhoneVerificationLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MobilePhoneVerificationLink(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MobilePhoneVerificationLink[] newArray(int i) {
            return new MobilePhoneVerificationLink[i];
        }
    }

    public MobilePhoneVerificationLink() {
        this(null, 1, null);
    }

    public MobilePhoneVerificationLink(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        this.d = str;
        this.c = PATH;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @NotNull
    public final String getPhone() {
        return this.d;
    }

    public final void setPhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MobilePhoneVerificationLink(String str, int i, j jVar) {
        this((i & 1) != 0 ? "" : str);
    }
}

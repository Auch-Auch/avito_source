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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\t8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/avito/android/deep_linking/links/ManualPhoneVerificationLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "e", "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "setPhone", "(Ljava/lang/String;)V", "phone", "Lcom/avito/android/deep_linking/links/PhoneVerificationLinkContext;", "d", "Lcom/avito/android/deep_linking/links/PhoneVerificationLinkContext;", "getContext", "()Lcom/avito/android/deep_linking/links/PhoneVerificationLinkContext;", "context", "c", "getPath", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "<init>", "(Lcom/avito/android/deep_linking/links/PhoneVerificationLinkContext;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ManualPhoneVerificationLink extends DeepLink {
    public static final Parcelable.Creator<ManualPhoneVerificationLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/phone/verification/manual";
    @NotNull
    public final String c = PATH;
    @NotNull
    public final PhoneVerificationLinkContext d;
    @Nullable
    public String e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/ManualPhoneVerificationLink$Companion;", "", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ManualPhoneVerificationLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ManualPhoneVerificationLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ManualPhoneVerificationLink(PhoneVerificationLinkContext.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ManualPhoneVerificationLink[] newArray(int i) {
            return new ManualPhoneVerificationLink[i];
        }
    }

    public ManualPhoneVerificationLink(@NotNull PhoneVerificationLinkContext phoneVerificationLinkContext, @Nullable String str) {
        Intrinsics.checkNotNullParameter(phoneVerificationLinkContext, "context");
        this.d = phoneVerificationLinkContext;
        this.e = str;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @NotNull
    public final PhoneVerificationLinkContext getContext() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Nullable
    public final String getPhone() {
        return this.e;
    }

    public final void setPhone(@Nullable String str) {
        this.e = str;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.d.writeToParcel(parcel, 0);
        parcel.writeString(this.e);
    }
}

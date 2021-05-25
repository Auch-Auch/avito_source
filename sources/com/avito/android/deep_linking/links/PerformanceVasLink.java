package com.avito.android.deep_linking.links;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B'\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u0019\u0010!\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f¨\u0006%"}, d2 = {"Lcom/avito/android/deep_linking/links/PerformanceVasLink;", "Lcom/avito/android/deep_linking/links/PaidServicesLink;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "d", "getItemId", "itemId", "", "f", "Z", "getClosable", "()Z", "closable", g.a, "getCurrentFlow", "currentFlow", "e", "getCheckoutContext", "checkoutContext", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceVasLink extends PaidServicesLink {
    public static final Parcelable.Creator<PerformanceVasLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String FACTORY_MAPPING_PATH = "1/performanceVas";
    @NotNull
    public final String c = "/performanceVas";
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    public final boolean f;
    @NotNull
    public final String g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/deep_linking/links/PerformanceVasLink$Companion;", "", "", "FACTORY_MAPPING_PATH", "Ljava/lang/String;", "PATH", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PerformanceVasLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PerformanceVasLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PerformanceVasLink(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PerformanceVasLink[] newArray(int i) {
            return new PerformanceVasLink[i];
        }
    }

    public PerformanceVasLink(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3) {
        a.Z0(str, "itemId", str2, "checkoutContext", str3, "currentFlow");
        this.d = str;
        this.e = str2;
        this.f = z;
        this.g = str3;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getCheckoutContext() {
        return this.e;
    }

    public final boolean getClosable() {
        return this.f;
    }

    @NotNull
    public final String getCurrentFlow() {
        return this.g;
    }

    @NotNull
    public final String getItemId() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeString(this.g);
    }
}

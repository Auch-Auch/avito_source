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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)BE\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020\u001d\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b'\u0010(J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0019\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\u0019\u0010 \u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010$\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\rR\u0019\u0010&\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!¨\u0006*"}, d2 = {"Lcom/avito/android/deep_linking/links/DeliverySummaryDeepLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "d", "getItemId", "itemId", "e", "getSearchContext", "searchContext", g.a, "getFiasGuid", "fiasGuid", "j", "getSource", "source", "", "f", "Z", "isCart", "()Z", "h", "getServiceId", "serviceId", "i", "isMarketplace", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DeliverySummaryDeepLink extends DeepLink {
    public static final Parcelable.Creator<DeliverySummaryDeepLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/delivery/order/summary";
    @NotNull
    public final String c = PATH;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    public final boolean f;
    @NotNull
    public final String g;
    @NotNull
    public final String h;
    public final boolean i;
    @Nullable
    public final String j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/DeliverySummaryDeepLink$Companion;", "", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliverySummaryDeepLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliverySummaryDeepLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DeliverySummaryDeepLink(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliverySummaryDeepLink[] newArray(int i) {
            return new DeliverySummaryDeepLink[i];
        }
    }

    public DeliverySummaryDeepLink(@Nullable String str, @Nullable String str2, boolean z, @NotNull String str3, @NotNull String str4, boolean z2, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str3, "fiasGuid");
        Intrinsics.checkNotNullParameter(str4, "serviceId");
        this.d = str;
        this.e = str2;
        this.f = z;
        this.g = str3;
        this.h = str4;
        this.i = z2;
        this.j = str5;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @NotNull
    public final String getFiasGuid() {
        return this.g;
    }

    @Nullable
    public final String getItemId() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Nullable
    public final String getSearchContext() {
        return this.e;
    }

    @NotNull
    public final String getServiceId() {
        return this.h;
    }

    @Nullable
    public final String getSource() {
        return this.j;
    }

    public final boolean isCart() {
        return this.f;
    }

    public final boolean isMarketplace() {
        return this.i;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeString(this.j);
    }
}

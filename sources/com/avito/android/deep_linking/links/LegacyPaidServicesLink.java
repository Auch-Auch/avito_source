package com.avito.android.deep_linking.links;

import a2.b.a.a.a;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B1\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b$\u0010%J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\n\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\f8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\u0010R\u0019\u0010\u0019\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u0019\u0010\u001c\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u0019\u0010#\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000b¨\u0006'"}, d2 = {"Lcom/avito/android/deep_linking/links/LegacyPaidServicesLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "isPostCreation", "()Z", "", "e", "Ljava/lang/String;", "getContext", "()Ljava/lang/String;", "context", "c", "getPath", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "d", "getItemId", "itemId", "f", "getVasType", "vasType", "h", "getFrom", "from", g.a, "Z", "getShowFees", "showFees", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyPaidServicesLink extends DeepLink {
    public static final Parcelable.Creator<LegacyPaidServicesLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String FROM_CREATION = "post_creation";
    @NotNull
    public static final String PATH = "/profile/item/paidServices";
    @NotNull
    public static final String TYPE_PERFORMANCE = "performance";
    @NotNull
    public final String c = PATH;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    public final boolean g;
    @Nullable
    public final String h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/deep_linking/links/LegacyPaidServicesLink$Companion;", "", "", "type", "", "isSupportedType", "(Ljava/lang/String;)Z", "FROM_CREATION", "Ljava/lang/String;", "PATH", "TYPE_PERFORMANCE", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final boolean isSupportedType(@Nullable String str) {
            return Intrinsics.areEqual(str, "performance");
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LegacyPaidServicesLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LegacyPaidServicesLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LegacyPaidServicesLink(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LegacyPaidServicesLink[] newArray(int i) {
            return new LegacyPaidServicesLink[i];
        }
    }

    public LegacyPaidServicesLink(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @Nullable String str4) {
        a.Z0(str, "itemId", str2, "context", str3, "vasType");
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = z;
        this.h = str4;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @NotNull
    public final String getContext() {
        return this.e;
    }

    @Nullable
    public final String getFrom() {
        return this.h;
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

    public final boolean getShowFees() {
        return this.g;
    }

    @NotNull
    public final String getVasType() {
        return this.f;
    }

    public final boolean isPostCreation() {
        return Intrinsics.areEqual(this.h, FROM_CREATION);
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeString(this.h);
    }
}

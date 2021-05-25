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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u00020\t8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u001b\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/avito/android/deep_linking/links/BadgeBarShowLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getObjectId", "()Ljava/lang/String;", "objectId", "f", "I", "getBadgeId", "()I", "badgeId", "c", "getPath", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "e", "getObjectEntity", "objectEntity", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeBarShowLink extends DeepLink {
    public static final Parcelable.Creator<BadgeBarShowLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/badgeBar/show";
    @NotNull
    public final String c = PATH;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    public final int f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/BadgeBarShowLink$Companion;", "", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BadgeBarShowLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BadgeBarShowLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BadgeBarShowLink(parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BadgeBarShowLink[] newArray(int i) {
            return new BadgeBarShowLink[i];
        }
    }

    public BadgeBarShowLink(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "objectId");
        Intrinsics.checkNotNullParameter(str2, "objectEntity");
        this.d = str;
        this.e = str2;
        this.f = i;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    public final int getBadgeId() {
        return this.f;
    }

    @NotNull
    public final String getObjectEntity() {
        return this.e;
    }

    @NotNull
    public final String getObjectId() {
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
        parcel.writeInt(this.f);
    }
}

package com.avito.android.player.router;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u001b\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/player/router/PlayerArguments;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSlug", "()Ljava/lang/String;", "slug", "Lcom/avito/android/rec/ScreenSource;", "e", "Lcom/avito/android/rec/ScreenSource;", "getScreenSource", "()Lcom/avito/android/rec/ScreenSource;", "screenSource", AuthSource.SEND_ABUSE, "getUrl", "url", "c", "getBlockType", "blockType", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "d", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getTreeParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/rec/ScreenSource;)V", "player_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerArguments implements Parcelable {
    public static final Parcelable.Creator<PlayerArguments> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final TreeClickStreamParent d;
    @NotNull
    public final ScreenSource e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PlayerArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PlayerArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PlayerArguments(parcel.readString(), parcel.readString(), parcel.readString(), (TreeClickStreamParent) parcel.readParcelable(PlayerArguments.class.getClassLoader()), (ScreenSource) parcel.readParcelable(PlayerArguments.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PlayerArguments[] newArray(int i) {
            return new PlayerArguments[i];
        }
    }

    public PlayerArguments(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull ScreenSource screenSource) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(screenSource, "screenSource");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = treeClickStreamParent;
        this.e = screenSource;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getBlockType() {
        return this.c;
    }

    @NotNull
    public final ScreenSource getScreenSource() {
        return this.e;
    }

    @Nullable
    public final String getSlug() {
        return this.b;
    }

    @Nullable
    public final TreeClickStreamParent getTreeParent() {
        return this.d;
    }

    @NotNull
    public final String getUrl() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeParcelable(this.e, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlayerArguments(String str, String str2, String str3, TreeClickStreamParent treeClickStreamParent, ScreenSource screenSource, int i, j jVar) {
        this(str, str2, str3, treeClickStreamParent, (i & 16) != 0 ? ScreenSource.EMPTY.INSTANCE : screenSource);
    }
}

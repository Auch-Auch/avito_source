package com.avito.android.player.view;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\n¨\u0006*"}, d2 = {"Lcom/avito/android/player/view/PlayerState;", "Landroid/os/Parcelable;", "", "component1", "()Z", "", "component2", "()I", "", "component3", "()J", "playWhenReady", "currentWindow", "playbackPosition", "copy", "(ZIJ)Lcom/avito/android/player/view/PlayerState;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Z", "getPlayWhenReady", AuthSource.BOOKING_ORDER, "I", "getCurrentWindow", "c", "J", "getPlaybackPosition", "<init>", "(ZIJ)V", "player_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerState implements Parcelable {
    public static final Parcelable.Creator<PlayerState> CREATOR = new Creator();
    public final boolean a;
    public final int b;
    public final long c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PlayerState> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PlayerState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PlayerState(parcel.readInt() != 0, parcel.readInt(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PlayerState[] newArray(int i) {
            return new PlayerState[i];
        }
    }

    public PlayerState() {
        this(false, 0, 0, 7, null);
    }

    public PlayerState(boolean z, int i, long j) {
        this.a = z;
        this.b = i;
        this.c = j;
    }

    public static /* synthetic */ PlayerState copy$default(PlayerState playerState, boolean z, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = playerState.a;
        }
        if ((i2 & 2) != 0) {
            i = playerState.b;
        }
        if ((i2 & 4) != 0) {
            j = playerState.c;
        }
        return playerState.copy(z, i, j);
    }

    public final boolean component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final long component3() {
        return this.c;
    }

    @NotNull
    public final PlayerState copy(boolean z, int i, long j) {
        return new PlayerState(z, i, j);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerState)) {
            return false;
        }
        PlayerState playerState = (PlayerState) obj;
        return this.a == playerState.a && this.b == playerState.b && this.c == playerState.c;
    }

    public final int getCurrentWindow() {
        return this.b;
    }

    public final boolean getPlayWhenReady() {
        return this.a;
    }

    public final long getPlaybackPosition() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean z = this.a;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return (((i * 31) + this.b) * 31) + c.a(this.c);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PlayerState(playWhenReady=");
        L.append(this.a);
        L.append(", currentWindow=");
        L.append(this.b);
        L.append(", playbackPosition=");
        return a.l(L, this.c, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.a ? 1 : 0);
        parcel.writeInt(this.b);
        parcel.writeLong(this.c);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlayerState(boolean z, int i, long j, int i2, j jVar) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 0 : j);
    }
}

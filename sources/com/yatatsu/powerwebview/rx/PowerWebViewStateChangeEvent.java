package com.yatatsu.powerwebview.rx;

import a2.b.a.a.a;
import android.graphics.Bitmap;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u0000 02\u00020\u0001:\u000201B=\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJR\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010\u0007R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010\nR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\r¨\u00062"}, d2 = {"Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent$State;", "component1", "()Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent$State;", "", "component2", "()I", "", "component3", "()Ljava/lang/String;", "Landroid/graphics/Bitmap;", "component4", "()Landroid/graphics/Bitmap;", "component5", "component6", "state", "progress", "url", "favicon", CommonKt.TAG_ERROR_CODE, "description", "copy", "(Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent$State;ILjava/lang/String;Landroid/graphics/Bitmap;ILjava/lang/String;)Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "I", "getErrorCode", AuthSource.SEND_ABUSE, "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent$State;", "getState", "c", "Ljava/lang/String;", "getUrl", AuthSource.BOOKING_ORDER, "getProgress", "f", "getDescription", "d", "Landroid/graphics/Bitmap;", "getFavicon", "<init>", "(Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent$State;ILjava/lang/String;Landroid/graphics/Bitmap;ILjava/lang/String;)V", "Companion", "State", "powerwebview_release"}, k = 1, mv = {1, 4, 2})
public final class PowerWebViewStateChangeEvent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final State a;
    public final int b;
    @Nullable
    public final String c;
    @Nullable
    public final Bitmap d;
    public final int e;
    @Nullable
    public final String f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent$Companion;", "", "", "url", "Landroid/graphics/Bitmap;", "favicon", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", Tracker.Events.CREATIVE_START, "(Ljava/lang/String;Landroid/graphics/Bitmap;)Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "", CommonKt.TAG_ERROR_CODE, "description", "failingUrl", "error", "(ILjava/lang/String;Ljava/lang/String;)Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "finish", "(Ljava/lang/String;)Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "newProgress", "progress", "(I)Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "<init>", "()V", "powerwebview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final PowerWebViewStateChangeEvent error(int i, @Nullable String str, @Nullable String str2) {
            return new PowerWebViewStateChangeEvent(State.ERROR, 0, str2, null, i, str);
        }

        @NotNull
        public final PowerWebViewStateChangeEvent finish(@Nullable String str) {
            return new PowerWebViewStateChangeEvent(State.FINISHED, 0, str, null, 0, null);
        }

        @NotNull
        public final PowerWebViewStateChangeEvent progress(int i) {
            return new PowerWebViewStateChangeEvent(State.PROGRESS, i, null, null, 0, null);
        }

        @NotNull
        public final PowerWebViewStateChangeEvent start(@Nullable String str, @Nullable Bitmap bitmap) {
            return new PowerWebViewStateChangeEvent(State.STARTED, 0, str, bitmap, 0, null);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent$State;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "FINISHED", "PROGRESS", "ERROR", "powerwebview_release"}, k = 1, mv = {1, 4, 2})
    public enum State {
        STARTED,
        FINISHED,
        PROGRESS,
        ERROR
    }

    public PowerWebViewStateChangeEvent(@NotNull State state, int i, @Nullable String str, @Nullable Bitmap bitmap, int i2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.a = state;
        this.b = i;
        this.c = str;
        this.d = bitmap;
        this.e = i2;
        this.f = str2;
    }

    public static /* synthetic */ PowerWebViewStateChangeEvent copy$default(PowerWebViewStateChangeEvent powerWebViewStateChangeEvent, State state, int i, String str, Bitmap bitmap, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            state = powerWebViewStateChangeEvent.a;
        }
        if ((i3 & 2) != 0) {
            i = powerWebViewStateChangeEvent.b;
        }
        if ((i3 & 4) != 0) {
            str = powerWebViewStateChangeEvent.c;
        }
        if ((i3 & 8) != 0) {
            bitmap = powerWebViewStateChangeEvent.d;
        }
        if ((i3 & 16) != 0) {
            i2 = powerWebViewStateChangeEvent.e;
        }
        if ((i3 & 32) != 0) {
            str2 = powerWebViewStateChangeEvent.f;
        }
        return powerWebViewStateChangeEvent.copy(state, i, str, bitmap, i2, str2);
    }

    @NotNull
    public final State component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final Bitmap component4() {
        return this.d;
    }

    public final int component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final PowerWebViewStateChangeEvent copy(@NotNull State state, int i, @Nullable String str, @Nullable Bitmap bitmap, int i2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new PowerWebViewStateChangeEvent(state, i, str, bitmap, i2, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PowerWebViewStateChangeEvent)) {
            return false;
        }
        PowerWebViewStateChangeEvent powerWebViewStateChangeEvent = (PowerWebViewStateChangeEvent) obj;
        return Intrinsics.areEqual(this.a, powerWebViewStateChangeEvent.a) && this.b == powerWebViewStateChangeEvent.b && Intrinsics.areEqual(this.c, powerWebViewStateChangeEvent.c) && Intrinsics.areEqual(this.d, powerWebViewStateChangeEvent.d) && this.e == powerWebViewStateChangeEvent.e && Intrinsics.areEqual(this.f, powerWebViewStateChangeEvent.f);
    }

    @Nullable
    public final String getDescription() {
        return this.f;
    }

    public final int getErrorCode() {
        return this.e;
    }

    @Nullable
    public final Bitmap getFavicon() {
        return this.d;
    }

    public final int getProgress() {
        return this.b;
    }

    @NotNull
    public final State getState() {
        return this.a;
    }

    @Nullable
    public final String getUrl() {
        return this.c;
    }

    public int hashCode() {
        State state = this.a;
        int i = 0;
        int hashCode = (((state != null ? state.hashCode() : 0) * 31) + this.b) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Bitmap bitmap = this.d;
        int hashCode3 = (((hashCode2 + (bitmap != null ? bitmap.hashCode() : 0)) * 31) + this.e) * 31;
        String str2 = this.f;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PowerWebViewStateChangeEvent(state=");
        L.append(this.a);
        L.append(", progress=");
        L.append(this.b);
        L.append(", url=");
        L.append(this.c);
        L.append(", favicon=");
        L.append(this.d);
        L.append(", errorCode=");
        L.append(this.e);
        L.append(", description=");
        return a.t(L, this.f, ")");
    }
}

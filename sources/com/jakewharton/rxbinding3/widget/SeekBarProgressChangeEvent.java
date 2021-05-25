package com.jakewharton.rxbinding3.widget;

import a2.b.a.a.a;
import android.widget.SeekBar;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007¨\u0006#"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SeekBarProgressChangeEvent;", "Lcom/jakewharton/rxbinding3/widget/SeekBarChangeEvent;", "Landroid/widget/SeekBar;", "component1", "()Landroid/widget/SeekBar;", "", "component2", "()I", "", "component3", "()Z", "view", "progress", "fromUser", "copy", "(Landroid/widget/SeekBar;IZ)Lcom/jakewharton/rxbinding3/widget/SeekBarProgressChangeEvent;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Z", "getFromUser", AuthSource.SEND_ABUSE, "Landroid/widget/SeekBar;", "getView", AuthSource.BOOKING_ORDER, "I", "getProgress", "<init>", "(Landroid/widget/SeekBar;IZ)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class SeekBarProgressChangeEvent extends SeekBarChangeEvent {
    @NotNull
    public final SeekBar a;
    public final int b;
    public final boolean c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeekBarProgressChangeEvent(@NotNull SeekBar seekBar, int i, boolean z) {
        super(null);
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        this.a = seekBar;
        this.b = i;
        this.c = z;
    }

    public static /* synthetic */ SeekBarProgressChangeEvent copy$default(SeekBarProgressChangeEvent seekBarProgressChangeEvent, SeekBar seekBar, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            seekBar = seekBarProgressChangeEvent.getView();
        }
        if ((i2 & 2) != 0) {
            i = seekBarProgressChangeEvent.b;
        }
        if ((i2 & 4) != 0) {
            z = seekBarProgressChangeEvent.c;
        }
        return seekBarProgressChangeEvent.copy(seekBar, i, z);
    }

    @NotNull
    public final SeekBar component1() {
        return getView();
    }

    public final int component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final SeekBarProgressChangeEvent copy(@NotNull SeekBar seekBar, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        return new SeekBarProgressChangeEvent(seekBar, i, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SeekBarProgressChangeEvent) {
                SeekBarProgressChangeEvent seekBarProgressChangeEvent = (SeekBarProgressChangeEvent) obj;
                if (Intrinsics.areEqual(getView(), seekBarProgressChangeEvent.getView())) {
                    if (this.b == seekBarProgressChangeEvent.b) {
                        if (this.c == seekBarProgressChangeEvent.c) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean getFromUser() {
        return this.c;
    }

    public final int getProgress() {
        return this.b;
    }

    @Override // com.jakewharton.rxbinding3.widget.SeekBarChangeEvent
    @NotNull
    public SeekBar getView() {
        return this.a;
    }

    public int hashCode() {
        SeekBar view = getView();
        int hashCode = (((view != null ? view.hashCode() : 0) * 31) + this.b) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SeekBarProgressChangeEvent(view=");
        L.append(getView());
        L.append(", progress=");
        L.append(this.b);
        L.append(", fromUser=");
        return a.B(L, this.c, ")");
    }
}

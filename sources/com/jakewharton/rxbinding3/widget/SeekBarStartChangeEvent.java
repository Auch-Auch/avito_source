package com.jakewharton.rxbinding3.widget;

import a2.b.a.a.a;
import android.widget.SeekBar;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SeekBarStartChangeEvent;", "Lcom/jakewharton/rxbinding3/widget/SeekBarChangeEvent;", "Landroid/widget/SeekBar;", "component1", "()Landroid/widget/SeekBar;", "view", "copy", "(Landroid/widget/SeekBar;)Lcom/jakewharton/rxbinding3/widget/SeekBarStartChangeEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/widget/SeekBar;", "getView", "<init>", "(Landroid/widget/SeekBar;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class SeekBarStartChangeEvent extends SeekBarChangeEvent {
    @NotNull
    public final SeekBar a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeekBarStartChangeEvent(@NotNull SeekBar seekBar) {
        super(null);
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        this.a = seekBar;
    }

    public static /* synthetic */ SeekBarStartChangeEvent copy$default(SeekBarStartChangeEvent seekBarStartChangeEvent, SeekBar seekBar, int i, Object obj) {
        if ((i & 1) != 0) {
            seekBar = seekBarStartChangeEvent.getView();
        }
        return seekBarStartChangeEvent.copy(seekBar);
    }

    @NotNull
    public final SeekBar component1() {
        return getView();
    }

    @NotNull
    public final SeekBarStartChangeEvent copy(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "view");
        return new SeekBarStartChangeEvent(seekBar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SeekBarStartChangeEvent) && Intrinsics.areEqual(getView(), ((SeekBarStartChangeEvent) obj).getView());
        }
        return true;
    }

    @Override // com.jakewharton.rxbinding3.widget.SeekBarChangeEvent
    @NotNull
    public SeekBar getView() {
        return this.a;
    }

    public int hashCode() {
        SeekBar view = getView();
        if (view != null) {
            return view.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SeekBarStartChangeEvent(view=");
        L.append(getView());
        L.append(")");
        return L.toString();
    }
}

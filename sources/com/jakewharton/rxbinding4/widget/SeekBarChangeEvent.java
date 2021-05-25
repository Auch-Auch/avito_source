package com.jakewharton.rxbinding4.widget;

import android.widget.SeekBar;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/jakewharton/rxbinding4/widget/SeekBarChangeEvent;", "", "Landroid/widget/SeekBar;", "getView", "()Landroid/widget/SeekBar;", "view", "<init>", "()V", "Lcom/jakewharton/rxbinding4/widget/SeekBarProgressChangeEvent;", "Lcom/jakewharton/rxbinding4/widget/SeekBarStartChangeEvent;", "Lcom/jakewharton/rxbinding4/widget/SeekBarStopChangeEvent;", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public abstract class SeekBarChangeEvent {
    public SeekBarChangeEvent() {
    }

    @NotNull
    public abstract SeekBar getView();

    public SeekBarChangeEvent(j jVar) {
    }
}

package com.getkeepsafe.taptargetview;

import android.app.Activity;
import android.app.Dialog;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.getkeepsafe.taptargetview.TapTargetView;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
public class TapTargetSequence {
    @Nullable
    public final Activity a;
    @Nullable
    public final Dialog b;
    public final Queue<TapTarget> c;
    public boolean d;
    @Nullable
    public TapTargetView e;
    public Listener f;
    public boolean g;
    public boolean h;
    public final TapTargetView.Listener i = new a();

    public interface Listener {
        void onSequenceCanceled(TapTarget tapTarget);

        void onSequenceFinish();

        void onSequenceStep(TapTarget tapTarget, boolean z);
    }

    public class a extends TapTargetView.Listener {
        public a() {
        }

        @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
        public void onOuterCircleClick(TapTargetView tapTargetView) {
            if (TapTargetSequence.this.g) {
                onTargetCancel(tapTargetView);
            }
        }

        @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
        public void onTargetCancel(TapTargetView tapTargetView) {
            super.onTargetCancel(tapTargetView);
            TapTargetSequence tapTargetSequence = TapTargetSequence.this;
            if (tapTargetSequence.h) {
                Listener listener = tapTargetSequence.f;
                if (listener != null) {
                    listener.onSequenceStep(tapTargetView.q, false);
                }
                TapTargetSequence.this.a();
                return;
            }
            Listener listener2 = tapTargetSequence.f;
            if (listener2 != null) {
                listener2.onSequenceCanceled(tapTargetView.q);
            }
        }

        @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
        public void onTargetClick(TapTargetView tapTargetView) {
            super.onTargetClick(tapTargetView);
            Listener listener = TapTargetSequence.this.f;
            if (listener != null) {
                listener.onSequenceStep(tapTargetView.q, true);
            }
            TapTargetSequence.this.a();
        }
    }

    public TapTargetSequence(Activity activity) {
        if (activity != null) {
            this.a = activity;
            this.b = null;
            this.c = new LinkedList();
            return;
        }
        throw new IllegalArgumentException("Activity is null");
    }

    public void a() {
        try {
            TapTarget remove = this.c.remove();
            Activity activity = this.a;
            if (activity != null) {
                this.e = TapTargetView.showFor(activity, remove, this.i);
            } else {
                this.e = TapTargetView.showFor(this.b, remove, this.i);
            }
        } catch (NoSuchElementException unused) {
            this.e = null;
            Listener listener = this.f;
            if (listener != null) {
                listener.onSequenceFinish();
            }
        }
    }

    @UiThread
    public boolean cancel() {
        TapTargetView tapTargetView;
        if (!this.d || (tapTargetView = this.e) == null || !tapTargetView.G) {
            return false;
        }
        tapTargetView.dismiss(false);
        this.d = false;
        this.c.clear();
        Listener listener = this.f;
        if (listener == null) {
            return true;
        }
        listener.onSequenceCanceled(this.e.q);
        return true;
    }

    public TapTargetSequence considerOuterCircleCanceled(boolean z) {
        this.g = z;
        return this;
    }

    public TapTargetSequence continueOnCancel(boolean z) {
        this.h = z;
        return this;
    }

    public TapTargetSequence listener(Listener listener) {
        this.f = listener;
        return this;
    }

    @UiThread
    public void start() {
        if (!this.c.isEmpty() && !this.d) {
            this.d = true;
            a();
        }
    }

    public void startAt(int i2) {
        if (!this.d) {
            if (i2 < 0 || i2 >= this.c.size()) {
                throw new IllegalArgumentException(a2.b.a.a.a.M2("Given invalid index ", i2));
            }
            int size = this.c.size() - i2;
            while (this.c.peek() != null && this.c.size() != size) {
                this.c.poll();
            }
            if (this.c.size() == size) {
                start();
                return;
            }
            throw new IllegalStateException(a2.b.a.a.a.Q2("Given index ", i2, " not in sequence"));
        }
    }

    public void startWith(int i2) {
        if (!this.d) {
            while (this.c.peek() != null && this.c.peek().id() != i2) {
                this.c.poll();
            }
            TapTarget peek = this.c.peek();
            if (peek == null || peek.id() != i2) {
                throw new IllegalStateException(a2.b.a.a.a.Q2("Given target ", i2, " not in sequence"));
            }
            start();
        }
    }

    public TapTargetSequence target(TapTarget tapTarget) {
        this.c.add(tapTarget);
        return this;
    }

    public TapTargetSequence targets(List<TapTarget> list) {
        this.c.addAll(list);
        return this;
    }

    public TapTargetSequence targets(TapTarget... tapTargetArr) {
        Collections.addAll(this.c, tapTargetArr);
        return this;
    }

    public TapTargetSequence(Dialog dialog) {
        if (dialog != null) {
            this.b = dialog;
            this.a = null;
            this.c = new LinkedList();
            return;
        }
        throw new IllegalArgumentException("Given null Dialog");
    }
}

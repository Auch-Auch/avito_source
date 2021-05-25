package androidx.work.impl.constraints.controllers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
public abstract class ConstraintController<T> implements ConstraintListener<T> {
    public final List<String> a = new ArrayList();
    public T b;
    public ConstraintTracker<T> c;
    public OnConstraintUpdatedCallback d;

    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(@NonNull List<String> list);

        void onConstraintNotMet(@NonNull List<String> list);
    }

    public ConstraintController(ConstraintTracker<T> constraintTracker) {
        this.c = constraintTracker;
    }

    public abstract boolean a(@NonNull WorkSpec workSpec);

    public abstract boolean b(@NonNull T t);

    public final void c(@Nullable OnConstraintUpdatedCallback onConstraintUpdatedCallback, @Nullable T t) {
        if (!this.a.isEmpty() && onConstraintUpdatedCallback != null) {
            if (t == null || b(t)) {
                onConstraintUpdatedCallback.onConstraintNotMet(this.a);
            } else {
                onConstraintUpdatedCallback.onConstraintMet(this.a);
            }
        }
    }

    public boolean isWorkSpecConstrained(@NonNull String str) {
        T t = this.b;
        return t != null && b(t) && this.a.contains(str);
    }

    @Override // androidx.work.impl.constraints.ConstraintListener
    public void onConstraintChanged(@Nullable T t) {
        this.b = t;
        c(this.d, t);
    }

    public void replace(@NonNull Iterable<WorkSpec> iterable) {
        this.a.clear();
        for (WorkSpec workSpec : iterable) {
            if (a(workSpec)) {
                this.a.add(workSpec.id);
            }
        }
        if (this.a.isEmpty()) {
            this.c.removeListener(this);
        } else {
            this.c.addListener(this);
        }
        c(this.d, this.b);
    }

    public void reset() {
        if (!this.a.isEmpty()) {
            this.a.clear();
            this.c.removeListener(this);
        }
    }

    public void setCallback(@Nullable OnConstraintUpdatedCallback onConstraintUpdatedCallback) {
        if (this.d != onConstraintUpdatedCallback) {
            this.d = onConstraintUpdatedCallback;
            c(onConstraintUpdatedCallback, this.b);
        }
    }
}

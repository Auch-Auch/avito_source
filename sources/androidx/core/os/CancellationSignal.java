package androidx.core.os;

import androidx.annotation.Nullable;
public final class CancellationSignal {
    public boolean a;
    public OnCancelListener b;
    public Object c;
    public boolean d;

    public interface OnCancelListener {
        void onCancel();
    }

    public void cancel() {
        OnCancelListener onCancelListener;
        Object obj;
        synchronized (this) {
            if (!this.a) {
                this.a = true;
                this.d = true;
                onCancelListener = this.b;
                obj = this.c;
            } else {
                return;
            }
        }
        if (onCancelListener != null) {
            try {
                onCancelListener.onCancel();
            } catch (Throwable th) {
                synchronized (this) {
                    this.d = false;
                    notifyAll();
                    throw th;
                }
            }
        }
        if (obj != null) {
            ((android.os.CancellationSignal) obj).cancel();
        }
        synchronized (this) {
            this.d = false;
            notifyAll();
        }
    }

    @Nullable
    public Object getCancellationSignalObject() {
        Object obj;
        synchronized (this) {
            if (this.c == null) {
                android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
                this.c = cancellationSignal;
                if (this.a) {
                    cancellationSignal.cancel();
                }
            }
            obj = this.c;
        }
        return obj;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.a;
        }
        return z;
    }

    public void setOnCancelListener(@Nullable OnCancelListener onCancelListener) {
        synchronized (this) {
            while (this.d) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.b != onCancelListener) {
                this.b = onCancelListener;
                if (this.a && onCancelListener != null) {
                    onCancelListener.onCancel();
                }
            }
        }
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }
}

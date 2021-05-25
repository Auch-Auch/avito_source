package com.google.android.play.core.tasks;

import a2.b.a.a.a;
public class NativeOnCompleteListener implements OnCompleteListener<Object> {
    public final long a;
    public final int b;

    public NativeOnCompleteListener(long j, int i) {
        this.a = j;
        this.b = i;
    }

    public native void nativeOnComplete(long j, int i, Object obj, int i2);

    @Override // com.google.android.play.core.tasks.OnCompleteListener
    public void onComplete(Task<Object> task) {
        if (!task.isComplete()) {
            throw new IllegalStateException(a.m2(50, "onComplete called for incomplete task: ", this.b));
        } else if (task.isSuccessful()) {
            nativeOnComplete(this.a, this.b, task.getResult(), 0);
        } else {
            Exception exception = task.getException();
            if (!(exception instanceof j)) {
                nativeOnComplete(this.a, this.b, null, -100);
                return;
            }
            int errorCode = ((j) exception).getErrorCode();
            if (errorCode != 0) {
                nativeOnComplete(this.a, this.b, null, errorCode);
                return;
            }
            throw new IllegalStateException(a.m2(51, "TaskException has error code 0 on task: ", this.b));
        }
    }
}

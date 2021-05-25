package com.vk.sdk.api.httpClient;

import androidx.annotation.Nullable;
import com.vk.sdk.api.VKError;
import java.util.concurrent.ExecutorService;
public abstract class VKAbstractOperation {
    public VKOperationCompleteListener a;
    public VKOperationState b = VKOperationState.Created;
    public boolean c = false;
    @Nullable
    public ExecutorService d;

    public static abstract class VKAbstractCompleteListener<OperationType extends VKAbstractOperation, ResponseType> {
        public abstract void onComplete(OperationType operationtype, ResponseType responsetype);

        public abstract void onError(OperationType operationtype, VKError vKError);
    }

    public interface VKOperationCompleteListener {
        void onComplete();
    }

    public enum VKOperationState {
        Created,
        Ready,
        Executing,
        Paused,
        Finished,
        Canceled
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VKOperationCompleteListener vKOperationCompleteListener = VKAbstractOperation.this.a;
            if (vKOperationCompleteListener != null) {
                vKOperationCompleteListener.onComplete();
            }
        }
    }

    public VKAbstractOperation() {
        setState(VKOperationState.Ready);
    }

    public void cancel() {
        this.c = true;
        setState(VKOperationState.Canceled);
    }

    public void finish() {
        a aVar = new a();
        ExecutorService executorService = this.d;
        if (executorService != null) {
            executorService.submit(aVar);
        } else {
            aVar.run();
        }
    }

    public abstract Object getResultObject();

    public void setCompleteListener(VKOperationCompleteListener vKOperationCompleteListener) {
        this.a = vKOperationCompleteListener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r0 != 5) goto L_0x0023;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setState(com.vk.sdk.api.httpClient.VKAbstractOperation.VKOperationState r9) {
        /*
            r8 = this;
            com.vk.sdk.api.httpClient.VKAbstractOperation$VKOperationState r0 = r8.b
            boolean r1 = r8.c
            int r0 = r0.ordinal()
            r2 = 2
            r3 = 4
            r4 = 3
            r5 = 5
            r6 = 0
            r7 = 1
            if (r0 == r7) goto L_0x0030
            if (r0 == r2) goto L_0x0025
            if (r0 == r4) goto L_0x0019
            if (r0 == r3) goto L_0x0023
            if (r0 == r5) goto L_0x0023
            goto L_0x003f
        L_0x0019:
            int r0 = r9.ordinal()
            if (r0 == r5) goto L_0x003f
            com.vk.sdk.api.httpClient.VKAbstractOperation$VKOperationState r0 = com.vk.sdk.api.httpClient.VKAbstractOperation.VKOperationState.Ready
            if (r9 == r0) goto L_0x003f
        L_0x0023:
            r6 = 1
            goto L_0x003f
        L_0x0025:
            int r0 = r9.ordinal()
            if (r0 == r4) goto L_0x003f
            if (r0 == r3) goto L_0x003f
            if (r0 == r5) goto L_0x003f
            goto L_0x0023
        L_0x0030:
            int r0 = r9.ordinal()
            if (r0 == r2) goto L_0x003f
            if (r0 == r4) goto L_0x003f
            if (r0 == r3) goto L_0x003d
            if (r0 == r5) goto L_0x003f
            goto L_0x0023
        L_0x003d:
            r6 = r1 ^ 1
        L_0x003f:
            if (r6 == 0) goto L_0x0042
            return
        L_0x0042:
            r8.b = r9
            com.vk.sdk.api.httpClient.VKAbstractOperation$VKOperationState r0 = com.vk.sdk.api.httpClient.VKAbstractOperation.VKOperationState.Finished
            if (r9 == r0) goto L_0x004c
            com.vk.sdk.api.httpClient.VKAbstractOperation$VKOperationState r0 = com.vk.sdk.api.httpClient.VKAbstractOperation.VKOperationState.Canceled
            if (r9 != r0) goto L_0x004f
        L_0x004c:
            r8.finish()
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vk.sdk.api.httpClient.VKAbstractOperation.setState(com.vk.sdk.api.httpClient.VKAbstractOperation$VKOperationState):void");
    }

    public void start(ExecutorService executorService) {
        this.d = executorService;
    }

    public VKOperationState state() {
        return this.b;
    }
}

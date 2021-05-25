package com.vk.sdk.api;

import android.os.Handler;
import android.os.Looper;
import com.vk.sdk.VKObject;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.httpClient.VKHttpClient;
public class VKBatchRequest extends VKObject {
    public final VKRequest[] c;
    public final VKResponse[] d;
    public final VKRequest.VKRequestListener[] e;
    public boolean f = false;
    public VKBatchRequestListener requestListener;

    public static abstract class VKBatchRequestListener {
        public void onComplete(VKResponse[] vKResponseArr) {
        }

        public void onError(VKError vKError) {
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ VKRequest a;

        /* renamed from: com.vk.sdk.api.VKBatchRequest$a$a  reason: collision with other inner class name */
        public class C0321a extends VKRequest.VKRequestListener {
            public final /* synthetic */ VKRequest.VKRequestListener a;

            public C0321a(VKRequest.VKRequestListener vKRequestListener) {
                this.a = vKRequestListener;
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onComplete(VKResponse vKResponse) {
                VKBatchRequest.this.provideResponse(vKResponse);
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onError(VKError vKError) {
                VKBatchRequest.this.provideError(vKError);
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onProgress(VKRequest.VKProgressType vKProgressType, long j, long j2) {
                VKRequest.VKRequestListener vKRequestListener = this.a;
                if (vKRequestListener != null) {
                    vKRequestListener.onProgress(vKProgressType, j, j2);
                }
            }
        }

        public a(VKRequest vKRequest) {
            this.a = vKRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            VKRequest vKRequest = this.a;
            vKRequest.setRequestListener(new C0321a(vKRequest.requestListener));
            VKHttpClient.enqueueOperation(this.a.getOperation());
        }
    }

    public VKBatchRequest(VKRequest... vKRequestArr) {
        int i = 0;
        this.c = vKRequestArr;
        this.d = new VKResponse[vKRequestArr.length];
        this.e = new VKRequest.VKRequestListener[vKRequestArr.length];
        while (true) {
            VKRequest[] vKRequestArr2 = this.c;
            if (i < vKRequestArr2.length) {
                this.e[i] = vKRequestArr2[i].requestListener;
                i++;
            } else {
                return;
            }
        }
    }

    public void cancel() {
        if (!this.f) {
            this.f = true;
            for (VKRequest vKRequest : this.c) {
                vKRequest.cancel();
            }
        }
    }

    public void executeWithListener(VKBatchRequestListener vKBatchRequestListener) {
        if (this.c == null) {
            provideError(new VKError((int) VKError.VK_REQUEST_NOT_PREPARED));
            return;
        }
        this.requestListener = vKBatchRequestListener;
        Handler handler = new Handler(Looper.myLooper());
        int i = 0;
        for (VKRequest vKRequest : this.c) {
            handler.postDelayed(new a(vKRequest), (long) i);
            i += 333;
        }
    }

    public void provideError(VKError vKError) {
        if (!this.f) {
            for (int i = 0; i < this.c.length; i++) {
                VKRequest.VKRequestListener vKRequestListener = this.e[i];
                if (vKRequestListener != null) {
                    vKRequestListener.onError(vKError);
                }
            }
            VKBatchRequestListener vKBatchRequestListener = this.requestListener;
            if (vKBatchRequestListener != null) {
                vKBatchRequestListener.onError(vKError);
            }
            cancel();
        }
    }

    public void provideResponse(VKResponse vKResponse) {
        VKResponse[] vKResponseArr = this.d;
        VKRequest vKRequest = vKResponse.request;
        int i = 0;
        while (true) {
            VKRequest[] vKRequestArr = this.c;
            if (i >= vKRequestArr.length) {
                i = -1;
                break;
            } else if (vKRequestArr[i].equals(vKRequest)) {
                break;
            } else {
                i++;
            }
        }
        vKResponseArr[i] = vKResponse;
        for (VKResponse vKResponse2 : this.d) {
            if (vKResponse2 == null) {
                return;
            }
        }
        for (int i2 = 0; i2 < this.c.length; i2++) {
            VKRequest.VKRequestListener vKRequestListener = this.e[i2];
            if (vKRequestListener != null) {
                vKRequestListener.onComplete(this.d[i2]);
            }
        }
        VKBatchRequestListener vKBatchRequestListener = this.requestListener;
        if (vKBatchRequestListener != null) {
            vKBatchRequestListener.onComplete(this.d);
        }
    }
}

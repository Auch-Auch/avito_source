package com.vk.sdk.api.httpClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import com.vk.sdk.api.httpClient.VKAbstractOperation;
import com.vk.sdk.api.httpClient.VKHttpClient;
public class VKImageOperation extends VKHttpOperation<Bitmap> {
    public float imageDensity;

    public static abstract class VKImageOperationListener extends VKAbstractOperation.VKAbstractCompleteListener<VKImageOperation, Bitmap> {
    }

    public class a implements VKAbstractOperation.VKOperationCompleteListener {
        public final /* synthetic */ VKImageOperationListener a;

        /* renamed from: com.vk.sdk.api.httpClient.VKImageOperation$a$a  reason: collision with other inner class name */
        public class RunnableC0323a implements Runnable {
            public final /* synthetic */ Bitmap a;

            public RunnableC0323a(Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.a.onComplete(VKImageOperation.this, this.a);
            }
        }

        public a(VKImageOperationListener vKImageOperationListener) {
            this.a = vKImageOperationListener;
        }

        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKOperationCompleteListener
        public void onComplete() {
            if (VKImageOperation.this.state() == VKAbstractOperation.VKOperationState.Finished) {
                VKImageOperation vKImageOperation = VKImageOperation.this;
                if (vKImageOperation.mLastException == null) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0323a(vKImageOperation.getResultObject()));
                    return;
                }
            }
            VKImageOperationListener vKImageOperationListener = this.a;
            VKImageOperation vKImageOperation2 = VKImageOperation.this;
            vKImageOperationListener.onError(vKImageOperation2, vKImageOperation2.generateError(vKImageOperation2.mLastException));
        }
    }

    public VKImageOperation(String str) {
        super(new VKHttpClient.VKHTTPRequest(str));
    }

    public void setImageOperationListener(VKImageOperationListener vKImageOperationListener) {
        setCompleteListener(new a(vKImageOperationListener));
    }

    @Override // com.vk.sdk.api.httpClient.VKHttpOperation, com.vk.sdk.api.httpClient.VKAbstractOperation
    public Bitmap getResultObject() {
        byte[] responseData = getResponseData();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(responseData, 0, responseData.length);
        return this.imageDensity > 0.0f ? Bitmap.createScaledBitmap(decodeByteArray, (int) (((float) decodeByteArray.getWidth()) * this.imageDensity), (int) (((float) decodeByteArray.getHeight()) * this.imageDensity), true) : decodeByteArray;
    }
}

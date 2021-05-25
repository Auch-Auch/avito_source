package com.vk.sdk.api.httpClient;

import androidx.annotation.Nullable;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.httpClient.VKAbstractOperation;
import com.vk.sdk.api.httpClient.VKHttpClient;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
public class VKHttpOperation<ResponseType> extends VKAbstractOperation {
    public final VKHttpClient.VKHTTPRequest e;
    public String f;
    public Exception mLastException;
    @Nullable
    public VKHttpClient.VKHttpResponse response;

    public class a implements VKAbstractOperation.VKOperationCompleteListener {
        public final /* synthetic */ VKAbstractOperation.VKAbstractCompleteListener a;

        public a(VKAbstractOperation.VKAbstractCompleteListener vKAbstractCompleteListener) {
            this.a = vKAbstractCompleteListener;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.vk.sdk.api.httpClient.VKAbstractOperation$VKAbstractCompleteListener */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKOperationCompleteListener
        public void onComplete() {
            if (VKHttpOperation.this.state() == VKAbstractOperation.VKOperationState.Finished) {
                VKHttpOperation vKHttpOperation = VKHttpOperation.this;
                if (vKHttpOperation.mLastException == null) {
                    this.a.onComplete(vKHttpOperation, vKHttpOperation.getResultObject());
                    return;
                }
            }
            VKAbstractOperation.VKAbstractCompleteListener vKAbstractCompleteListener = this.a;
            VKHttpOperation vKHttpOperation2 = VKHttpOperation.this;
            vKAbstractCompleteListener.onError(vKHttpOperation2, vKHttpOperation2.generateError(vKHttpOperation2.mLastException));
        }
    }

    public VKHttpOperation(VKHttpClient.VKHTTPRequest vKHTTPRequest) {
        this.e = vKHTTPRequest;
    }

    @Override // com.vk.sdk.api.httpClient.VKAbstractOperation
    public void cancel() {
        VKHttpClient.cancelHttpOperation(this);
        super.cancel();
    }

    @Override // com.vk.sdk.api.httpClient.VKAbstractOperation
    public void finish() {
        postExecution();
        super.finish();
    }

    public VKError generateError(Exception exc) {
        VKError vKError;
        if (state() == VKAbstractOperation.VKOperationState.Canceled) {
            vKError = new VKError((int) VKError.VK_CANCELED);
        } else {
            vKError = new VKError((int) VKError.VK_REQUEST_HTTP_FAILED);
        }
        if (exc != null) {
            String message = exc.getMessage();
            vKError.errorMessage = message;
            if (message == null) {
                vKError.errorMessage = exc.toString();
            }
            vKError.httpError = exc;
        }
        return vKError;
    }

    public byte[] getResponseData() {
        VKHttpClient.VKHttpResponse vKHttpResponse = this.response;
        if (vKHttpResponse != null) {
            return vKHttpResponse.responseBytes;
        }
        return null;
    }

    public String getResponseString() {
        VKHttpClient.VKHttpResponse vKHttpResponse = this.response;
        if (vKHttpResponse == null || vKHttpResponse.responseBytes == null) {
            return null;
        }
        if (this.f == null) {
            try {
                this.f = new String(this.response.responseBytes, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                this.mLastException = e2;
            }
        }
        return this.f;
    }

    @Override // com.vk.sdk.api.httpClient.VKAbstractOperation
    public ResponseType getResultObject() {
        VKHttpClient.VKHttpResponse vKHttpResponse = this.response;
        if (vKHttpResponse != null) {
            return (ResponseType) vKHttpResponse.responseBytes;
        }
        return null;
    }

    public VKHttpClient.VKHTTPRequest getUriRequest() {
        return this.e;
    }

    public boolean postExecution() {
        return true;
    }

    public <OperationType extends VKHttpOperation> void setHttpOperationListener(VKAbstractOperation.VKAbstractCompleteListener<OperationType, ResponseType> vKAbstractCompleteListener) {
        setCompleteListener(new a(vKAbstractCompleteListener));
    }

    @Override // com.vk.sdk.api.httpClient.VKAbstractOperation
    public void start(ExecutorService executorService) {
        super.start(executorService);
        setState(VKAbstractOperation.VKOperationState.Executing);
        try {
            VKHttpClient.VKHTTPRequest vKHTTPRequest = this.e;
            if (!vKHTTPRequest.isAborted) {
                this.response = VKHttpClient.execute(vKHTTPRequest);
                setState(VKAbstractOperation.VKOperationState.Finished);
            }
        } catch (IOException e2) {
            this.mLastException = e2;
        }
    }
}

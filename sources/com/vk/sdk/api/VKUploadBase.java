package com.vk.sdk.api;

import a2.s.a.a.e;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.httpClient.VKAbstractOperation;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKJsonOperation;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
public abstract class VKUploadBase extends VKRequest {

    public class b extends VKAbstractOperation {
        public VKAbstractOperation e;

        public class a extends VKRequest.VKRequestListener {
            public final /* synthetic */ VKRequest.VKRequestListener a;

            public a(VKRequest.VKRequestListener vKRequestListener) {
                this.a = vKRequestListener;
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onComplete(VKResponse vKResponse) {
                b.this.setState(VKAbstractOperation.VKOperationState.Finished);
                vKResponse.request = VKUploadBase.this;
                VKRequest.VKRequestListener vKRequestListener = this.a;
                if (vKRequestListener != null) {
                    vKRequestListener.onComplete(vKResponse);
                }
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onError(VKError vKError) {
                b.this.setState(VKAbstractOperation.VKOperationState.Finished);
                vKError.request = VKUploadBase.this;
                VKRequest.VKRequestListener vKRequestListener = this.a;
                if (vKRequestListener != null) {
                    vKRequestListener.onError(vKError);
                }
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onProgress(VKRequest.VKProgressType vKProgressType, long j, long j2) {
                VKRequest.VKRequestListener vKRequestListener = this.a;
                if (vKRequestListener != null) {
                    vKRequestListener.onProgress(vKProgressType, j, j2);
                }
            }
        }

        /* renamed from: com.vk.sdk.api.VKUploadBase$b$b  reason: collision with other inner class name */
        public class C0322b extends VKRequest.VKRequestListener {

            /* renamed from: com.vk.sdk.api.VKUploadBase$b$b$a */
            public class a extends VKJsonOperation.VKJSONOperationCompleteListener {
                public a() {
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.vk.sdk.api.httpClient.VKAbstractOperation, java.lang.Object] */
                @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
                public void onComplete(VKJsonOperation vKJsonOperation, JSONObject jSONObject) {
                    VKRequest saveRequest = VKUploadBase.this.getSaveRequest(jSONObject);
                    saveRequest.setRequestListener(new e(this));
                    b.this.e = saveRequest.getOperation();
                    VKHttpClient.enqueueOperation(b.this.e);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.vk.sdk.api.httpClient.VKAbstractOperation, com.vk.sdk.api.VKError] */
                @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
                public void onError(VKJsonOperation vKJsonOperation, VKError vKError) {
                    VKRequest.VKRequestListener vKRequestListener = VKUploadBase.this.requestListener;
                    if (vKRequestListener != null) {
                        vKRequestListener.onError(vKError);
                    }
                }
            }

            public C0322b(a aVar) {
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onComplete(VKResponse vKResponse) {
                try {
                    VKJsonOperation uploadOperation = VKUploadBase.this.getUploadOperation(vKResponse.json.getJSONObject(CommonKt.EXTRA_RESPONSE).getString("upload_url"));
                    uploadOperation.setHttpOperationListener(new a());
                    b.this.e = uploadOperation;
                    VKHttpClient.enqueueOperation(uploadOperation);
                } catch (JSONException e) {
                    VKError vKError = new VKError((int) VKError.VK_JSON_FAILED);
                    vKError.httpError = e;
                    vKError.errorMessage = e.getMessage();
                    VKRequest.VKRequestListener vKRequestListener = VKUploadBase.this.requestListener;
                    if (vKRequestListener != null) {
                        vKRequestListener.onError(vKError);
                    }
                }
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onError(VKError vKError) {
                VKRequest.VKRequestListener vKRequestListener = VKUploadBase.this.requestListener;
                if (vKRequestListener != null) {
                    vKRequestListener.onError(vKError);
                }
            }
        }

        public b(a aVar) {
        }

        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation
        public void cancel() {
            VKAbstractOperation vKAbstractOperation = this.e;
            if (vKAbstractOperation != null) {
                vKAbstractOperation.cancel();
            }
            super.cancel();
        }

        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation
        public void finish() {
            super.finish();
            this.e = null;
        }

        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation
        public Object getResultObject() {
            return null;
        }

        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation
        public void start(ExecutorService executorService) {
            super.start(executorService);
            VKUploadBase vKUploadBase = VKUploadBase.this;
            vKUploadBase.requestListener = new a(vKUploadBase.requestListener);
            setState(VKAbstractOperation.VKOperationState.Executing);
            VKRequest serverRequest = VKUploadBase.this.getServerRequest();
            serverRequest.setRequestListener(new C0322b(null));
            VKAbstractOperation operation = serverRequest.getOperation();
            this.e = operation;
            VKHttpClient.enqueueOperation(operation);
        }
    }

    public VKUploadBase() {
        super(null);
    }

    @Override // com.vk.sdk.api.VKRequest
    public VKAbstractOperation getOperation() {
        return new b(null);
    }

    public abstract VKRequest getSaveRequest(JSONObject jSONObject);

    public abstract VKRequest getServerRequest();

    public abstract VKJsonOperation getUploadOperation(String str);
}

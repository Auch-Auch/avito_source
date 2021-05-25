package com.vk.sdk.api.httpClient;

import com.vk.sdk.api.httpClient.VKAbstractOperation;
import com.vk.sdk.api.httpClient.VKHttpClient;
import org.json.JSONObject;
public class VKJsonOperation extends VKHttpOperation<JSONObject> {
    public JSONObject g;

    public static abstract class VKJSONOperationCompleteListener extends VKAbstractOperation.VKAbstractCompleteListener<VKJsonOperation, JSONObject> {
    }

    public VKJsonOperation(VKHttpClient.VKHTTPRequest vKHTTPRequest) {
        super(vKHTTPRequest);
    }

    public JSONObject getResponseJson() {
        if (this.g == null) {
            String responseString = getResponseString();
            if (responseString == null) {
                return null;
            }
            try {
                this.g = new JSONObject(responseString);
            } catch (Exception e) {
                this.mLastException = e;
            }
        }
        return this.g;
    }

    @Override // com.vk.sdk.api.httpClient.VKHttpOperation
    public boolean postExecution() {
        if (!super.postExecution()) {
            return false;
        }
        this.g = getResponseJson();
        return true;
    }

    @Override // com.vk.sdk.api.httpClient.VKHttpOperation, com.vk.sdk.api.httpClient.VKAbstractOperation
    public JSONObject getResultObject() {
        return this.g;
    }
}

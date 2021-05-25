package com.vk.sdk.api.httpClient;

import com.vk.sdk.api.VKDefaultParser;
import com.vk.sdk.api.VKParser;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.model.VKApiModel;
public class VKModelOperation extends VKJsonOperation {
    public final VKParser mParser;
    public Object parsedModel;

    public VKModelOperation(VKHttpClient.VKHTTPRequest vKHTTPRequest, Class<? extends VKApiModel> cls) {
        super(vKHTTPRequest);
        this.mParser = new VKDefaultParser(cls);
    }

    @Override // com.vk.sdk.api.httpClient.VKJsonOperation, com.vk.sdk.api.httpClient.VKHttpOperation
    public boolean postExecution() {
        if (super.postExecution() && this.mParser != null) {
            try {
                this.parsedModel = this.mParser.createModel(getResponseJson());
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public VKModelOperation(VKHttpClient.VKHTTPRequest vKHTTPRequest, VKParser vKParser) {
        super(vKHTTPRequest);
        this.mParser = vKParser;
    }
}

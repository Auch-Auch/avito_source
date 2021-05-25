package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKParser;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKApiModel;
import java.util.Locale;
public abstract class VKApiBase {
    public abstract String getMethodsGroup();

    public VKRequest prepareRequest(String str, VKParameters vKParameters) {
        return new VKRequest(String.format(Locale.US, "%s.%s", getMethodsGroup(), str), vKParameters, null);
    }

    public VKRequest prepareRequest(String str, VKParameters vKParameters, Class<? extends VKApiModel> cls) {
        return new VKRequest(String.format(Locale.US, "%s.%s", getMethodsGroup(), str), vKParameters, cls);
    }

    public VKRequest prepareRequest(String str, VKParameters vKParameters, VKParser vKParser) {
        VKRequest vKRequest = new VKRequest(String.format(Locale.US, "%s.%s", getMethodsGroup(), str), vKParameters);
        vKRequest.setResponseParser(vKParser);
        return vKRequest;
    }
}

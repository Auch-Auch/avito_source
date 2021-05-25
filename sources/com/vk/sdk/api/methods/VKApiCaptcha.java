package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKRequest;
public class VKApiCaptcha extends VKApiBase {
    public VKRequest force() {
        return prepareRequest("force", null);
    }

    @Override // com.vk.sdk.api.methods.VKApiBase
    public String getMethodsGroup() {
        return "captcha";
    }
}

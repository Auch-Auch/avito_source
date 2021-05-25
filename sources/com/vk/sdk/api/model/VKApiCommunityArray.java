package com.vk.sdk.api.model;

import org.json.JSONException;
import org.json.JSONObject;
public class VKApiCommunityArray extends VKList<VKApiCommunityFull> {
    @Override // com.vk.sdk.api.model.VKList, com.vk.sdk.api.model.VKApiModel
    public VKApiModel parse(JSONObject jSONObject) throws JSONException {
        fill(jSONObject, VKApiCommunityFull.class);
        return this;
    }
}

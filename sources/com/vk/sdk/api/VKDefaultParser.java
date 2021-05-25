package com.vk.sdk.api;

import com.vk.sdk.api.model.VKApiModel;
import org.json.JSONObject;
public class VKDefaultParser extends VKParser {
    public final Class<? extends VKApiModel> a;

    public VKDefaultParser(Class<? extends VKApiModel> cls) {
        this.a = cls;
    }

    @Override // com.vk.sdk.api.VKParser
    public Object createModel(JSONObject jSONObject) {
        try {
            VKApiModel vKApiModel = (VKApiModel) this.a.newInstance();
            vKApiModel.parse(jSONObject);
            return vKApiModel;
        } catch (Exception unused) {
            return null;
        }
    }
}

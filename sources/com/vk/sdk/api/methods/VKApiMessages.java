package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKParser;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKApiGetDialogResponse;
import com.vk.sdk.api.model.VKApiGetMessagesResponse;
import org.json.JSONObject;
public class VKApiMessages extends VKApiBase {

    public class a extends VKParser {
        public a(VKApiMessages vKApiMessages) {
        }

        @Override // com.vk.sdk.api.VKParser
        public Object createModel(JSONObject jSONObject) {
            return new VKApiGetMessagesResponse(jSONObject);
        }
    }

    public class b extends VKParser {
        public b(VKApiMessages vKApiMessages) {
        }

        @Override // com.vk.sdk.api.VKParser
        public Object createModel(JSONObject jSONObject) {
            return new VKApiGetDialogResponse(jSONObject);
        }
    }

    public VKRequest get() {
        return get(VKParameters.from("count", "10"));
    }

    public VKRequest getDialogs() {
        return getDialogs(VKParameters.from("count", "5"));
    }

    @Override // com.vk.sdk.api.methods.VKApiBase
    public String getMethodsGroup() {
        return "messages";
    }

    public VKRequest get(VKParameters vKParameters) {
        return prepareRequest("get", vKParameters, new a(this));
    }

    public VKRequest getDialogs(VKParameters vKParameters) {
        return prepareRequest("getDialogs", vKParameters, new b(this));
    }
}

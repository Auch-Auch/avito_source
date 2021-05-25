package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKParser;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKApiUserFull;
import com.vk.sdk.api.model.VKList;
import com.vk.sdk.api.model.VKUsersArray;
import org.json.JSONObject;
public class VKApiUsers extends VKApiBase {

    public class a extends VKParser {
        public a(VKApiUsers vKApiUsers) {
        }

        @Override // com.vk.sdk.api.VKParser
        public Object createModel(JSONObject jSONObject) {
            return new VKList(jSONObject, VKApiUserFull.class);
        }
    }

    public class b extends VKParameters {
        private static final long serialVersionUID = 7458591447441581671L;
        public final /* synthetic */ int a;

        public b(VKApiUsers vKApiUsers, int i) {
            this.a = i;
            put("user_id", String.valueOf(i));
        }
    }

    public VKRequest get() {
        return get(null);
    }

    public VKRequest getFollowers() {
        return getFollowers(null);
    }

    @Override // com.vk.sdk.api.methods.VKApiBase
    public String getMethodsGroup() {
        return "users";
    }

    public VKRequest getSubscriptions() {
        return getSubscriptions(null);
    }

    public VKRequest isAppUser() {
        return prepareRequest("isAppUser", null);
    }

    public VKRequest report(VKParameters vKParameters) {
        return prepareRequest("report", vKParameters);
    }

    public VKRequest search(VKParameters vKParameters) {
        return prepareRequest("search", vKParameters, VKUsersArray.class);
    }

    public VKRequest get(VKParameters vKParameters) {
        return prepareRequest("get", vKParameters, new a(this));
    }

    public VKRequest getFollowers(VKParameters vKParameters) {
        return prepareRequest("getFollowers", vKParameters);
    }

    public VKRequest getSubscriptions(VKParameters vKParameters) {
        return prepareRequest("getSubscriptions", vKParameters);
    }

    public VKRequest isAppUser(int i) {
        return prepareRequest("isAppUser", new b(this, i));
    }
}

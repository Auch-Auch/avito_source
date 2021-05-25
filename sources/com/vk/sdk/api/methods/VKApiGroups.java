package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKApiCommunityArray;
import com.vk.sdk.api.model.VKUsersArray;
public class VKApiGroups extends VKApiBase {

    public class a extends VKParameters {
        public final /* synthetic */ int a;

        public a(VKApiGroups vKApiGroups, int i) {
            this.a = i;
            put("group_id", String.valueOf(i));
        }
    }

    public VKRequest banUser(VKParameters vKParameters) {
        return prepareRequest("banUser", vKParameters);
    }

    public VKRequest get(VKParameters vKParameters) {
        if (!vKParameters.containsKey("extended") || ((Integer) vKParameters.get("extended")).intValue() != 1) {
            return prepareRequest("get", vKParameters);
        }
        return prepareRequest("get", vKParameters, VKApiCommunityArray.class);
    }

    public VKRequest getBanned(VKParameters vKParameters) {
        return prepareRequest("getBanned", vKParameters, VKUsersArray.class);
    }

    public VKRequest getById(VKParameters vKParameters) {
        return prepareRequest("getById", vKParameters, VKApiCommunityArray.class);
    }

    public VKRequest getInvites(VKParameters vKParameters) {
        return prepareRequest("getInvites", vKParameters, VKApiCommunityArray.class);
    }

    public VKRequest getMembers(VKParameters vKParameters) {
        return prepareRequest("getMembers", vKParameters);
    }

    @Override // com.vk.sdk.api.methods.VKApiBase
    public String getMethodsGroup() {
        return "groups";
    }

    public VKRequest isMember(VKParameters vKParameters) {
        return prepareRequest("isMember", vKParameters);
    }

    public VKRequest join(VKParameters vKParameters) {
        return prepareRequest("join", vKParameters);
    }

    public VKRequest leave(VKParameters vKParameters) {
        return prepareRequest("leave", vKParameters);
    }

    public VKRequest search(VKParameters vKParameters) {
        return prepareRequest("search", vKParameters, VKApiCommunityArray.class);
    }

    public VKRequest unbanUser(VKParameters vKParameters) {
        return prepareRequest("unbanUser", vKParameters);
    }

    public VKRequest leave(int i) {
        return prepareRequest("leave", new a(this, i));
    }
}

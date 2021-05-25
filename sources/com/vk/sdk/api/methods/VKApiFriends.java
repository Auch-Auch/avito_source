package com.vk.sdk.api.methods;

import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKUsersArray;
public class VKApiFriends extends VKApiBase {
    public VKRequest add(VKParameters vKParameters) {
        return prepareRequest(ProductAction.ACTION_ADD, vKParameters);
    }

    public VKRequest addList(VKParameters vKParameters) {
        return prepareRequest("addList", vKParameters);
    }

    public VKRequest areFriends(VKParameters vKParameters) {
        return prepareRequest("areFriends", vKParameters);
    }

    public VKRequest delete(VKParameters vKParameters) {
        return prepareRequest(PhoneActionStrings.REMOVE, vKParameters);
    }

    public VKRequest deleteAllRequests(VKParameters vKParameters) {
        return prepareRequest("deleteAllRequests", vKParameters);
    }

    public VKRequest deleteList(VKParameters vKParameters) {
        return prepareRequest("deleteList", vKParameters);
    }

    public VKRequest edit(VKParameters vKParameters) {
        return prepareRequest("edit", vKParameters);
    }

    public VKRequest editList(VKParameters vKParameters) {
        return prepareRequest("editList", vKParameters);
    }

    public VKRequest get(VKParameters vKParameters) {
        if (vKParameters.get("fields") != null) {
            return prepareRequest("get", vKParameters, VKUsersArray.class);
        }
        return prepareRequest("get", vKParameters);
    }

    public VKRequest getAppUsers(VKParameters vKParameters) {
        return prepareRequest("getAppUsers", vKParameters);
    }

    public VKRequest getByPhones(VKParameters vKParameters) {
        return prepareRequest("getByPhones", vKParameters, VKUsersArray.class);
    }

    public VKRequest getLists(VKParameters vKParameters) {
        return prepareRequest("getLists", vKParameters);
    }

    @Override // com.vk.sdk.api.methods.VKApiBase
    public String getMethodsGroup() {
        return "friends";
    }

    public VKRequest getMutual(VKParameters vKParameters) {
        return prepareRequest("getMutual", vKParameters);
    }

    public VKRequest getOnline(VKParameters vKParameters) {
        return prepareRequest("getOnline", vKParameters);
    }

    public VKRequest getRecent(VKParameters vKParameters) {
        return prepareRequest("getRecent", vKParameters);
    }

    public VKRequest getRequests(VKParameters vKParameters) {
        return prepareRequest("getRequests", vKParameters);
    }

    public VKRequest getSuggestions(VKParameters vKParameters) {
        return prepareRequest("getSuggestions", vKParameters);
    }
}

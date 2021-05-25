package com.vk.sdk.api.methods;

import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKCommentArray;
import com.vk.sdk.api.model.VKPostArray;
import com.vk.sdk.api.model.VKWallPostResult;
public class VKApiWall extends VKApiBase {
    public static final String EXTENDED = "extended";

    public VKRequest addComment(VKParameters vKParameters) {
        return prepareRequest("addComment", vKParameters);
    }

    public VKRequest delete(VKParameters vKParameters) {
        return prepareRequest(PhoneActionStrings.REMOVE, vKParameters);
    }

    public VKRequest deleteComment(VKParameters vKParameters) {
        return prepareRequest("deleteComment", vKParameters);
    }

    public VKRequest edit(VKParameters vKParameters) {
        return prepareRequest("edit", vKParameters);
    }

    public VKRequest editComment(VKParameters vKParameters) {
        return prepareRequest("editComment", vKParameters);
    }

    public VKRequest get(VKParameters vKParameters) {
        if (!vKParameters.containsKey("extended") || ((Integer) vKParameters.get("extended")).intValue() != 1) {
            return prepareRequest("get", vKParameters);
        }
        return prepareRequest("get", vKParameters, VKPostArray.class);
    }

    public VKRequest getById(VKParameters vKParameters) {
        return prepareRequest("getById", vKParameters, VKPostArray.class);
    }

    public VKRequest getComments(VKParameters vKParameters) {
        return prepareRequest("getComments", vKParameters, VKCommentArray.class);
    }

    @Override // com.vk.sdk.api.methods.VKApiBase
    public String getMethodsGroup() {
        return "wall";
    }

    public VKRequest getReposts(VKParameters vKParameters) {
        return prepareRequest("getReposts", vKParameters);
    }

    public VKRequest post(VKParameters vKParameters) {
        return prepareRequest("post", vKParameters, VKWallPostResult.class);
    }

    public VKRequest reportComment(VKParameters vKParameters) {
        return prepareRequest("reportComment", vKParameters);
    }

    public VKRequest reportPost(VKParameters vKParameters) {
        return prepareRequest("reportPost", vKParameters);
    }

    public VKRequest repost(VKParameters vKParameters) {
        return prepareRequest("repost", vKParameters);
    }

    public VKRequest restore(VKParameters vKParameters) {
        return prepareRequest("restore", vKParameters);
    }

    public VKRequest restoreComment(VKParameters vKParameters) {
        return prepareRequest("restoreComment", vKParameters);
    }

    public VKRequest savePost(VKParameters vKParameters) {
        return prepareRequest("savePost", vKParameters);
    }
}

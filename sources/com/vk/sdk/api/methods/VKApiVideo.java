package com.vk.sdk.api.methods;

import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VkVideoArray;
public class VKApiVideo extends VKApiBase {
    public VKRequest add(VKParameters vKParameters) {
        return prepareRequest(ProductAction.ACTION_ADD, vKParameters);
    }

    public VKRequest addAlbum(VKParameters vKParameters) {
        return prepareRequest("addAlbum", vKParameters);
    }

    public VKRequest addToAlbum(VKParameters vKParameters) {
        return prepareRequest("addToAlbum", vKParameters);
    }

    public VKRequest createComment(VKParameters vKParameters) {
        return prepareRequest("createComment", vKParameters);
    }

    public VKRequest delete(VKParameters vKParameters) {
        return prepareRequest(PhoneActionStrings.REMOVE, vKParameters);
    }

    public VKRequest deleteAlbum(VKParameters vKParameters) {
        return prepareRequest("deleteAlbum", vKParameters);
    }

    public VKRequest deleteComment(VKParameters vKParameters) {
        return prepareRequest("deleteComment", vKParameters);
    }

    public VKRequest edit(VKParameters vKParameters) {
        return prepareRequest("edit", vKParameters);
    }

    public VKRequest editAlbum(VKParameters vKParameters) {
        return prepareRequest("editAlbum", vKParameters);
    }

    public VKRequest editComment(VKParameters vKParameters) {
        return prepareRequest("editComment", vKParameters);
    }

    public VKRequest get() {
        return get(null);
    }

    public VKRequest getAlbumById(VKParameters vKParameters) {
        return prepareRequest("getAlbumById", vKParameters);
    }

    public VKRequest getAlbums() {
        return getAlbums(null);
    }

    public VKRequest getAlbumsByVideo(VKParameters vKParameters) {
        return prepareRequest("getAlbumsByVideo", vKParameters);
    }

    public VKRequest getComments(VKParameters vKParameters) {
        return prepareRequest("getComments", vKParameters);
    }

    @Override // com.vk.sdk.api.methods.VKApiBase
    public String getMethodsGroup() {
        return "video";
    }

    public VKRequest getNewTags(VKParameters vKParameters) {
        return prepareRequest("getNewTags", vKParameters);
    }

    public VKRequest getTags(VKParameters vKParameters) {
        return prepareRequest("getTags", vKParameters);
    }

    public VKRequest getUserVideos(VKParameters vKParameters) {
        return prepareRequest("getUserVideos", vKParameters, VkVideoArray.class);
    }

    public VKRequest putTag(VKParameters vKParameters) {
        return prepareRequest("putTag", vKParameters);
    }

    public VKRequest removeFromAlbum(VKParameters vKParameters) {
        return prepareRequest("removeFromAlbum", vKParameters);
    }

    public VKRequest removeTag(VKParameters vKParameters) {
        return prepareRequest("removeTag", vKParameters);
    }

    public VKRequest reorderAlbums(VKParameters vKParameters) {
        return prepareRequest("getAlbumById", vKParameters);
    }

    public VKRequest reorderVideos(VKParameters vKParameters) {
        return prepareRequest("getAlbumById", vKParameters);
    }

    public VKRequest report(VKParameters vKParameters) {
        return prepareRequest("report", vKParameters);
    }

    public VKRequest reportComment(VKParameters vKParameters) {
        return prepareRequest("reportComment", vKParameters);
    }

    public VKRequest restore(VKParameters vKParameters) {
        return prepareRequest("restore", vKParameters);
    }

    public VKRequest restoreComment(VKParameters vKParameters) {
        return prepareRequest("restoreComment", vKParameters);
    }

    public VKRequest save(VKParameters vKParameters) {
        return prepareRequest("save", vKParameters);
    }

    public VKRequest search(VKParameters vKParameters) {
        return prepareRequest("search", vKParameters, VkVideoArray.class);
    }

    public VKRequest get(VKParameters vKParameters) {
        return prepareRequest("get", vKParameters, VkVideoArray.class);
    }

    public VKRequest getAlbums(VKParameters vKParameters) {
        return prepareRequest("getAlbums", vKParameters);
    }
}

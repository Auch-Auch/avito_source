package com.vk.sdk.api.methods;

import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VkAudioArray;
public class VKApiAudio extends VKApiBase {
    public VKRequest add(VKParameters vKParameters) {
        return prepareRequest(ProductAction.ACTION_ADD, vKParameters);
    }

    public VKRequest addAlbum(VKParameters vKParameters) {
        return prepareRequest("addAlbum", vKParameters);
    }

    public VKRequest delete(VKParameters vKParameters) {
        return prepareRequest(PhoneActionStrings.REMOVE, vKParameters);
    }

    public VKRequest deleteAlbum(VKParameters vKParameters) {
        return prepareRequest("deleteAlbum", vKParameters);
    }

    public VKRequest edit(VKParameters vKParameters) {
        return prepareRequest("edit", vKParameters);
    }

    public VKRequest editAlbum(VKParameters vKParameters) {
        return prepareRequest("editAlbum", vKParameters);
    }

    public VKRequest get() {
        return get(null);
    }

    public VKRequest getAlbums() {
        return getAlbums(null);
    }

    public VKRequest getBroadcastList() {
        return getBroadcastList(null);
    }

    public VKRequest getById(VKParameters vKParameters) {
        return prepareRequest("getById", vKParameters);
    }

    public VKRequest getCount(VKParameters vKParameters) {
        return prepareRequest("getCount", vKParameters);
    }

    public VKRequest getLyrics(VKParameters vKParameters) {
        return prepareRequest("getLyrics", vKParameters);
    }

    @Override // com.vk.sdk.api.methods.VKApiBase
    public String getMethodsGroup() {
        return "audio";
    }

    public VKRequest getPopular() {
        return getPopular(null);
    }

    public VKRequest getRecommendations() {
        return getRecommendations(null);
    }

    public VKRequest getUploadServer() {
        return getUploadServer(null);
    }

    public VKRequest moveToAlbum(VKParameters vKParameters) {
        return prepareRequest("moveToAlbum", vKParameters);
    }

    public VKRequest reorder(VKParameters vKParameters) {
        return prepareRequest("reorder", vKParameters);
    }

    public VKRequest restore(VKParameters vKParameters) {
        return prepareRequest("restore", vKParameters);
    }

    public VKRequest save(VKParameters vKParameters) {
        return prepareRequest("save", vKParameters);
    }

    public VKRequest search(VKParameters vKParameters) {
        return prepareRequest("search", vKParameters, VkAudioArray.class);
    }

    public VKRequest setBroadcast(VKParameters vKParameters) {
        return prepareRequest("setBroadcast", vKParameters);
    }

    public VKRequest get(VKParameters vKParameters) {
        return prepareRequest("get", vKParameters, VkAudioArray.class);
    }

    public VKRequest getAlbums(VKParameters vKParameters) {
        return prepareRequest("getAlbums", vKParameters);
    }

    public VKRequest getBroadcastList(VKParameters vKParameters) {
        return prepareRequest("getBroadcastList", vKParameters);
    }

    public VKRequest getPopular(VKParameters vKParameters) {
        return prepareRequest("getPopular", vKParameters, VkAudioArray.class);
    }

    public VKRequest getRecommendations(VKParameters vKParameters) {
        return prepareRequest("getRecommendations", vKParameters, VkAudioArray.class);
    }

    public VKRequest getUploadServer(VKParameters vKParameters) {
        return prepareRequest("getUploadServer", vKParameters);
    }
}

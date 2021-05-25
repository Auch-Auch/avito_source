package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.util.VKUtil;
public class VKApiPhotos extends VKApiBase {
    public VKRequest getMessagesUploadServer() {
        return prepareRequest("getMessagesUploadServer", null);
    }

    @Override // com.vk.sdk.api.methods.VKApiBase
    public String getMethodsGroup() {
        return "photos";
    }

    public VKRequest getUploadServer(long j) {
        return prepareRequest("getUploadServer", VKUtil.paramsFrom(VKApiConst.ALBUM_ID, String.valueOf(j)));
    }

    public VKRequest getWallUploadServer() {
        return prepareRequest("getWallUploadServer", null);
    }

    public VKRequest save(VKParameters vKParameters) {
        return prepareRequest("save", vKParameters, VKPhotoArray.class);
    }

    public VKRequest saveMessagesPhoto(VKParameters vKParameters) {
        return prepareRequest("saveMessagesPhoto", vKParameters, VKPhotoArray.class);
    }

    public VKRequest saveWallPhoto(VKParameters vKParameters) {
        return prepareRequest("saveWallPhoto", vKParameters, VKPhotoArray.class);
    }

    public VKRequest getUploadServer(long j, long j2) {
        return prepareRequest("getUploadServer", VKUtil.paramsFrom(VKApiConst.ALBUM_ID, Long.valueOf(j), "group_id", Long.valueOf(j2)));
    }

    public VKRequest getWallUploadServer(long j) {
        return prepareRequest("getWallUploadServer", VKUtil.paramsFrom("group_id", Long.valueOf(j)));
    }
}

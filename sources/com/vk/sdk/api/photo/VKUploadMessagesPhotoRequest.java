package com.vk.sdk.api.photo;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.util.VKJsonHelper;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
public class VKUploadMessagesPhotoRequest extends VKUploadPhotoBase {
    public VKUploadMessagesPhotoRequest(File file) {
        this.mImages = new File[]{file};
    }

    @Override // com.vk.sdk.api.VKUploadBase
    public VKRequest getSaveRequest(JSONObject jSONObject) {
        try {
            return VKApi.photos().saveMessagesPhoto(new VKParameters(VKJsonHelper.toMap(jSONObject)));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.vk.sdk.api.VKUploadBase
    public VKRequest getServerRequest() {
        return VKApi.photos().getMessagesUploadServer();
    }

    public VKUploadMessagesPhotoRequest(VKUploadImage vKUploadImage) {
        this.mImages = new File[]{vKUploadImage.getTmpFile()};
    }
}

package com.vk.sdk.api.photo;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.util.VKJsonHelper;
import com.vk.sdk.util.VKUtil;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
public class VKUploadWallPhotoRequest extends VKUploadPhotoBase {
    public VKUploadWallPhotoRequest(File file, long j, int i) {
        this.mUserId = j;
        this.mGroupId = (long) i;
        this.mImages = new File[]{file};
    }

    @Override // com.vk.sdk.api.VKUploadBase
    public VKRequest getSaveRequest(JSONObject jSONObject) {
        try {
            VKRequest saveWallPhoto = VKApi.photos().saveWallPhoto(new VKParameters(VKJsonHelper.toMap(jSONObject)));
            long j = this.mUserId;
            if (j != 0) {
                saveWallPhoto.addExtraParameters(VKUtil.paramsFrom("user_id", Long.valueOf(j)));
            }
            long j2 = this.mGroupId;
            if (j2 != 0) {
                saveWallPhoto.addExtraParameters(VKUtil.paramsFrom("group_id", Long.valueOf(j2)));
            }
            return saveWallPhoto;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.vk.sdk.api.VKUploadBase
    public VKRequest getServerRequest() {
        if (this.mGroupId != 0) {
            return VKApi.photos().getWallUploadServer(this.mGroupId);
        }
        return VKApi.photos().getWallUploadServer();
    }

    public VKUploadWallPhotoRequest(VKUploadImage vKUploadImage, long j, int i) {
        this.mUserId = j;
        this.mGroupId = (long) i;
        this.mImages = new File[]{vKUploadImage.getTmpFile()};
    }

    public VKUploadWallPhotoRequest(VKUploadImage[] vKUploadImageArr, long j, int i) {
        this.mUserId = j;
        this.mGroupId = (long) i;
        this.mImages = new File[vKUploadImageArr.length];
        for (int i2 = 0; i2 < vKUploadImageArr.length; i2++) {
            this.mImages[i2] = vKUploadImageArr[i2].getTmpFile();
        }
    }
}

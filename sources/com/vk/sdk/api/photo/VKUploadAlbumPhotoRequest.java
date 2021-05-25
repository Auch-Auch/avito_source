package com.vk.sdk.api.photo;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.util.VKJsonHelper;
import com.vk.sdk.util.VKUtil;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
public class VKUploadAlbumPhotoRequest extends VKUploadPhotoBase {
    public VKUploadAlbumPhotoRequest(File file, long j, long j2) {
        this.mAlbumId = j;
        this.mGroupId = j2;
        this.mImages = new File[]{file};
    }

    @Override // com.vk.sdk.api.VKUploadBase
    public VKRequest getSaveRequest(JSONObject jSONObject) {
        try {
            VKRequest save = VKApi.photos().save(new VKParameters(VKJsonHelper.toMap(jSONObject)));
            long j = this.mAlbumId;
            if (j != 0) {
                save.addExtraParameters(VKUtil.paramsFrom(VKApiConst.ALBUM_ID, Long.valueOf(j)));
            }
            long j2 = this.mGroupId;
            if (j2 != 0) {
                save.addExtraParameters(VKUtil.paramsFrom("group_id", Long.valueOf(j2)));
            }
            return save;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.vk.sdk.api.VKUploadBase
    public VKRequest getServerRequest() {
        if (this.mAlbumId == 0 || this.mGroupId == 0) {
            return VKApi.photos().getUploadServer(this.mAlbumId);
        }
        return VKApi.photos().getUploadServer(this.mAlbumId, this.mGroupId);
    }

    public VKUploadAlbumPhotoRequest(VKUploadImage vKUploadImage, long j, long j2) {
        this.mAlbumId = j;
        this.mGroupId = j2;
        this.mImages = new File[]{vKUploadImage.getTmpFile()};
    }
}

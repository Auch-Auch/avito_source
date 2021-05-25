package com.vk.sdk.api.photo;

import com.vk.sdk.api.VKUploadBase;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKJsonOperation;
import java.io.File;
public abstract class VKUploadPhotoBase extends VKUploadBase {
    public long mAlbumId;
    public long mGroupId;
    public File[] mImages;
    public long mUserId;

    @Override // com.vk.sdk.api.VKUploadBase
    public VKJsonOperation getUploadOperation(String str) {
        return new VKJsonOperation(VKHttpClient.fileUploadRequest(str, this.mImages));
    }
}

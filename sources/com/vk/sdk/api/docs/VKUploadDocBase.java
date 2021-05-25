package com.vk.sdk.api.docs;

import com.vk.sdk.api.VKUploadBase;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKJsonOperation;
import java.io.File;
public abstract class VKUploadDocBase extends VKUploadBase {
    public File mDoc;
    public long mGroupId;

    @Override // com.vk.sdk.api.VKUploadBase
    public VKJsonOperation getUploadOperation(String str) {
        return new VKJsonOperation(VKHttpClient.docUploadRequest(str, this.mDoc));
    }
}

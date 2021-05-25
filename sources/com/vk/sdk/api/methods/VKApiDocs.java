package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.docs.VKUploadDocRequest;
import com.vk.sdk.api.docs.VKUploadWallDocRequest;
import com.vk.sdk.api.model.VKDocsArray;
import com.vk.sdk.util.VKUtil;
import java.io.File;
public class VKApiDocs extends VKApiBase {
    @Override // com.vk.sdk.api.methods.VKApiBase
    public String getMethodsGroup() {
        return "docs";
    }

    public VKRequest getUploadServer() {
        return prepareRequest("getUploadServer", null);
    }

    public VKRequest getUploadWallServer() {
        return prepareRequest("getWallUploadServer", null);
    }

    public VKRequest save(VKParameters vKParameters) {
        return prepareRequest("save", vKParameters, VKDocsArray.class);
    }

    public VKRequest uploadDocRequest(File file) {
        return new VKUploadDocRequest(file);
    }

    public VKRequest uploadWallDocRequest(File file) {
        return new VKUploadWallDocRequest(file);
    }

    public VKRequest getUploadServer(long j) {
        return prepareRequest("getUploadServer", VKUtil.paramsFrom("group_id", Long.valueOf(j)));
    }

    public VKRequest getUploadWallServer(long j) {
        return prepareRequest("getWallUploadServer", VKUtil.paramsFrom("group_id", Long.valueOf(j)));
    }

    public VKRequest uploadDocRequest(File file, long j) {
        return new VKUploadDocRequest(file, j);
    }

    public VKRequest uploadWallDocRequest(File file, long j) {
        return new VKUploadWallDocRequest(file, j);
    }
}

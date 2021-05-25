package com.vk.sdk.api.docs;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.util.VKJsonHelper;
import com.vk.sdk.util.VKUtil;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
public class VKUploadWallDocRequest extends VKUploadDocBase {
    public VKUploadWallDocRequest(File file) {
        this.mDoc = file;
        this.mGroupId = 0;
    }

    @Override // com.vk.sdk.api.VKUploadBase
    public VKRequest getSaveRequest(JSONObject jSONObject) {
        try {
            VKRequest save = VKApi.docs().save(new VKParameters(VKJsonHelper.toMap(jSONObject)));
            long j = this.mGroupId;
            if (j != 0) {
                save.addExtraParameters(VKUtil.paramsFrom("group_id", Long.valueOf(j)));
            }
            return save;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.vk.sdk.api.VKUploadBase
    public VKRequest getServerRequest() {
        if (this.mGroupId != 0) {
            return VKApi.docs().getUploadWallServer(this.mGroupId);
        }
        return VKApi.docs().getUploadWallServer();
    }

    public VKUploadWallDocRequest(File file, long j) {
        this.mDoc = file;
        this.mGroupId = j;
    }
}

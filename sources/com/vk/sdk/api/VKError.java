package com.vk.sdk.api;

import android.net.Uri;
import com.facebook.internal.NativeProtocol;
import com.vk.sdk.VKObject;
import com.vk.sdk.util.VKJsonHelper;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public class VKError extends VKObject {
    public static final int VK_API_ERROR = -101;
    public static final int VK_CANCELED = -102;
    public static final int VK_JSON_FAILED = -104;
    public static final int VK_REQUEST_HTTP_FAILED = -105;
    public static final int VK_REQUEST_NOT_PREPARED = -103;
    public VKError apiError;
    public String captchaImg;
    public String captchaSid;
    public int errorCode;
    public String errorMessage;
    public String errorReason;
    public Exception httpError;
    public String redirectUri;
    public VKRequest request;
    public ArrayList<Map<String, String>> requestParams;

    public VKError(int i) {
        this.errorCode = i;
    }

    public static VKError getRegisteredError(long j) {
        return (VKError) VKObject.getRegisteredObject(j);
    }

    public void answerCaptcha(String str) {
        VKParameters vKParameters = new VKParameters();
        vKParameters.put(VKApiConst.CAPTCHA_SID, this.captchaSid);
        vKParameters.put(VKApiConst.CAPTCHA_KEY, str);
        this.request.addExtraParameters(vKParameters);
        this.request.repeat();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VKError (");
        int i = this.errorCode;
        switch (i) {
            case VK_REQUEST_HTTP_FAILED /* -105 */:
                sb.append("HTTP failed");
                break;
            case VK_JSON_FAILED /* -104 */:
                sb.append("JSON failed");
                break;
            case VK_REQUEST_NOT_PREPARED /* -103 */:
                sb.append("Request wasn't prepared");
                break;
            case VK_CANCELED /* -102 */:
                sb.append("Canceled");
                break;
            case VK_API_ERROR /* -101 */:
                sb.append("API error");
                VKError vKError = this.apiError;
                if (vKError != null) {
                    sb.append(vKError.toString());
                    break;
                }
                break;
            default:
                sb.append(String.format("code: %d; ", Integer.valueOf(i)));
                break;
        }
        String str = this.errorReason;
        if (str != null) {
            sb.append(String.format("; %s", str));
        }
        String str2 = this.errorMessage;
        if (str2 != null) {
            sb.append(String.format("; %s", str2));
        }
        sb.append(")");
        return sb.toString();
    }

    public VKError(JSONObject jSONObject) throws JSONException {
        VKError vKError = new VKError(jSONObject.getInt("error_code"));
        vKError.errorMessage = jSONObject.getString("error_msg");
        vKError.requestParams = (ArrayList) VKJsonHelper.toList(jSONObject.getJSONArray(VKApiConst.REQUEST_PARAMS));
        if (vKError.errorCode == 14) {
            vKError.captchaImg = jSONObject.getString(VKApiConst.CAPTCHA_IMG);
            vKError.captchaSid = jSONObject.getString(VKApiConst.CAPTCHA_SID);
        }
        if (vKError.errorCode == 17) {
            vKError.redirectUri = jSONObject.getString("redirect_uri");
        }
        this.errorCode = VK_API_ERROR;
        this.apiError = vKError;
    }

    public VKError(Map<String, String> map) {
        this.errorCode = VK_API_ERROR;
        this.errorReason = map.get("error_reason");
        this.errorMessage = Uri.decode(map.get(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION));
        if (map.containsKey("fail")) {
            this.errorReason = "Action failed";
        }
        if (map.containsKey("cancel")) {
            this.errorCode = VK_CANCELED;
            this.errorReason = "User canceled request";
        }
    }
}

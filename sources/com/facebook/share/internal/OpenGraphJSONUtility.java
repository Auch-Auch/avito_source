package com.facebook.share.internal;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public final class OpenGraphJSONUtility {

    public interface PhotoJSONProcessor {
        JSONObject toJSONObject(SharePhoto sharePhoto);
    }

    public static JSONObject toJSONObject(ShareOpenGraphAction shareOpenGraphAction, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphAction.keySet()) {
            jSONObject.put(str, toJSONValue(shareOpenGraphAction.get(str), photoJSONProcessor));
        }
        return jSONObject;
    }

    public static Object toJSONValue(@Nullable Object obj, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            return obj;
        }
        if (obj instanceof SharePhoto) {
            if (photoJSONProcessor != null) {
                return photoJSONProcessor.toJSONObject((SharePhoto) obj);
            }
            return null;
        } else if (obj instanceof ShareOpenGraphObject) {
            ShareOpenGraphObject shareOpenGraphObject = (ShareOpenGraphObject) obj;
            JSONObject jSONObject = new JSONObject();
            for (String str : shareOpenGraphObject.keySet()) {
                jSONObject.put(str, toJSONValue(shareOpenGraphObject.get(str), photoJSONProcessor));
            }
            return jSONObject;
        } else if (obj instanceof List) {
            JSONArray jSONArray = new JSONArray();
            for (Object obj2 : (List) obj) {
                jSONArray.put(toJSONValue(obj2, photoJSONProcessor));
            }
            return jSONArray;
        } else {
            StringBuilder L = a.L("Invalid object found for JSON serialization: ");
            L.append(obj.toString());
            throw new IllegalArgumentException(L.toString());
        }
    }
}

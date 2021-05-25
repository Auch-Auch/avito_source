package com.facebook.share.internal;

import a2.b.a.a.a;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
public class LegacyNativeDialogParameters {
    public static Bundle a(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, ShareConstants.LEGACY_LINK, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_PLACE_TAG, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.LEGACY_DATA_FAILURES_FATAL, z);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putStringArrayList(ShareConstants.LEGACY_FRIEND_TAGS, new ArrayList<>(peopleIds));
        }
        return bundle;
    }

    public static Bundle create(UUID uuid, ShareContent shareContent, boolean z) {
        Validate.notNull(shareContent, "shareContent");
        Validate.notNull(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
            Bundle a = a(shareLinkContent, z);
            Utility.putNonEmptyString(a, ShareConstants.LEGACY_TITLE, shareLinkContent.getContentTitle());
            Utility.putNonEmptyString(a, ShareConstants.LEGACY_DESCRIPTION, shareLinkContent.getContentDescription());
            Utility.putUri(a, ShareConstants.LEGACY_IMAGE, shareLinkContent.getImageUrl());
            return a;
        } else if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            List<String> photoUrls = ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid);
            Bundle a3 = a(sharePhotoContent, z);
            a3.putStringArrayList(ShareConstants.LEGACY_PHOTOS, new ArrayList<>(photoUrls));
            return a3;
        } else if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            return null;
        } else if (!(shareContent instanceof ShareOpenGraphContent)) {
            return null;
        } else {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                JSONObject jSONObjectForCall = ShareInternalUtility.toJSONObjectForCall(uuid, shareOpenGraphContent);
                Bundle a4 = a(shareOpenGraphContent, z);
                Utility.putNonEmptyString(a4, ShareConstants.LEGACY_PREVIEW_PROPERTY_NAME, shareOpenGraphContent.getPreviewPropertyName());
                Utility.putNonEmptyString(a4, ShareConstants.LEGACY_ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
                Utility.putNonEmptyString(a4, ShareConstants.LEGACY_ACTION, jSONObjectForCall.toString());
                return a4;
            } catch (JSONException e) {
                StringBuilder L = a.L("Unable to create a JSON Object from the provided ShareOpenGraphContent: ");
                L.append(e.getMessage());
                throw new FacebookException(L.toString());
            }
        }
    }
}

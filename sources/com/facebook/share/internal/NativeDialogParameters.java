package com.facebook.share.internal;

import a2.b.a.a.a;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
public class NativeDialogParameters {
    public static Bundle a(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, ShareConstants.CONTENT_URL, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.PLACE_ID, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.PAGE_ID, shareContent.getPageId());
        Utility.putNonEmptyString(bundle, ShareConstants.REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.DATA_FAILURES_FATAL, z);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putStringArrayList(ShareConstants.PEOPLE_IDS, new ArrayList<>(peopleIds));
        }
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        if (shareHashtag != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.HASHTAG, shareHashtag.getHashtag());
        }
        return bundle;
    }

    public static Bundle create(UUID uuid, ShareContent shareContent, boolean z) {
        Bundle a;
        Bundle a3;
        Validate.notNull(shareContent, "shareContent");
        Validate.notNull(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
            Bundle a4 = a(shareLinkContent, z);
            Utility.putNonEmptyString(a4, ShareConstants.TITLE, shareLinkContent.getContentTitle());
            Utility.putNonEmptyString(a4, ShareConstants.DESCRIPTION, shareLinkContent.getContentDescription());
            Utility.putUri(a4, ShareConstants.IMAGE_URL, shareLinkContent.getImageUrl());
            Utility.putNonEmptyString(a4, ShareConstants.QUOTE, shareLinkContent.getQuote());
            Utility.putUri(a4, ShareConstants.MESSENGER_URL, shareLinkContent.getContentUrl());
            Utility.putUri(a4, ShareConstants.TARGET_DISPLAY, shareLinkContent.getContentUrl());
            return a4;
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            List<String> photoUrls = ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid);
            a3 = a(sharePhotoContent, z);
            a3.putStringArrayList(ShareConstants.PHOTOS, new ArrayList<>(photoUrls));
        } else {
            if (shareContent instanceof ShareVideoContent) {
                ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
                String videoUrl = ShareInternalUtility.getVideoUrl(shareVideoContent, uuid);
                a = a(shareVideoContent, z);
                Utility.putNonEmptyString(a, ShareConstants.TITLE, shareVideoContent.getContentTitle());
                Utility.putNonEmptyString(a, ShareConstants.DESCRIPTION, shareVideoContent.getContentDescription());
                Utility.putNonEmptyString(a, ShareConstants.VIDEO_URL, videoUrl);
            } else if (shareContent instanceof ShareOpenGraphContent) {
                ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
                try {
                    JSONObject removeNamespacesFromOGJsonObject = ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForCall(uuid, shareOpenGraphContent), false);
                    a = a(shareOpenGraphContent, z);
                    Utility.putNonEmptyString(a, ShareConstants.PREVIEW_PROPERTY_NAME, (String) ShareInternalUtility.getFieldNameAndNamespaceFromFullName(shareOpenGraphContent.getPreviewPropertyName()).second);
                    Utility.putNonEmptyString(a, ShareConstants.ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
                    Utility.putNonEmptyString(a, ShareConstants.ACTION, removeNamespacesFromOGJsonObject.toString());
                } catch (JSONException e) {
                    StringBuilder L = a.L("Unable to create a JSON Object from the provided ShareOpenGraphContent: ");
                    L.append(e.getMessage());
                    throw new FacebookException(L.toString());
                }
            } else if (shareContent instanceof ShareMediaContent) {
                ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
                List<Bundle> mediaInfos = ShareInternalUtility.getMediaInfos(shareMediaContent, uuid);
                a3 = a(shareMediaContent, z);
                a3.putParcelableArrayList(ShareConstants.MEDIA, new ArrayList<>(mediaInfos));
            } else if (shareContent instanceof ShareCameraEffectContent) {
                ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
                Bundle textureUrlBundle = ShareInternalUtility.getTextureUrlBundle(shareCameraEffectContent, uuid);
                a = a(shareCameraEffectContent, z);
                Utility.putNonEmptyString(a, ShareConstants.EFFECT_ID, shareCameraEffectContent.getEffectId());
                if (textureUrlBundle != null) {
                    a.putBundle(ShareConstants.EFFECT_TEXTURES, textureUrlBundle);
                }
                try {
                    JSONObject convertToJSON = CameraEffectJSONUtility.convertToJSON(shareCameraEffectContent.getArguments());
                    if (convertToJSON != null) {
                        Utility.putNonEmptyString(a, ShareConstants.EFFECT_ARGS, convertToJSON.toString());
                    }
                } catch (JSONException e2) {
                    StringBuilder L2 = a.L("Unable to create a JSON Object from the provided CameraEffectArguments: ");
                    L2.append(e2.getMessage());
                    throw new FacebookException(L2.toString());
                }
            } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
                ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent = (ShareMessengerGenericTemplateContent) shareContent;
                Bundle a5 = a(shareMessengerGenericTemplateContent, z);
                try {
                    MessengerShareContentUtility.addGenericTemplateContent(a5, shareMessengerGenericTemplateContent);
                    return a5;
                } catch (JSONException e3) {
                    StringBuilder L3 = a.L("Unable to create a JSON Object from the provided ShareMessengerGenericTemplateContent: ");
                    L3.append(e3.getMessage());
                    throw new FacebookException(L3.toString());
                }
            } else if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
                ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent = (ShareMessengerOpenGraphMusicTemplateContent) shareContent;
                Bundle a6 = a(shareMessengerOpenGraphMusicTemplateContent, z);
                try {
                    MessengerShareContentUtility.addOpenGraphMusicTemplateContent(a6, shareMessengerOpenGraphMusicTemplateContent);
                    return a6;
                } catch (JSONException e4) {
                    StringBuilder L4 = a.L("Unable to create a JSON Object from the provided ShareMessengerOpenGraphMusicTemplateContent: ");
                    L4.append(e4.getMessage());
                    throw new FacebookException(L4.toString());
                }
            } else if (shareContent instanceof ShareMessengerMediaTemplateContent) {
                ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent = (ShareMessengerMediaTemplateContent) shareContent;
                Bundle a8 = a(shareMessengerMediaTemplateContent, z);
                try {
                    MessengerShareContentUtility.addMediaTemplateContent(a8, shareMessengerMediaTemplateContent);
                    return a8;
                } catch (JSONException e5) {
                    StringBuilder L5 = a.L("Unable to create a JSON Object from the provided ShareMessengerMediaTemplateContent: ");
                    L5.append(e5.getMessage());
                    throw new FacebookException(L5.toString());
                }
            } else if (!(shareContent instanceof ShareStoryContent)) {
                return null;
            } else {
                ShareStoryContent shareStoryContent = (ShareStoryContent) shareContent;
                Bundle backgroundAssetMediaInfo = ShareInternalUtility.getBackgroundAssetMediaInfo(shareStoryContent, uuid);
                Bundle stickerUrl = ShareInternalUtility.getStickerUrl(shareStoryContent, uuid);
                a = a(shareStoryContent, z);
                if (backgroundAssetMediaInfo != null) {
                    a.putParcelable(ShareConstants.STORY_BG_ASSET, backgroundAssetMediaInfo);
                }
                if (stickerUrl != null) {
                    a.putParcelable(ShareConstants.STORY_INTERACTIVE_ASSET_URI, stickerUrl);
                }
                List<String> backgroundColorList = shareStoryContent.getBackgroundColorList();
                if (!Utility.isNullOrEmpty(backgroundColorList)) {
                    a.putStringArrayList(ShareConstants.STORY_INTERACTIVE_COLOR_LIST, new ArrayList<>(backgroundColorList));
                }
                Utility.putNonEmptyString(a, ShareConstants.STORY_DEEP_LINK_URL, shareStoryContent.getAttributionLink());
            }
            return a;
        }
        return a3;
    }
}

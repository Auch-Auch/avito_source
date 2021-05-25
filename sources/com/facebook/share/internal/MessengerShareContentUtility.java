package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public class MessengerShareContentUtility {
    public static final String ATTACHMENT = "attachment";
    public static final String ATTACHMENT_ID = "attachment_id";
    public static final String ATTACHMENT_PAYLOAD = "payload";
    public static final String ATTACHMENT_TEMPLATE_TYPE = "template";
    public static final String ATTACHMENT_TYPE = "type";
    public static final String BUTTONS = "buttons";
    public static final String BUTTON_TYPE = "type";
    public static final String BUTTON_URL_TYPE = "web_url";
    public static final String DEFAULT_ACTION = "default_action";
    public static final String ELEMENTS = "elements";
    public static final Pattern FACEBOOK_DOMAIN = Pattern.compile("^(.+)\\.(facebook\\.com)$");
    public static final String FALLBACK_URL = "fallback_url";
    public static final String IMAGE_ASPECT_RATIO = "image_aspect_ratio";
    public static final String IMAGE_RATIO_HORIZONTAL = "horizontal";
    public static final String IMAGE_RATIO_SQUARE = "square";
    public static final String IMAGE_URL = "image_url";
    public static final String MEDIA_IMAGE = "image";
    public static final String MEDIA_TYPE = "media_type";
    public static final String MEDIA_VIDEO = "video";
    public static final String MESSENGER_EXTENSIONS = "messenger_extensions";
    public static final String PREVIEW_DEFAULT = "DEFAULT";
    public static final String PREVIEW_OPEN_GRAPH = "OPEN_GRAPH";
    public static final String SHARABLE = "sharable";
    public static final String SHARE_BUTTON_HIDE = "hide";
    public static final String SUBTITLE = "subtitle";
    public static final String TEMPLATE_GENERIC_TYPE = "generic";
    public static final String TEMPLATE_MEDIA_TYPE = "media";
    public static final String TEMPLATE_OPEN_GRAPH_TYPE = "open_graph";
    public static final String TEMPLATE_TYPE = "template_type";
    public static final String TITLE = "title";
    public static final String URL = "url";
    public static final String WEBVIEW_RATIO = "webview_height_ratio";
    public static final String WEBVIEW_RATIO_COMPACT = "compact";
    public static final String WEBVIEW_RATIO_FULL = "full";
    public static final String WEBVIEW_RATIO_TALL = "tall";
    public static final String WEBVIEW_SHARE_BUTTON = "webview_share_button";

    public static void a(Bundle bundle, ShareMessengerActionButton shareMessengerActionButton, boolean z) throws JSONException {
        String str;
        if (shareMessengerActionButton != null && (shareMessengerActionButton instanceof ShareMessengerURLActionButton)) {
            ShareMessengerURLActionButton shareMessengerURLActionButton = (ShareMessengerURLActionButton) shareMessengerActionButton;
            if (z) {
                str = Utility.getUriString(shareMessengerURLActionButton.getUrl());
            } else {
                str = shareMessengerURLActionButton.getTitle() + " - " + Utility.getUriString(shareMessengerURLActionButton.getUrl());
            }
            Utility.putNonEmptyString(bundle, ShareConstants.TARGET_DISPLAY, str);
            Utility.putUri(bundle, ShareConstants.ITEM_URL, shareMessengerURLActionButton.getUrl());
        }
    }

    public static void addGenericTemplateContent(Bundle bundle, ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) throws JSONException {
        ShareMessengerGenericTemplateElement genericTemplateElement = shareMessengerGenericTemplateContent.getGenericTemplateElement();
        if (genericTemplateElement.getButton() != null) {
            a(bundle, genericTemplateElement.getButton(), false);
        } else if (genericTemplateElement.getDefaultAction() != null) {
            a(bundle, genericTemplateElement.getDefaultAction(), true);
        }
        Utility.putUri(bundle, ShareConstants.IMAGE_URL, genericTemplateElement.getImageUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, PREVIEW_DEFAULT);
        Utility.putNonEmptyString(bundle, ShareConstants.TITLE, genericTemplateElement.getTitle());
        Utility.putNonEmptyString(bundle, ShareConstants.SUBTITLE, genericTemplateElement.getSubtitle());
        JSONArray jSONArray = new JSONArray();
        ShareMessengerGenericTemplateElement genericTemplateElement2 = shareMessengerGenericTemplateContent.getGenericTemplateElement();
        JSONObject put = new JSONObject().put("title", genericTemplateElement2.getTitle()).put(SUBTITLE, genericTemplateElement2.getSubtitle()).put("image_url", Utility.getUriString(genericTemplateElement2.getImageUrl()));
        if (genericTemplateElement2.getButton() != null) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(b(genericTemplateElement2.getButton()));
            put.put(BUTTONS, jSONArray2);
        }
        if (genericTemplateElement2.getDefaultAction() != null) {
            put.put(DEFAULT_ACTION, c(genericTemplateElement2.getDefaultAction(), true));
        }
        JSONArray put2 = jSONArray.put(put);
        JSONObject put3 = new JSONObject().put(TEMPLATE_TYPE, TEMPLATE_GENERIC_TYPE).put(SHARABLE, shareMessengerGenericTemplateContent.getIsSharable());
        ShareMessengerGenericTemplateContent.ImageAspectRatio imageAspectRatio = shareMessengerGenericTemplateContent.getImageAspectRatio();
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", put3.put(IMAGE_ASPECT_RATIO, (imageAspectRatio != null && imageAspectRatio.ordinal() == 1) ? IMAGE_RATIO_SQUARE : IMAGE_RATIO_HORIZONTAL).put(ELEMENTS, put2))));
    }

    public static void addMediaTemplateContent(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        String str;
        a(bundle, shareMessengerMediaTemplateContent.getButton(), false);
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, PREVIEW_DEFAULT);
        Utility.putNonEmptyString(bundle, ShareConstants.ATTACHMENT_ID, shareMessengerMediaTemplateContent.getAttachmentId());
        if (shareMessengerMediaTemplateContent.getMediaUrl() != null) {
            String host = shareMessengerMediaTemplateContent.getMediaUrl().getHost();
            Utility.putUri(bundle, (Utility.isNullOrEmpty(host) || !FACEBOOK_DOMAIN.matcher(host).matches()) ? ShareConstants.IMAGE_URL : ShareConstants.MEDIA_URI, shareMessengerMediaTemplateContent.getMediaUrl());
        }
        ShareMessengerMediaTemplateContent.MediaType mediaType = shareMessengerMediaTemplateContent.getMediaType();
        String str2 = "video";
        if (mediaType != null && mediaType.ordinal() == 1) {
            str = str2;
        } else {
            str = "image";
        }
        Utility.putNonEmptyString(bundle, "type", str);
        JSONArray jSONArray = new JSONArray();
        JSONObject put = new JSONObject().put(ATTACHMENT_ID, shareMessengerMediaTemplateContent.getAttachmentId()).put("url", Utility.getUriString(shareMessengerMediaTemplateContent.getMediaUrl()));
        ShareMessengerMediaTemplateContent.MediaType mediaType2 = shareMessengerMediaTemplateContent.getMediaType();
        if (mediaType2 == null || mediaType2.ordinal() != 1) {
            str2 = "image";
        }
        JSONObject put2 = put.put(MEDIA_TYPE, str2);
        if (shareMessengerMediaTemplateContent.getButton() != null) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(b(shareMessengerMediaTemplateContent.getButton()));
            put2.put(BUTTONS, jSONArray2);
        }
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", new JSONObject().put(TEMPLATE_TYPE, "media").put(ELEMENTS, jSONArray.put(put2)))));
    }

    public static void addOpenGraphMusicTemplateContent(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        a(bundle, shareMessengerOpenGraphMusicTemplateContent.getButton(), false);
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, PREVIEW_OPEN_GRAPH);
        Utility.putUri(bundle, ShareConstants.OPEN_GRAPH_URL, shareMessengerOpenGraphMusicTemplateContent.getUrl());
        JSONArray jSONArray = new JSONArray();
        JSONObject put = new JSONObject().put("url", Utility.getUriString(shareMessengerOpenGraphMusicTemplateContent.getUrl()));
        if (shareMessengerOpenGraphMusicTemplateContent.getButton() != null) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(b(shareMessengerOpenGraphMusicTemplateContent.getButton()));
            put.put(BUTTONS, jSONArray2);
        }
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", new JSONObject().put(TEMPLATE_TYPE, "open_graph").put(ELEMENTS, jSONArray.put(put)))));
    }

    public static JSONObject b(ShareMessengerActionButton shareMessengerActionButton) throws JSONException {
        return c(shareMessengerActionButton, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject c(com.facebook.share.model.ShareMessengerActionButton r4, boolean r5) throws org.json.JSONException {
        /*
            boolean r0 = r4 instanceof com.facebook.share.model.ShareMessengerURLActionButton
            r1 = 0
            if (r0 == 0) goto L_0x0076
            com.facebook.share.model.ShareMessengerURLActionButton r4 = (com.facebook.share.model.ShareMessengerURLActionButton) r4
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r2 = "type"
            java.lang.String r3 = "web_url"
            org.json.JSONObject r0 = r0.put(r2, r3)
            if (r5 == 0) goto L_0x0018
            r5 = r1
            goto L_0x001c
        L_0x0018:
            java.lang.String r5 = r4.getTitle()
        L_0x001c:
            java.lang.String r2 = "title"
            org.json.JSONObject r5 = r0.put(r2, r5)
            android.net.Uri r0 = r4.getUrl()
            java.lang.String r0 = com.facebook.internal.Utility.getUriString(r0)
            java.lang.String r2 = "url"
            org.json.JSONObject r5 = r5.put(r2, r0)
            com.facebook.share.model.ShareMessengerURLActionButton$WebviewHeightRatio r0 = r4.getWebviewHeightRatio()
            if (r0 != 0) goto L_0x0037
            goto L_0x0041
        L_0x0037:
            int r0 = r0.ordinal()
            r2 = 1
            if (r0 == r2) goto L_0x0047
            r2 = 2
            if (r0 == r2) goto L_0x0044
        L_0x0041:
            java.lang.String r0 = "full"
            goto L_0x0049
        L_0x0044:
            java.lang.String r0 = "compact"
            goto L_0x0049
        L_0x0047:
            java.lang.String r0 = "tall"
        L_0x0049:
            java.lang.String r2 = "webview_height_ratio"
            org.json.JSONObject r5 = r5.put(r2, r0)
            boolean r0 = r4.getIsMessengerExtensionURL()
            java.lang.String r2 = "messenger_extensions"
            org.json.JSONObject r5 = r5.put(r2, r0)
            android.net.Uri r0 = r4.getFallbackUrl()
            java.lang.String r0 = com.facebook.internal.Utility.getUriString(r0)
            java.lang.String r2 = "fallback_url"
            org.json.JSONObject r5 = r5.put(r2, r0)
            boolean r4 = r4.getShouldHideWebviewShareButton()
            if (r4 == 0) goto L_0x006f
            java.lang.String r1 = "hide"
        L_0x006f:
            java.lang.String r4 = "webview_share_button"
            org.json.JSONObject r4 = r5.put(r4, r1)
            return r4
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.MessengerShareContentUtility.c(com.facebook.share.model.ShareMessengerActionButton, boolean):org.json.JSONObject");
    }
}

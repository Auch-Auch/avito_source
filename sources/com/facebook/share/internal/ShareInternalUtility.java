package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.share.Sharer;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView;
import com.vk.sdk.api.model.VKApiCommunityFull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public final class ShareInternalUtility {
    public static final String MY_PHOTOS = "me/photos";

    public static class a implements Utility.Mapper<NativeAppCallAttachmentStore.Attachment, Bundle> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.internal.Utility.Mapper
        public Bundle apply(NativeAppCallAttachmentStore.Attachment attachment) {
            NativeAppCallAttachmentStore.Attachment attachment2 = attachment;
            Bundle bundle = new Bundle();
            bundle.putString(ShareConstants.MEDIA_URI, attachment2.getAttachmentUrl());
            String uriExtension = ShareInternalUtility.getUriExtension(attachment2.getOriginalUri());
            if (uriExtension != null) {
                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
            }
            return bundle;
        }
    }

    public static class b implements Utility.Mapper<ShareMedia, Bundle> {
        public final /* synthetic */ UUID a;
        public final /* synthetic */ List b;

        public b(UUID uuid, List list) {
            this.a = uuid;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.internal.Utility.Mapper
        public Bundle apply(ShareMedia shareMedia) {
            ShareMedia shareMedia2 = shareMedia;
            NativeAppCallAttachmentStore.Attachment a3 = ShareInternalUtility.a(this.a, shareMedia2);
            this.b.add(a3);
            Bundle bundle = new Bundle();
            bundle.putString("type", shareMedia2.getMediaType().name());
            bundle.putString(ShareConstants.MEDIA_URI, a3.getAttachmentUrl());
            String uriExtension = ShareInternalUtility.getUriExtension(a3.getOriginalUri());
            if (uriExtension != null) {
                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
            }
            return bundle;
        }
    }

    public static class c extends ResultProcessor {
        public final /* synthetic */ FacebookCallback b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
            super(facebookCallback);
            this.b = facebookCallback2;
        }

        @Override // com.facebook.share.internal.ResultProcessor
        public void onCancel(AppCall appCall) {
            ShareInternalUtility.b(this.b);
        }

        @Override // com.facebook.share.internal.ResultProcessor
        public void onError(AppCall appCall, FacebookException facebookException) {
            FacebookCallback facebookCallback = this.b;
            ShareInternalUtility.e("error", facebookException.getMessage());
            if (facebookCallback != null) {
                facebookCallback.onError(facebookException);
            }
        }

        @Override // com.facebook.share.internal.ResultProcessor
        public void onSuccess(AppCall appCall, Bundle bundle) {
            if (bundle != null) {
                String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
                if (nativeDialogCompletionGesture == null || "post".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                    ShareInternalUtility.d(this.b, ShareInternalUtility.getShareDialogPostId(bundle));
                } else if ("cancel".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                    ShareInternalUtility.b(this.b);
                } else {
                    FacebookCallback facebookCallback = this.b;
                    FacebookException facebookException = new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR);
                    ShareInternalUtility.e("error", facebookException.getMessage());
                    if (facebookCallback != null) {
                        facebookCallback.onError(facebookException);
                    }
                }
            }
        }
    }

    public static class d implements CallbackManagerImpl.Callback {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.Callback
        public boolean onActivityResult(int i, Intent intent) {
            return ShareInternalUtility.handleActivityResult(this.a, i, intent, ShareInternalUtility.getShareResultProcessor(null));
        }
    }

    public static class e implements CallbackManagerImpl.Callback {
        public final /* synthetic */ int a;
        public final /* synthetic */ FacebookCallback b;

        public e(int i, FacebookCallback facebookCallback) {
            this.a = i;
            this.b = facebookCallback;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.Callback
        public boolean onActivityResult(int i, Intent intent) {
            return ShareInternalUtility.handleActivityResult(this.a, i, intent, ShareInternalUtility.getShareResultProcessor(this.b));
        }
    }

    public static class f implements Utility.Mapper<SharePhoto, NativeAppCallAttachmentStore.Attachment> {
        public final /* synthetic */ UUID a;

        public f(UUID uuid) {
            this.a = uuid;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.internal.Utility.Mapper
        public NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharePhoto) {
            return ShareInternalUtility.a(this.a, sharePhoto);
        }
    }

    public static class g implements Utility.Mapper<NativeAppCallAttachmentStore.Attachment, String> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.internal.Utility.Mapper
        public String apply(NativeAppCallAttachmentStore.Attachment attachment) {
            return attachment.getAttachmentUrl();
        }
    }

    public static class h implements Utility.Mapper<ShareMedia, Bundle> {
        public final /* synthetic */ UUID a;
        public final /* synthetic */ List b;

        public h(UUID uuid, List list) {
            this.a = uuid;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.internal.Utility.Mapper
        public Bundle apply(ShareMedia shareMedia) {
            ShareMedia shareMedia2 = shareMedia;
            NativeAppCallAttachmentStore.Attachment a3 = ShareInternalUtility.a(this.a, shareMedia2);
            this.b.add(a3);
            Bundle bundle = new Bundle();
            bundle.putString("type", shareMedia2.getMediaType().name());
            bundle.putString(ShareConstants.MEDIA_URI, a3.getAttachmentUrl());
            return bundle;
        }
    }

    public static class i implements OpenGraphJSONUtility.PhotoJSONProcessor {
        public final /* synthetic */ UUID a;
        public final /* synthetic */ ArrayList b;

        public i(UUID uuid, ArrayList arrayList) {
            this.a = uuid;
            this.b = arrayList;
        }

        @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
        public JSONObject toJSONObject(SharePhoto sharePhoto) {
            NativeAppCallAttachmentStore.Attachment a3 = ShareInternalUtility.a(this.a, sharePhoto);
            if (a3 == null) {
                return null;
            }
            this.b.add(a3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", a3.getAttachmentUrl());
                if (sharePhoto.getUserGenerated()) {
                    jSONObject.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
                }
                return jSONObject;
            } catch (JSONException e) {
                throw new FacebookException("Unable to attach images", e);
            }
        }
    }

    public static class j implements OpenGraphJSONUtility.PhotoJSONProcessor {
        @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
        public JSONObject toJSONObject(SharePhoto sharePhoto) {
            Uri imageUrl = sharePhoto.getImageUrl();
            if (Utility.isWebUri(imageUrl)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", imageUrl.toString());
                    return jSONObject;
                } catch (JSONException e) {
                    throw new FacebookException("Unable to attach images", e);
                }
            } else {
                throw new FacebookException("Only web images may be used in OG objects shared via the web dialog");
            }
        }
    }

    public static class k implements Utility.Mapper<SharePhoto, NativeAppCallAttachmentStore.Attachment> {
        public final /* synthetic */ UUID a;

        public k(UUID uuid) {
            this.a = uuid;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.internal.Utility.Mapper
        public NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharePhoto) {
            return ShareInternalUtility.a(this.a, sharePhoto);
        }
    }

    public static NativeAppCallAttachmentStore.Attachment a(UUID uuid, ShareMedia shareMedia) {
        Uri uri;
        Bitmap bitmap;
        if (shareMedia instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto) shareMedia;
            bitmap = sharePhoto.getBitmap();
            uri = sharePhoto.getImageUrl();
        } else if (shareMedia instanceof ShareVideo) {
            uri = ((ShareVideo) shareMedia).getLocalUrl();
            bitmap = null;
        } else {
            uri = null;
            bitmap = null;
        }
        if (bitmap != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        }
        if (uri != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        }
        return null;
    }

    public static void b(FacebookCallback<Sharer.Result> facebookCallback) {
        e(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, null);
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
    }

    public static void c(FacebookCallback<Sharer.Result> facebookCallback, FacebookException facebookException) {
        e("error", facebookException.getMessage());
        if (facebookCallback != null) {
            facebookCallback.onError(facebookException);
        }
    }

    public static void d(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        e(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, null);
        if (facebookCallback != null) {
            facebookCallback.onSuccess(new Sharer.Result(str));
        }
    }

    public static void e(String str, String str2) {
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
        Bundle y1 = a2.b.a.a.a.y1(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
        if (str2 != null) {
            y1.putString("error_message", str2);
        }
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_RESULT, y1);
    }

    @Nullable
    public static Bundle getBackgroundAssetMediaInfo(ShareStoryContent shareStoryContent, UUID uuid) {
        if (shareStoryContent == null || shareStoryContent.getBackgroundAsset() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(shareStoryContent.getBackgroundAsset());
        ArrayList arrayList2 = new ArrayList();
        List map = Utility.map(arrayList, new b(uuid, arrayList2));
        NativeAppCallAttachmentStore.addAttachments(arrayList2);
        return (Bundle) map.get(0);
    }

    public static Pair<String, String> getFieldNameAndNamespaceFromFullName(String str) {
        String str2;
        int i2;
        int indexOf = str.indexOf(58);
        if (indexOf == -1 || str.length() <= (i2 = indexOf + 1)) {
            str2 = null;
        } else {
            str2 = str.substring(0, indexOf);
            str = str.substring(i2);
        }
        return new Pair<>(str2, str);
    }

    public static List<Bundle> getMediaInfos(ShareMediaContent shareMediaContent, UUID uuid) {
        List<ShareMedia> media;
        if (shareMediaContent == null || (media = shareMediaContent.getMedia()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<Bundle> map = Utility.map(media, new h(uuid, arrayList));
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return map;
    }

    @Nullable
    public static LikeView.ObjectType getMostSpecificObjectType(LikeView.ObjectType objectType, LikeView.ObjectType objectType2) {
        if (objectType == objectType2) {
            return objectType;
        }
        LikeView.ObjectType objectType3 = LikeView.ObjectType.UNKNOWN;
        if (objectType == objectType3) {
            return objectType2;
        }
        if (objectType2 == objectType3) {
            return objectType;
        }
        return null;
    }

    public static String getNativeDialogCompletionGesture(Bundle bundle) {
        if (bundle.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
            return bundle.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
        }
        return bundle.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    public static List<String> getPhotoUrls(SharePhotoContent sharePhotoContent, UUID uuid) {
        List<SharePhoto> photos;
        if (sharePhotoContent == null || (photos = sharePhotoContent.getPhotos()) == null) {
            return null;
        }
        List map = Utility.map(photos, new f(uuid));
        List<String> map2 = Utility.map(map, new g());
        NativeAppCallAttachmentStore.addAttachments(map);
        return map2;
    }

    public static String getShareDialogPostId(Bundle bundle) {
        if (bundle.containsKey(ShareConstants.RESULT_POST_ID)) {
            return bundle.getString(ShareConstants.RESULT_POST_ID);
        }
        if (bundle.containsKey(ShareConstants.EXTRA_RESULT_POST_ID)) {
            return bundle.getString(ShareConstants.EXTRA_RESULT_POST_ID);
        }
        return bundle.getString("post_id");
    }

    public static ResultProcessor getShareResultProcessor(FacebookCallback<Sharer.Result> facebookCallback) {
        return new c(facebookCallback, facebookCallback);
    }

    @Nullable
    public static Bundle getStickerUrl(ShareStoryContent shareStoryContent, UUID uuid) {
        if (shareStoryContent == null || shareStoryContent.getStickerAsset() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(shareStoryContent.getStickerAsset());
        List map = Utility.map(arrayList, new k(uuid));
        List map2 = Utility.map(map, new a());
        NativeAppCallAttachmentStore.addAttachments(map);
        return (Bundle) map2.get(0);
    }

    public static Bundle getTextureUrlBundle(ShareCameraEffectContent shareCameraEffectContent, UUID uuid) {
        CameraEffectTextures textures;
        NativeAppCallAttachmentStore.Attachment attachment;
        if (shareCameraEffectContent == null || (textures = shareCameraEffectContent.getTextures()) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (String str : textures.keySet()) {
            Uri textureUri = textures.getTextureUri(str);
            Bitmap textureBitmap = textures.getTextureBitmap(str);
            if (textureBitmap != null) {
                attachment = NativeAppCallAttachmentStore.createAttachment(uuid, textureBitmap);
            } else {
                attachment = textureUri != null ? NativeAppCallAttachmentStore.createAttachment(uuid, textureUri) : null;
            }
            arrayList.add(attachment);
            bundle.putString(str, attachment.getAttachmentUrl());
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return bundle;
    }

    @Nullable
    public static String getUriExtension(Uri uri) {
        String uri2;
        int lastIndexOf;
        if (uri == null || (lastIndexOf = (uri2 = uri.toString()).lastIndexOf(46)) == -1) {
            return null;
        }
        return uri2.substring(lastIndexOf);
    }

    public static String getVideoUrl(ShareVideoContent shareVideoContent, UUID uuid) {
        if (shareVideoContent == null || shareVideoContent.getVideo() == null) {
            return null;
        }
        NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, shareVideoContent.getVideo().getLocalUrl());
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(createAttachment);
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return createAttachment.getAttachmentUrl();
    }

    public static boolean handleActivityResult(int i2, int i3, Intent intent, ResultProcessor resultProcessor) {
        AppCall appCall;
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            appCall = null;
        } else {
            appCall = AppCall.finishPendingCall(callIdFromIntent, i2);
        }
        if (appCall == null) {
            return false;
        }
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCall.getCallId());
        if (resultProcessor == null) {
            return true;
        }
        FacebookException exceptionFromErrorData = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent));
        if (exceptionFromErrorData == null) {
            resultProcessor.onSuccess(appCall, NativeProtocol.getSuccessResultsFromIntent(intent));
        } else if (exceptionFromErrorData instanceof FacebookOperationCanceledException) {
            resultProcessor.onCancel(appCall);
        } else {
            resultProcessor.onError(appCall, exceptionFromErrorData);
        }
        return true;
    }

    public static void invokeCallbackWithError(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        e("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookException(str));
        }
    }

    public static void invokeCallbackWithException(FacebookCallback<Sharer.Result> facebookCallback, Exception exc) {
        if (exc instanceof FacebookException) {
            c(facebookCallback, (FacebookException) exc);
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("Error preparing share content: ");
        L.append(exc.getLocalizedMessage());
        invokeCallbackWithError(facebookCallback, L.toString());
    }

    public static void invokeCallbackWithResults(FacebookCallback<Sharer.Result> facebookCallback, String str, GraphResponse graphResponse) {
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (Utility.isNullOrEmpty(errorMessage)) {
                errorMessage = "Unexpected error sharing.";
            }
            e("error", errorMessage);
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookGraphResponseException(graphResponse, errorMessage));
                return;
            }
            return;
        }
        d(facebookCallback, str);
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Bitmap bitmap, GraphRequest.Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", bitmap);
        return new GraphRequest(accessToken, "me/staging_resources", bundle, HttpMethod.POST, callback);
    }

    public static void registerSharerCallback(int i2, CallbackManager callbackManager, FacebookCallback<Sharer.Result> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(i2, new e(i2, facebookCallback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public static void registerStaticShareCallback(int i2) {
        CallbackManagerImpl.registerStaticCallback(i2, new d(i2));
    }

    public static JSONArray removeNamespacesFromOGJsonArray(JSONArray jSONArray, boolean z) throws JSONException {
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Object obj = jSONArray.get(i2);
            if (obj instanceof JSONArray) {
                obj = removeNamespacesFromOGJsonArray((JSONArray) obj, z);
            } else if (obj instanceof JSONObject) {
                obj = removeNamespacesFromOGJsonObject((JSONObject) obj, z);
            }
            jSONArray2.put(obj);
        }
        return jSONArray2;
    }

    public static JSONObject removeNamespacesFromOGJsonObject(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray names = jSONObject.names();
            for (int i2 = 0; i2 < names.length(); i2++) {
                String string = names.getString(i2);
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    obj = removeNamespacesFromOGJsonObject((JSONObject) obj, true);
                } else if (obj instanceof JSONArray) {
                    obj = removeNamespacesFromOGJsonArray((JSONArray) obj, true);
                }
                Pair<String, String> fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(string);
                String str = (String) fieldNameAndNamespaceFromFullName.first;
                String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                if (z) {
                    if (str == null || !str.equals("fbsdk")) {
                        if (str != null) {
                            if (!str.equals("og")) {
                                jSONObject3.put(str2, obj);
                            }
                        }
                        jSONObject2.put(str2, obj);
                    } else {
                        jSONObject2.put(string, obj);
                    }
                } else if (str == null || !str.equals("fb")) {
                    jSONObject2.put(str2, obj);
                } else {
                    jSONObject2.put(string, obj);
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("data", jSONObject3);
            }
            return jSONObject2;
        } catch (JSONException unused) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    public static JSONObject toJSONObjectForCall(UUID uuid, ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        Set set;
        ShareOpenGraphAction action = shareOpenGraphContent.getAction();
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = OpenGraphJSONUtility.toJSONObject(action, new i(uuid, arrayList));
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        if (shareOpenGraphContent.getPlaceId() != null && Utility.isNullOrEmpty(jSONObject.optString(VKApiCommunityFull.PLACE))) {
            jSONObject.put(VKApiCommunityFull.PLACE, shareOpenGraphContent.getPlaceId());
        }
        if (shareOpenGraphContent.getPeopleIds() != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("tags");
            if (optJSONArray == null) {
                set = new HashSet();
            } else {
                set = Utility.jsonArrayToSet(optJSONArray);
            }
            for (String str : shareOpenGraphContent.getPeopleIds()) {
                set.add(str);
            }
            jSONObject.put("tags", new JSONArray((Collection) set));
        }
        return jSONObject;
    }

    public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        return OpenGraphJSONUtility.toJSONObject(shareOpenGraphContent.getAction(), new j());
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, File file, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, "me/staging_resources", bundle, HttpMethod.POST, callback);
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri uri, GraphRequest.Callback callback) throws FileNotFoundException {
        if (Utility.isFileUri(uri)) {
            return newUploadStagingResourceWithImageRequest(accessToken, new File(uri.getPath()), callback);
        }
        if (Utility.isContentUri(uri)) {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(uri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, "me/staging_resources", bundle, HttpMethod.POST, callback);
        }
        throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
    }
}

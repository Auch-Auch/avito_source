package com.facebook.share;

import a2.g.v.b;
import a2.g.v.c;
import a2.g.v.d;
import a2.g.v.e;
import a2.g.v.f;
import a2.g.v.g;
import a2.g.v.h;
import a2.g.v.i;
import a2.g.v.j;
import a2.g.v.k;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiCommunityFull;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public final class ShareApi {
    public String a;
    public String b = "me";
    public final ShareContent c;

    public class a implements CollectionMapper.ValueMapper {
        public a() {
        }

        @Override // com.facebook.internal.CollectionMapper.ValueMapper
        public void mapValue(Object obj, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
            if (obj instanceof ArrayList) {
                ShareApi shareApi = ShareApi.this;
                Objects.requireNonNull(shareApi);
                JSONArray jSONArray = new JSONArray();
                shareApi.f(new h(shareApi, (ArrayList) obj, jSONArray), new i(shareApi, onMapValueCompleteListener, jSONArray));
            } else if (obj instanceof ShareOpenGraphObject) {
                ShareApi shareApi2 = ShareApi.this;
                ShareOpenGraphObject shareOpenGraphObject = (ShareOpenGraphObject) obj;
                Objects.requireNonNull(shareApi2);
                String string = shareOpenGraphObject.getString("type");
                if (string == null) {
                    string = shareOpenGraphObject.getString("og:type");
                }
                if (string == null) {
                    ((CollectionMapper.b) onMapValueCompleteListener).c.onError(new FacebookException("Open Graph objects must contain a type value."));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                shareApi2.f(new k(shareApi2, shareOpenGraphObject, jSONObject), new b(shareApi2, jSONObject, string, new a2.g.v.a(shareApi2, onMapValueCompleteListener), onMapValueCompleteListener));
            } else if (obj instanceof SharePhoto) {
                ShareApi shareApi3 = ShareApi.this;
                SharePhoto sharePhoto = (SharePhoto) obj;
                Objects.requireNonNull(shareApi3);
                Bitmap bitmap = sharePhoto.getBitmap();
                Uri imageUrl = sharePhoto.getImageUrl();
                if (bitmap == null && imageUrl == null) {
                    ((CollectionMapper.b) onMapValueCompleteListener).c.onError(new FacebookException("Photos must have an imageURL or bitmap."));
                    return;
                }
                c cVar = new c(shareApi3, onMapValueCompleteListener, sharePhoto);
                if (bitmap != null) {
                    ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), bitmap, cVar).executeAsync();
                    return;
                }
                try {
                    ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), imageUrl, cVar).executeAsync();
                } catch (FileNotFoundException e) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "Error staging photo.";
                    }
                    ((CollectionMapper.b) onMapValueCompleteListener).c.onError(new FacebookException(localizedMessage));
                }
            } else {
                CollectionMapper.b bVar = (CollectionMapper.b) onMapValueCompleteListener;
                bVar.a.set(bVar.b, obj, bVar.c);
                bVar.c.onComplete();
            }
        }
    }

    public ShareApi(ShareContent shareContent) {
        this.c = shareContent;
    }

    public static void a(Bundle bundle) {
        String string = bundle.getString("image");
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        e(bundle, i, optJSONObject);
                    } else {
                        bundle.putString(String.format(Locale.ROOT, "image[%d][url]", Integer.valueOf(i)), jSONArray.getString(i));
                    }
                }
                bundle.remove("image");
            } catch (JSONException unused) {
                try {
                    e(bundle, 0, new JSONObject(string));
                    bundle.remove("image");
                } catch (JSONException unused2) {
                }
            }
        }
    }

    public static void e(Bundle bundle, int i, JSONObject jSONObject) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            bundle.putString(String.format(Locale.ROOT, "image[%d][%s]", Integer.valueOf(i), next), jSONObject.get(next).toString());
        }
    }

    public static void share(ShareContent shareContent, FacebookCallback<Sharer.Result> facebookCallback) {
        new ShareApi(shareContent).share(facebookCallback);
    }

    public final void b(Bundle bundle, ShareContent shareContent) {
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putString("tags", TextUtils.join(", ", peopleIds));
        }
        if (!Utility.isNullOrEmpty(shareContent.getPlaceId())) {
            bundle.putString(VKApiCommunityFull.PLACE, shareContent.getPlaceId());
        }
        if (!Utility.isNullOrEmpty(shareContent.getPageId())) {
            bundle.putString("page", shareContent.getPageId());
        }
        if (!Utility.isNullOrEmpty(shareContent.getRef())) {
            bundle.putString("ref", shareContent.getRef());
        }
    }

    public final String c(String str) {
        try {
            return String.format(Locale.ROOT, "%s/%s", URLEncoder.encode(getGraphNode(), "UTF-8"), str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public boolean canShare() {
        if (getShareContent() == null) {
            return false;
        }
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (!AccessToken.isCurrentAccessTokenActive()) {
            return false;
        }
        Set<String> permissions2 = currentAccessToken.getPermissions();
        if (permissions2 == null) {
            return true;
        }
        permissions2.contains("publish_actions");
        return true;
    }

    public final Bundle d(SharePhoto sharePhoto, SharePhotoContent sharePhotoContent) throws JSONException {
        Bundle parameters = sharePhoto.getParameters();
        if (!parameters.containsKey(VKApiCommunityFull.PLACE) && !Utility.isNullOrEmpty(sharePhotoContent.getPlaceId())) {
            parameters.putString(VKApiCommunityFull.PLACE, sharePhotoContent.getPlaceId());
        }
        if (!parameters.containsKey("tags") && !Utility.isNullOrEmpty(sharePhotoContent.getPeopleIds())) {
            List<String> peopleIds = sharePhotoContent.getPeopleIds();
            if (!Utility.isNullOrEmpty(peopleIds)) {
                JSONArray jSONArray = new JSONArray();
                for (String str : peopleIds) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("tag_uid", str);
                    jSONArray.put(jSONObject);
                }
                parameters.putString("tags", jSONArray.toString());
            }
        }
        if (!parameters.containsKey("ref") && !Utility.isNullOrEmpty(sharePhotoContent.getRef())) {
            parameters.putString("ref", sharePhotoContent.getRef());
        }
        return parameters;
    }

    public final <T> void f(CollectionMapper.Collection<T> collection, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        CollectionMapper.iterate(collection, new a(), onMapperCompleteListener);
    }

    public String getGraphNode() {
        return this.b;
    }

    public String getMessage() {
        return this.a;
    }

    public ShareContent getShareContent() {
        return this.c;
    }

    public void setGraphNode(String str) {
        this.b = str;
    }

    public void setMessage(String str) {
        this.a = str;
    }

    public void share(FacebookCallback<Sharer.Result> facebookCallback) {
        ArrayList arrayList;
        if (!canShare()) {
            ShareInternalUtility.invokeCallbackWithError(facebookCallback, "Insufficient permissions for sharing content via Api.");
            return;
        }
        ShareContent shareContent = getShareContent();
        try {
            ShareContentValidation.validateForApiShare(shareContent);
            if (shareContent instanceof ShareLinkContent) {
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                g gVar = new g(this, facebookCallback);
                Bundle bundle = new Bundle();
                b(bundle, shareLinkContent);
                bundle.putString("message", getMessage());
                bundle.putString("link", Utility.getUriString(shareLinkContent.getContentUrl()));
                bundle.putString("picture", Utility.getUriString(shareLinkContent.getImageUrl()));
                bundle.putString("name", shareLinkContent.getContentTitle());
                bundle.putString("description", shareLinkContent.getContentDescription());
                bundle.putString("ref", shareLinkContent.getRef());
                new GraphRequest(AccessToken.getCurrentAccessToken(), c(VKApiConst.FEED), bundle, HttpMethod.POST, gVar).executeAsync();
            } else if (shareContent instanceof SharePhotoContent) {
                SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
                Mutable mutable = new Mutable(0);
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                ArrayList arrayList2 = new ArrayList();
                f fVar = new f(this, new ArrayList(), new ArrayList(), mutable, facebookCallback);
                try {
                    for (SharePhoto sharePhoto : sharePhotoContent.getPhotos()) {
                        try {
                            Bundle d = d(sharePhoto, sharePhotoContent);
                            Bitmap bitmap = sharePhoto.getBitmap();
                            Uri imageUrl = sharePhoto.getImageUrl();
                            String caption = sharePhoto.getCaption();
                            if (caption == null) {
                                caption = getMessage();
                            }
                            if (bitmap != null) {
                                arrayList = arrayList2;
                                arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, c("photos"), bitmap, caption, d, fVar));
                            } else {
                                arrayList = arrayList2;
                                if (imageUrl != null) {
                                    arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, c("photos"), imageUrl, caption, d, fVar));
                                }
                            }
                            arrayList2 = arrayList;
                        } catch (JSONException e) {
                            ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
                            return;
                        }
                    }
                    mutable.value = (T) Integer.valueOf(mutable.value.intValue() + arrayList2.size());
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((GraphRequest) it.next()).executeAsync();
                    }
                } catch (FileNotFoundException e2) {
                    ShareInternalUtility.invokeCallbackWithException(facebookCallback, e2);
                }
            } else if (shareContent instanceof ShareVideoContent) {
                try {
                    VideoUploader.uploadAsync((ShareVideoContent) shareContent, getGraphNode(), facebookCallback);
                } catch (FileNotFoundException e3) {
                    ShareInternalUtility.invokeCallbackWithException(facebookCallback, e3);
                }
            } else if (shareContent instanceof ShareOpenGraphContent) {
                ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
                d dVar = new d(this, facebookCallback);
                ShareOpenGraphAction action = shareOpenGraphContent.getAction();
                Bundle bundle2 = action.getBundle();
                b(bundle2, shareOpenGraphContent);
                if (!Utility.isNullOrEmpty(getMessage())) {
                    bundle2.putString("message", getMessage());
                }
                f(new j(this, bundle2), new e(this, bundle2, action, dVar, facebookCallback));
            }
        } catch (FacebookException e4) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback, e4);
        }
    }
}

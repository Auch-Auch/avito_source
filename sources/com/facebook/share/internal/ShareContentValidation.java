package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
public class ShareContentValidation {
    public static d a;
    public static d b;
    public static d c;
    public static d d;

    public static class b extends d {
        public b(a aVar) {
            super(null);
        }

        @Override // com.facebook.share.internal.ShareContentValidation.d
        public void a(ShareLinkContent shareLinkContent) {
            if (!Utility.isNullOrEmpty(shareLinkContent.getQuote())) {
                throw new FacebookException("Cannot share link content with quote using the share api");
            }
        }

        @Override // com.facebook.share.internal.ShareContentValidation.d
        public void b(ShareMediaContent shareMediaContent) {
            throw new FacebookException("Cannot share ShareMediaContent using the share api");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.d
        public void d(SharePhoto sharePhoto) {
            ShareContentValidation.e(sharePhoto, this);
        }

        @Override // com.facebook.share.internal.ShareContentValidation.d
        public void g(ShareVideoContent shareVideoContent) {
            if (!Utility.isNullOrEmpty(shareVideoContent.getPlaceId())) {
                throw new FacebookException("Cannot share video content with place IDs using the share api");
            } else if (!Utility.isNullOrEmpty(shareVideoContent.getPeopleIds())) {
                throw new FacebookException("Cannot share video content with people IDs using the share api");
            } else if (!Utility.isNullOrEmpty(shareVideoContent.getRef())) {
                throw new FacebookException("Cannot share video content with referrer URL using the share api");
            }
        }
    }

    public static class c extends d {
        public c(a aVar) {
            super(null);
        }

        @Override // com.facebook.share.internal.ShareContentValidation.d
        public void e(ShareStoryContent shareStoryContent) {
            ShareContentValidation.a(shareStoryContent, this);
        }
    }

    public static class d {
        public boolean a = false;

        public d(a aVar) {
        }

        public void a(ShareLinkContent shareLinkContent) {
            Uri imageUrl = shareLinkContent.getImageUrl();
            if (imageUrl != null && !Utility.isWebUri(imageUrl)) {
                throw new FacebookException("Image Url must be an http:// or https:// url");
            }
        }

        public void b(ShareMediaContent shareMediaContent) {
            List<ShareMedia> media = shareMediaContent.getMedia();
            if (media == null || media.isEmpty()) {
                throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
            } else if (media.size() <= 6) {
                for (ShareMedia shareMedia : media) {
                    ShareContentValidation.validateMedium(shareMedia, this);
                }
            } else {
                throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", 6));
            }
        }

        public void c(ShareOpenGraphValueContainer shareOpenGraphValueContainer, boolean z) {
            for (String str : shareOpenGraphValueContainer.keySet()) {
                if (z) {
                    String[] split = str.split(":");
                    if (split.length >= 2) {
                        for (String str2 : split) {
                            if (str2.isEmpty()) {
                                throw new FacebookException("Invalid key found in Open Graph dictionary: %s", str);
                            }
                        }
                    } else {
                        throw new FacebookException("Open Graph keys must be namespaced: %s", str);
                    }
                }
                Object obj = shareOpenGraphValueContainer.get(str);
                if (obj instanceof List) {
                    for (Object obj2 : (List) obj) {
                        if (obj2 != null) {
                            ShareContentValidation.c(obj2, this);
                        } else {
                            throw new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                        }
                    }
                    continue;
                } else {
                    ShareContentValidation.c(obj, this);
                }
            }
        }

        public void d(SharePhoto sharePhoto) {
            ShareContentValidation.e(sharePhoto, this);
            if (sharePhoto.getBitmap() != null || !Utility.isWebUri(sharePhoto.getImageUrl())) {
                Validate.hasContentProvider(FacebookSdk.getApplicationContext());
            }
        }

        public void e(ShareStoryContent shareStoryContent) {
            ShareContentValidation.a(shareStoryContent, this);
        }

        public void f(ShareVideo shareVideo) {
            if (shareVideo != null) {
                Uri localUrl = shareVideo.getLocalUrl();
                if (localUrl == null) {
                    throw new FacebookException("ShareVideo does not have a LocalUrl specified");
                } else if (!Utility.isContentUri(localUrl) && !Utility.isFileUri(localUrl)) {
                    throw new FacebookException("ShareVideo must reference a video that is on the device");
                }
            } else {
                throw new FacebookException("Cannot share a null ShareVideo");
            }
        }

        public void g(ShareVideoContent shareVideoContent) {
            f(shareVideoContent.getVideo());
            SharePhoto previewPhoto = shareVideoContent.getPreviewPhoto();
            if (previewPhoto != null) {
                d(previewPhoto);
            }
        }
    }

    public static class e extends d {
        public e(a aVar) {
            super(null);
        }

        @Override // com.facebook.share.internal.ShareContentValidation.d
        public void b(ShareMediaContent shareMediaContent) {
            throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.d
        public void d(SharePhoto sharePhoto) {
            ShareContentValidation.d(sharePhoto);
        }

        @Override // com.facebook.share.internal.ShareContentValidation.d
        public void g(ShareVideoContent shareVideoContent) {
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }
    }

    public static void a(ShareStoryContent shareStoryContent, d dVar) {
        if (shareStoryContent == null || (shareStoryContent.getBackgroundAsset() == null && shareStoryContent.getStickerAsset() == null)) {
            throw new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
        }
        if (shareStoryContent.getBackgroundAsset() != null) {
            validateMedium(shareStoryContent.getBackgroundAsset(), dVar);
        }
        if (shareStoryContent.getStickerAsset() != null) {
            dVar.d(shareStoryContent.getStickerAsset());
        }
    }

    public static void b(ShareContent shareContent, d dVar) throws FacebookException {
        if (shareContent == null) {
            throw new FacebookException("Must provide non-null content to share");
        } else if (shareContent instanceof ShareLinkContent) {
            dVar.a((ShareLinkContent) shareContent);
        } else if (shareContent instanceof SharePhotoContent) {
            Objects.requireNonNull(dVar);
            List<SharePhoto> photos = ((SharePhotoContent) shareContent).getPhotos();
            if (photos == null || photos.isEmpty()) {
                throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
            } else if (photos.size() <= 6) {
                for (SharePhoto sharePhoto : photos) {
                    dVar.d(sharePhoto);
                }
            } else {
                throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", 6));
            }
        } else if (shareContent instanceof ShareVideoContent) {
            dVar.g((ShareVideoContent) shareContent);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            dVar.a = true;
            ShareOpenGraphAction action = shareOpenGraphContent.getAction();
            if (action == null) {
                throw new FacebookException("Must specify a non-null ShareOpenGraphAction");
            } else if (!Utility.isNullOrEmpty(action.getActionType())) {
                dVar.c(action, false);
                String previewPropertyName = shareOpenGraphContent.getPreviewPropertyName();
                if (Utility.isNullOrEmpty(previewPropertyName)) {
                    throw new FacebookException("Must specify a previewPropertyName.");
                } else if (shareOpenGraphContent.getAction().get(previewPropertyName) == null) {
                    throw new FacebookException(a2.b.a.a.a.e3("Property \"", previewPropertyName, "\" was not found on the action. The name of the preview property must match the name of an action property."));
                }
            } else {
                throw new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
            }
        } else if (shareContent instanceof ShareMediaContent) {
            dVar.b((ShareMediaContent) shareContent);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            Objects.requireNonNull(dVar);
            if (Utility.isNullOrEmpty(((ShareCameraEffectContent) shareContent).getEffectId())) {
                throw new FacebookException("Must specify a non-empty effectId");
            }
        } else if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
            ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent = (ShareMessengerOpenGraphMusicTemplateContent) shareContent;
            Objects.requireNonNull(dVar);
            if (Utility.isNullOrEmpty(shareMessengerOpenGraphMusicTemplateContent.getPageId())) {
                throw new FacebookException("Must specify Page Id for ShareMessengerOpenGraphMusicTemplateContent");
            } else if (shareMessengerOpenGraphMusicTemplateContent.getUrl() != null) {
                f(shareMessengerOpenGraphMusicTemplateContent.getButton());
            } else {
                throw new FacebookException("Must specify url for ShareMessengerOpenGraphMusicTemplateContent");
            }
        } else if (shareContent instanceof ShareMessengerMediaTemplateContent) {
            ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent = (ShareMessengerMediaTemplateContent) shareContent;
            Objects.requireNonNull(dVar);
            if (Utility.isNullOrEmpty(shareMessengerMediaTemplateContent.getPageId())) {
                throw new FacebookException("Must specify Page Id for ShareMessengerMediaTemplateContent");
            } else if (shareMessengerMediaTemplateContent.getMediaUrl() != null || !Utility.isNullOrEmpty(shareMessengerMediaTemplateContent.getAttachmentId())) {
                f(shareMessengerMediaTemplateContent.getButton());
            } else {
                throw new FacebookException("Must specify either attachmentId or mediaURL for ShareMessengerMediaTemplateContent");
            }
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent = (ShareMessengerGenericTemplateContent) shareContent;
            Objects.requireNonNull(dVar);
            if (Utility.isNullOrEmpty(shareMessengerGenericTemplateContent.getPageId())) {
                throw new FacebookException("Must specify Page Id for ShareMessengerGenericTemplateContent");
            } else if (shareMessengerGenericTemplateContent.getGenericTemplateElement() == null) {
                throw new FacebookException("Must specify element for ShareMessengerGenericTemplateContent");
            } else if (!Utility.isNullOrEmpty(shareMessengerGenericTemplateContent.getGenericTemplateElement().getTitle())) {
                f(shareMessengerGenericTemplateContent.getGenericTemplateElement().getButton());
            } else {
                throw new FacebookException("Must specify title for ShareMessengerGenericTemplateElement");
            }
        } else if (shareContent instanceof ShareStoryContent) {
            dVar.e((ShareStoryContent) shareContent);
        }
    }

    public static void c(Object obj, d dVar) {
        if (obj instanceof ShareOpenGraphObject) {
            ShareOpenGraphObject shareOpenGraphObject = (ShareOpenGraphObject) obj;
            Objects.requireNonNull(dVar);
            if (shareOpenGraphObject != null) {
                dVar.c(shareOpenGraphObject, true);
                return;
            }
            throw new FacebookException("Cannot share a null ShareOpenGraphObject");
        } else if (obj instanceof SharePhoto) {
            dVar.d((SharePhoto) obj);
        }
    }

    public static void d(SharePhoto sharePhoto) {
        if (sharePhoto != null) {
            Bitmap bitmap = sharePhoto.getBitmap();
            Uri imageUrl = sharePhoto.getImageUrl();
            if (bitmap == null && imageUrl == null) {
                throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            return;
        }
        throw new FacebookException("Cannot share a null SharePhoto");
    }

    public static void e(SharePhoto sharePhoto, d dVar) {
        d(sharePhoto);
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && Utility.isWebUri(imageUrl) && !dVar.a) {
            throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        }
    }

    public static void f(ShareMessengerActionButton shareMessengerActionButton) {
        if (shareMessengerActionButton != null) {
            if (Utility.isNullOrEmpty(shareMessengerActionButton.getTitle())) {
                throw new FacebookException("Must specify title for ShareMessengerActionButton");
            } else if ((shareMessengerActionButton instanceof ShareMessengerURLActionButton) && ((ShareMessengerURLActionButton) shareMessengerActionButton).getUrl() == null) {
                throw new FacebookException("Must specify url for ShareMessengerURLActionButton");
            }
        }
    }

    public static void validateForApiShare(ShareContent shareContent) {
        if (c == null) {
            c = new b(null);
        }
        b(shareContent, c);
    }

    public static void validateForMessage(ShareContent shareContent) {
        if (b == null) {
            b = new d(null);
        }
        b(shareContent, b);
    }

    public static void validateForNativeShare(ShareContent shareContent) {
        if (b == null) {
            b = new d(null);
        }
        b(shareContent, b);
    }

    public static void validateForStoryShare(ShareContent shareContent) {
        if (d == null) {
            d = new c(null);
        }
        b(shareContent, d);
    }

    public static void validateForWebShare(ShareContent shareContent) {
        if (a == null) {
            a = new e(null);
        }
        b(shareContent, a);
    }

    public static void validateMedium(ShareMedia shareMedia, d dVar) {
        if (shareMedia instanceof SharePhoto) {
            dVar.d((SharePhoto) shareMedia);
        } else if (shareMedia instanceof ShareVideo) {
            dVar.f((ShareVideo) shareMedia);
        } else {
            throw new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", shareMedia.getClass().getSimpleName()));
        }
    }
}

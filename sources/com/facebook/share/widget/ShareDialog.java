package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public final class ShareDialog extends FacebookDialogBase<ShareContent, Sharer.Result> implements Sharer {
    public static final String WEB_SHARE_DIALOG = "share";
    public static final int g = CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    public boolean e;
    public boolean f;

    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    public class b extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
        public b(a aVar) {
            super(ShareDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(Object obj, boolean z) {
            ShareContent shareContent = (ShareContent) obj;
            return (shareContent instanceof ShareCameraEffectContent) && ShareDialog.a(shareContent.getClass());
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            ShareContent shareContent = (ShareContent) obj;
            ShareContentValidation.validateForNativeShare(shareContent);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new a2.g.v.m.d(this, createBaseAppCall, shareContent, ShareDialog.this.getShouldFailOnDataError()), ShareDialog.d(shareContent.getClass()));
            return createBaseAppCall;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return Mode.NATIVE;
        }
    }

    public class c extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
        public c(a aVar) {
            super(ShareDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(Object obj, boolean z) {
            ShareContent shareContent = (ShareContent) obj;
            return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            Bundle bundle;
            ShareContent shareContent = (ShareContent) obj;
            ShareDialog shareDialog = ShareDialog.this;
            String str = ShareDialog.WEB_SHARE_DIALOG;
            ShareDialog.b(shareDialog, shareDialog.getActivityContext(), shareContent, Mode.FEED);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            if (shareContent instanceof ShareLinkContent) {
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                ShareContentValidation.validateForWebShare(shareLinkContent);
                bundle = WebDialogParameters.createForFeed(shareLinkContent);
            } else {
                bundle = WebDialogParameters.createForFeed((ShareFeedContent) shareContent);
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, VKApiConst.FEED, bundle);
            return createBaseAppCall;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return Mode.FEED;
        }
    }

    public class d extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
        public d(a aVar) {
            super(ShareDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(Object obj, boolean z) {
            boolean z2;
            ShareContent shareContent = (ShareContent) obj;
            if (shareContent == null || (shareContent instanceof ShareCameraEffectContent) || (shareContent instanceof ShareStoryContent)) {
                return false;
            }
            if (!z) {
                z2 = shareContent.getShareHashtag() != null ? DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.HASHTAG) : true;
                if ((shareContent instanceof ShareLinkContent) && !Utility.isNullOrEmpty(((ShareLinkContent) shareContent).getQuote())) {
                    z2 &= DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.LINK_SHARE_QUOTES);
                }
            } else {
                z2 = true;
            }
            if (!z2 || !ShareDialog.a(shareContent.getClass())) {
                return false;
            }
            return true;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            ShareContent shareContent = (ShareContent) obj;
            ShareDialog shareDialog = ShareDialog.this;
            String str = ShareDialog.WEB_SHARE_DIALOG;
            ShareDialog.b(shareDialog, shareDialog.getActivityContext(), shareContent, Mode.NATIVE);
            ShareContentValidation.validateForNativeShare(shareContent);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new a2.g.v.m.e(this, createBaseAppCall, shareContent, ShareDialog.this.getShouldFailOnDataError()), ShareDialog.d(shareContent.getClass()));
            return createBaseAppCall;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return Mode.NATIVE;
        }
    }

    public class e extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
        public e(a aVar) {
            super(ShareDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(Object obj, boolean z) {
            ShareContent shareContent = (ShareContent) obj;
            return (shareContent instanceof ShareStoryContent) && ShareDialog.a(shareContent.getClass());
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            ShareContent shareContent = (ShareContent) obj;
            ShareContentValidation.validateForStoryShare(shareContent);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new a2.g.v.m.f(this, createBaseAppCall, shareContent, ShareDialog.this.getShouldFailOnDataError()), ShareDialog.d(shareContent.getClass()));
            return createBaseAppCall;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return Mode.NATIVE;
        }
    }

    public class f extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
        public f(a aVar) {
            super(ShareDialog.this);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean canShow(java.lang.Object r4, boolean r5) {
            /*
                r3 = this;
                com.facebook.share.model.ShareContent r4 = (com.facebook.share.model.ShareContent) r4
                r5 = 0
                r0 = 1
                if (r4 == 0) goto L_0x002b
                java.lang.String r1 = com.facebook.share.widget.ShareDialog.WEB_SHARE_DIALOG
                java.lang.Class r1 = r4.getClass()
                boolean r1 = com.facebook.share.widget.ShareDialog.c(r1)
                if (r1 != 0) goto L_0x0013
                goto L_0x0025
            L_0x0013:
                boolean r1 = r4 instanceof com.facebook.share.model.ShareOpenGraphContent
                if (r1 == 0) goto L_0x0027
                com.facebook.share.model.ShareOpenGraphContent r4 = (com.facebook.share.model.ShareOpenGraphContent) r4
                com.facebook.share.internal.ShareInternalUtility.toJSONObjectForWeb(r4)     // Catch:{ Exception -> 0x001d }
                goto L_0x0027
            L_0x001d:
                r4 = move-exception
                java.lang.String r1 = "ShareDialog"
                java.lang.String r2 = "canShow returned false because the content of the Opem Graph object can't be shared via the web dialog"
                com.facebook.internal.Utility.logd(r1, r2, r4)
            L_0x0025:
                r4 = 0
                goto L_0x0028
            L_0x0027:
                r4 = 1
            L_0x0028:
                if (r4 == 0) goto L_0x002b
                r5 = 1
            L_0x002b:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.f.canShow(java.lang.Object, boolean):boolean");
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            Bundle bundle;
            ShareContent shareContent = (ShareContent) obj;
            ShareDialog shareDialog = ShareDialog.this;
            String str = ShareDialog.WEB_SHARE_DIALOG;
            ShareDialog.b(shareDialog, shareDialog.getActivityContext(), shareContent, Mode.WEB);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            ShareContentValidation.validateForWebShare(shareContent);
            boolean z = shareContent instanceof ShareLinkContent;
            String str2 = null;
            if (z) {
                bundle = WebDialogParameters.create((ShareLinkContent) shareContent);
            } else if (shareContent instanceof SharePhotoContent) {
                SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
                UUID callId = createBaseAppCall.getCallId();
                SharePhotoContent.Builder readFrom = new SharePhotoContent.Builder().readFrom(sharePhotoContent);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < sharePhotoContent.getPhotos().size(); i++) {
                    SharePhoto sharePhoto = sharePhotoContent.getPhotos().get(i);
                    Bitmap bitmap = sharePhoto.getBitmap();
                    if (bitmap != null) {
                        NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(callId, bitmap);
                        sharePhoto = new SharePhoto.Builder().readFrom(sharePhoto).setImageUrl(Uri.parse(createAttachment.getAttachmentUrl())).setBitmap(null).build();
                        arrayList2.add(createAttachment);
                    }
                    arrayList.add(sharePhoto);
                }
                readFrom.setPhotos(arrayList);
                NativeAppCallAttachmentStore.addAttachments(arrayList2);
                bundle = WebDialogParameters.create(readFrom.build());
            } else {
                bundle = WebDialogParameters.create((ShareOpenGraphContent) shareContent);
            }
            if (z || (shareContent instanceof SharePhotoContent)) {
                str2 = "share";
            } else if (shareContent instanceof ShareOpenGraphContent) {
                str2 = "share_open_graph";
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, str2, bundle);
            return createBaseAppCall;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return Mode.WEB;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShareDialog(android.app.Activity r2) {
        /*
            r1 = this;
            int r0 = com.facebook.share.widget.ShareDialog.g
            r1.<init>(r2, r0)
            r2 = 0
            r1.e = r2
            r2 = 1
            r1.f = r2
            com.facebook.share.internal.ShareInternalUtility.registerStaticShareCallback(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.<init>(android.app.Activity):void");
    }

    public static boolean a(Class cls) {
        DialogFeature d2 = d(cls);
        return d2 != null && DialogPresenter.canPresentNativeDialogWithFeature(d2);
    }

    public static void b(ShareDialog shareDialog, Context context, ShareContent shareContent, Mode mode) {
        if (shareDialog.f) {
            mode = Mode.AUTOMATIC;
        }
        int ordinal = mode.ordinal();
        String str = "unknown";
        String str2 = ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? str : "web" : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC;
        DialogFeature d2 = d(shareContent.getClass());
        if (d2 == ShareDialogFeature.SHARE_DIALOG) {
            str = "status";
        } else if (d2 == ShareDialogFeature.PHOTOS) {
            str = "photo";
        } else if (d2 == ShareDialogFeature.VIDEO) {
            str = "video";
        } else if (d2 == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
            str = "open_graph";
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str2);
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_TYPE, str);
        internalAppEventsLogger.logEventImplicitly("fb_share_dialog_show", bundle);
    }

    public static boolean c(Class<? extends ShareContent> cls) {
        return ShareLinkContent.class.isAssignableFrom(cls) || ShareOpenGraphContent.class.isAssignableFrom(cls) || (SharePhotoContent.class.isAssignableFrom(cls) && AccessToken.isCurrentAccessTokenActive());
    }

    public static boolean canShow(Class<? extends ShareContent> cls) {
        if (c(cls)) {
            return true;
        }
        DialogFeature d2 = d(cls);
        if (d2 != null && DialogPresenter.canPresentNativeDialogWithFeature(d2)) {
            return true;
        }
        return false;
    }

    public static DialogFeature d(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.SHARE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            return OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
        }
        if (ShareMediaContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.MULTIMEDIA;
        }
        if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
            return CameraEffectFeature.SHARE_CAMERA_EFFECT;
        }
        if (ShareStoryContent.class.isAssignableFrom(cls)) {
            return ShareStoryFeature.SHARE_STORY_ASSET;
        }
        return null;
    }

    public static void show(Activity activity, ShareContent shareContent) {
        new ShareDialog(activity).show(shareContent);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(null));
        arrayList.add(new c(null));
        arrayList.add(new f(null));
        arrayList.add(new b(null));
        arrayList.add(new e(null));
        return arrayList;
    }

    @Override // com.facebook.share.Sharer
    public boolean getShouldFailOnDataError() {
        return this.e;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Sharer.Result> facebookCallback) {
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManagerImpl, facebookCallback);
    }

    @Override // com.facebook.share.Sharer
    public void setShouldFailOnDataError(boolean z) {
        this.e = z;
    }

    public static void show(Fragment fragment, ShareContent shareContent) {
        new ShareDialog(new FragmentWrapper(fragment)).show(shareContent);
    }

    public static void show(android.app.Fragment fragment, ShareContent shareContent) {
        new ShareDialog(new FragmentWrapper(fragment)).show(shareContent);
    }

    public boolean canShow(ShareContent shareContent, Mode mode) {
        Mode mode2 = mode;
        if (mode == Mode.AUTOMATIC) {
            mode2 = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        return canShowImpl(shareContent, mode2);
    }

    public ShareDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public ShareDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public void show(ShareContent shareContent, Mode mode) {
        boolean z = mode == Mode.AUTOMATIC;
        this.f = z;
        Mode mode2 = mode;
        if (z) {
            mode2 = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        showImpl(shareContent, mode2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShareDialog(com.facebook.internal.FragmentWrapper r2) {
        /*
            r1 = this;
            int r0 = com.facebook.share.widget.ShareDialog.g
            r1.<init>(r2, r0)
            r2 = 0
            r1.e = r2
            r2 = 1
            r1.f = r2
            com.facebook.share.internal.ShareInternalUtility.registerStaticShareCallback(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.<init>(com.facebook.internal.FragmentWrapper):void");
    }

    public ShareDialog(Activity activity, int i) {
        super(activity, i);
        this.e = false;
        this.f = true;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    public ShareDialog(Fragment fragment, int i) {
        super(new FragmentWrapper(fragment), i);
        this.e = false;
        this.f = true;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    public ShareDialog(android.app.Fragment fragment, int i) {
        super(new FragmentWrapper(fragment), i);
        this.e = false;
        this.f = true;
        ShareInternalUtility.registerStaticShareCallback(i);
    }
}

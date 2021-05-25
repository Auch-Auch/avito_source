package com.facebook.share.widget;

import a2.g.v.m.c;
import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.Sharer;
import com.facebook.share.internal.MessageDialogFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import java.util.ArrayList;
import java.util.List;
@Deprecated
public final class MessageDialog extends FacebookDialogBase<ShareContent, Sharer.Result> implements Sharer {
    public static final int f = CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
    public boolean e = false;

    public class b extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
        public b(a aVar) {
            super(MessageDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(Object obj, boolean z) {
            ShareContent shareContent = (ShareContent) obj;
            return shareContent != null && MessageDialog.canShow(shareContent.getClass());
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            String str;
            ShareContent shareContent = (ShareContent) obj;
            ShareContentValidation.validateForMessage(shareContent);
            AppCall createBaseAppCall = MessageDialog.this.createBaseAppCall();
            boolean shouldFailOnDataError = MessageDialog.this.getShouldFailOnDataError();
            Activity activityContext = MessageDialog.this.getActivityContext();
            DialogFeature a3 = MessageDialog.a(shareContent.getClass());
            if (a3 == MessageDialogFeature.MESSAGE_DIALOG) {
                str = "status";
            } else if (a3 == MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE) {
                str = AnalyticsEvents.PARAMETER_SHARE_MESSENGER_GENERIC_TEMPLATE;
            } else if (a3 == MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE) {
                str = AnalyticsEvents.PARAMETER_SHARE_MESSENGER_MEDIA_TEMPLATE;
            } else {
                str = a3 == MessageDialogFeature.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE ? AnalyticsEvents.PARAMETER_SHARE_MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE : "unknown";
            }
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(activityContext);
            Bundle y1 = a2.b.a.a.a.y1(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_TYPE, str);
            y1.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_UUID, createBaseAppCall.getCallId().toString());
            y1.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PAGE_ID, shareContent.getPageId());
            internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_MESSENGER_DIALOG_SHOW, y1);
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new c(this, createBaseAppCall, shareContent, shouldFailOnDataError), MessageDialog.a(shareContent.getClass()));
            return createBaseAppCall;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessageDialog(android.app.Activity r2) {
        /*
            r1 = this;
            int r0 = com.facebook.share.widget.MessageDialog.f
            r1.<init>(r2, r0)
            r2 = 0
            r1.e = r2
            com.facebook.share.internal.ShareInternalUtility.registerStaticShareCallback(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.MessageDialog.<init>(android.app.Activity):void");
    }

    public static DialogFeature a(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSAGE_DIALOG;
        }
        if (ShareMessengerGenericTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE;
        }
        if (ShareMessengerOpenGraphMusicTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE;
        }
        if (ShareMessengerMediaTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE;
        }
        return null;
    }

    public static boolean canShow(Class<? extends ShareContent> cls) {
        DialogFeature a3 = a(cls);
        return a3 != null && DialogPresenter.canPresentNativeDialogWithFeature(a3);
    }

    public static void show(Activity activity, ShareContent shareContent) {
        new MessageDialog(activity).show(shareContent);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(null));
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
        new MessageDialog(new FragmentWrapper(fragment)).show(shareContent);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessageDialog(androidx.fragment.app.Fragment r2) {
        /*
            r1 = this;
            com.facebook.internal.FragmentWrapper r0 = new com.facebook.internal.FragmentWrapper
            r0.<init>(r2)
            int r2 = com.facebook.share.widget.MessageDialog.f
            r1.<init>(r0, r2)
            r0 = 0
            r1.e = r0
            com.facebook.share.internal.ShareInternalUtility.registerStaticShareCallback(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.MessageDialog.<init>(androidx.fragment.app.Fragment):void");
    }

    public static void show(android.app.Fragment fragment, ShareContent shareContent) {
        new MessageDialog(new FragmentWrapper(fragment)).show(shareContent);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessageDialog(android.app.Fragment r2) {
        /*
            r1 = this;
            com.facebook.internal.FragmentWrapper r0 = new com.facebook.internal.FragmentWrapper
            r0.<init>(r2)
            int r2 = com.facebook.share.widget.MessageDialog.f
            r1.<init>(r0, r2)
            r0 = 0
            r1.e = r0
            com.facebook.share.internal.ShareInternalUtility.registerStaticShareCallback(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.MessageDialog.<init>(android.app.Fragment):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessageDialog(com.facebook.internal.FragmentWrapper r2) {
        /*
            r1 = this;
            int r0 = com.facebook.share.widget.MessageDialog.f
            r1.<init>(r2, r0)
            r2 = 0
            r1.e = r2
            com.facebook.share.internal.ShareInternalUtility.registerStaticShareCallback(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.MessageDialog.<init>(com.facebook.internal.FragmentWrapper):void");
    }

    public MessageDialog(Activity activity, int i) {
        super(activity, i);
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    public MessageDialog(Fragment fragment, int i) {
        super(new FragmentWrapper(fragment), i);
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    public MessageDialog(android.app.Fragment fragment, int i) {
        super(new FragmentWrapper(fragment), i);
        ShareInternalUtility.registerStaticShareCallback(i);
    }
}

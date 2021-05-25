package a2.g.v.l;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.ResultProcessor;
public class g extends ResultProcessor {
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ LikeActionController c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(LikeActionController likeActionController, FacebookCallback facebookCallback, Bundle bundle) {
        super(null);
        this.c = likeActionController;
        this.b = bundle;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onCancel(AppCall appCall) {
        onError(appCall, new FacebookOperationCanceledException());
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onError(AppCall appCall, FacebookException facebookException) {
        LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
        String str = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
        Logger.log(loggingBehavior, "LikeActionController", "Like Dialog failed with error : %s", facebookException);
        Bundle bundle = this.b;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
        this.c.j("present_dialog", bundle);
        LikeActionController.c(this.c, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, NativeProtocol.createBundleForException(facebookException));
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (bundle != null && bundle.containsKey("object_is_liked")) {
            boolean z = bundle.getBoolean("object_is_liked");
            LikeActionController likeActionController = this.c;
            String str6 = likeActionController.d;
            String str7 = likeActionController.e;
            if (bundle.containsKey("like_count_string")) {
                str2 = bundle.getString("like_count_string");
                str = str2;
            } else {
                str = str7;
                str2 = str6;
            }
            LikeActionController likeActionController2 = this.c;
            String str8 = likeActionController2.f;
            String str9 = likeActionController2.g;
            if (bundle.containsKey("social_sentence")) {
                str4 = bundle.getString("social_sentence");
                str3 = str4;
            } else {
                str3 = str9;
                str4 = str8;
            }
            if (bundle.containsKey("object_is_liked")) {
                str5 = bundle.getString("unlike_token");
            } else {
                str5 = this.c.h;
            }
            Bundle bundle2 = this.b;
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
            this.c.g().logEventImplicitly(AnalyticsEvents.EVENT_LIKE_VIEW_DIALOG_DID_SUCCEED, bundle2);
            this.c.p(z, str2, str, str4, str3, str5);
        }
    }
}

package a2.g.v.l;

import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.ShareConstants;
public class b implements PlatformServiceClient.CompletedListener {
    public final /* synthetic */ LikeActionController a;

    public b(LikeActionController likeActionController) {
        this.a = likeActionController;
    }

    @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
    public void completed(Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (bundle != null && bundle.containsKey(ShareConstants.EXTRA_OBJECT_IS_LIKED)) {
            boolean z = bundle.getBoolean(ShareConstants.EXTRA_OBJECT_IS_LIKED);
            if (bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE)) {
                str = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE);
            } else {
                str = this.a.d;
            }
            if (bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE)) {
                str2 = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE);
            } else {
                str2 = this.a.e;
            }
            if (bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE)) {
                str3 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE);
            } else {
                str3 = this.a.f;
            }
            if (bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE)) {
                str4 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE);
            } else {
                str4 = this.a.g;
            }
            if (bundle.containsKey(ShareConstants.EXTRA_UNLIKE_TOKEN)) {
                str5 = bundle.getString(ShareConstants.EXTRA_UNLIKE_TOKEN);
            } else {
                str5 = this.a.h;
            }
            LikeActionController likeActionController = this.a;
            String str6 = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
            likeActionController.p(z, str, str2, str3, str4, str5);
        }
    }
}

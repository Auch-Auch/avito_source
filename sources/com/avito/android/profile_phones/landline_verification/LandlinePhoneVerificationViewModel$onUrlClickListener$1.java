package com.avito.android.profile_phones.landline_verification;

import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationViewModel;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$onUrlClickListener$1", "Lcom/avito/android/deep_linking/links/OnUrlClickListener;", "", "url", "", "onUrlClick", "(Ljava/lang/String;)Z", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class LandlinePhoneVerificationViewModel$onUrlClickListener$1 implements OnUrlClickListener {
    public final /* synthetic */ LandlinePhoneVerificationViewModel a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public LandlinePhoneVerificationViewModel$onUrlClickListener$1(LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel) {
        this.a = landlinePhoneVerificationViewModel;
    }

    @Override // com.avito.android.deep_linking.links.OnUrlClickListener
    public boolean onUrlClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        URL url = new URL(str);
        if (!Intrinsics.areEqual(url.getHost(), "support.avito.ru")) {
            return true;
        }
        SingleLiveEvent singleLiveEvent = this.a.h;
        String path = url.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "urlObj.path");
        singleLiveEvent.postValue(new LandlinePhoneVerificationViewModel.RoutingAction.GoToHelpCenter(path));
        return true;
    }
}

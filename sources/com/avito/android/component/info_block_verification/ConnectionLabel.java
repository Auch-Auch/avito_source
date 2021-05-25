package com.avito.android.component.info_block_verification;

import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/component/info_block_verification/ConnectionLabel;", "", "", AuthSource.SEND_ABUSE, "I", "getImageRes", "()I", "imageRes", "<init>", "(Ljava/lang/String;II)V", "VK", "GOOGLE_PLUS", "FACEBOOK", "OK", "MAIL", "PHONE", "ESIA", "APPLE", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public enum ConnectionLabel {
    VK(R.drawable.ic_profile_vk),
    GOOGLE_PLUS(R.drawable.ic_profile_gp),
    FACEBOOK(R.drawable.ic_profile_fb),
    OK(R.drawable.ic_profile_ok),
    MAIL(R.drawable.ic_profile_mail),
    PHONE(R.drawable.ic_profile_phone),
    ESIA(R.drawable.ic_profile_esia),
    APPLE(R.drawable.ic_profile_apple);
    
    public final int a;

    /* access modifiers changed from: public */
    ConnectionLabel(@DrawableRes int i) {
        this.a = i;
    }

    public final int getImageRes() {
        return this.a;
    }
}

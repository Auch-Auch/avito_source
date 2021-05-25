package com.avito.android.vas.list;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/vas/list/VasContext;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", MessengerShareContentUtility.PREVIEW_DEFAULT, "WAITING_AD_ACTIVATION", "FINISHED_AD_ACTIVATION", "AD_EDITING", "POST_ACTIVATION", "AD_CREATION", "core_release"}, k = 1, mv = {1, 4, 2})
public enum VasContext {
    DEFAULT("default"),
    WAITING_AD_ACTIVATION("waiting_ad_activation"),
    FINISHED_AD_ACTIVATION("finished_ad_activation"),
    AD_EDITING("ad_editing"),
    POST_ACTIVATION("post_activation"),
    AD_CREATION("ad_creation");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    VasContext(String str) {
        this.a = str;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }
}

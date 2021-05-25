package com.avito.android.social.button;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/avito/android/social/button/SocialInfo;", "", "", AuthSource.BOOKING_ORDER, "I", "getIcon", "()I", "icon", "c", "Ljava/lang/Integer;", "getTintColor", "()Ljava/lang/Integer;", "tintColor", AuthSource.SEND_ABUSE, "getBackground", "background", "<init>", "(IILjava/lang/Integer;)V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class SocialInfo {
    public final int a;
    public final int b;
    @Nullable
    public final Integer c;

    public SocialInfo(@DrawableRes int i, @DrawableRes int i2, @ColorRes @Nullable Integer num) {
        this.a = i;
        this.b = i2;
        this.c = num;
    }

    public final int getBackground() {
        return this.a;
    }

    public final int getIcon() {
        return this.b;
    }

    @Nullable
    public final Integer getTintColor() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SocialInfo(int i, int i2, Integer num, int i3, j jVar) {
        this(i, i2, (i3 & 4) != 0 ? null : num);
    }
}

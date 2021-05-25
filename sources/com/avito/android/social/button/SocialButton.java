package com.avito.android.social.button;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/social/button/SocialButton;", "", "", "c", "Ljava/lang/Integer;", "getTint", "()Ljava/lang/Integer;", "tint", AuthSource.SEND_ABUSE, "I", "getBackground", "()I", "background", AuthSource.BOOKING_ORDER, "getIcon", "icon", "Lkotlin/Function0;", "", "d", "Lkotlin/jvm/functions/Function0;", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "clickListener", "<init>", "(IILjava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class SocialButton {
    public final int a;
    public final int b;
    @Nullable
    public final Integer c;
    @NotNull
    public final Function0<Unit> d;

    public SocialButton(@DrawableRes int i, @DrawableRes int i2, @ColorRes @Nullable Integer num, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "clickListener");
        this.a = i;
        this.b = i2;
        this.c = num;
        this.d = function0;
    }

    public final int getBackground() {
        return this.a;
    }

    @NotNull
    public final Function0<Unit> getClickListener() {
        return this.d;
    }

    public final int getIcon() {
        return this.b;
    }

    @Nullable
    public final Integer getTint() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SocialButton(int i, int i2, Integer num, Function0 function0, int i3, j jVar) {
        this(i, i2, (i3 & 4) != 0 ? null : num, function0);
    }
}

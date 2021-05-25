package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0018"}, d2 = {"Landroidx/navigation/AnimBuilder;", "", "", AuthSource.SEND_ABUSE, "I", "getEnter", "()I", "setEnter", "(I)V", "enter", AuthSource.BOOKING_ORDER, "getExit", "setExit", "exit", "c", "getPopEnter", "setPopEnter", "popEnter", "d", "getPopExit", "setPopExit", "popExit", "<init>", "()V", "navigation-common-ktx_release"}, k = 1, mv = {1, 4, 0})
@NavOptionsDsl
public final class AnimBuilder {
    @AnimRes
    @AnimatorRes
    public int a = -1;
    @AnimRes
    @AnimatorRes
    public int b = -1;
    @AnimRes
    @AnimatorRes
    public int c = -1;
    @AnimRes
    @AnimatorRes
    public int d = -1;

    public final int getEnter() {
        return this.a;
    }

    public final int getExit() {
        return this.b;
    }

    public final int getPopEnter() {
        return this.c;
    }

    public final int getPopExit() {
        return this.d;
    }

    public final void setEnter(int i) {
        this.a = i;
    }

    public final void setExit(int i) {
        this.b = i;
    }

    public final void setPopEnter(int i) {
        this.c = i;
    }

    public final void setPopExit(int i) {
        this.d = i;
    }
}

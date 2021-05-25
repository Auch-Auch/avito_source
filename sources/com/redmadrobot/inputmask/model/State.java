package com.redmadrobot.inputmask.model;

import a2.b.a.a.a;
import com.avito.android.BuildConfig;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/redmadrobot/inputmask/model/State;", "", "", FirebaseAnalytics.Param.CHARACTER, "Lcom/redmadrobot/inputmask/model/Next;", "accept", "(C)Lcom/redmadrobot/inputmask/model/Next;", "autocomplete", "()Lcom/redmadrobot/inputmask/model/Next;", "nextState", "()Lcom/redmadrobot/inputmask/model/State;", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Lcom/redmadrobot/inputmask/model/State;", "getChild", VKApiUserFull.RelativeType.CHILD, "<init>", "(Lcom/redmadrobot/inputmask/model/State;)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public abstract class State {
    @Nullable
    public final State a;

    public State(@Nullable State state) {
        this.a = state;
    }

    @Nullable
    public abstract Next accept(char c);

    @Nullable
    public Next autocomplete() {
        return null;
    }

    @Nullable
    public final State getChild() {
        return this.a;
    }

    @NotNull
    public State nextState() {
        State state = this.a;
        if (state == null) {
            Intrinsics.throwNpe();
        }
        return state;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("BASE -> ");
        State state = this.a;
        L.append(state != null ? state.toString() : BuildConfig.ADJUST_DEFAULT_TRACKER);
        return L.toString();
    }
}

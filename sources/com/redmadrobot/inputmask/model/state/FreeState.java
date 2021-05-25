package com.redmadrobot.inputmask.model.state;

import a2.b.a.a.a;
import com.avito.android.BuildConfig;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.State;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/FreeState;", "Lcom/redmadrobot/inputmask/model/State;", "", FirebaseAnalytics.Param.CHARACTER, "Lcom/redmadrobot/inputmask/model/Next;", "accept", "(C)Lcom/redmadrobot/inputmask/model/Next;", "autocomplete", "()Lcom/redmadrobot/inputmask/model/Next;", "", "toString", "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "C", "getOwnCharacter", "()C", "ownCharacter", VKApiUserFull.RelativeType.CHILD, "<init>", "(Lcom/redmadrobot/inputmask/model/State;C)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public final class FreeState extends State {
    public final char b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FreeState(@NotNull State state, char c) {
        super(state);
        Intrinsics.checkParameterIsNotNull(state, VKApiUserFull.RelativeType.CHILD);
        this.b = c;
    }

    @Override // com.redmadrobot.inputmask.model.State
    @Nullable
    public Next accept(char c) {
        if (this.b == c) {
            return new Next(nextState(), Character.valueOf(c), true, null);
        }
        return new Next(nextState(), Character.valueOf(this.b), false, null);
    }

    @Override // com.redmadrobot.inputmask.model.State
    @Nullable
    public Next autocomplete() {
        return new Next(nextState(), Character.valueOf(this.b), false, null);
    }

    public final char getOwnCharacter() {
        return this.b;
    }

    @Override // com.redmadrobot.inputmask.model.State
    @NotNull
    public String toString() {
        StringBuilder L = a.L("");
        L.append(this.b);
        L.append(" -> ");
        L.append(getChild() == null ? BuildConfig.ADJUST_DEFAULT_TRACKER : getChild().toString());
        return L.toString();
    }
}

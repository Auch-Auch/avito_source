package com.redmadrobot.inputmask.model;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/redmadrobot/inputmask/model/Next;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Character;", "getInsert", "()Ljava/lang/Character;", "insert", "d", "getValue", "value", "Lcom/redmadrobot/inputmask/model/State;", AuthSource.SEND_ABUSE, "Lcom/redmadrobot/inputmask/model/State;", "getState", "()Lcom/redmadrobot/inputmask/model/State;", "state", "", "c", "Z", "getPass", "()Z", "pass", "<init>", "(Lcom/redmadrobot/inputmask/model/State;Ljava/lang/Character;ZLjava/lang/Character;)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public final class Next {
    @NotNull
    public final State a;
    @Nullable
    public final Character b;
    public final boolean c;
    @Nullable
    public final Character d;

    public Next(@NotNull State state, @Nullable Character ch, boolean z, @Nullable Character ch2) {
        Intrinsics.checkParameterIsNotNull(state, "state");
        this.a = state;
        this.b = ch;
        this.c = z;
        this.d = ch2;
    }

    @Nullable
    public final Character getInsert() {
        return this.b;
    }

    public final boolean getPass() {
        return this.c;
    }

    @NotNull
    public final State getState() {
        return this.a;
    }

    @Nullable
    public final Character getValue() {
        return this.d;
    }
}

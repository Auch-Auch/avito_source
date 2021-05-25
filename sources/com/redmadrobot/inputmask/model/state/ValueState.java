package com.redmadrobot.inputmask.model.state;

import a2.b.a.a.a;
import com.avito.android.BuildConfig;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.State;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017B\u001b\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0019J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState;", "Lcom/redmadrobot/inputmask/model/State;", "", FirebaseAnalytics.Param.CHARACTER, "Lcom/redmadrobot/inputmask/model/Next;", "accept", "(C)Lcom/redmadrobot/inputmask/model/Next;", "nextState", "()Lcom/redmadrobot/inputmask/model/State;", "", "toString", "()Ljava/lang/String;", "", "isElliptical", "()Z", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", AuthSource.BOOKING_ORDER, "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "getType", "()Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "type", "inheritedType", "<init>", "(Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;)V", VKApiUserFull.RelativeType.CHILD, "(Lcom/redmadrobot/inputmask/model/State;Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;)V", "StateType", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public final class ValueState extends State {
    @NotNull
    public final StateType b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "", "<init>", "()V", "AlphaNumeric", "Custom", "Ellipsis", "Literal", "Numeric", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Numeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Literal;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$AlphaNumeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Ellipsis;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Custom;", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
    public static abstract class StateType {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$AlphaNumeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "<init>", "()V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
        public static final class AlphaNumeric extends StateType {
            public AlphaNumeric() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Custom;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCharacterSet", "()Ljava/lang/String;", "characterSet", "", AuthSource.SEND_ABUSE, "C", "getCharacter", "()C", FirebaseAnalytics.Param.CHARACTER, "<init>", "(CLjava/lang/String;)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
        public static final class Custom extends StateType {
            public final char a;
            @NotNull
            public final String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Custom(char c, @NotNull String str) {
                super(null);
                Intrinsics.checkParameterIsNotNull(str, "characterSet");
                this.a = c;
                this.b = str;
            }

            public final char getCharacter() {
                return this.a;
            }

            @NotNull
            public final String getCharacterSet() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Ellipsis;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", AuthSource.SEND_ABUSE, "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "getInheritedType", "()Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "inheritedType", "<init>", "(Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
        public static final class Ellipsis extends StateType {
            @NotNull
            public final StateType a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Ellipsis(@NotNull StateType stateType) {
                super(null);
                Intrinsics.checkParameterIsNotNull(stateType, "inheritedType");
                this.a = stateType;
            }

            @NotNull
            public final StateType getInheritedType() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Literal;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "<init>", "()V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
        public static final class Literal extends StateType {
            public Literal() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Numeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "<init>", "()V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
        public static final class Numeric extends StateType {
            public Numeric() {
                super(null);
            }
        }

        public StateType() {
        }

        public StateType(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValueState(@NotNull StateType stateType) {
        super(null);
        Intrinsics.checkParameterIsNotNull(stateType, "inheritedType");
        this.b = new StateType.Ellipsis(stateType);
    }

    @Override // com.redmadrobot.inputmask.model.State
    @Nullable
    public Next accept(char c) {
        StateType stateType = this.b;
        boolean z = false;
        if (stateType instanceof StateType.Numeric) {
            z = Character.isDigit(c);
        } else if (stateType instanceof StateType.Literal) {
            z = Character.isLetter(c);
        } else if (stateType instanceof StateType.AlphaNumeric) {
            z = Character.isLetterOrDigit(c);
        } else if (stateType instanceof StateType.Ellipsis) {
            StateType inheritedType = ((StateType.Ellipsis) stateType).getInheritedType();
            if (inheritedType instanceof StateType.Numeric) {
                z = Character.isDigit(c);
            } else if (inheritedType instanceof StateType.Literal) {
                z = Character.isLetter(c);
            } else if (inheritedType instanceof StateType.AlphaNumeric) {
                z = Character.isLetterOrDigit(c);
            } else if (inheritedType instanceof StateType.Custom) {
                z = StringsKt__StringsKt.contains$default((CharSequence) ((StateType.Custom) ((StateType.Ellipsis) this.b).getInheritedType()).getCharacterSet(), c, false, 2, (Object) null);
            }
        } else if (stateType instanceof StateType.Custom) {
            z = StringsKt__StringsKt.contains$default((CharSequence) ((StateType.Custom) stateType).getCharacterSet(), c, false, 2, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (!z) {
            return null;
        }
        return new Next(nextState(), Character.valueOf(c), true, Character.valueOf(c));
    }

    @NotNull
    public final StateType getType() {
        return this.b;
    }

    public final boolean isElliptical() {
        return this.b instanceof StateType.Ellipsis;
    }

    @Override // com.redmadrobot.inputmask.model.State
    @NotNull
    public State nextState() {
        return this.b instanceof StateType.Ellipsis ? this : super.nextState();
    }

    @Override // com.redmadrobot.inputmask.model.State
    @NotNull
    public String toString() {
        StateType stateType = this.b;
        boolean z = stateType instanceof StateType.Literal;
        String str = BuildConfig.ADJUST_DEFAULT_TRACKER;
        if (z) {
            StringBuilder L = a.L("[A] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            L.append(str);
            return L.toString();
        } else if (stateType instanceof StateType.Numeric) {
            StringBuilder L2 = a.L("[0] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            L2.append(str);
            return L2.toString();
        } else if (stateType instanceof StateType.AlphaNumeric) {
            StringBuilder L3 = a.L("[_] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            L3.append(str);
            return L3.toString();
        } else if (stateType instanceof StateType.Ellipsis) {
            StringBuilder L4 = a.L("[…] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            L4.append(str);
            return L4.toString();
        } else if (stateType instanceof StateType.Custom) {
            StringBuilder L5 = a.L("[");
            L5.append(((StateType.Custom) this.b).getCharacter());
            L5.append("] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            L5.append(str);
            return L5.toString();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValueState(@Nullable State state, @NotNull StateType stateType) {
        super(state);
        Intrinsics.checkParameterIsNotNull(stateType, "type");
        this.b = stateType;
    }
}

package com.redmadrobot.inputmask.helper;

import com.avito.android.remote.auth.AuthSource;
import com.redmadrobot.inputmask.model.Notation;
import com.redmadrobot.inputmask.model.State;
import com.redmadrobot.inputmask.model.state.EOLState;
import com.redmadrobot.inputmask.model.state.FixedState;
import com.redmadrobot.inputmask.model.state.FreeState;
import com.redmadrobot.inputmask.model.state.OptionalValueState;
import com.redmadrobot.inputmask.model.state.ValueState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Compiler;", "", "", "formatString", "Lcom/redmadrobot/inputmask/model/State;", "compile", "(Ljava/lang/String;)Lcom/redmadrobot/inputmask/model/State;", "", "valuable", "fixed", "", "lastCharacter", AuthSource.SEND_ABUSE, "(Ljava/lang/String;ZZLjava/lang/Character;)Lcom/redmadrobot/inputmask/model/State;", "", "Lcom/redmadrobot/inputmask/model/Notation;", "Ljava/util/List;", "customNotations", "<init>", "(Ljava/util/List;)V", "FormatError", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public final class Compiler {
    public final List<Notation> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Compiler$FormatError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
    public static final class FormatError extends Exception {
    }

    public Compiler(@NotNull List<Notation> list) {
        Intrinsics.checkParameterIsNotNull(list, "customNotations");
        this.a = list;
    }

    public final State a(String str, boolean z, boolean z2, Character ch) {
        ValueState.StateType stateType;
        if (str.length() == 0) {
            return new EOLState();
        }
        char first = StringsKt___StringsKt.first(str);
        if (first != '{') {
            if (first != '}') {
                switch (first) {
                    case '[':
                        if (ch == null || '\\' != ch.charValue()) {
                            return a(StringsKt___StringsKt.drop(str, 1), true, false, Character.valueOf(first));
                        }
                    case '\\':
                        if (ch == null || '\\' != ch.charValue()) {
                            return a(StringsKt___StringsKt.drop(str, 1), z, z2, Character.valueOf(first));
                        }
                    case ']':
                        if (ch == null || '\\' != ch.charValue()) {
                            return a(StringsKt___StringsKt.drop(str, 1), false, false, Character.valueOf(first));
                        }
                }
            } else if (ch == null || '\\' != ch.charValue()) {
                return a(StringsKt___StringsKt.drop(str, 1), false, false, Character.valueOf(first));
            }
        } else if (ch == null || '\\' != ch.charValue()) {
            return a(StringsKt___StringsKt.drop(str, 1), false, true, Character.valueOf(first));
        }
        if (z) {
            if (first == '-') {
                return new OptionalValueState(a(StringsKt___StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new OptionalValueState.StateType.AlphaNumeric());
            }
            if (first == '0') {
                return new ValueState(a(StringsKt___StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new ValueState.StateType.Numeric());
            }
            if (first == '9') {
                return new OptionalValueState(a(StringsKt___StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new OptionalValueState.StateType.Numeric());
            }
            if (first == 'A') {
                return new ValueState(a(StringsKt___StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new ValueState.StateType.Literal());
            }
            if (first == '_') {
                return new ValueState(a(StringsKt___StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new ValueState.StateType.AlphaNumeric());
            }
            if (first == 'a') {
                return new OptionalValueState(a(StringsKt___StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new OptionalValueState.StateType.Literal());
            }
            if (first != 8230) {
                for (Notation notation : this.a) {
                    if (notation.getCharacter() == first) {
                        if (notation.isOptional()) {
                            return new OptionalValueState(a(StringsKt___StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new OptionalValueState.StateType.Custom(first, notation.getCharacterSet()));
                        }
                        return new ValueState(a(StringsKt___StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new ValueState.StateType.Custom(first, notation.getCharacterSet()));
                    }
                }
                throw new FormatError();
            }
            if ((ch != null && ch.charValue() == '0') || (ch != null && ch.charValue() == '9')) {
                stateType = new ValueState.StateType.Numeric();
            } else if ((ch != null && ch.charValue() == 'A') || (ch != null && ch.charValue() == 'a')) {
                stateType = new ValueState.StateType.Literal();
            } else if ((ch != null && ch.charValue() == '_') || (ch != null && ch.charValue() == '-')) {
                stateType = new ValueState.StateType.AlphaNumeric();
            } else if (ch != null && ch.charValue() == 8230) {
                stateType = new ValueState.StateType.AlphaNumeric();
            } else if (ch != null && ch.charValue() == '[') {
                stateType = new ValueState.StateType.AlphaNumeric();
            } else {
                for (T t : this.a) {
                    char character = t.getCharacter();
                    if (ch != null && character == ch.charValue()) {
                        stateType = new ValueState.StateType.Custom(ch.charValue(), t.getCharacterSet());
                    }
                }
                throw new FormatError();
            }
            return new ValueState(stateType);
        } else if (z2) {
            return new FixedState(a(StringsKt___StringsKt.drop(str, 1), false, true, Character.valueOf(first)), first);
        } else {
            return new FreeState(a(StringsKt___StringsKt.drop(str, 1), false, false, Character.valueOf(first)), first);
        }
    }

    @NotNull
    public final State compile(@NotNull String str) throws FormatError {
        Intrinsics.checkParameterIsNotNull(str, "formatString");
        return a(new FormatSanitizer().sanitize(str), false, false, null);
    }
}

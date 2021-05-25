package com.redmadrobot.inputmask.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.Types;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b!\u0010\"J\r\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0013\u0010\tJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\fR\u0019\u0010\u000e\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\tR\u0019\u0010\r\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0006¨\u0006$"}, d2 = {"Lcom/redmadrobot/inputmask/model/CaretString;", "", "reversed", "()Lcom/redmadrobot/inputmask/model/CaretString;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", "component3", "()Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", Types.STRING, "caretPosition", "caretGravity", "copy", "(Ljava/lang/String;ILcom/redmadrobot/inputmask/model/CaretString$CaretGravity;)Lcom/redmadrobot/inputmask/model/CaretString;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", "getCaretGravity", AuthSource.BOOKING_ORDER, "I", "getCaretPosition", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getString", "<init>", "(Ljava/lang/String;ILcom/redmadrobot/inputmask/model/CaretString$CaretGravity;)V", "CaretGravity", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public final class CaretString {
    @NotNull
    public final String a;
    public final int b;
    @NotNull
    public final CaretGravity c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\n\u000bB\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0007\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", "", "", "getAutocomplete", "()Z", "autocomplete", "getAutoskip", "autoskip", "<init>", "()V", "BACKWARD", "FORWARD", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity$FORWARD;", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity$BACKWARD;", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
    public static abstract class CaretGravity {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity$BACKWARD;", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", "", AuthSource.SEND_ABUSE, "Z", "getAutoskipValue", "()Z", "autoskipValue", "<init>", "(Z)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
        public static final class BACKWARD extends CaretGravity {
            public final boolean a;

            public BACKWARD(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean getAutoskipValue() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity$FORWARD;", "Lcom/redmadrobot/inputmask/model/CaretString$CaretGravity;", "", AuthSource.SEND_ABUSE, "Z", "getAutocompleteValue", "()Z", "autocompleteValue", "<init>", "(Z)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
        public static final class FORWARD extends CaretGravity {
            public final boolean a;

            public FORWARD(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean getAutocompleteValue() {
                return this.a;
            }
        }

        public CaretGravity() {
        }

        public final boolean getAutocomplete() {
            if (this instanceof FORWARD) {
                return ((FORWARD) this).getAutocompleteValue();
            }
            return false;
        }

        public final boolean getAutoskip() {
            if (this instanceof BACKWARD) {
                return ((BACKWARD) this).getAutoskipValue();
            }
            return false;
        }

        public CaretGravity(j jVar) {
        }
    }

    public CaretString(@NotNull String str, int i, @NotNull CaretGravity caretGravity) {
        Intrinsics.checkParameterIsNotNull(str, Types.STRING);
        Intrinsics.checkParameterIsNotNull(caretGravity, "caretGravity");
        this.a = str;
        this.b = i;
        this.c = caretGravity;
    }

    @NotNull
    public static /* synthetic */ CaretString copy$default(CaretString caretString, String str, int i, CaretGravity caretGravity, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = caretString.a;
        }
        if ((i2 & 2) != 0) {
            i = caretString.b;
        }
        if ((i2 & 4) != 0) {
            caretGravity = caretString.c;
        }
        return caretString.copy(str, i, caretGravity);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final CaretGravity component3() {
        return this.c;
    }

    @NotNull
    public final CaretString copy(@NotNull String str, int i, @NotNull CaretGravity caretGravity) {
        Intrinsics.checkParameterIsNotNull(str, Types.STRING);
        Intrinsics.checkParameterIsNotNull(caretGravity, "caretGravity");
        return new CaretString(str, i, caretGravity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CaretString) {
                CaretString caretString = (CaretString) obj;
                if (Intrinsics.areEqual(this.a, caretString.a)) {
                    if (!(this.b == caretString.b) || !Intrinsics.areEqual(this.c, caretString.c)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final CaretGravity getCaretGravity() {
        return this.c;
    }

    public final int getCaretPosition() {
        return this.b;
    }

    @NotNull
    public final String getString() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b) * 31;
        CaretGravity caretGravity = this.c;
        if (caretGravity != null) {
            i = caretGravity.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public final CaretString reversed() {
        String str = this.a;
        if (str != null) {
            return new CaretString(StringsKt___StringsKt.reversed(str).toString(), this.a.length() - this.b, this.c);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CaretString(string=");
        L.append(this.a);
        L.append(", caretPosition=");
        L.append(this.b);
        L.append(", caretGravity=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}

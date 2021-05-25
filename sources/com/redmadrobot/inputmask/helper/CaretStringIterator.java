package com.redmadrobot.inputmask.helper;

import com.avito.android.remote.auth.AuthSource;
import com.redmadrobot.inputmask.model.CaretString;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "", "", "insertionAffectsCaret", "()Z", "deletionAffectsCaret", "", "next", "()Ljava/lang/Character;", "Lcom/redmadrobot/inputmask/model/CaretString;", AuthSource.SEND_ABUSE, "Lcom/redmadrobot/inputmask/model/CaretString;", "getCaretString", "()Lcom/redmadrobot/inputmask/model/CaretString;", "caretString", "", AuthSource.BOOKING_ORDER, "I", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "currentIndex", "<init>", "(Lcom/redmadrobot/inputmask/model/CaretString;I)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public class CaretStringIterator {
    @NotNull
    public final CaretString a;
    public int b;

    public CaretStringIterator(@NotNull CaretString caretString, int i) {
        Intrinsics.checkParameterIsNotNull(caretString, "caretString");
        this.a = caretString;
        this.b = i;
    }

    public boolean deletionAffectsCaret() {
        return this.b < this.a.getCaretPosition();
    }

    @NotNull
    public final CaretString getCaretString() {
        return this.a;
    }

    public final int getCurrentIndex() {
        return this.b;
    }

    public boolean insertionAffectsCaret() {
        CaretString.CaretGravity caretGravity = this.a.getCaretGravity();
        if (caretGravity instanceof CaretString.CaretGravity.BACKWARD) {
            if (this.b < this.a.getCaretPosition()) {
                return true;
            }
        } else if (!(caretGravity instanceof CaretString.CaretGravity.FORWARD)) {
            throw new NoWhenBranchMatchedException();
        } else if (this.b <= this.a.getCaretPosition()) {
            return true;
        } else {
            if (this.b == 0 && this.a.getCaretPosition() == 0) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public Character next() {
        if (this.b >= this.a.getString().length()) {
            return null;
        }
        String string = this.a.getString();
        if (string != null) {
            char[] charArray = string.toCharArray();
            Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
            int i = this.b;
            char c = charArray[i];
            this.b = i + 1;
            return Character.valueOf(c);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final void setCurrentIndex(int i) {
        this.b = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CaretStringIterator(CaretString caretString, int i, int i2, j jVar) {
        this(caretString, (i2 & 2) != 0 ? 0 : i);
    }
}

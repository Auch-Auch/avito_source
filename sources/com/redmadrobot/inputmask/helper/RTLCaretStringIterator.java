package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.model.CaretString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/redmadrobot/inputmask/helper/RTLCaretStringIterator;", "Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "", "insertionAffectsCaret", "()Z", "Lcom/redmadrobot/inputmask/model/CaretString;", "caretString", "<init>", "(Lcom/redmadrobot/inputmask/model/CaretString;)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public final class RTLCaretStringIterator extends CaretStringIterator {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RTLCaretStringIterator(@NotNull CaretString caretString) {
        super(caretString, 0, 2, null);
        Intrinsics.checkParameterIsNotNull(caretString, "caretString");
    }

    @Override // com.redmadrobot.inputmask.helper.CaretStringIterator
    public boolean insertionAffectsCaret() {
        return getCurrentIndex() <= getCaretString().getCaretPosition();
    }
}

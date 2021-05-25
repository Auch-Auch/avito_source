package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.model.CaretString;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "", "Lcom/redmadrobot/inputmask/helper/Mask;", "mask", "Lcom/redmadrobot/inputmask/model/CaretString;", "text", "", "calculateAffinityOfMask", "(Lcom/redmadrobot/inputmask/helper/Mask;Lcom/redmadrobot/inputmask/model/CaretString;)I", "<init>", "(Ljava/lang/String;I)V", "WHOLE_STRING", "PREFIX", "CAPACITY", "EXTRACTED_VALUE_CAPACITY", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public enum AffinityCalculationStrategy {
    WHOLE_STRING,
    PREFIX,
    CAPACITY,
    EXTRACTED_VALUE_CAPACITY;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AffinityCalculationStrategy.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
        }
    }

    public final int calculateAffinityOfMask(@NotNull Mask mask, @NotNull CaretString caretString) {
        String str;
        int i;
        int i2;
        Intrinsics.checkParameterIsNotNull(mask, "mask");
        Intrinsics.checkParameterIsNotNull(caretString, "text");
        int ordinal = ordinal();
        if (ordinal == 0) {
            return mask.apply(caretString).getAffinity();
        }
        boolean z = true;
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    i = mask.apply(caretString).getExtractedValue().length();
                    if (i > mask.totalValueLength()) {
                        return Integer.MIN_VALUE;
                    }
                    i2 = mask.totalValueLength();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (caretString.getString().length() > mask.totalTextLength()) {
                return Integer.MIN_VALUE;
            } else {
                i = caretString.getString().length();
                i2 = mask.totalTextLength();
            }
            return i - i2;
        }
        String string = mask.apply(caretString).getFormattedText().getString();
        String string2 = caretString.getString();
        if (!(string.length() == 0)) {
            if (string2.length() != 0) {
                z = false;
            }
            if (!z) {
                int i3 = 0;
                while (true) {
                    if (i3 < string.length() && i3 < string2.length()) {
                        if (string.charAt(i3) != string2.charAt(i3)) {
                            str = string.substring(0, i3);
                            Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
                str = string.substring(0, i3);
                Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return str.length();
            }
        }
        str = "";
        return str.length();
    }
}

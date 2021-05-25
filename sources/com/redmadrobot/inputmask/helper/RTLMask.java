package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.helper.Mask;
import com.redmadrobot.inputmask.model.CaretString;
import com.redmadrobot.inputmask.model.Notation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/redmadrobot/inputmask/helper/RTLMask;", "Lcom/redmadrobot/inputmask/helper/Mask;", "Lcom/redmadrobot/inputmask/model/CaretString;", "text", "Lcom/redmadrobot/inputmask/helper/Mask$Result;", "apply", "(Lcom/redmadrobot/inputmask/model/CaretString;)Lcom/redmadrobot/inputmask/helper/Mask$Result;", "Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "makeIterator", "(Lcom/redmadrobot/inputmask/model/CaretString;)Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "", "format", "", "Lcom/redmadrobot/inputmask/model/Notation;", "customNotations", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Factory", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public final class RTLMask extends Mask {
    public static final Factory Factory = new Factory(null);
    public static final Map<String, RTLMask> d = new HashMap();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/redmadrobot/inputmask/helper/RTLMask$Factory;", "", "", "format", "", "Lcom/redmadrobot/inputmask/model/Notation;", "customNotations", "Lcom/redmadrobot/inputmask/helper/RTLMask;", "getOrCreate", "(Ljava/lang/String;Ljava/util/List;)Lcom/redmadrobot/inputmask/helper/RTLMask;", "", "cache", "Ljava/util/Map;", "<init>", "()V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
    public static final class Factory {
        public Factory() {
        }

        @NotNull
        public final RTLMask getOrCreate(@NotNull String str, @NotNull List<Notation> list) {
            Intrinsics.checkParameterIsNotNull(str, "format");
            Intrinsics.checkParameterIsNotNull(list, "customNotations");
            RTLMask rTLMask = (RTLMask) RTLMask.d.get(RTLMaskKt.access$reversedFormat(str));
            if (rTLMask != null) {
                return rTLMask;
            }
            RTLMask rTLMask2 = new RTLMask(str, list);
            RTLMask.d.put(RTLMaskKt.access$reversedFormat(str), rTLMask2);
            return rTLMask2;
        }

        public Factory(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RTLMask(@NotNull String str, @NotNull List<Notation> list) {
        super(RTLMaskKt.access$reversedFormat(str), list);
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(list, "customNotations");
    }

    @Override // com.redmadrobot.inputmask.helper.Mask
    @NotNull
    public Mask.Result apply(@NotNull CaretString caretString) {
        Intrinsics.checkParameterIsNotNull(caretString, "text");
        return super.apply(caretString.reversed()).reversed();
    }

    @Override // com.redmadrobot.inputmask.helper.Mask
    @NotNull
    public CaretStringIterator makeIterator(@NotNull CaretString caretString) {
        Intrinsics.checkParameterIsNotNull(caretString, "text");
        return new RTLCaretStringIterator(caretString);
    }
}

package com.avito.android.util;

import android.widget.EditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a4\u0010\b\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/widget/EditText;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "value", "", "action", "watchText", "(Landroid/widget/EditText;Lkotlin/jvm/functions/Function1;)V", "android_release"}, k = 2, mv = {1, 4, 2})
public final class EditTextsKt {
    public static final void watchText(@NotNull EditText editText, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(editText, "$this$watchText");
        Intrinsics.checkNotNullParameter(function1, "action");
        editText.addTextChangedListener(new SimpleTextWatcher(function1) { // from class: com.avito.android.util.EditTextsKt$watchText$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(charSequence, "s");
                this.a.invoke(charSequence.toString());
            }
        });
    }
}

package com.avito.android.lib.design.input;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Builds;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0019\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a3\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\r*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a!\u0010\u0012\u001a\u00020\r*\u00020\f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0016\u001a\u00020\r*\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a)\u0010\u001b\u001a\u00020\r*\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a!\u0010\u001d\u001a\u00020\r*\u00020\f2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0019\u0010\u001f\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u001f\u0010 \u001a\u0019\u0010\"\u001a\u00020\r*\u00020\u00012\u0006\u0010!\u001a\u00020\r¢\u0006\u0004\b\"\u0010#\u001a'\u0010'\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0019H\u0002¢\u0006\u0004\b'\u0010(\u001aG\u0010.\u001a\u00020-*\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00192\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b.\u0010/\u001a\u001b\u00100\u001a\u00020\u0019*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b0\u00101\u001a\u0013\u00102\u001a\u00020\u0019*\u00020\u0001H\u0002¢\u0006\u0004\b2\u00103¨\u00064"}, d2 = {"Landroid/widget/EditText;", "Lcom/avito/android/lib/design/input/FormatterType;", "formatterType", "previousFormatterType", "", "prefixColor", "postfixColor", "Landroid/text/TextWatcher;", "afterMaskedTextChanged", "(Landroid/widget/EditText;Lcom/avito/android/lib/design/input/FormatterType;Lcom/avito/android/lib/design/input/FormatterType;II)Landroid/text/TextWatcher;", "getMaxLength", "(Landroid/widget/EditText;)I", "", "", "symbols", "removeAllSymbols", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "duplicateString", "removeDuplicateStringFromStart", "(Ljava/lang/CharSequence;Ljava/lang/String;Lcom/avito/android/lib/design/input/FormatterType;)Ljava/lang/String;", "", "list", "removePrefixStringsOnPasting", "(Ljava/lang/CharSequence;Ljava/util/List;)Ljava/lang/String;", "mask", "", "isReversed", "toMaskedString", "(Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/lib/design/input/FormatterType;)Ljava/lang/String;", "simpleMasked", "(Ljava/lang/CharSequence;Ljava/lang/String;Z)Ljava/lang/String;", "getMaskSymbolsCount", "(Ljava/lang/String;Ljava/lang/String;)I", "value", "deformatText", "(Lcom/avito/android/lib/design/input/FormatterType;Ljava/lang/String;)Ljava/lang/String;", "", "resultArray", "isReversedMask", AuthSource.SEND_ABUSE, "([CLjava/lang/String;Z)Ljava/lang/String;", "beforeValue", "selection", "maxLength", "hasFocus", "Lcom/avito/android/lib/design/input/FormattedResult;", "formatString", "(Lcom/avito/android/lib/design/input/FormatterType;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZLcom/avito/android/lib/design/input/FormatterType;)Lcom/avito/android/lib/design/input/FormattedResult;", "c", "(Ljava/lang/String;Lcom/avito/android/lib/design/input/FormatterType;)Z", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/lib/design/input/FormatterType;)Z", "components_release"}, k = 2, mv = {1, 4, 2})
public final class CustomMaskFormatterKt {
    public static final String a(char[] cArr, String str, boolean z) {
        String str2 = str;
        int i = 0;
        if (z) {
            if (str.length() > cArr.length) {
                str2 = str2.substring(str.length() - cArr.length, str.length());
                Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            int i2 = 0;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                int i3 = i2 + 1;
                if (i2 < cArr.length && charAt != '#') {
                    cArr[i2] = '#';
                }
                i++;
                i2 = i3;
            }
        } else {
            int i4 = 0;
            while (i < str.length()) {
                char charAt2 = str2.charAt(i);
                int i5 = i4 + 1;
                if (i4 < cArr.length && charAt2 != '#') {
                    cArr[i4] = '#';
                }
                i++;
                i4 = i5;
            }
        }
        return m.replace$default(ArraysKt___ArraysKt.joinToString$default(cArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), "#", "", false, 4, (Object) null);
    }

    @NotNull
    public static final TextWatcher afterMaskedTextChanged(@NotNull EditText editText, @NotNull FormatterType formatterType, @Nullable FormatterType formatterType2, int i, int i2) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(editText, "$this$afterMaskedTextChanged");
        Intrinsics.checkNotNullParameter(formatterType, "formatterType");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean z = false;
        booleanRef.element = false;
        Editable text = editText.getText();
        Intrinsics.checkNotNullExpressionValue(text, "this.text");
        if (text.length() == 0) {
            z = true;
        }
        if (z) {
            MaskParameters maskParameters = formatterType.getMaskParameters();
            if (maskParameters == null || (charSequence = maskParameters.getPrefix()) == null) {
                charSequence = "";
            }
            editText.setText(charSequence);
        }
        CustomMaskFormatterKt$afterMaskedTextChanged$textWatcher$1 customMaskFormatterKt$afterMaskedTextChanged$textWatcher$1 = new TextWatcher(editText, i, i2, formatterType, formatterType2, booleanRef) { // from class: com.avito.android.lib.design.input.CustomMaskFormatterKt$afterMaskedTextChanged$textWatcher$1
            @NotNull
            public EditText a;
            @NotNull
            public String b = "";
            public final /* synthetic */ EditText c;
            public final /* synthetic */ int d;
            public final /* synthetic */ int e;
            public final /* synthetic */ FormatterType f;
            public final /* synthetic */ FormatterType g;
            public final /* synthetic */ Ref.BooleanRef h;

            {
                this.c = r1;
                this.d = r2;
                this.e = r3;
                this.f = r4;
                this.g = r5;
                this.h = r6;
                this.a = r1;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence2, int i3, int i4, int i5) {
                String str;
                if (charSequence2 == null || (str = charSequence2.toString()) == null) {
                    str = "";
                }
                this.b = str;
            }

            @NotNull
            public final String getBeforeValue() {
                return this.b;
            }

            @NotNull
            public final EditText getEditText() {
                return this.a;
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence2, int i3, int i4, int i5) {
                if (charSequence2 != null) {
                    setMask(charSequence2, this.b);
                }
            }

            public final void setBeforeValue(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.b = str;
            }

            public final void setEditText(@NotNull EditText editText2) {
                Intrinsics.checkNotNullParameter(editText2, "<set-?>");
                this.a = editText2;
            }

            public final void setMask(@Nullable CharSequence charSequence2, @NotNull CharSequence charSequence3) {
                String postfix;
                String prefix;
                Intrinsics.checkNotNullParameter(charSequence3, "beforeValue");
                FormatterType formatterType3 = this.f;
                int selectionEnd = this.a.getSelectionEnd();
                int maxLength = CustomMaskFormatterKt.getMaxLength(this.c);
                boolean hasFocus = this.a.hasFocus();
                FormatterType formatterType4 = this.g;
                if (!(!this.h.element)) {
                    formatterType4 = null;
                }
                FormattedResult formatString = CustomMaskFormatterKt.formatString(formatterType3, charSequence2, charSequence3, selectionEnd, maxLength, hasFocus, formatterType4);
                if (this.a.isEnabled()) {
                    String formattedText = formatString.getFormattedText();
                    SpannableString spannableString = new SpannableString(formattedText);
                    if (!(formattedText.length() == 0)) {
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.d);
                        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(this.e);
                        ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(this.a.getTextColors().getColorForState(this.a.getDrawableState(), this.a.getCurrentTextColor()));
                        MaskParameters maskParameters2 = this.f.getMaskParameters();
                        int length = (maskParameters2 == null || (prefix = maskParameters2.getPrefix()) == null) ? 0 : prefix.length();
                        MaskParameters maskParameters3 = this.f.getMaskParameters();
                        int length2 = (maskParameters3 == null || (postfix = maskParameters3.getPostfix()) == null) ? 0 : postfix.length();
                        spannableString.setSpan(foregroundColorSpan, 0, length, 34);
                        spannableString.setSpan(foregroundColorSpan2, Math.max(formattedText.length() - length2, 0), formattedText.length(), 34);
                        spannableString.setSpan(foregroundColorSpan3, length, Math.max(formattedText.length() - length2, 0), 34);
                    }
                    this.a.removeTextChangedListener(this);
                    this.a.setText(spannableString);
                    this.a.addTextChangedListener(this);
                    this.a.setSelection(formatString.getFormatSelection());
                }
                this.h.element = true;
            }
        };
        editText.addTextChangedListener(customMaskFormatterKt$afterMaskedTextChanged$textWatcher$1);
        Editable text2 = editText.getText();
        Editable text3 = editText.getText();
        Intrinsics.checkNotNullExpressionValue(text3, "text");
        customMaskFormatterKt$afterMaskedTextChanged$textWatcher$1.setMask(text2, text3);
        return customMaskFormatterKt$afterMaskedTextChanged$textWatcher$1;
    }

    public static final boolean b(FormatterType formatterType) {
        return formatterType.getId() == FormatterType.Companion.getFLOATING_POINT().getId();
    }

    public static final boolean c(String str, FormatterType formatterType) {
        MaskParameters maskParameters = formatterType.getMaskParameters();
        Character valueOf = maskParameters != null ? Character.valueOf(maskParameters.getDecimalSeparator()) : null;
        return b(formatterType) && valueOf != null && StringsKt__StringsKt.startsWith$default(str, valueOf.charValue(), false, 2, null);
    }

    @NotNull
    public static final String deformatText(@NotNull FormatterType formatterType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(formatterType, "$this$deformatText");
        Intrinsics.checkNotNullParameter(str, "value");
        if (formatterType.getMaskParameters() == null) {
            return str;
        }
        String removeSuffix = StringsKt__StringsKt.removeSuffix(StringsKt__StringsKt.removePrefix(str, (CharSequence) formatterType.getMaskParameters().getPrefix()), (CharSequence) formatterType.getMaskParameters().getPostfix());
        Objects.requireNonNull(removeSuffix, "null cannot be cast to non-null type java.lang.String");
        char[] charArray = removeSuffix.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        if (!b(formatterType) || !ArraysKt___ArraysKt.contains(charArray, formatterType.getMaskParameters().getDecimalSeparator())) {
            return a(charArray, formatterType.getMaskParameters().getMask(), formatterType.getMaskParameters().isReversedMask());
        }
        int indexOf = ArraysKt___ArraysKt.indexOf(charArray, formatterType.getMaskParameters().getDecimalSeparator());
        return a.c3(a(CollectionsKt___CollectionsKt.toCharArray(ArraysKt___ArraysKt.take(charArray, indexOf)), formatterType.getMaskParameters().getMask(), formatterType.getMaskParameters().isReversedMask()), CollectionsKt___CollectionsKt.joinToString$default(ArraysKt___ArraysKt.takeLast(charArray, charArray.length - indexOf), "", null, null, 0, null, null, 62, null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0104, code lost:
        if ((r6.length() > 0) != false) goto L_0x0106;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0161  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.avito.android.lib.design.input.FormattedResult formatString(@org.jetbrains.annotations.NotNull com.avito.android.lib.design.input.FormatterType r25, @org.jetbrains.annotations.Nullable java.lang.CharSequence r26, @org.jetbrains.annotations.NotNull java.lang.CharSequence r27, int r28, int r29, boolean r30, @org.jetbrains.annotations.Nullable com.avito.android.lib.design.input.FormatterType r31) {
        /*
        // Method dump skipped, instructions count: 1198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.input.CustomMaskFormatterKt.formatString(com.avito.android.lib.design.input.FormatterType, java.lang.CharSequence, java.lang.CharSequence, int, int, boolean, com.avito.android.lib.design.input.FormatterType):com.avito.android.lib.design.input.FormattedResult");
    }

    public static /* synthetic */ FormattedResult formatString$default(FormatterType formatterType, CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, FormatterType formatterType2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            formatterType2 = null;
        }
        return formatString(formatterType, charSequence, charSequence2, i, i2, z, formatterType2);
    }

    public static final int getMaskSymbolsCount(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "$this$getMaskSymbolsCount");
        Intrinsics.checkNotNullParameter(str2, "mask");
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (StringsKt__StringsKt.contains$default((CharSequence) str2, str.charAt(i2), false, 2, (Object) null)) {
                i++;
            }
        }
        return i;
    }

    @SuppressLint({"NewApi"})
    public static final int getMaxLength(@NotNull EditText editText) {
        InputFilter.LengthFilter lengthFilter;
        Intrinsics.checkNotNullParameter(editText, "$this$getMaxLength");
        if (Builds.isAtLeastMarshmallow) {
            InputFilter[] filters = editText.getFilters();
            Intrinsics.checkNotNullExpressionValue(filters, "this.filters");
            int length = filters.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    lengthFilter = null;
                    break;
                }
                lengthFilter = filters[i];
                if (lengthFilter instanceof InputFilter.LengthFilter) {
                    break;
                }
                i++;
            }
            if (lengthFilter != null) {
                return lengthFilter.getMax();
            }
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    public static final String removeAllSymbols(@NotNull CharSequence charSequence, @NotNull String str) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$removeAllSymbols");
        Intrinsics.checkNotNullParameter(str, "symbols");
        String obj = charSequence.toString();
        Iterator<T> it = StringsKt___StringsKt.toSet(str).iterator();
        String str2 = obj;
        while (it.hasNext()) {
            str2 = m.replace$default(str2, String.valueOf(it.next().charValue()), "", false, 4, (Object) null);
        }
        return str2;
    }

    @NotNull
    public static final String removeDuplicateStringFromStart(@NotNull CharSequence charSequence, @NotNull String str, @NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$removeDuplicateStringFromStart");
        Intrinsics.checkNotNullParameter(str, "duplicateString");
        Intrinsics.checkNotNullParameter(formatterType, "formatterType");
        boolean z = true;
        if (str.length() == 0) {
            return charSequence.toString();
        }
        String obj = charSequence.toString();
        boolean z2 = false;
        while (m.startsWith$default(obj, str, false, 2, null)) {
            obj = StringsKt__StringsKt.removePrefix(obj, (CharSequence) str);
            z2 = true;
        }
        if (!z2) {
            return obj;
        }
        if (obj.length() != 0) {
            z = false;
        }
        return (z || c(obj, formatterType)) ? a.c3(str, obj) : obj;
    }

    @NotNull
    public static final String removePrefixStringsOnPasting(@NotNull CharSequence charSequence, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$removePrefixStringsOnPasting");
        Intrinsics.checkNotNullParameter(list, "list");
        String obj = charSequence.toString();
        for (T t : list) {
            if (m.startsWith$default(obj, t, false, 2, null)) {
                return StringsKt__StringsKt.removePrefix(obj, (CharSequence) t);
            }
        }
        return obj;
    }

    @NotNull
    public static final String simpleMasked(@NotNull CharSequence charSequence, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$simpleMasked");
        Intrinsics.checkNotNullParameter(str, "mask");
        int i = 0;
        String str2 = "";
        if (!z) {
            int i2 = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charSequence.length() > i2) {
                    if (charAt == '#') {
                        StringBuilder L = a.L(str2);
                        L.append(charSequence.charAt(i2));
                        str2 = L.toString();
                        i2++;
                    } else {
                        str2 = a.K2(str2, charAt);
                    }
                }
                i++;
            }
        } else {
            if (z) {
                str = StringsKt___StringsKt.reversed(str).toString();
            }
            int length = charSequence.length() - 1;
            while (i < str.length()) {
                char charAt2 = str.charAt(i);
                if (length < 0) {
                    return str2;
                }
                if (charAt2 == '#') {
                    char charAt3 = charSequence.charAt(length);
                    str2 = String.valueOf(charAt3) + str2;
                    length--;
                } else {
                    str2 = String.valueOf(charAt2) + str2;
                }
                i++;
            }
        }
        return str2;
    }

    @NotNull
    public static final String toMaskedString(@NotNull String str, @NotNull String str2, boolean z, @NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(str, "$this$toMaskedString");
        Intrinsics.checkNotNullParameter(str2, "mask");
        Intrinsics.checkNotNullParameter(formatterType, "formatterType");
        if (formatterType.getId() != FormatterType.Companion.getFLOATING_POINT().getId()) {
            return simpleMasked(str, str2, z);
        }
        MaskParameters maskParameters = formatterType.getMaskParameters();
        Character valueOf = maskParameters != null ? Character.valueOf(maskParameters.getDecimalSeparator()) : null;
        if (valueOf == null || !StringsKt__StringsKt.contains$default((CharSequence) str, valueOf.charValue(), false, 2, (Object) null)) {
            return simpleMasked(str, str2, z);
        }
        String simpleMasked = simpleMasked(StringsKt__StringsKt.substringBefore$default(str, valueOf.charValue(), (String) null, 2, (Object) null), str2, true);
        String substringAfter$default = StringsKt__StringsKt.substringAfter$default(str, valueOf.charValue(), (String) null, 2, (Object) null);
        MaskParameters maskParameters2 = formatterType.getMaskParameters();
        int decimalPlaces = maskParameters2 != null ? maskParameters2.getDecimalPlaces() : Integer.MAX_VALUE;
        if (decimalPlaces < substringAfter$default.length()) {
            substringAfter$default = substringAfter$default.substring(0, decimalPlaces);
            Intrinsics.checkNotNullExpressionValue(substringAfter$default, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return simpleMasked + valueOf + substringAfter$default;
    }
}

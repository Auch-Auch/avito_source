package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.MaskInfo;
import com.avito.android.util.preferences.db_preferences.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BH\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012'\b\u0002\u0010\u001f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017¢\u0006\u0004\b \u0010!J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J!\u0010\u0006\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0006\u0010\nJ!\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R5\u0010\u001f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/util/MasksFormatterImpl;", "Lcom/avito/android/util/MasksFormatter;", "", "value", "filterUnconstrainedLetters", "(Ljava/lang/String;)Ljava/lang/String;", "format", "", "cursorPosition", "Lcom/avito/android/util/CursorString;", "(Ljava/lang/String;I)Lcom/avito/android/util/CursorString;", Types.STRING, "", "applyUnconstrainedLetters", AuthSource.SEND_ABUSE, "(Lcom/avito/android/util/CursorString;Z)Lcom/avito/android/util/CursorString;", AuthSource.BOOKING_ORDER, "Z", "forceUppercaseSymbols", "", "Lcom/avito/android/remote/model/category_parameters/MaskInfo;", "Ljava/util/List;", "masks", "Lkotlin/Function1;", "Lcom/avito/android/util/MaskApplyingResult;", "Lkotlin/ParameterName;", "name", "result", "", "c", "Lkotlin/jvm/functions/Function1;", "formatResultListener", "<init>", "(Ljava/util/List;ZLkotlin/jvm/functions/Function1;)V", "formatters_release"}, k = 1, mv = {1, 4, 2})
public final class MasksFormatterImpl implements MasksFormatter {
    public final List<MaskInfo> a;
    public final boolean b;
    public final Function1<MaskApplyingResult, Unit> c;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.util.MaskApplyingResult, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public MasksFormatterImpl(@NotNull List<MaskInfo> list, boolean z, @Nullable Function1<? super MaskApplyingResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "masks");
        this.a = list;
        this.b = z;
        this.c = function1;
    }

    public final CursorString a(CursorString cursorString, boolean z) {
        String str;
        Object obj;
        String str2;
        Object obj2 = null;
        if (cursorString.getValue().length() == 0) {
            Function1<MaskApplyingResult, Unit> function1 = this.c;
            if (function1 != null) {
                function1.invoke(null);
            }
            return cursorString;
        } else if (this.a.isEmpty()) {
            return cursorString;
        } else {
            if (this.b) {
                String value = cursorString.getValue();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                Objects.requireNonNull(value, "null cannot be cast to non-null type java.lang.String");
                str = value.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toUpperCase(locale)");
            } else {
                str = cursorString.getValue();
            }
            List<MaskInfo> list = this.a;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                T next = it.next();
                int cursorPosition = cursorString.getCursorPosition();
                StringBuilder sb = new StringBuilder(next.getMask().length());
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                boolean z2 = false;
                while (i <= StringsKt__StringsKt.getLastIndex(str) && i2 <= StringsKt__StringsKt.getLastIndex(next.getMask())) {
                    char charAt = next.getMask().charAt(i2);
                    char charAt2 = str.charAt(i);
                    if (next.isConstrainedPlaceholder(charAt)) {
                        if (next.isCharacterMatchesToConstraints(charAt, charAt2)) {
                            sb.append(charAt2);
                            i2++;
                        } else if (!z2) {
                            i3 = i;
                            z2 = true;
                        }
                        i++;
                    } else {
                        if (z) {
                            sb.append(charAt);
                            if (charAt2 == charAt) {
                                i++;
                            } else if (cursorPosition > i) {
                                i4++;
                            }
                        }
                        i2++;
                    }
                }
                if (!z2) {
                    i3 = str.length();
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                arrayList.add(new MaskApplyingResult(str, next, sb2, cursorPosition + i4, i3));
            }
            int cursorPosition2 = cursorString.getCursorPosition();
            Iterator it2 = arrayList.iterator();
            if (!it2.hasNext()) {
                obj = null;
            } else {
                obj = it2.next();
                if (it2.hasNext()) {
                    int matchedStartLength = ((MaskApplyingResult) obj).getMatchedStartLength();
                    do {
                        Object next2 = it2.next();
                        int matchedStartLength2 = ((MaskApplyingResult) next2).getMatchedStartLength();
                        if (matchedStartLength < matchedStartLength2) {
                            obj = next2;
                            matchedStartLength = matchedStartLength2;
                        }
                    } while (it2.hasNext());
                }
            }
            MaskApplyingResult maskApplyingResult = (MaskApplyingResult) obj;
            int matchedStartLength3 = maskApplyingResult != null ? maskApplyingResult.getMatchedStartLength() : 0;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : arrayList) {
                if (((MaskApplyingResult) obj3).getMatchedStartLength() == matchedStartLength3) {
                    arrayList2.add(obj3);
                }
            }
            Iterator it3 = arrayList2.iterator();
            if (it3.hasNext()) {
                obj2 = it3.next();
                if (it3.hasNext()) {
                    int length = ((MaskApplyingResult) obj2).getResultText().length();
                    do {
                        Object next3 = it3.next();
                        int length2 = ((MaskApplyingResult) next3).getResultText().length();
                        if (length < length2) {
                            obj2 = next3;
                            length = length2;
                        }
                    } while (it3.hasNext());
                }
            }
            MaskApplyingResult maskApplyingResult2 = (MaskApplyingResult) obj2;
            Function1<MaskApplyingResult, Unit> function12 = this.c;
            if (function12 != null) {
                function12.invoke(maskApplyingResult2);
            }
            if (maskApplyingResult2 == null || (str2 = maskApplyingResult2.getResultText()) == null) {
                str2 = "";
            }
            if (maskApplyingResult2 != null) {
                cursorPosition2 = maskApplyingResult2.getCursorPosition();
            }
            return new CursorString(str2, cursorPosition2);
        }
    }

    @Override // com.avito.android.util.MasksFormatter
    @NotNull
    public String filterUnconstrainedLetters(@Nullable String str) {
        return str != null ? a(new CursorString(str, 0), false).getValue() : "";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MasksFormatterImpl(List list, boolean z, Function1 function1, int i, j jVar) {
        this(list, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : function1);
    }

    @Override // com.avito.android.util.PositionFormatter
    @NotNull
    public String format(@Nullable String str) {
        return str != null ? format(str, 0).getValue() : "";
    }

    @Override // com.avito.android.util.PositionFormatter
    @NotNull
    public CursorString format(@Nullable String str, int i) {
        if (str != null) {
            return a(new CursorString(str, i), true);
        }
        return new CursorString("", 0);
    }
}

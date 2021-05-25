package com.redmadrobot.inputmask.helper;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.advert.item.AdvertDetailsPresenterKt;
import com.avito.android.remote.auth.AuthSource;
import com.redmadrobot.inputmask.helper.Compiler;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/redmadrobot/inputmask/helper/FormatSanitizer;", "", "", "formatString", "sanitize", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public final class FormatSanitizer {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('[' char), (r15v5 char)] */
    @NotNull
    public final String sanitize(@NotNull String str) throws Compiler.FormatError {
        String str2;
        Iterator it;
        String str3;
        String str4;
        String str5;
        int i;
        String str6;
        int i2;
        Object obj;
        boolean z;
        Intrinsics.checkParameterIsNotNull(str, "formatString");
        String str7 = "null cannot be cast to non-null type java.lang.String";
        if (str != null) {
            char[] charArray = str.toCharArray();
            Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
            int length = charArray.length;
            boolean z2 = false;
            int i3 = 0;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            while (true) {
                char c = '{';
                char c2 = '[';
                if (i3 < length) {
                    char c3 = charArray[i3];
                    if ('\\' == c3) {
                        z3 = !z3;
                    } else {
                        if ('[' == c3) {
                            if (!z4) {
                                z4 = !z3;
                            } else {
                                throw new Compiler.FormatError();
                            }
                        }
                        if (']' == c3 && !z3) {
                            z4 = false;
                        }
                        if ('{' == c3) {
                            if (!z5) {
                                z5 = !z3;
                            } else {
                                throw new Compiler.FormatError();
                            }
                        }
                        if ('}' == c3 && !z3) {
                            z5 = false;
                        }
                        z3 = false;
                    }
                    i3++;
                } else {
                    ArrayList arrayList = new ArrayList();
                    char[] charArray2 = str.toCharArray();
                    Intrinsics.checkExpressionValueIsNotNull(charArray2, "(this as java.lang.String).toCharArray()");
                    int length2 = charArray2.length;
                    String str8 = "";
                    int i4 = 0;
                    boolean z7 = false;
                    String str9 = str8;
                    while (i4 < length2) {
                        char c4 = charArray2[i4];
                        if ('\\' != c4 || z7) {
                            if (('[' == c4 || c == c4) && !z7) {
                                if (str9.length() > 0) {
                                    arrayList.add(str9);
                                }
                                str9 = str8;
                            }
                            str9 = a.K2(str9, c4);
                            if ((']' == c4 || '}' == c4) && !z7) {
                                arrayList.add(str9);
                                str9 = str8;
                            }
                            z7 = false;
                        } else {
                            str9 = a.K2(str9, c4);
                            z7 = true;
                        }
                        i4++;
                        c = '{';
                    }
                    if (!(str9.length() == 0)) {
                        arrayList.add(str9);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        String str10 = (String) it2.next();
                        if (m.startsWith$default(str10, "[", z2, 2, null)) {
                            int length3 = str10.length();
                            String str11 = str8;
                            int i5 = z2;
                            while (true) {
                                if (i5 >= length3) {
                                    str3 = str7;
                                    it = it2;
                                    str4 = str8;
                                    break;
                                }
                                char charAt = str10.charAt(i5 == true ? 1 : 0);
                                if (charAt == c2) {
                                    str11 = a.K2(str11, charAt);
                                    str5 = str7;
                                    it = it2;
                                    str4 = str8;
                                    i = length3;
                                } else {
                                    if (charAt == ']') {
                                        it = it2;
                                        str4 = str8;
                                        i = length3;
                                        if (!m.endsWith$default(str11, "\\", false, 2, null)) {
                                            arrayList2.add(str11 + charAt);
                                            str3 = str7;
                                            break;
                                        }
                                    } else {
                                        it = it2;
                                        str4 = str8;
                                        i = length3;
                                    }
                                    if (charAt == '0' || charAt == '9') {
                                        str5 = str7;
                                        if (StringsKt__StringsKt.contains$default((CharSequence) str11, (CharSequence) ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str11, (CharSequence) AuthSource.SEND_ABUSE, false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str11, (CharSequence) "-", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str11, (CharSequence) "_", false, 2, (Object) null)) {
                                            arrayList2.add(str11 + "]");
                                            StringBuilder sb = new StringBuilder();
                                            sb.append('[');
                                            sb.append(charAt);
                                            str6 = sb.toString();
                                            str11 = str6;
                                        } else {
                                            obj = null;
                                            i2 = 2;
                                        }
                                    } else {
                                        obj = null;
                                        i2 = 2;
                                        str5 = str7;
                                    }
                                    if (charAt == 'A' || charAt == 'a') {
                                        z = false;
                                        if (StringsKt__StringsKt.contains$default((CharSequence) str11, (CharSequence) "0", false, i2, obj) || StringsKt__StringsKt.contains$default((CharSequence) str11, (CharSequence) AdvertDetailsPresenterKt.AUTO_CATEGORY_ID, false, i2, obj) || StringsKt__StringsKt.contains$default((CharSequence) str11, (CharSequence) "-", false, i2, obj) || StringsKt__StringsKt.contains$default((CharSequence) str11, (CharSequence) "_", false, i2, obj)) {
                                            arrayList2.add(str11 + "]");
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append('[');
                                            sb2.append(charAt);
                                            str6 = sb2.toString();
                                            str11 = str6;
                                        }
                                    } else {
                                        z = false;
                                    }
                                    if ((charAt == '-' || charAt == '_') && (StringsKt__StringsKt.contains$default(str11, "0", z, i2, obj) || StringsKt__StringsKt.contains$default(str11, AdvertDetailsPresenterKt.AUTO_CATEGORY_ID, z, i2, obj) || StringsKt__StringsKt.contains$default(str11, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, z, i2, obj) || StringsKt__StringsKt.contains$default(str11, AuthSource.SEND_ABUSE, z, i2, obj))) {
                                        arrayList2.add(str11 + "]");
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append('[');
                                        sb3.append(charAt);
                                        str6 = sb3.toString();
                                    } else {
                                        str6 = a.K2(str11, charAt);
                                    }
                                    str11 = str6;
                                }
                                c2 = '[';
                                it2 = it;
                                str8 = str4;
                                length3 = i;
                                str7 = str5;
                                i5++;
                            }
                        } else {
                            str3 = str7;
                            it = it2;
                            str4 = str8;
                            arrayList2.add(str10);
                        }
                        z2 = false;
                        c2 = '[';
                        it2 = it;
                        str8 = str4;
                        str7 = str3;
                    }
                    String str12 = str7;
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        String str13 = (String) it3.next();
                        if (m.startsWith$default(str13, "[", false, 2, null)) {
                            if (StringsKt__StringsKt.contains$default((CharSequence) str13, (CharSequence) "0", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str13, (CharSequence) AdvertDetailsPresenterKt.AUTO_CATEGORY_ID, false, 2, (Object) null)) {
                                str2 = str12;
                                StringBuilder L = a.L("[");
                                String replace$default = m.replace$default(m.replace$default(str13, "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
                                if (replace$default != null) {
                                    char[] charArray3 = replace$default.toCharArray();
                                    Intrinsics.checkExpressionValueIsNotNull(charArray3, "(this as java.lang.String).toCharArray()");
                                    str13 = a.t(L, CollectionsKt___CollectionsKt.joinToString$default(ArraysKt___ArraysKt.sorted(charArray3), "", null, null, 0, null, null, 62, null), "]");
                                    arrayList3.add(str13);
                                    str12 = str2;
                                } else {
                                    throw new TypeCastException(str2);
                                }
                            } else if (StringsKt__StringsKt.contains$default((CharSequence) str13, (CharSequence) AuthSource.SEND_ABUSE, false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str13, (CharSequence) ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, false, 2, (Object) null)) {
                                str2 = str12;
                                StringBuilder L2 = a.L("[");
                                String replace$default2 = m.replace$default(m.replace$default(str13, "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
                                if (replace$default2 != null) {
                                    char[] charArray4 = replace$default2.toCharArray();
                                    Intrinsics.checkExpressionValueIsNotNull(charArray4, "(this as java.lang.String).toCharArray()");
                                    str13 = a.t(L2, CollectionsKt___CollectionsKt.joinToString$default(ArraysKt___ArraysKt.sorted(charArray4), "", null, null, 0, null, null, 62, null), "]");
                                    arrayList3.add(str13);
                                    str12 = str2;
                                } else {
                                    throw new TypeCastException(str2);
                                }
                            } else {
                                StringBuilder L3 = a.L("[");
                                String replace$default3 = m.replace$default(m.replace$default(m.replace$default(m.replace$default(str13, "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null), "_", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, false, 4, (Object) null), "-", AuthSource.SEND_ABUSE, false, 4, (Object) null);
                                if (replace$default3 != null) {
                                    char[] charArray5 = replace$default3.toCharArray();
                                    Intrinsics.checkExpressionValueIsNotNull(charArray5, "(this as java.lang.String).toCharArray()");
                                    str13 = m.replace$default(m.replace$default(a.t(L3, CollectionsKt___CollectionsKt.joinToString$default(ArraysKt___ArraysKt.sorted(charArray5), "", null, null, 0, null, null, 62, null), "]"), ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "_", false, 4, (Object) null), AuthSource.SEND_ABUSE, "-", false, 4, (Object) null);
                                } else {
                                    throw new TypeCastException(str12);
                                }
                            }
                        }
                        str2 = str12;
                        arrayList3.add(str13);
                        str12 = str2;
                    }
                    return CollectionsKt___CollectionsKt.joinToString$default(arrayList3, "", null, null, 0, null, null, 62, null);
                }
            }
        } else {
            throw new TypeCastException(str7);
        }
    }
}

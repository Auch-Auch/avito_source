package a2.a.a.s2.a;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Comparator<String> {
    public static final a a = new a();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        String str3 = str;
        Intrinsics.checkNotNullExpressionValue(str3, "o1");
        return str2.compareTo(str3);
    }
}

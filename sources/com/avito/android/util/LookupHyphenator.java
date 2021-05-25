package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import com.bluejamesbond.text.hyphen.IHyphenator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/LookupHyphenator;", "Lcom/bluejamesbond/text/hyphen/IHyphenator;", "", "lookup", "", "setLookup", "(Ljava/lang/String;)V", "word", "", "hyphenate", "(Ljava/lang/String;)Ljava/util/List;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/List;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class LookupHyphenator implements IHyphenator {
    public List<String> a = CollectionsKt__CollectionsKt.emptyList();

    public final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!(charAt == 173)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    @Override // com.bluejamesbond.text.hyphen.IHyphenator
    @NotNull
    public List<String> hyphenate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "word");
        List<String> list = this.a;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        Iterator it2 = arrayList.iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            } else if (m.equals((String) it2.next(), str, true)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) this.a.get(i), new char[]{173}, false, 0, 6, (Object) null);
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(split$default, 10));
        for (String str2 : split$default) {
            arrayList2.add(a(str2));
        }
        return arrayList2;
    }

    public final void setLookup(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "lookup");
        this.a = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{' '}, false, 0, 6, (Object) null);
    }
}

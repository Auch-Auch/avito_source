package com.avito.android.serp;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/serp/InlineFiltersParametersKeyWrapper;", "Lkotlin/Function1;", "", "key", "invoke", "(Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/text/Regex;", AuthSource.BOOKING_ORDER, "Lkotlin/text/Regex;", "paramsRegularExp", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "paramsName", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersParametersKeyWrapper implements Function1<String, String> {
    public final String a = "params";
    public final Regex b = new Regex(a.e3("\\b(", "params", "\\[[a-zA-Z0-9+-_]+])"));

    @NotNull
    public String invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (Regex.find$default(this.b, str, 0, 2, null) != null) {
            return m.replace$default(str, this.a, a.s(a.L("parameters["), this.a, ']'), false, 4, (Object) null);
        }
        return a.d3("parameters[", str, ']');
    }
}

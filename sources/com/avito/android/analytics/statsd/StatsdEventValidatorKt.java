package com.avito.android.analytics.statsd;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001d\u0010\u0005\u001a\u00020\u00008@@\u0000X\u0002¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lkotlin/text/Regex;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getInvalidStatsdSymbols", "()Lkotlin/text/Regex;", "invalidStatsdSymbols", "analytics-statsd_release"}, k = 2, mv = {1, 4, 2})
public final class StatsdEventValidatorKt {
    @NotNull
    public static final Lazy a = c.lazy(a.a);

    public static final class a extends Lambda implements Function0<Regex> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Regex invoke() {
            return new Regex("\\W+");
        }
    }

    @NotNull
    public static final Regex getInvalidStatsdSymbols() {
        return (Regex) a.getValue();
    }
}

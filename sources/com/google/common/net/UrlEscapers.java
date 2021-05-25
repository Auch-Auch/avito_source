package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
@GwtCompatible
public final class UrlEscapers {
    public static final Escaper a = new PercentEscaper("-_.*", true);
    public static final Escaper b = new PercentEscaper("-._~!$'()*,;&=@:+", false);
    public static final Escaper c = new PercentEscaper("-._~!$'()*,;&=@:+/?", false);

    public static Escaper urlFormParameterEscaper() {
        return a;
    }

    public static Escaper urlFragmentEscaper() {
        return c;
    }

    public static Escaper urlPathSegmentEscaper() {
        return b;
    }
}

package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
@GwtCompatible
public abstract class Escaper {
    public final Function<String, String> a = new a();

    public class a implements Function<String, String> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Function
        public String apply(String str) {
            return Escaper.this.escape(str);
        }
    }

    public final Function<String, String> asFunction() {
        return this.a;
    }

    public abstract String escape(String str);
}

package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
@Beta
@GwtCompatible
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY('!', '?');
    
    public final char a;
    public final char b;

    /* access modifiers changed from: public */
    PublicSuffixType(char c2, char c3) {
        this.a = c2;
        this.b = c3;
    }
}

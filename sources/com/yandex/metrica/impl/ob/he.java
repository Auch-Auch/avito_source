package com.yandex.metrica.impl.ob;

import java.util.Collections;
import java.util.List;
public class he<BaseHandler> extends hf<BaseHandler> {
    private final List<BaseHandler> a;

    public he(List<BaseHandler> list) {
        this.a = Collections.unmodifiableList(list);
    }

    @Override // com.yandex.metrica.impl.ob.hf
    public List<? extends BaseHandler> a() {
        return this.a;
    }
}

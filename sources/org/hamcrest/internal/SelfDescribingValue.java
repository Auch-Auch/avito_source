package org.hamcrest.internal;

import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;
public class SelfDescribingValue<T> implements SelfDescribing {
    public T a;

    public SelfDescribingValue(T t) {
        this.a = t;
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendValue(this.a);
    }
}

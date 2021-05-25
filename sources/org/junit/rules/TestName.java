package org.junit.rules;

import org.junit.runner.Description;
public class TestName extends TestWatcher {
    public volatile String a;

    public String getMethodName() {
        return this.a;
    }

    @Override // org.junit.rules.TestWatcher
    public void starting(Description description) {
        this.a = description.getMethodName();
    }
}

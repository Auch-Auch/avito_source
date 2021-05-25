package org.junit.runners.model;
public interface MemberValueConsumer<T> {
    void accept(FrameworkMember<?> frameworkMember, T t);
}

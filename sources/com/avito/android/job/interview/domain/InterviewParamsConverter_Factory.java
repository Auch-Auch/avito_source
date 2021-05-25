package com.avito.android.job.interview.domain;

import dagger.internal.Factory;
public final class InterviewParamsConverter_Factory implements Factory<InterviewParamsConverter> {

    public static final class a {
        public static final InterviewParamsConverter_Factory a = new InterviewParamsConverter_Factory();
    }

    public static InterviewParamsConverter_Factory create() {
        return a.a;
    }

    public static InterviewParamsConverter newInstance() {
        return new InterviewParamsConverter();
    }

    @Override // javax.inject.Provider
    public InterviewParamsConverter get() {
        return newInstance();
    }
}

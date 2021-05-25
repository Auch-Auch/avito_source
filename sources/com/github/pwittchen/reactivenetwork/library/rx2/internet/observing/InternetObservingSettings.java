package com.github.pwittchen.reactivenetwork.library.rx2.internet.observing;

import com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.error.DefaultErrorHandler;
import com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.error.ErrorHandler;
import com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.strategy.WalledGardenInternetObservingStrategy;
public final class InternetObservingSettings {
    public final int a;
    public final int b;
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final ErrorHandler g;
    public final InternetObservingStrategy h;

    public InternetObservingSettings() {
        this(builder());
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static InternetObservingSettings create() {
        return new Builder(null).build();
    }

    public ErrorHandler errorHandler() {
        return this.g;
    }

    public String host() {
        return this.c;
    }

    public int httpResponse() {
        return this.f;
    }

    public int initialInterval() {
        return this.a;
    }

    public int interval() {
        return this.b;
    }

    public int port() {
        return this.d;
    }

    public InternetObservingStrategy strategy() {
        return this.h;
    }

    public int timeout() {
        return this.e;
    }

    public InternetObservingSettings(Builder builder) {
        int i = builder.a;
        int i2 = builder.b;
        String str = builder.c;
        int i3 = builder.d;
        int i4 = builder.e;
        int i5 = builder.f;
        ErrorHandler errorHandler = builder.g;
        InternetObservingStrategy internetObservingStrategy = builder.h;
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = errorHandler;
        this.h = internetObservingStrategy;
    }

    public static final class Builder {
        public int a = 0;
        public int b = 2000;
        public String c = "http://clients3.google.com/generate_204";
        public int d = 80;
        public int e = 2000;
        public int f = 204;
        public ErrorHandler g = new DefaultErrorHandler();
        public InternetObservingStrategy h = new WalledGardenInternetObservingStrategy();

        public Builder() {
        }

        public InternetObservingSettings build() {
            return new InternetObservingSettings(this);
        }

        public Builder errorHandler(ErrorHandler errorHandler) {
            this.g = errorHandler;
            return this;
        }

        public Builder host(String str) {
            this.c = str;
            return this;
        }

        public Builder httpResponse(int i) {
            this.f = i;
            return this;
        }

        public Builder initialInterval(int i) {
            this.a = i;
            return this;
        }

        public Builder interval(int i) {
            this.b = i;
            return this;
        }

        public Builder port(int i) {
            this.d = i;
            return this;
        }

        public Builder strategy(InternetObservingStrategy internetObservingStrategy) {
            this.h = internetObservingStrategy;
            return this;
        }

        public Builder timeout(int i) {
            this.e = i;
            return this;
        }

        public Builder(a aVar) {
        }
    }
}

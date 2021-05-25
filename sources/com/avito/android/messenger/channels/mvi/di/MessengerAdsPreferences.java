package com.avito.android.messenger.channels.mvi.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Qualifier
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/MessengerAdsPreferences;", "", "<init>", "()V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention
public @interface MessengerAdsPreferences {
    @NotNull
    public static final String BANNER_HIDDEN_TIMESTAMP = "banner_hidden_timestamp";
    @NotNull
    public static final String BANNER_SHOWN_TIMESTAMP = "banner_shown_timestamp";
    @NotNull
    public static final Companion Companion = Companion.a;
    public static final long DEFAULT_TIMESTAMP_VALUE = -1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/MessengerAdsPreferences$Companion;", "", "", "BANNER_HIDDEN_TIMESTAMP", "Ljava/lang/String;", "BANNER_SHOWN_TIMESTAMP", "", "DEFAULT_TIMESTAMP_VALUE", "J", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static final String BANNER_HIDDEN_TIMESTAMP = "banner_hidden_timestamp";
        @NotNull
        public static final String BANNER_SHOWN_TIMESTAMP = "banner_shown_timestamp";
        public static final long DEFAULT_TIMESTAMP_VALUE = -1;
        public static final /* synthetic */ Companion a = new Companion();
    }
}

package com.avito.android.di.module;

import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.date_time_formatter.DateTimeFormatterImpl;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProvider;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl;
import com.avito.android.server_time.TimeSource;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/avito/android/di/module/DateTimeFormatterModule;", "", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProvider;", "resourceProvider", "Ljava/util/Locale;", "locale", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "provideUpperCaseDateTimeFormatter", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProvider;Ljava/util/Locale;)Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "provideLowerCaseDateTimeFormatter", "<init>", "()V", "Declarations", "LowerCase", "UpperCase", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class DateTimeFormatterModule {
    @NotNull
    public static final DateTimeFormatterModule INSTANCE = new DateTimeFormatterModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/DateTimeFormatterModule$Declarations;", "", "Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProviderImpl;", "provicer", "Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProvider;", "bindDateTimeFormatterResourceProvider", "(Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProviderImpl;)Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProvider;", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        DateTimeFormatterResourceProvider bindDateTimeFormatterResourceProvider(@NotNull DateTimeFormatterResourceProviderImpl dateTimeFormatterResourceProviderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/DateTimeFormatterModule$LowerCase;", "", "<init>", "()V", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface LowerCase {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/DateTimeFormatterModule$UpperCase;", "", "<init>", "()V", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface UpperCase {
    }

    @Provides
    @JvmStatic
    @NotNull
    @LowerCase
    public static final DateTimeFormatter provideLowerCaseDateTimeFormatter(@NotNull TimeSource timeSource, @NotNull DateTimeFormatterResourceProvider dateTimeFormatterResourceProvider, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(dateTimeFormatterResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new DateTimeFormatterImpl(timeSource, dateTimeFormatterResourceProvider, locale, 0);
    }

    @Provides
    @JvmStatic
    @UpperCase
    @NotNull
    public static final DateTimeFormatter provideUpperCaseDateTimeFormatter(@NotNull TimeSource timeSource, @NotNull DateTimeFormatterResourceProvider dateTimeFormatterResourceProvider, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(dateTimeFormatterResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new DateTimeFormatterImpl(timeSource, dateTimeFormatterResourceProvider, locale, 1);
    }
}

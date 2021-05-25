package com.avito.android.util;

import android.text.TextWatcher;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/avito/android/util/PhoneNumberFormatterModule;", "", "Lcom/avito/android/util/Formatter;", "", "providePhoneNumberFormatter", "()Lcom/avito/android/util/Formatter;", "provideNationalPhoneNumberFormatterWithCountryCode", "providePhoneNumberFormatterWithCountryCode", "formatter", "Landroid/text/TextWatcher;", "providePhoneNumberFormatterTextWatcher", "(Lcom/avito/android/util/Formatter;)Landroid/text/TextWatcher;", "providePhoneNumberFormatterTextWatcherWithCountryCode", "<init>", "()V", "NationalPhoneNumberFormatter", "PhoneNumberFormatter", "PhoneNumberFormatterWithCountryCode", "formatters_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PhoneNumberFormatterModule {
    @NotNull
    public static final PhoneNumberFormatterModule INSTANCE = new PhoneNumberFormatterModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/util/PhoneNumberFormatterModule$NationalPhoneNumberFormatter;", "", "<init>", "()V", "formatters_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface NationalPhoneNumberFormatter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/util/PhoneNumberFormatterModule$PhoneNumberFormatter;", "", "<init>", "()V", "formatters_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface PhoneNumberFormatter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/util/PhoneNumberFormatterModule$PhoneNumberFormatterWithCountryCode;", "", "<init>", "()V", "formatters_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface PhoneNumberFormatterWithCountryCode {
    }

    @Provides
    @JvmStatic
    @NotNull
    @NationalPhoneNumberFormatter
    public static final Formatter<String> provideNationalPhoneNumberFormatterWithCountryCode() {
        return new RussianPhoneNumberFormatter(false, true);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PhoneNumberFormatter
    public static final Formatter<String> providePhoneNumberFormatter() {
        return new RussianPhoneNumberFormatter(false, false);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PhoneNumberFormatter
    public static final TextWatcher providePhoneNumberFormatterTextWatcher(@PhoneNumberFormatter @NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        return new PositionFormatterTextWatcher((PositionFormatter) formatter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PhoneNumberFormatterWithCountryCode
    public static final TextWatcher providePhoneNumberFormatterTextWatcherWithCountryCode(@PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        return new PositionFormatterTextWatcher((PositionFormatter) formatter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PhoneNumberFormatterWithCountryCode
    public static final Formatter<String> providePhoneNumberFormatterWithCountryCode() {
        return new RussianPhoneNumberFormatter(true, true);
    }
}

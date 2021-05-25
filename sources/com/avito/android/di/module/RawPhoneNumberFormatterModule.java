package com.avito.android.di.module;

import com.avito.android.util.Formatter;
import com.avito.android.util.RawPhoneNumberFormatter;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/di/module/RawPhoneNumberFormatterModule;", "", "Lcom/avito/android/util/Formatter;", "", "provideRawPhoneNumberFormatter", "()Lcom/avito/android/util/Formatter;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class RawPhoneNumberFormatterModule {
    @Provides
    @RawPhoneNumber
    @NotNull
    public final Formatter<String> provideRawPhoneNumberFormatter() {
        return new RawPhoneNumberFormatter();
    }
}

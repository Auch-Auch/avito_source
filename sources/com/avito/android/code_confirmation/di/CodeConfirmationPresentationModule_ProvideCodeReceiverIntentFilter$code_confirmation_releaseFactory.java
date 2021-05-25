package com.avito.android.code_confirmation.di;

import android.content.IntentFilter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CodeConfirmationPresentationModule_ProvideCodeReceiverIntentFilter$code_confirmation_releaseFactory implements Factory<IntentFilter> {

    public static final class a {
        public static final CodeConfirmationPresentationModule_ProvideCodeReceiverIntentFilter$code_confirmation_releaseFactory a = new CodeConfirmationPresentationModule_ProvideCodeReceiverIntentFilter$code_confirmation_releaseFactory();
    }

    public static CodeConfirmationPresentationModule_ProvideCodeReceiverIntentFilter$code_confirmation_releaseFactory create() {
        return a.a;
    }

    public static IntentFilter provideCodeReceiverIntentFilter$code_confirmation_release() {
        return (IntentFilter) Preconditions.checkNotNullFromProvides(CodeConfirmationPresentationModule.provideCodeReceiverIntentFilter$code_confirmation_release());
    }

    @Override // javax.inject.Provider
    public IntentFilter get() {
        return provideCodeReceiverIntentFilter$code_confirmation_release();
    }
}

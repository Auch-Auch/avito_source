package com.avito.android.code_confirmation;

import com.avito.android.code_confirmation.tfa.TfaInteractor;
import com.avito.android.code_confirmation.timer.RxTimer;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CodeConfirmationPresenterImpl_Factory implements Factory<CodeConfirmationPresenterImpl> {
    public final Provider<CodeConfirmationInteractor> a;
    public final Provider<PhoneAntihackInteractor> b;
    public final Provider<TfaInteractor> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<ErrorFormatter> e;
    public final Provider<CodeConfirmationResourceProvider> f;
    public final Provider<Formatter<Long>> g;
    public final Provider<RxTimer> h;
    public final Provider<CodeReceiver> i;
    public final Provider<Kundle> j;

    public CodeConfirmationPresenterImpl_Factory(Provider<CodeConfirmationInteractor> provider, Provider<PhoneAntihackInteractor> provider2, Provider<TfaInteractor> provider3, Provider<SchedulersFactory> provider4, Provider<ErrorFormatter> provider5, Provider<CodeConfirmationResourceProvider> provider6, Provider<Formatter<Long>> provider7, Provider<RxTimer> provider8, Provider<CodeReceiver> provider9, Provider<Kundle> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static CodeConfirmationPresenterImpl_Factory create(Provider<CodeConfirmationInteractor> provider, Provider<PhoneAntihackInteractor> provider2, Provider<TfaInteractor> provider3, Provider<SchedulersFactory> provider4, Provider<ErrorFormatter> provider5, Provider<CodeConfirmationResourceProvider> provider6, Provider<Formatter<Long>> provider7, Provider<RxTimer> provider8, Provider<CodeReceiver> provider9, Provider<Kundle> provider10) {
        return new CodeConfirmationPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static CodeConfirmationPresenterImpl newInstance(CodeConfirmationInteractor codeConfirmationInteractor, PhoneAntihackInteractor phoneAntihackInteractor, Lazy<TfaInteractor> lazy, SchedulersFactory schedulersFactory, ErrorFormatter errorFormatter, CodeConfirmationResourceProvider codeConfirmationResourceProvider, Formatter<Long> formatter, RxTimer rxTimer, CodeReceiver codeReceiver, Kundle kundle) {
        return new CodeConfirmationPresenterImpl(codeConfirmationInteractor, phoneAntihackInteractor, lazy, schedulersFactory, errorFormatter, codeConfirmationResourceProvider, formatter, rxTimer, codeReceiver, kundle);
    }

    @Override // javax.inject.Provider
    public CodeConfirmationPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), DoubleCheck.lazy(this.c), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}

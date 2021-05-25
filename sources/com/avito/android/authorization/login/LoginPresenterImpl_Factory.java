package com.avito.android.authorization.login;

import com.avito.android.Features;
import com.avito.android.account.LastLoggedEmailStorage;
import com.avito.android.authorization.reset_password.ResetPasswordInteractor;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.code_confirmation.PhoneAntihackInteractor;
import com.avito.android.code_confirmation.tfa.TfaInteractor;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.remote.model.text.AttributedTextCreator;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoginPresenterImpl_Factory implements Factory<LoginPresenterImpl> {
    public final Provider<LoginInteractor> a;
    public final Provider<ResetPasswordInteractor> b;
    public final Provider<PhoneAntihackInteractor> c;
    public final Provider<TfaInteractor> d;
    public final Provider<AttributedTextCreator> e;
    public final Provider<AttributedTextFormatter> f;
    public final Provider<LoginResourceProvider> g;
    public final Provider<SupportEmailResourceProvider> h;
    public final Provider<LastLoggedEmailStorage> i;
    public final Provider<SmartLockSaver> j;
    public final Provider<Features> k;
    public final Provider<SchedulersFactory> l;
    public final Provider<ErrorHelper> m;
    public final Provider<Kundle> n;
    public final Provider<String> o;

    public LoginPresenterImpl_Factory(Provider<LoginInteractor> provider, Provider<ResetPasswordInteractor> provider2, Provider<PhoneAntihackInteractor> provider3, Provider<TfaInteractor> provider4, Provider<AttributedTextCreator> provider5, Provider<AttributedTextFormatter> provider6, Provider<LoginResourceProvider> provider7, Provider<SupportEmailResourceProvider> provider8, Provider<LastLoggedEmailStorage> provider9, Provider<SmartLockSaver> provider10, Provider<Features> provider11, Provider<SchedulersFactory> provider12, Provider<ErrorHelper> provider13, Provider<Kundle> provider14, Provider<String> provider15) {
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
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
    }

    public static LoginPresenterImpl_Factory create(Provider<LoginInteractor> provider, Provider<ResetPasswordInteractor> provider2, Provider<PhoneAntihackInteractor> provider3, Provider<TfaInteractor> provider4, Provider<AttributedTextCreator> provider5, Provider<AttributedTextFormatter> provider6, Provider<LoginResourceProvider> provider7, Provider<SupportEmailResourceProvider> provider8, Provider<LastLoggedEmailStorage> provider9, Provider<SmartLockSaver> provider10, Provider<Features> provider11, Provider<SchedulersFactory> provider12, Provider<ErrorHelper> provider13, Provider<Kundle> provider14, Provider<String> provider15) {
        return new LoginPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static LoginPresenterImpl newInstance(LoginInteractor loginInteractor, ResetPasswordInteractor resetPasswordInteractor, PhoneAntihackInteractor phoneAntihackInteractor, TfaInteractor tfaInteractor, AttributedTextCreator attributedTextCreator, AttributedTextFormatter attributedTextFormatter, LoginResourceProvider loginResourceProvider, SupportEmailResourceProvider supportEmailResourceProvider, LastLoggedEmailStorage lastLoggedEmailStorage, SmartLockSaver smartLockSaver, Features features, SchedulersFactory schedulersFactory, ErrorHelper errorHelper, Kundle kundle, String str) {
        return new LoginPresenterImpl(loginInteractor, resetPasswordInteractor, phoneAntihackInteractor, tfaInteractor, attributedTextCreator, attributedTextFormatter, loginResourceProvider, supportEmailResourceProvider, lastLoggedEmailStorage, smartLockSaver, features, schedulersFactory, errorHelper, kundle, str);
    }

    @Override // javax.inject.Provider
    public LoginPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get());
    }
}

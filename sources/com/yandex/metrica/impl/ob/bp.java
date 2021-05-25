package com.yandex.metrica.impl.ob;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class bp implements bo {
    private act a;
    private bo b;

    public bp(@NonNull bo boVar) {
        this(as.a().k().a(), boVar);
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void b(final Intent intent) {
        this.a.a(new abn() { // from class: com.yandex.metrica.impl.ob.bp.7
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() {
                bp.this.b.b(intent);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void c(final Intent intent) {
        this.a.a(new abn() { // from class: com.yandex.metrica.impl.ob.bp.8
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() {
                bp.this.b.c(intent);
            }
        });
    }

    @VisibleForTesting
    public bp(@NonNull act act, @NonNull bo boVar) {
        this.a = act;
        this.b = boVar;
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a() {
        this.a.a(new abn() { // from class: com.yandex.metrica.impl.ob.bp.1
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() {
                bp.this.b.a();
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void b() {
        this.a.a(new abn() { // from class: com.yandex.metrica.impl.ob.bp.9
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() throws Exception {
                bp.this.b.b();
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.bo
    public void c(@NonNull final Bundle bundle) {
        this.a.a(new abn() { // from class: com.yandex.metrica.impl.ob.bp.3
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() throws Exception {
                bp.this.b.c(bundle);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a(final Intent intent, final int i) {
        this.a.a(new abn() { // from class: com.yandex.metrica.impl.ob.bp.4
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() {
                bp.this.b.a(intent, i);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.bo
    public void b(@NonNull final Bundle bundle) {
        this.a.a(new abn() { // from class: com.yandex.metrica.impl.ob.bp.2
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() throws Exception {
                bp.this.b.b(bundle);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a(final Intent intent, final int i, final int i2) {
        this.a.a(new abn() { // from class: com.yandex.metrica.impl.ob.bp.5
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() {
                bp.this.b.a(intent, i, i2);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a(final Intent intent) {
        this.a.a(new abn() { // from class: com.yandex.metrica.impl.ob.bp.6
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() {
                bp.this.b.a(intent);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.bo
    public void a(final String str, final int i, final String str2, final Bundle bundle) {
        this.a.a(new abn() { // from class: com.yandex.metrica.impl.ob.bp.10
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() throws RemoteException {
                bp.this.b.a(str, i, str2, bundle);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.bo
    public void a(final Bundle bundle) {
        this.a.a(new abn() { // from class: com.yandex.metrica.impl.ob.bp.11
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() throws Exception {
                bp.this.b.a(bundle);
            }
        });
    }
}

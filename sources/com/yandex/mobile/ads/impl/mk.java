package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import java.lang.ref.WeakReference;
public abstract class mk<V extends View, T> {
    @NonNull
    private final WeakReference<V> a;

    public mk(@NonNull V v) {
        this.a = new WeakReference<>(v);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull V v) {
        v.setVisibility(8);
        v.setOnClickListener(null);
        v.setOnTouchListener(null);
        v.setSelected(false);
    }

    public abstract boolean a(@NonNull V v, @NonNull T t);

    public abstract void b(@NonNull V v, @NonNull T t);

    public final boolean b() {
        return a() != null;
    }

    public final boolean c() {
        V a3 = a();
        if (a3 == null || eg.d(a3) || eg.a(a3, 1)) {
            return false;
        }
        return true;
    }

    public final boolean d() {
        return eg.b(a(), 100);
    }

    @Nullable
    public final V a() {
        return this.a.get();
    }

    public void a(@NonNull oq oqVar, @NonNull mq mqVar) {
        V a3 = a();
        if (a3 != null) {
            mqVar.a(oqVar, a3);
            mqVar.a(oqVar, new na(a3));
        }
    }
}

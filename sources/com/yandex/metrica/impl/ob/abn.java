package com.yandex.metrica.impl.ob;
public abstract class abn implements Runnable {
    public abstract void a() throws Exception;

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable unused) {
        }
    }
}

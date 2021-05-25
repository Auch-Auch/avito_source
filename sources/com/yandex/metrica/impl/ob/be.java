package com.yandex.metrica.impl.ob;
public class be {

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static void a() {
        b();
    }

    public static void b() throws IllegalStateException {
        if (!a("com.yandex.metrica.CounterConfiguration")) {
            throw new a("\nClass com.yandex.metrica.CounterConfiguration isn't found.\nPerhaps this is due to obfuscation.\nIf you build your application with ProGuard,\nyou need to keep the Metrica for Apps.\nPlease try to use the following lines of code:\n##########################################\n-keep class com.yandex.metrica.** { *; }\n-dontwarn com.yandex.metrica.**\n##########################################");
        }
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}

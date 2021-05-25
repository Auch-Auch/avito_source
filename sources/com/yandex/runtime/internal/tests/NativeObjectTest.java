package com.yandex.runtime.internal.tests;

import com.yandex.runtime.NativeObject;
import java.util.ArrayList;
public class NativeObjectTest {
    public static native NativeObject createNative();

    public void doTest() {
        new ManagerBinding(createNative()).doSmth();
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (!z) {
            try {
                arrayList.add(new Byte[104857600]);
            } catch (OutOfMemoryError unused) {
                arrayList.clear();
                System.gc();
                z = true;
            }
        }
    }
}

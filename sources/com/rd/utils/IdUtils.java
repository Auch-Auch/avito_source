package com.rd.utils;

import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;
public class IdUtils {
    public static final AtomicInteger a = new AtomicInteger(1);

    public static int generateViewId() {
        return View.generateViewId();
    }
}

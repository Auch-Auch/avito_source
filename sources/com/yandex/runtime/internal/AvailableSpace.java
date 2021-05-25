package com.yandex.runtime.internal;

import java.io.File;
public class AvailableSpace {
    public static long getAvailableSpaceOnFilesystem(String str) throws Exception {
        return new File(str).getUsableSpace();
    }
}

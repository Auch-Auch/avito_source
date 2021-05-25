package com.bluejamesbond.text.hyphen;

import java.util.ArrayList;
import java.util.List;
public class SqueezeHyphenator implements IHyphenator {
    public static SqueezeHyphenator a = new SqueezeHyphenator();

    public static SqueezeHyphenator getInstance() {
        return a;
    }

    @Override // com.bluejamesbond.text.hyphen.IHyphenator
    public List<String> hyphenate(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length() - 1;
        int i = 0;
        while (i < length) {
            int i2 = i + 2;
            arrayList.add(str.substring(i, i2));
            i = i2;
        }
        if (i < length) {
            arrayList.add(str.substring(i, str.length()));
        }
        return arrayList;
    }
}

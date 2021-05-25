package com.avito.android.remote.model;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
public class SearchParamElement {
    private boolean isMultiselect = false;
    private List<String> list = new ArrayList(1);

    private boolean isMultiselectParam(@NonNull String str) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '[') {
                i++;
            }
            if (str.charAt(i3) == ']') {
                i2++;
            }
            if (i2 > i) {
                return false;
            }
        }
        if (i != i2 || i < 2) {
            return false;
        }
        return true;
    }

    public void add(@NonNull String str, @NonNull String str2) {
        this.list.add(str2);
        boolean z = true;
        if (this.list.size() <= 1 && !isMultiselectParam(str)) {
            z = false;
        }
        this.isMultiselect = z;
    }

    public String get(int i) {
        return this.list.get(i);
    }

    public List<String> getAll() {
        return this.list;
    }

    public boolean isMultiselect() {
        return this.isMultiselect;
    }
}

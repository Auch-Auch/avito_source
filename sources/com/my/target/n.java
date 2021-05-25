package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import com.my.target.e;
import java.util.Map;
public class n extends e.a {
    public final int a;

    public n(int i) {
        this.a = i;
    }

    @NonNull
    public static e b(int i) {
        return new n(i);
    }

    @Override // com.my.target.e.a
    @NonNull
    public Map<String, String> c(@NonNull a aVar, @NonNull Context context) {
        Map<String, String> c = super.c(aVar, context);
        c.put("duration", Integer.toString(this.a));
        return c;
    }
}

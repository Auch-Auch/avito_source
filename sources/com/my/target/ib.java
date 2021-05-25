package com.my.target;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
public class ib {
    public static void m(@NonNull String str, @NonNull Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            a.q1(th, a.L("Unable to open link: "));
        }
    }
}

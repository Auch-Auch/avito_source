package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
@AutoHandleExceptions
public class SensitiveUserDataUtils {
    public static boolean isSensitiveUserData(View view) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        if (textView.getInputType() == 128) {
            z = true;
        } else {
            z = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        }
        if (!z) {
            String replaceAll = ViewHierarchy.getTextOfView(textView).replaceAll("\\s", "");
            int length = replaceAll.length();
            if (length >= 12 && length <= 19) {
                int i = length - 1;
                int i2 = 0;
                boolean z4 = false;
                while (true) {
                    if (i >= 0) {
                        char charAt = replaceAll.charAt(i);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        int i3 = charAt - '0';
                        if (z4 && (i3 = i3 * 2) > 9) {
                            i3 = (i3 % 10) + 1;
                        }
                        i2 += i3;
                        z4 = !z4;
                        i--;
                    } else if (i2 % 10 == 0) {
                        z2 = true;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                if (!(textView.getInputType() == 96)) {
                    if (!(textView.getInputType() == 112)) {
                        if (!(textView.getInputType() == 3)) {
                            if (textView.getInputType() == 32) {
                                z3 = true;
                            } else {
                                String textOfView = ViewHierarchy.getTextOfView(textView);
                                z3 = (textOfView == null || textOfView.length() == 0) ? false : Patterns.EMAIL_ADDRESS.matcher(textOfView).matches();
                            }
                            if (!z3) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}

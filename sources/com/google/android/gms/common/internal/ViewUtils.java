package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public class ViewUtils {
    private ViewUtils() {
    }

    @RecentlyNullable
    @KeepForSdk
    public static String getXmlAttributeString(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, @RecentlyNonNull boolean z, @RecentlyNonNull boolean z2, @RecentlyNonNull String str3) {
        String attributeValue = attributeSet == null ? null : attributeSet.getAttributeValue(str, str2);
        if (attributeValue != null && attributeValue.startsWith("@string/") && z) {
            String substring = attributeValue.substring(8);
            String packageName = context.getPackageName();
            TypedValue typedValue = new TypedValue();
            try {
                Resources resources = context.getResources();
                StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 8 + String.valueOf(substring).length());
                sb.append(packageName);
                sb.append(":string/");
                sb.append(substring);
                resources.getValue(sb.toString(), typedValue, true);
            } catch (Resources.NotFoundException unused) {
                String.valueOf(str2).length();
                attributeValue.length();
            }
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                attributeValue = charSequence.toString();
            } else {
                String valueOf = String.valueOf(typedValue);
                String.valueOf(str2).length();
                valueOf.length();
            }
        }
        if (z2 && attributeValue == null) {
            String.valueOf(str2).length();
        }
        return attributeValue;
    }
}

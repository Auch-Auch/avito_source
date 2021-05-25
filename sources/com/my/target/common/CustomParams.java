package com.my.target.common;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.fb;
import com.my.target.hw;
import com.vk.sdk.api.VKApiConst;
public final class CustomParams extends fb {
    @Nullable
    public String[] b;
    @Nullable
    public String[] c;
    @Nullable
    public String[] d;
    @Nullable
    public String[] e;
    @Nullable
    public String[] f;

    public interface Gender {
        public static final int FEMALE = 2;
        public static final int MALE = 1;
        public static final int UNKNOWN = 0;
        public static final int UNSPECIFIED = -1;
    }

    @Override // com.my.target.fb
    public void collectData(@NonNull Context context) {
    }

    public int getAge() {
        String param = getParam("ea");
        if (param == null) {
            return 0;
        }
        try {
            return Integer.parseInt(param);
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Nullable
    public String getCustomParam(@NonNull String str) {
        return getParam(str);
    }

    @Nullable
    public String getCustomUserId() {
        String[] strArr = this.f;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[0];
    }

    @Nullable
    public String[] getCustomUserIds() {
        String[] strArr = this.f;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    @Nullable
    public String getEmail() {
        String[] strArr = this.b;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[0];
    }

    @Nullable
    public String[] getEmails() {
        String[] strArr = this.b;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public int getGender() {
        String param = getParam("eg");
        if (param == null) {
            return -1;
        }
        try {
            return Integer.parseInt(param);
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Nullable
    public String getIcqId() {
        String[] strArr = this.e;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[0];
    }

    @Nullable
    public String[] getIcqIds() {
        String[] strArr = this.e;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    @Nullable
    public String getLang() {
        return getParam(VKApiConst.LANG);
    }

    @Nullable
    public String getMrgsAppId() {
        return getParam("mrgs_app_id");
    }

    @Nullable
    public String getMrgsId() {
        return getParam("mrgs_device_id");
    }

    @Nullable
    public String getMrgsUserId() {
        return getParam("mrgs_user_id");
    }

    @Nullable
    public String getOkId() {
        String[] strArr = this.c;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[0];
    }

    @Nullable
    public String[] getOkIds() {
        String[] strArr = this.c;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    @Nullable
    public String getVKId() {
        String[] strArr = this.d;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[0];
    }

    @Nullable
    public String[] getVKIds() {
        String[] strArr = this.d;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public void setAge(int i) {
        if (i >= 0) {
            ae.a("age param set to " + i);
            addParam("ea", String.valueOf(i));
            return;
        }
        ae.a("age param removed");
        removeParam("ea");
    }

    public void setCustomParam(@NonNull String str, @Nullable String str2) {
        addParam(str, str2);
    }

    public void setCustomUserId(@Nullable String str) {
        if (str == null) {
            this.f = null;
        } else {
            this.f = new String[]{str};
        }
        addParam("custom_user_id", str);
    }

    public void setCustomUserIds(@Nullable String[] strArr) {
        if (strArr == null) {
            this.f = null;
            removeParam("custom_user_id");
            return;
        }
        String[] strArr2 = new String[strArr.length];
        this.f = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        addParam("custom_user_id", hw.a(strArr));
    }

    public void setEmail(@Nullable String str) {
        if (str == null) {
            this.b = null;
        } else {
            this.b = new String[]{str};
        }
        addParam("email", str);
    }

    public void setEmails(@Nullable String[] strArr) {
        if (strArr == null) {
            this.b = null;
            removeParam("email");
            return;
        }
        String[] strArr2 = new String[strArr.length];
        this.b = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        addParam("email", hw.a(strArr));
    }

    public void setGender(int i) {
        if (i == 0 || i == 1 || i == 2) {
            ae.a("gender param is set to " + i);
            addParam("eg", String.valueOf(i));
            return;
        }
        removeParam("eg");
        ae.a("gender param removed");
    }

    public void setIcqId(@Nullable String str) {
        if (str == null) {
            this.e = null;
        } else {
            this.e = new String[]{str};
        }
        addParam("icq_id", str);
    }

    public void setIcqIds(@Nullable String[] strArr) {
        if (strArr == null) {
            this.e = null;
            removeParam("icq_id");
            return;
        }
        String[] strArr2 = new String[strArr.length];
        this.e = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        addParam("icq_id", hw.a(strArr));
    }

    public void setLang(@Nullable String str) {
        addParam(VKApiConst.LANG, str);
    }

    public void setMrgsAppId(@Nullable String str) {
        addParam("mrgs_app_id", str);
    }

    public void setMrgsId(@Nullable String str) {
        addParam("mrgs_device_id", str);
    }

    public void setMrgsUserId(@Nullable String str) {
        addParam("mrgs_user_id", str);
    }

    public void setOkId(@Nullable String str) {
        if (str == null) {
            this.c = null;
        } else {
            this.c = new String[]{str};
        }
        addParam("ok_id", str);
    }

    public void setOkIds(@Nullable String[] strArr) {
        if (strArr == null) {
            this.c = null;
            removeParam("ok_id");
            return;
        }
        String[] strArr2 = new String[strArr.length];
        this.c = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        addParam("ok_id", hw.a(strArr));
    }

    public void setVKId(@Nullable String str) {
        if (str == null) {
            this.d = null;
        } else {
            this.d = new String[]{str};
        }
        addParam("vk_id", str);
    }

    public void setVKIds(@Nullable String[] strArr) {
        if (strArr == null) {
            this.d = null;
            removeParam("vk_id");
            return;
        }
        String[] strArr2 = new String[strArr.length];
        this.d = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        addParam("vk_id", hw.a(strArr));
    }
}

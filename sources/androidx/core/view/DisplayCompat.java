package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
public final class DisplayCompat {
    @Nullable
    public static Point a(@NonNull String str, @NonNull Display display) {
        String str2;
        if (display.getDisplayId() == 0) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str2 = (String) cls.getMethod("get", String.class).invoke(cls, str);
            } catch (Exception unused) {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    String[] split = str2.trim().split("x", -1);
                    if (split.length == 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                    throw new NumberFormatException();
                } catch (NumberFormatException unused2) {
                }
            }
        }
        return null;
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        Point point;
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            point = a("sys.display-size", display);
        } else {
            point = a("vendor.display-size", display);
        }
        if (point == null) {
            UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
            if ((uiModeManager != null && uiModeManager.getCurrentModeType() == 4) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                point = new Point(3840, 2160);
            } else {
                point = new Point();
                if (i >= 23) {
                    Display.Mode mode = display.getMode();
                    point.x = mode.getPhysicalWidth();
                    point.y = mode.getPhysicalHeight();
                } else {
                    display.getRealSize(point);
                }
            }
        }
        if (i < 23) {
            return new ModeCompat[]{new ModeCompat(point)};
        }
        Display.Mode[] supportedModes = display.getSupportedModes();
        ArrayList arrayList = new ArrayList(supportedModes.length);
        boolean z = false;
        for (int i2 = 0; i2 < supportedModes.length; i2++) {
            Display.Mode mode2 = supportedModes[i2];
            if ((mode2.getPhysicalWidth() == point.x && mode2.getPhysicalHeight() == point.y) || (mode2.getPhysicalWidth() == point.y && mode2.getPhysicalHeight() == point.x)) {
                arrayList.add(i2, new ModeCompat(supportedModes[i2], true));
                z = true;
            } else {
                arrayList.add(i2, new ModeCompat(supportedModes[i2], false));
            }
        }
        if (!z) {
            arrayList.add(new ModeCompat(point));
        }
        return (ModeCompat[]) arrayList.toArray(new ModeCompat[0]);
    }

    public static final class ModeCompat {
        public final Display.Mode a;
        public final Point b;
        public final boolean c;

        public ModeCompat(@NonNull Point point) {
            Preconditions.checkNotNull(point, "physicalDisplaySize == null");
            this.c = true;
            this.b = point;
            this.a = null;
        }

        public int getPhysicalHeight() {
            return this.b.y;
        }

        public int getPhysicalWidth() {
            return this.b.x;
        }

        public boolean isNative() {
            return this.c;
        }

        @Nullable
        @RequiresApi(23)
        public Display.Mode toMode() {
            return this.a;
        }

        @RequiresApi(23)
        public ModeCompat(@NonNull Display.Mode mode, boolean z) {
            Preconditions.checkNotNull(mode, "Display.Mode == null, can't wrap a null reference");
            this.c = z;
            this.b = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.a = mode;
        }
    }
}

package androidx.constraintlayout.motion.widget;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.model.category_parameters.DateTimeParameterKt;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
public class Debug {
    public static void dumpLayoutParams(ViewGroup viewGroup, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder L = a.L(".(");
        L.append(stackTraceElement.getFileName());
        L.append(":");
        L.append(stackTraceElement.getLineNumber());
        L.append(") ");
        L.append(str);
        L.append("  ");
        String sb = L.toString();
        int childCount = viewGroup.getChildCount();
        System.out.println(str + " children " + childCount);
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            PrintStream printStream = System.out;
            StringBuilder Q = a.Q(sb, "     ");
            Q.append(getName(childAt));
            printStream.println(Q.toString());
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Field[] fields = layoutParams.getClass().getFields();
            for (Field field : fields) {
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To")) {
                        if (!obj.toString().equals(DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME)) {
                            System.out.println(sb + "       " + field.getName() + " " + obj);
                        }
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public static void dumpPoc(Object obj) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder L = a.L(".(");
        L.append(stackTraceElement.getFileName());
        L.append(":");
        L.append(stackTraceElement.getLineNumber());
        L.append(")");
        String sb = L.toString();
        Class<?> cls = obj.getClass();
        PrintStream printStream = System.out;
        StringBuilder Q = a.Q(sb, "------------- ");
        Q.append(cls.getName());
        Q.append(" --------------------");
        printStream.println(Q.toString());
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint")) {
                    if (!(obj2 instanceof Integer) || !obj2.toString().equals(DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME)) {
                        if (!(obj2 instanceof Integer) || !obj2.toString().equals("0")) {
                            if (!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) {
                                if (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")) {
                                    System.out.println(sb + "    " + field.getName() + " " + obj2);
                                }
                            }
                        }
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        PrintStream printStream2 = System.out;
        StringBuilder Q2 = a.Q(sb, "------------- ");
        Q2.append(cls.getSimpleName());
        Q2.append(" --------------------");
        printStream2.println(Q2.toString());
    }

    public static String getActionType(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        Field[] fields = MotionEvent.class.getFields();
        for (Field field : fields) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static String getCallFrom(int i) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i + 2];
        StringBuilder L = a.L(".(");
        L.append(stackTraceElement.getFileName());
        L.append(":");
        L.append(stackTraceElement.getLineNumber());
        L.append(")");
        return L.toString();
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder L = a.L(".(");
        L.append(stackTraceElement.getFileName());
        L.append(":");
        L.append(stackTraceElement.getLineNumber());
        L.append(") ");
        L.append(stackTraceElement.getMethodName());
        L.append("()");
        return L.toString();
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder L = a.L(".(");
        L.append(stackTraceElement.getFileName());
        L.append(":");
        L.append(stackTraceElement.getLineNumber());
        L.append(")");
        return L.toString();
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        StringBuilder L = a.L(".(");
        L.append(stackTraceElement.getFileName());
        L.append(":");
        L.append(stackTraceElement.getLineNumber());
        L.append(")");
        return L.toString();
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout motionLayout, int i) {
        if (i == -1) {
            return "UNDEFINED";
        }
        return motionLayout.getContext().getResources().getResourceEntryName(i);
    }

    public static void logStack(String str, String str2, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length - 1);
        String str3 = " ";
        for (int i2 = 1; i2 <= min; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            StringBuilder L = a.L(".(");
            L.append(stackTrace[i2].getFileName());
            L.append(":");
            L.append(stackTrace[i2].getLineNumber());
            L.append(") ");
            L.append(stackTrace[i2].getMethodName());
            L.toString();
            str3 = str3 + " ";
        }
    }

    public static void printStack(String str, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length - 1);
        String str2 = " ";
        for (int i2 = 1; i2 <= min; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            StringBuilder L = a.L(".(");
            L.append(stackTrace[i2].getFileName());
            L.append(":");
            L.append(stackTrace[i2].getLineNumber());
            L.append(") ");
            String sb = L.toString();
            str2 = a.c3(str2, " ");
            PrintStream printStream = System.out;
            printStream.println(str + str2 + sb + str2);
        }
    }

    public static String getName(Context context, int i) {
        if (i == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            return a.M2("?", i);
        }
    }

    public static String getName(Context context, int[] iArr) {
        String str;
        try {
            String str2 = iArr.length + "[";
            int i = 0;
            while (i < iArr.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(i == 0 ? "" : " ");
                String sb2 = sb.toString();
                try {
                    str = context.getResources().getResourceEntryName(iArr[i]);
                } catch (Resources.NotFoundException unused) {
                    str = "? " + iArr[i] + " ";
                }
                str2 = sb2 + str;
                i++;
            }
            return str2 + "]";
        } catch (Exception e) {
            e.toString();
            return "UNKNOWN";
        }
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder L = a.L(".(");
        L.append(stackTraceElement.getFileName());
        L.append(":");
        L.append(stackTraceElement.getLineNumber());
        L.append(") ");
        L.append(str);
        L.append("  ");
        String sb = L.toString();
        PrintStream printStream = System.out;
        StringBuilder R = a.R(" >>>>>>>>>>>>>>>>>>. dump ", sb, "  ");
        R.append(layoutParams.getClass().getName());
        printStream.println(R.toString());
        Field[] fields = layoutParams.getClass().getFields();
        for (Field field : fields) {
            try {
                Object obj = field.get(layoutParams);
                String name = field.getName();
                if (name.contains("To")) {
                    if (!obj.toString().equals(DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME)) {
                        System.out.println(sb + "       " + name + " " + obj);
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + sb);
    }
}

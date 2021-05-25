package com.google.firebase.crashlytics.internal.proto;

import a2.j.e.d.d.f.a;
import android.app.ActivityManager;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.List;
import java.util.Map;
public class SessionProtobufHelper {
    public static final a a = a.a("0");
    public static final a b = a.a("Unity");

    public static int a(a aVar, a aVar2) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(3, aVar) + CodedOutputStream.computeUInt64Size(2, 0) + CodedOutputStream.computeUInt64Size(1, 0) + 0;
        return aVar2 != null ? computeBytesSize + CodedOutputStream.computeBytesSize(4, aVar2) : computeBytesSize;
    }

    public static int b(String str, String str2) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, a.a(str));
        if (str2 == null) {
            str2 = "";
        }
        return CodedOutputStream.computeBytesSize(2, a.a(str2)) + computeBytesSize;
    }

    public static int c(TrimmedThrowableData trimmedThrowableData, int i, int i2) {
        int i3 = 0;
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, a.a(trimmedThrowableData.className)) + 0;
        String str = trimmedThrowableData.localizedMessage;
        if (str != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, a.a(str));
        }
        for (StackTraceElement stackTraceElement : trimmedThrowableData.stacktrace) {
            int h = h(stackTraceElement, true);
            computeBytesSize += CodedOutputStream.computeRawVarint32Size(h) + CodedOutputStream.computeTagSize(4) + h;
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (trimmedThrowableData2 == null) {
            return computeBytesSize;
        }
        if (i < i2) {
            int c = c(trimmedThrowableData2, i + 1, i2);
            return computeBytesSize + CodedOutputStream.computeRawVarint32Size(c) + CodedOutputStream.computeTagSize(6) + c;
        }
        while (trimmedThrowableData2 != null) {
            trimmedThrowableData2 = trimmedThrowableData2.cause;
            i3++;
        }
        return computeBytesSize + CodedOutputStream.computeUInt32Size(7, i3);
    }

    public static int d() {
        a aVar = a;
        return CodedOutputStream.computeUInt64Size(3, 0) + CodedOutputStream.computeBytesSize(2, aVar) + CodedOutputStream.computeBytesSize(1, aVar) + 0;
    }

    public static int e(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, a aVar, a aVar2) {
        int i2 = i(thread, stackTraceElementArr, 4, true);
        int computeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(i2) + CodedOutputStream.computeTagSize(1) + i2 + 0;
        int length = threadArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i(threadArr[i3], list.get(i3), 0, false);
            computeRawVarint32Size += CodedOutputStream.computeRawVarint32Size(i4) + CodedOutputStream.computeTagSize(1) + i4;
        }
        int c = c(trimmedThrowableData, 1, i);
        int computeTagSize = CodedOutputStream.computeTagSize(2);
        int d = d();
        int computeRawVarint32Size2 = CodedOutputStream.computeRawVarint32Size(d) + CodedOutputStream.computeTagSize(3) + d + CodedOutputStream.computeRawVarint32Size(c) + computeTagSize + c + computeRawVarint32Size;
        int a3 = a(aVar, aVar2);
        return CodedOutputStream.computeRawVarint32Size(a3) + CodedOutputStream.computeTagSize(3) + a3 + computeRawVarint32Size2;
    }

    public static int f(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, a aVar, a aVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int e = e(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, aVar, aVar2);
        boolean z = true;
        int computeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(e) + CodedOutputStream.computeTagSize(1) + e + 0;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int b2 = b(entry.getKey(), entry.getValue());
                computeRawVarint32Size += CodedOutputStream.computeRawVarint32Size(b2) + CodedOutputStream.computeTagSize(2) + b2;
            }
        }
        if (runningAppProcessInfo != null) {
            if (runningAppProcessInfo.importance == 100) {
                z = false;
            }
            computeRawVarint32Size += CodedOutputStream.computeBoolSize(3, z);
        }
        return CodedOutputStream.computeUInt32Size(4, i2) + computeRawVarint32Size;
    }

    public static int g(Float f, int i, boolean z, int i2, long j, long j2) {
        int i3 = 0;
        if (f != null) {
            i3 = 0 + CodedOutputStream.computeFloatSize(1, f.floatValue());
        }
        return CodedOutputStream.computeUInt64Size(6, j2) + CodedOutputStream.computeUInt64Size(5, j) + CodedOutputStream.computeUInt32Size(4, i2) + CodedOutputStream.computeBoolSize(3, z) + CodedOutputStream.computeSInt32Size(2, i) + i3;
    }

    public static int h(StackTraceElement stackTraceElement, boolean z) {
        int i;
        int i2 = 0;
        if (stackTraceElement.isNativeMethod()) {
            i = CodedOutputStream.computeUInt64Size(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            i = CodedOutputStream.computeUInt64Size(1, 0);
        }
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, a.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) + i + 0;
        if (stackTraceElement.getFileName() != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, a.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            computeBytesSize += CodedOutputStream.computeUInt64Size(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i2 = 2;
        }
        return CodedOutputStream.computeUInt32Size(5, i2) + computeBytesSize;
    }

    public static int i(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int computeUInt32Size = CodedOutputStream.computeUInt32Size(2, i) + CodedOutputStream.computeBytesSize(1, a.a(thread.getName()));
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int h = h(stackTraceElement, z);
            computeUInt32Size += CodedOutputStream.computeRawVarint32Size(h) + CodedOutputStream.computeTagSize(3) + h;
        }
        return computeUInt32Size;
    }

    public static a j(String str) {
        if (str == null) {
            return null;
        }
        return a.a(str);
    }

    public static void k(CodedOutputStream codedOutputStream, int i, StackTraceElement stackTraceElement, boolean z) throws Exception {
        codedOutputStream.writeTag(i, 2);
        codedOutputStream.writeRawVarint32(h(stackTraceElement, z));
        int i2 = 0;
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream.writeUInt64(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            codedOutputStream.writeUInt64(1, 0);
        }
        codedOutputStream.writeBytes(2, a.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream.writeBytes(3, a.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream.writeUInt64(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i2 = 4;
        }
        codedOutputStream.writeUInt32(5, i2);
    }

    public static void l(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) throws Exception {
        codedOutputStream.writeTag(i3, 2);
        codedOutputStream.writeRawVarint32(c(trimmedThrowableData, 1, i2));
        codedOutputStream.writeBytes(1, a.a(trimmedThrowableData.className));
        String str = trimmedThrowableData.localizedMessage;
        if (str != null) {
            codedOutputStream.writeBytes(3, a.a(str));
        }
        int i4 = 0;
        for (StackTraceElement stackTraceElement : trimmedThrowableData.stacktrace) {
            k(codedOutputStream, 4, stackTraceElement, true);
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (trimmedThrowableData2 == null) {
            return;
        }
        if (i < i2) {
            l(codedOutputStream, trimmedThrowableData2, i + 1, i2, 6);
            return;
        }
        while (trimmedThrowableData2 != null) {
            trimmedThrowableData2 = trimmedThrowableData2.cause;
            i4++;
        }
        codedOutputStream.writeUInt32(7, i4);
    }

    public static void m(CodedOutputStream codedOutputStream, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws Exception {
        codedOutputStream.writeTag(1, 2);
        codedOutputStream.writeRawVarint32(i(thread, stackTraceElementArr, i, z));
        codedOutputStream.writeBytes(1, a.a(thread.getName()));
        codedOutputStream.writeUInt32(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            k(codedOutputStream, 3, stackTraceElement, z);
        }
    }

    public static void writeBeginSession(CodedOutputStream codedOutputStream, String str, String str2, long j) throws Exception {
        codedOutputStream.writeBytes(1, a.a(str2));
        codedOutputStream.writeBytes(2, a.a(str));
        codedOutputStream.writeUInt64(3, j);
    }

    public static void writeSessionApp(CodedOutputStream codedOutputStream, String str, String str2, String str3, String str4, int i, String str5) throws Exception {
        a a3 = a.a(str);
        a a4 = a.a(str2);
        a a5 = a.a(str3);
        a a6 = a.a(str4);
        a a8 = str5 != null ? a.a(str5) : null;
        codedOutputStream.writeTag(7, 2);
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, a4);
        int computeBytesSize2 = CodedOutputStream.computeBytesSize(6, a6) + CodedOutputStream.computeBytesSize(3, a5) + computeBytesSize + CodedOutputStream.computeBytesSize(1, a3) + 0;
        if (a8 != null) {
            computeBytesSize2 = CodedOutputStream.computeBytesSize(9, a8) + CodedOutputStream.computeBytesSize(8, b) + computeBytesSize2;
        }
        codedOutputStream.writeRawVarint32(CodedOutputStream.computeEnumSize(10, i) + computeBytesSize2);
        codedOutputStream.writeBytes(1, a3);
        codedOutputStream.writeBytes(2, a4);
        codedOutputStream.writeBytes(3, a5);
        codedOutputStream.writeBytes(6, a6);
        if (a8 != null) {
            codedOutputStream.writeBytes(8, b);
            codedOutputStream.writeBytes(9, a8);
        }
        codedOutputStream.writeEnum(10, i);
    }

    public static void writeSessionAppClsId(CodedOutputStream codedOutputStream, String str) throws Exception {
        a a3 = a.a(str);
        codedOutputStream.writeTag(7, 2);
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, a3);
        codedOutputStream.writeRawVarint32(CodedOutputStream.computeRawVarint32Size(computeBytesSize) + CodedOutputStream.computeTagSize(5) + computeBytesSize);
        codedOutputStream.writeTag(5, 2);
        codedOutputStream.writeRawVarint32(computeBytesSize);
        codedOutputStream.writeBytes(2, a3);
    }

    public static void writeSessionDevice(CodedOutputStream codedOutputStream, int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) throws Exception {
        int i4;
        int i5;
        int i6;
        a j3 = j(str);
        a j4 = j(str3);
        a j5 = j(str2);
        codedOutputStream.writeTag(9, 2);
        int computeEnumSize = CodedOutputStream.computeEnumSize(3, i) + 0;
        if (j3 == null) {
            i4 = 0;
        } else {
            i4 = CodedOutputStream.computeBytesSize(4, j3);
        }
        int computeUInt64Size = CodedOutputStream.computeUInt64Size(6, j);
        int computeUInt64Size2 = CodedOutputStream.computeUInt64Size(7, j2) + computeUInt64Size + CodedOutputStream.computeUInt32Size(5, i2) + computeEnumSize + i4;
        int computeUInt32Size = CodedOutputStream.computeUInt32Size(12, i3) + CodedOutputStream.computeBoolSize(10, z) + computeUInt64Size2;
        if (j5 == null) {
            i5 = 0;
        } else {
            i5 = CodedOutputStream.computeBytesSize(13, j5);
        }
        int i7 = computeUInt32Size + i5;
        if (j4 == null) {
            i6 = 0;
        } else {
            i6 = CodedOutputStream.computeBytesSize(14, j4);
        }
        codedOutputStream.writeRawVarint32(i7 + i6);
        codedOutputStream.writeEnum(3, i);
        codedOutputStream.writeBytes(4, j3);
        codedOutputStream.writeUInt32(5, i2);
        codedOutputStream.writeUInt64(6, j);
        codedOutputStream.writeUInt64(7, j2);
        codedOutputStream.writeBool(10, z);
        codedOutputStream.writeUInt32(12, i3);
        if (j5 != null) {
            codedOutputStream.writeBytes(13, j5);
        }
        if (j4 != null) {
            codedOutputStream.writeBytes(14, j4);
        }
    }

    public static void writeSessionEvent(CodedOutputStream codedOutputStream, long j, String str, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, byte[] bArr, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, String str2, String str3, Float f, int i3, boolean z, long j2, long j3) throws Exception {
        a aVar;
        a a3 = a.a(str2);
        a a4 = str3 == null ? null : a.a(str3.replace("-", ""));
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            aVar = new a(bArr2);
        } else {
            Logger.getLogger().d("No log data to include with this event.");
            aVar = null;
        }
        codedOutputStream.writeTag(10, 2);
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, a.a(str)) + CodedOutputStream.computeUInt64Size(1, j) + 0;
        int f2 = f(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, a3, a4, map, runningAppProcessInfo, i2);
        int computeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(f2) + CodedOutputStream.computeTagSize(3) + f2 + computeBytesSize;
        int g = g(f, i3, z, i2, j2, j3);
        int computeRawVarint32Size2 = CodedOutputStream.computeRawVarint32Size(g) + CodedOutputStream.computeTagSize(5) + g + computeRawVarint32Size;
        if (aVar != null) {
            int computeBytesSize2 = CodedOutputStream.computeBytesSize(1, aVar);
            computeRawVarint32Size2 += CodedOutputStream.computeRawVarint32Size(computeBytesSize2) + CodedOutputStream.computeTagSize(6) + computeBytesSize2;
        }
        codedOutputStream.writeRawVarint32(computeRawVarint32Size2);
        codedOutputStream.writeUInt64(1, j);
        codedOutputStream.writeBytes(2, a.a(str));
        codedOutputStream.writeTag(3, 2);
        codedOutputStream.writeRawVarint32(f(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, a3, a4, map, runningAppProcessInfo, i2));
        codedOutputStream.writeTag(1, 2);
        codedOutputStream.writeRawVarint32(e(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, a3, a4));
        m(codedOutputStream, thread, stackTraceElementArr, 4, true);
        int length2 = threadArr.length;
        for (int i4 = 0; i4 < length2; i4++) {
            m(codedOutputStream, threadArr[i4], list.get(i4), 0, false);
        }
        l(codedOutputStream, trimmedThrowableData, 1, i, 2);
        codedOutputStream.writeTag(3, 2);
        codedOutputStream.writeRawVarint32(d());
        a aVar2 = a;
        codedOutputStream.writeBytes(1, aVar2);
        codedOutputStream.writeBytes(2, aVar2);
        codedOutputStream.writeUInt64(3, 0);
        codedOutputStream.writeTag(4, 2);
        codedOutputStream.writeRawVarint32(a(a3, a4));
        codedOutputStream.writeUInt64(1, 0);
        codedOutputStream.writeUInt64(2, 0);
        codedOutputStream.writeBytes(3, a3);
        if (a4 != null) {
            codedOutputStream.writeBytes(4, a4);
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                codedOutputStream.writeTag(2, 2);
                codedOutputStream.writeRawVarint32(b(entry.getKey(), entry.getValue()));
                codedOutputStream.writeBytes(1, a.a(entry.getKey()));
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                codedOutputStream.writeBytes(2, a.a(value));
            }
        }
        if (runningAppProcessInfo != null) {
            codedOutputStream.writeBool(3, runningAppProcessInfo.importance != 100);
        }
        codedOutputStream.writeUInt32(4, i2);
        codedOutputStream.writeTag(5, 2);
        codedOutputStream.writeRawVarint32(g(f, i3, z, i2, j2, j3));
        if (f != null) {
            codedOutputStream.writeFloat(1, f.floatValue());
        }
        codedOutputStream.writeSInt32(2, i3);
        codedOutputStream.writeBool(3, z);
        codedOutputStream.writeUInt32(4, i2);
        codedOutputStream.writeUInt64(5, j2);
        codedOutputStream.writeUInt64(6, j3);
        if (aVar != null) {
            codedOutputStream.writeTag(6, 2);
            codedOutputStream.writeRawVarint32(CodedOutputStream.computeBytesSize(1, aVar));
            codedOutputStream.writeBytes(1, aVar);
        }
    }

    public static void writeSessionOS(CodedOutputStream codedOutputStream, String str, String str2, boolean z) throws Exception {
        a a3 = a.a(str);
        a a4 = a.a(str2);
        codedOutputStream.writeTag(8, 2);
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, a3) + CodedOutputStream.computeEnumSize(1, 3) + 0;
        codedOutputStream.writeRawVarint32(CodedOutputStream.computeBoolSize(4, z) + CodedOutputStream.computeBytesSize(3, a4) + computeBytesSize);
        codedOutputStream.writeEnum(1, 3);
        codedOutputStream.writeBytes(2, a3);
        codedOutputStream.writeBytes(3, a4);
        codedOutputStream.writeBool(4, z);
    }

    public static void writeSessionUser(CodedOutputStream codedOutputStream, String str, String str2, String str3) throws Exception {
        if (str == null) {
            str = "";
        }
        a a3 = a.a(str);
        a j = j(str2);
        a j2 = j(str3);
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, a3) + 0;
        if (str2 != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(2, j);
        }
        if (str3 != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, j2);
        }
        codedOutputStream.writeTag(6, 2);
        codedOutputStream.writeRawVarint32(computeBytesSize);
        codedOutputStream.writeBytes(1, a3);
        if (str2 != null) {
            codedOutputStream.writeBytes(2, j);
        }
        if (str3 != null) {
            codedOutputStream.writeBytes(3, j2);
        }
    }
}

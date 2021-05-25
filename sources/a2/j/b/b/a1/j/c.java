package a2.j.b.b.a1.j;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.regex.Pattern;
public final class c {
    public static final Pattern c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    public final ParsableByteArray a = new ParsableByteArray();
    public final StringBuilder b = new StringBuilder();

    public static String a(ParsableByteArray parsableByteArray, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit && !z) {
            char c2 = (char) parsableByteArray.getData()[position];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                position++;
                sb.append(c2);
            }
        }
        parsableByteArray.skipBytes(position - parsableByteArray.getPosition());
        return sb.toString();
    }

    @Nullable
    public static String b(ParsableByteArray parsableByteArray, StringBuilder sb) {
        c(parsableByteArray);
        if (parsableByteArray.bytesLeft() == 0) {
            return null;
        }
        String a3 = a(parsableByteArray, sb);
        if (!"".equals(a3)) {
            return a3;
        }
        StringBuilder L = a.L("");
        L.append((char) parsableByteArray.readUnsignedByte());
        return L.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A[LOOP:1: B:2:0x0002->B:35:0x0074, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0001 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(com.google.android.exoplayer2.util.ParsableByteArray r8) {
        /*
            r0 = 1
        L_0x0001:
            r1 = 1
        L_0x0002:
            int r2 = r8.bytesLeft()
            if (r2 <= 0) goto L_0x0076
            if (r1 == 0) goto L_0x0076
            int r1 = r8.getPosition()
            byte[] r2 = r8.getData()
            byte r1 = r2[r1]
            char r1 = (char) r1
            r2 = 9
            r3 = 0
            if (r1 == r2) goto L_0x002c
            r2 = 10
            if (r1 == r2) goto L_0x002c
            r2 = 12
            if (r1 == r2) goto L_0x002c
            r2 = 13
            if (r1 == r2) goto L_0x002c
            r2 = 32
            if (r1 == r2) goto L_0x002c
            r1 = 0
            goto L_0x0030
        L_0x002c:
            r8.skipBytes(r0)
            r1 = 1
        L_0x0030:
            if (r1 != 0) goto L_0x0001
            int r1 = r8.getPosition()
            int r2 = r8.limit()
            byte[] r4 = r8.getData()
            int r5 = r1 + 2
            if (r5 > r2) goto L_0x0070
            int r5 = r1 + 1
            byte r1 = r4[r1]
            r6 = 47
            if (r1 != r6) goto L_0x0070
            int r1 = r5 + 1
            byte r5 = r4[r5]
            r7 = 42
            if (r5 != r7) goto L_0x0070
        L_0x0052:
            int r5 = r1 + 1
            if (r5 >= r2) goto L_0x0066
            byte r1 = r4[r1]
            char r1 = (char) r1
            if (r1 != r7) goto L_0x0064
            byte r1 = r4[r5]
            char r1 = (char) r1
            if (r1 != r6) goto L_0x0064
            int r2 = r5 + 1
            r1 = r2
            goto L_0x0052
        L_0x0064:
            r1 = r5
            goto L_0x0052
        L_0x0066:
            int r1 = r8.getPosition()
            int r2 = r2 - r1
            r8.skipBytes(r2)
            r1 = 1
            goto L_0x0071
        L_0x0070:
            r1 = 0
        L_0x0071:
            if (r1 == 0) goto L_0x0074
            goto L_0x0001
        L_0x0074:
            r1 = 0
            goto L_0x0002
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.a1.j.c.c(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }
}

package com.google.zxing.client.result;

import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import ru.avito.messenger.internal.ConstantsKt;
public final class CalendarParsedResult extends ParsedResult {
    public static final Pattern m = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
    public static final long[] n = {604800000, 86400000, ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS, DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS, 1000};
    public static final Pattern o = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
    public final String b;
    public final long c;
    public final boolean d;
    public final long e;
    public final boolean f;
    public final String g;
    public final String h;
    public final String[] i;
    public final String j;
    public final double k;
    public final double l;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CalendarParsedResult(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String[] r22, java.lang.String r23, double r24, double r26) {
        /*
            r15 = this;
            r1 = r15
            r0 = r19
            com.google.zxing.client.result.ParsedResultType r2 = com.google.zxing.client.result.ParsedResultType.CALENDAR
            r15.<init>(r2)
            r2 = r16
            r1.b = r2
            long r2 = b(r17)     // Catch:{ ParseException -> 0x0095 }
            r1.c = r2     // Catch:{ ParseException -> 0x0095 }
            r2 = 0
            if (r18 != 0) goto L_0x0052
            r3 = 0
            if (r0 != 0) goto L_0x001c
        L_0x0019:
            r8 = -1
            goto L_0x0044
        L_0x001c:
            java.util.regex.Pattern r7 = com.google.zxing.client.result.CalendarParsedResult.m
            java.util.regex.Matcher r0 = r7.matcher(r0)
            boolean r7 = r0.matches()
            if (r7 != 0) goto L_0x0029
            goto L_0x0019
        L_0x0029:
            r8 = r3
            r7 = 0
        L_0x002b:
            long[] r10 = com.google.zxing.client.result.CalendarParsedResult.n
            int r11 = r10.length
            if (r7 >= r11) goto L_0x0044
            int r11 = r7 + 1
            java.lang.String r12 = r0.group(r11)
            if (r12 == 0) goto L_0x0042
            r13 = r10[r7]
            int r7 = java.lang.Integer.parseInt(r12)
            long r5 = (long) r7
            long r13 = r13 * r5
            long r8 = r8 + r13
        L_0x0042:
            r7 = r11
            goto L_0x002b
        L_0x0044:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x004b
            r5 = -1
            goto L_0x004f
        L_0x004b:
            long r3 = r1.c
            long r5 = r3 + r8
        L_0x004f:
            r1.e = r5
            goto L_0x0058
        L_0x0052:
            long r3 = b(r18)     // Catch:{ ParseException -> 0x008a }
            r1.e = r3     // Catch:{ ParseException -> 0x008a }
        L_0x0058:
            int r0 = r17.length()
            r3 = 8
            r4 = 1
            if (r0 != r3) goto L_0x0063
            r0 = 1
            goto L_0x0064
        L_0x0063:
            r0 = 0
        L_0x0064:
            r1.d = r0
            if (r18 == 0) goto L_0x006f
            int r0 = r18.length()
            if (r0 != r3) goto L_0x006f
            r2 = 1
        L_0x006f:
            r1.f = r2
            r0 = r20
            r1.g = r0
            r0 = r21
            r1.h = r0
            r0 = r22
            r1.i = r0
            r0 = r23
            r1.j = r0
            r2 = r24
            r1.k = r2
            r2 = r26
            r1.l = r2
            return
        L_0x008a:
            r0 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x0095:
            r0 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.CalendarParsedResult.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String[], java.lang.String, double, double):void");
    }

    public static String a(boolean z, long j2) {
        DateFormat dateFormat;
        if (j2 < 0) {
            return null;
        }
        if (z) {
            dateFormat = DateFormat.getDateInstance(2);
        } else {
            dateFormat = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateFormat.format(Long.valueOf(j2));
    }

    public static long b(String str) throws ParseException {
        if (!o.matcher(str).matches()) {
            throw new ParseException(str, 0);
        } else if (str.length() == 8) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        } else if (str.length() != 16 || str.charAt(15) != 'Z') {
            return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH).parse(str).getTime();
        } else {
            long time = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH).parse(str.substring(0, 15)).getTime();
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            long j2 = time + ((long) gregorianCalendar.get(15));
            gregorianCalendar.setTime(new Date(j2));
            return j2 + ((long) gregorianCalendar.get(16));
        }
    }

    public String[] getAttendees() {
        return this.i;
    }

    public String getDescription() {
        return this.j;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.maybeAppend(this.b, sb);
        ParsedResult.maybeAppend(a(this.d, this.c), sb);
        ParsedResult.maybeAppend(a(this.f, this.e), sb);
        ParsedResult.maybeAppend(this.g, sb);
        ParsedResult.maybeAppend(this.h, sb);
        ParsedResult.maybeAppend(this.i, sb);
        ParsedResult.maybeAppend(this.j, sb);
        return sb.toString();
    }

    @Deprecated
    public Date getEnd() {
        if (this.e < 0) {
            return null;
        }
        return new Date(this.e);
    }

    public long getEndTimestamp() {
        return this.e;
    }

    public double getLatitude() {
        return this.k;
    }

    public String getLocation() {
        return this.g;
    }

    public double getLongitude() {
        return this.l;
    }

    public String getOrganizer() {
        return this.h;
    }

    @Deprecated
    public Date getStart() {
        return new Date(this.c);
    }

    public long getStartTimestamp() {
        return this.c;
    }

    public String getSummary() {
        return this.b;
    }

    public boolean isEndAllDay() {
        return this.f;
    }

    public boolean isStartAllDay() {
        return this.d;
    }
}

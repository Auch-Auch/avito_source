package com.google.android.exoplayer2.text.subrip;

import a2.b.a.a.a;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public final class SubripDecoder extends SimpleSubtitleDecoder {
    public static final Pattern q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    public static final Pattern r = Pattern.compile("\\{\\\\.*?\\}");
    public final StringBuilder o = new StringBuilder();
    public final ArrayList<String> p = new ArrayList<>();

    public SubripDecoder() {
        super("SubripDecoder");
    }

    public static float e(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    public static long f(Matcher matcher, int i) {
        String group = matcher.group(i + 1);
        long parseLong = (Long.parseLong((String) Assertions.checkNotNull(matcher.group(i + 3))) * 1000) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(i + 2))) * 60 * 1000) + (group != null ? Long.parseLong(group) * 60 * 60 * 1000 : 0);
        String group2 = matcher.group(i + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        ParsableByteArray parsableByteArray;
        Cue cue;
        char c;
        char c2;
        SubripDecoder subripDecoder = this;
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(bArr, i);
        while (true) {
            String readLine = parsableByteArray2.readLine();
            if (readLine != null) {
                if (readLine.length() != 0) {
                    try {
                        Integer.parseInt(readLine);
                        String readLine2 = parsableByteArray2.readLine();
                        if (readLine2 == null) {
                            Log.w("SubripDecoder", "Unexpected end");
                        } else {
                            Matcher matcher = q.matcher(readLine2);
                            if (matcher.matches()) {
                                longArray.add(f(matcher, 1));
                                longArray.add(f(matcher, 6));
                                subripDecoder.o.setLength(0);
                                subripDecoder.p.clear();
                                for (String readLine3 = parsableByteArray2.readLine(); !TextUtils.isEmpty(readLine3); readLine3 = parsableByteArray2.readLine()) {
                                    if (subripDecoder.o.length() > 0) {
                                        subripDecoder.o.append("<br>");
                                    }
                                    StringBuilder sb = subripDecoder.o;
                                    ArrayList<String> arrayList2 = subripDecoder.p;
                                    String trim = readLine3.trim();
                                    StringBuilder sb2 = new StringBuilder(trim);
                                    Matcher matcher2 = r.matcher(trim);
                                    int i2 = 0;
                                    while (matcher2.find()) {
                                        String group = matcher2.group();
                                        arrayList2.add(group);
                                        int start = matcher2.start() - i2;
                                        int length = group.length();
                                        sb2.replace(start, start + length, "");
                                        i2 += length;
                                    }
                                    sb.append(sb2.toString());
                                }
                                Spanned fromHtml = Html.fromHtml(subripDecoder.o.toString());
                                String str = null;
                                int i3 = 0;
                                while (true) {
                                    if (i3 < subripDecoder.p.size()) {
                                        String str2 = subripDecoder.p.get(i3);
                                        if (str2.matches("\\{\\\\an[1-9]\\}")) {
                                            str = str2;
                                        } else {
                                            i3++;
                                        }
                                    }
                                }
                                Cue.Builder text = new Cue.Builder().setText(fromHtml);
                                if (str == null) {
                                    cue = text.build();
                                    parsableByteArray = parsableByteArray2;
                                } else {
                                    switch (str.hashCode()) {
                                        case -685620710:
                                            if (str.equals("{\\an1}")) {
                                                c = 0;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -685620679:
                                            if (str.equals("{\\an2}")) {
                                                c = 6;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -685620648:
                                            if (str.equals("{\\an3}")) {
                                                c = 3;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -685620617:
                                            if (str.equals("{\\an4}")) {
                                                c = 1;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -685620586:
                                            if (str.equals("{\\an5}")) {
                                                c = 7;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -685620555:
                                            if (str.equals("{\\an6}")) {
                                                c = 4;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -685620524:
                                            if (str.equals("{\\an7}")) {
                                                c = 2;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -685620493:
                                            if (str.equals("{\\an8}")) {
                                                c = '\b';
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -685620462:
                                            if (str.equals("{\\an9}")) {
                                                c = 5;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        default:
                                            c = 65535;
                                            break;
                                    }
                                    parsableByteArray = parsableByteArray2;
                                    if (c == 0 || c == 1 || c == 2) {
                                        text.setPositionAnchor(0);
                                    } else if (c == 3 || c == 4 || c == 5) {
                                        text.setPositionAnchor(2);
                                    } else {
                                        text.setPositionAnchor(1);
                                    }
                                    switch (str.hashCode()) {
                                        case -685620710:
                                            if (str.equals("{\\an1}")) {
                                                c2 = 0;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -685620679:
                                            if (str.equals("{\\an2}")) {
                                                c2 = 1;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -685620648:
                                            if (str.equals("{\\an3}")) {
                                                c2 = 2;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -685620617:
                                            if (str.equals("{\\an4}")) {
                                                c2 = 6;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -685620586:
                                            if (str.equals("{\\an5}")) {
                                                c2 = 7;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -685620555:
                                            if (str.equals("{\\an6}")) {
                                                c2 = '\b';
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -685620524:
                                            if (str.equals("{\\an7}")) {
                                                c2 = 3;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -685620493:
                                            if (str.equals("{\\an8}")) {
                                                c2 = 4;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -685620462:
                                            if (str.equals("{\\an9}")) {
                                                c2 = 5;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        default:
                                            c2 = 65535;
                                            break;
                                    }
                                    if (c2 == 0 || c2 == 1 || c2 == 2) {
                                        text.setLineAnchor(2);
                                    } else if (c2 == 3 || c2 == 4 || c2 == 5) {
                                        text.setLineAnchor(0);
                                    } else {
                                        text.setLineAnchor(1);
                                    }
                                    cue = text.setPosition(e(text.getPositionAnchor())).setLine(e(text.getLineAnchor()), 0).build();
                                }
                                arrayList.add(cue);
                                arrayList.add(Cue.EMPTY);
                            } else {
                                parsableByteArray = parsableByteArray2;
                                a.V0("Skipping invalid timing: ", readLine2, "SubripDecoder");
                            }
                            subripDecoder = this;
                            parsableByteArray2 = parsableByteArray;
                        }
                    } catch (NumberFormatException unused) {
                        parsableByteArray = parsableByteArray2;
                        a.V0("Skipping invalid index: ", readLine, "SubripDecoder");
                    }
                }
            }
        }
        return new a2.j.b.b.a1.g.a((Cue[]) arrayList.toArray(new Cue[0]), longArray.toArray());
    }
}

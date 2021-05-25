package a2.t.a.c.n0;

import com.voximplant.sdk.internal.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.webrtc.SessionDescription;
public class g2 {
    public static g2 c;
    public SessionDescription a;
    public a b;

    public static class a {
        public boolean a;
        public boolean b;
        public boolean c;
        public HashMap<String, String> d;
    }

    public static synchronized g2 b() {
        g2 g2Var;
        synchronized (g2.class) {
            if (c == null) {
                c = new g2();
            }
            g2Var = c;
        }
        return g2Var;
    }

    public boolean a(SessionDescription sessionDescription) {
        if (!sessionDescription.description.contains("VIMS")) {
            return false;
        }
        boolean contains = sessionDescription.description.contains("a=vox-params:platform android");
        boolean contains2 = sessionDescription.description.contains("a=vox-params:platform ios");
        if (!contains && !contains2) {
            return false;
        }
        String str = null;
        Matcher matcher = Pattern.compile("a=vox-params:clver\\s\\w+-((\\d{1,3}\\.){2}\\d{1,3})").matcher(sessionDescription.description);
        if (matcher.find()) {
            str = matcher.group(1);
        }
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\.");
        int parseInt = split.length > 0 ? (Integer.parseInt(split[0]) * 1000000) + 0 : 0;
        if (split.length > 1) {
            parseInt += Integer.parseInt(split[1]) * 1000;
        }
        if (split.length > 2) {
            parseInt += Integer.parseInt(split[2]);
        }
        if ((!contains || parseInt >= 2012000) && (!contains2 || parseInt >= 2021000)) {
            return false;
        }
        return true;
    }

    public SessionDescription c() {
        SessionDescription sessionDescription;
        String str;
        String[] split = this.a.description.split("(\r\n|\n)");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i = 0; i < split.length; i++) {
            if (this.b.a && split[i].contains("m=audio") && split[i].matches("^.+(?:\\s127(?!\\d).*)$")) {
                split[i] = split[i].replaceAll("(?:\\s127(?!\\d))", "");
            }
            if (this.b.c && split[i].contains("a=setup:")) {
                split[i] = split[i].replace(split[i].substring(8), "passive");
                z = true;
            }
            if (!split[i].contains("b=TIAS:13888000") && !split[i].contains("b=AS:13888")) {
                arrayList.add(split[i]);
            } else if (!this.b.b) {
                arrayList.add(split[i]);
            }
        }
        if (z) {
            Logger.i("SdpModifier: updateSSLRoleToPassive: updated to passive");
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append("\r\n");
        }
        this.a = new SessionDescription(this.a.type, sb.toString());
        HashMap<String, String> hashMap = this.b.d;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : this.b.d.entrySet()) {
                String key = entry.getKey();
                boolean equals = entry.getValue().equals("audio");
                String[] split2 = this.a.description.split("\r\n");
                String str2 = equals ? "m=audio " : "m=video ";
                int i2 = 0;
                while (true) {
                    if (i2 >= split2.length) {
                        i2 = -1;
                        break;
                    }
                    if (split2[i2].startsWith(str2)) {
                        for (int i3 = i2; i3 < split2.length; i3++) {
                            String str3 = split2[i3];
                            if (str3.startsWith("a=sendonly") || str3.startsWith("a=sendrecv")) {
                                break;
                            }
                            if (str3.startsWith("a=recvonly") || str3.startsWith("a=inactive")) {
                                break;
                            }
                        }
                        continue;
                    }
                    i2++;
                }
                int i4 = i2;
                while (true) {
                    i4++;
                    if (i4 < split2.length) {
                        if (!split2[i4].startsWith("m=audio ")) {
                            if (split2[i4].startsWith("m=video ")) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        i4 = split2.length;
                        break;
                    }
                }
                int i5 = i4 - 1;
                if (i2 == -1) {
                    Logger.w("SdpModifier: preferCodec: No media line with send direction, can't prefer " + key);
                    sessionDescription = this.a;
                } else {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    Pattern compile = Pattern.compile("^a=rtpmap:(\\d+) " + key + "(/\\d+)+[\r]?$");
                    for (int i6 = i2; i6 <= i5; i6++) {
                        Matcher matcher = compile.matcher(split2[i6]);
                        if (matcher.matches()) {
                            linkedHashSet.add(matcher.group(1));
                        }
                    }
                    if (linkedHashSet.isEmpty()) {
                        Logger.w("SdpModifier: preferCodec: No payload types with name " + key);
                        sessionDescription = this.a;
                    } else {
                        ArrayList arrayList2 = new ArrayList(linkedHashSet);
                        String str4 = split2[i2];
                        List asList = Arrays.asList(str4.split(" "));
                        if (asList.size() <= 3) {
                            Logger.e("SdpModifier: preferCodec: Wrong SDP media description format: " + str4);
                            str = null;
                        } else {
                            List subList = asList.subList(0, 3);
                            LinkedHashSet linkedHashSet2 = new LinkedHashSet(asList.subList(3, asList.size()));
                            linkedHashSet2.removeAll(arrayList2);
                            ArrayList arrayList3 = new ArrayList(subList);
                            arrayList3.addAll(arrayList2);
                            arrayList3.addAll(linkedHashSet2);
                            str = d(arrayList3, " ", false);
                        }
                        if (str == null) {
                            sessionDescription = this.a;
                        } else {
                            StringBuilder L = a2.b.a.a.a.L("SdpModifier: preferCodec: Change media description from: ");
                            L.append(split2[i2]);
                            L.append(" to ");
                            L.append(str);
                            Logger.d(L.toString());
                            split2[i2] = str;
                            sessionDescription = new SessionDescription(this.a.type, d(Arrays.asList(split2), "\r\n", true));
                        }
                    }
                }
                this.a = sessionDescription;
            }
        }
        return this.a;
    }

    public final String d(Iterable<? extends CharSequence> iterable, String str, boolean z) {
        Iterator<? extends CharSequence> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder((CharSequence) it.next());
        while (it.hasNext()) {
            sb.append(str);
            sb.append((CharSequence) it.next());
        }
        if (z) {
            sb.append(str);
        }
        return sb.toString();
    }
}

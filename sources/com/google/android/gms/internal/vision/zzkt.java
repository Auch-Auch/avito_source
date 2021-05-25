package com.google.android.gms.internal.vision;
public final class zzkt {
    public static String zzd(zzgs zzgs) {
        zzks zzks = new zzks(zzgs);
        StringBuilder sb = new StringBuilder(zzks.size());
        for (int i = 0; i < zzks.size(); i++) {
            byte zzau = zzks.zzau(i);
            if (zzau == 34) {
                sb.append("\\\"");
            } else if (zzau == 39) {
                sb.append("\\'");
            } else if (zzau != 92) {
                switch (zzau) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (zzau < 32 || zzau > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzau >>> 6) & 3) + 48));
                            sb.append((char) (((zzau >>> 3) & 7) + 48));
                            sb.append((char) ((zzau & 7) + 48));
                            break;
                        } else {
                            sb.append((char) zzau);
                            continue;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}

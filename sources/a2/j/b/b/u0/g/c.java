package a2.j.b.b.u0.g;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class c extends TagPayloadReader {
    public long b = C.TIME_UNSET;
    public long[] c = new long[0];
    public long[] d = new long[0];

    public c() {
        super(new DummyTrackOutput());
    }

    @Nullable
    public static Object d(ParsableByteArray parsableByteArray, int i) {
        if (i == 0) {
            return Double.valueOf(Double.longBitsToDouble(parsableByteArray.readLong()));
        }
        boolean z = false;
        if (i == 1) {
            if (parsableByteArray.readUnsignedByte() == 1) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else if (i == 2) {
            return f(parsableByteArray);
        } else {
            if (i == 3) {
                HashMap hashMap = new HashMap();
                while (true) {
                    String f = f(parsableByteArray);
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    if (readUnsignedByte == 9) {
                        return hashMap;
                    }
                    Object d2 = d(parsableByteArray, readUnsignedByte);
                    if (d2 != null) {
                        hashMap.put(f, d2);
                    }
                }
            } else if (i == 8) {
                return e(parsableByteArray);
            } else {
                if (i == 10) {
                    int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                    ArrayList arrayList = new ArrayList(readUnsignedIntToInt);
                    for (int i2 = 0; i2 < readUnsignedIntToInt; i2++) {
                        Object d3 = d(parsableByteArray, parsableByteArray.readUnsignedByte());
                        if (d3 != null) {
                            arrayList.add(d3);
                        }
                    }
                    return arrayList;
                } else if (i != 11) {
                    return null;
                } else {
                    Date date = new Date((long) Double.valueOf(Double.longBitsToDouble(parsableByteArray.readLong())).doubleValue());
                    parsableByteArray.skipBytes(2);
                    return date;
                }
            }
        }
    }

    public static HashMap<String, Object> e(ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        HashMap<String, Object> hashMap = new HashMap<>(readUnsignedIntToInt);
        for (int i = 0; i < readUnsignedIntToInt; i++) {
            String f = f(parsableByteArray);
            Object d2 = d(parsableByteArray, parsableByteArray.readUnsignedByte());
            if (d2 != null) {
                hashMap.put(f, d2);
            }
        }
        return hashMap;
    }

    public static String f(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return new String(parsableByteArray.getData(), position, readUnsignedShort);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(ParsableByteArray parsableByteArray) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(ParsableByteArray parsableByteArray, long j) {
        if (parsableByteArray.readUnsignedByte() != 2 || !"onMetaData".equals(f(parsableByteArray)) || parsableByteArray.readUnsignedByte() != 8) {
            return false;
        }
        HashMap<String, Object> e = e(parsableByteArray);
        Object obj = e.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.b = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = e.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.c = new long[size];
                this.d = new long[size];
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        break;
                    }
                    this.c[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.d[i] = ((Double) obj5).longValue();
                    i++;
                }
                this.c = new long[0];
                this.d = new long[0];
            }
        }
        return false;
    }
}

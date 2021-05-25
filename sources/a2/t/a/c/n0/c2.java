package a2.t.a.c.n0;

import a2.b.a.a.a;
import com.voximplant.sdk.call.IAudioStream;
import com.voximplant.sdk.call.IVideoStream;
import com.voximplant.sdk.call.VideoStreamType;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.EndpointTracks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
public class c2 {
    public String a;
    public ArrayList<a2> b = new ArrayList<>();
    public ArrayList<a2> c = new ArrayList<>();
    public HashMap<String, EndpointTracks> d = new HashMap<>();

    public c2(String str) {
        this.a = str;
    }

    public final String a() {
        return a.t(a.L("EndpointManager ["), this.a, "] ");
    }

    public a2 b(String str, boolean z) {
        for (a2 a2Var : z ? this.c : this.b) {
            if (a2Var.a.equals(str)) {
                Logger.i(a() + "findEndpointById: " + str + " found");
                return a2Var;
            }
        }
        Logger.e(a() + "findEndpointById: " + str + " not found (pending = " + z + ")");
        return null;
    }

    public final a2 c(String str, boolean z) {
        String str2;
        Map.Entry<String, EndpointTracks> next;
        Iterator<Map.Entry<String, EndpointTracks>> it = this.d.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            next = it.next();
            if (z) {
                if (next.getValue().c.contains(str) || next.getValue().d.contains(str)) {
                    break;
                }
            } else if (next.getValue().b.contains(str)) {
                str2 = next.getKey();
                break;
            }
        }
        str2 = next.getKey();
        if (str2 == null) {
            Iterator<a2> it2 = this.b.iterator();
            while (it2.hasNext()) {
                a2 next2 = it2.next();
                if (z) {
                    Iterator it3 = ((ArrayList) next2.getVideoStreams()).iterator();
                    while (it3.hasNext()) {
                        if (((IVideoStream) it3.next()).getVideoStreamId().equals(str)) {
                            return next2;
                        }
                    }
                    continue;
                } else {
                    Objects.requireNonNull(next2);
                    Iterator it4 = new ArrayList(next2.g.values()).iterator();
                    while (it4.hasNext()) {
                        if (((IAudioStream) it4.next()).getAudioStreamId().equals(str)) {
                            return next2;
                        }
                    }
                    continue;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a());
            sb.append("findEndpointByStreamId(");
            sb.append(z ? "video" : "audio");
            sb.append("): ");
            sb.append(str);
            sb.append(" can't find endpoint id");
            Logger.e(sb.toString());
            return null;
        }
        a2 b2 = b(str2, false);
        return b2 == null ? b(str2, true) : b2;
    }

    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        Iterator<a2> it = this.b.iterator();
        while (it.hasNext()) {
            a2 next = it.next();
            Objects.requireNonNull(next);
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry<String, h2> entry : next.f.entrySet()) {
                if (entry.getValue().i == VideoStreamType.VIDEO) {
                    arrayList2.add(entry.getKey());
                }
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }
}

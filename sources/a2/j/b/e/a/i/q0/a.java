package a2.j.b.e.a.i.q0;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.ArrayList;
import java.util.List;
public final class a implements f {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Long d;
    public final /* synthetic */ Long e;
    public final /* synthetic */ List f;
    public final /* synthetic */ List g;

    public a(Integer num, int i, int i2, Long l, Long l2, List list, List list2) {
        this.a = num;
        this.b = i;
        this.c = i2;
        this.d = l;
        this.e = l2;
        this.f = list;
        this.g = list2;
    }

    public final SplitInstallSessionState a(SplitInstallSessionState splitInstallSessionState) {
        if (splitInstallSessionState == null) {
            splitInstallSessionState = SplitInstallSessionState.create(0, 0, 0, 0, 0, new ArrayList(), new ArrayList());
        }
        Integer num = this.a;
        int intValue = num != null ? num.intValue() : splitInstallSessionState.sessionId();
        int i = this.b;
        int i2 = this.c;
        Long l = this.d;
        long longValue = l != null ? l.longValue() : splitInstallSessionState.bytesDownloaded();
        Long l2 = this.e;
        long longValue2 = l2 == null ? splitInstallSessionState.totalBytesToDownload() : l2.longValue();
        List<String> list = this.f;
        if (list == null) {
            list = splitInstallSessionState.moduleNames();
        }
        List<String> list2 = this.g;
        return SplitInstallSessionState.create(intValue, i, i2, longValue, longValue2, list, list2 == null ? splitInstallSessionState.languages() : list2);
    }
}

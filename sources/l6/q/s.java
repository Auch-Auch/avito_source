package l6.q;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import java.util.ArrayList;
import java.util.List;
public class s<T> {
    public MediaBrowserService.Result a;

    public s(MediaBrowserService.Result result) {
        this.a = result;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: android.service.media.MediaBrowserService$Result */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: android.service.media.MediaBrowserService$Result */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(T t) {
        ArrayList arrayList = null;
        if (t instanceof List) {
            MediaBrowserService.Result result = this.a;
            T<Parcel> t2 = t;
            if (t2 != null) {
                arrayList = new ArrayList();
                for (Parcel parcel : t2) {
                    parcel.setDataPosition(0);
                    arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                    parcel.recycle();
                }
            }
            result.sendResult(arrayList);
        } else if (t instanceof Parcel) {
            T t3 = t;
            t3.setDataPosition(0);
            this.a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(t3));
            t3.recycle();
        } else {
            this.a.sendResult(null);
        }
    }
}

package l6.c.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.R;
import androidx.browser.browseractions.BrowserActionItem;
import java.util.ArrayList;
import java.util.List;
@Deprecated
public class e implements AdapterView.OnItemClickListener {
    public final Context a;
    public final Uri b;
    public final List<BrowserActionItem> c;
    @Nullable
    public b d;

    public e(@NonNull Context context, @NonNull Uri uri, @NonNull List<BrowserActionItem> list) {
        this.a = context;
        this.b = uri;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BrowserActionItem(context.getString(R.string.fallback_menu_item_open_in_browser), PendingIntent.getActivity(context, 0, new Intent("android.intent.action.VIEW", uri), 0)));
        arrayList.add(new BrowserActionItem(context.getString(R.string.fallback_menu_item_copy_link), new c(this)));
        String string = context.getString(R.string.fallback_menu_item_share_link);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", uri.toString());
        intent.setType("text/plain");
        arrayList.add(new BrowserActionItem(string, PendingIntent.getActivity(context, 0, intent, 0)));
        arrayList.addAll(list);
        this.c = arrayList;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BrowserActionItem browserActionItem = this.c.get(i);
        if (browserActionItem.getAction() != null) {
            try {
                browserActionItem.getAction().send();
            } catch (PendingIntent.CanceledException unused) {
            }
        } else {
            Runnable runnable = browserActionItem.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        b bVar = this.d;
        if (bVar != null) {
            bVar.b(false);
        }
    }
}

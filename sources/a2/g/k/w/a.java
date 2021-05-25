package a2.g.k.w;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@AutoHandleExceptions
public final class a {
    public static List<String> a(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof EditText) {
            return arrayList;
        }
        if (view instanceof TextView) {
            String charSequence = ((TextView) view).getText().toString();
            if (!charSequence.isEmpty() && charSequence.length() < 100) {
                arrayList.add(charSequence.toLowerCase());
            }
            return arrayList;
        }
        for (View view2 : ViewHierarchy.getChildrenOfView(view)) {
            arrayList.addAll(a(view2));
        }
        return arrayList;
    }

    public static boolean b(List<String> list, List<String> list2) {
        boolean z;
        Iterator<String> it = list.iterator();
        do {
            z = false;
            if (it.hasNext()) {
                String next = it.next();
                Iterator<String> it2 = list2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (next.contains(it2.next())) {
                            z = true;
                            continue;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                return false;
            }
        } while (!z);
        return true;
    }
}

package a2.g.u;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookSdk;
public class a {
    public Fragment a;
    public String b;
    public String c;

    public a(Fragment fragment) {
        this.a = fragment;
    }

    public static String b() {
        StringBuilder L = a2.b.a.a.a.L("fb");
        L.append(FacebookSdk.getApplicationId());
        L.append("://authorize");
        return L.toString();
    }

    public final void a(int i, Intent intent) {
        FragmentActivity activity;
        if (this.a.isAdded() && (activity = this.a.getActivity()) != null) {
            activity.setResult(i, intent);
            activity.finish();
        }
    }
}

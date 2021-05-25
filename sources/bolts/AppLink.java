package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
public class AppLink {
    public Uri a;
    public List<Target> b;
    public Uri c;

    public static class Target {
        public final Uri a;
        public final String b;
        public final String c;
        public final String d;

        public Target(String str, String str2, Uri uri, String str3) {
            this.b = str;
            this.c = str2;
            this.a = uri;
            this.d = str3;
        }

        public String getAppName() {
            return this.d;
        }

        public String getClassName() {
            return this.c;
        }

        public String getPackageName() {
            return this.b;
        }

        public Uri getUrl() {
            return this.a;
        }
    }

    public AppLink(Uri uri, List<Target> list, Uri uri2) {
        this.a = uri;
        this.b = list == null ? Collections.emptyList() : list;
        this.c = uri2;
    }

    public Uri getSourceUrl() {
        return this.a;
    }

    public List<Target> getTargets() {
        return Collections.unmodifiableList(this.b);
    }

    public Uri getWebUrl() {
        return this.c;
    }
}

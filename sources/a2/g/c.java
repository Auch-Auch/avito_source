package a2.g;

import com.facebook.GraphRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;
public class c implements GraphRequest.g {
    public final /* synthetic */ ArrayList a;

    public c(GraphRequest graphRequest, ArrayList arrayList) {
        this.a = arrayList;
    }

    @Override // com.facebook.GraphRequest.g
    public void a(String str, String str2) throws IOException {
        this.a.add(String.format(Locale.US, "%s=%s", str, URLEncoder.encode(str2, "UTF-8")));
    }
}

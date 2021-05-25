package a2.j.b.e.a.i;

import com.google.android.play.core.splitinstall.e;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public final class b0 {
    public final XmlPullParser a;
    public final e b = new e();

    public b0(XmlPullParser xmlPullParser) {
        this.a = xmlPullParser;
    }

    public final String a(String str) {
        for (int i = 0; i < this.a.getAttributeCount(); i++) {
            if (this.a.getAttributeName(i).equals(str)) {
                return this.a.getAttributeValue(i);
            }
        }
        return null;
    }

    public final void b() throws IOException, XmlPullParserException {
        int i = 1;
        while (i != 0) {
            int next = this.a.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}

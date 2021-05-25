package a2.j.d.i;

import com.google.common.base.Function;
import com.google.common.net.MediaType;
import kotlin.text.Typography;
public class a implements Function<String, String> {
    public a(MediaType mediaType) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.common.base.Function
    public String apply(String str) {
        String str2 = str;
        if (MediaType.h.matchesAllOf(str2)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(str2.length() + 16);
        sb.append(Typography.quote);
        for (int i = 0; i < str2.length(); i++) {
            char charAt = str2.charAt(i);
            if (charAt == '\r' || charAt == '\\' || charAt == '\"') {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        sb.append(Typography.quote);
        return sb.toString();
    }
}

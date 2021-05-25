package l6.r;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgument;
import androidx.navigation.NavType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class c {
    public static final Pattern f = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    public final ArrayList<String> a = new ArrayList<>();
    public final Pattern b;
    public final boolean c;
    public final boolean d;
    public final Map<String, a> e = new HashMap();

    public static class a {
        public String a;
        public ArrayList<String> b = new ArrayList<>();
    }

    public c(@NonNull String str) {
        Uri parse = Uri.parse(str);
        int i = 1;
        boolean z = parse.getQuery() != null;
        this.d = z;
        StringBuilder sb = new StringBuilder("^");
        if (!f.matcher(str).find()) {
            sb.append("http[s]?://");
        }
        Pattern compile = Pattern.compile("\\{(.+?)\\}");
        if (z) {
            Matcher matcher = Pattern.compile("(\\?)").matcher(str);
            if (matcher.find()) {
                a(str.substring(0, matcher.start()), sb, compile);
                sb.append("($|(\\?(.)*))");
            }
            this.c = false;
            for (String str2 : parse.getQueryParameterNames()) {
                StringBuilder sb2 = new StringBuilder();
                String queryParameter = parse.getQueryParameter(str2);
                Matcher matcher2 = compile.matcher(queryParameter);
                a aVar = new a();
                int i2 = 0;
                while (matcher2.find()) {
                    aVar.b.add(matcher2.group(i));
                    sb2.append(Pattern.quote(queryParameter.substring(i2, matcher2.start())));
                    sb2.append("(.+?)?");
                    i2 = matcher2.end();
                    i = 1;
                }
                if (i2 < queryParameter.length()) {
                    sb2.append(Pattern.quote(queryParameter.substring(i2)));
                }
                aVar.a = sb2.toString().replace(".*", "\\E.*\\Q");
                this.e.put(str2, aVar);
                i = 1;
            }
        } else {
            this.c = a(str, sb, compile);
        }
        this.b = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"));
    }

    public final boolean a(@NonNull String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !str.contains(".*");
        int i = 0;
        while (matcher.find()) {
            this.a.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i, matcher.start())));
            sb.append("(.+?)");
            i = matcher.end();
            z = false;
        }
        if (i < str.length()) {
            sb.append(Pattern.quote(str.substring(i)));
        }
        return z;
    }

    public final boolean b(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            NavType<?> type = navArgument.getType();
            try {
                type.put(bundle, str, type.parseValue(str2));
                return false;
            } catch (IllegalArgumentException unused) {
                return true;
            }
        } else {
            bundle.putString(str, str2);
            return false;
        }
    }
}

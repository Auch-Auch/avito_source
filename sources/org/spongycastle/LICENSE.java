package org.spongycastle;

import a2.b.a.a.a;
import org.spongycastle.util.Strings;
public class LICENSE {
    public static String licenseText;

    static {
        StringBuilder L = a.L("Copyright (c) 2000-2017 The Legion of the Bouncy Castle Inc. (http://www.bouncycastle.org) ");
        L.append(Strings.lineSeparator());
        L.append(Strings.lineSeparator());
        L.append("Permission is hereby granted, free of charge, to any person obtaining a copy of this software ");
        L.append(Strings.lineSeparator());
        L.append("and associated documentation files (the \"Software\"), to deal in the Software without restriction, ");
        L.append(Strings.lineSeparator());
        L.append("including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, ");
        L.append(Strings.lineSeparator());
        L.append("and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,");
        L.append(Strings.lineSeparator());
        L.append("subject to the following conditions:");
        L.append(Strings.lineSeparator());
        L.append(Strings.lineSeparator());
        L.append("The above copyright notice and this permission notice shall be included in all copies or substantial");
        L.append(Strings.lineSeparator());
        L.append("portions of the Software.");
        L.append(Strings.lineSeparator());
        L.append(Strings.lineSeparator());
        L.append("THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,");
        L.append(Strings.lineSeparator());
        L.append("INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR");
        L.append(Strings.lineSeparator());
        L.append("PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE");
        L.append(Strings.lineSeparator());
        L.append("LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR");
        L.append(Strings.lineSeparator());
        L.append("OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER");
        L.append(Strings.lineSeparator());
        L.append("DEALINGS IN THE SOFTWARE.");
        licenseText = L.toString();
    }

    public static void main(String[] strArr) {
        System.out.println(licenseText);
    }
}

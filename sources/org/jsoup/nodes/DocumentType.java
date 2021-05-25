package org.jsoup.nodes;

import java.io.IOException;
import kotlin.text.Typography;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import x6.b.a.a;
public class DocumentType extends a {
    public static final String PUBLIC_KEY = "PUBLIC";
    public static final String SYSTEM_KEY = "SYSTEM";

    public DocumentType(String str, String str2, String str3) {
        Validate.notNull(str);
        Validate.notNull(str2);
        Validate.notNull(str3);
        attr("name", str);
        attr("publicId", str2);
        attr("systemId", str3);
        if (!StringUtil.isBlank(attr("publicId"))) {
            attr("pubSysKey", PUBLIC_KEY);
        } else if (!StringUtil.isBlank(attr("systemId"))) {
            attr("pubSysKey", SYSTEM_KEY);
        }
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String baseUri() {
        return super.baseUri();
    }

    @Override // org.jsoup.nodes.Node
    public void c(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.syntax() != Document.OutputSettings.Syntax.html || (!StringUtil.isBlank(attr("publicId"))) || (!StringUtil.isBlank(attr("systemId")))) {
            appendable.append("<!DOCTYPE");
        } else {
            appendable.append("<!doctype");
        }
        if (!StringUtil.isBlank(attr("name"))) {
            appendable.append(" ").append(attr("name"));
        }
        if (!StringUtil.isBlank(attr("pubSysKey"))) {
            appendable.append(" ").append(attr("pubSysKey"));
        }
        if (!StringUtil.isBlank(attr("publicId"))) {
            appendable.append(" \"").append(attr("publicId")).append(Typography.quote);
        }
        if (!StringUtil.isBlank(attr("systemId"))) {
            appendable.append(" \"").append(attr("systemId")).append(Typography.quote);
        }
        appendable.append(Typography.greater);
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ int childNodeSize() {
        return super.childNodeSize();
    }

    @Override // org.jsoup.nodes.Node
    public void d(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node empty() {
        return super.empty();
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public String name() {
        return attr("name");
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#doctype";
    }

    public String publicId() {
        return attr("publicId");
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    public void setPubSysKey(String str) {
        if (str != null) {
            attr("pubSysKey", str);
        }
    }

    public String systemId() {
        return attr("systemId");
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node attr(String str, String str2) {
        return super.attr(str, str2);
    }
}

package org.jsoup.helper;

import a2.b.a.a.a;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
public class W3CDom {
    public DocumentBuilderFactory factory;

    public static class W3CBuilder implements NodeVisitor {
        public final Document a;
        public final Stack<HashMap<String, String>> b;
        public Element c;

        public W3CBuilder(Document document) {
            Stack<HashMap<String, String>> stack = new Stack<>();
            this.b = stack;
            this.a = document;
            stack.push(new HashMap<>());
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            String str;
            Element element;
            this.b.push(new HashMap<>(this.b.peek()));
            if (node instanceof org.jsoup.nodes.Element) {
                org.jsoup.nodes.Element element2 = (org.jsoup.nodes.Element) node;
                Iterator<Attribute> it = element2.attributes().iterator();
                while (true) {
                    str = "";
                    if (!it.hasNext()) {
                        break;
                    }
                    Attribute next = it.next();
                    String key = next.getKey();
                    if (!key.equals("xmlns")) {
                        if (key.startsWith("xmlns:")) {
                            str = key.substring(6);
                        }
                    }
                    this.b.peek().put(str, next.getValue());
                }
                int indexOf = element2.tagName().indexOf(":");
                String str2 = this.b.peek().get(indexOf > 0 ? element2.tagName().substring(0, indexOf) : str);
                String tagName = element2.tagName();
                if (str2 != null || !tagName.contains(":")) {
                    element = this.a.createElementNS(str2, tagName);
                } else {
                    element = this.a.createElementNS(str, tagName);
                }
                Iterator<Attribute> it2 = element2.attributes().iterator();
                while (it2.hasNext()) {
                    Attribute next2 = it2.next();
                    String replaceAll = next2.getKey().replaceAll("[^-a-zA-Z0-9_:.]", str);
                    if (replaceAll.matches("[a-zA-Z_:][-a-zA-Z0-9_:.]*")) {
                        element.setAttribute(replaceAll, next2.getValue());
                    }
                }
                Element element3 = this.c;
                if (element3 == null) {
                    this.a.appendChild(element);
                } else {
                    element3.appendChild(element);
                }
                this.c = element;
            } else if (node instanceof TextNode) {
                this.c.appendChild(this.a.createTextNode(((TextNode) node).getWholeText()));
            } else if (node instanceof Comment) {
                this.c.appendChild(this.a.createComment(((Comment) node).getData()));
            } else if (node instanceof DataNode) {
                this.c.appendChild(this.a.createTextNode(((DataNode) node).getWholeData()));
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if ((node instanceof org.jsoup.nodes.Element) && (this.c.getParentNode() instanceof Element)) {
                this.c = (Element) this.c.getParentNode();
            }
            this.b.pop();
        }
    }

    public W3CDom() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        this.factory = newInstance;
        newInstance.setNamespaceAware(true);
    }

    public static HashMap<String, String> OutputHtml() {
        return a.k0("method", "html");
    }

    public static HashMap<String, String> OutputXml() {
        return a.k0("method", "xml");
    }

    public static String asString(Document document, Map<String, String> map) {
        try {
            DOMSource dOMSource = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            if (map != null) {
                Properties properties = new Properties();
                properties.putAll(map);
                newTransformer.setOutputProperties(properties);
            }
            if (document.getDoctype() != null) {
                DocumentType doctype = document.getDoctype();
                if (!StringUtil.isBlank(doctype.getPublicId())) {
                    newTransformer.setOutputProperty("doctype-public", doctype.getPublicId());
                }
                if (!StringUtil.isBlank(doctype.getSystemId())) {
                    newTransformer.setOutputProperty("doctype-system", doctype.getSystemId());
                } else if (doctype.getName().equalsIgnoreCase("html") && StringUtil.isBlank(doctype.getPublicId()) && StringUtil.isBlank(doctype.getSystemId())) {
                    newTransformer.setOutputProperty("doctype-system", "about:legacy-compat");
                }
            }
            newTransformer.transform(dOMSource, streamResult);
            return stringWriter.toString();
        } catch (TransformerException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Document convert(org.jsoup.nodes.Document document) {
        return new W3CDom().fromJsoup(document);
    }

    public Document fromJsoup(org.jsoup.nodes.Document document) {
        Validate.notNull(document);
        try {
            DocumentBuilder newDocumentBuilder = this.factory.newDocumentBuilder();
            DOMImplementation dOMImplementation = newDocumentBuilder.getDOMImplementation();
            Document newDocument = newDocumentBuilder.newDocument();
            org.jsoup.nodes.DocumentType documentType = document.documentType();
            if (documentType != null) {
                newDocument.appendChild(dOMImplementation.createDocumentType(documentType.name(), documentType.publicId(), documentType.systemId()));
            }
            newDocument.setXmlStandalone(true);
            convert(document, newDocument);
            return newDocument;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }

    public void convert(org.jsoup.nodes.Document document, Document document2) {
        if (!StringUtil.isBlank(document.location())) {
            document2.setDocumentURI(document.location());
        }
        NodeTraversor.traverse(new W3CBuilder(document2), document.child(0));
    }

    public String asString(Document document) {
        return asString(document, null);
    }
}

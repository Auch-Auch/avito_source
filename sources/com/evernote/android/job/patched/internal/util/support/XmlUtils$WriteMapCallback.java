package com.evernote.android.job.patched.internal.util.support;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
public interface XmlUtils$WriteMapCallback {
    void writeUnknownObject(Object obj, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException;
}

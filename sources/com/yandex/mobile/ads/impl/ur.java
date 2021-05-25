package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.mobile.ads.video.models.ad.Creative;
import com.yandex.mobile.ads.video.models.ad.Icon;
import com.yandex.mobile.ads.video.models.ad.MediaFile;
import com.yandex.mobile.ads.video.models.ad.SkipOffset;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import com.yandex.mobile.ads.video.models.ad.VideoAdConfigurator;
import com.yandex.mobile.ads.video.models.blocksinfo.Block;
import com.yandex.mobile.ads.video.models.blocksinfo.BlocksInfo;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public final class ur {
    @NonNull
    private final uu a = new uu();
    @NonNull
    private final ut b = new ut();

    public static final class a {
        private VideoAd a;
        private XmlPullParser b;

        public /* synthetic */ a(VideoAd videoAd, XmlPullParser xmlPullParser, byte b2) {
            this(videoAd, xmlPullParser);
        }

        public static /* synthetic */ void a(a aVar, String str, String str2) throws IOException, XmlPullParserException {
            ur.b(aVar.b, str);
            Cif.a(aVar.a, str2, ur.l(aVar.b));
        }

        private a(VideoAd videoAd, XmlPullParser xmlPullParser) {
            this.a = videoAd;
            this.b = xmlPullParser;
        }
    }

    public static final class b {
        private BlocksInfo a;
        private XmlPullParser b;

        public /* synthetic */ b(BlocksInfo blocksInfo, XmlPullParser xmlPullParser, byte b2) {
            this(blocksInfo, xmlPullParser);
        }

        public static /* synthetic */ void a(b bVar, String str, String str2) throws IOException, XmlPullParserException {
            ur.b(bVar.b, str);
            Cif.a(bVar.a, str2, ur.l(bVar.b));
        }

        private b(BlocksInfo blocksInfo, XmlPullParser xmlPullParser) {
            this.a = blocksInfo;
            this.b = xmlPullParser;
        }
    }

    @Nullable
    private tt b(@NonNull XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "version");
        ArrayList arrayList = new ArrayList();
        while (n(xmlPullParser)) {
            if (m(xmlPullParser) && xmlPullParser.getName().equals("Ad")) {
                arrayList.add(c(xmlPullParser));
            }
        }
        if (!TextUtils.isEmpty(attributeValue)) {
            return new tt(attributeValue, arrayList);
        }
        return null;
    }

    private VideoAd c(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        VideoAd videoAd = (VideoAd) Cif.a(VideoAd.class, Boolean.FALSE);
        b(xmlPullParser, "Ad");
        while (n(xmlPullParser)) {
            if (m(xmlPullParser)) {
                String name = xmlPullParser.getName();
                if (name.equals("InLine")) {
                    videoAd = (VideoAd) Cif.a(VideoAd.class, Boolean.FALSE);
                    b(xmlPullParser, "InLine");
                    while (n(xmlPullParser)) {
                        if (m(xmlPullParser)) {
                            a(xmlPullParser, videoAd);
                        }
                    }
                } else if (name.equals("Wrapper")) {
                    videoAd = (VideoAd) Cif.a(VideoAd.class, Boolean.TRUE);
                    b(xmlPullParser, "Wrapper");
                    if (videoAd != null) {
                        b(xmlPullParser, "Wrapper");
                        new VideoAdConfigurator(videoAd).setWrapperConfiguration(ut.a(xmlPullParser));
                    }
                    while (n(xmlPullParser)) {
                        if (m(xmlPullParser)) {
                            if (TextUtils.equals(xmlPullParser.getName(), "VASTAdTagURI")) {
                                b(xmlPullParser, "VASTAdTagURI");
                                Cif.a(videoAd, "setVastAdTagUri", l(xmlPullParser));
                            } else {
                                a(xmlPullParser, videoAd);
                            }
                        }
                    }
                }
            }
        }
        return videoAd;
    }

    private static List<Creative> d(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        ArrayList arrayList = new ArrayList();
        b(xmlPullParser, "Creatives");
        while (n(xmlPullParser)) {
            if (m(xmlPullParser)) {
                if (TextUtils.equals(xmlPullParser.getName(), "Creative")) {
                    Creative e = e(xmlPullParser);
                    if (e != null) {
                        arrayList.add(e);
                    }
                } else {
                    k(xmlPullParser);
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00d5: APUT  (r5v9 java.lang.Object[]), (0 ??[int, short, byte, char]), (r7v2 java.util.ArrayList) */
    private static Creative e(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        b(xmlPullParser, "Creative");
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        Creative creative = null;
        while (n(xmlPullParser)) {
            if (m(xmlPullParser)) {
                if (TextUtils.equals(xmlPullParser.getName(), "Linear")) {
                    creative = (Creative) Cif.a(Creative.class, new Object[0]);
                    if (creative != null) {
                        b(xmlPullParser, "Linear");
                        Cif.a(creative, "setId", attributeValue);
                        String attributeValue2 = xmlPullParser.getAttributeValue(null, "skipoffset");
                        Cif.a(creative, "setSkipOffset", !TextUtils.isEmpty(attributeValue2) ? (SkipOffset) Cif.a(SkipOffset.class, attributeValue2) : null);
                        while (n(xmlPullParser)) {
                            String name = xmlPullParser.getName();
                            if (m(xmlPullParser)) {
                                if (TextUtils.equals(name, "Duration")) {
                                    b(xmlPullParser, "Duration");
                                    Cif.a(creative, "setDurationHHMMSS", l(xmlPullParser));
                                } else if (TextUtils.equals(name, "TrackingEvents")) {
                                    Object[] objArr = new Object[1];
                                    ArrayList arrayList = new ArrayList();
                                    b(xmlPullParser, "TrackingEvents");
                                    while (n(xmlPullParser)) {
                                        if (m(xmlPullParser)) {
                                            if (TextUtils.equals(xmlPullParser.getName(), "Tracking")) {
                                                b(xmlPullParser, "Tracking");
                                                String attributeValue3 = xmlPullParser.getAttributeValue(null, "event");
                                                String l = l(xmlPullParser);
                                                if (!TextUtils.isEmpty(l)) {
                                                    arrayList.add(new Pair(attributeValue3, l));
                                                }
                                            } else {
                                                k(xmlPullParser);
                                            }
                                        }
                                    }
                                    objArr[0] = arrayList;
                                    Cif.a(creative, "addTrackingEvents", objArr);
                                } else if (TextUtils.equals(name, "MediaFiles")) {
                                    Cif.a(creative, "addMediaFiles", h(xmlPullParser));
                                } else if (TextUtils.equals(name, "VideoClicks")) {
                                    Cif.a(creative, "addClickThroughUrls", a(xmlPullParser, creative));
                                } else if (TextUtils.equals(name, "Icons")) {
                                    Cif.a(creative, "addIcons", f(xmlPullParser));
                                } else {
                                    k(xmlPullParser);
                                }
                            }
                        }
                    }
                } else {
                    k(xmlPullParser);
                }
            }
        }
        return creative;
    }

    private static List<Icon> f(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        ArrayList arrayList = new ArrayList();
        b(xmlPullParser, "Icons");
        while (n(xmlPullParser)) {
            if (m(xmlPullParser)) {
                if (TextUtils.equals(xmlPullParser.getName(), "Icon")) {
                    arrayList.add(g(xmlPullParser));
                } else {
                    k(xmlPullParser);
                }
            }
        }
        return arrayList;
    }

    private static Icon g(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        Icon icon = (Icon) Cif.a(Icon.class, new Object[0]);
        b(xmlPullParser, "Icon");
        a(icon, xmlPullParser, "program", "setProgram");
        a(icon, xmlPullParser, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setHeight");
        a(icon, xmlPullParser, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "setWidth");
        a(icon, xmlPullParser, "xPosition", "setHorizontalPosition");
        a(icon, xmlPullParser, "yPosition", "setVerticalPosition");
        a(icon, xmlPullParser, "apiFramework", "setApiFramework");
        a(icon, xmlPullParser, "offset", "setOffset");
        a(icon, xmlPullParser, "duration", "setDuration");
        while (n(xmlPullParser)) {
            if (m(xmlPullParser)) {
                String name = xmlPullParser.getName();
                if (Icon.IconResourceType.contains(name)) {
                    b(xmlPullParser, name);
                    String l = l(xmlPullParser);
                    Cif.a(icon, "setResourceType", name);
                    Cif.a(icon, "setResourceUrl", l);
                }
            }
        }
        return icon;
    }

    private static List<MediaFile> h(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        ArrayList arrayList = new ArrayList();
        b(xmlPullParser, "MediaFiles");
        while (n(xmlPullParser)) {
            if (m(xmlPullParser)) {
                if (TextUtils.equals(xmlPullParser.getName(), "MediaFile")) {
                    MediaFile mediaFile = (MediaFile) Cif.a(MediaFile.class, new Object[0]);
                    b(xmlPullParser, "MediaFile");
                    a(mediaFile, xmlPullParser, "id", "setId");
                    a(mediaFile, xmlPullParser, "delivery", "setDeliveryMethod");
                    a(mediaFile, xmlPullParser, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setHeight");
                    a(mediaFile, xmlPullParser, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "setWidth");
                    a(mediaFile, xmlPullParser, "bitrate", "setBitrate");
                    a(mediaFile, xmlPullParser, "type", "setMimeType");
                    Cif.a(mediaFile, "setUri", l(xmlPullParser));
                    arrayList.add(mediaFile);
                } else {
                    k(xmlPullParser);
                }
            }
        }
        return arrayList;
    }

    private static List<Block> i(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        ArrayList arrayList = new ArrayList();
        b(xmlPullParser, "Blocks");
        while (n(xmlPullParser)) {
            if (m(xmlPullParser)) {
                if (TextUtils.equals(xmlPullParser.getName(), "Block")) {
                    arrayList.add(j(xmlPullParser));
                } else {
                    k(xmlPullParser);
                }
            }
        }
        return arrayList;
    }

    private static Block j(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        Block block = (Block) Cif.a(Block.class, new Object[0]);
        b(xmlPullParser, "Block");
        Cif.a(block, "setType", xmlPullParser.getAttributeValue(null, "type"));
        Cif.a(block, "setId", xmlPullParser.getAttributeValue(null, "BlockID"));
        while (n(xmlPullParser)) {
            if (m(xmlPullParser)) {
                String name = xmlPullParser.getName();
                if (TextUtils.equals(name, "StartTime")) {
                    Cif.a(block, "setStartTime", l(xmlPullParser));
                } else if (TextUtils.equals(name, "Duration")) {
                    Cif.a(block, "setDuration", l(xmlPullParser));
                } else if (TextUtils.equals(name, "PositionsCount")) {
                    Cif.a(block, "setPositionsCount", l(xmlPullParser));
                } else {
                    k(xmlPullParser);
                }
            }
        }
        return block;
    }

    private static void k(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() == 2) {
            int i = 1;
            while (i != 0) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    i++;
                } else if (next == 3) {
                    i--;
                }
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: private */
    public static String l(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str;
        if (xmlPullParser.next() == 4) {
            str = xmlPullParser.getText();
            xmlPullParser.nextTag();
        } else {
            str = "";
        }
        return str.trim();
    }

    private static boolean m(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 2;
    }

    private static boolean n(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return xmlPullParser.next() != 3;
    }

    @Nullable
    public final tt a(String str) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        newPullParser.setInput(new StringReader(str));
        newPullParser.nextTag();
        b(newPullParser, "VAST");
        return b(newPullParser);
    }

    private static void a(XmlPullParser xmlPullParser, VideoAd videoAd) throws IOException, XmlPullParserException {
        a aVar = new a(videoAd, xmlPullParser, (byte) 0);
        String name = xmlPullParser.getName();
        if (TextUtils.equals(name, "Impression")) {
            a.a(aVar, "Impression", "addImpression");
        } else if (TextUtils.equals(name, "Error")) {
            a.a(aVar, "Error", "addError");
        } else if (TextUtils.equals(name, "Survey")) {
            a.a(aVar, "Survey", "setSurvey");
        } else if (TextUtils.equals(name, "Description")) {
            a.a(aVar, "Description", "setDescription");
        } else if (TextUtils.equals(name, "AdTitle")) {
            a.a(aVar, "AdTitle", "setAdTitle");
        } else if (TextUtils.equals(name, "AdSystem")) {
            a.a(aVar, "AdSystem", "setAdSystem");
        } else if (TextUtils.equals(name, "Creatives")) {
            Cif.a(videoAd, "addCreatives", d(xmlPullParser));
        } else {
            k(xmlPullParser);
        }
    }

    public final List<VideoAd> b(String str) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        newPullParser.setInput(new StringReader(str));
        newPullParser.nextTag();
        b(newPullParser, "VAST");
        while (n(newPullParser)) {
            if (m(newPullParser) && newPullParser.getName().equals("Ad")) {
                arrayList.add(c(newPullParser));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static void b(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        xmlPullParser.require(2, null, str);
    }

    private static List<String> a(XmlPullParser xmlPullParser, Creative creative) throws IOException, XmlPullParserException {
        ArrayList arrayList = new ArrayList();
        b(xmlPullParser, "VideoClicks");
        while (n(xmlPullParser)) {
            if (m(xmlPullParser)) {
                String name = xmlPullParser.getName();
                if (TextUtils.equals(name, "ClickThrough")) {
                    b(xmlPullParser, "ClickThrough");
                    arrayList.add(l(xmlPullParser));
                } else if (TextUtils.equals(name, "ClickTracking")) {
                    b(xmlPullParser, "ClickTracking");
                    String l = l(xmlPullParser);
                    if (!TextUtils.isEmpty(l)) {
                        Cif.a(creative, "addTrackingEvent", Tracker.Events.CREATIVE_CLICK_TRACKING, l);
                    }
                } else {
                    k(xmlPullParser);
                }
            }
        }
        return arrayList;
    }

    public static BlocksInfo c(String str) throws XmlPullParserException, IOException {
        BlocksInfo blocksInfo = (BlocksInfo) Cif.a(BlocksInfo.class, new Object[0]);
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        newPullParser.setInput(new StringReader(str));
        newPullParser.nextTag();
        b(newPullParser, "Blocksinfo");
        b bVar = new b(blocksInfo, newPullParser, (byte) 0);
        while (n(newPullParser)) {
            String name = newPullParser.getName();
            if (m(newPullParser)) {
                if (TextUtils.equals(name, "Version")) {
                    b.a(bVar, "Version", "setVersion");
                } else if (TextUtils.equals(name, "PartnerID")) {
                    b.a(bVar, "PartnerID", "setPartnerId");
                } else if (TextUtils.equals(name, "SessionID")) {
                    b.a(bVar, "SessionID", "setSessionId");
                } else if (TextUtils.equals(name, "CategoryID")) {
                    b.a(bVar, "CategoryID", "setCategoryId");
                } else if (TextUtils.equals(name, "CategoryName")) {
                    b.a(bVar, "CategoryName", "setCategoryName");
                } else if (TextUtils.equals(name, "Skin")) {
                    b.a(bVar, "Skin", "setSkin");
                } else if (TextUtils.equals(name, "VPAIDEnabled")) {
                    b.a(bVar, "VPAIDEnabled", "setVPaidEnabled");
                } else if (TextUtils.equals(name, "BufferEmptyLimit")) {
                    b.a(bVar, "BufferEmptyLimit", "setBufferEmptyLimit");
                } else if (TextUtils.equals(name, "Title")) {
                    b.a(bVar, "Title", "setTitle");
                } else if (TextUtils.equals(name, "SkipDelay")) {
                    b.a(bVar, "SkipDelay", "setSkipDelay");
                } else if (TextUtils.equals(name, "SkinTimeout")) {
                    b.a(bVar, "SkinTimeout", "setSkinTimeout");
                } else if (TextUtils.equals(name, "VPAIDTimeout")) {
                    b.a(bVar, "VPAIDTimeout", "setVpaidTimeout");
                } else if (TextUtils.equals(name, "WrapperTimeout")) {
                    b.a(bVar, "WrapperTimeout", "setWrapperTimeout");
                } else if (TextUtils.equals(name, "VideoTimeout")) {
                    b.a(bVar, "VideoTimeout", "setVideoTimeout");
                } else if (TextUtils.equals(name, "VASTTimeout")) {
                    b.a(bVar, "VASTTimeout", "setVastTimeout");
                } else if (TextUtils.equals(name, "TimeLeftShow")) {
                    b.a(bVar, "TimeLeftShow", "setShowTimeLeft");
                } else if (TextUtils.equals(name, "SkipTimeLeftShow")) {
                    b.a(bVar, "SkipTimeLeftShow", "setShowSkipTimeLeft");
                } else if (TextUtils.equals(name, "BufferFullTimeout")) {
                    b.a(bVar, "BufferFullTimeout", "setBufferFullTimeout");
                } else if (TextUtils.equals(name, "WrapperMaxCount")) {
                    b.a(bVar, "WrapperMaxCount", "setWrapperMaxCount");
                } else if (TextUtils.equals(name, "FirstBuffTimeout")) {
                    b.a(bVar, "FirstBuffTimeout", "setFirstBuffTimeout");
                } else if (TextUtils.equals(name, "Blocks")) {
                    Cif.a(blocksInfo, "addBlocks", i(newPullParser));
                } else {
                    k(newPullParser);
                }
            }
        }
        return blocksInfo;
    }

    private static void a(Object obj, XmlPullParser xmlPullParser, String str, String str2) throws IOException, XmlPullParserException {
        Cif.a(obj, str2, xmlPullParser.getAttributeValue(null, str));
    }
}

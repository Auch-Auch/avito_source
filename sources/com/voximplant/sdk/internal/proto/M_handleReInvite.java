package com.voximplant.sdk.internal.proto;

import a2.b.a.a.a;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.vk.sdk.api.model.VKApiCommunityFull;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.EndpointTracks;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.SessionDescription;
public class M_handleReInvite extends WSMessageCall {
    public Map<String, EndpointTracks> getEndpointTracks() {
        if (this.params.size() <= 2) {
            Logger.e("M_handleReinvite: getEndpointTracks: no information");
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            JsonObject asJsonObject = new JsonParser().parse((String) this.params.get(3)).getAsJsonObject().getAsJsonObject("endpoints");
            if (asJsonObject.size() > 0) {
                for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
                    String key = entry.getKey();
                    if (key == null || key.isEmpty()) {
                        key = (String) this.params.get(0);
                    }
                    JsonObject asJsonObject2 = entry.getValue().getAsJsonObject();
                    EndpointTracks endpointTracks = new EndpointTracks(asJsonObject2.getAsJsonPrimitive(VKApiCommunityFull.PLACE).getAsInt());
                    for (Map.Entry<String, JsonElement> entry2 : asJsonObject2.getAsJsonObject("tracks").entrySet()) {
                        String asString = entry2.getValue().getAsString();
                        char c = 65535;
                        int hashCode = asString.hashCode();
                        if (hashCode != 93166550) {
                            if (hashCode != 112202875) {
                                if (hashCode == 2054222044) {
                                    if (asString.equals("sharing")) {
                                        c = 2;
                                    }
                                }
                            } else if (asString.equals("video")) {
                                c = 1;
                            }
                        } else if (asString.equals("audio")) {
                            c = 0;
                        }
                        if (c == 0) {
                            endpointTracks.addAudioTrack(entry2.getKey());
                        } else if (c == 1) {
                            endpointTracks.addVideoTrack(entry2.getKey());
                        } else if (c == 2) {
                            endpointTracks.addScreenSharingTrack(entry2.getKey());
                        }
                    }
                    hashMap.put(key, endpointTracks);
                }
            }
            return hashMap;
        } catch (JsonParseException | ClassCastException e) {
            StringBuilder L = a.L("M_handleReinvite: getEndpointTracks: Failed to parse endpoint track info: ");
            L.append(e.getMessage());
            Logger.e(L.toString());
            return null;
        }
    }

    public Map<String, String> headers() {
        return (Map) this.params.get(1);
    }

    public String sdp() {
        if (this.params.size() > 1) {
            return (String) this.params.get(2);
        }
        return null;
    }

    public SessionDescription sdpOffer() {
        if (this.params.size() > 1) {
            return new SessionDescription(SessionDescription.Type.OFFER, sdp());
        }
        return null;
    }
}

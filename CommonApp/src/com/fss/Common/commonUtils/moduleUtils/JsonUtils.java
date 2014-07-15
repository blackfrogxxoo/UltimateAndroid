package com.fss.Common.commonUtils.moduleUtils;


import com.fss.Common.commonUtils.logUtils.Logs;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


import java.util.*;

/**
 * Use Gson to parse jsons
 *
 * @t unfinish
 */
public class JsonUtils {
    public static <T> T getListFromJson(String jsonString, TypeToken typeToken) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, typeToken.getType());
    }


    public static ArrayList getArrayListFromJson(String jsonString) {
        JsonParser jsonParser = new JsonParser();
        Gson gson = new Gson();
        JsonElement jsonElement = jsonParser.parse(jsonString);
        Logs.d(jsonElement.isJsonArray() + "   " + jsonElement.isJsonObject());
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
        if (jsonElement.isJsonObject()) {
            arrayList.add(gson.fromJson(jsonElement, HashMap.class));
        } else if (jsonElement.isJsonArray()) {
            arrayList = getListFromJson(jsonString, new TypeToken<ArrayList<HashMap<String, Object>>>() {
            });
        }
        return arrayList;
    }


    public static void iteratorArrayList(ArrayList arrayList) {
        Iterator it1 = arrayList.iterator();
        while (it1.hasNext()) {
            int i = 0;
            Iterator it = ((HashMap<String, String>) it1.next()).entrySet().iterator();
            while (it.hasNext()) {
                i++;
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                Logs.d("key--" + key + "  value   " + value + "\n");
            }
        }
    }
//    public static <T> T fromJSON(final TypeReference<T> type,
//                                 final String jsonPacket) {
//        T data = null;
//
//        try {
//            data = new ObjectMapper().readValue(jsonPacket, type);
//        } catch (Exception e) {
//            // Handle the problem
//        }
//        return data;
//    }

//    public <T>  T fromJson(com.google.gson.JsonElement json, java.lang.Class<T> classOfT) throws com.google.gson.JsonSyntaxException
//
//    public <T>  T fromJson(com.google.gson.JsonElement json, java.lang.reflect.Type typeOfT) throws com.google.gson.JsonSyntaxException


}

package com.example.a109590016_hw10;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWebData {
    public static String getHtml(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == 200) {
            InputStream in = conn.getInputStream();
            byte[] data = StreamTool.read(in);
            String html = new String(data, "UTF-8");
            return html;
        }
        return null;
    }
}

package net.scai.fitp.esb.client;

import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
/**
 * 天御服务API工具类
 */
class BspAPI {
    /* Basic request URL */
    private static final String URL = "csec.api.qcloud.com/v2/index.php";

    /**
    * 编码
    * @param bstr
    * @return String
    */
    private static String encode(byte[] bstr){
        return new BASE64Encoder().encode(bstr);
    }

    /* Signature algorithm using HMAC-SHA1 */
    public static String hmacSHA1(String key, String text) throws InvalidKeyException, NoSuchAlgorithmException
    {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(key.getBytes(), "HmacSHA1"));
        return encode(mac.doFinal(text.getBytes()));
    }

    /* Assemble query string */
    private static String makeQueryString(Map<String, String> args, String charset) throws UnsupportedEncodingException
    {
        String url = "";

        for (Map.Entry<String, String> entry : args.entrySet())
            url += entry.getKey() + "=" + (charset == null ? entry.getValue() : URLEncoder.encode(entry.getValue(), charset)) + "&";

        return url.substring(0, url.length()-1);
    }

    /* Generates an available URL */
    public static String makeURL(
        String method,
        String action,
        String region,
        String secretId,
        String secretKey,
        Map<String, String> args,
        String charset)
    throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException
    {
        SortedMap<String, String> arguments = new TreeMap<String, String>();

        /* Sort all parameters, then calculate signature */
        arguments.putAll(args);
        arguments.put("Nonce", String.valueOf((int)(Math.random() * 0x7fffffff)));
        arguments.put("Action", action);
        arguments.put("Region", region);
        arguments.put("SecretId", secretId);
        arguments.put("Timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        arguments.put("Signature", hmacSHA1(secretKey, String.format("%s%s?%s", method, URL, makeQueryString(arguments, null))));

        /* Assemble final request URL */
        return String.format("https://%s?%s", URL, makeQueryString(arguments, charset));
    }
}


/**
 * Http 请求工具类
 */
class ApiRequest {
    /**
     * Get 请求
     *
     * @param url    http请求地址
     * @param params http请求参数
     * @return String
     */
    public static ApiResponse sendGet(String url, String params) {
        BufferedReader br = null;
        ApiResponse response = new ApiResponse();
        try {
            String urlNameString = url;
            if(0 != params.length()) {
                String linkOperator = urlNameString.contains("?") ? "&" : "?";
                urlNameString += linkOperator + params;
            }

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection)new URL(urlNameString).openConnection();

            // 设置请求头
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            connection.connect();

            // 获取请求头字段
            Map<String, List<String>> header = connection.getHeaderFields();

            // 获取URL的输入流，读取请求响应
            String body = readString(connection.getInputStream());
            response.setHeader(header);
            response.setBody(body);

        } catch (Exception e) {
            System.out.println("发送GET请求出现异常!" + e);
            e.printStackTrace();
        }

        return response;
    }

    /**
     * POST 请求
     *
     * @param url    http请求地址
     * @param params http请求参数
     * @return String
     */
    public static ApiResponse sendPost(String url, String params) {
        PrintWriter pw = null;
        BufferedReader br = null;
        ApiResponse response = new ApiResponse();
        try {
            HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();

            // 设置请求头
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            // 设置 POST
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // Post 请求不能使用缓存
            connection.setUseCaches(false);

            connection.setConnectTimeout(5000);

            // 获取URL的输出流, 发送请求参数
            pw = new PrintWriter(connection.getOutputStream());
            pw.print(params);
            pw.flush();

            // 获取请求头字段
            Map<String, List<String>> header = connection.getHeaderFields();

            // 获取URL的输入流，读取请求响应
            String body = readString(connection.getInputStream());

            response.setHeader(header);
            response.setBody(body);

        } catch (Exception e) {
            System.out.println("发送POST请求出现异常!" + e);
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }


    private static String readString(InputStream is) {
        BufferedReader br = null;
        String content = "";
        try {
            br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String line;
            while ((line = br.readLine()) != null) {
                content += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return content;
    }
}
/**
 * Http 请求响应
 */
class ApiResponse {
    private Map header;
    private Object body;

    public ApiResponse() {
        this.header = new TreeMap();
        this.body = "";
    }

    public ApiResponse(Map header, String body) {
        this.header = header;
        this.body = body;
    }

    public void setHeader(Map header) {
        this.header = header;
    }

    public Map getHeader() {
        return this.header;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Object getBody() {
        return this.body;
    }
}

/* Demo section */
public class AntiFraud {

    public static void main(String[] argv) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException
    {
        /* 密钥,请进行替换,密钥申请地址 https://console.qcloud.com/capi  */
        final String SECRET_ID = "AKID2vdDdshoUyOdgkHK0Wu7BB2jFZilOKqB";
        final String SECRET_KEY = "JRXXVL3d2FH7vdEl7HKBsNm15xd7PVQ9";

        Map<String, String> args = new TreeMap<String, String>();

        // 基本字段
        args.put("idNumber", "350322197910031575");
        args.put("phoneNumber", "0086-15926464343");
        // 可选字段
        args.put("name", "林炼");

        String url = BspAPI.makeURL("GET", "AntiFraud", "gz", SECRET_ID, SECRET_KEY, args, "utf-8");
//        System.out.println(url);
        url = "http://192.168.1.240:8280/services/RESTAPI";
        ApiResponse res = ApiRequest.sendGet(url, "");
        System.out.println(res.getBody());
    }
}

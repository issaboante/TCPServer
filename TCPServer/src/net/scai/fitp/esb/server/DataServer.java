package net.scai.fitp.esb.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import sun.misc.BASE64Encoder;

public class DataServer {
	
	public final static int PORT = 6062;
	
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {
		
		ExecutorService pool = Executors.newFixedThreadPool(50);
		
		try (ServerSocket server = new ServerSocket(PORT) ) {
			while (true) {
				try {
					Socket connection = server.accept();
					String url = makeURL(createMap(connection));
					System.out.println(url);
					ApiResponse res = sendGet(url, "");
					System.out.println(res.getBody());
					
					
					OutputStream out = connection.getOutputStream();
					Writer writer = new OutputStreamWriter(out, "UTF-8");
					writer.write(res.getBody().toString());
					writer.flush();
					connection.shutdownOutput();
					Callable<Void> task = new DataTask(connection);
					pool.submit(task);
				} catch (IOException e) {
					System.err.println(e);
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public static Map<String, String> createMap(Socket connection) throws IOException {
		InputStream is = connection.getInputStream();
		Scanner scanner = new Scanner(is, "UTF-8");
		String text = scanner.next();
		JSONObject datajson = new JSONObject(text);
		Map<String, Object> map = datajson.toMap();
		
		Map<String, String> mapstring = new HashMap<String, String>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			mapstring.put(entry.getKey(), entry.getValue().toString());
		}

		connection.shutdownInput();
		return mapstring;
	}
	
	public static String makeQueryString (Map<String, String> map, String charset) throws UnsupportedEncodingException {
		
		String url = "";

        for (Map.Entry<String, String> entry : map.entrySet())
            url += entry.getKey() + "=" + (charset == null ? entry.getValue() : URLEncoder.encode(entry.getValue(), charset)) + "&";

        return url.substring(0, url.length()-1);
	}
	
	public static String makeURL(Map<String, String> args)
	    throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException
	    {
	        SortedMap<String, String> arguments = new TreeMap<String, String>();

	        /* Sort all parameters, then calculate signature */
	        arguments.putAll(args);
	        arguments.put("Nonce", String.valueOf((int)(Math.random() * 0x7fffffff)));
	        arguments.put("Action", "AntiFraud");
	        arguments.put("Region", "gz");
	        arguments.put("SecretId", "AKID2vdDdshoUyOdgkHK0Wu7BB2jFZilOKqB");
	        arguments.put("Timestamp", String.valueOf(System.currentTimeMillis() / 1000));
	        arguments.put("Signature", hmacSHA1("JRXXVL3d2FH7vdEl7HKBsNm15xd7PVQ9", String.format("%s%s?%s", "GET", "csec.api.qcloud.com/v2/index.php", makeQueryString(arguments, null))));

	        /* Assemble final request URL */
	        return String.format("http://%s?%s", "192.168.1.240:8280/v2/index.php", makeQueryString(arguments, "UTF-8"));
	    }
	
	public static String hmacSHA1(String key, String text) throws InvalidKeyException, NoSuchAlgorithmException {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(key.getBytes(), "HmacSHA1"));
        return encode(mac.doFinal(text.getBytes()));
    }
	
	private static String encode(byte[] bstr){
        return new BASE64Encoder().encode(bstr);
    }
	
	
	public static ApiResponse sendGet(String url, String params) {
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

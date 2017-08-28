package cm.shm.https;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class MyX509TrustManager implements X509TrustManager {
	X509TrustManager sunJSSEX509TrustManager;
	private static final String TRUST_MANAGER_ALGORITHM = "SunX509";
	private static final String TRUEST_PROVIDER = "SunJSSE";
	private static final String CERTS_PWD = "bhstorekey";
	private static final String FILE_PATH = "D:\\tomcatkey\\BHbank.keystore";
	// 构造方法初始化证书信息
	MyX509TrustManager() throws Exception {
		// 获得keystore实例
		KeyStore ks = KeyStore.getInstance("JKS");
		// keystore文件流、密码
		ks.load(new FileInputStream(FILE_PATH), CERTS_PWD.toCharArray());

		// algorithm:加密方式

		// provider:提供者

		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TRUST_MANAGER_ALGORITHM, TRUEST_PROVIDER);
		// 信任管理器初始化证书
		tmf.init(ks);
		TrustManager[] tms = tmf.getTrustManagers();
		for (TrustManager tm : tms) {
			if (tm instanceof X509TrustManager) {
				sunJSSEX509TrustManager = (X509TrustManager) tm;
				return;
			}
		}
		// 如果都没有发现，抛出异常
		throw new Exception("Couldn'tinitialize!");
	}

	// 检测客户端是否信任程序
	public void checkClientTrusted(X509Certificate[] chain, String authType){
        try {
            sunJSSEX509TrustManager.checkClientTrusted(chain,authType);
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }

	// 检测服务器端是否信任程序
	public void checkServerTrusted(X509Certificate[] chain, String authType){
        try {
            sunJSSEX509TrustManager.checkServerTrusted(chain,authType);
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }

	// 获得信任的发型证书
	public X509Certificate[] getAcceptedIssuers() {
		return sunJSSEX509TrustManager.getAcceptedIssuers();
	}

}
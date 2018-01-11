package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestHttp {
	public static String sendPost(String url, String param) {
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = null;
			conn = (HttpURLConnection) realUrl.openConnection();
			// �򿪺�URL֮�������
			// ����POST�������������������
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST"); // POST����

			// ����ͨ�õ���������
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.connect();
			// ��ȡURLConnection�����Ӧ�������
			out = new OutputStreamWriter(conn.getOutputStream(), "GBK");
			// �����������
			out.write(param);
			// flush������Ļ���
			out.flush();
			// ����BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("���� POST ��������쳣��" + e);
			e.printStackTrace();
		}
		// ʹ��finally�����ر��������������
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
	//	for(int i=0;i<100;i++){
			String str=	sendPost("http://localhost:8082/zwpt/savePingBanShouLi.action", "jsonStr={'serviceoid':'114245','projectname':'��α˰��ϵͳ��߿�Ʊ�޶���������','userId':'402880fe5de3b0fc015de4b238b812cc','sljtdd':'������','sqdwhsqrmc':'����','sqdwjbrxm':'���','sqdwlxdh':'','sqdwjbrsj':'15319826085','sqdwhsqrdz':'����ʡ�����к�̨����������10��10��','sqrtype':'1','cardtype':'1','cardid':'612301198206112118','status':'1','number':'963003'}");
		System.out.println(str);
	//	}
	}
}

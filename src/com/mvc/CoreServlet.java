package com.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hua.util.SignUtil;

public class CoreServlet extends HttpServlet{

	private static final long serialVersionUID = 4440739483644821986L;  
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		super.doGet(request, resp);
		   // ΢�ż���ǩ��  
        String signature = request.getParameter("signature");  
        // ʱ���  
        String timestamp = request.getParameter("timestamp");  
        // �����  
        String nonce = request.getParameter("nonce");  
        // ����ַ���  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close();  
        out = null;
	}
	
	
	   /** 
     * ����΢�ŷ�������������Ϣ 
     */  
	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        // TODO ��Ϣ�Ľ��ա�������Ӧ  
    }  
}

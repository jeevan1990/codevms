package net.BiometricMatch;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * Example how to use multipart/form encoded POST request.
 */
public class ClientMultipartFormPost {

    public String submitForm(byte[] filedata,String personId,String fingerIndex) throws Exception {
        
    	System.out.println(" in fingerprint post web service call ");
       //CloseableHttpClient httpclient = HttpClients.createDefault();
    	//HttpClient httpclient = HttpClientBuilder.create().build();
    	
    	HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpPost httppost = new HttpPost("http://localhost:8080/vms/uploadFingerprint.htm");
            
            File file = new File("D:\\temp\\temp.jpg");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(filedata);
            fos.flush();
            FileBody bin = new FileBody(file);
            StringBody prsId = new StringBody(personId, ContentType.TEXT_PLAIN);
            StringBody fIndex = new StringBody(fingerIndex, ContentType.TEXT_PLAIN);
            //StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);


            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("fingerprint", bin)
                    .addPart("personId", prsId)
                    .addPart("fingerindex", fIndex)
                    .build();


            httppost.setEntity(reqEntity);

            System.out.println("executing request " + httppost.getRequestLine());
           // CloseableHttpResponse response = httpclient.execute(httppost);
            HttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
   
                HttpEntity resEntity = response.getEntity();
                byte[] responsetosend=IOUtils.toByteArray(resEntity.getContent());
                if (resEntity != null) {
                    System.out.println("Response content length: " + resEntity.getContentLength());
                   
                    
                    System.out.println("Response to send: "+new String(responsetosend) );
                }
                EntityUtils.consume(resEntity);
                return new String(responsetosend);
            } finally {
                //response.close();
            	fos.close();
            	//if(file!=null)
            		//file.delete();
            }
        } finally {
           // httpclient.close();
        }
    }

}

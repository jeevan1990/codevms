package net.BiometricMatch;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class RegisterClientFingerprint {

	
    public void submitForm(byte[] filedata,String personId,String fingerIndex) throws Exception {

    	
    	System.out.println(" in registration post web service call ");
    	File file = new File("D:\\joy\\Image002.jpg");
    	HttpPost post = new HttpPost("http://localhost:8080/vms/uploadFingerprint.htm");
    	FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);
    	StringBody stringBody1 = new StringBody("Message 1", ContentType.MULTIPART_FORM_DATA);
    	StringBody stringBody2 = new StringBody("Message 2", ContentType.MULTIPART_FORM_DATA);
    	// 
    	MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    	builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
    	builder.addPart("fingerprint", fileBody);
    	builder.addPart("personId", stringBody1);
    	builder.addPart("fingerindex", stringBody2);
    	HttpEntity entity = builder.build();
    	//
    	post.setEntity(entity);
    	HttpClient client = new DefaultHttpClient();
    	HttpResponse response = client.execute(post);
    	System.out.println(" web service response got "+response.toString());
    }
}

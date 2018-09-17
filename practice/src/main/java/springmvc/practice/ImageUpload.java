package springmvc.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import ecommerce.model.productdetails.Product;
@Service
public class ImageUpload {
	public void saveImage(Product product,HttpServletRequest request)
	{
		String contextPath=request.getRealPath("/");
		File file=new File(contextPath+"/resources/resource/products/");
		if(!file.exists())
		{
			file.mkdir();
		}
		 System.out.println(file.getPath());
         FileOutputStream fileOutputStream=null;
		try {
			fileOutputStream=new FileOutputStream(file.getPath()+"/"+product.getProduct_id()+".jpg");
			InputStream inputStream=product.getImage().getInputStream();
			byte[] bytes=new byte[inputStream.available()];
			inputStream.read(bytes);
			
			fileOutputStream.write(bytes);
			fileOutputStream.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 try {
                 fileOutputStream.close();
             } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
		}
        
		
	}

}

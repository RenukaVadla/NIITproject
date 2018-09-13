package springmvc.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;


import ecommerce.model.productdetails.Product;

public class ImageUpload {
	
	public void saveImage(Product product,HttpServletRequest request)
	{
		String contextPath=request.getRealPath("/");
		FileOutputStream fileOutputStream=null;
		File file=new File(contextPath+"/resources/resource/products/");
		if(!file.exists())
		{
			file.mkdir();
		}
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
		}
        
		
	}

}

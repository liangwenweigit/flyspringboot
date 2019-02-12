package com.fly.flyspringboot.controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fly.flyspringboot.domain.JsonData;
import com.fly.flyspringboot.utils.CommonUtils;

@Controller
@RequestMapping("/file")
public class FileController {
	@Value("${my.upload.imgPath}")
    private String imgPath;
	@RequestMapping("/upload")
	@ResponseBody
	public JsonData upLoad(@RequestParam("head_img") MultipartFile file,HttpServletRequest request){
		//file.isEmpty();判断图片是否为空
		//file.getSize();图片大小进行判断
		String name = request.getParameter("name");
		System.err.println("用户名："+name);
		//获取文件名
		String fileName = file.getOriginalFilename();
		//用uuid补全文件名
		fileName = CommonUtils.getUUID()+fileName;
		//获取项目存储文件的基本路径，并且接拼一层时间作为存放图片的目录
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//把时间提取出来并置换掉横线 
		String timer = sdf.format(new Date()).toString().replace("-", "");
		//创建文件夹，测试看看存在不 不存在就创建
		String savePath = imgPath+timer+"/";
		File fileSavePath = new File(savePath);
		if(!fileSavePath.exists()){fileSavePath.mkdirs();}
		//根据创建的路径 +文件名保存文件
		File dest = new File(fileSavePath,fileName);
		//写出到上面指定的目录
		try {
			file.transferTo(dest);
			return JsonData.buildSuccess(fileName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return JsonData.buildError("上传失败");
	}
}

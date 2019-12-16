<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File"%>
<%@page import="java.awt.Graphics2D"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.media.jai.JAI"%>
<%@page import="javax.media.jai.RenderedOp"%>
<%@page import="java.awt.image.renderable.ParameterBlock"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String uploadPath=request.getRealPath("/image"); //실제 서버의 폴더위치
 int size= 1024*1024*10; //10메가(기본값 byte)
 
 MultipartRequest multi = new MultipartRequest(request,uploadPath,
   size,"UTF-8",new DefaultFileRenamePolicy());
 
 //실제 서버에 저장된 파일이름
 String filename1= multi.getFilesystemName("filename"); 
 //올린 파일이름
 String origfilename1=multi.getOriginalFileName("filename");
 
 ParameterBlock pb = new ParameterBlock();
 pb.add(uploadPath+"/"+filename1);
 RenderedOp rOp=JAI.create("fileload", pb);
 
 BufferedImage bi=rOp.getAsBufferedImage();
 BufferedImage thumb=new BufferedImage(100,100,BufferedImage.TYPE_INT_BGR);
 Graphics2D g=thumb.createGraphics();
 g.drawImage(bi, 0, 0, 100, 100, null);
 File file=new File(uploadPath+"/sm_"+filename1);
 ImageIO.write(thumb, "jpg", file);
 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=uploadPath %>
</body>
</html>
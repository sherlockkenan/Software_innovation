package com.example.resume2;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class ResumeController {

    @RequestMapping(value="/resume", method= RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<byte[]> resume(@RequestParam(value = "username", required = false) String username,
                                         @RequestParam(value = "template", required = false) String template,
                                         @RequestBody String json) {
        //System.out.println(username);
        //System.out.println(template);
        //System.out.println(json);
        try
        {
            String filedir="db/"+username;
            String filename=username+".json";
            String resultname=username+".html";

            File folder = new File(filedir);
            if (!folder.exists() && !folder.isDirectory()) {
                folder.mkdirs();
            }
            File f = new File(filedir+"/"+filename);
            FileOutputStream fop = new FileOutputStream(f);
            // 构建FileOutputStream对象,文件不存在会自动新建
            OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
            // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
            writer.append(json);
            // 写入到缓冲区
            // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入
            writer.close();
            // 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
            fop.close();
            // 关闭输出流,释放系统资源

            String exec="hackmyresume BUILD "+filedir + "/" + filename+ " TO "
                    + filedir + "/" + resultname + " -t "
                    + "resume_server/node_modules/jsonresume-theme-" + template;
            //System.out.println(exec);
            Process process=Runtime.getRuntime().exec(exec);
            int status=process.waitFor();
            if(status != 0){
                System.err.println("Failed to call shell's command and the return status's is: " + status);
                String errormessage="<html lang=\"zh-CN\">\n" +
                        "<head>\n" +
                        "    <title>Error</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "shit happens!\n" +
                        "</body>\n" +
                        "</html>";
                return ResponseEntity.ok()
                        .contentType(MediaType.TEXT_HTML)
                        .body(errormessage.getBytes());
            }

            byte[] bytes = Files.readAllBytes(Paths.get(filedir+"/"+resultname));
            //System.out.println(file.getAbsolutePath());
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_HTML)
                    .body(bytes);
        }
        catch(Exception e)
        {
            String errormessage="<html lang=\"zh-CN\">\n" +
                    "<head>\n" +
                    "    <title>Error</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "shit happens!\n" +
                    "</body>\n" +
                    "</html>";
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_HTML)
                    .body(errormessage.getBytes());
        }
    }
}

package com.example.resume1;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

@Controller
public class ResumeController {

    public static String basichelper(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9)
    {
        String result="\"basics\":{\n"
                +"\"name\":\""+s1+"\",\n"
                +"\"label\":\""+s2+"\",\n"
                +"\"email\":\""+s3+"\",\n"
                +"\"phone\":\""+s4+"\",\n"
                +"\"location\":{\n"
                +"\"address\":\""+s5+"\",\n"
                +"\"postalCode\":\""+s6+"\",\n"
                +"\"city\":\""+s7+"\",\n"
                +"\"countryCode\":\""+s8+"\",\n"
                +"\"region\":\""+s9+"\"\n}\n},\n";
        return result;
    }

    public static String workhelper(String s1,String s2,String s3,String s4,String s5,String s6)
    {
        String result="\"work\":[{\n"
                +"\"company\":\""+s1+"\",\n"
                +"\"position\":\""+s2+"\",\n"
                +"\"website\":\""+s3+"\",\n"
                +"\"startDate\":\""+s4+"\",\n"
                +"\"endDate\":\""+s5+"\",\n"
                +"\"summary\":\""+s6+"\"\n}],\n";
        return result;
    }

    public static String educationhelper(String s1,String s2,String s3,String s4,String s5)
    {
        String result="\"education\":[{\n"
                +"\"institution\":\""+s1+"\",\n"
                +"\"area\":\""+s2+"\",\n"
                +"\"studyType\":\""+s3+"\",\n"
                +"\"startDate\":\""+s4+"\",\n"
                +"\"endDate\":\""+s5+"\"\n}],\n";
        return result;
    }

    public static String awardhelper(String s1,String s2,String s3)
    {
        String result="\"awards\":[{\n"
                +"\"title\":\""+s1+"\",\n"
                +"\"date\":\""+s2+"\",\n"
                +"\"awarder\":\""+s3+"\"\n}],\n";
        return result;
    }

    public static String publicationhelper(String s1,String s2,String s3,String s4,String s5)
    {
        String result="\"publications\":[{\n"
                +"\"name\":\""+s1+"\",\n"
                +"\"publisher\":\""+s2+"\",\n"
                +"\"releaseDate\":\""+s3+"\",\n"
                +"\"website\":\""+s4+"\",\n"
                +"\"summary\":\""+s5+"\"\n}],\n";
        return result;
    }

    public static String interesthelper(String s1,String s2,String s3,String s4)
    {
        String result="\"interests\":[{\n"
                +"\"name\":\""+s1+"\",\n"
                +"\"keyswords\":[\n"
                +"\""+s2+"\",\n"
                +"\""+s3+"\",\n"
                +"\""+s4+"\"\n]\n}]\n";
        return result;
    }

    @RequestMapping("/")
    public String main_entry(HttpSession session, Model model) {
        if(session.getAttribute("user")==null)
        {
            System.out.println("mainentry: model no user");

            model.addAttribute("user",new User());
            return "login";
        }
        User user=(User)session.getAttribute("user");
        if(user.getUsername().isEmpty())
        {
            System.out.println("mainentry: user name is empty");

            model.addAttribute("user",new User());
            return "login";
        }
        String[] strs={"spartan",

                "Docker","Seeking a position as a summer intern in 2018","ce.gao@outlook.com","1592 1592 066",
                "800 Dongchuan RD. Minhang District","200240","Shanghai","86","China",

                "Google Summer of Code 2017","Student Participant","https://summerofcode.withgoogle.com/","2017-05",
                "2017-08","Implemented R mode for Processing with the sponsorship of Google",

                "Shanghai Jiao Tong University","Software Engineering","Master","2016-09","2019-03",

                "13th National Post-Graduate Mathematic Contest in Modeling(NPGMCM)","2016-12","Second Prize",

                "scrala","Ce Gao","2015-12","http://gaocegege.com/scrala/","The framework for writing spiders written in scala, got 70 stars in GitHub",

                "Programming","Scala","Docker","OS"
        };
        ResumeInfo resumeinfo=new ResumeInfo(strs);
        model.addAttribute("resumeinfo",resumeinfo);
        return "index";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute User user,HttpSession session) {
        System.out.println("name: "+user.getUsername()+"  password: "+user.getPassword());

        String filename="db";
        try
        {
            File file=new File("userdb");
            if(!file.exists()||!file.isFile())
            {
                file.createNewFile();
                FileOutputStream outStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
                HashMap<String,String>map=new HashMap<String,String>();
                map.put("root","root");
                objectOutputStream.writeObject(map);
                objectOutputStream.close();
                outStream.close();
            }
            System.out.println("here1");
            FileInputStream freader=new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(freader);
            HashMap<String,String> map = new HashMap<String,String>();
            map = (HashMap<String, String>) objectInputStream.readObject();
            objectInputStream.close();
            freader.close();
            System.out.println("here2");

            if(!map.containsKey(user.getUsername()))
            {
                if(user.getPassword().isEmpty())
                {
                    System.out.println("here3");
                    return "loginerror";
                }
                map.put(user.getUsername(),user.getPassword());

                FileOutputStream outStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
                objectOutputStream.writeObject(map);
                objectOutputStream.close();
                outStream.close();

                System.out.println("create new user");
                session.setAttribute("user",user);
                return "forward:/";
            }
            if(!user.getPassword().equals(map.get(user.getUsername())))
            {
                System.out.println("wrong number");
                return "loginerror";
            }
        }
        catch(Exception e)
        {
            System.out.println("some exception happens");
            return "loginerror";
        }
        System.out.println("some exception happens");
        return "loginerror";
    }

    @RequestMapping(value="/resume", method= RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> resume(@ModelAttribute ResumeInfo resumeinfo) {
        String json="{\n"+basichelper(resumeinfo.getBasicname(), resumeinfo.getBasiclabel(),resumeinfo.getBasicemail(),
                resumeinfo.getBasicphone(),resumeinfo.getBasiclocationaddress(),resumeinfo.getBasiclocationpostalcode(),
                resumeinfo.getBasiclocationcity(),resumeinfo.getBasiclocationcountrycode(),resumeinfo.getBasiclocationregion())
                +workhelper(resumeinfo.getWorkcompany(),resumeinfo.getWorkposition(),resumeinfo.getWorkwebsite(),
                resumeinfo.getWorkstartdate(),resumeinfo.getWorkenddate(),resumeinfo.getWorksummary())
                +educationhelper(resumeinfo.getEducationinstitution(),resumeinfo.getEducationarea(),
                resumeinfo.getEducationstudytype(),resumeinfo.getEducationstartdate(),resumeinfo.getEducationenddate())
                +awardhelper(resumeinfo.getAwardtitle(),resumeinfo.getAwarddate(),resumeinfo.getAwardwarder())
                +publicationhelper(resumeinfo.getPublicationname(),resumeinfo.getPublicationpublicsher(),
                resumeinfo.getPublicationreleasedate(),resumeinfo.getPublicationwebsite(),resumeinfo.getPublicationsummary())
                +interesthelper(resumeinfo.getInterestname(),resumeinfo.getInterestkeyword1(),
                resumeinfo.getInterestkeyword2(),resumeinfo.getInterestkeyword3())+"}";
        //System.out.println(json);
        //System.out.println("here1");

        String resulthtml="";

        //构建HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //构建POST请求
        HttpPost httpPost = new HttpPost("http://resume2-jar:30564/resume?"+"username="+resumeinfo.getBasicname()+"&template="+resumeinfo.getTemplate());
        InputStream inputStream = null;
        CloseableHttpResponse response = null;
        //System.out.println("here2");
        try {
            StringEntity s = new StringEntity(json);
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            httpPost.setEntity(s);
            //发送请求
            response = client.execute(httpPost);
            //System.out.println("here3");
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(response.getEntity());// 返回json格式：
                //System.out.println(result);
                //System.out.println("here4");
                return ResponseEntity.ok()
                        .contentType(MediaType.TEXT_HTML)
                        .body(result);
            }
        } catch (IOException e) {
            //System.out.println("here5");
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                //System.out.println("here6");
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //System.out.println("here7");
        //System.out.println(file.getAbsolutePath());
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
                .body(errormessage);
    }
}

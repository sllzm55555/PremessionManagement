package com.lovo.springboot.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class JSONPController {

    @RequestMapping("jsonpRequest")
    public void jsonpRequest(HttpServletResponse response, @RequestParam String callBack){

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(callBack + "(");
            writer.write("{userName:'admin', password:'123'}");
            writer.write(");");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }
}

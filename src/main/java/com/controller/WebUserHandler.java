package com.controller;

import com.entity.WebUser;
import com.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/webuser")
public class WebUserHandler {

    @Autowired
    private WebUserService webUserService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, String> login(HttpServletRequest httpServletRequest){
        Map<String, String> map = new HashMap<String, String>();
        String id = httpServletRequest.getParameter("ID");
        String password = httpServletRequest.getParameter("password");
        HttpSession httpSession = httpServletRequest.getSession();
        map = webUserService.login(id,password);
        httpSession.setAttribute("privilege",map.get("privilege"));
        return map;
    }

    @RequestMapping("/regist")
    @ResponseBody
    public Map<String,String> regist(HttpServletRequest httpServletRequest){
        Map<String,String> map = new HashMap<String,String>();
        String id = httpServletRequest.getParameter("ID");
        String password = httpServletRequest.getParameter("password");
        String privilege_s = httpServletRequest.getParameter("privilege");
        if (privilege_s==""||privilege_s==null){
            privilege_s = "2";
        }
        int privilege = Integer.valueOf(privilege_s);
        WebUser webUser = new WebUser();
        webUser.setId(id);
        webUser.setPassword(password);
        webUser.setPrivilege(privilege);
        map.put("ending",webUserService.regist(webUser));
        return map;

    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Map<String,String> updateUser(HttpServletRequest httpServletRequest){
        Map<String,String> map = new HashMap<String,String>();
        String id = httpServletRequest.getParameter("ID");
        String id_p = httpServletRequest.getParameter("id_p");
        String password = httpServletRequest.getParameter("password");
        String privilege_s = httpServletRequest.getParameter("privilege");
        if (privilege_s==""||privilege_s==null){
            privilege_s = "2";
        }
        int privilege = Integer.valueOf(privilege_s);
        WebUser webUser = new WebUser();
        webUser.setId(id);
        webUser.setPassword(password);
        webUser.setPrivilege(privilege);
        System.out.println(id+id_p+password+privilege+"--------------------------");
        map.put("ending",webUserService.updateUser(webUser,id_p));
        return map;

    }

    @RequestMapping("/getWebuser")
    @ResponseBody
    public List<WebUser> getWebuser(HttpServletRequest httpServletRequest){
        List<WebUser> webUsers = new ArrayList<>();
        webUsers = webUserService.getWebuser();
        return webUsers;
    }

    @RequestMapping("/getWebuserByID")
    @ResponseBody
    public List<WebUser> getWebuserByID(HttpServletRequest httpServletRequest){
        List<WebUser> webUsers = new ArrayList<>();
        String id =httpServletRequest.getParameter("id");
        System.out.println(id);
        webUsers = webUserService.getWebuserByID(id);
        return webUsers;
    }

    @RequestMapping("/deleteUserById")
    @ResponseBody
    public void deleteUserById(HttpServletRequest httpServletRequest){
        String id = (String) httpServletRequest.getParameter("id");
        System.out.println(id);
        webUserService.deleteUserById(id);
    }
}

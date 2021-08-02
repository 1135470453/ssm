package com.service.impl;

import com.entity.WebUser;
import com.repository.WebUserRepository;
import com.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WebUserServiceImpl implements WebUserService {

    @Autowired
    private WebUserRepository webUserRepository;

    @Override
    public Map<String,String> login(String id, String password) {
        Map<String,String> map = new HashMap<String,String>();
        if(webUserRepository.getPriviegeByIdAndPwd(id,password)!=null){
            System.out.println("找到用户");
            Integer privilege = webUserRepository.getPriviegeByIdAndPwd(id,password);
            System.out.println("login--------------privilege:"+privilege.toString());
            map.put("ending","right");
            map.put("privilege",privilege.toString());
            return map;
        }else{
            System.out.println("登陆失败");
            map.put("ending","error");
            return map;
        }

    }

    @Override
    public String regist(WebUser webUser) {
        if (webUserRepository.getIdById(webUser.getId())!=null){
            return "exist";
        }else{
            try {
                webUserRepository.insetWebUser(webUser);
                return "right";
            }catch(Error error){
                System.out.println("regist error:"+error);
                return "error";
            }
        }
    }

    @Override
    public List<WebUser> getWebuser() {
        return webUserRepository.getWebuser();
    }

    @Override
    public List<WebUser> getWebuserByID(String id) {
        return webUserRepository.getWebuserByID(id);
    }

    @Override
    public void deleteUserById(String id) {
        webUserRepository.deleteUserById(id);
    }

    @Override
    public String updateUser(WebUser webUser, String id_p) {
        if (id_p.equals(webUser.getId())){
            try {
                webUserRepository.updataUser(webUser.getId(),webUser.getPassword(),String.valueOf(webUser.getPrivilege()),id_p);
                return "right";
            }catch(Error error){
                System.out.println("regist error:"+error);
                return "error";
            }
        }else {
            if (webUserRepository.getIdById(webUser.getId())!=null){
                return "exist";
            }else{
                try {
                    webUserRepository.updataUser(webUser.getId(),webUser.getPassword(),String.valueOf(webUser.getPrivilege()),id_p);
                    return "right";
                }catch(Error error){
                    System.out.println("regist error:"+error);
                    return "error";
                }
            }
        }

    }
}

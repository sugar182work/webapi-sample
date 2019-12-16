package com.sugars.webapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.sugars.webapi.domain.User;
import com.sugars.webapi.service.UserService;

@RestController		//WebAPIの機能を追加するアノテーション
@Validated 			//バリデーションを使用するアノテーション
@RequestMapping("/v1/api/users")
public class UserController {
     
    @RequestMapping(value = "/test")	//URL「〜/test」にアクセスされたときのアノテーション
    public String test() {
        return "{\"result\": \"test OK\"}";

    }
    
    @Autowired
    UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findUsers();
    }
    
    @RequestMapping(method=RequestMethod.GET, value="{userid}")	//URL「〜/user」にアクセスされたときのアノテーション
    public User getUser(@PathVariable("userid") Long userid) {
    	return (User) userService.findUser(userid).get();
    } 
    
    /**
     * ユーザ情報を登録する
     * TODO POSTで更新が可能.チェック方法検討中
     * @param user ユーザをPOSTに設定
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public User createUser(@Validated @RequestBody User user) {
        //return userService.save(user);
    	return userService.save(user);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="{userid}")
    public User updateUser(@PathVariable("userid") Long userid, @RequestBody User user) {
        user.setUserid(userid);
        return userService.save(user);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="{userid}")
    public void deleteUser(@PathVariable("userid") Long userid) {
        userService.delete(userid);
    }
    
    
}

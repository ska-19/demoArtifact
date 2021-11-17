package com.exampleWeb.demoArtifact;
import com.exampleWeb.demoArtifact.ErrorM.ErrorNotAdmin;
import com.exampleWeb.demoArtifact.ErrorM.ErrorSameName;
import com.exampleWeb.demoArtifact.ErrorM.ErrorUsernameOrPassword;
import com.exampleWeb.demoArtifact.ErrorM.UserNotFound;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
//@Controller

@RestController
public class UserPWController {
    private List<UserPW> UserList = new ArrayList<>();

    // 1) Добавляет пользователя в список
    /*
    curl -X POST http://localhost:8080/userList -H 'Content-Type: application/json' -d '{"username":"Kirill","password":"qwe","age": 17}'
    curl -X POST http://localhost:8080/userList -H 'Content-Type: application/json' -d '{"username":"updateKirill","password":"qweaaa","age": 23}'
    curl -X POST http://localhost:8080/userList -H 'Content-Type: application/json' -d '{"username":"adminD","password":"qqqqq","age": 12}'
    */
    @PostMapping("userList")
    public void addUser(@RequestBody UserPW user) throws ErrorUsernameOrPassword, ErrorSameName {

        String name = user.getUsername();
        char[] xArr = name.toCharArray();
        for (char x:xArr){
//            int i = (int) x;
            if(x>122||x<48){throw new ErrorUsernameOrPassword();}
            if (57<x&&x<65){throw new ErrorUsernameOrPassword();}
            if (90<x&&x<97){throw new ErrorUsernameOrPassword();}
        }
        for (int i = UserList.size()-1; i>-1; i--){
            if(UserList.get(i).getUsername().equals(name)){throw new ErrorSameName();}
        }
        UserList.add(user);
    }
//    @RequestMapping(method = RequestMethod.PUT)

    // 2) Выводит пользователя по имени
    /*
    curl -X GET http://localhost:8080/userList -H 'Content-Type: application/json' -d 'Kirill'
    curl -X GET http://localhost:8080/userList -H 'Content-Type: application/json' -d '"adminKirill"'
    */
    @GetMapping("userList")
    public UserPW getUser(@RequestBody String name) throws UserNotFound {
        for (int i = UserList.size()-1; i>-1; i--){
            if(UserList.get(i).getUsername().equals(name)){ return UserList.get(i);}
            else if(i==0){ throw new UserNotFound();}
        }
        return null;
    }

    // 3) Удаляет пользователя по имени
    /*
    curl -X DELETE http://localhost:8080/userList -H 'Content-Type: application/json' -d 'Kirill'
    */
    @DeleteMapping("userList")
    public void deleteUser(@RequestBody String name) throws UserNotFound, ErrorNotAdmin {
        //403
        if(name.length()<5){ throw new ErrorNotAdmin();}
        else if(!name.startsWith("admin")){throw new ErrorNotAdmin();}

        //404
        for (int i = UserList.size()-1; i>-1; i--){
            if(UserList.get(i).getUsername().equals(name)){ UserList.remove(i); break;}
            else if(i==0){throw new UserNotFound();}
        }


    }


    // 4) Обновляет пароль пользователя по имени
    /*
    curl -X PUT http://localhost:8080/userList -H 'Content-Type: application/json' -d '{"username":"Kirill", "newPassword":"123", "repeatPassword":"qwe123"}'
    curl -X PUT http://localhost:8080/userList -H 'Content-Type: application/json' -d '{"username":"updateKirill", "newPassword":"123", "repeatPassword":"qwe123"}'
     */
    @PutMapping("userList")
    public void updateUserAge(@RequestBody LoginUser newUser)
            throws ErrorNotAdmin, ErrorUsernameOrPassword, UserNotFound
    {
        for (int i = UserList.size()-1; i>-1; i--){
            if(UserList.get(i).getUsername().equals(newUser.getUsername())){

                //403
                if(newUser.getUsername().length()<6){ throw new ErrorNotAdmin();}
                else if(!newUser.getUsername().startsWith("update")){throw new ErrorNotAdmin();}

                //400
                char[] xArr = newUser.getUsername().toCharArray();
                for (char x:xArr){
                    //int a = (int) x;
                    if(x>122||x<48){throw new ErrorUsernameOrPassword();}
                    if (57<x&&x<65){throw new ErrorUsernameOrPassword();}
                    if (90<x&&x<97){throw new ErrorUsernameOrPassword();}
                }

                UserList.get(i).setPassword(newUser.getNewPassword());break;
            }
            else if(i==0){throw new UserNotFound();}
            //404 ^
        }



    }

// d) Выводит список пользователей
// curl -X GET http://localhost:8080/userList/all -H 'Content-Type: application/json'
    @GetMapping("userList/all")
    public List<UserPW> getMessages() {
        return UserList;
    }





}

// b) Удаляет пользователя по индексу
    /* curl -X DELETE http://localhost:8080/userList/0 -H 'Content-Type: application/json'
    @DeleteMapping("userList/{index}")
    public void deleteUser(@PathVariable("index") Integer index) {
        UserList.remove((int) index);
    }
    // e) Обновляет возраст пользователя по индексу
     curl -X PUT http://localhost:8080/userList/0 -H 'Content-Type: application/json' -d '10'
@PutMapping("userList/{index}")
public void updateUserAge(
        @PathVariable("index") Integer index,
        @RequestBody Integer age) {
    UserList.get( index).setAge(age);
}
// d) Выводит список пользователей
     curl -X GET http://localhost:8080/userList -H 'Content-Type: application/json'
@GetMapping("userList")
public List<UserPW> getMessages() {
    return UserList;
}
    */
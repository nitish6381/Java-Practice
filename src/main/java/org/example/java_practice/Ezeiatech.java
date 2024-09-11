//package org.example.java_practice;
//
////@Service
//public class Ezeiatech {
////    public static void main(String[] args) {
////
////    }
//
//
////    @postconstruct
////    public void method1(){
////        System.out.println("bean has been created");
////    }
//}
//
//@Entity
//@Table(name="users")
//public class User{
//    @Id
//    @column(name="email_id")
//    private emailId;
//
//    @column("password")
//    public password;
//
//}
//
//interface UserRepository extends JpaRepository<User, emailId>{
//
//}
//
//public class UserSignInDTO{
//    public emailId;
//    public password;
//}
//
//public class ResponseDTO<T>{
//    boolean status;
//    String message;
//    T data;
//}
//
//@Service
//public class UserService{
//    @Autowired
//    private UserRepository userRepository;
//    public ResponsEntity<ResponseDTO> userSignIn(UserSignInDTO userSignInDTO){
//        User user = userRepository.findById(userSignInDTO.emailId);
//        if(user == null){
//        }
//    }
//}
//
//@RestController
//@RequestMapping("/api/v1/user")
//public class UserController{
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/signin")
//    public ResponsEntity<ResponseDTO> userSignIn(@RepuestBody UserSignInDTO userSignInDTO){
//        return userService.userSignIn(userSignInDTO);
//    }
//}
//
//What is equals and hashcode contract in java
//
//Design an in-memory cache in your springboot application
//Cache will get initialized on application startup
//It will store data in key-value pairs
//Dev Chaturvedi
//5:39 PM
//@postconstruct
//Dev Chaturvedi
//5:42 PM
//How will you initialize certain beans at runtime on the basis of some conditions or logic in springboot application
//Dev Chaturvedi
//5:44 PM
//What is concurrent modification exception
//Create a post api to sign in a user into your system
//Dev Chaturvedi
//5:52 PM
//What is equals and hashcode contract in java

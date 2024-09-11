package org.example.java_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Interview {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(112);
//        list.add(115);
        list.add(168);
        list.add(172);
        list.add(156);
        list.add(123);
        list.add(123);
        list.add(90);
        list.add(137);
        list.add(198);
        int max = list.stream().max(Integer::compareTo).get();
        List<Integer> result = new ArrayList<>();
        Collections.sort(list);
        if(list.size() % 2==0){
            int mid = list.size()/2;
            for(int i=0;i<mid-1;i++){
                result.add(list.get(i));
            }
            result.add(list.get(list.size()-2));
            result.add(max);

            int j = list.size() - 3;
            for(int i=mid+1;i<list.size();i++){
                result.add(list.get(j));
                j--;
            }
            for(int i=0;i<result.size();i++) {
                System.out.println(result.get(i));
            }
        } else {
            int mid = list.size()/2;
            for(int i=0;i<mid;i++){
                result.add(list.get(i));
            }
           result.add(max);
            int j = list.size() - 2;
            for(int i=mid+1;i<list.size();i++){
                result.add(list.get(j));
                j--;
            }
            for(int i=0;i<result.size();i++) {
                System.out.println(result.get(i));
            }
        }




    }
//    112, 115, 168, 172, 156, 148, 123
//    112, 115,148, 172, 168, 156, 123
//    112,, 168, 172, 156, 148, 123
//            112, 156, 168,172, 148, 123
}

//Student CRUD

//1. to setup the basic application for service
// 2 . we will create one controller for student
// getall, create, update, getbyid, delete

//@RestController
//@RequestMapping("/client/student")
//class STUdentController{
//    @PostMapping
//    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO studentDTO){
//        Student student = new Student();
//        return ResponseEntity.ok();
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id){
//        return ResponseEntity.ok();
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody StudentDTO studentDTO){
//        return ResponseEntity.ok();
//    }
//    @GetMapping
//    public ResponseEntity<List<Student>> getAllStudents(){
//        return ResponseEntity.ok();
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
//        return ResponseEntity.ok();
//    }

//    service class
//to maintain tye business login
//class StudentService{
//    @Autowired
//    private StudentRepository studentRepository;
//
//    public Student createStudent(StudentDTO studentDTO){
//        Student student = new Student();
//        student.setFirstName(studentDTO.getFirstName());
//        student.setLastName(studentDTO.getLastName());
//        return studentRepository.save(student);
//    }
//
//    public void deleteStudent(Long id){
//        studentRepository.deleteById(id);
//    }
//
//    public Student updateStudent(Long id, StudentDTO studentDTO){
//        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
//        student.setFirstName(studentDTO.getFirstName());
//        student.setLastName(studentDTO.getLastName());
//        return studentRepository.save(student);
//    }
//
//    public List<Student> getAllStudents(){
//        return studentRepository.findAll();
//    }
//
//    public Student getStudentById(Long id){
//        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
//    }
//}

//entity class - replica of table
//@Entity
//repository class

//interface StudentRepository extends JpaRepository<Student, Long>{

//}

////    localhost:8080/client/student/
//
//}
//
//class StudentDTO{
//    string first_name;
//    string last_name;
//}
//
/*@Entity
@Table(name="students")
class Student{
    @Column(name="firstNmae")
    String first_name;

    @Column(name="lastNmae")
    String last_name;
}*/



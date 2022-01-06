//package com.nighthawk.intellijs;
//import com.nighthawk.intellijs.SQL.*;
//import org.json.simple.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.validation.Valid;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class SQLController {
//    @Controller
//    public class PersonSqlMvcController implements WebMvcConfigurer {
//
//        // Autowired enables Control to connect HTML and POJO Object to Database easily for CRUD
//        @Autowired
//        private CollegeSQL repository;
//
//        @GetMapping("college_list")
//        public String college(Model model) {
//            List<College> list = repository.listAll();
//            model.addAttribute("list", list);
//            return "college_list";
//        }
//
//        /*  The HTML template Forms and PersonForm attributes are bound
//            @return - template for person form
//            @param - Person Class
//        */
//        @GetMapping("add_college")
//        public String addcollege(College college) {
//            return "add_college";
//        }
//
//        /* Gathers the attributes filled out in the form, tests for and retrieves validation error
//        @param - Person object with @Valid
//        @param - BindingResult object
//         */
//        @PostMapping("add_college")
//        public String savecollege(@Valid College college, BindingResult bindingResult) {
//            // Validation of Decorated PersonForm attributes
//            if (bindingResult.hasErrors()) {
//                return "add_college";
//            }
//            repository.save(college);
//            // Redirect to next step
//            return "redirect:college_list";
//        }
//
//        @GetMapping("update_college/{id}")
//        public String updatecollege(@PathVariable("id") int id, Model model) {
//            model.addAttribute("person", repository.get(id));
//            return "update_college";
//        }
//
//        @PostMapping("update_college")
//        public String saveupdatecollege(@Valid College college, BindingResult bindingResult) {
//            // Validation of Decorated PersonForm attributes
//            if (bindingResult.hasErrors()) {
//                return "update_college";
//            }
//            repository.save(college);
//            // Redirect to next step
//            return "redirect:college_List";
//        }
//
//        @GetMapping("collegedelete/{id}")
//        public String collegedelete(@PathVariable("id") long id) {
//            repository.delete(id);
//            return "redirect:college_list";
//        }
//
//    /*
//    #### RESTful API section ####
//    Resource: https://spring.io/guides/gs/rest-service/
//    */
//
//        /*
//        GET List of People
//         */
//        @RequestMapping(value = "/api/people/get")
//        public ResponseEntity<List<College>> getcolleges() {
//            return new ResponseEntity<>( repository.listAll(), HttpStatus.OK);
//        }
//
//        /*
//        GET individual Person using ID
//         */
//        @RequestMapping(value = "/api/person/get/{id}")
//        public ResponseEntity<College> getcollege(@PathVariable long id) {
//            return new ResponseEntity<>( repository.get(id), HttpStatus.OK);
//        }
//
//        /*
//        DELETE individual Person using ID
//         */
//        @RequestMapping(value = "/api/person/delete/{id}", method = RequestMethod.DELETE)
//        public ResponseEntity<Object> deletecollege(@PathVariable long id) {
//            repository.delete(id);
//            return new ResponseEntity<>( ""+ id +" deleted", HttpStatus.OK);
//        }
//
//
//        /*
//        POST Aa record by Requesting Parameters from URI
//         */
//        @RequestMapping(value = "/api/person/post", method = RequestMethod.POST)
//        public ResponseEntity<Object> postcollege(@RequestParam("name") String name,
//                                                 @RequestParam("deadline") String deadline) {
//            Date date;
//            try {
//                date = new SimpleDateFormat("MM-dd-yyyy").parse(deadline);
//            } catch (Exception e) {
//                return new ResponseEntity<>(deadline +" error; try MM-dd-yyyy", HttpStatus.BAD_REQUEST);
//            }
//            // A college object WITHOUT ID will create a new record
//            College college = new College(name, date);
//            repository.save(college);
//            return new ResponseEntity<>(name +" was added successfully", HttpStatus.CREATED);
//        }
//
//        @GetMapping("college_search")
//        public String college() {
//            return "college_search";
//        }
//
//        /*
//        The personSearch API looks across database for partial match to term (k,v) passed by RequestEntity body
//         */
//        @RequestMapping(value = "/api/person_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//        public ResponseEntity<Object> collegesearch(RequestEntity<Object> request) {
//
//            // extract term from RequestEntity
//            JSONObject json = new JSONObject((Map) Objects.requireNonNull(request.getBody()));
//            String term = (String) json.get("term");
//
//            // custom JPA query to filter on term
//            List<College> list = repository.listLikeNative(term);
//
//            // return resulting list and status, error checking should be added
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        }
//
//    }
//}

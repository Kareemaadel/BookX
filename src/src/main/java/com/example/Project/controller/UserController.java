    package com.example.Project.controller;


    import com.example.Project.model.entity.Book;
    import com.example.Project.model.entity.Exchange;
    import com.example.Project.model.entity.Report;
    import com.example.Project.model.entity.User;
    import com.example.Project.service.UserService;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @Controller
    @RequestMapping("/user")
    public class UserController {

        @Autowired
        private UserService userService;
        private Integer currid;
        private  List<Book> testbooks;
        private  List<Book> searchbooks;
        private  Exchange  exchange;



        @GetMapping
        public String user(Model model) {
            User user = new User();
            model.addAttribute("User", user);
            return "register";
        }
        @GetMapping("/login")
        public String login(Model model) {
            User user = new User();
            model.addAttribute("User", user);
            return "login";
        }
        @GetMapping("/performLogin")
        public String performLogin(@RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   Model model) {
            User user = userService.findByEmailAndPassword(email, password);
            if (user != null) {
                return "redirect:/user/welcome/" + user.getId();
            } else {
                model.addAttribute("error", "Invalid email or password");
                return "login"; // Return to the login page with an error message
            }
        }

        @PostMapping
        public String performRegister(@ModelAttribute("User") User user) {
           User savedUser =userService.SaveUser(user);
            return "redirect:/user/welcome/" + savedUser.getId();
        }
        @GetMapping("/welcome/{id}")
        public String welcome(@PathVariable("id") Integer id, Model model) {
            User user = userService.getUserById(id);
            currid=id;
            Book book=new Book();
            Report report=new Report();
           testbooks=userService.getBooksByUserId(currid);

            model.addAttribute("user", user);
            model.addAttribute("Book",book);
            model.addAttribute("Report",report);
            model.addAttribute("searchres",searchbooks);

            model.addAttribute("userBooks", testbooks); // Add books to the model

            return "welcome";
        }



        @GetMapping("/showBooks")
        public String showBooks( Model model) {
            List<Book> userBooks = userService.getBooksByUserId(currid);
            model.addAttribute("userBooks", userBooks);
            return "showBooks"; // Name of your Thymeleaf template
        }

        @PostMapping("/addbook")
        public String addbook(@ModelAttribute("Book") Book book, Model model) {
            book.setUserid(currid);
            userService.addbook(book);
            return  "redirect:/user/welcome/" + currid;
        }
        @GetMapping("/searchBooks")
        public String searchBooks(@RequestParam("query") String query, Model model) {
            searchbooks = userService.findBooksByTitle(query);
            model.addAttribute("searchres", searchbooks);
            model.addAttribute("user", userService.getUserById(currid)); // Ensure user data is included
            return "redirect:/user/welcome/" + currid;
        }
        @PostMapping("/addreport")
        public String addreport(@ModelAttribute("Report") Report report, Model model) {
            userService.addreport(report);
            return  "addedreport";
        }
        /*@PostMapping("/exchange")
        public String performExchange(@ModelAttribute("Exchange") Exchange exchange, Model model) {
           Book book1= userService.getaBooksbyIsd(exchange.getUser1Id(),exchange.getBook1Id());
           book1.setCondition("Exchnaged");
            Book book2= userService.getaBooksbyIsd(exchange.getUser2Id(),exchange.getBook2Id());
            book2.setCondition("Exchnaged");
            model.addAttribute("Exchange", exchange);
            return "redirect:/user/welcome/" + exchange.getUser1Id(); // Adjust as needed
        }*/

    }

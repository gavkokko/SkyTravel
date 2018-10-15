package com.code.ergasia.controller;

import com.code.ergasia.model.Flights;
import com.code.ergasia.model.User;
import com.code.ergasia.repository.FlightRepository;
import com.code.ergasia.service.FlightService;
import com.code.ergasia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "home";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/booking")
    public String booking(){
        return "booking";
    }

    @RequestMapping("/confirm")
    public String confirm(){
        return "confirm";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/page403")
    public String page403(){
        return "page403";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }


    @Autowired
    private FlightService flightService;
    @Autowired
    private  FlightRepository flightRepository;

    @RequestMapping(value = "/adminresults", method = RequestMethod.GET)
    public ModelAndView flightresults(){
        ModelAndView model = new ModelAndView("adminresults");
        List flightList = flightService.findAll();
        model.addObject("flightList",flightList);
        return model;
    }


    @RequestMapping(value = "/flightresults", method = RequestMethod.GET)
    public ModelAndView findByDest(@RequestParam(name = "dest", required = false) String dest){
        ModelAndView modelAndView= new ModelAndView("flightresults");
        List<Flights> flightList = flightRepository.findByTo(dest);
        modelAndView.addObject("flightList",flightList);
        return modelAndView;
    }
}

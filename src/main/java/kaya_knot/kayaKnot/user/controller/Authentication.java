package kaya_knot.kayaKnot.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import kaya_knot.kayaKnot.user.entity.Users;
import kaya_knot.kayaKnot.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class Authentication {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private HttpSession httpSession;
    @RequestMapping(value = "/userAccount", method = RequestMethod.GET)
    public String authenticate(Model model, HttpServletRequest request) {
        System.out.println("========================");
        Users users;
        LoggedUserSession loggedUserSession=null;
        try {
            String email = request.getRemoteUser();
            users = userRepo.findUserByEmail(email);
            LoggedUserSession loggedUser= new LoggedUserSession();
            loggedUser.setUsers(users);
//            loggedUser.setId(111);
            System.out.println("userTable"+ users);
            System.out.println("loggedUser"+loggedUser);
            httpSession.setAttribute("loggedUser", loggedUser);
            return "redirect:application_list";

        } catch (Exception e) {
            // e.printStackTrace();
        }
        model.addAttribute("accountInfo", "Your Account does not exist. Please contact system admin");
        return "redirect:/login?error=true";
    }
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (CrsSessionUtil.isUserLoggedIn(httpSession)) {
//            LoggedUserSession loggedUser = (LoggedUserSession) httpSession.getAttribute("loggedUser");
//
//            UserVO userVO = userSessionVO.getUserVO();
//            UserTable userTable= loggedUser.getId();
//            // UserVO userVO =
//            // userService.findByEmail(userSessionVO.getUserVO().getEmail());
//            // userVO.setLastlogout(new Timestamp(new Date().getTime()));
//            // userService.createUser(userVO);
//            userService.userLastLogout(userVO.getId());
//        }
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login?logout";
//    }
//}
}

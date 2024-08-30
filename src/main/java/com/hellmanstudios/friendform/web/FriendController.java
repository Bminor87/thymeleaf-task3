package com.hellmanstudios.friendform.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hellmanstudios.friendform.domain.Friend;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;






@Controller
public class FriendController {

    public List<Friend> friends;

    public FriendController() {
        this.friends = new ArrayList<Friend>();
    }

    @GetMapping("")
    public String mainPage() {
        return "redirect:/list";
    }
    

    @GetMapping("add")
    public String addFriendForm(Model model) {
        model.addAttribute("friend", new Friend("", ""));
        return "add";
    }

    @GetMapping("addfriend")
    public String altRouteAddFriendForm() {
        return "redirect:/add";
    }
    

    @PostMapping("add")
    public String addFriend(@ModelAttribute Friend friend, RedirectAttributes redirectAttributes, Model model) {

        if (friend.getFirstName().isEmpty()) {
            model.addAttribute("error", "Your friend must have a first name!");
            model.addAttribute("friend", friend);
            return "add";
        } else {
            this.friends.add(new Friend(friend.getFirstName(), friend.getLastName()));
            redirectAttributes.addFlashAttribute("message", friend + " added to friends");
        }

        return "redirect:/list";
    }

    @GetMapping("list")
    public String listFriends(Model model) {
        model.addAttribute("friends", friends);
        return "list";
    }

    @GetMapping("friends")
    public String altRouteFriendsList() {
        return "redirect:/list";
    }
    

}
